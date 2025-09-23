package net.p003sf.scuba.smartcards;

/* loaded from: classes.dex */
public class WrappingCardService extends CardService {
    private boolean enabled;
    private CardService service;
    private APDUWrapper wrapper;

    public WrappingCardService(CardService service, APDUWrapper wrapper) {
        this.service = service;
        this.wrapper = wrapper;
    }

    @Override // net.p003sf.scuba.smartcards.CardService
    public void open() throws CardServiceException {
        this.service.open();
    }

    @Override // net.p003sf.scuba.smartcards.CardService
    public boolean isOpen() {
        return this.service.isOpen();
    }

    @Override // net.p003sf.scuba.smartcards.CardService
    public ResponseAPDU transmit(CommandAPDU capdu) throws CardServiceException {
        if (isEnabled()) {
            ResponseAPDU rapdu = this.service.transmit(this.wrapper.wrap(capdu));
            return this.wrapper.unwrap(rapdu);
        }
        return this.service.transmit(capdu);
    }

    @Override // net.p003sf.scuba.smartcards.CardService
    public byte[] getATR() throws CardServiceException {
        return this.service.getATR();
    }

    @Override // net.p003sf.scuba.smartcards.CardService
    public void close() {
        this.service.close();
    }

    public void enable() {
        this.enabled = true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void disable() {
        this.enabled = false;
    }

    @Override // net.p003sf.scuba.smartcards.CardService
    public boolean isConnectionLost(Exception e) {
        return this.service.isConnectionLost(e);
    }
}
