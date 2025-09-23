package com.github.devnied.emvnfccard.model.enums;

import com.github.devnied.emvnfccard.model.Application;
import java.util.List;

/* loaded from: classes.dex */
public enum ApplicationStepEnum implements IKeyEnum {
    NOT_SELECTED(0),
    SELECTED(1),
    READ(2);

    private int key;

    ApplicationStepEnum(int pKey) {
        this.key = pKey;
    }

    @Override // com.github.devnied.emvnfccard.model.enums.IKeyEnum
    public int getKey() {
        return this.key;
    }

    public static boolean isAtLeast(List<Application> pApplications, ApplicationStepEnum pStep) {
        boolean ret = false;
        if (pApplications != null && pStep != null) {
            for (Application app : pApplications) {
                if (app != null && app.getReadingStep() != null && app.getReadingStep().key >= pStep.getKey()) {
                    ret = true;
                }
            }
        }
        return ret;
    }
}
