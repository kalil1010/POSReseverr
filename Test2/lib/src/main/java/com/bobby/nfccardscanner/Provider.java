package com.bobby.nfccardscanner;

import android.nfc.tech.IsoDep;
import com.github.devnied.emvnfccard.parser.IProvider;
import java.io.IOException;

/* loaded from: classes2.dex */
public class Provider implements IProvider {
    private IsoDep mTagCom;

    @Override // com.github.devnied.emvnfccard.parser.IProvider
    public byte[] transceive(byte[] pCommand) throws IOException {
        try {
            byte[] response = this.mTagCom.transceive(pCommand);
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.github.devnied.emvnfccard.parser.IProvider
    public byte[] getAt() {
        return this.mTagCom.getHistoricalBytes();
    }

    public void setmTagCom(IsoDep mTagCom) {
        this.mTagCom = mTagCom;
    }
}
