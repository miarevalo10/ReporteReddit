package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.LinkDataModel;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/model/Link;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/LinkDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$getLinkById$1<T, R> implements Function<T, R> {
    final /* synthetic */ DatabaseLinkDataSource f16023a;

    DatabaseLinkDataSource$getLinkById$1(DatabaseLinkDataSource databaseLinkDataSource) {
        this.f16023a = databaseLinkDataSource;
    }

    public final /* synthetic */ Object apply(Object obj) {
        LinkDataModel linkDataModel = (LinkDataModel) obj;
        Intrinsics.b(linkDataModel, "it");
        LinkDataModelConverter linkDataModelConverter = LinkDataModelConverter.f10654a;
        return LinkDataModelConverter.m8952a(linkDataModel, this.f16023a.m15966b());
    }
}
