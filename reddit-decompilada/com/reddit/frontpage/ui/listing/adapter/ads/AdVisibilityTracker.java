package com.reddit.frontpage.ui.listing.adapter.ads;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\"#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u00060\u0014R\u00020\u00000\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "Lkotlin/Lazy;", "(Lkotlin/Lazy;)V", "MS_BETWEEN_VISIBILITY_CHECKS", "", "clipRect", "Landroid/graphics/Rect;", "handler", "Landroid/os/Handler;", "isVisibilityCheckScheduled", "", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "trackedViews", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$TrackingInfo;", "visibilityCheck", "Lkotlin/Function0;", "", "getVisiblePercentage", "", "view", "registerView", "visibilityListener", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$VisiblityListener;", "scheduleVisibilityCheck", "startTracking", "stopTracking", "unregisterView", "TrackingInfo", "VisiblityListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdVisibilityTracker.kt */
public final class AdVisibilityTracker {
    private final long f21340a;
    private final WeakHashMap<View, TrackingInfo> f21341b;
    private final Rect f21342c;
    private final Handler f21343d;
    private boolean f21344e;
    private final Function0<Unit> f21345f;
    private final OnPreDrawListener f21346g;
    private final Lazy<Activity> f21347h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$TrackingInfo;", "", "visibilityListener", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$VisiblityListener;", "lastPercentShowing", "", "(Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker;Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$VisiblityListener;F)V", "getLastPercentShowing", "()F", "setLastPercentShowing", "(F)V", "getVisibilityListener", "()Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$VisiblityListener;", "setVisibilityListener", "(Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$VisiblityListener;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdVisibilityTracker.kt */
    public final class TrackingInfo {
        VisiblityListener f21336a;
        float f21337b;
        final /* synthetic */ AdVisibilityTracker f21338c;

        private TrackingInfo(VisiblityListener visiblityListener) {
            this.f21338c = visiblityListener;
            this.f21336a = null;
            this.f21337b = null;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/ui/listing/adapter/ads/AdVisibilityTracker$VisiblityListener;", "", "onShowing", "", "percentShowing", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdVisibilityTracker.kt */
    public interface VisiblityListener {
        void mo4955a(float f);
    }

    @Inject
    public AdVisibilityTracker(Lazy<? extends Activity> lazy) {
        Intrinsics.m26847b(lazy, "activity");
        this.f21347h = lazy;
        this.f21340a = 100;
        this.f21341b = new WeakHashMap();
        this.f21342c = new Rect();
        this.f21343d = new Handler();
        this.f21345f = (Function0) new AdVisibilityTracker$visibilityCheck$1(this);
        this.f21346g = (OnPreDrawListener) new AdVisibilityTracker$preDrawListener$1(this);
    }

    public AdVisibilityTracker(final Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        this(LazyKt.m26777a(new Function0<Activity>() {
            public final /* bridge */ /* synthetic */ Object invoke() {
                return activity;
            }
        }));
    }

    public final void m23451a(View view, VisiblityListener visiblityListener) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(visiblityListener, "visibilityListener");
        TrackingInfo trackingInfo = (TrackingInfo) this.f21341b.get(view);
        if (trackingInfo == null) {
            trackingInfo = new TrackingInfo();
            this.f21341b.put(view, trackingInfo);
            m23447c();
        }
        trackingInfo.f21336a = visiblityListener;
        trackingInfo.f21337b = null;
    }

    public final void m23450a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f21341b.remove(view);
    }

    public final void m23449a() {
        Window window = ((Activity) this.f21347h.mo5678b()).getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView == null) {
            Timber.e("Can't start tracking because activity has been released", new Object[0]);
            return;
        }
        Object viewTreeObserver = decorView.getViewTreeObserver();
        Intrinsics.m26843a(viewTreeObserver, "rootView.viewTreeObserver");
        if (viewTreeObserver.isAlive()) {
            decorView.getViewTreeObserver().removeOnPreDrawListener(this.f21346g);
            decorView.getViewTreeObserver().addOnPreDrawListener(this.f21346g);
            return;
        }
        Timber.e("Visibility tracker root view is not alive", new Object[0]);
    }

    public final void m23452b() {
        Window window = ((Activity) this.f21347h.mo5678b()).getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView == null) {
            Timber.e("Can't stop tracking because activity has been released", new Object[0]);
            return;
        }
        decorView.getViewTreeObserver().removeOnPreDrawListener(this.f21346g);
        this.f21341b.clear();
    }

    private final void m23447c() {
        if (!this.f21344e) {
            this.f21344e = true;
            Handler handler = this.f21343d;
            Function0 function0 = this.f21345f;
            if (function0 != null) {
                function0 = new AdVisibilityTrackerKt$sam$Runnable$289a578f(function0);
            }
            handler.postDelayed((Runnable) function0, this.f21340a);
        }
    }

    public static final /* synthetic */ float m23444a(AdVisibilityTracker adVisibilityTracker, View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                if (!view.getGlobalVisibleRect(adVisibilityTracker.f21342c)) {
                    return 0.0f;
                }
                return ((float) (adVisibilityTracker.f21342c.height() * adVisibilityTracker.f21342c.width())) / ((float) (view.getHeight() * view.getWidth()));
            }
        }
        return 0.0f;
    }
}
