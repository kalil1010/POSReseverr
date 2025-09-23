package com.github.devnied.emvnfccard.parser.apdu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Data {
    int dateStandard() default 0;

    String format() default "yyyyMMdd";

    int index();

    boolean readHexa() default false;

    int size();

    String tag() default "";
}
