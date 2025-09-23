package net.p003sf.scuba.smartcards;

/* loaded from: classes.dex */
public interface APDUWrapper {
    String getType();

    ResponseAPDU unwrap(ResponseAPDU responseAPDU);

    CommandAPDU wrap(CommandAPDU commandAPDU);
}
