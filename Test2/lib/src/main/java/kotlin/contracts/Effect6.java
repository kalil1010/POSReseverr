package kotlin.contracts;

import kotlin.Metadata;

/* compiled from: Effect.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§\u0004¨\u0006\u0006"}, m17d2 = {"Lkotlin/contracts/SimpleEffect;", "Lkotlin/contracts/Effect;", "implies", "Lkotlin/contracts/ConditionalEffect;", "booleanExpression", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.contracts.SimpleEffect, reason: use source file name */
/* loaded from: classes.dex */
public interface Effect6 extends Effect {
    Effect3 implies(boolean booleanExpression);
}
