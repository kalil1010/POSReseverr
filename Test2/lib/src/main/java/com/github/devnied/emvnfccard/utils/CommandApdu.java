package com.github.devnied.emvnfccard.utils;

import com.github.devnied.emvnfccard.enums.CommandEnum;

/* loaded from: classes.dex */
public class CommandApdu {
    protected int mCla;
    protected byte[] mData;
    protected int mIns;
    protected int mLc;
    protected int mLe;
    protected boolean mLeUsed;
    protected int mP1;
    protected int mP2;

    public CommandApdu(CommandEnum pEnum, byte[] data, int le) {
        this.mCla = 0;
        this.mIns = 0;
        this.mP1 = 0;
        this.mP2 = 0;
        this.mLc = 0;
        this.mData = new byte[0];
        this.mLe = 0;
        this.mLeUsed = false;
        this.mCla = pEnum.getCla();
        this.mIns = pEnum.getIns();
        this.mP1 = pEnum.getP1();
        this.mP2 = pEnum.getP2();
        this.mLc = data != null ? data.length : 0;
        this.mData = data;
        this.mLe = le;
        this.mLeUsed = true;
    }

    public CommandApdu(CommandEnum pEnum, int p1, int p2, int le) {
        this.mCla = 0;
        this.mIns = 0;
        this.mP1 = 0;
        this.mP2 = 0;
        this.mLc = 0;
        this.mData = new byte[0];
        this.mLe = 0;
        this.mLeUsed = false;
        this.mCla = pEnum.getCla();
        this.mIns = pEnum.getIns();
        this.mP1 = p1;
        this.mP2 = p2;
        this.mLe = le;
        this.mLeUsed = true;
    }

    public CommandApdu(CommandEnum pEnum, int p1, int p2) {
        this.mCla = 0;
        this.mIns = 0;
        this.mP1 = 0;
        this.mP2 = 0;
        this.mLc = 0;
        this.mData = new byte[0];
        this.mLe = 0;
        this.mLeUsed = false;
        this.mCla = pEnum.getCla();
        this.mIns = pEnum.getIns();
        this.mP1 = p1;
        this.mP2 = p2;
        this.mLeUsed = false;
    }

    public CommandApdu(CommandEnum pEnum, int p1, int p2, byte[] data, int le) {
        this.mCla = 0;
        this.mIns = 0;
        this.mP1 = 0;
        this.mP2 = 0;
        this.mLc = 0;
        this.mData = new byte[0];
        this.mLe = 0;
        this.mLeUsed = false;
        this.mCla = pEnum.getCla();
        this.mIns = pEnum.getIns();
        this.mP1 = p1;
        this.mP2 = p2;
        this.mLc = data != null ? data.length : 0;
        this.mData = data;
        this.mLe = le;
        this.mLeUsed = true;
    }

    public byte[] toBytes() {
        int length = 4;
        byte[] bArr = this.mData;
        if (bArr != null && bArr.length != 0) {
            length = 4 + 1 + bArr.length;
        }
        if (this.mLeUsed) {
            length++;
        }
        byte[] apdu = new byte[length];
        apdu[0] = (byte) this.mCla;
        int index = 0 + 1;
        apdu[index] = (byte) this.mIns;
        int index2 = index + 1;
        apdu[index2] = (byte) this.mP1;
        int index3 = index2 + 1;
        apdu[index3] = (byte) this.mP2;
        int index4 = index3 + 1;
        byte[] bArr2 = this.mData;
        if (bArr2 != null && bArr2.length != 0) {
            apdu[index4] = (byte) this.mLc;
            int index5 = index4 + 1;
            System.arraycopy(bArr2, 0, apdu, index5, bArr2.length);
            index4 = index5 + this.mData.length;
        }
        if (this.mLeUsed) {
            apdu[index4] = (byte) (apdu[index4] + ((byte) this.mLe));
        }
        return apdu;
    }
}
