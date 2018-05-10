package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdLoader;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdLoader.C17393;
import com.reddit.frontpage.FrontpageApplication;
import java.util.List;
import timber.log.Timber;

final /* synthetic */ class AdsRepository$NativeAdLoader$$Lambda$1 implements OnContentAdLoadedListener {
    private final NativeAdLoader f15771a;

    AdsRepository$NativeAdLoader$$Lambda$1(NativeAdLoader nativeAdLoader) {
        this.f15771a = nativeAdLoader;
    }

    public final void mo1265a(NativeContentAd nativeContentAd) {
        NativeAdLoader nativeAdLoader = this.f15771a;
        Timber.b("Content ad loaded", new Object[0]);
        if (!nativeAdLoader.f10333b) {
            List c = nativeContentAd.mo3558c();
            Uri b = !c.isEmpty() ? ((Image) c.get(0)).mo2095b() : null;
            if (b != null) {
                GlideApp.m8727a(FrontpageApplication.a).m19651h().load(b).into(new C17393(nativeAdLoader, nativeContentAd));
                return;
            }
            nativeAdLoader.m8800a(nativeContentAd, -1.0f);
        }
    }
}
