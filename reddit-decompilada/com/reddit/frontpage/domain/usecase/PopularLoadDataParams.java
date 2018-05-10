package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003J_\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0010HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/PopularLoadDataParams;", "Lcom/reddit/frontpage/domain/usecase/AdsParams;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "after", "", "adDistance", "refresh", "", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "adsBatchSize", "", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;Ljava/lang/String;ZLcom/reddit/frontpage/presentation/listing/model/ListingViewMode;Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;I)V", "getAdContext", "()Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "getAdDistance", "()Ljava/lang/String;", "getAdsBatchSize", "()I", "getAfter", "getRefresh", "()Z", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PopularLoadData.kt */
public final class PopularLoadDataParams implements AdsParams {
    final SortType f33752a;
    final SortTimeFrame f33753b;
    final String f33754c;
    final String f33755d;
    final ListingViewMode f33756e;
    private final boolean f33757f;
    private final AdContext f33758g;
    private final int f33759h;

    private PopularLoadDataParams(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, ListingViewMode listingViewMode, AdContext adContext, int i) {
        Intrinsics.m26847b(sortType, "sort");
        Intrinsics.m26847b(listingViewMode, "viewMode");
        Intrinsics.m26847b(adContext, "adContext");
        this.f33752a = sortType;
        this.f33753b = sortTimeFrame;
        this.f33754c = str;
        this.f33755d = str2;
        this.f33757f = null;
        this.f33756e = listingViewMode;
        this.f33758g = adContext;
        this.f33759h = i;
    }

    public final AdContext mo6430a() {
        return this.f33758g;
    }

    public final int mo6431b() {
        return this.f33759h;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PopularLoadDataParams(sort=");
        stringBuilder.append(this.f33752a);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f33753b);
        stringBuilder.append(", after=");
        stringBuilder.append(this.f33754c);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.f33755d);
        stringBuilder.append(", refresh=");
        stringBuilder.append(this.f33757f);
        stringBuilder.append(", viewMode=");
        stringBuilder.append(this.f33756e);
        stringBuilder.append(", adContext=");
        stringBuilder.append(this.f33758g);
        stringBuilder.append(", adsBatchSize=");
        stringBuilder.append(this.f33759h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        SortType sortType = this.f33752a;
        int i = 0;
        int hashCode = (sortType != null ? sortType.hashCode() : 0) * 31;
        SortTimeFrame sortTimeFrame = this.f33753b;
        hashCode = (hashCode + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        String str = this.f33754c;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f33755d;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        int i2 = this.f33757f;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        ListingViewMode listingViewMode = this.f33756e;
        hashCode = (hashCode + (listingViewMode != null ? listingViewMode.hashCode() : 0)) * 31;
        AdContext adContext = this.f33758g;
        if (adContext != null) {
            i = adContext.hashCode();
        }
        return ((hashCode + i) * 31) + this.f33759h;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PopularLoadDataParams) {
                PopularLoadDataParams popularLoadDataParams = (PopularLoadDataParams) obj;
                if (Intrinsics.m26845a(this.f33752a, popularLoadDataParams.f33752a) && Intrinsics.m26845a(this.f33753b, popularLoadDataParams.f33753b) && Intrinsics.m26845a(this.f33754c, popularLoadDataParams.f33754c) && Intrinsics.m26845a(this.f33755d, popularLoadDataParams.f33755d)) {
                    if ((this.f33757f == popularLoadDataParams.f33757f) && Intrinsics.m26845a(this.f33756e, popularLoadDataParams.f33756e) && Intrinsics.m26845a(this.f33758g, popularLoadDataParams.f33758g)) {
                        if ((this.f33759h == popularLoadDataParams.f33759h ? 1 : null) != null) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }
}
