package com.reddit.frontpage.util;

import android.app.Activity;
import android.content.IntentFilter;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.kotlin.ActivityLifecycleCallbacksSimple;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"com/reddit/frontpage/util/NetworkUtil$init$1", "Lcom/reddit/frontpage/util/kotlin/ActivityLifecycleCallbacksSimple;", "(Lcom/reddit/frontpage/FrontpageApplication;)V", "activitiesActive", "", "getActivitiesActive", "()I", "setActivitiesActive", "(I)V", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "registerReceiver", "Lcom/reddit/frontpage/util/NetworkUtil$NetworkConnectivityReceiver;", "getRegisterReceiver", "()Lcom/reddit/frontpage/util/NetworkUtil$NetworkConnectivityReceiver;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "onActivityStopped", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NetworkUtil.kt */
public final class NetworkUtil$init$1 extends ActivityLifecycleCallbacksSimple {
    final /* synthetic */ FrontpageApplication f29393a;
    private final IntentFilter f29394b = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    private final NetworkConnectivityReceiver f29395c = new NetworkConnectivityReceiver();
    private int f29396d;

    NetworkUtil$init$1(FrontpageApplication frontpageApplication) {
        this.f29393a = frontpageApplication;
    }

    public final void onActivityStarted(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        if (this.f29396d == null) {
            this.f29393a.registerReceiver(this.f29395c, this.f29394b);
            activity = NetworkUtil.f21762a;
            NetworkUtil.m23841b(this.f29393a);
        }
        this.f29396d++;
    }

    public final void onActivityStopped(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        this.f29396d--;
        if (this.f29396d == null) {
            this.f29393a.unregisterReceiver(this.f29395c);
        }
    }
}
