package com.github.devnied.emvnfccard.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p006io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class AtrUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) AtrUtils.class);
    private static final MultiValuedMap<String, String> MAP = new ArrayListValuedHashMap();

    static {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            try {
                is = AtrUtils.class.getResourceAsStream("/smartcard_list.txt");
                isr = new InputStreamReader(is, CharEncoding.UTF_8);
                br = new BufferedReader(isr);
                int lineNumber = 0;
                String currentATR = null;
                while (true) {
                    String line = br.readLine();
                    if (line != null) {
                        lineNumber++;
                        if (!line.startsWith("#") && line.trim().length() != 0 && !line.contains("http")) {
                            if (line.startsWith("\t") && currentATR != null) {
                                MAP.put(currentATR, line.replace("\t", "").trim());
                            } else if (line.startsWith("3")) {
                                currentATR = StringUtils.deleteWhitespace(line.toUpperCase()).replaceAll("9000$", "");
                            } else {
                                LOGGER.error("Encountered unexpected line in atr list: currentATR=" + currentATR + " Line(" + lineNumber + ") = " + line);
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            IOUtils.closeQuietly((Reader) br);
            IOUtils.closeQuietly((Reader) isr);
            IOUtils.closeQuietly(is);
        }
    }

    public static final Collection<String> getDescription(String pAtr) {
        if (!StringUtils.isNotBlank(pAtr)) {
            return null;
        }
        String val = StringUtils.deleteWhitespace(pAtr).toUpperCase();
        for (String key : MAP.keySet()) {
            if (val.matches("^" + key + "$")) {
                Collection<String> ret = MAP.get(key);
                return ret;
            }
        }
        return null;
    }

    public static final Collection<String> getDescriptionFromAts(String pAts) {
        Collection<String> ret = new ArrayList<>();
        if (StringUtils.isNotBlank(pAts)) {
            String val = StringUtils.deleteWhitespace(pAts).replaceAll("9000$", "");
            for (String key : MAP.keySet()) {
                int j = val.length() - 1;
                int i = key.length() - 1;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    if (key.charAt(i) == '.' || key.charAt(i) == val.charAt(j)) {
                        j--;
                        i--;
                        if (j < 0) {
                            if (!key.substring(key.length() - val.length(), key.length()).replace(".", "").isEmpty()) {
                                ret.addAll(MAP.get(key));
                            }
                        }
                    } else if (j != val.length() - 1) {
                        j = val.length() - 1;
                    } else {
                        if (i == key.length() - 1) {
                            break;
                        }
                        i--;
                    }
                }
            }
        }
        return ret;
    }

    private AtrUtils() {
    }
}
