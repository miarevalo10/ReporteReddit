package com.reddit.frontpage.presentation.analytics;

import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent;
import com.reddit.frontpage.domain.usecase.AdsPixelParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/reddit/frontpage/presentation/analytics/RedditAdsAnalytics$sendAdEvent$1", "Lcom/reddit/frontpage/domain/usecase/AdsPixelParams;", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/AdEvent;)V", "pixelUrl", "", "getPixelUrl", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAdsAnalytics.kt */
public final class RedditAdsAnalytics$sendAdEvent$1 implements AdsPixelParams {
    final /* synthetic */ AdEvent f33779a;

    RedditAdsAnalytics$sendAdEvent$1(AdEvent adEvent) {
        this.f33779a = adEvent;
    }

    public final String mo6432a() {
        String url = this.f33779a.getUrl();
        if (url == null) {
            Intrinsics.m26842a();
        }
        return url;
    }
}
