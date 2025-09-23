package com.github.devnied.emvnfccard.model;

import java.util.Date;

/* loaded from: classes.dex */
public class EmvTrack2 extends AbstractData {
    private static final long serialVersionUID = -2906133619803198319L;
    private String cardNumber;
    private Date expireDate;
    private byte[] raw;
    private Service service;

    public byte[] getRaw() {
        return this.raw;
    }

    public void setRaw(byte[] raw) {
        this.raw = raw;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
