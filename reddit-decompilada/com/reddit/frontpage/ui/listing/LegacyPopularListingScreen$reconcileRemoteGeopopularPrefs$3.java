package com.reddit.frontpage.ui.listing;

import com.google.common.base.Optional;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "optionalFilter", "Lcom/google/common/base/Optional;", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$3<T> implements Consumer<Optional<GeopopularRegionSelectFilter>> {
    final /* synthetic */ LegacyPopularListingScreen f29048a;

    LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$3(LegacyPopularListingScreen legacyPopularListingScreen) {
        this.f29048a = legacyPopularListingScreen;
    }

    public final /* synthetic */ void accept(Object obj) {
        GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) ((Optional) obj).d();
        if (geopopularRegionSelectFilter != null) {
            String str = geopopularRegionSelectFilter.f20534a;
            String str2 = geopopularRegionSelectFilter.f20535b;
            if ((Intrinsics.m26845a(geopopularRegionSelectFilter.f20535b, this.f29048a.geopopularRegionName) ^ 1) != 0) {
                LegacyPopularListingScreen legacyPopularListingScreen = this.f29048a;
                Intrinsics.m26843a((Object) geopopularRegionSelectFilter, "select");
                legacyPopularListingScreen.m42518a(geopopularRegionSelectFilter);
            }
            this.f29048a.m42536a(str);
            this.f29048a.m42538b(str2);
        }
    }
}
