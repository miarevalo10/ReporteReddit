package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$saveFrontpageLinks$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DatabaseLinkDataSource f19375a;
    final /* synthetic */ Listing f19376b;
    final /* synthetic */ SortType f19377c;
    final /* synthetic */ SortTimeFrame f19378d;
    final /* synthetic */ String f19379e;

    DatabaseLinkDataSource$saveFrontpageLinks$1(DatabaseLinkDataSource databaseLinkDataSource, Listing listing, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        this.f19375a = databaseLinkDataSource;
        this.f19376b = listing;
        this.f19377c = sortType;
        this.f19378d = sortTimeFrame;
        this.f19379e = str;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f19375a.m15965a(this.f19376b, this.f19377c, this.f19378d, this.f19379e, ListingType.a, null);
        return Unit.a;
    }
}
