package com.github.devnied.emvnfccard.model.enums;

/* loaded from: classes.dex */
public enum CardStateEnum implements IKeyEnum {
    UNKNOWN,
    LOCKED,
    ACTIVE;

    @Override // com.github.devnied.emvnfccard.model.enums.IKeyEnum
    public int getKey() {
        return 0;
    }
}
