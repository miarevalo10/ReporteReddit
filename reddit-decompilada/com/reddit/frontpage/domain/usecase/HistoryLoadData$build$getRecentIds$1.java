package com.reddit.frontpage.domain.usecase;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/usecase/RecentIds;", "recentIds", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryLoadData.kt */
final class HistoryLoadData$build$getRecentIds$1<T, R> implements Function<T, R> {
    public static final HistoryLoadData$build$getRecentIds$1 f27990a = new HistoryLoadData$build$getRecentIds$1();

    HistoryLoadData$build$getRecentIds$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "recentIds");
        return new RecentIds(str);
    }
}
