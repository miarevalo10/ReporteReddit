package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.zzf;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbm implements Callback {
    public static final Status f5774a = new Status(4, "Sign-out occurred while this API call was in progress.");
    static final Object f5775b = new Object();
    private static final Status f5776j = new Status(4, "The user must be signed in to make this API call.");
    private static zzbm f5777n;
    final Context f5778c;
    public final AtomicInteger f5779d = new AtomicInteger(1);
    public final AtomicInteger f5780e = new AtomicInteger(0);
    final Map<zzh<?>, zzbo<?>> f5781f = new ConcurrentHashMap(5, 0.75f, 1);
    zzah f5782g = null;
    final Set<zzh<?>> f5783h = new ArraySet();
    public final Handler f5784i;
    private long f5785k = 5000;
    private long f5786l = 120000;
    private long f5787m = 10000;
    private final GoogleApiAvailability f5788o;
    private int f5789p = -1;
    private final Set<zzh<?>> f5790q = new ArraySet();

    private zzbm(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f5778c = context;
        this.f5784i = new Handler(looper, this);
        this.f5788o = googleApiAvailability;
        this.f5784i.sendMessage(this.f5784i.obtainMessage(6));
    }

    public static zzbm m4710a() {
        zzbm com_google_android_gms_common_api_internal_zzbm;
        synchronized (f5775b) {
            zzbq.m4809a(f5777n, (Object) "Must guarantee manager is non-null before using getInstance");
            com_google_android_gms_common_api_internal_zzbm = f5777n;
        }
        return com_google_android_gms_common_api_internal_zzbm;
    }

    public static zzbm m4711a(Context context) {
        zzbm com_google_android_gms_common_api_internal_zzbm;
        synchronized (f5775b) {
            if (f5777n == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f5777n = new zzbm(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.m12790a());
            }
            com_google_android_gms_common_api_internal_zzbm = f5777n;
        }
        return com_google_android_gms_common_api_internal_zzbm;
    }

    public static void m4713b() {
        synchronized (f5775b) {
            if (f5777n != null) {
                zzbm com_google_android_gms_common_api_internal_zzbm = f5777n;
                com_google_android_gms_common_api_internal_zzbm.f5780e.incrementAndGet();
                com_google_android_gms_common_api_internal_zzbm.f5784i.sendMessageAtFrontOfQueue(com_google_android_gms_common_api_internal_zzbm.f5784i.obtainMessage(10));
            }
        }
    }

    private final void m4714b(GoogleApi<?> googleApi) {
        zzh zzagn = googleApi.zzagn();
        zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) this.f5781f.get(zzagn);
        if (com_google_android_gms_common_api_internal_zzbo == null) {
            com_google_android_gms_common_api_internal_zzbo = new zzbo(this, googleApi);
            this.f5781f.put(zzagn, com_google_android_gms_common_api_internal_zzbo);
        }
        if (com_google_android_gms_common_api_internal_zzbo.m17634h()) {
            this.f5790q.add(zzagn);
        }
        com_google_android_gms_common_api_internal_zzbo.m17632f();
    }

    private final void m4721f() {
        for (zzh remove : this.f5790q) {
            ((zzbo) this.f5781f.remove(remove)).m17621a();
        }
        this.f5790q.clear();
    }

    public final void m4727a(GoogleApi<?> googleApi) {
        this.f5784i.sendMessage(this.f5784i.obtainMessage(7, googleApi));
    }

    public final void m4730b(ConnectionResult connectionResult, int i) {
        if (!m4729a(connectionResult, i)) {
            this.f5784i.sendMessage(this.f5784i.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void m4731c() {
        this.f5784i.sendMessage(this.f5784i.obtainMessage(3));
    }

    public final void m4728a(zzah com_google_android_gms_common_api_internal_zzah) {
        synchronized (f5775b) {
            if (this.f5782g != com_google_android_gms_common_api_internal_zzah) {
                this.f5782g = com_google_android_gms_common_api_internal_zzah;
                this.f5783h.clear();
                this.f5783h.addAll(com_google_android_gms_common_api_internal_zzah.f17274b);
            }
        }
    }

    public final Task<Map<zzh<?>, String>> m4726a(Iterable<? extends GoogleApi<?>> iterable) {
        zzj com_google_android_gms_common_api_internal_zzj = new zzj(iterable);
        for (GoogleApi googleApi : iterable) {
            zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) this.f5781f.get(googleApi.zzagn());
            if (com_google_android_gms_common_api_internal_zzbo != null) {
                if (com_google_android_gms_common_api_internal_zzbo.m17633g()) {
                    com_google_android_gms_common_api_internal_zzj.m4768a(googleApi.zzagn(), ConnectionResult.f17256a, com_google_android_gms_common_api_internal_zzbo.f17291a.m12816j());
                }
            }
            this.f5784i.sendMessage(this.f5784i.obtainMessage(2, com_google_android_gms_common_api_internal_zzj));
            return com_google_android_gms_common_api_internal_zzj.f5844b.f8211a;
        }
        return com_google_android_gms_common_api_internal_zzj.f5844b.f8211a;
    }

    public final boolean handleMessage(Message message) {
        long j = 300000;
        boolean z = false;
        zzbo com_google_android_gms_common_api_internal_zzbo;
        zzbo com_google_android_gms_common_api_internal_zzbo2;
        StringBuilder stringBuilder;
        zzbo com_google_android_gms_common_api_internal_zzbo3;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue() != null) {
                    j = 10000;
                }
                this.f5787m = j;
                this.f5784i.removeMessages(12);
                for (zzh obtainMessage : this.f5781f.keySet()) {
                    this.f5784i.sendMessageDelayed(this.f5784i.obtainMessage(12, obtainMessage), this.f5787m);
                }
                break;
            case 2:
                zzj com_google_android_gms_common_api_internal_zzj = (zzj) message.obj;
                for (zzh obtainMessage2 : com_google_android_gms_common_api_internal_zzj.f5843a.keySet()) {
                    com_google_android_gms_common_api_internal_zzbo = (zzbo) this.f5781f.get(obtainMessage2);
                    if (com_google_android_gms_common_api_internal_zzbo == null) {
                        com_google_android_gms_common_api_internal_zzj.m4768a(obtainMessage2, new ConnectionResult(13), null);
                        break;
                    } else if (com_google_android_gms_common_api_internal_zzbo.m17633g()) {
                        com_google_android_gms_common_api_internal_zzj.m4768a(obtainMessage2, ConnectionResult.f17256a, com_google_android_gms_common_api_internal_zzbo.f17291a.m12816j());
                    } else if (com_google_android_gms_common_api_internal_zzbo.m17629c() != null) {
                        com_google_android_gms_common_api_internal_zzj.m4768a(obtainMessage2, com_google_android_gms_common_api_internal_zzbo.m17629c(), null);
                    } else {
                        zzbq.m4812a(com_google_android_gms_common_api_internal_zzbo.f17298h.f5784i);
                        com_google_android_gms_common_api_internal_zzbo.f17293c.add(com_google_android_gms_common_api_internal_zzj);
                    }
                }
                break;
            case 3:
                for (zzbo com_google_android_gms_common_api_internal_zzbo22 : this.f5781f.values()) {
                    com_google_android_gms_common_api_internal_zzbo22.m17628b();
                    com_google_android_gms_common_api_internal_zzbo22.m17632f();
                }
                break;
            case 4:
            case 8:
            case 13:
                zzcp com_google_android_gms_common_api_internal_zzcp = (zzcp) message.obj;
                com_google_android_gms_common_api_internal_zzbo22 = (zzbo) this.f5781f.get(com_google_android_gms_common_api_internal_zzcp.f5819c.zzagn());
                if (com_google_android_gms_common_api_internal_zzbo22 == null) {
                    m4714b(com_google_android_gms_common_api_internal_zzcp.f5819c);
                    com_google_android_gms_common_api_internal_zzbo22 = (zzbo) this.f5781f.get(com_google_android_gms_common_api_internal_zzcp.f5819c.zzagn());
                }
                if (com_google_android_gms_common_api_internal_zzbo22.m17634h() && this.f5780e.get() != com_google_android_gms_common_api_internal_zzcp.f5818b) {
                    com_google_android_gms_common_api_internal_zzcp.f5817a.mo1584a(f5774a);
                    com_google_android_gms_common_api_internal_zzbo22.m17621a();
                    break;
                }
                com_google_android_gms_common_api_internal_zzbo22.m17627a(com_google_android_gms_common_api_internal_zzcp.f5817a);
                break;
                break;
            case 5:
                String b;
                StringBuilder stringBuilder2;
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zzbo com_google_android_gms_common_api_internal_zzbo4 : this.f5781f.values()) {
                    if (com_google_android_gms_common_api_internal_zzbo4.f17295e == i) {
                        if (com_google_android_gms_common_api_internal_zzbo4 != null) {
                            stringBuilder = new StringBuilder(76);
                            stringBuilder.append("Could not find API instance ");
                            stringBuilder.append(i);
                            stringBuilder.append(" while trying to fail enqueued calls.");
                            Log.wtf("GoogleApiManager", stringBuilder.toString(), new Exception());
                            break;
                        }
                        b = this.f5788o.mo1540b(connectionResult.f17257b);
                        message = connectionResult.f17259d;
                        stringBuilder2 = new StringBuilder((69 + String.valueOf(b).length()) + String.valueOf(message).length());
                        stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                        stringBuilder2.append(b);
                        stringBuilder2.append(": ");
                        stringBuilder2.append(message);
                        com_google_android_gms_common_api_internal_zzbo4.m17626a(new Status(17, stringBuilder2.toString()));
                        break;
                    }
                }
                com_google_android_gms_common_api_internal_zzbo4 = null;
                if (com_google_android_gms_common_api_internal_zzbo4 != null) {
                    stringBuilder = new StringBuilder(76);
                    stringBuilder.append("Could not find API instance ");
                    stringBuilder.append(i);
                    stringBuilder.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", stringBuilder.toString(), new Exception());
                } else {
                    b = this.f5788o.mo1540b(connectionResult.f17257b);
                    message = connectionResult.f17259d;
                    stringBuilder2 = new StringBuilder((69 + String.valueOf(b).length()) + String.valueOf(message).length());
                    stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                    stringBuilder2.append(b);
                    stringBuilder2.append(": ");
                    stringBuilder2.append(message);
                    com_google_android_gms_common_api_internal_zzbo4.m17626a(new Status(17, stringBuilder2.toString()));
                }
            case 6:
                if ((this.f5778c.getApplicationContext() instanceof Application) != null) {
                    zzk.m4770a((Application) this.f5778c.getApplicationContext());
                    zzk.m4769a().m4772a(new zzbn(this));
                    message = zzk.m4769a();
                    if (!message.f5850b.get()) {
                        if (!zzq.m4910b()) {
                            message = 1;
                            if (message == null) {
                                this.f5787m = 300000;
                                break;
                            }
                        }
                        RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!message.f5850b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            message.f5849a.set(true);
                        }
                    }
                    message = message.f5849a.get();
                    if (message == null) {
                        this.f5787m = 300000;
                    }
                }
                break;
            case 7:
                m4714b((GoogleApi) message.obj);
                break;
            case 9:
                if (this.f5781f.containsKey(message.obj)) {
                    com_google_android_gms_common_api_internal_zzbo3 = (zzbo) this.f5781f.get(message.obj);
                    zzbq.m4812a(com_google_android_gms_common_api_internal_zzbo3.f17298h.f5784i);
                    if (com_google_android_gms_common_api_internal_zzbo3.f17297g) {
                        com_google_android_gms_common_api_internal_zzbo3.m17632f();
                        break;
                    }
                }
                break;
            case 10:
                m4721f();
                break;
            case 11:
                if (this.f5781f.containsKey(message.obj)) {
                    com_google_android_gms_common_api_internal_zzbo3 = (zzbo) this.f5781f.get(message.obj);
                    zzbq.m4812a(com_google_android_gms_common_api_internal_zzbo3.f17298h.f5784i);
                    if (com_google_android_gms_common_api_internal_zzbo3.f17297g) {
                        com_google_android_gms_common_api_internal_zzbo3.m17630d();
                        com_google_android_gms_common_api_internal_zzbo3.m17626a(com_google_android_gms_common_api_internal_zzbo3.f17298h.f5788o.mo1537a(com_google_android_gms_common_api_internal_zzbo3.f17298h.f5778c) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                        com_google_android_gms_common_api_internal_zzbo3.f17291a.mo4292e();
                        break;
                    }
                }
                break;
            case 12:
                if (this.f5781f.containsKey(message.obj)) {
                    com_google_android_gms_common_api_internal_zzbo3 = (zzbo) this.f5781f.get(message.obj);
                    zzbq.m4812a(com_google_android_gms_common_api_internal_zzbo3.f17298h.f5784i);
                    if (com_google_android_gms_common_api_internal_zzbo3.f17291a.m12812f() && com_google_android_gms_common_api_internal_zzbo3.f17294d.size() == 0) {
                        zzae com_google_android_gms_common_api_internal_zzae = com_google_android_gms_common_api_internal_zzbo3.f17292b;
                        if (!(com_google_android_gms_common_api_internal_zzae.f5766a.isEmpty() && com_google_android_gms_common_api_internal_zzae.f5767b.isEmpty())) {
                            z = true;
                        }
                        if (!z) {
                            com_google_android_gms_common_api_internal_zzbo3.f17291a.mo4292e();
                            break;
                        }
                        com_google_android_gms_common_api_internal_zzbo3.m17631e();
                        break;
                    }
                }
                break;
            default:
                message = message.what;
                stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(message);
                Log.w("GoogleApiManager", stringBuilder.toString());
                return false;
        }
        return true;
    }

    final boolean m4729a(ConnectionResult connectionResult, int i) {
        PendingIntent pendingIntent;
        zzf com_google_android_gms_common_zzf = this.f5788o;
        Context context = this.f5778c;
        if (connectionResult.m17583a()) {
            pendingIntent = connectionResult.f17258c;
        } else {
            pendingIntent = com_google_android_gms_common_zzf.mo1538a(context, connectionResult.f17257b, 0);
        }
        if (pendingIntent == null) {
            return false;
        }
        com_google_android_gms_common_zzf.m12800a(context, connectionResult.f17257b, GoogleApiActivity.m4634a(context, pendingIntent, i));
        return true;
    }
}
