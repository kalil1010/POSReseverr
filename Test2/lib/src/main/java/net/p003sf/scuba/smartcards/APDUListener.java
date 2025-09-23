package net.p003sf.scuba.smartcards;

import java.util.EventListener;

/* loaded from: classes.dex */
public interface APDUListener extends EventListener {
    void exchangedAPDU(APDUEvent aPDUEvent);
}
