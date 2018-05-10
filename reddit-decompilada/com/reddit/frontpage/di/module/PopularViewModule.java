package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.RedditAdsActions;
import com.reddit.frontpage.presentation.listing.common.RedditUserLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/di/module/PopularViewModule;", "", "()V", "adsActions", "Lcom/reddit/frontpage/presentation/listing/common/AdsActions;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "navigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "adsNavigator", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PopularViewModule.kt */
public final class PopularViewModule {
    public static UserLinkActions m22362a(ListingNavigator listingNavigator, SessionManager sessionManager, AdsNavigator adsNavigator) {
        Intrinsics.m26847b(listingNavigator, "navigator");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(adsNavigator, "adsNavigator");
        return new RedditUserLinkActions(listingNavigator, sessionManager, adsNavigator);
    }

    public static AdsActions m22361a(FrontpageSettings frontpageSettings) {
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        return new RedditAdsActions(frontpageSettings);
    }
}
