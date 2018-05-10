package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "appInstallAd", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "kotlin.jvm.PlatformType", "onAppInstallAdLoaded"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdMobAdsLoader.kt */
final class RedditAdLoader$createAdLoader$1 implements OnAppInstallAdLoadedListener {
    final /* synthetic */ RedditAdLoader f15777a;

    RedditAdLoader$createAdLoader$1(RedditAdLoader redditAdLoader) {
        this.f15777a = redditAdLoader;
    }

    public final void mo1264a(NativeAppInstallAd nativeAppInstallAd) {
        Function1 a = this.f15777a.f10358l;
        Intrinsics.a(nativeAppInstallAd, "appInstallAd");
        a.a(new NativeAppInstallAdInfo(nativeAppInstallAd));
    }
}
