package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.google.android.gms.ads.AdListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader$createAdLoader$3", "Lcom/google/android/gms/ads/AdListener;", "(Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/RedditAdLoader;)V", "onAdFailedToLoad", "", "errorCode", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
public final class RedditAdLoader$createAdLoader$3 extends AdListener {
    final /* synthetic */ RedditAdLoader f15779a;

    RedditAdLoader$createAdLoader$3(RedditAdLoader redditAdLoader) {
        this.f15779a = redditAdLoader;
    }

    public final void mo1258a(int i) {
        StringBuilder stringBuilder = new StringBuilder("Error during fetching add. Code=");
        stringBuilder.append(i);
        if (i == 1) {
            Intrinsics.a(stringBuilder, "messageBuilder");
            stringBuilder.append("Invalid dfp request!");
            Intrinsics.a(stringBuilder, "append(value)");
            StringsKt.a(stringBuilder);
        }
        this.f15779a.f10359m.a(new RuntimeException(stringBuilder.toString()));
        Timber.d("Ad failed to load.", new Object[0]);
    }
}
