package com.github.devnied.emvnfccard.parser;

import com.github.devnied.emvnfccard.exception.CommunicationException;

/* loaded from: classes.dex */
public interface IProvider {
    byte[] getAt();

    byte[] transceive(byte[] bArr) throws CommunicationException;
}
