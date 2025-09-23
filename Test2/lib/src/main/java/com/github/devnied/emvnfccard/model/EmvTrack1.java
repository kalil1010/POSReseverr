package com.github.devnied.emvnfccard.model;

import java.util.Date;

/* loaded from: classes.dex */
public class EmvTrack1 extends AbstractData {
    private static final long serialVersionUID = 6619730513813482135L;
    private String cardNumber;
    private Date expireDate;
    private String formatCode;
    private String holderFirstname;
    private String holderLastname;
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

    public String getFormatCode() {
        return this.formatCode;
    }

    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
    }

    public String getHolderLastname() {
        return this.holderLastname;
    }

    public void setHolderLastname(String holderLastname) {
        this.holderLastname = holderLastname;
    }

    public String getHolderFirstname() {
        return this.holderFirstname;
    }

    public void setHolderFirstname(String holderFirstname) {
        this.holderFirstname = holderFirstname;
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
