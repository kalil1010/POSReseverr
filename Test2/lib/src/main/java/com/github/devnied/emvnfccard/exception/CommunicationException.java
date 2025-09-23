package com.github.devnied.emvnfccard.exception;

import java.io.IOException;

/* loaded from: classes.dex */
public class CommunicationException extends IOException {
    private static final long serialVersionUID = -7916924250407562185L;

    public CommunicationException() {
    }

    public CommunicationException(String pMessage) {
        super(pMessage);
    }
}
