package com.github.devnied.emvnfccard.enums;

/* loaded from: classes.dex */
public enum CommandEnum {
    SELECT(0, 164, 4, 0),
    READ_RECORD(0, 178, 0, 0),
    GPO(128, 168, 0, 0),
    GET_DATA(128, 202, 0, 0),
    GET_RESPONSE(0, 12, 0, 0);

    private final int cla;
    private final int ins;

    /* renamed from: p1 */
    private final int f61p1;

    /* renamed from: p2 */
    private final int f62p2;

    CommandEnum(int cla, int ins, int p1, int p2) {
        this.cla = cla;
        this.ins = ins;
        this.f61p1 = p1;
        this.f62p2 = p2;
    }

    public int getCla() {
        return this.cla;
    }

    public int getIns() {
        return this.ins;
    }

    public int getP1() {
        return this.f61p1;
    }

    public int getP2() {
        return this.f62p2;
    }
}
