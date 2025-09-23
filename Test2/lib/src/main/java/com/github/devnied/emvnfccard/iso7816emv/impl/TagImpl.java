package com.github.devnied.emvnfccard.iso7816emv.impl;

import com.github.devnied.emvnfccard.enums.TagTypeEnum;
import com.github.devnied.emvnfccard.enums.TagValueTypeEnum;
import com.github.devnied.emvnfccard.iso7816emv.ITag;
import fr.devnied.bitlib.BytesUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class TagImpl implements ITag {
    private final String description;
    private final byte[] idBytes;
    public final String name;
    private final ITag.Class tagClass;
    private final TagValueTypeEnum tagValueType;
    private final TagTypeEnum type;

    public TagImpl(String id, TagValueTypeEnum tagValueType, String name, String description) {
        this(BytesUtils.fromString(id), tagValueType, name, description);
    }

    public TagImpl(byte[] idBytes, TagValueTypeEnum tagValueType, String name, String description) {
        if (idBytes == null) {
            throw new IllegalArgumentException("Param id cannot be null");
        }
        if (idBytes.length == 0) {
            throw new IllegalArgumentException("Param id cannot be empty");
        }
        if (tagValueType == null) {
            throw new IllegalArgumentException("Param tagValueType cannot be null");
        }
        this.idBytes = idBytes;
        this.name = name;
        this.description = description;
        this.tagValueType = tagValueType;
        if (BytesUtils.matchBitByBitIndex(idBytes[0], 5)) {
            this.type = TagTypeEnum.CONSTRUCTED;
        } else {
            this.type = TagTypeEnum.PRIMITIVE;
        }
        byte classValue = (byte) ((this.idBytes[0] >>> 6) & 3);
        if (classValue == 1) {
            this.tagClass = ITag.Class.APPLICATION;
            return;
        }
        if (classValue == 2) {
            this.tagClass = ITag.Class.CONTEXT_SPECIFIC;
        } else if (classValue == 3) {
            this.tagClass = ITag.Class.PRIVATE;
        } else {
            this.tagClass = ITag.Class.UNIVERSAL;
        }
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public boolean isConstructed() {
        return this.type == TagTypeEnum.CONSTRUCTED;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public byte[] getTagBytes() {
        return this.idBytes;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public String getName() {
        return this.name;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public String getDescription() {
        return this.description;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public TagValueTypeEnum getTagValueType() {
        return this.tagValueType;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public TagTypeEnum getType() {
        return this.type;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public ITag.Class getTagClass() {
        return this.tagClass;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ITag)) {
            return false;
        }
        ITag that = (ITag) other;
        if (getTagBytes().length != that.getTagBytes().length) {
            return false;
        }
        return Arrays.equals(getTagBytes(), that.getTagBytes());
    }

    public int hashCode() {
        int hash = (3 * 59) + Arrays.hashCode(this.idBytes);
        return hash;
    }

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITag
    public int getNumTagBytes() {
        return this.idBytes.length;
    }

    public String toString() {
        return "Tag[" + BytesUtils.bytesToString(getTagBytes()) + "] Name=" + getName() + ", TagType=" + getType() + ", ValueType=" + getTagValueType() + ", Class=" + this.tagClass;
    }
}
