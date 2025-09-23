package com.github.devnied.emvnfccard.model.enums;

/* loaded from: classes.dex */
public enum TransactionTypeEnum implements IKeyEnum {
    PURCHASE(0),
    CASH_ADVANCE(1),
    CASHBACK(9),
    REFUND(32),
    LOADED(254),
    UNLOADED(255);

    private final int value;

    TransactionTypeEnum(int value) {
        this.value = value;
    }

    @Override // com.github.devnied.emvnfccard.model.enums.IKeyEnum
    public int getKey() {
        return this.value;
    }
}
