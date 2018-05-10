package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.usecase.ListingSortUseCase.LegacyListingSort;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/usecase/ListingSortUseCase$LegacyListingSort;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ListingSortUseCase.kt */
final class ListingSortUseCase$get$1<T, R> implements Function<T, R> {
    public static final ListingSortUseCase$get$1 f28019a = new ListingSortUseCase$get$1();

    ListingSortUseCase$get$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "<name for destructuring parameter 0>");
        int intValue = ((Number) pair.f25267a).intValue();
        obj = (Integer) pair.f25268b;
        Intrinsics.m26843a(obj, "sortTimeFrame");
        return new LegacyListingSort(intValue, obj.intValue());
    }
}
