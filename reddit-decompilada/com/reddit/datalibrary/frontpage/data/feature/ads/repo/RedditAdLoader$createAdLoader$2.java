package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "contentAd", "Lcom/google/android/gms/ads/formats/NativeContentAd;", "kotlin.jvm.PlatformType", "onContentAdLoaded"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
final class RedditAdLoader$createAdLoader$2 implements OnContentAdLoadedListener {
    final /* synthetic */ RedditAdLoader f15778a;

    RedditAdLoader$createAdLoader$2(RedditAdLoader redditAdLoader) {
        this.f15778a = redditAdLoader;
    }

    public final void mo1265a(NativeContentAd nativeContentAd) {
        Function1 a = this.f15778a.f10358l;
        Intrinsics.a(nativeContentAd, "contentAd");
        a.a(new NativeContentAdInfo(nativeContentAd));
    }
}
