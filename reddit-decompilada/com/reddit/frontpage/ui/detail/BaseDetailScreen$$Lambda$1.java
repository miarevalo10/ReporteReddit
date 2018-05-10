package com.reddit.frontpage.ui.detail;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class BaseDetailScreen$$Lambda$1 implements Function1 {
    private final BaseDetailScreen f34233a;

    BaseDetailScreen$$Lambda$1(BaseDetailScreen baseDetailScreen) {
        this.f34233a = baseDetailScreen;
    }

    public final Object mo6492a(Object obj) {
        Link link = (Link) obj;
        Context am_ = this.f34233a.am_();
        if (am_ != null) {
            RedditAdsAnalytics.m22651a(am_, link, 7);
        }
        return Unit.f25273a;
    }
}
