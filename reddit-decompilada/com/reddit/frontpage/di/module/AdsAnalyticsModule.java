package com.reddit.frontpage.di.module;

import android.app.Activity;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/di/module/AdsAnalyticsModule;", "", "()V", "adsVisibilityTracker", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;", "activity", "Lkotlin/Lazy;", "Landroid/app/Activity;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsAnalyticsModule.kt */
public final class AdsAnalyticsModule {
    public static AdVisibilityTracker m22315a(Lazy<? extends Activity> lazy) {
        Intrinsics.m26847b(lazy, "activity");
        return new AdVisibilityTracker((Lazy) lazy);
    }
}
