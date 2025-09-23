package net.p003sf.scuba.smartcards;

import java.io.Serializable;
import java.util.EventObject;

/* loaded from: classes.dex */
public class APDUEvent extends EventObject {
    private static final long serialVersionUID = 7152351242541552732L;
    private CommandAPDU capdu;
    private ResponseAPDU rapdu;
    private int sequenceNumber;
    private Serializable type;

    public APDUEvent(Object source, Serializable type, int sequenceNumber, CommandAPDU capdu, ResponseAPDU rapdu) {
        super(source);
        this.type = type;
        this.sequenceNumber = sequenceNumber;
        this.capdu = capdu;
        this.rapdu = rapdu;
    }

    public Object getType() {
        return this.type;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public CommandAPDU getCommandAPDU() {
        return this.capdu;
    }

    public ResponseAPDU getResponseAPDU() {
        return this.rapdu;
    }
}
