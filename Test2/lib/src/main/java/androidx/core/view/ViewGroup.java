package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers4;
import kotlin.sequences.Sequence;

/* compiled from: ViewGroup.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0086\b\u001a5\u0010\u001f\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010 \u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010\"\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0086\b\u001a5\u0010$\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010%\u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006'"}, m17d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.view.ViewGroupKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewGroup {
    public static final View get(android.view.ViewGroup get, int index) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        View childAt = get.getChildAt(index);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + get.getChildCount());
    }

    public static final boolean contains(android.view.ViewGroup contains, View view) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(view, "view");
        return contains.indexOfChild(view) != -1;
    }

    public static final void plusAssign(android.view.ViewGroup plusAssign, View view) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(view, "view");
        plusAssign.addView(view);
    }

    public static final void minusAssign(android.view.ViewGroup minusAssign, View view) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(view, "view");
        minusAssign.removeView(view);
    }

    public static final int getSize(android.view.ViewGroup size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.getChildCount();
    }

    public static final boolean isEmpty(android.view.ViewGroup isEmpty) {
        Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(android.view.ViewGroup isNotEmpty) {
        Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.getChildCount() != 0;
    }

    public static final void forEach(android.view.ViewGroup forEach, Functions2<? super View, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int childCount = forEach.getChildCount();
        for (int index = 0; index < childCount; index++) {
            View childAt = forEach.getChildAt(index);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(android.view.ViewGroup forEachIndexed, Functions13<? super Integer, ? super View, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int childCount = forEachIndexed.getChildCount();
        for (int index = 0; index < childCount; index++) {
            Integer numValueOf = Integer.valueOf(index);
            View childAt = forEachIndexed.getChildAt(index);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            action.invoke(numValueOf, childAt);
        }
    }

    /* compiled from: ViewGroup.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m17d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
    /* renamed from: androidx.core.view.ViewGroupKt$iterator$1 */
    public static final class C01901 implements Iterator<View>, KMarkers4 {
        final /* synthetic */ android.view.ViewGroup $this_iterator;
        private int index;

        C01901(android.view.ViewGroup $receiver) {
            this.$this_iterator = $receiver;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            android.view.ViewGroup viewGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public void remove() {
            android.view.ViewGroup viewGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            viewGroup.removeViewAt(i);
        }
    }

    public static final Iterator<View> iterator(android.view.ViewGroup iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new C01901(iterator);
    }

    public static final Sequence<View> getChildren(final android.view.ViewGroup children) {
        Intrinsics.checkParameterIsNotNull(children, "$this$children");
        return new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<View> iterator() {
                return ViewGroup.iterator(children);
            }
        };
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams setMargins, int size) {
        Intrinsics.checkParameterIsNotNull(setMargins, "$this$setMargins");
        setMargins.setMargins(size, size, size, size);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams updateMargins, int left, int top, int right, int bottom, int i, Object obj) {
        if ((i & 1) != 0) {
            left = updateMargins.leftMargin;
        }
        if ((i & 2) != 0) {
            top = updateMargins.topMargin;
        }
        if ((i & 4) != 0) {
            right = updateMargins.rightMargin;
        }
        if ((i & 8) != 0) {
            bottom = updateMargins.bottomMargin;
        }
        Intrinsics.checkParameterIsNotNull(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(left, top, right, bottom);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams updateMargins, int left, int top, int right, int bottom) {
        Intrinsics.checkParameterIsNotNull(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(left, top, right, bottom);
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams updateMarginsRelative, int start, int top, int end, int bottom, int i, Object obj) {
        if ((i & 1) != 0) {
            start = updateMarginsRelative.getMarginStart();
        }
        if ((i & 2) != 0) {
            top = updateMarginsRelative.topMargin;
        }
        if ((i & 4) != 0) {
            end = updateMarginsRelative.getMarginEnd();
        }
        if ((i & 8) != 0) {
            bottom = updateMarginsRelative.bottomMargin;
        }
        Intrinsics.checkParameterIsNotNull(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(start);
        updateMarginsRelative.topMargin = top;
        updateMarginsRelative.setMarginEnd(end);
        updateMarginsRelative.bottomMargin = bottom;
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams updateMarginsRelative, int start, int top, int end, int bottom) {
        Intrinsics.checkParameterIsNotNull(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(start);
        updateMarginsRelative.topMargin = top;
        updateMarginsRelative.setMarginEnd(end);
        updateMarginsRelative.bottomMargin = bottom;
    }
}
