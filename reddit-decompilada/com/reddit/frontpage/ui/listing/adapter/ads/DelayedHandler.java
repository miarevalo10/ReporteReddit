package com.reddit.frontpage.ui.listing.adapter.ads;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/DelayedHandler;", "Lcom/reddit/frontpage/ui/listing/adapter/ads/Delayer;", "delayTime", "", "(J)V", "handler", "Landroid/os/Handler;", "cancel", "", "runnable", "Ljava/lang/Runnable;", "post", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdImpressionCalculator.kt */
public final class DelayedHandler implements Delayer {
    private final Handler f29122a;
    private final long f29123b;

    private DelayedHandler() {
        this.f29123b = 1000;
        this.f29122a = new Handler();
    }

    public final void mo4997a(Runnable runnable) {
        Intrinsics.m26847b(runnable, "runnable");
        this.f29122a.postDelayed(runnable, this.f29123b);
    }

    public final void mo4998b(Runnable runnable) {
        Intrinsics.m26847b(runnable, "runnable");
        this.f29122a.removeCallbacks(runnable);
    }
}
