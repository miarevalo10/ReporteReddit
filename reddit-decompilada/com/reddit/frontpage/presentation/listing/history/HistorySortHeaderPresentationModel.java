package com.reddit.frontpage.presentation.listing.history;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "sort", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "(Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "listableType", "", "getListableType", "()I", "getSort", "()Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "getViewMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "component1", "component2", "copy", "equals", "", "other", "", "getUniqueID", "", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistorySortHeaderPresentationModel.kt */
public final class HistorySortHeaderPresentationModel implements Listable {
    public final SortOption<HistorySortType> f33927a;
    public final ListingViewMode f33928b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HistorySortHeaderPresentationModel) {
                HistorySortHeaderPresentationModel historySortHeaderPresentationModel = (HistorySortHeaderPresentationModel) obj;
                if (Intrinsics.m26845a(this.f33927a, historySortHeaderPresentationModel.f33927a) && Intrinsics.m26845a(this.f33928b, historySortHeaderPresentationModel.f33928b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int getListableType() {
        return 22;
    }

    public final int getMinAndroidVersion() {
        return 0;
    }

    public final long getUniqueID() {
        return Long.MIN_VALUE;
    }

    public final int hashCode() {
        SortOption sortOption = this.f33927a;
        int i = 0;
        int hashCode = (sortOption != null ? sortOption.hashCode() : 0) * 31;
        ListingViewMode listingViewMode = this.f33928b;
        if (listingViewMode != null) {
            i = listingViewMode.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("HistorySortHeaderPresentationModel(sort=");
        stringBuilder.append(this.f33927a);
        stringBuilder.append(", viewMode=");
        stringBuilder.append(this.f33928b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public HistorySortHeaderPresentationModel(SortOption<HistorySortType> sortOption, ListingViewMode listingViewMode) {
        Intrinsics.m26847b(sortOption, "sort");
        Intrinsics.m26847b(listingViewMode, "viewMode");
        this.f33927a = sortOption;
        this.f33928b = listingViewMode;
    }

    public static /* synthetic */ HistorySortHeaderPresentationModel m34725a(HistorySortHeaderPresentationModel historySortHeaderPresentationModel, ListingViewMode listingViewMode) {
        historySortHeaderPresentationModel = historySortHeaderPresentationModel.f33927a;
        Intrinsics.m26847b(historySortHeaderPresentationModel, "sort");
        Intrinsics.m26847b(listingViewMode, "viewMode");
        return new HistorySortHeaderPresentationModel(historySortHeaderPresentationModel, listingViewMode);
    }
}
