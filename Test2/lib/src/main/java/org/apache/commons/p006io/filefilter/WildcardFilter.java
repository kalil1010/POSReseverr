package org.apache.commons.p006io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p006io.FilenameUtils;

@Deprecated
/* loaded from: classes.dex */
public class WildcardFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -5037645902506953517L;
    private final String[] wildcards;

    public WildcardFilter(String wildcard) {
        if (wildcard == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{wildcard};
    }

    public WildcardFilter(String[] wildcards) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        String[] strArr = new String[wildcards.length];
        this.wildcards = strArr;
        System.arraycopy(wildcards, 0, strArr, 0, wildcards.length);
    }

    public WildcardFilter(List<String> wildcards) {
        if (wildcards == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[]) wildcards.toArray(new String[wildcards.size()]);
    }

    @Override // org.apache.commons.p006io.filefilter.AbstractFileFilter, org.apache.commons.p006io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File dir, String name) {
        if (dir != null && new File(dir, name).isDirectory()) {
            return false;
        }
        for (String wildcard : this.wildcards) {
            if (FilenameUtils.wildcardMatch(name, wildcard)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.p006io.filefilter.AbstractFileFilter, org.apache.commons.p006io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (String wildcard : this.wildcards) {
            if (FilenameUtils.wildcardMatch(file.getName(), wildcard)) {
                return true;
            }
        }
        return false;
    }
}
