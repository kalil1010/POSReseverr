package androidx.core.location;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Location.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0086\n¨\u0006\u0004"}, m17d2 = {"component1", "", "Landroid/location/Location;", "component2", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.location.LocationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Location {
    public static final double component1(android.location.Location component1) {
        Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.getLatitude();
    }

    public static final double component2(android.location.Location component2) {
        Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.getLongitude();
    }
}
