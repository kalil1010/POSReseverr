package com.github.devnied.emvnfccard.parser.apdu.impl;

import com.github.devnied.emvnfccard.iso7816emv.ITag;
import com.github.devnied.emvnfccard.iso7816emv.TagAndLength;
import com.github.devnied.emvnfccard.model.AbstractData;
import com.github.devnied.emvnfccard.parser.apdu.IFile;
import com.github.devnied.emvnfccard.parser.apdu.annotation.AnnotationData;
import com.github.devnied.emvnfccard.parser.apdu.annotation.AnnotationUtils;
import fr.devnied.bitlib.BitUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public abstract class AbstractByteBean<T> extends AbstractData implements IFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractByteBean.class.getName());
    private static final long serialVersionUID = -2016039522844322383L;

    private Collection<AnnotationData> getAnnotationSet(Collection<TagAndLength> pTags) {
        if (pTags != null) {
            Map<ITag, AnnotationData> data = AnnotationUtils.getInstance().getMap().get(getClass().getName());
            Collection<AnnotationData> ret = new ArrayList<>(data.size());
            for (TagAndLength tal : pTags) {
                AnnotationData ann = data.get(tal.getTag());
                if (ann != null) {
                    ann.setSize(tal.getLength() * 8);
                } else {
                    ann = new AnnotationData();
                    ann.setSkip(true);
                    ann.setSize(tal.getLength() * 8);
                }
                ret.add(ann);
            }
            return ret;
        }
        return AnnotationUtils.getInstance().getMapSet().get(getClass().getName());
    }

    @Override // com.github.devnied.emvnfccard.parser.apdu.IFile
    public void parse(byte[] pData, Collection<TagAndLength> pTags) throws IllegalAccessException, IllegalArgumentException {
        Collection<AnnotationData> set = getAnnotationSet(pTags);
        BitUtils bit = new BitUtils(pData);
        for (AnnotationData data : set) {
            if (data.isSkip()) {
                bit.addCurrentBitIndex(data.getSize());
            } else {
                Object obj = DataFactory.getObject(data, bit);
                setField(data.getField(), this, obj);
            }
        }
    }

    protected void setField(Field field, IFile pData, Object pValue) throws IllegalAccessException, IllegalArgumentException {
        if (field != null) {
            try {
                field.set(pData, pValue);
            } catch (IllegalAccessException e) {
                LOGGER.error("Impossible to set the Field :" + field.getName(), (Throwable) e);
            } catch (IllegalArgumentException e2) {
                LOGGER.error("Parameters of fied.set are not valid", (Throwable) e2);
            }
        }
    }
}
