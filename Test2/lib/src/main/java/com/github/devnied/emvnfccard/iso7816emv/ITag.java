package com.github.devnied.emvnfccard.iso7816emv;

import com.github.devnied.emvnfccard.enums.TagTypeEnum;
import com.github.devnied.emvnfccard.enums.TagValueTypeEnum;

/* loaded from: classes.dex */
public interface ITag {

    public enum Class {
        UNIVERSAL,
        APPLICATION,
        CONTEXT_SPECIFIC,
        PRIVATE
    }

    String getDescription();

    String getName();

    int getNumTagBytes();

    byte[] getTagBytes();

    Class getTagClass();

    TagValueTypeEnum getTagValueType();

    TagTypeEnum getType();

    boolean isConstructed();
}
