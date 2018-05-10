package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.RedditUserLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/di/module/OnboardingListingViewModule;", "", "()V", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "navigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "adsNavigator", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingViewModule.kt */
public final class OnboardingListingViewModule {
    public static UserLinkActions m22360a(ListingNavigator listingNavigator, SessionManager sessionManager, AdsNavigator adsNavigator) {
        Intrinsics.m26847b(listingNavigator, "navigator");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(adsNavigator, "adsNavigator");
        return new RedditUserLinkActions(listingNavigator, sessionManager, adsNavigator);
    }
}
