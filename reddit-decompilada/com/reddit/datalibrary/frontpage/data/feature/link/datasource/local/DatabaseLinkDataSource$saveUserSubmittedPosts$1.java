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
final class DatabaseLinkDataSource$saveUserSubmittedPosts$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DatabaseLinkDataSource f19385a;
    final /* synthetic */ Listing f19386b;
    final /* synthetic */ SortType f19387c;
    final /* synthetic */ SortTimeFrame f19388d;
    final /* synthetic */ String f19389e;
    final /* synthetic */ String f19390f;

    DatabaseLinkDataSource$saveUserSubmittedPosts$1(DatabaseLinkDataSource databaseLinkDataSource, Listing listing, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2) {
        this.f19385a = databaseLinkDataSource;
        this.f19386b = listing;
        this.f19387c = sortType;
        this.f19388d = sortTimeFrame;
        this.f19389e = str;
        this.f19390f = str2;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        this.f19385a.m15965a(this.f19386b, this.f19387c, this.f19388d, this.f19389e, ListingType.c, this.f19390f);
        return Unit.a;
    }
}
