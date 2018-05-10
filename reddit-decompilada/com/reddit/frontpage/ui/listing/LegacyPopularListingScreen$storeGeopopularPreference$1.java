package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "it", "", "Lcom/reddit/frontpage/domain/model/Region;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$storeGeopopularPreference$1<T, R> implements Function<T, R> {
    final /* synthetic */ LegacyPopularListingScreen f29052a;
    final /* synthetic */ String f29053b;

    LegacyPopularListingScreen$storeGeopopularPreference$1(LegacyPopularListingScreen legacyPopularListingScreen, String str) {
        this.f29052a = legacyPopularListingScreen;
        this.f29053b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        return new GeopopularRegionSelectFilter(this.f29053b, LegacyPopularListingScreen.m42517a(list, this.f29053b));
    }
}
