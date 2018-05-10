package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.reddit.datalibrary.frontpage.data.model.LinkDataModel;
import com.reddit.datalibrary.frontpage.data.model.LinkDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$mutate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DatabaseLinkDataSource f19372a;
    final /* synthetic */ LinkMutationsDataModel f19373b;
    final /* synthetic */ Function1 f19374c;

    DatabaseLinkDataSource$mutate$1(DatabaseLinkDataSource databaseLinkDataSource, LinkMutationsDataModel linkMutationsDataModel, Function1 function1) {
        this.f19372a = databaseLinkDataSource;
        this.f19373b = linkMutationsDataModel;
        this.f19374c = function1;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f19373b.load();
        this.f19374c.a(this.f19373b);
        this.f19373b.save();
        SQLite.update(LinkDataModel.class).set(LinkDataModel_Table.mutations_linkId.eq((Object) this.f19373b.getLinkId())).where(LinkDataModel_Table.linkId.eq((Object) this.f19373b.getLinkId())).execute();
        return Unit.a;
    }
}
