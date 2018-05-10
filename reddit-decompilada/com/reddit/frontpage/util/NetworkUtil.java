package com.reddit.frontpage.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21ServicesKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR2\u0010\r\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00040\u0004 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u00118FX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0010\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00118FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/util/NetworkUtil;", "", "()V", "connectivity", "Lcom/reddit/frontpage/util/Connectivity;", "connectivity$annotations", "getConnectivity", "()Lcom/reddit/frontpage/util/Connectivity;", "connectivityObservable", "Lio/reactivex/Observable;", "connectivityObservable$annotations", "getConnectivityObservable", "()Lio/reactivex/Observable;", "connectivitySubject", "Lio/reactivex/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "isInternetConnected", "", "isInternetConnected$annotations", "()Z", "isUnmetered", "isUnmetered$annotations", "context", "Landroid/content/Context;", "init", "", "updateNetworkState", "NetworkConnectivityReceiver", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NetworkUtil.kt */
public final class NetworkUtil {
    public static final NetworkUtil f21762a = new NetworkUtil();
    private static final BehaviorSubject<Connectivity> f21763b;
    private static final Observable<Connectivity> f21764c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/util/NetworkUtil$NetworkConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: NetworkUtil.kt */
    private static final class NetworkConnectivityReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            Intrinsics.m26847b(context, "context");
            Intrinsics.m26847b(intent, "intent");
            if (Intrinsics.m26845a(intent.getAction(), (Object) "android.net.conn.CONNECTIVITY_CHANGE") != null) {
                intent = NetworkUtil.f21762a;
                NetworkUtil.m23841b(context);
            }
        }
    }

    static {
        Object a = BehaviorSubject.m38175a();
        f21763b = a;
        Intrinsics.m26843a(a, "connectivitySubject");
        f21764c = (Observable) a;
    }

    private NetworkUtil() {
    }

    private static Connectivity m23845e() {
        Object obj = f21763b;
        Intrinsics.m26843a(obj, "connectivitySubject");
        Connectivity connectivity = (Connectivity) obj.m38179b();
        if (connectivity != null) {
            return connectivity;
        }
        obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        return m23841b((Context) obj);
    }

    public static final Observable<Connectivity> m23840a() {
        return f21764c;
    }

    public static final boolean m23842b() {
        return m23845e().f21708a;
    }

    public static final boolean m23843c() {
        return m23845e().f21709b;
    }

    public static final void m23844d() {
        FrontpageApplication frontpageApplication = FrontpageApplication.f27402a;
        if (frontpageApplication != null) {
            frontpageApplication.registerActivityLifecycleCallbacks(new NetworkUtil$init$1(frontpageApplication));
        } else {
            Timber.e("NetworkUtil initialized but no application instance available", new Object[0]);
        }
    }

    private static Connectivity m23841b(Context context) {
        context = Sdk21ServicesKt.m28415a(context);
        NetworkInfo activeNetworkInfo = context.getActiveNetworkInfo();
        Connectivity connectivity = new Connectivity(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false, ConnectivityManagerCompat.a(context) ^ 1);
        f21763b.onNext(connectivity);
        return connectivity;
    }
}
