package org.apache.commons.p006io.serialization;

import org.apache.commons.p006io.FilenameUtils;

/* loaded from: classes.dex */
final class WildcardClassNameMatcher implements ClassNameMatcher {
    private final String pattern;

    public WildcardClassNameMatcher(String pattern) {
        this.pattern = pattern;
    }

    @Override // org.apache.commons.p006io.serialization.ClassNameMatcher
    public boolean matches(String className) {
        return FilenameUtils.wildcardMatch(className, this.pattern);
    }
}
