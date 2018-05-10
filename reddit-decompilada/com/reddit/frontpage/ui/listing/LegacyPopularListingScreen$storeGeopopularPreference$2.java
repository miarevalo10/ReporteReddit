package com.reddit.frontpage.ui.listing;

import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "kotlin.jvm.PlatformType", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$storeGeopopularPreference$2<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ UserComponent f29054a;

    LegacyPopularListingScreen$storeGeopopularPreference$2(UserComponent userComponent) {
        this.f29054a = userComponent;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) obj;
        Intrinsics.m26847b(geopopularRegionSelectFilter, "it");
        return this.f29054a.mo4613a().m22467a(geopopularRegionSelectFilter).toSingle(new Callable<GeopopularRegionSelectFilter>() {
            public final /* bridge */ /* synthetic */ Object call() {
                return geopopularRegionSelectFilter;
            }
        });
    }
}
