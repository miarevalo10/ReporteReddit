package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.AdsConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012 \u0003*\b\u0018\u00010\u0001R\u00020\u00020\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration$AdsConfiguration;", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdsActions.kt */
final class RedditAdsActions$adConfig$2 extends Lambda implements Function0<AdsConfiguration> {
    final /* synthetic */ RedditAdsActions f36566a;

    RedditAdsActions$adConfig$2(RedditAdsActions redditAdsActions) {
        this.f36566a = redditAdsActions;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object t = this.f36566a.f28283j.t();
        Intrinsics.m26843a(t, "frontpageSettings.appConfig");
        return t.a();
    }
}
