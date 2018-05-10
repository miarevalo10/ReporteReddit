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
final class DatabaseLinkDataSource$savePopularLinks$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DatabaseLinkDataSource f19380a;
    final /* synthetic */ Listing f19381b;
    final /* synthetic */ SortType f19382c;
    final /* synthetic */ SortTimeFrame f19383d;
    final /* synthetic */ String f19384e;

    DatabaseLinkDataSource$savePopularLinks$1(DatabaseLinkDataSource databaseLinkDataSource, Listing listing, SortType sortType, SortTimeFrame sortTimeFrame, String str) {
        this.f19380a = databaseLinkDataSource;
        this.f19381b = listing;
        this.f19382c = sortType;
        this.f19383d = sortTimeFrame;
        this.f19384e = str;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f19380a.m15965a(this.f19381b, this.f19382c, this.f19383d, this.f19384e, ListingType.b, null);
        return Unit.a;
    }
}
