package com.reddit.datalibrary.frontpage.data.feature.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/common/NotificationSortType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "ALL", "POST_REPLIES", "COMMENT_REPLIES", "MENTIONS", "INBOX", "TRENDING", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sortings.kt */
public enum NotificationSortType {
    ;
    
    private final String f10377h;

    private NotificationSortType(String str) {
        Intrinsics.b(str, "value");
        this.f10377h = str;
    }

    public final String toString() {
        return this.f10377h;
    }
}
