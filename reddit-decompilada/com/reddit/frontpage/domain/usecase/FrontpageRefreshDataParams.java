package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/FrontpageRefreshDataParams;", "Lcom/reddit/frontpage/domain/usecase/AdsParams;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "adsBatchSize", "", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;I)V", "getAdContext", "()Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "getAdsBatchSize", "()I", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageRefreshData.kt */
public final class FrontpageRefreshDataParams implements AdsParams {
    final SortType f33730a;
    final SortTimeFrame f33731b;
    final ListingViewMode f33732c;
    private final AdContext f33733d;
    private final int f33734e;

    public FrontpageRefreshDataParams(SortType sortType, SortTimeFrame sortTimeFrame, ListingViewMode listingViewMode, AdContext adContext, int i) {
        Intrinsics.m26847b(listingViewMode, "viewMode");
        Intrinsics.m26847b(adContext, "adContext");
        this.f33730a = sortType;
        this.f33731b = sortTimeFrame;
        this.f33732c = listingViewMode;
        this.f33733d = adContext;
        this.f33734e = i;
    }

    public final AdContext mo6430a() {
        return this.f33733d;
    }

    public final int mo6431b() {
        return this.f33734e;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("FrontpageRefreshDataParams(sort=");
        stringBuilder.append(this.f33730a);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f33731b);
        stringBuilder.append(", viewMode=");
        stringBuilder.append(this.f33732c);
        stringBuilder.append(", adContext=");
        stringBuilder.append(this.f33733d);
        stringBuilder.append(", adsBatchSize=");
        stringBuilder.append(this.f33734e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        SortType sortType = this.f33730a;
        int i = 0;
        int hashCode = (sortType != null ? sortType.hashCode() : 0) * 31;
        SortTimeFrame sortTimeFrame = this.f33731b;
        hashCode = (hashCode + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        ListingViewMode listingViewMode = this.f33732c;
        hashCode = (hashCode + (listingViewMode != null ? listingViewMode.hashCode() : 0)) * 31;
        AdContext adContext = this.f33733d;
        if (adContext != null) {
            i = adContext.hashCode();
        }
        return ((hashCode + i) * 31) + this.f33734e;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FrontpageRefreshDataParams) {
                FrontpageRefreshDataParams frontpageRefreshDataParams = (FrontpageRefreshDataParams) obj;
                if (Intrinsics.m26845a(this.f33730a, frontpageRefreshDataParams.f33730a) && Intrinsics.m26845a(this.f33731b, frontpageRefreshDataParams.f33731b) && Intrinsics.m26845a(this.f33732c, frontpageRefreshDataParams.f33732c) && Intrinsics.m26845a(this.f33733d, frontpageRefreshDataParams.f33733d)) {
                    if ((this.f33734e == frontpageRefreshDataParams.f33734e ? 1 : null) != null) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
