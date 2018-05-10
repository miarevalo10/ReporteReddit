package com.reddit.datalibrary.frontpage.data.feature.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "CONFIDENCE", "TOP", "NEW", "CONTROVERSIAL", "OLD", "QA", "LIVE", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sortings.kt */
public enum CommentSortType {
    ;
    
    public static final Companion f10367h = null;
    private final String f10369j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType$Companion;", "", "()V", "toEnum", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "string", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Sortings.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private CommentSortType(String str) {
        Intrinsics.b(str, "value");
        this.f10369j = str;
    }

    static {
        f10367h = new Companion();
    }

    public final String toString() {
        return this.f10369j;
    }
}
