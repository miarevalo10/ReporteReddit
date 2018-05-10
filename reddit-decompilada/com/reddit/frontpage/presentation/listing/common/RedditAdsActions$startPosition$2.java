package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.AdsConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdsActions.kt */
final class RedditAdsActions$startPosition$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ RedditAdsActions f36568a;

    RedditAdsActions$startPosition$2(RedditAdsActions redditAdsActions) {
        this.f36568a = redditAdsActions;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return Integer.valueOf(((AdsConfiguration) this.f36568a.f28276c.mo5678b()).b());
    }
}
