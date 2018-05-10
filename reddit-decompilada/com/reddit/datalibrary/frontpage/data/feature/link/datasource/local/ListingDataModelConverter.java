package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.LinkDataModel;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel;
import com.reddit.frontpage.domain.model.Link;
import com.squareup.moshi.JsonAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/ListingDataModelConverter;", "", "()V", "from", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "model", "Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class ListingDataModelConverter {
    public static final ListingDataModelConverter f10658a = new ListingDataModelConverter();

    private ListingDataModelConverter() {
    }

    public static Listing<Link> m8953a(ListingDataModel listingDataModel, JsonAdapter<Link> jsonAdapter) {
        Intrinsics.b(listingDataModel, "model");
        Intrinsics.b(jsonAdapter, "adapter");
        List links = listingDataModel.getLinks();
        if (links == null) {
            Intrinsics.a();
        }
        Iterable<LinkDataModel> iterable = links;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (LinkDataModel linkDataModel : iterable) {
            LinkDataModelConverter linkDataModelConverter = LinkDataModelConverter.f10654a;
            Intrinsics.a(linkDataModel, "it");
            arrayList.add(LinkDataModelConverter.m8952a(linkDataModel, jsonAdapter));
        }
        return new Listing((List) arrayList, listingDataModel.getAfter(), listingDataModel.getBefore(), listingDataModel.getAdDistance());
    }
}
