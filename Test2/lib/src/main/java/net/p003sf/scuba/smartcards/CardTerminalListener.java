package net.p003sf.scuba.smartcards;

import java.util.EventListener;

/* loaded from: classes.dex */
public interface CardTerminalListener extends EventListener {
    void cardInserted(CardEvent cardEvent);

    void cardRemoved(CardEvent cardEvent);
}
