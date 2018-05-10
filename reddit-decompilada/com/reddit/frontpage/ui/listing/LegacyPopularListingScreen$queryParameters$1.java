package com.reddit.frontpage.ui.listing;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$queryParameters$1 extends Lambda implements Function0<List<Pair<? extends String, ? extends String>>> {
    final /* synthetic */ LegacyPopularListingScreen f37269a;

    LegacyPopularListingScreen$queryParameters$1(LegacyPopularListingScreen legacyPopularListingScreen) {
        this.f37269a = legacyPopularListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return CollectionsKt__CollectionsKt.m26797c(TuplesKt.m26780a("geo_filter", this.f37269a.geopopularRegionQueryParameterValue));
    }
}
