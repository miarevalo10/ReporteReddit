package com.reddit.frontpage.presentation.listing.history;

import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "RECENT", "UPVOTED", "DOWNVOTED", "HIDDEN", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistorySortOptions.kt */
public enum HistorySortType implements LinkSortType {
    ;
    
    private final String f28413f;

    private HistorySortType(String str) {
        Intrinsics.m26847b(str, "value");
        this.f28413f = str;
    }

    public final String toString() {
        return this.f28413f;
    }
}
