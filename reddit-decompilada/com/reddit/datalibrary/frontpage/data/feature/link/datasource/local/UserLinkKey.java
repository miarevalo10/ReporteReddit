package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.Key;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/UserLinkKey;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "username", "", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "after", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getAfter", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FileLinkDataSource.kt */
public final class UserLinkKey implements Key {
    public final String f16048a;
    public final SortType f16049b;
    public final String f16050c;
    public final SortTimeFrame f16051d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserLinkKey) {
                UserLinkKey userLinkKey = (UserLinkKey) obj;
                if (Intrinsics.a(this.f16048a, userLinkKey.f16048a) && Intrinsics.a(this.f16049b, userLinkKey.f16049b) && Intrinsics.a(this.f16050c, userLinkKey.f16050c) && Intrinsics.a(this.f16051d, userLinkKey.f16051d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f16048a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SortType sortType = this.f16049b;
        hashCode = (hashCode + (sortType != null ? sortType.hashCode() : 0)) * 31;
        String str2 = this.f16050c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        SortTimeFrame sortTimeFrame = this.f16051d;
        if (sortTimeFrame != null) {
            i = sortTimeFrame.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserLinkKey(username=");
        stringBuilder.append(this.f16048a);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.f16049b);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f16050c);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f16051d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UserLinkKey(String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame) {
        Intrinsics.b(str, "username");
        Intrinsics.b(sortType, "sort");
        this.f16048a = str;
        this.f16049b = sortType;
        this.f16050c = str2;
        this.f16051d = sortTimeFrame;
    }
}
