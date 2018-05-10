package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsLoaderFactory;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.RedditAdsRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.repository.AdsRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/di/module/AdsModule;", "", "()V", "provideAdsLoaderFactory", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsLoaderFactory;", "provideAdsRepo", "Lcom/reddit/frontpage/domain/repository/AdsRepository;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "context", "Landroid/content/Context;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "adsLoaderFactory", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsModule.kt */
public final class AdsModule {
    public static AdsLoaderFactory m22316a() {
        return AdsLoaderFactory.a;
    }

    public static AdsRepository m22317a(FrontpageSettings frontpageSettings, Context context, BackgroundThread backgroundThread, AdsLoaderFactory adsLoaderFactory) {
        Intrinsics.m26847b(frontpageSettings, "settings");
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(adsLoaderFactory, "adsLoaderFactory");
        return new RedditAdsRepository(frontpageSettings, context, backgroundThread, adsLoaderFactory);
    }
}
