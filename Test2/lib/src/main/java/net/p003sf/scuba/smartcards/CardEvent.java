package net.p003sf.scuba.smartcards;

import java.util.EventObject;

/* loaded from: classes.dex */
public class CardEvent extends EventObject {
    public static final int INSERTED = 1;
    public static final int REMOVED = 0;
    private static final long serialVersionUID = -5645277246646615351L;
    private transient CardService service;
    private int type;

    public CardEvent(int type, CardService service) {
        super(service);
        this.type = type;
        this.service = service;
    }

    public int getType() {
        return this.type;
    }

    public CardService getService() {
        return this.service;
    }

    @Override // java.util.EventObject
    public String toString() {
        int i = this.type;
        if (i == 0) {
            return "Card removed from " + this.service;
        }
        if (i == 1) {
            return "Card inserted in " + this.service;
        }
        throw new IllegalStateException("Unknown event type " + this.type);
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!other.getClass().equals(getClass())) {
            return false;
        }
        CardEvent otherCardEvent = (CardEvent) other;
        return this.type == otherCardEvent.type && this.service.equals(otherCardEvent.service);
    }

    public int hashCode() {
        return (this.service.hashCode() * 5) + (this.type * 7);
    }
}
