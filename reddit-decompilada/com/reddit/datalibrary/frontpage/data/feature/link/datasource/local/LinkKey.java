package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.Key;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkKey;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "type", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkKeyType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "after", "", "(Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkKeyType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;)V", "getAfter", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getType", "()Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkKeyType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FileLinkDataSource.kt */
public final class LinkKey implements Key {
    private final LinkKeyType f16043a;
    private final SortType f16044b;
    private final SortTimeFrame f16045c;
    private final String f16046d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkKey) {
                LinkKey linkKey = (LinkKey) obj;
                if (Intrinsics.a(this.f16043a, linkKey.f16043a) && Intrinsics.a(this.f16044b, linkKey.f16044b) && Intrinsics.a(this.f16045c, linkKey.f16045c) && Intrinsics.a(this.f16046d, linkKey.f16046d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        LinkKeyType linkKeyType = this.f16043a;
        int i = 0;
        int hashCode = (linkKeyType != null ? linkKeyType.hashCode() : 0) * 31;
        SortType sortType = this.f16044b;
        hashCode = (hashCode + (sortType != null ? sortType.hashCode() : 0)) * 31;
        SortTimeFrame sortTimeFrame = this.f16045c;
        hashCode = (hashCode + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        String str = this.f16046d;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkKey(type=");
        stringBuilder.append(this.f16043a);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.f16044b);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f16045c);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f16046d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinkKey(LinkKeyType linkKeyType, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        Intrinsics.b(linkKeyType, "type");
        this.f16043a = linkKeyType;
        this.f16044b = sortType;
        this.f16045c = sortTimeFrame;
        this.f16046d = str;
    }
}
