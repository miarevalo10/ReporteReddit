package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/DiffListingUseCaseParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "presentationModels", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Ljava/util/List;Lcom/reddit/frontpage/presentation/listing/common/ListingType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "getPresentationModels", "()Ljava/util/List;", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiffListingUseCase.kt */
public final class DiffListingUseCaseParams implements Params {
    final List<Listable> f27978a;
    final ListingType f27979b;
    final SortType f27980c;
    final SortTimeFrame f27981d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DiffListingUseCaseParams) {
                DiffListingUseCaseParams diffListingUseCaseParams = (DiffListingUseCaseParams) obj;
                if (Intrinsics.m26845a(this.f27978a, diffListingUseCaseParams.f27978a) && Intrinsics.m26845a(this.f27979b, diffListingUseCaseParams.f27979b) && Intrinsics.m26845a(this.f27980c, diffListingUseCaseParams.f27980c) && Intrinsics.m26845a(this.f27981d, diffListingUseCaseParams.f27981d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.f27978a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ListingType listingType = this.f27979b;
        hashCode = (hashCode + (listingType != null ? listingType.hashCode() : 0)) * 31;
        SortType sortType = this.f27980c;
        hashCode = (hashCode + (sortType != null ? sortType.hashCode() : 0)) * 31;
        SortTimeFrame sortTimeFrame = this.f27981d;
        if (sortTimeFrame != null) {
            i = sortTimeFrame.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DiffListingUseCaseParams(presentationModels=");
        stringBuilder.append(this.f27978a);
        stringBuilder.append(", listingType=");
        stringBuilder.append(this.f27979b);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.f27980c);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f27981d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public DiffListingUseCaseParams(List<? extends Listable> list, ListingType listingType, SortType sortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(list, "presentationModels");
        Intrinsics.m26847b(listingType, "listingType");
        Intrinsics.m26847b(sortType, "sort");
        this.f27978a = list;
        this.f27979b = listingType;
        this.f27980c = sortType;
        this.f27981d = sortTimeFrame;
    }
}
