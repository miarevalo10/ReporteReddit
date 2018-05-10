package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/reddit/datalibrary/frontpage/data/model/LinkMutationsDataModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$markLinkAsRead$1 extends Lambda implements Function1<LinkMutationsDataModel, Unit> {
    public static final DatabaseLinkDataSource$markLinkAsRead$1 f19371a = new DatabaseLinkDataSource$markLinkAsRead$1();

    DatabaseLinkDataSource$markLinkAsRead$1() {
        super(1);
    }

    public final /* synthetic */ Object m20626a(Object obj) {
        LinkMutationsDataModel linkMutationsDataModel = (LinkMutationsDataModel) obj;
        Intrinsics.b(linkMutationsDataModel, "$receiver");
        linkMutationsDataModel.setRead(true);
        linkMutationsDataModel.setReadTimestampUtc(System.currentTimeMillis());
        return Unit.a;
    }
}
