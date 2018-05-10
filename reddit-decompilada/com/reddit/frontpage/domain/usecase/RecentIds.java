package com.reddit.frontpage.domain.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/RecentIds;", "", "ids", "", "(Ljava/lang/String;)V", "getIds", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistoryLoadData.kt */
public final class RecentIds {
    final String f20290a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RecentIds) {
                if (Intrinsics.m26845a(this.f20290a, ((RecentIds) obj).f20290a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f20290a;
        return str != null ? str.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RecentIds(ids=");
        stringBuilder.append(this.f20290a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RecentIds(String str) {
        this.f20290a = str;
    }

    public /* synthetic */ RecentIds() {
        this(null);
    }
}
