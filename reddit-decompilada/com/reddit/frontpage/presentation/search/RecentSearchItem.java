package com.reddit.frontpage.presentation.search;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "model", "", "(Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchModels.kt */
public final class RecentSearchItem extends CommunitySearchItem {
    public static final Companion f28779d = new Companion();
    final String f28780c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/search/RecentSearchItem$Companion;", "", "()V", "VIEW_TYPE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchModels.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RecentSearchItem) {
                if (Intrinsics.m26845a(this.f28780c, ((RecentSearchItem) obj).f28780c)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f28780c;
        return str != null ? str.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RecentSearchItem(model=");
        stringBuilder.append(this.f28780c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RecentSearchItem(String str) {
        Intrinsics.m26847b(str, "model");
        super(1, -Math.abs((long) str.hashCode()));
        this.f28780c = str;
    }
}
