package com.github.devnied.emvnfccard.parser.impl;

import com.github.devnied.emvnfccard.enums.CommandEnum;
import com.github.devnied.emvnfccard.enums.SwEnum;
import com.github.devnied.emvnfccard.exception.CommunicationException;
import com.github.devnied.emvnfccard.parser.IProvider;
import com.github.devnied.emvnfccard.utils.CommandApdu;
import com.github.devnied.emvnfccard.utils.ResponseUtils;

/* loaded from: classes.dex */
public class ProviderWrapper implements IProvider {
    private IProvider provider;

    public ProviderWrapper(IProvider pProvider) {
        this.provider = pProvider;
    }

    @Override // com.github.devnied.emvnfccard.parser.IProvider
    public byte[] transceive(byte[] pCommand) throws CommunicationException {
        byte[] ret = this.provider.transceive(pCommand);
        if (ResponseUtils.isEquals(ret, SwEnum.SW_6C)) {
            pCommand[pCommand.length - 1] = ret[ret.length - 1];
            return this.provider.transceive(pCommand);
        }
        if (ResponseUtils.isEquals(ret, SwEnum.SW_61)) {
            return this.provider.transceive(new CommandApdu(CommandEnum.GET_RESPONSE, (byte[]) null, ret[ret.length - 1]).toBytes());
        }
        return ret;
    }

    @Override // com.github.devnied.emvnfccard.parser.IProvider
    public byte[] getAt() {
        return this.provider.getAt();
    }
}
