package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003JW\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/FrontpageLoadDataParams;", "Lcom/reddit/frontpage/domain/usecase/AdsParams;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "after", "", "adDistance", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "adsBatchSize", "", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;I)V", "getAdContext", "()Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "getAdDistance", "()Ljava/lang/String;", "getAdsBatchSize", "()I", "getAfter", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageLoadData.kt */
public final class FrontpageLoadDataParams implements AdsParams {
    final SortType f33718a;
    final SortTimeFrame f33719b;
    final String f33720c;
    final String f33721d;
    final ListingViewMode f33722e;
    private final AdContext f33723f;
    private final int f33724g;

    public FrontpageLoadDataParams(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, ListingViewMode listingViewMode, AdContext adContext, int i) {
        Intrinsics.m26847b(listingViewMode, "viewMode");
        Intrinsics.m26847b(adContext, "adContext");
        this.f33718a = sortType;
        this.f33719b = sortTimeFrame;
        this.f33720c = str;
        this.f33721d = str2;
        this.f33722e = listingViewMode;
        this.f33723f = adContext;
        this.f33724g = i;
    }

    public final AdContext mo6430a() {
        return this.f33723f;
    }

    public final int mo6431b() {
        return this.f33724g;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("FrontpageLoadDataParams(sort=");
        stringBuilder.append(this.f33718a);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f33719b);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f33720c);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.f33721d);
        stringBuilder.append(", viewMode=");
        stringBuilder.append(this.f33722e);
        stringBuilder.append(", adContext=");
        stringBuilder.append(this.f33723f);
        stringBuilder.append(", adsBatchSize=");
        stringBuilder.append(this.f33724g);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        SortType sortType = this.f33718a;
        int i = 0;
        int hashCode = (sortType != null ? sortType.hashCode() : 0) * 31;
        SortTimeFrame sortTimeFrame = this.f33719b;
        hashCode = (hashCode + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        String str = this.f33720c;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33721d;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ListingViewMode listingViewMode = this.f33722e;
        hashCode = (hashCode + (listingViewMode != null ? listingViewMode.hashCode() : 0)) * 31;
        AdContext adContext = this.f33723f;
        if (adContext != null) {
            i = adContext.hashCode();
        }
        return ((hashCode + i) * 31) + this.f33724g;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FrontpageLoadDataParams) {
                FrontpageLoadDataParams frontpageLoadDataParams = (FrontpageLoadDataParams) obj;
                if (Intrinsics.m26845a(this.f33718a, frontpageLoadDataParams.f33718a) && Intrinsics.m26845a(this.f33719b, frontpageLoadDataParams.f33719b) && Intrinsics.m26845a(this.f33720c, frontpageLoadDataParams.f33720c) && Intrinsics.m26845a(this.f33721d, frontpageLoadDataParams.f33721d) && Intrinsics.m26845a(this.f33722e, frontpageLoadDataParams.f33722e) && Intrinsics.m26845a(this.f33723f, frontpageLoadDataParams.f33723f)) {
                    if ((this.f33724g == frontpageLoadDataParams.f33724g ? 1 : null) != null) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
