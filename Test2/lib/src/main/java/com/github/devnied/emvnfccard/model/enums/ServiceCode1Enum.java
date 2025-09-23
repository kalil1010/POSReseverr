package com.github.devnied.emvnfccard.model.enums;

/* loaded from: classes.dex */
public enum ServiceCode1Enum implements IKeyEnum {
    INTERNATIONNAL(1, "International interchange", "None"),
    INTERNATIONNAL_ICC(2, "International interchange", "Integrated circuit card"),
    NATIONAL(5, "National interchange", "None"),
    NATIONAL_ICC(6, "National interchange", "Integrated circuit card"),
    PRIVATE(7, "Private", "None");

    private final String interchange;
    private final String technology;
    private final int value;

    ServiceCode1Enum(int value, String interchange, String technology) {
        this.value = value;
        this.interchange = interchange;
        this.technology = technology;
    }

    public String getInterchange() {
        return this.interchange;
    }

    public String getTechnology() {
        return this.technology;
    }

    @Override // com.github.devnied.emvnfccard.model.enums.IKeyEnum
    public int getKey() {
        return this.value;
    }
}
