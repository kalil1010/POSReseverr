package com.github.devnied.emvnfccard.parser;

import com.github.devnied.emvnfccard.enums.CommandEnum;
import com.github.devnied.emvnfccard.enums.EmvCardScheme;
import com.github.devnied.emvnfccard.exception.CommunicationException;
import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.iso7816emv.ITerminal;
import com.github.devnied.emvnfccard.iso7816emv.TLV;
import com.github.devnied.emvnfccard.iso7816emv.impl.DefaultTerminalImpl;
import com.github.devnied.emvnfccard.model.Application;
import com.github.devnied.emvnfccard.model.EmvCard;
import com.github.devnied.emvnfccard.model.enums.CardStateEnum;
import com.github.devnied.emvnfccard.parser.impl.EmvParser;
import com.github.devnied.emvnfccard.parser.impl.GeldKarteParser;
import com.github.devnied.emvnfccard.parser.impl.ProviderWrapper;
import com.github.devnied.emvnfccard.utils.AtrUtils;
import com.github.devnied.emvnfccard.utils.CPLCUtils;
import com.github.devnied.emvnfccard.utils.CommandApdu;
import com.github.devnied.emvnfccard.utils.ResponseUtils;
import com.github.devnied.emvnfccard.utils.TlvUtil;
import fr.devnied.bitlib.BytesUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public class EmvTemplate {
    public static final int MAX_RECORD_SFI = 16;
    private EmvCard card;
    private Config config;
    private List<IParser> parsers;
    private IProvider provider;
    private ITerminal terminal;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) EmvTemplate.class);
    private static final byte[] PPSE = "2PAY.SYS.DDF01".getBytes();
    private static final byte[] PSE = "1PAY.SYS.DDF01".getBytes();

    public static Builder Builder() {
        return new Builder();
    }

    public static Config Config() {
        return new Config();
    }

    public static class Config {
        public boolean removeDefaultParsers;
        public boolean contactLess = true;
        public boolean readTransactions = true;
        public boolean readAllAids = true;
        public boolean readAt = true;
        public boolean readCplc = false;

        Config() {
        }

        public Config setContactLess(boolean contactLess) {
            this.contactLess = contactLess;
            return this;
        }

        public Config setReadTransactions(boolean readTransactions) {
            this.readTransactions = readTransactions;
            return this;
        }

        public Config setReadAllAids(boolean readAllAids) {
            this.readAllAids = readAllAids;
            return this;
        }

        public Config setRemoveDefaultParsers(boolean removeDefaultParsers) {
            this.removeDefaultParsers = removeDefaultParsers;
            return this;
        }

        public Config setReadAt(boolean readAt) {
            this.readAt = readAt;
            return this;
        }

        public Config setReadCplc(boolean readCplc) {
            this.readCplc = readCplc;
            return this;
        }
    }

    public static class Builder {
        private Config config;
        private IProvider provider;
        private ITerminal terminal;

        Builder() {
        }

        public Builder setProvider(IProvider provider) {
            this.provider = provider;
            return this;
        }

        public Builder setTerminal(ITerminal terminal) {
            this.terminal = terminal;
            return this;
        }

        public Builder setConfig(Config config) {
            this.config = config;
            return this;
        }

        public EmvTemplate build() {
            if (this.provider == null) {
                throw new IllegalArgumentException("Provider may not be null.");
            }
            if (this.terminal == null) {
                this.terminal = new DefaultTerminalImpl();
            }
            return new EmvTemplate(this.provider, this.terminal, this.config);
        }
    }

    private EmvTemplate(IProvider pProvider, ITerminal pTerminal, Config pConfig) {
        this.provider = new ProviderWrapper(pProvider);
        this.terminal = pTerminal;
        this.config = pConfig;
        if (pConfig == null) {
            this.config = Config();
        }
        this.parsers = new ArrayList();
        if (!this.config.removeDefaultParsers) {
            addDefaultParsers();
        }
        this.card = new EmvCard();
    }

    private void addDefaultParsers() {
        this.parsers.add(new GeldKarteParser(this));
        this.parsers.add(new EmvParser(this));
    }

    public EmvTemplate addParsers(IParser... pParsers) {
        if (pParsers != null) {
            for (IParser parser : pParsers) {
                this.parsers.add(0, parser);
            }
        }
        return this;
    }

    public EmvCard readEmvCard() throws CommunicationException {
        if (this.config.readCplc) {
            readCPLCInfos();
        }
        if (this.config.readAt) {
            this.card.setAt(BytesUtils.bytesToStringNoSpace(this.provider.getAt()));
            this.card.setAtrDescription(this.config.contactLess ? AtrUtils.getDescriptionFromAts(this.card.getAt()) : AtrUtils.getDescription(this.card.getAt()));
        }
        if (!readWithPSE()) {
            readWithAID();
        }
        return this.card;
    }

    protected void readCPLCInfos() throws CommunicationException {
        this.card.setCplc(CPLCUtils.parse(this.provider.transceive(new CommandApdu(CommandEnum.GET_DATA, 159, 127, null, 0).toBytes())));
    }

    protected boolean readWithPSE() throws CommunicationException {
        boolean ret = false;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Try to read card with Payment System Environment");
        }
        byte[] data = selectPaymentEnvironment();
        if (ResponseUtils.isSucceed(data)) {
            this.card.getApplications().addAll(parseFCIProprietaryTemplate(data));
            Collections.sort(this.card.getApplications());
            for (Application app : this.card.getApplications()) {
                boolean status = false;
                String applicationAid = BytesUtils.bytesToStringNoSpace(app.getAid());
                Iterator<IParser> it = this.parsers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IParser impl = it.next();
                    if (impl.getId() != null && impl.getId().matcher(applicationAid).matches()) {
                        status = impl.parse(app);
                        break;
                    }
                }
                if (!ret && status) {
                    ret = status;
                    if (!this.config.readAllAids) {
                        break;
                    }
                }
            }
            if (!ret) {
                this.card.setState(CardStateEnum.LOCKED);
            }
        } else if (LOGGER.isDebugEnabled()) {
            Logger logger = LOGGER;
            StringBuilder sb = new StringBuilder();
            sb.append(this.config.contactLess ? "PPSE" : "PSE");
            sb.append(" not found -> Use kown AID");
            logger.debug(sb.toString());
        }
        return ret;
    }

    protected List<Application> parseFCIProprietaryTemplate(byte[] pData) throws IOException {
        List<Application> ret = new ArrayList<>();
        byte[] data = TlvUtil.getValue(pData, EmvTags.SFI);
        if (data != null) {
            int sfi = BytesUtils.byteArrayToInt(data);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("SFI found:" + sfi);
            }
            for (int rec = 0; rec < 16; rec++) {
                byte[] data2 = this.provider.transceive(new CommandApdu(CommandEnum.READ_RECORD, rec, (sfi << 3) | 4, 0).toBytes());
                if (!ResponseUtils.isSucceed(data2)) {
                    break;
                }
                ret.addAll(getApplicationTemplate(data2));
            }
        } else {
            ret.addAll(getApplicationTemplate(pData));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("(FCI) Issuer Discretionary Data is already present");
            }
        }
        return ret;
    }

    protected List<Application> getApplicationTemplate(byte[] pData) {
        List<Application> ret = new ArrayList<>();
        List<TLV> listTlv = TlvUtil.getlistTLV(pData, EmvTags.APPLICATION_TEMPLATE);
        for (TLV tlv : listTlv) {
            Application application = new Application();
            List<TLV> listTlvData = TlvUtil.getlistTLV(tlv.getValueBytes(), EmvTags.AID_CARD, EmvTags.APPLICATION_LABEL, EmvTags.APPLICATION_PRIORITY_INDICATOR);
            for (TLV data : listTlvData) {
                if (data.getTag() == EmvTags.APPLICATION_PRIORITY_INDICATOR) {
                    application.setPriority(BytesUtils.byteArrayToInt(data.getValueBytes()));
                } else if (data.getTag() == EmvTags.APPLICATION_LABEL) {
                    application.setApplicationLabel(new String(data.getValueBytes()));
                } else {
                    application.setAid(data.getValueBytes());
                    ret.add(application);
                }
            }
        }
        return ret;
    }

    protected void readWithAID() throws CommunicationException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Try to read card with AID");
        }
        Application app = new Application();
        for (EmvCardScheme type : EmvCardScheme.values()) {
            for (byte[] aid : type.getAidByte()) {
                app.setAid(aid);
                app.setApplicationLabel(type.getName());
                String applicationAid = BytesUtils.bytesToStringNoSpace(aid);
                for (IParser impl : this.parsers) {
                    if (impl.getId() != null && impl.getId().matcher(applicationAid).matches() && impl.parse(app)) {
                        this.card.getApplications().clear();
                        this.card.getApplications().add(app);
                        return;
                    }
                }
            }
        }
    }

    protected byte[] selectPaymentEnvironment() throws CommunicationException {
        if (LOGGER.isDebugEnabled()) {
            Logger logger = LOGGER;
            StringBuilder sb = new StringBuilder();
            sb.append("Select ");
            sb.append(this.config.contactLess ? "PPSE" : "PSE");
            sb.append(" Application");
            logger.debug(sb.toString());
        }
        return this.provider.transceive(new CommandApdu(CommandEnum.SELECT, this.config.contactLess ? PPSE : PSE, 0).toBytes());
    }

    public EmvCard getCard() {
        return this.card;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public Config getConfig() {
        return this.config;
    }

    public ITerminal getTerminal() {
        return this.terminal;
    }

    public List<IParser> getParsers() {
        return Collections.unmodifiableList(this.parsers);
    }
}
