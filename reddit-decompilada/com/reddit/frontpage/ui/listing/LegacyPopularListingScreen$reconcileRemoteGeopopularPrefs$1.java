package com.reddit.frontpage.ui.listing;

import com.google.common.base.Optional;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountPrefs;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.domain.model.Region;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/google/common/base/Optional;", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "kotlin.jvm.PlatformType", "prefs", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AccountPrefs;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$1<T, R> implements Function<T, R> {
    final /* synthetic */ LegacyPopularListingScreen f29046a;

    LegacyPopularListingScreen$reconcileRemoteGeopopularPrefs$1(LegacyPopularListingScreen legacyPopularListingScreen) {
        this.f29046a = legacyPopularListingScreen;
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str;
        AccountPrefs accountPrefs = (AccountPrefs) obj;
        Intrinsics.m26847b(accountPrefs, "prefs");
        Object a = UserSettingsStorage.a().a(FrontpageApplication.m28875k().mo4621i().c());
        Intrinsics.m26843a(a, "UserSettingsStorage.getI…er(manager.activeSession)");
        a.a(accountPrefs);
        if (accountPrefs.geopopular != null) {
            str = accountPrefs.geopopular;
        } else {
            str = Region.DEFAULT.getGeoFilter();
        }
        LegacyPopularListingScreen legacyPopularListingScreen = this.f29046a;
        Intrinsics.m26843a((Object) str, "filter");
        return Optional.b(LegacyPopularListingScreen.m42516a(legacyPopularListingScreen, str));
    }
}
