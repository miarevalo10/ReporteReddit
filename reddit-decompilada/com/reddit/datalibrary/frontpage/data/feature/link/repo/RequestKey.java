package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/RequestKey;", "", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "after", "", "adDistance", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "getAdDistance", "()Ljava/lang/String;", "getAfter", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RequestKey {
    final SortType f10706a;
    final SortTimeFrame f10707b;
    final String f10708c;
    final String f10709d;
    final ListingViewMode f10710e;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RequestKey) {
                RequestKey requestKey = (RequestKey) obj;
                if (Intrinsics.a(this.f10706a, requestKey.f10706a) && Intrinsics.a(this.f10707b, requestKey.f10707b) && Intrinsics.a(this.f10708c, requestKey.f10708c) && Intrinsics.a(this.f10709d, requestKey.f10709d) && Intrinsics.a(this.f10710e, requestKey.f10710e)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        SortType sortType = this.f10706a;
        int i = 0;
        int hashCode = (sortType != null ? sortType.hashCode() : 0) * 31;
        SortTimeFrame sortTimeFrame = this.f10707b;
        hashCode = (hashCode + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        String str = this.f10708c;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f10709d;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ListingViewMode listingViewMode = this.f10710e;
        if (listingViewMode != null) {
            i = listingViewMode.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RequestKey(sort=");
        stringBuilder.append(this.f10706a);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f10707b);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f10708c);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.f10709d);
        stringBuilder.append(", viewMode=");
        stringBuilder.append(this.f10710e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RequestKey(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, ListingViewMode listingViewMode) {
        this.f10706a = sortType;
        this.f10707b = sortTimeFrame;
        this.f10708c = str;
        this.f10709d = str2;
        this.f10710e = listingViewMode;
    }

    private /* synthetic */ RequestKey() {
        this(null, null, null, null, null);
    }
}
