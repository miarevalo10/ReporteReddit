package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.LinkDataModel;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel;
import com.reddit.frontpage.domain.model.Link;
import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J.\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkDataModelConverter;", "", "()V", "from", "Lcom/reddit/frontpage/domain/model/Link;", "model", "Lcom/reddit/datalibrary/frontpage/data/model/LinkDataModel;", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "mutateIfNecessary", "link", "to", "listingPosition", "", "listing", "Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class LinkDataModelConverter {
    public static final LinkDataModelConverter f10654a = new LinkDataModelConverter();

    private LinkDataModelConverter() {
    }

    public static LinkDataModel m8951a(int i, Link link, JsonAdapter<Link> jsonAdapter, ListingDataModel listingDataModel) {
        Intrinsics.b(link, "link");
        Intrinsics.b(jsonAdapter, "adapter");
        String uniqueId = link.getUniqueId();
        link = jsonAdapter.toJson(link);
        Intrinsics.a(link, "adapter.toJson(link)");
        LinkDataModel linkDataModel = new LinkDataModel(uniqueId, i, link);
        linkDataModel.setListing(listingDataModel);
        return linkDataModel;
    }

    public static Link m8952a(LinkDataModel linkDataModel, JsonAdapter<Link> jsonAdapter) {
        JsonAdapter<Link> jsonAdapter2 = jsonAdapter;
        Intrinsics.b(linkDataModel, "model");
        Intrinsics.b(jsonAdapter2, "adapter");
        Object fromJson = jsonAdapter2.fromJson(linkDataModel.getLinkJson());
        if (fromJson == null) {
            Intrinsics.a();
        }
        Link link = (Link) fromJson;
        Intrinsics.a(link, "link");
        LinkMutationsDataModel mutations = linkDataModel.getMutations();
        if (mutations == null) {
            return link;
        }
        Object obj;
        Link copy$default;
        if (!mutations.isRead()) {
            if (link.getSaved() == mutations.isSaved()) {
                obj = null;
                if (obj == null) {
                    copy$default = Link.copy$default(link, null, null, 0, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, null, null, null, null, false, 0, false, false, null, null, null, null, null, null, null, null, false, null, null, null, false, false, false, false, mutations.isSaved(), false, false, false, false, null, null, false, false, false, null, false, false, null, null, null, null, null, false, false, null, null, null, mutations.isRead(), -1, 2147483391, null);
                } else {
                    copy$default = link;
                }
                return copy$default != null ? link : copy$default;
            }
        }
        obj = 1;
        if (obj == null) {
            copy$default = link;
        } else {
            copy$default = Link.copy$default(link, null, null, 0, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, null, null, null, null, false, 0, false, false, null, null, null, null, null, null, null, null, false, null, null, null, false, false, false, false, mutations.isSaved(), false, false, false, false, null, null, false, false, false, null, false, false, null, null, null, null, null, false, false, null, null, null, mutations.isRead(), -1, 2147483391, null);
        }
        if (copy$default != null) {
        }
    }
}
