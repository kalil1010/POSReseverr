package com.github.devnied.emvnfccard.iso7816emv;

import fr.devnied.bitlib.BytesUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class TerminalTransactionQualifiers {
    private byte[] data = new byte[4];

    public boolean contactlessMagneticStripeSupported() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 7);
    }

    public boolean contactlessVSDCsupported() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 6);
    }

    public boolean contactlessEMVmodeSupported() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 5);
    }

    public boolean contactEMVsupported() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 4);
    }

    public boolean readerIsOfflineOnly() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 3);
    }

    public boolean onlinePINsupported() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 2);
    }

    public boolean signatureSupported() {
        return BytesUtils.matchBitByBitIndex(this.data[0], 1);
    }

    public boolean onlineCryptogramRequired() {
        return BytesUtils.matchBitByBitIndex(this.data[1], 7);
    }

    public boolean cvmRequired() {
        return BytesUtils.matchBitByBitIndex(this.data[1], 6);
    }

    public boolean contactChipOfflinePINsupported() {
        return BytesUtils.matchBitByBitIndex(this.data[1], 5);
    }

    public boolean issuerUpdateProcessingSupported() {
        return BytesUtils.matchBitByBitIndex(this.data[2], 7);
    }

    public boolean consumerDeviceCVMsupported() {
        return BytesUtils.matchBitByBitIndex(this.data[2], 6);
    }

    public void setMagneticStripeSupported(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 7, value);
    }

    public void setContactlessVSDCsupported(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 6, value);
        if (value) {
            setContactlessEMVmodeSupported(false);
        }
    }

    public void setContactlessEMVmodeSupported(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 5, value);
    }

    public void setContactEMVsupported(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 4, value);
    }

    public void setReaderIsOfflineOnly(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 3, value);
    }

    public void setOnlinePINsupported(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 2, value);
    }

    public void setSignatureSupported(boolean value) {
        byte[] bArr = this.data;
        bArr[0] = BytesUtils.setBit(bArr[0], 1, value);
    }

    public void setOnlineCryptogramRequired(boolean value) {
        byte[] bArr = this.data;
        bArr[1] = BytesUtils.setBit(bArr[1], 7, value);
    }

    public void setCvmRequired(boolean value) {
        byte[] bArr = this.data;
        bArr[1] = BytesUtils.setBit(bArr[1], 6, value);
    }

    public void setContactChipOfflinePINsupported(boolean value) {
        byte[] bArr = this.data;
        bArr[1] = BytesUtils.setBit(bArr[1], 5, value);
    }

    public void setIssuerUpdateProcessingSupported(boolean value) {
        byte[] bArr = this.data;
        bArr[2] = BytesUtils.setBit(bArr[2], 7, value);
    }

    public void setConsumerDeviceCVMsupported(boolean value) {
        byte[] bArr = this.data;
        bArr[2] = BytesUtils.setBit(bArr[2], 6, value);
    }

    public byte[] getBytes() {
        byte[] bArr = this.data;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
