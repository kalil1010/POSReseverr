package org.apache.commons.p006io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p006io.IOCase;

/* loaded from: classes.dex */
public class NameFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 176844364689077340L;
    private final IOCase caseSensitivity;
    private final String[] names;

    public NameFileFilter(String name) {
        this(name, (IOCase) null);
    }

    public NameFileFilter(String name, IOCase caseSensitivity) {
        if (name == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.names = new String[]{name};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    public NameFileFilter(String[] names) {
        this(names, (IOCase) null);
    }

    public NameFileFilter(String[] names, IOCase caseSensitivity) {
        if (names == null) {
            throw new IllegalArgumentException("The array of names must not be null");
        }
        String[] strArr = new String[names.length];
        this.names = strArr;
        System.arraycopy(names, 0, strArr, 0, names.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    public NameFileFilter(List<String> names) {
        this(names, (IOCase) null);
    }

    public NameFileFilter(List<String> names, IOCase caseSensitivity) {
        if (names == null) {
            throw new IllegalArgumentException("The list of names must not be null");
        }
        this.names = (String[]) names.toArray(new String[names.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    @Override // org.apache.commons.p006io.filefilter.AbstractFileFilter, org.apache.commons.p006io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        for (String name2 : this.names) {
            if (this.caseSensitivity.checkEquals(name, name2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.p006io.filefilter.AbstractFileFilter, org.apache.commons.p006io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File dir, String name) {
        for (String name2 : this.names) {
            if (this.caseSensitivity.checkEquals(name, name2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.p006io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (this.names != null) {
            for (int i = 0; i < this.names.length; i++) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(this.names[i]);
            }
        }
        buffer.append(")");
        return buffer.toString();
    }
}
