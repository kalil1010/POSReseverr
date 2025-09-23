package com.github.devnied.emvnfccard.parser.apdu.annotation;

import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.iso7816emv.ITag;
import fr.devnied.bitlib.BytesUtils;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class AnnotationData implements Comparable<AnnotationData>, Cloneable {
    private int dateStandard;
    private Field field;
    private String format;
    private int index;
    private boolean readHexa;
    private int size;
    private boolean skip;
    private ITag tag;

    @Override // java.lang.Comparable
    public int compareTo(AnnotationData pO) {
        return Integer.valueOf(this.index).compareTo(Integer.valueOf(pO.getIndex()));
    }

    public boolean equals(Object pObj) {
        if (!(pObj instanceof AnnotationData)) {
            return false;
        }
        boolean ret = this.index == ((AnnotationData) pObj).getIndex();
        return ret;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isReadHexa() {
        return this.readHexa;
    }

    public Field getField() {
        return this.field;
    }

    public int getDateStandard() {
        return this.dateStandard;
    }

    public String getFormat() {
        return this.format;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public ITag getTag() {
        return this.tag;
    }

    public void initFromAnnotation(Data pData) {
        this.dateStandard = pData.dateStandard();
        this.format = pData.format();
        this.index = pData.index();
        this.readHexa = pData.readHexa();
        this.size = pData.size();
        if (pData.tag() != null) {
            this.tag = EmvTags.find(BytesUtils.fromString(pData.tag()));
        }
    }

    protected Object clone() throws CloneNotSupportedException {
        AnnotationData data = new AnnotationData();
        data.dateStandard = this.dateStandard;
        data.field = this.field;
        data.format = new String(this.format);
        data.index = this.index;
        data.readHexa = this.readHexa;
        data.size = this.size;
        data.tag = this.tag;
        return data;
    }

    public boolean isSkip() {
        return this.skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
