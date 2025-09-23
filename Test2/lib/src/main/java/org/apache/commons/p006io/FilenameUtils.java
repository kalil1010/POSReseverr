package org.apache.commons.p006io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import org.slf4j.Marker;

/* loaded from: classes.dex */
public class FilenameUtils {
    public static final char EXTENSION_SEPARATOR = '.';
    private static final int NOT_FOUND = -1;
    private static final char OTHER_SEPARATOR;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    private static boolean isSeparator(char ch) {
        return ch == '/' || ch == '\\';
    }

    public static String normalize(String filename) {
        return doNormalize(filename, SYSTEM_SEPARATOR, true);
    }

    public static String normalize(String filename, boolean unixSeparator) {
        char separator = unixSeparator ? '/' : '\\';
        return doNormalize(filename, separator, true);
    }

    public static String normalizeNoEndSeparator(String filename) {
        return doNormalize(filename, SYSTEM_SEPARATOR, false);
    }

    public static String normalizeNoEndSeparator(String filename, boolean unixSeparator) {
        char separator = unixSeparator ? '/' : '\\';
        return doNormalize(filename, separator, false);
    }

    private static String doNormalize(String filename, char separator, boolean keepSeparator) {
        if (filename == null) {
            return null;
        }
        failIfNullBytePresent(filename);
        int size = filename.length();
        if (size == 0) {
            return filename;
        }
        int prefix = getPrefixLength(filename);
        if (prefix < 0) {
            return null;
        }
        char[] array = new char[size + 2];
        filename.getChars(0, filename.length(), array, 0);
        char otherSeparator = SYSTEM_SEPARATOR;
        if (separator == otherSeparator) {
            otherSeparator = OTHER_SEPARATOR;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == otherSeparator) {
                array[i] = separator;
            }
        }
        int i2 = 1;
        if (array[size - 1] != separator) {
            array[size] = separator;
            i2 = 0;
            size++;
        }
        int i3 = prefix + 1;
        while (i3 < size) {
            if (array[i3] == separator && array[i3 - 1] == separator) {
                System.arraycopy(array, i3, array, i3 - 1, size - i3);
                size--;
                i3--;
            }
            i3++;
        }
        int i4 = prefix + 1;
        while (i4 < size) {
            if (array[i4] == separator && array[i4 - 1] == '.' && (i4 == prefix + 1 || array[i4 - 2] == separator)) {
                if (i4 == size - 1) {
                    i2 = 1;
                }
                System.arraycopy(array, i4 + 1, array, i4 - 1, size - i4);
                size -= 2;
                i4--;
            }
            i4++;
        }
        int i5 = prefix + 2;
        while (i5 < size) {
            if (array[i5] == separator && array[i5 - 1] == '.' && array[i5 - 2] == '.' && (i5 == prefix + 2 || array[i5 - 3] == separator)) {
                if (i5 == prefix + 2) {
                    return null;
                }
                if (i5 == size - 1) {
                    i2 = 1;
                }
                int j = i5 - 4;
                while (true) {
                    if (j >= prefix) {
                        if (array[j] == separator) {
                            System.arraycopy(array, i5 + 1, array, j + 1, size - i5);
                            size -= i5 - j;
                            i5 = j + 1;
                            break;
                        }
                        j--;
                    } else {
                        System.arraycopy(array, i5 + 1, array, prefix, size - i5);
                        size -= (i5 + 1) - prefix;
                        i5 = prefix + 1;
                        break;
                    }
                }
            }
            i5++;
        }
        if (size <= 0) {
            return "";
        }
        if (size <= prefix) {
            return new String(array, 0, size);
        }
        if (i2 != 0 && keepSeparator) {
            return new String(array, 0, size);
        }
        return new String(array, 0, size - 1);
    }

    public static String concat(String basePath, String fullFilenameToAdd) {
        int prefix = getPrefixLength(fullFilenameToAdd);
        if (prefix < 0) {
            return null;
        }
        if (prefix > 0) {
            return normalize(fullFilenameToAdd);
        }
        if (basePath == null) {
            return null;
        }
        int len = basePath.length();
        if (len == 0) {
            return normalize(fullFilenameToAdd);
        }
        char ch = basePath.charAt(len - 1);
        if (isSeparator(ch)) {
            return normalize(basePath + fullFilenameToAdd);
        }
        return normalize(basePath + '/' + fullFilenameToAdd);
    }

    public static boolean directoryContains(String canonicalParent, String canonicalChild) throws IOException {
        if (canonicalParent == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (canonicalChild == null || IOCase.SYSTEM.checkEquals(canonicalParent, canonicalChild)) {
            return false;
        }
        return IOCase.SYSTEM.checkStartsWith(canonicalChild, canonicalParent);
    }

    public static String separatorsToUnix(String path) {
        if (path == null || path.indexOf(92) == -1) {
            return path;
        }
        return path.replace('\\', '/');
    }

    public static String separatorsToWindows(String path) {
        if (path == null || path.indexOf(47) == -1) {
            return path;
        }
        return path.replace('/', '\\');
    }

    public static String separatorsToSystem(String path) {
        if (path == null) {
            return null;
        }
        if (isSystemWindows()) {
            return separatorsToWindows(path);
        }
        return separatorsToUnix(path);
    }

    public static int getPrefixLength(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == ':') {
            return -1;
        }
        if (length != 1) {
            if (cCharAt == '~') {
                int iIndexOf = str.indexOf(47, 1);
                int iIndexOf2 = str.indexOf(92, 1);
                if (iIndexOf == -1 && iIndexOf2 == -1) {
                    return length + 1;
                }
                int i = iIndexOf == -1 ? iIndexOf2 : iIndexOf;
                return Math.min(i, iIndexOf2 == -1 ? i : iIndexOf2) + 1;
            }
            char cCharAt2 = str.charAt(1);
            if (cCharAt2 == ':') {
                char upperCase = Character.toUpperCase(cCharAt);
                return (upperCase < 'A' || upperCase > 'Z') ? upperCase == '/' ? 1 : -1 : (length == 2 || !isSeparator(str.charAt(2))) ? 2 : 3;
            }
            if (!isSeparator(cCharAt) || !isSeparator(cCharAt2)) {
                return isSeparator(cCharAt) ? 1 : 0;
            }
            int iIndexOf3 = str.indexOf(47, 2);
            int iIndexOf4 = str.indexOf(92, 2);
            if ((iIndexOf3 == -1 && iIndexOf4 == -1) || iIndexOf3 == 2 || iIndexOf4 == 2) {
                return -1;
            }
            int i2 = iIndexOf3 == -1 ? iIndexOf4 : iIndexOf3;
            return Math.min(i2, iIndexOf4 == -1 ? i2 : iIndexOf4) + 1;
        }
        if (cCharAt == '~') {
            return 2;
        }
        return isSeparator(cCharAt) ? 1 : 0;
    }

    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        int lastUnixPos = filename.lastIndexOf(47);
        int lastWindowsPos = filename.lastIndexOf(92);
        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }
        int extensionPos = filename.lastIndexOf(46);
        int lastSeparator = indexOfLastSeparator(filename);
        if (lastSeparator > extensionPos) {
            return -1;
        }
        return extensionPos;
    }

    public static String getPrefix(String filename) {
        int len;
        if (filename == null || (len = getPrefixLength(filename)) < 0) {
            return null;
        }
        if (len > filename.length()) {
            failIfNullBytePresent(filename + '/');
            return filename + '/';
        }
        String path = filename.substring(0, len);
        failIfNullBytePresent(path);
        return path;
    }

    public static String getPath(String filename) {
        return doGetPath(filename, 1);
    }

    public static String getPathNoEndSeparator(String filename) {
        return doGetPath(filename, 0);
    }

    private static String doGetPath(String filename, int separatorAdd) {
        int prefix;
        if (filename == null || (prefix = getPrefixLength(filename)) < 0) {
            return null;
        }
        int index = indexOfLastSeparator(filename);
        int endIndex = index + separatorAdd;
        if (prefix >= filename.length() || index < 0 || prefix >= endIndex) {
            return "";
        }
        String path = filename.substring(prefix, endIndex);
        failIfNullBytePresent(path);
        return path;
    }

    public static String getFullPath(String filename) {
        return doGetFullPath(filename, true);
    }

    public static String getFullPathNoEndSeparator(String filename) {
        return doGetFullPath(filename, false);
    }

    private static String doGetFullPath(String str, boolean z) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            if (z) {
                return getPrefix(str);
            }
            return str;
        }
        int iIndexOfLastSeparator = indexOfLastSeparator(str);
        if (iIndexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i = iIndexOfLastSeparator + (z ? 1 : 0);
        if (i == 0) {
            i++;
        }
        return str.substring(0, i);
    }

    public static String getName(String filename) {
        if (filename == null) {
            return null;
        }
        failIfNullBytePresent(filename);
        int index = indexOfLastSeparator(filename);
        return filename.substring(index + 1);
    }

    private static void failIfNullBytePresent(String path) {
        int len = path.length();
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String getBaseName(String filename) {
        return removeExtension(getName(filename));
    }

    public static String getExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int index = indexOfExtension(filename);
        if (index == -1) {
            return "";
        }
        return filename.substring(index + 1);
    }

    public static String removeExtension(String filename) {
        if (filename == null) {
            return null;
        }
        failIfNullBytePresent(filename);
        int index = indexOfExtension(filename);
        if (index == -1) {
            return filename;
        }
        return filename.substring(0, index);
    }

    public static boolean equals(String filename1, String filename2) {
        return equals(filename1, filename2, false, IOCase.SENSITIVE);
    }

    public static boolean equalsOnSystem(String filename1, String filename2) {
        return equals(filename1, filename2, false, IOCase.SYSTEM);
    }

    public static boolean equalsNormalized(String filename1, String filename2) {
        return equals(filename1, filename2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String filename1, String filename2) {
        return equals(filename1, filename2, true, IOCase.SYSTEM);
    }

    public static boolean equals(String filename1, String filename2, boolean normalized, IOCase caseSensitivity) {
        if (filename1 == null || filename2 == null) {
            return filename1 == null && filename2 == null;
        }
        if (normalized) {
            filename1 = normalize(filename1);
            filename2 = normalize(filename2);
            if (filename1 == null || filename2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (caseSensitivity == null) {
            caseSensitivity = IOCase.SENSITIVE;
        }
        return caseSensitivity.checkEquals(filename1, filename2);
    }

    public static boolean isExtension(String filename, String extension) {
        if (filename == null) {
            return false;
        }
        failIfNullBytePresent(filename);
        if (extension == null || extension.isEmpty()) {
            return indexOfExtension(filename) == -1;
        }
        String fileExt = getExtension(filename);
        return fileExt.equals(extension);
    }

    public static boolean isExtension(String filename, String[] extensions) {
        if (filename == null) {
            return false;
        }
        failIfNullBytePresent(filename);
        if (extensions == null || extensions.length == 0) {
            return indexOfExtension(filename) == -1;
        }
        String fileExt = getExtension(filename);
        for (String extension : extensions) {
            if (fileExt.equals(extension)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(String filename, Collection<String> extensions) {
        if (filename == null) {
            return false;
        }
        failIfNullBytePresent(filename);
        if (extensions == null || extensions.isEmpty()) {
            return indexOfExtension(filename) == -1;
        }
        String fileExt = getExtension(filename);
        for (String extension : extensions) {
            if (fileExt.equals(extension)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wildcardMatch(String filename, String wildcardMatcher) {
        return wildcardMatch(filename, wildcardMatcher, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String filename, String wildcardMatcher) {
        return wildcardMatch(filename, wildcardMatcher, IOCase.SYSTEM);
    }

    public static boolean wildcardMatch(String filename, String wildcardMatcher, IOCase caseSensitivity) {
        IOCase caseSensitivity2;
        if (filename == null && wildcardMatcher == null) {
            return true;
        }
        if (filename == null || wildcardMatcher == null) {
            return false;
        }
        if (caseSensitivity != null) {
            caseSensitivity2 = caseSensitivity;
        } else {
            caseSensitivity2 = IOCase.SENSITIVE;
        }
        String[] wcs = splitOnTokens(wildcardMatcher);
        boolean anyChars = false;
        int textIdx = 0;
        int wcsIdx = 0;
        Stack<int[]> backtrack = new Stack<>();
        do {
            if (backtrack.size() > 0) {
                int[] array = backtrack.pop();
                wcsIdx = array[0];
                textIdx = array[1];
                anyChars = true;
            }
            while (wcsIdx < wcs.length) {
                if (wcs[wcsIdx].equals("?")) {
                    textIdx++;
                    if (textIdx > filename.length()) {
                        break;
                    }
                    anyChars = false;
                    wcsIdx++;
                } else {
                    if (wcs[wcsIdx].equals(Marker.ANY_MARKER)) {
                        anyChars = true;
                        if (wcsIdx == wcs.length - 1) {
                            textIdx = filename.length();
                        }
                    } else if (anyChars) {
                        textIdx = caseSensitivity2.checkIndexOf(filename, textIdx, wcs[wcsIdx]);
                        if (textIdx == -1) {
                            break;
                        }
                        int repeat = caseSensitivity2.checkIndexOf(filename, textIdx + 1, wcs[wcsIdx]);
                        if (repeat >= 0) {
                            backtrack.push(new int[]{wcsIdx, repeat});
                        }
                        textIdx += wcs[wcsIdx].length();
                        anyChars = false;
                    } else {
                        if (!caseSensitivity2.checkRegionMatches(filename, textIdx, wcs[wcsIdx])) {
                            break;
                        }
                        textIdx += wcs[wcsIdx].length();
                        anyChars = false;
                    }
                    wcsIdx++;
                }
            }
            if (wcsIdx == wcs.length && textIdx == filename.length()) {
                return true;
            }
        } while (backtrack.size() > 0);
        return false;
    }

    static String[] splitOnTokens(String text) {
        if (text.indexOf(63) == -1 && text.indexOf(42) == -1) {
            return new String[]{text};
        }
        char[] array = text.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        char prevChar = 0;
        for (char ch : array) {
            if (ch == '?' || ch == '*') {
                if (buffer.length() != 0) {
                    list.add(buffer.toString());
                    buffer.setLength(0);
                }
                if (ch == '?') {
                    list.add("?");
                } else if (prevChar != '*') {
                    list.add(Marker.ANY_MARKER);
                }
            } else {
                buffer.append(ch);
            }
            prevChar = ch;
        }
        if (buffer.length() != 0) {
            list.add(buffer.toString());
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
