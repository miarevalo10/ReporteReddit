package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.ListingDataModel;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$getLinks$1<T, R> implements Function<T, R> {
    final /* synthetic */ DatabaseLinkDataSource f16024a;

    DatabaseLinkDataSource$getLinks$1(DatabaseLinkDataSource databaseLinkDataSource) {
        this.f16024a = databaseLinkDataSource;
    }

    public final /* synthetic */ Object apply(Object obj) {
        ListingDataModel listingDataModel = (ListingDataModel) obj;
        Intrinsics.b(listingDataModel, "it");
        ListingDataModelConverter listingDataModelConverter = ListingDataModelConverter.f10658a;
        return ListingDataModelConverter.m8953a(listingDataModel, this.f16024a.m15966b());
    }
}
