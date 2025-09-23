package com.github.devnied.emvnfccard.parser.apdu.annotation;

import com.github.devnied.emvnfccard.iso7816emv.ITag;
import com.github.devnied.emvnfccard.model.CPLC;
import com.github.devnied.emvnfccard.model.EmvTransactionRecord;
import com.github.devnied.emvnfccard.parser.apdu.IFile;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class AnnotationUtils {
    private final Map<String, Map<ITag, AnnotationData>> map = new HashMap();
    private final Map<String, Set<AnnotationData>> mapSet = new HashMap();
    private static final Class<? extends IFile>[] LISTE_CLASS = {EmvTransactionRecord.class, CPLC.class};
    private static final AnnotationUtils INSTANCE = new AnnotationUtils();

    public static AnnotationUtils getInstance() {
        return INSTANCE;
    }

    private AnnotationUtils() {
        extractAnnotation();
    }

    private void extractAnnotation() {
        for (Class<? extends IFile> clazz : LISTE_CLASS) {
            Map<ITag, AnnotationData> maps = new HashMap<>();
            Set<AnnotationData> set = new TreeSet<>();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                AnnotationData param = new AnnotationData();
                field.setAccessible(true);
                param.setField(field);
                Data annotation = (Data) field.getAnnotation(Data.class);
                if (annotation != null) {
                    param.initFromAnnotation(annotation);
                    maps.put(param.getTag(), param);
                    try {
                        set.add((AnnotationData) param.clone());
                    } catch (CloneNotSupportedException e) {
                    }
                }
            }
            this.mapSet.put(clazz.getName(), set);
            this.map.put(clazz.getName(), maps);
        }
    }

    public Map<String, Set<AnnotationData>> getMapSet() {
        return this.mapSet;
    }

    public Map<String, Map<ITag, AnnotationData>> getMap() {
        return this.map;
    }
}
