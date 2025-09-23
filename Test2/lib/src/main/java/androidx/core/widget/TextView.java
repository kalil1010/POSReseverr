package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions18;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextView.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0080\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u001a4\u0010\u0013\u001a\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u001as\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b\u001as\u0010\u0016\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b¨\u0006\u0017"}, m17d2 = {"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "onTextChanged", "before", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.widget.TextViewKt, reason: use source file name */
/* loaded from: classes.dex */
public final class TextView {
    public static final TextWatcher doBeforeTextChanged(android.widget.TextView doBeforeTextChanged, final Functions18<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doBeforeTextChanged, "$this$doBeforeTextChanged");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                action.invoke(text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        };
        doBeforeTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doOnTextChanged(android.widget.TextView doOnTextChanged, final Functions18<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnTextChanged, "$this$doOnTextChanged");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                action.invoke(text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        };
        doOnTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doAfterTextChanged(android.widget.TextView doAfterTextChanged, final Functions2<? super Editable, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doAfterTextChanged, "$this$doAfterTextChanged");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                action.invoke(s);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        };
        doAfterTextChanged.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(android.widget.TextView addTextChangedListener, Functions18 beforeTextChanged, Functions18 onTextChanged, Functions2 afterTextChanged, int i, Object obj) {
        if ((i & 1) != 0) {
            Functions18 beforeTextChanged2 = new Functions18<CharSequence, Integer, Integer, Integer, Unit>() { // from class: androidx.core.widget.TextViewKt.addTextChangedListener.1
                @Override // kotlin.jvm.functions.Functions18
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(CharSequence $noName_0, int $noName_1, int $noName_2, int $noName_3) {
                }
            };
            beforeTextChanged = beforeTextChanged2;
        }
        if ((i & 2) != 0) {
            Functions18 onTextChanged2 = new Functions18<CharSequence, Integer, Integer, Integer, Unit>() { // from class: androidx.core.widget.TextViewKt.addTextChangedListener.2
                @Override // kotlin.jvm.functions.Functions18
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(CharSequence $noName_0, int $noName_1, int $noName_2, int $noName_3) {
                }
            };
            onTextChanged = onTextChanged2;
        }
        if ((i & 4) != 0) {
            Functions2 afterTextChanged2 = new Functions2<Editable, Unit>() { // from class: androidx.core.widget.TextViewKt.addTextChangedListener.3
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                    invoke2(editable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Editable it) {
                }
            };
            afterTextChanged = afterTextChanged2;
        }
        Intrinsics.checkParameterIsNotNull(addTextChangedListener, "$this$addTextChangedListener");
        Intrinsics.checkParameterIsNotNull(beforeTextChanged, "beforeTextChanged");
        Intrinsics.checkParameterIsNotNull(onTextChanged, "onTextChanged");
        Intrinsics.checkParameterIsNotNull(afterTextChanged, "afterTextChanged");
        TextView5 textWatcher = new TextView5(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher addTextChangedListener(android.widget.TextView addTextChangedListener, Functions18<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> beforeTextChanged, Functions18<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> onTextChanged, Functions2<? super Editable, Unit> afterTextChanged) {
        Intrinsics.checkParameterIsNotNull(addTextChangedListener, "$this$addTextChangedListener");
        Intrinsics.checkParameterIsNotNull(beforeTextChanged, "beforeTextChanged");
        Intrinsics.checkParameterIsNotNull(onTextChanged, "onTextChanged");
        Intrinsics.checkParameterIsNotNull(afterTextChanged, "afterTextChanged");
        TextView5 textWatcher = new TextView5(afterTextChanged, beforeTextChanged, onTextChanged);
        addTextChangedListener.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
