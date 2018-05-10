package com.reddit.frontpage.presentation.listing.model;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\b\u0010 \u001a\u00020!H\u0016J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "sortType", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "geopopularText", "", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;Ljava/lang/String;)V", "getGeopopularText", "()Ljava/lang/String;", "listableType", "", "getListableType", "()I", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getSortType", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getUniqueID", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SortHeaderPresentationModel.kt */
public final class SortHeaderPresentationModel implements Listable {
    public final SortType f34005a;
    public final SortTimeFrame f34006b;
    public final ListingViewMode f34007c;
    public final String f34008d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SortHeaderPresentationModel) {
                SortHeaderPresentationModel sortHeaderPresentationModel = (SortHeaderPresentationModel) obj;
                if (Intrinsics.m26845a(this.f34005a, sortHeaderPresentationModel.f34005a) && Intrinsics.m26845a(this.f34006b, sortHeaderPresentationModel.f34006b) && Intrinsics.m26845a(this.f34007c, sortHeaderPresentationModel.f34007c) && Intrinsics.m26845a(this.f34008d, sortHeaderPresentationModel.f34008d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int getListableType() {
        return 7;
    }

    public final int getMinAndroidVersion() {
        return 0;
    }

    public final long getUniqueID() {
        return Long.MIN_VALUE;
    }

    public final int hashCode() {
        SortType sortType = this.f34005a;
        int i = 0;
        int hashCode = (sortType != null ? sortType.hashCode() : 0) * 31;
        SortTimeFrame sortTimeFrame = this.f34006b;
        hashCode = (hashCode + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        ListingViewMode listingViewMode = this.f34007c;
        hashCode = (hashCode + (listingViewMode != null ? listingViewMode.hashCode() : 0)) * 31;
        String str = this.f34008d;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortHeaderPresentationModel(sortType=");
        stringBuilder.append(this.f34005a);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f34006b);
        stringBuilder.append(", viewMode=");
        stringBuilder.append(this.f34007c);
        stringBuilder.append(", geopopularText=");
        stringBuilder.append(this.f34008d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SortHeaderPresentationModel(SortType sortType, SortTimeFrame sortTimeFrame, ListingViewMode listingViewMode, String str) {
        Intrinsics.m26847b(sortType, "sortType");
        Intrinsics.m26847b(listingViewMode, "viewMode");
        this.f34005a = sortType;
        this.f34006b = sortTimeFrame;
        this.f34007c = listingViewMode;
        this.f34008d = str;
    }

    public static /* synthetic */ SortHeaderPresentationModel m34745a(SortHeaderPresentationModel sortHeaderPresentationModel, ListingViewMode listingViewMode) {
        SortType sortType = sortHeaderPresentationModel.f34005a;
        SortTimeFrame sortTimeFrame = sortHeaderPresentationModel.f34006b;
        sortHeaderPresentationModel = sortHeaderPresentationModel.f34008d;
        Intrinsics.m26847b(sortType, "sortType");
        Intrinsics.m26847b(listingViewMode, "viewMode");
        return new SortHeaderPresentationModel(sortType, sortTimeFrame, listingViewMode, sortHeaderPresentationModel);
    }
}
