package com.github.devnied.emvnfccard.model;

import com.github.devnied.emvnfccard.enums.EmvCardScheme;
import com.github.devnied.emvnfccard.model.enums.CardStateEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class EmvCard extends AbstractData {
    private static final long serialVersionUID = 736740432469989941L;

    /* renamed from: at */
    private String f65at;
    private Collection<String> atrDescription;
    private String bic;
    private CPLC cplc;
    private String holderFirstname;
    private String holderLastname;
    private String iban;
    private EmvTrack1 track1;
    private EmvTrack2 track2;
    private EmvCardScheme type;
    private final List<Application> applications = new ArrayList();
    private CardStateEnum state = CardStateEnum.UNKNOWN;

    public String getHolderLastname() {
        EmvTrack1 emvTrack1;
        String ret = this.holderLastname;
        if (ret == null && (emvTrack1 = this.track1) != null) {
            return emvTrack1.getHolderLastname();
        }
        return ret;
    }

    public void setHolderLastname(String holderLastname) {
        this.holderLastname = holderLastname;
    }

    public String getHolderFirstname() {
        EmvTrack1 emvTrack1;
        String ret = this.holderFirstname;
        if (ret == null && (emvTrack1 = this.track1) != null) {
            return emvTrack1.getHolderFirstname();
        }
        return ret;
    }

    public void setHolderFirstname(String holderFirstname) {
        this.holderFirstname = holderFirstname;
    }

    public String getCardNumber() {
        EmvTrack1 emvTrack1;
        String ret = null;
        EmvTrack2 emvTrack2 = this.track2;
        if (emvTrack2 != null) {
            ret = emvTrack2.getCardNumber();
        }
        if (ret == null && (emvTrack1 = this.track1) != null) {
            String ret2 = emvTrack1.getCardNumber();
            return ret2;
        }
        return ret;
    }

    public Date getExpireDate() {
        EmvTrack1 emvTrack1;
        Date ret = null;
        EmvTrack2 emvTrack2 = this.track2;
        if (emvTrack2 != null) {
            ret = emvTrack2.getExpireDate();
        }
        if (ret == null && (emvTrack1 = this.track1) != null) {
            Date ret2 = emvTrack1.getExpireDate();
            return ret2;
        }
        return ret;
    }

    public EmvCardScheme getType() {
        return this.type;
    }

    public void setType(EmvCardScheme type) {
        this.type = type;
    }

    public boolean equals(Object arg0) {
        return (arg0 instanceof EmvCard) && getCardNumber() != null && getCardNumber().equals(((EmvCard) arg0).getCardNumber());
    }

    public Collection<String> getAtrDescription() {
        return this.atrDescription;
    }

    public void setAtrDescription(Collection<String> atrDescription) {
        this.atrDescription = atrDescription;
    }

    public String getAt() {
        return this.f65at;
    }

    public void setAt(String at) {
        this.f65at = at;
    }

    public CardStateEnum getState() {
        return this.state;
    }

    public void setState(CardStateEnum state) {
        this.state = state;
    }

    public EmvTrack2 getTrack2() {
        return this.track2;
    }

    public void setTrack2(EmvTrack2 track2) {
        this.track2 = track2;
    }

    public EmvTrack1 getTrack1() {
        return this.track1;
    }

    public void setTrack1(EmvTrack1 track1) {
        this.track1 = track1;
    }

    public String getBic() {
        return this.bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public List<Application> getApplications() {
        return this.applications;
    }

    public CPLC getCplc() {
        return this.cplc;
    }

    public void setCplc(CPLC cplc) {
        this.cplc = cplc;
    }
}
