package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdLoader;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdLoader.C17382;
import com.reddit.frontpage.FrontpageApplication;
import java.util.List;
import timber.log.Timber;

final /* synthetic */ class AdsRepository$NativeAdLoader$$Lambda$0 implements OnAppInstallAdLoadedListener {
    private final NativeAdLoader f15770a;

    AdsRepository$NativeAdLoader$$Lambda$0(NativeAdLoader nativeAdLoader) {
        this.f15770a = nativeAdLoader;
    }

    public final void mo1264a(NativeAppInstallAd nativeAppInstallAd) {
        NativeAdLoader nativeAdLoader = this.f15770a;
        Timber.b("App install ad loaded", new Object[0]);
        if (!nativeAdLoader.f10333b) {
            List c = nativeAppInstallAd.mo3548c();
            Uri b = !c.isEmpty() ? ((Image) c.get(0)).mo2095b() : null;
            if (b != null) {
                GlideApp.m8727a(FrontpageApplication.a).m19651h().load(b).into(new C17382(nativeAdLoader, nativeAppInstallAd));
                return;
            }
            nativeAdLoader.m8799a(nativeAppInstallAd, -1.0f);
        }
    }
}
