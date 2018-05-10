package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "afterLocal", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$getAllLinks$fetch$1 extends Lambda implements Function1<String, Maybe<Listing<? extends Link>>> {
    final /* synthetic */ DatabaseLinkDataSource f19365a;
    final /* synthetic */ SortType f19366b;
    final /* synthetic */ SortTimeFrame f19367c;
    final /* synthetic */ ListingType f19368d;
    final /* synthetic */ String f19369e;

    DatabaseLinkDataSource$getAllLinks$fetch$1(DatabaseLinkDataSource databaseLinkDataSource, SortType sortType, SortTimeFrame sortTimeFrame, ListingType listingType, String str) {
        this.f19365a = databaseLinkDataSource;
        this.f19366b = sortType;
        this.f19367c = sortTimeFrame;
        this.f19368d = listingType;
        this.f19369e = str;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object m20624a(Object obj) {
        return this.f19365a.m15958a(this.f19366b, this.f19367c, (String) obj, this.f19368d, this.f19369e);
    }
}
