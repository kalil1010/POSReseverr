package androidx.core.content;

import com.github.devnied.emvnfccard.utils.TrackUtils;
import java.util.ArrayList;
import org.slf4j.Marker;

/* loaded from: classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    private static boolean mimeTypeAgainstFilter(String[] mimeTypeParts, String[] filterParts) {
        if (filterParts.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (filterParts[0].isEmpty() || filterParts[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (mimeTypeParts.length != 2) {
            return false;
        }
        if (Marker.ANY_MARKER.equals(filterParts[0]) || filterParts[0].equals(mimeTypeParts[0])) {
            return Marker.ANY_MARKER.equals(filterParts[1]) || filterParts[1].equals(mimeTypeParts[1]);
        }
        return false;
    }

    public static boolean matches(String mimeType, String filter) {
        if (mimeType == null) {
            return false;
        }
        String[] mimeTypeParts = mimeType.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
        String[] filterParts = filter.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
        return mimeTypeAgainstFilter(mimeTypeParts, filterParts);
    }

    public static String matches(String mimeType, String[] filters) {
        if (mimeType == null) {
            return null;
        }
        String[] mimeTypeParts = mimeType.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
        for (String filter : filters) {
            String[] filterParts = filter.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
            if (mimeTypeAgainstFilter(mimeTypeParts, filterParts)) {
                return filter;
            }
        }
        return null;
    }

    public static String matches(String[] mimeTypes, String filter) {
        if (mimeTypes == null) {
            return null;
        }
        String[] filterParts = filter.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
        for (String mimeType : mimeTypes) {
            String[] mimeTypeParts = mimeType.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
            if (mimeTypeAgainstFilter(mimeTypeParts, filterParts)) {
                return mimeType;
            }
        }
        return null;
    }

    public static String[] matchesMany(String[] mimeTypes, String filter) {
        if (mimeTypes == null) {
            return new String[0];
        }
        ArrayList<String> list = new ArrayList<>();
        String[] filterParts = filter.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
        for (String mimeType : mimeTypes) {
            String[] mimeTypeParts = mimeType.split(TrackUtils.CARD_HOLDER_NAME_SEPARATOR);
            if (mimeTypeAgainstFilter(mimeTypeParts, filterParts)) {
                list.add(mimeType);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
