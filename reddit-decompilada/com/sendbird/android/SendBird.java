package com.sendbird.android;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.sendbird.android.APIClient.APIClientHandler;
import com.sendbird.android.Command.SendCommandHandler;
import com.sendbird.android.CountDownTimer.CountDownTimerEventHandler;
import com.sendbird.android.WSClient.WSClientHandler;
import com.sendbird.android.WSClient.WSClientSendHandler;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class SendBird {
    static final BuildConfig f22816a = BuildConfig.RELEASE;
    static String f22817b;
    static String f22818c;
    private static SendBird f22819h;
    private static final Handler f22820i = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<String, ConnectionHandler> f22821A = new ConcurrentHashMap();
    private final LinkedHashSet<ConnectHandler> f22822B = new LinkedHashSet();
    private ApplicationStateHandler f22823C;
    private boolean f22824D = true;
    private boolean f22825E = true;
    private boolean f22826F = false;
    private final Object f22827G;
    private ConnectivityManager f22828H;
    private NetworkReceiver f22829I;
    final ConcurrentHashMap<String, ChannelHandler> f22830d = new ConcurrentHashMap();
    final ConcurrentHashMap<String, Object> f22831e = new ConcurrentHashMap();
    String f22832f;
    String f22833g;
    private String f22834j;
    private final Context f22835k;
    private WSClient f22836l;
    private User f22837m;
    private int f22838n = 0;
    private int f22839o;
    private boolean f22840p = false;
    private CountDownTimer f22841q;
    private CountDownTimer f22842r;
    private CountDownTimer f22843s;
    private SendBirdException f22844t;
    private final Object f22845u = new Object();
    private final Object f22846v = new Object();
    private final Object f22847w = new Object();
    private final Object f22848x = new Object();
    private final Object f22849y = new Object();
    private final HashMap<String, HashMap<String, Object>> f22850z = new HashMap();

    class C19941 implements ActivityLifecycleCallbacks {
        final /* synthetic */ SendBird f22724a;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        C19941(SendBird sendBird) {
            this.f22724a = sendBird;
        }

        public void onActivityResumed(Activity activity) {
            if (this.f22724a.f22823C != null) {
                StringBuilder stringBuilder = new StringBuilder("onActivityResumed: ");
                stringBuilder.append(activity.getPackageName());
                stringBuilder.append(":");
                stringBuilder.append(activity.getLocalClassName());
                Logger.m24934b(stringBuilder.toString());
                this.f22724a.f22823C.mo5234c();
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f22724a.f22823C != null) {
                StringBuilder stringBuilder = new StringBuilder("onActivityPaused: ");
                stringBuilder.append(activity.getPackageName());
                stringBuilder.append(":");
                stringBuilder.append(activity.getLocalClassName());
                Logger.m24934b(stringBuilder.toString());
                this.f22724a.f22823C.mo5235d();
            }
        }
    }

    private static abstract class ApplicationStateHandler {
        abstract void mo5232a();

        abstract void mo5233b();

        abstract void mo5234c();

        abstract void mo5235d();

        private ApplicationStateHandler() {
        }
    }

    enum BuildConfig {
        DEBUG,
        CI,
        RELEASE
    }

    public static abstract class ChannelHandler {
        public void mo4504a(BaseChannel baseChannel) {
        }

        public abstract void mo4494a(BaseChannel baseChannel, BaseMessage baseMessage);

        public void mo4495a(GroupChannel groupChannel) {
        }

        public void mo4505a(GroupChannel groupChannel, User user, List<User> list) {
        }
    }

    public interface ConnectHandler {
        void mo4559a(User user, SendBirdException sendBirdException);
    }

    public interface ConnectionHandler {
        void mo4556a();

        void mo4557b();

        void mo4558c();
    }

    public enum ConnectionState {
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    private class NetworkReceiver extends BroadcastReceiver {
        final /* synthetic */ SendBird f22813a;
        private boolean f22814b;

        private NetworkReceiver(SendBird sendBird) {
            this.f22813a = sendBird;
            this.f22814b = null;
        }

        public void onReceive(Context context, Intent intent) {
            context = this.f22813a.f22828H.getActiveNetworkInfo();
            if (context == null || context.isConnected() == null) {
                if (context == null) {
                    this.f22814b = true;
                }
            } else if (this.f22814b != null) {
                this.f22814b = null;
                try {
                    if (SendBird.m24994g() != null) {
                        SendBird.m24998i();
                    }
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        }
    }

    public static class Options {
        static boolean f22815a;
    }

    public interface UserBlockHandler {
        void mo4487a(SendBirdException sendBirdException);
    }

    class C24092 implements CountDownTimerEventHandler {
        long f30134a = 0;
        final /* synthetic */ SendBird f30135b;

        public final void mo5221a() {
        }

        public final void mo5223b() {
        }

        public final void mo5224c() {
        }

        public final void mo5225d() {
        }

        C24092(SendBird sendBird) {
            this.f30135b = sendBird;
        }

        public final void mo5222a(int i, int i2) {
            this.f30134a++;
            if (this.f30134a % 10 == 0 && GroupChannel.f30084g != 0) {
                for (final GroupChannel groupChannel : GroupChannel.f30084g.values()) {
                    if (groupChannel.m30990t()) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ C24092 f22726b;

                            public void run() {
                                for (ChannelHandler a : this.f22726b.f30135b.f22830d.values()) {
                                    a.mo4495a(groupChannel);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    static class C24103 extends ApplicationStateHandler {
        boolean f30136a;
        boolean f30137b;
        Handler f30138c;
        Thread f30139d = new C19961(this);
        Runnable f30140e = new C19972(this);
        Runnable f30141f = new C19983(this);

        class C19961 extends Thread {
            final /* synthetic */ C24103 f22727a;

            C19961(C24103 c24103) {
                this.f22727a = c24103;
            }

            public void run() {
                Looper.prepare();
                this.f22727a.f30138c = new Handler();
                Looper.loop();
            }
        }

        class C19972 implements Runnable {
            final /* synthetic */ C24103 f22728a;

            C19972(C24103 c24103) {
                this.f22728a = c24103;
            }

            public void run() {
                if (this.f22728a.f30136a) {
                    Logger.m24934b("Application is on foreground.");
                    this.f22728a.f30136a = false;
                    if (SendBird.m24995h() == ConnectionState.CLOSED && this.f22728a.f30137b && SendBird.f22819h.f22837m != null) {
                        boolean z = SendBird.f22819h.f22839o == 0;
                        SendBird.m24985c(false);
                        SendBird.m24984c(SendBird.f22819h.f22837m.f22858c, z);
                    }
                }
            }
        }

        class C19983 implements Runnable {
            final /* synthetic */ C24103 f22729a;

            C19983(C24103 c24103) {
                this.f22729a = c24103;
            }

            public void run() {
                if (!this.f22729a.f30136a) {
                    Logger.m24934b("Application is on background.");
                    if (SendBird.m24995h() == ConnectionState.CLOSED) {
                        if (SendBird.f22819h.f22839o <= 0) {
                            this.f22729a.f30137b = false;
                            this.f22729a.f30136a = true;
                        }
                    }
                    SendBird.m24985c(false);
                    this.f22729a.f30137b = true;
                    this.f22729a.f30136a = true;
                }
            }
        }

        C24103() {
            super();
        }

        final void mo5232a() {
            this.f30139d.start();
        }

        final void mo5233b() {
            if (this.f30138c != null && this.f30138c.getLooper() != null) {
                this.f30138c.getLooper().quit();
            }
        }

        public final void mo5234c() {
            if (SendBird.m24992f()) {
                if (this.f30138c != null) {
                    this.f30138c.removeCallbacksAndMessages(null);
                    this.f30138c.post(this.f30140e);
                }
            }
        }

        public final void mo5235d() {
            if (SendBird.m24992f()) {
                if (this.f30138c != null) {
                    this.f30138c.removeCallbacksAndMessages(null);
                    this.f30138c.postDelayed(this.f30141f, 500);
                }
            }
        }
    }

    public static String m24983c() {
        return "3.0.50";
    }

    final boolean m25016a() {
        boolean z;
        synchronized (this.f22827G) {
            z = this.f22826F;
        }
        return z;
    }

    final void m25015a(boolean z) {
        synchronized (this.f22827G) {
            this.f22826F = z;
        }
    }

    public static String m24977b() {
        return String.valueOf(VERSION.SDK_INT);
    }

    public static String m24986d() {
        return m24988e().f22834j;
    }

    private void m24980b(String str, boolean z) {
        this.f22834j = str;
        str = new StringBuilder("com.sendbird.");
        str.append(this.f22834j);
        str.append(".PREF_API_HOST");
        this.f22832f = str.toString();
        str = new StringBuilder("com.sendbird.");
        str.append(this.f22834j);
        str.append(".PREF_WS_HOST");
        this.f22833g = str.toString();
        if (z) {
            APIClient.m24818a();
            APIClient.m24834g();
        }
    }

    private SendBird(String str, Context context) {
        m24980b(str, false);
        this.f22835k = context;
        this.f22827G = new Object();
        if (context != null) {
            this.f22828H = (ConnectivityManager) context.getSystemService("connectivity");
            this.f22829I = new NetworkReceiver();
            context.registerReceiver(this.f22829I, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (VERSION.SDK_INT >= 14 && (context instanceof Application) != null) {
            ((Application) context).registerActivityLifecycleCallbacks(new C19941(this));
        }
    }

    protected static void m24968a(Runnable runnable) {
        if (f22820i != null) {
            f22820i.post(runnable);
        } else {
            runnable.run();
        }
    }

    protected static synchronized SendBird m24988e() {
        SendBird sendBird;
        synchronized (SendBird.class) {
            if (f22819h == null) {
                Logger.m24932a("SendBird instance hasn't been initialized. Try SendBird.init().");
                throw new RuntimeException("SendBird instance hasn't been initialized.");
            }
            sendBird = f22819h;
        }
        return sendBird;
    }

    private static synchronized boolean m25006m() {
        boolean z;
        synchronized (SendBird.class) {
            z = f22819h != null;
        }
        return z;
    }

    public static synchronized boolean m24975a(String str, Context context) {
        synchronized (SendBird.class) {
            if (f22819h == null) {
                f22819h = new SendBird(str, context.getApplicationContext());
                APIClient.m24829b();
            } else {
                context = null;
                if (str.length() > 0) {
                    if (!str.equals(m24988e().f22834j)) {
                        SendBird e = m24988e();
                        if (e != null && m24995h() == ConnectionState.CLOSED) {
                            e.m24980b(str, true);
                        }
                    }
                }
                m24985c(true);
                if (f22819h.f22823C != null) {
                    f22819h.f22823C.mo5233b();
                }
                f22819h.f22824D = true;
                f22819h.f22825E = true;
                f22819h.f22823C = new C24103();
                f22819h.f22823C.mo5232a();
            }
            context = 1;
            m24985c(true);
            if (f22819h.f22823C != null) {
                f22819h.f22823C.mo5233b();
            }
            f22819h.f22824D = true;
            f22819h.f22825E = true;
            f22819h.f22823C = new C24103();
            f22819h.f22823C.mo5232a();
        }
        return context;
    }

    public static void m24981b(boolean z) {
        m24988e().f22824D = z;
    }

    public static boolean m24992f() {
        return m24988e().f22824D;
    }

    public static boolean m24994g() {
        return m24988e().f22825E;
    }

    public static com.sendbird.android.SendBird.ConnectionState m24995h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = m25006m();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r0 = com.sendbird.android.SendBird.ConnectionState.CLOSED;
        return r0;
    L_0x0009:
        r0 = m24988e();	 Catch:{ RuntimeException -> 0x001f }
        r0 = r0.f22836l;	 Catch:{ RuntimeException -> 0x001f }
        if (r0 != 0) goto L_0x0014;	 Catch:{ RuntimeException -> 0x001f }
    L_0x0011:
        r0 = com.sendbird.android.SendBird.ConnectionState.CLOSED;	 Catch:{ RuntimeException -> 0x001f }
        return r0;	 Catch:{ RuntimeException -> 0x001f }
    L_0x0014:
        r0 = m24988e();	 Catch:{ RuntimeException -> 0x001f }
        r0 = r0.f22836l;	 Catch:{ RuntimeException -> 0x001f }
        r0 = r0.m25056c();	 Catch:{ RuntimeException -> 0x001f }
        return r0;
    L_0x001f:
        r0 = com.sendbird.android.SendBird.ConnectionState.CLOSED;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBird.h():com.sendbird.android.SendBird$ConnectionState");
    }

    public static void m24969a(String str, ChannelHandler channelHandler) {
        if (str != null) {
            if (str.length() != 0) {
                m24988e().f22830d.put(str, channelHandler);
            }
        }
    }

    public static ChannelHandler m24961a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return (ChannelHandler) m24988e().f22830d.remove(str);
            }
        }
        return null;
    }

    public static void m24970a(String str, ConnectionHandler connectionHandler) {
        if (str != null) {
            if (str.length() != 0) {
                m24988e().f22821A.put(str, connectionHandler);
            }
        }
    }

    private static void m24964a(ConnectHandler connectHandler) {
        if (connectHandler != null) {
            synchronized (m24988e().f22822B) {
                m24988e().f22822B.add(connectHandler);
            }
        }
    }

    private static synchronized void m24984c(final String str, boolean z) {
        synchronized (SendBird.class) {
            final SendBird e = m24988e();
            e.f22838n = Math.min(e.f22838n, 300000);
            e.f22839o++;
            synchronized (e.f22847w) {
                e.f22840p = true;
            }
            if (e.f22839o == 1 && z) {
                Logger.m24934b("Reconnect Started.");
                m24968a(new Runnable() {
                    public final void run() {
                        for (ConnectionHandler a : e.f22821A.values()) {
                            a.mo4556a();
                        }
                    }
                });
            }
            int i = 0;
            if (e.f22839o <= true) {
                synchronized (e.f22846v) {
                    if (e.f22841q == null) {
                        int i2 = e.f22838n;
                        if (e.f22838n != 0) {
                            i = 1000;
                        }
                        e.f22841q = new CountDownTimer(i2, i);
                        e.f22841q.f22578a = new CountDownTimerEventHandler() {

                            class C24131 implements WSClientHandler {
                                final /* synthetic */ C24148 f30160a;

                                class C24121 implements CountDownTimerEventHandler {
                                    final /* synthetic */ C24131 f30158a;
                                    private boolean f30159b;

                                    class C20111 implements Runnable {
                                        final /* synthetic */ C24121 f22755a;

                                        C20111(C24121 c24121) {
                                            this.f22755a = c24121;
                                        }

                                        public void run() {
                                            for (ConnectionHandler c : e.f22821A.values()) {
                                                c.mo4558c();
                                            }
                                        }
                                    }

                                    class C20134 implements Runnable {
                                        final /* synthetic */ C24121 f22758a;

                                        C20134(C24121 c24121) {
                                            this.f22758a = c24121;
                                        }

                                        public void run() {
                                            for (ConnectionHandler b : e.f22821A.values()) {
                                                b.mo4557b();
                                            }
                                        }
                                    }

                                    public final void mo5221a() {
                                    }

                                    public final void mo5222a(int i, int i2) {
                                    }

                                    C24121(C24131 c24131) {
                                        this.f30158a = c24131;
                                    }

                                    public final void mo5223b() {
                                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                        /*
                                        r6 = this;
                                        r0 = r6.f30159b;
                                        r1 = 0;
                                        if (r0 == 0) goto L_0x003f;
                                    L_0x0005:
                                        r0 = "Reconnect login timer failed.";
                                        com.sendbird.android.Logger.m24934b(r0);
                                        com.sendbird.android.SendBird.m24985c(r1);
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0 = r0.f22847w;
                                        monitor-enter(r0);
                                        r1 = r6.f30158a;	 Catch:{ all -> 0x003c }
                                        r1 = r1.f30160a;	 Catch:{ all -> 0x003c }
                                        r1 = r1;	 Catch:{ all -> 0x003c }
                                        r1.f22840p = false;	 Catch:{ all -> 0x003c }
                                        monitor-exit(r0);	 Catch:{ all -> 0x003c }
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0 = r0.f22821A;
                                        r0 = r0.size();
                                        if (r0 <= 0) goto L_0x011f;
                                    L_0x0032:
                                        r0 = new com.sendbird.android.SendBird$8$1$1$1;
                                        r0.<init>(r6);
                                        com.sendbird.android.SendBird.m24968a(r0);
                                        goto L_0x011f;
                                    L_0x003c:
                                        r1 = move-exception;
                                        monitor-exit(r0);	 Catch:{ all -> 0x003c }
                                        throw r1;
                                    L_0x003f:
                                        r0 = "Reconnect login timer succeeded.";
                                        com.sendbird.android.Logger.m24934b(r0);
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0.f22838n = 0;
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0.f22839o = 0;
                                        r0 = com.sendbird.android.OpenChannel.m31005j();
                                        r2 = new java.util.concurrent.atomic.AtomicBoolean;
                                        r2.<init>(r1);
                                        r3 = r0.size();
                                        if (r3 <= 0) goto L_0x00ed;
                                    L_0x0065:
                                        r3 = new java.lang.StringBuilder;
                                        r4 = "Enter open channels: ";
                                        r3.<init>(r4);
                                        r4 = r0.size();
                                        r3.append(r4);
                                        r3 = r3.toString();
                                        com.sendbird.android.Logger.m24934b(r3);
                                        r3 = new java.util.concurrent.CountDownLatch;
                                        r0 = r0.size();
                                        r3.<init>(r0);
                                        r0 = com.sendbird.android.OpenChannel.m31005j();
                                        r0 = r0.iterator();
                                    L_0x008b:
                                        r4 = r0.hasNext();
                                        if (r4 == 0) goto L_0x00a0;
                                    L_0x0091:
                                        r4 = r0.next();
                                        r4 = (com.sendbird.android.OpenChannel) r4;
                                        r5 = new com.sendbird.android.SendBird$8$1$1$2;
                                        r5.<init>(r6, r2, r3);
                                        r4.m31010a(r5);
                                        goto L_0x008b;
                                    L_0x00a0:
                                        r3.await();	 Catch:{ InterruptedException -> 0x00a4 }
                                        goto L_0x00a8;
                                    L_0x00a4:
                                        r0 = 1;
                                        r2.set(r0);
                                    L_0x00a8:
                                        r0 = r2.get();
                                        if (r0 == 0) goto L_0x00b7;
                                    L_0x00ae:
                                        r0 = "Error on enter: true";
                                        com.sendbird.android.Logger.m24934b(r0);
                                        com.sendbird.android.SendBird.m24985c(r1);
                                        goto L_0x00bc;
                                    L_0x00b7:
                                        r0 = "Error on enter: false";
                                        com.sendbird.android.Logger.m24934b(r0);
                                    L_0x00bc:
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0 = r0.f22847w;
                                        monitor-enter(r0);
                                        r1 = r6.f30158a;	 Catch:{ all -> 0x00ea }
                                        r1 = r1.f30160a;	 Catch:{ all -> 0x00ea }
                                        r1 = r1;	 Catch:{ all -> 0x00ea }
                                        r1.f22840p = false;	 Catch:{ all -> 0x00ea }
                                        monitor-exit(r0);	 Catch:{ all -> 0x00ea }
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0 = r0.f22821A;
                                        r0 = r0.size();
                                        if (r0 <= 0) goto L_0x011f;
                                    L_0x00e1:
                                        r0 = new com.sendbird.android.SendBird$8$1$1$3;
                                        r0.<init>(r6, r2);
                                        com.sendbird.android.SendBird.m24968a(r0);
                                        goto L_0x011f;
                                    L_0x00ea:
                                        r1 = move-exception;
                                        monitor-exit(r0);	 Catch:{ all -> 0x00ea }
                                        throw r1;
                                    L_0x00ed:
                                        r0 = "No open channels to enter.";
                                        com.sendbird.android.Logger.m24934b(r0);
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0 = r0.f22847w;
                                        monitor-enter(r0);
                                        r1 = r6.f30158a;	 Catch:{ all -> 0x0139 }
                                        r1 = r1.f30160a;	 Catch:{ all -> 0x0139 }
                                        r1 = r1;	 Catch:{ all -> 0x0139 }
                                        r1.f22840p = false;	 Catch:{ all -> 0x0139 }
                                        monitor-exit(r0);	 Catch:{ all -> 0x0139 }
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r0 = r0.f22821A;
                                        r0 = r0.size();
                                        if (r0 <= 0) goto L_0x011f;
                                    L_0x0117:
                                        r0 = new com.sendbird.android.SendBird$8$1$1$4;
                                        r0.<init>(r6);
                                        com.sendbird.android.SendBird.m24968a(r0);
                                    L_0x011f:
                                        r0 = r6.f30158a;
                                        r0 = r0.f30160a;
                                        r0 = r1;
                                        r1 = r0.f22845u;
                                        monitor-enter(r1);
                                        r0 = r6.f30158a;	 Catch:{ all -> 0x0136 }
                                        r0 = r0.f30160a;	 Catch:{ all -> 0x0136 }
                                        r0 = r1;	 Catch:{ all -> 0x0136 }
                                        r2 = 0;	 Catch:{ all -> 0x0136 }
                                        r0.f22842r = r2;	 Catch:{ all -> 0x0136 }
                                        monitor-exit(r1);	 Catch:{ all -> 0x0136 }
                                        return;	 Catch:{ all -> 0x0136 }
                                    L_0x0136:
                                        r0 = move-exception;	 Catch:{ all -> 0x0136 }
                                        monitor-exit(r1);	 Catch:{ all -> 0x0136 }
                                        throw r0;
                                    L_0x0139:
                                        r1 = move-exception;
                                        monitor-exit(r0);	 Catch:{ all -> 0x0139 }
                                        throw r1;
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBird.8.1.1.b():void");
                                    }

                                    public final void mo5224c() {
                                        Logger.m24934b("Reconnect login timer canceled.");
                                        synchronized (e.f22845u) {
                                            e.f22842r = null;
                                        }
                                    }

                                    public final void mo5225d() {
                                        this.f30159b = true;
                                    }
                                }

                                C24131(C24148 c24148) {
                                    this.f30160a = c24148;
                                }

                                public final void mo5227a() {
                                    Logger.m24934b("WS Ready.");
                                    if (e.f22836l != null) {
                                        e.f22836l.m25052a();
                                    }
                                }

                                public final void mo5230b() {
                                    Logger.m24934b("WS Open.");
                                    synchronized (e.f22845u) {
                                        e.f22842r = new CountDownTimer(AbstractSpiCall.DEFAULT_TIMEOUT, 100);
                                        e.f22842r.f22578a = new C24121(this);
                                        e.f22842r.m24907a();
                                    }
                                }

                                public final void mo5231c() {
                                    Logger.m24934b("WS onClose.");
                                }

                                public final void mo5229a(String str) {
                                    StringBuilder stringBuilder = new StringBuilder("WS onMessage: ");
                                    stringBuilder.append(str);
                                    Logger.m24934b(stringBuilder.toString());
                                    SendBird.m24966a(e, str);
                                }

                                public final void mo5228a(SendBirdException sendBirdException) {
                                    Logger.m24934b("WS onError.");
                                    Logger.m24933b((Exception) sendBirdException);
                                    APIClient.m24818a().m24854d();
                                    APIClient.m24818a().m24852c();
                                    SendBird.m24984c(str, e.f22839o == 0);
                                }
                            }

                            public final void mo5221a() {
                                Logger.m24934b("ReconnectTimer start.");
                            }

                            public final void mo5223b() {
                                synchronized (e.f22846v) {
                                    e.f22841q = null;
                                }
                                Logger.m24934b("ReconnectTimer stop.");
                            }

                            public final void mo5224c() {
                                synchronized (e.f22846v) {
                                    e.f22841q = null;
                                }
                                Logger.m24934b("ReconnectTimer cancel.");
                            }

                            public final void mo5225d() {
                                synchronized (e.f22846v) {
                                    e.f22841q = null;
                                }
                                Logger.m24934b("ReconnectTimer timeout. Try to reconnect...");
                                synchronized (e.f22848x) {
                                    if (e.f22836l != null) {
                                        e.f22836l.m25055b();
                                        e.f22836l = null;
                                    }
                                    e.f22836l = new WSClient();
                                    e.f22836l.f22870a = new C24131(this);
                                }
                                if (e.f22836l != null) {
                                    e.f22836l.m25054a(str, null);
                                }
                            }

                            public final void mo5222a(int i, int i2) {
                                StringBuilder stringBuilder = new StringBuilder("ReconnectTimer Tick: ");
                                stringBuilder.append(i - i2);
                                Logger.m24934b(stringBuilder.toString());
                            }
                        };
                        e.f22841q.m24907a();
                    } else {
                        Logger.m24934b("Reconnecting is in progress.");
                    }
                }
                if (e.f22838n == null) {
                    e.f22838n = 3000;
                    return;
                }
                e.f22838n *= 2;
                return;
            }
            Logger.m24934b("Reconnect Failed.");
            m24985c(false);
            synchronized (e.f22847w) {
                e.f22840p = false;
            }
            m24968a(new Runnable() {
                public final void run() {
                    for (ConnectionHandler c : e.f22821A.values()) {
                        c.mo4558c();
                    }
                }
            });
        }
    }

    private static void m24972a(final String str, String str2) {
        final SendBird e = m24988e();
        synchronized (e.f22848x) {
            if (e.f22836l != null) {
                e.f22836l.m25055b();
                e.f22836l = null;
            }
            e.f22836l = new WSClient();
            e.f22836l.f22870a = new WSClientHandler() {

                class C24081 implements CountDownTimerEventHandler {
                    final /* synthetic */ AnonymousClass10 f30121a;
                    private boolean f30122b;

                    public final void mo5221a() {
                    }

                    public final void mo5222a(int i, int i2) {
                    }

                    C24081(AnonymousClass10 anonymousClass10) {
                        this.f30121a = anonymousClass10;
                    }

                    public final void mo5223b() {
                        synchronized (e.f22845u) {
                            boolean z = e.f22844t != null;
                            if (z) {
                                e.f22844t.getMessage();
                                e.f22844t;
                            }
                        }
                        if (this.f30122b) {
                            Logger.m24934b("Connect login timer failed.");
                            SendBird.m24985c(true);
                            SendBird.m24967a(new SendBirdException("Login timeout.", 800190));
                        } else if (z) {
                            Logger.m24934b("Connect login failed.");
                            SendBird.m24985c(true);
                            SendBird.m24967a(new SendBirdException(null, 0));
                        } else {
                            Logger.m24934b("Connect login timer succeeded.");
                            e.f22838n = 0;
                            e.f22839o = 0;
                            SendBird.m25009p(e);
                            SendBird.m24967a(null);
                        }
                        synchronized (e.f22845u) {
                            e.f22842r = null;
                        }
                    }

                    public final void mo5224c() {
                        Logger.m24934b("Connect login timer canceled.");
                        synchronized (e.f22845u) {
                            e.f22842r = null;
                        }
                    }

                    public final void mo5225d() {
                        this.f30122b = true;
                    }
                }

                public final void mo5227a() {
                    Logger.m24934b("WS Ready.");
                    if (e.f22836l != null) {
                        e.f22836l.m25052a();
                    }
                }

                public final void mo5230b() {
                    Logger.m24934b("WS Open.");
                    synchronized (e.f22845u) {
                        e.f22842r = new CountDownTimer(AbstractSpiCall.DEFAULT_TIMEOUT, 100);
                        e.f22842r.f22578a = new C24081(this);
                        e.f22842r.m24907a();
                        e.f22844t = null;
                    }
                }

                public final void mo5231c() {
                    Logger.m24934b("WS Close.");
                }

                public final void mo5229a(String str) {
                    StringBuilder stringBuilder = new StringBuilder("WS Received: ");
                    stringBuilder.append(str);
                    Logger.m24934b(stringBuilder.toString());
                    SendBird.m24966a(e, str);
                }

                public final void mo5228a(SendBirdException sendBirdException) {
                    Logger.m24934b("WS Error.");
                    Logger.m24933b((Exception) sendBirdException);
                    boolean z = true;
                    if (SendBird.m25001k() == null) {
                        SendBird.m24985c(true);
                        SendBird.m24967a(sendBirdException);
                        return;
                    }
                    APIClient.m24818a().m24854d();
                    APIClient.m24818a().m24852c();
                    String str = str;
                    if (e.f22839o != 0) {
                        z = false;
                    }
                    SendBird.m24984c(str, z);
                }
            };
        }
        if (e.f22836l != null) {
            e.f22836l.m25054a(str, str2);
        }
    }

    public static void m25000j() {
        m24985c(true);
    }

    static synchronized void m24985c(boolean z) {
        synchronized (SendBird.class) {
            Logger.m24934b("Disconnect.");
            SendBird e = m24988e();
            e.f22838n = 0;
            e.f22839o = 0;
            synchronized (e.f22845u) {
                if (e.f22842r != null) {
                    e.f22842r.m24909c();
                    e.f22842r = null;
                }
            }
            synchronized (e.f22846v) {
                if (e.f22841q != null) {
                    e.f22841q.m24909c();
                    e.f22841q = null;
                }
            }
            synchronized (e.f22848x) {
                if (e.f22836l != null) {
                    e.f22836l.m25055b();
                    e.f22836l = null;
                }
            }
            if (z) {
                Logger.m24934b("Clear local data.");
                if (e.f22843s) {
                    e.f22843s.m24909c();
                    e.f22843s = null;
                }
                synchronized (e.f22849y) {
                    for (HashMap hashMap : e.f22850z.values()) {
                        CountDownTimer countDownTimer = (CountDownTimer) hashMap.get("timer");
                        if (countDownTimer != null) {
                            countDownTimer.m24909c();
                        }
                    }
                    e.f22850z.clear();
                }
                if (e.f22837m) {
                    e.f22837m = null;
                }
                APIClient.m24818a().m24854d();
                APIClient.m24818a().m24840a("");
                APIClient.m24818a().m24849b("");
                OpenChannel.m31004i();
                OpenChannel.m31003h();
                GroupChannel.m30963h();
            }
        }
    }

    public static User m25001k() {
        return m24988e().f22837m;
    }

    private void m24963a(Command command) {
        UserEvent userEvent = new UserEvent(command.m24896d());
        command = userEvent.f22865a;
        int i = 0;
        if (command != 20900) {
            User user = null;
            Member member;
            Member member2;
            switch (command) {
                case 20000:
                    if (userEvent.m25024a() == null || userEvent.m25024a().m25073h().m31129a("blocker") == null || userEvent.m25024a().m25073h().m31129a("blockee") == null) {
                        command = null;
                    } else {
                        user = new User(userEvent.m25024a().m25073h().m31130b("blocker"));
                        command = new User(userEvent.m25024a().m25073h().m31130b("blockee"));
                    }
                    if (user != null) {
                        if (m24988e().f22837m != null && m24988e().f22837m.f22858c.equals(user.f22858c)) {
                            for (Entry value : GroupChannel.f30084g.entrySet()) {
                                member = (Member) ((GroupChannel) value.getValue()).f30092o.get(command.f22858c);
                                if (member != null) {
                                    member.f30105b = false;
                                }
                            }
                        }
                        if (!(m24988e().f22837m == null || m24988e().f22837m.f22858c.equals(command.f22858c) == null)) {
                            for (Entry value2 : GroupChannel.f30084g.entrySet()) {
                                member2 = (Member) ((GroupChannel) value2.getValue()).f30092o.get(user.f22858c);
                                if (member2 != null) {
                                    member2.f30104a = false;
                                }
                            }
                            return;
                        }
                    }
                    break;
                case 20001:
                    if (userEvent.m25024a() == null || userEvent.m25024a().m25073h().m31129a("blocker") == null || userEvent.m25024a().m25073h().m31129a("blockee") == null) {
                        command = null;
                    } else {
                        user = new User(userEvent.m25024a().m25073h().m31130b("blocker"));
                        command = new User(userEvent.m25024a().m25073h().m31130b("blockee"));
                    }
                    if (user != null) {
                        if (m24988e().f22837m != null && m24988e().f22837m.f22858c.equals(user.f22858c)) {
                            for (Entry value3 : GroupChannel.f30084g.entrySet()) {
                                member = (Member) ((GroupChannel) value3.getValue()).f30092o.get(command.f22858c);
                                if (member != null) {
                                    member.f30105b = true;
                                }
                            }
                        }
                        if (!(m24988e().f22837m == null || m24988e().f22837m.f22858c.equals(command.f22858c) == null)) {
                            for (Entry value22 : GroupChannel.f30084g.entrySet()) {
                                member2 = (Member) ((GroupChannel) value22.getValue()).f30092o.get(user.f22858c);
                                if (member2 != null) {
                                    member2.f30104a = true;
                                }
                            }
                            return;
                        }
                    }
                    break;
                default:
                    break;
            }
        } else if (!(userEvent.m25024a() == null || userEvent.m25024a().m25073h().m31129a("friend_discoveries") == null)) {
            command = userEvent.m25024a().m25073h().m31130b("friend_discoveries").m25074i();
            final ArrayList arrayList = new ArrayList();
            while (i < command.m31115a()) {
                arrayList.add(new User(command.m31116a(i)));
                i++;
            }
            m24968a(new Runnable(this) {
                final /* synthetic */ SendBird f22723b;

                public void run() {
                    Iterator it = this.f22723b.f22831e.values().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    final void m25014a(final Command command, final SendCommandHandler sendCommandHandler) {
        if (this.f22836l != null) {
            if (this.f22836l.m25056c() == ConnectionState.OPEN) {
                if (command.m24894b()) {
                    final SendBird e = m24988e();
                    final String str = command.f22576c;
                    CountDownTimer countDownTimer = new CountDownTimer(AbstractSpiCall.DEFAULT_TIMEOUT, 100);
                    countDownTimer.f22578a = new CountDownTimerEventHandler(this) {
                        final /* synthetic */ SendBird f30131d;

                        public final void mo5221a() {
                        }

                        public final void mo5222a(int i, int i2) {
                        }

                        public final void mo5223b() {
                            synchronized (e.f22849y) {
                                this.f30131d.f22850z.remove(str);
                            }
                        }

                        public final void mo5224c() {
                            synchronized (e.f22849y) {
                                this.f30131d.f22850z.remove(str);
                            }
                        }

                        public final void mo5225d() {
                            sendCommandHandler.mo5215a(null, new SendBirdException("Command received no ack.", 800180));
                        }
                    };
                    synchronized (e.f22849y) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("handler", sendCommandHandler);
                        hashMap.put("timer", countDownTimer);
                        this.f22850z.put(str, hashMap);
                    }
                    countDownTimer.m24907a();
                    this.f22836l.m25053a(command, new WSClientSendHandler(this) {
                        final /* synthetic */ SendBird f30125c;

                        public final void mo5226a(SendBirdException sendBirdException) {
                            if (sendBirdException != null) {
                                HashMap b = this.f30125c.m24990e(command.f22576c);
                                if (b != null) {
                                    CountDownTimer countDownTimer = (CountDownTimer) b.get("timer");
                                    b.get("handler");
                                    countDownTimer.m24908b();
                                }
                                if (sendCommandHandler != null) {
                                    sendCommandHandler.mo5215a(null, sendBirdException);
                                }
                            }
                        }
                    });
                    return;
                }
                this.f22836l.m25053a(command, new WSClientSendHandler(this) {
                    final /* synthetic */ SendBird f30127b;

                    public final void mo5226a(SendBirdException sendBirdException) {
                        if (sendBirdException != null) {
                            if (sendCommandHandler != null) {
                                sendCommandHandler.mo5215a(null, sendBirdException);
                            }
                            return;
                        }
                        if (sendCommandHandler != null) {
                            sendCommandHandler.mo5215a(null, null);
                        }
                    }
                });
                return;
            }
        }
        if (sendCommandHandler != null) {
            sendCommandHandler.mo5215a(null, new SendBirdException("WS connection closed.", 800200));
        }
    }

    private HashMap<String, Object> m24990e(String str) {
        return (HashMap) this.f22850z.get(str);
    }

    final String m25017b(String str) {
        if (this.f22835k != null) {
            return PreferenceManager.getDefaultSharedPreferences(this.f22835k).getString(str, null);
        }
        return null;
    }

    private void m24979b(String str, String str2) {
        if (this.f22835k != null) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f22835k).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    final void m25018c(String str) {
        m24979b(this.f22832f, str);
    }

    final void m25019d(String str) {
        m24979b(this.f22833g, str);
    }

    public static void m24973a(String str, String str2, String str3, String str4, final ConnectHandler connectHandler) {
        f22818c = str3;
        f22817b = str4;
        if (str != null) {
            if (str.length() != null) {
                if (m24995h() == ConnectionState.OPEN && m24988e().f22837m != null && m24988e().f22837m.f22858c.equals(str) != null) {
                    m24968a(new Runnable() {
                        public final void run() {
                            connectHandler.mo4559a(SendBird.m25001k(), null);
                        }
                    });
                    return;
                } else if (m24995h() == ConnectionState.CONNECTING) {
                    m24964a(connectHandler);
                    return;
                } else {
                    m24964a(connectHandler);
                    m24985c((boolean) null);
                    str3 = m24988e().f22837m;
                    if (str3 != null) {
                        if (str3.f22858c.equals(str) != null) {
                            APIClient.m24818a().m24852c();
                            m24972a(str3.f22858c, null);
                            return;
                        }
                    }
                    if (str3 != null && str3.f22858c.equals(str) == null) {
                        m24985c(true);
                    }
                    APIClient.m24818a().m24852c();
                    m24972a(str, str2);
                    return;
                }
            }
        }
        m24968a(new Runnable() {
            public final void run() {
                connectHandler.mo4559a(null, new SendBirdException("Invalid arguments.", 800110));
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m24998i() {
        /*
        r0 = com.sendbird.android.SendBird.class;
        monitor-enter(r0);
        r1 = m24988e();	 Catch:{ all -> 0x003c }
        r1 = r1.f22837m;	 Catch:{ all -> 0x003c }
        r2 = 0;
        if (r1 == 0) goto L_0x003a;
    L_0x000c:
        r1 = com.sendbird.android.APIClient.m24818a();	 Catch:{ all -> 0x003c }
        r1 = r1.m24856e();	 Catch:{ all -> 0x003c }
        if (r1 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x003a;
    L_0x0017:
        r1 = m24988e();	 Catch:{ all -> 0x003c }
        r1 = r1.f22839o;	 Catch:{ all -> 0x003c }
        r3 = 1;
        if (r1 != 0) goto L_0x0022;
    L_0x0020:
        r1 = r3;
        goto L_0x0023;
    L_0x0022:
        r1 = r2;
    L_0x0023:
        m24985c(r2);	 Catch:{ all -> 0x003c }
        r2 = com.sendbird.android.APIClient.m24818a();	 Catch:{ all -> 0x003c }
        r2.m24852c();	 Catch:{ all -> 0x003c }
        r2 = m24988e();	 Catch:{ all -> 0x003c }
        r2 = r2.f22837m;	 Catch:{ all -> 0x003c }
        r2 = r2.f22858c;	 Catch:{ all -> 0x003c }
        m24984c(r2, r1);	 Catch:{ all -> 0x003c }
        monitor-exit(r0);
        return r3;
    L_0x003a:
        monitor-exit(r0);
        return r2;
    L_0x003c:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBird.i():boolean");
    }

    public static void m24971a(String str, final UserBlockHandler userBlockHandler) {
        if (m24988e().f22837m == null) {
            m24968a(new Runnable() {
                public final void run() {
                    userBlockHandler.mo4487a(new SendBirdException("Connection must be made before you block a user.", 800101));
                }
            });
        } else if (str == null) {
            m24968a(new Runnable() {
                public final void run() {
                    userBlockHandler.mo4487a(new SendBirdException("Invalid operation.", 800110));
                }
            });
        } else {
            APIClient.m24818a().m24857e(m24988e().f22837m.f22858c, str, new APIClientHandler() {
                public final void mo5216a(final JsonElement jsonElement, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        if (userBlockHandler != null) {
                            SendBird.m24968a(new Runnable(this) {
                                final /* synthetic */ AnonymousClass49 f22733b;

                                public void run() {
                                    userBlockHandler.mo4487a(sendBirdException);
                                }
                            });
                        }
                        return;
                    }
                    if (userBlockHandler != null) {
                        SendBird.m24968a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass49 f22735b;

                            public void run() {
                                UserBlockHandler userBlockHandler = userBlockHandler;
                                User user = new User(jsonElement);
                                userBlockHandler.mo4487a(null);
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m24966a(com.sendbird.android.SendBird r11, java.lang.String r12) {
        /*
        r0 = new com.sendbird.android.Command;
        r0.<init>(r12);
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r1 = r0.f22576c;
        r12.append(r1);
        r1 = ":";
        r12.append(r1);
        r1 = r0.f22574a;
        r12.append(r1);
        r1 = ":";
        r12.append(r1);
        r1 = r0.f22575b;
        r12.append(r1);
        r12 = r12.toString();
        com.sendbird.android.Logger.m24934b(r12);
        r12 = r0.f22576c;
        r1 = 0;
        r2 = 1;
        if (r12 == 0) goto L_0x003a;
    L_0x0030:
        r12 = r0.f22576c;
        r12 = r12.length();
        if (r12 <= 0) goto L_0x003a;
    L_0x0038:
        r12 = r2;
        goto L_0x003b;
    L_0x003a:
        r12 = r1;
    L_0x003b:
        r3 = 2362860; // 0x240dec float:3.311072E-39 double:1.167408E-317;
        r4 = 2157948; // 0x20ed7c float:3.023929E-39 double:1.066168E-317;
        r5 = 0;
        r6 = 2;
        r7 = -1;
        if (r12 == 0) goto L_0x0134;
    L_0x0046:
        r12 = r0.f22576c;
        r12 = r11.m24990e(r12);
        if (r12 == 0) goto L_0x059e;
    L_0x004e:
        r8 = "timer";
        r8 = r12.get(r8);
        r8 = (com.sendbird.android.CountDownTimer) r8;
        r9 = "handler";
        r12 = r12.get(r9);
        r12 = (com.sendbird.android.Command.SendCommandHandler) r12;
        if (r8 == 0) goto L_0x0063;
    L_0x0060:
        r8.m24908b();
    L_0x0063:
        if (r12 == 0) goto L_0x0133;
    L_0x0065:
        r8 = r0.f22574a;
        r9 = r8.hashCode();
        r10 = 2136912; // 0x209b50 float:2.994452E-39 double:1.055775E-317;
        if (r9 == r10) goto L_0x0089;
    L_0x0070:
        if (r9 == r4) goto L_0x007f;
    L_0x0072:
        if (r9 == r3) goto L_0x0075;
    L_0x0074:
        goto L_0x0092;
    L_0x0075:
        r1 = "MESG";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x0092;
    L_0x007d:
        r1 = r2;
        goto L_0x0093;
    L_0x007f:
        r1 = "FILE";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x0092;
    L_0x0087:
        r1 = r6;
        goto L_0x0093;
    L_0x0089:
        r2 = "EROR";
        r2 = r8.equals(r2);
        if (r2 == 0) goto L_0x0092;
    L_0x0091:
        goto L_0x0093;
    L_0x0092:
        r1 = r7;
    L_0x0093:
        switch(r1) {
            case 0: goto L_0x010e;
            case 1: goto L_0x009b;
            case 2: goto L_0x009b;
            default: goto L_0x0096;
        };
    L_0x0096:
        r12.mo5215a(r0, r5);
        goto L_0x0133;
    L_0x009b:
        r1 = r0.f22574a;
        r2 = "MESG";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00b4;
    L_0x00a5:
        r1 = new com.sendbird.android.UserMessage;
        r2 = r0.m24896d();
        r1.<init>(r2);
        r2 = r1;
        r2 = (com.sendbird.android.UserMessage) r2;
        r2 = r2.f30210a;
        goto L_0x00c2;
    L_0x00b4:
        r1 = new com.sendbird.android.FileMessage;
        r2 = r0.m24896d();
        r1.<init>(r2);
        r2 = r1;
        r2 = (com.sendbird.android.FileMessage) r2;
        r2 = r2.f30052a;
    L_0x00c2:
        if (r2 == 0) goto L_0x00f8;
    L_0x00c4:
        r3 = r11.f22837m;
        if (r3 == 0) goto L_0x00f8;
    L_0x00c8:
        r3 = r2.f22858c;
        r4 = r11.f22837m;
        r4 = r4.f22858c;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00f8;
    L_0x00d4:
        r3 = r2.f22859d;
        r4 = r11.f22837m;
        r4 = r4.f22859d;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00e6;
    L_0x00e0:
        r3 = r11.f22837m;
        r4 = r2.f22859d;
        r3.f22859d = r4;
    L_0x00e6:
        r3 = r2.f22860e;
        r4 = r11.f22837m;
        r4 = r4.f22860e;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00f8;
    L_0x00f2:
        r3 = r11.f22837m;
        r2 = r2.f22860e;
        r3.f22860e = r2;
    L_0x00f8:
        r2 = r1.m24881i();
        if (r2 == 0) goto L_0x010a;
    L_0x00fe:
        r2 = r1.m24880h();
        r3 = new com.sendbird.android.SendBird$74;
        r3.<init>(r11, r1);
        com.sendbird.android.GroupChannel.m30962b(r2, r3);
    L_0x010a:
        r12.mo5215a(r0, r5);
        return;
    L_0x010e:
        r11 = r0.m24896d();
        r11 = r11.m25073h();
        r1 = "code";
        r1 = r11.m31130b(r1);
        r1 = r1.mo5247f();
        r2 = "message";
        r11 = r11.m31130b(r2);
        r11 = r11.mo5244c();
        r2 = new com.sendbird.android.SendBirdException;
        r2.<init>(r11, r1);
        r12.mo5215a(r0, r2);
        return;
    L_0x0133:
        return;
    L_0x0134:
        r12 = r0.f22574a;
        r8 = r12.hashCode();
        r9 = 3;
        switch(r8) {
            case 2004227: goto L_0x01f1;
            case 2004905: goto L_0x01e7;
            case 2047193: goto L_0x01dd;
            case 2094530: goto L_0x01d2;
            case 2153860: goto L_0x01c8;
            case 2157948: goto L_0x01be;
            case 2282794: goto L_0x01b3;
            case 2332526: goto L_0x01a8;
            case 2342309: goto L_0x019e;
            case 2362397: goto L_0x0193;
            case 2362860: goto L_0x0188;
            case 2376973: goto L_0x017c;
            case 2511254: goto L_0x0170;
            case 2560407: goto L_0x0164;
            case 2581541: goto L_0x0158;
            case 2581981: goto L_0x014c;
            case 2614223: goto L_0x0140;
            default: goto L_0x013e;
        };
    L_0x013e:
        goto L_0x01fb;
    L_0x0140:
        r8 = "USEV";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x0148:
        r12 = 13;
        goto L_0x01fc;
    L_0x014c:
        r8 = "TPST";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x0154:
        r12 = 9;
        goto L_0x01fc;
    L_0x0158:
        r8 = "TPEN";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x0160:
        r12 = 10;
        goto L_0x01fc;
    L_0x0164:
        r8 = "SYEV";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x016c:
        r12 = 12;
        goto L_0x01fc;
    L_0x0170:
        r8 = "READ";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x0178:
        r12 = 8;
        goto L_0x01fc;
    L_0x017c:
        r8 = "MTIO";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x0184:
        r12 = 11;
        goto L_0x01fc;
    L_0x0188:
        r8 = "MESG";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x0190:
        r12 = r2;
        goto L_0x01fc;
    L_0x0193:
        r8 = "MEDI";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x019b:
        r12 = 5;
        goto L_0x01fc;
    L_0x019e:
        r8 = "LOGI";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01a6:
        r12 = r1;
        goto L_0x01fc;
    L_0x01a8:
        r8 = "LEAV";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01b0:
        r12 = 15;
        goto L_0x01fc;
    L_0x01b3:
        r8 = "JOIN";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01bb:
        r12 = 16;
        goto L_0x01fc;
    L_0x01be:
        r8 = "FILE";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01c6:
        r12 = r6;
        goto L_0x01fc;
    L_0x01c8:
        r8 = "FEDI";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01d0:
        r12 = 6;
        goto L_0x01fc;
    L_0x01d2:
        r8 = "DELM";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01da:
        r12 = 14;
        goto L_0x01fc;
    L_0x01dd:
        r8 = "BRDM";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01e5:
        r12 = r9;
        goto L_0x01fc;
    L_0x01e7:
        r8 = "AEDI";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01ef:
        r12 = 7;
        goto L_0x01fc;
    L_0x01f1:
        r8 = "ADMM";
        r12 = r12.equals(r8);
        if (r12 == 0) goto L_0x01fb;
    L_0x01f9:
        r12 = 4;
        goto L_0x01fc;
    L_0x01fb:
        r12 = r7;
    L_0x01fc:
        switch(r12) {
            case 0: goto L_0x04b2;
            case 1: goto L_0x040c;
            case 2: goto L_0x040c;
            case 3: goto L_0x040c;
            case 4: goto L_0x040c;
            case 5: goto L_0x0384;
            case 6: goto L_0x0384;
            case 7: goto L_0x0384;
            case 8: goto L_0x035b;
            case 9: goto L_0x035a;
            case 10: goto L_0x035a;
            case 11: goto L_0x0359;
            case 12: goto L_0x027e;
            case 13: goto L_0x027a;
            case 14: goto L_0x0216;
            case 15: goto L_0x0215;
            case 16: goto L_0x0214;
            default: goto L_0x01ff;
        };
    L_0x01ff:
        r11 = new java.lang.StringBuilder;
        r12 = "Discard a command: ";
        r11.<init>(r12);
        r12 = r0.f22574a;
        r11.append(r12);
        r11 = r11.toString();
        com.sendbird.android.Logger.m24934b(r11);
        goto L_0x059e;
    L_0x0214:
        return;
    L_0x0215:
        return;
    L_0x0216:
        r12 = r0.m24896d();
        r12 = r12.m25073h();
        r0 = "channel_type";
        r0 = r12.m31130b(r0);
        r0 = r0.mo5244c();
        r3 = "channel_url";
        r3 = r12.m31130b(r3);
        r3 = r3.mo5244c();
        r4 = "msg_id";
        r12 = r12.m31130b(r4);
        r4 = r12.mo5246e();
        r12 = r0.hashCode();
        r6 = 3417674; // 0x34264a float:4.789181E-39 double:1.6885553E-317;
        if (r12 == r6) goto L_0x0255;
    L_0x0245:
        r1 = 98629247; // 0x5e0f67f float:2.1155407E-35 double:4.87293226E-316;
        if (r12 == r1) goto L_0x024b;
    L_0x024a:
        goto L_0x025e;
    L_0x024b:
        r12 = "group";
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x025e;
    L_0x0253:
        r1 = r2;
        goto L_0x025f;
    L_0x0255:
        r12 = "open";
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x025e;
    L_0x025d:
        goto L_0x025f;
    L_0x025e:
        r1 = r7;
    L_0x025f:
        switch(r1) {
            case 0: goto L_0x0271;
            case 1: goto L_0x0268;
            default: goto L_0x0262;
        };
    L_0x0262:
        r11 = "Discard a command.";
        com.sendbird.android.Logger.m24934b(r11);
        return;
    L_0x0268:
        r12 = new com.sendbird.android.SendBird$83;
        r12.<init>(r11, r4);
        com.sendbird.android.GroupChannel.m30962b(r3, r12);
        return;
    L_0x0271:
        r12 = new com.sendbird.android.SendBird$82;
        r12.<init>(r11, r4);
        com.sendbird.android.OpenChannel.m31002b(r3, r12);
        return;
    L_0x027a:
        r11.m24963a(r0);
        return;
    L_0x027e:
        r12 = new com.sendbird.android.ChannelEvent;
        r1 = r0.m24896d();
        r12.<init>(r1);
        r1 = r12.f22568b;
        switch(r1) {
            case 10000: goto L_0x034d;
            case 10001: goto L_0x034d;
            case 10020: goto L_0x0342;
            case 10022: goto L_0x0337;
            case 10102: goto L_0x032c;
            case 10103: goto L_0x032c;
            case 10200: goto L_0x0321;
            case 10201: goto L_0x0321;
            case 10600: goto L_0x0316;
            case 10601: goto L_0x0316;
            case 10700: goto L_0x030b;
            case 10701: goto L_0x030b;
            case 10900: goto L_0x0300;
            case 10901: goto L_0x0300;
            case 11000: goto L_0x02e4;
            case 11100: goto L_0x02c8;
            case 11200: goto L_0x02c8;
            case 12000: goto L_0x02a4;
            case 13000: goto L_0x028e;
            default: goto L_0x028c;
        };
    L_0x028c:
        goto L_0x0358;
    L_0x028e:
        r1 = r12.f22570d;
        r2 = "group";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0358;
    L_0x0298:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$98;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30962b(r1, r2);
        goto L_0x0358;
    L_0x02a4:
        r0 = r12.f22569c;
        r1 = r12.m24883b();
        if (r1 == 0) goto L_0x02ba;
    L_0x02ac:
        r12 = r12.f22569c;
        com.sendbird.android.OpenChannel.m31000a(r12);
        r12 = new com.sendbird.android.SendBird$94;
        r12.<init>(r11, r0);
        m24968a(r12);
        return;
    L_0x02ba:
        r12 = r12.f22569c;
        com.sendbird.android.GroupChannel.m30958a(r12);
        r12 = new com.sendbird.android.SendBird$95;
        r12.<init>(r11, r0);
        m24968a(r12);
        return;
    L_0x02c8:
        r1 = r12.m24883b();
        if (r1 == 0) goto L_0x02d9;
    L_0x02ce:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$96;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.OpenChannel.m31002b(r1, r2);
        return;
    L_0x02d9:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$97;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30962b(r1, r2);
        return;
    L_0x02e4:
        r1 = r12.m24883b();
        if (r1 == 0) goto L_0x02f5;
    L_0x02ea:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$92;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.OpenChannel.m31001a(r1, r2);
        return;
    L_0x02f5:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$93;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30959a(r1, r2);
        return;
    L_0x0300:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$87;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30962b(r1, r2);
        return;
    L_0x030b:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$91;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.OpenChannel.m31002b(r1, r2);
        return;
    L_0x0316:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$90;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.OpenChannel.m31002b(r1, r2);
        return;
    L_0x0321:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$89;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.OpenChannel.m31002b(r1, r2);
        return;
    L_0x032c:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$88;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.OpenChannel.m31002b(r1, r2);
        return;
    L_0x0337:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$85;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30962b(r1, r2);
        return;
    L_0x0342:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$84;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30962b(r1, r2);
        return;
    L_0x034d:
        r1 = r12.f22569c;
        r2 = new com.sendbird.android.SendBird$86;
        r2.<init>(r11, r0, r12);
        com.sendbird.android.GroupChannel.m30962b(r1, r2);
        return;
    L_0x0358:
        return;
    L_0x0359:
        return;
    L_0x035a:
        return;
    L_0x035b:
        r12 = new com.sendbird.android.ReadStatus;
        r0 = r0.m24896d();
        r12.<init>(r0);
        r0 = com.sendbird.android.GroupChannel.f30084g;
        r1 = r12.f22705c;
        r0 = r0.containsKey(r1);
        if (r0 != 0) goto L_0x0379;
    L_0x036e:
        r0 = r12.f22705c;
        r1 = new com.sendbird.android.SendBird$80;
        r1.<init>(r11, r12);
        com.sendbird.android.GroupChannel.m30959a(r0, r1);
        return;
    L_0x0379:
        r0 = r12.f22705c;
        r1 = new com.sendbird.android.SendBird$81;
        r1.<init>(r11, r12);
        com.sendbird.android.GroupChannel.m30962b(r0, r1);
        return;
    L_0x0384:
        r12 = r0.f22574a;
        r3 = r12.hashCode();
        r4 = 2004905; // 0x1e97a9 float:2.80947E-39 double:9.905547E-318;
        if (r3 == r4) goto L_0x03ad;
    L_0x038f:
        r4 = 2153860; // 0x20dd84 float:3.018201E-39 double:1.064148E-317;
        if (r3 == r4) goto L_0x03a3;
    L_0x0394:
        r2 = 2362397; // 0x240c1d float:3.310423E-39 double:1.167179E-317;
        if (r3 == r2) goto L_0x039a;
    L_0x0399:
        goto L_0x03b7;
    L_0x039a:
        r2 = "MEDI";
        r12 = r12.equals(r2);
        if (r12 == 0) goto L_0x03b7;
    L_0x03a2:
        goto L_0x03b8;
    L_0x03a3:
        r1 = "FEDI";
        r12 = r12.equals(r1);
        if (r12 == 0) goto L_0x03b7;
    L_0x03ab:
        r1 = r2;
        goto L_0x03b8;
    L_0x03ad:
        r1 = "AEDI";
        r12 = r12.equals(r1);
        if (r12 == 0) goto L_0x03b7;
    L_0x03b5:
        r1 = r6;
        goto L_0x03b8;
    L_0x03b7:
        r1 = r7;
    L_0x03b8:
        switch(r1) {
            case 0: goto L_0x03e3;
            case 1: goto L_0x03d9;
            case 2: goto L_0x03cf;
            default: goto L_0x03bb;
        };
    L_0x03bb:
        r11 = new java.lang.StringBuilder;
        r12 = "Discard a command: ";
        r11.<init>(r12);
        r12 = r0.f22574a;
        r11.append(r12);
        r11 = r11.toString();
        com.sendbird.android.Logger.m24934b(r11);
        return;
    L_0x03cf:
        r12 = new com.sendbird.android.AdminMessage;
        r0 = r0.m24896d();
        r12.<init>(r0);
        goto L_0x03ec;
    L_0x03d9:
        r12 = new com.sendbird.android.FileMessage;
        r0 = r0.m24896d();
        r12.<init>(r0);
        goto L_0x03ec;
    L_0x03e3:
        r12 = new com.sendbird.android.UserMessage;
        r0 = r0.m24896d();
        r12.<init>(r0);
    L_0x03ec:
        r0 = r12.m24881i();
        if (r0 == 0) goto L_0x03ff;
    L_0x03f2:
        r0 = r12.m24880h();
        r1 = new com.sendbird.android.SendBird$78;
        r1.<init>(r11, r12);
        com.sendbird.android.GroupChannel.m30962b(r0, r1);
        return;
    L_0x03ff:
        r0 = r12.m24880h();
        r1 = new com.sendbird.android.SendBird$79;
        r1.<init>(r11, r12);
        com.sendbird.android.OpenChannel.m31002b(r0, r1);
        return;
    L_0x040c:
        r12 = r0.f22574a;
        r5 = r12.hashCode();
        r8 = 2004227; // 0x1e9503 float:2.80852E-39 double:9.902197E-318;
        if (r5 == r8) goto L_0x043e;
    L_0x0417:
        r8 = 2047193; // 0x1f3cd9 float:2.868728E-39 double:1.0114477E-317;
        if (r5 == r8) goto L_0x0434;
    L_0x041c:
        if (r5 == r4) goto L_0x042a;
    L_0x041e:
        if (r5 == r3) goto L_0x0421;
    L_0x0420:
        goto L_0x0448;
    L_0x0421:
        r2 = "MESG";
        r12 = r12.equals(r2);
        if (r12 == 0) goto L_0x0448;
    L_0x0429:
        goto L_0x0449;
    L_0x042a:
        r1 = "FILE";
        r12 = r12.equals(r1);
        if (r12 == 0) goto L_0x0448;
    L_0x0432:
        r1 = r2;
        goto L_0x0449;
    L_0x0434:
        r1 = "BRDM";
        r12 = r12.equals(r1);
        if (r12 == 0) goto L_0x0448;
    L_0x043c:
        r1 = r6;
        goto L_0x0449;
    L_0x043e:
        r1 = "ADMM";
        r12 = r12.equals(r1);
        if (r12 == 0) goto L_0x0448;
    L_0x0446:
        r1 = r9;
        goto L_0x0449;
    L_0x0448:
        r1 = r7;
    L_0x0449:
        switch(r1) {
            case 0: goto L_0x0474;
            case 1: goto L_0x046a;
            case 2: goto L_0x0460;
            case 3: goto L_0x0460;
            default: goto L_0x044c;
        };
    L_0x044c:
        r11 = new java.lang.StringBuilder;
        r12 = "Discard a command: ";
        r11.<init>(r12);
        r12 = r0.f22574a;
        r11.append(r12);
        r11 = r11.toString();
        com.sendbird.android.Logger.m24934b(r11);
        return;
    L_0x0460:
        r12 = new com.sendbird.android.AdminMessage;
        r0 = r0.m24896d();
        r12.<init>(r0);
        goto L_0x047d;
    L_0x046a:
        r12 = new com.sendbird.android.FileMessage;
        r0 = r0.m24896d();
        r12.<init>(r0);
        goto L_0x047d;
    L_0x0474:
        r12 = new com.sendbird.android.UserMessage;
        r0 = r0.m24896d();
        r12.<init>(r0);
    L_0x047d:
        r0 = r12.m24881i();
        if (r0 == 0) goto L_0x04a5;
    L_0x0483:
        r0 = r12.m24880h();
        r1 = com.sendbird.android.GroupChannel.f30084g;
        r1 = r1.containsKey(r0);
        if (r1 != 0) goto L_0x0498;
    L_0x048f:
        r1 = new com.sendbird.android.SendBird$75;
        r1.<init>(r11, r12);
        com.sendbird.android.GroupChannel.m30959a(r0, r1);
        return;
    L_0x0498:
        r0 = r12.m24880h();
        r1 = new com.sendbird.android.SendBird$76;
        r1.<init>(r11, r12);
        com.sendbird.android.GroupChannel.m30962b(r0, r1);
        return;
    L_0x04a5:
        r0 = r12.m24880h();
        r1 = new com.sendbird.android.SendBird$77;
        r1.<init>(r11, r12);
        com.sendbird.android.OpenChannel.m31002b(r0, r1);
        return;
    L_0x04b2:
        r12 = r11.f22845u;
        monitor-enter(r12);
        r3 = r11.f22842r;	 Catch:{ all -> 0x059b }
        if (r3 == 0) goto L_0x0599;
    L_0x04b9:
        r3 = r0.m24896d();	 Catch:{ all -> 0x059b }
        r3 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r4 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r6 = "error";
        r4 = r4.m31129a(r6);	 Catch:{ all -> 0x059b }
        if (r4 == 0) goto L_0x0545;
    L_0x04cd:
        r4 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r6 = "error";
        r4 = r4.m31130b(r6);	 Catch:{ all -> 0x059b }
        r4 = r4 instanceof com.sendbird.android.shadow.com.google.gson.JsonPrimitive;	 Catch:{ all -> 0x059b }
        if (r4 == 0) goto L_0x0545;
    L_0x04db:
        r4 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r6 = "error";
        r4 = r4.m31130b(r6);	 Catch:{ all -> 0x059b }
        r4 = r4.mo5248g();	 Catch:{ all -> 0x059b }
        if (r4 == 0) goto L_0x0545;
    L_0x04eb:
        r0 = "";
        r2 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r4 = "message";
        r2 = r2.m31129a(r4);	 Catch:{ all -> 0x059b }
        if (r2 == 0) goto L_0x0515;
    L_0x04f9:
        r2 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r4 = "message";
        r2 = r2.m31130b(r4);	 Catch:{ all -> 0x059b }
        r2 = r2 instanceof com.sendbird.android.shadow.com.google.gson.JsonPrimitive;	 Catch:{ all -> 0x059b }
        if (r2 == 0) goto L_0x0515;
    L_0x0507:
        r0 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r2 = "message";
        r0 = r0.m31130b(r2);	 Catch:{ all -> 0x059b }
        r0 = r0.mo5244c();	 Catch:{ all -> 0x059b }
    L_0x0515:
        r2 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r4 = "code";
        r2 = r2.m31129a(r4);	 Catch:{ all -> 0x059b }
        if (r2 == 0) goto L_0x053d;
    L_0x0521:
        r2 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r4 = "code";
        r2 = r2.m31130b(r4);	 Catch:{ all -> 0x059b }
        r2 = r2 instanceof com.sendbird.android.shadow.com.google.gson.JsonPrimitive;	 Catch:{ all -> 0x059b }
        if (r2 == 0) goto L_0x053d;
    L_0x052f:
        r1 = r3.m25073h();	 Catch:{ all -> 0x059b }
        r2 = "code";
        r1 = r1.m31130b(r2);	 Catch:{ all -> 0x059b }
        r1 = r1.mo5247f();	 Catch:{ all -> 0x059b }
    L_0x053d:
        r2 = new com.sendbird.android.SendBirdException;	 Catch:{ all -> 0x059b }
        r2.<init>(r0, r1);	 Catch:{ all -> 0x059b }
        r11.f22844t = r2;	 Catch:{ all -> 0x059b }
        goto L_0x0594;
    L_0x0545:
        r1 = "key";
        r1 = r3.m31129a(r1);	 Catch:{ all -> 0x059b }
        if (r1 == 0) goto L_0x055e;
    L_0x054d:
        r1 = com.sendbird.android.APIClient.m24818a();	 Catch:{ all -> 0x059b }
        r4 = "key";
        r4 = r3.m31130b(r4);	 Catch:{ all -> 0x059b }
        r4 = r4.mo5244c();	 Catch:{ all -> 0x059b }
        r1.m24840a(r4);	 Catch:{ all -> 0x059b }
    L_0x055e:
        r1 = "ekey";
        r1 = r3.m31129a(r1);	 Catch:{ all -> 0x059b }
        if (r1 == 0) goto L_0x0577;
    L_0x0566:
        r1 = com.sendbird.android.APIClient.m24818a();	 Catch:{ all -> 0x059b }
        r4 = "ekey";
        r4 = r3.m31130b(r4);	 Catch:{ all -> 0x059b }
        r4 = r4.mo5244c();	 Catch:{ all -> 0x059b }
        r1.m24849b(r4);	 Catch:{ all -> 0x059b }
    L_0x0577:
        r1 = "user_id";
        r1 = r3.m31129a(r1);	 Catch:{ all -> 0x059b }
        if (r1 == 0) goto L_0x058f;
    L_0x0580:
        r1 = m24988e();	 Catch:{ all -> 0x059b }
        r3 = new com.sendbird.android.User;	 Catch:{ all -> 0x059b }
        r0 = r0.m24896d();	 Catch:{ all -> 0x059b }
        r3.<init>(r0);	 Catch:{ all -> 0x059b }
        r1.f22837m = r3;	 Catch:{ all -> 0x059b }
    L_0x058f:
        r11.f22844t = r5;	 Catch:{ all -> 0x059b }
        r11.m25015a(r2);	 Catch:{ all -> 0x059b }
    L_0x0594:
        r11 = r11.f22842r;	 Catch:{ all -> 0x059b }
        r11.m24908b();	 Catch:{ all -> 0x059b }
    L_0x0599:
        monitor-exit(r12);	 Catch:{ all -> 0x059b }
        return;
    L_0x059b:
        r11 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x059b }
        throw r11;
    L_0x059e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBird.a(com.sendbird.android.SendBird, java.lang.String):void");
    }

    static /* synthetic */ void m24967a(final SendBirdException sendBirdException) {
        synchronized (m24988e().f22822B) {
            final LinkedHashSet linkedHashSet = (LinkedHashSet) m24988e().f22822B.clone();
            m24988e().f22822B.clear();
            m24968a(new Runnable() {
                public final void run() {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        ConnectHandler connectHandler = (ConnectHandler) it.next();
                        if (sendBirdException != null) {
                            connectHandler.mo4559a(null, sendBirdException);
                        } else {
                            connectHandler.mo4559a(SendBird.m25001k(), null);
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ void m25009p(SendBird sendBird) {
        if (sendBird.f22843s != null) {
            sendBird.f22843s.m24909c();
            sendBird.f22843s = null;
        }
        sendBird.f22843s = new CountDownTimer(1000, 100, true);
        sendBird.f22843s.f22578a = new C24092(sendBird);
        sendBird.f22843s.m24907a();
    }

    static /* synthetic */ void m24965a(SendBird sendBird, final BaseChannel baseChannel, ChannelEvent channelEvent) {
        try {
            JsonObject h = channelEvent.m24882a().m25073h();
            int i = 0;
            JsonArray c;
            if (channelEvent.f22568b == 11100) {
                if (h.m31129a("created") != null) {
                    channelEvent = new HashMap();
                    for (Entry entry : h.m31132d("created").f30235a.entrySet()) {
                        if (((JsonElement) entry.getValue()) instanceof JsonPrimitive) {
                            channelEvent.put(entry.getKey(), ((JsonElement) entry.getValue()).mo5244c());
                        }
                    }
                    m24968a(new Runnable(sendBird) {
                        final /* synthetic */ SendBird f22807c;

                        public void run() {
                            Iterator it = this.f22807c.f22830d.values().iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                    });
                }
                if (h.m31129a("updated") != null) {
                    channelEvent = new HashMap();
                    for (Entry entry2 : h.m31132d("updated").f30235a.entrySet()) {
                        if (((JsonElement) entry2.getValue()) instanceof JsonPrimitive) {
                            channelEvent.put(entry2.getKey(), ((JsonElement) entry2.getValue()).mo5244c());
                        }
                    }
                    m24968a(new Runnable(sendBird) {
                        final /* synthetic */ SendBird f22709c;

                        public void run() {
                            Iterator it = this.f22709c.f22830d.values().iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                    });
                }
                if (h.m31129a("deleted") != null) {
                    channelEvent = new ArrayList();
                    c = h.m31131c("deleted");
                    while (i < c.m31115a()) {
                        if (c.m31116a(i) instanceof JsonPrimitive) {
                            channelEvent.add(c.m31116a(i).mo5244c());
                        }
                        i++;
                    }
                    m24968a(new Runnable(sendBird) {
                        final /* synthetic */ SendBird f22712c;

                        public void run() {
                            Iterator it = this.f22712c.f22830d.values().iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                    });
                    return;
                }
            }
            if (h.m31129a("created") != null) {
                channelEvent = new HashMap();
                for (Entry entry22 : h.m31132d("created").f30235a.entrySet()) {
                    if (((JsonElement) entry22.getValue()) instanceof JsonPrimitive) {
                        channelEvent.put(entry22.getKey(), Integer.valueOf(((JsonElement) entry22.getValue()).mo5247f()));
                    }
                }
                m24968a(new Runnable(sendBird) {
                    final /* synthetic */ SendBird f22715c;

                    public void run() {
                        Iterator it = this.f22715c.f22830d.values().iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                });
            }
            if (h.m31129a("updated") != null) {
                channelEvent = new HashMap();
                for (Entry entry222 : h.m31132d("updated").f30235a.entrySet()) {
                    if (((JsonElement) entry222.getValue()) instanceof JsonPrimitive) {
                        channelEvent.put(entry222.getKey(), Integer.valueOf(((JsonElement) entry222.getValue()).mo5247f()));
                    }
                }
                m24968a(new Runnable(sendBird) {
                    final /* synthetic */ SendBird f22718c;

                    public void run() {
                        Iterator it = this.f22718c.f22830d.values().iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                });
            }
            if (h.m31129a("deleted") != null) {
                channelEvent = new ArrayList();
                c = h.m31131c("deleted");
                while (i < c.m31115a()) {
                    if (c.m31116a(i) instanceof JsonPrimitive) {
                        channelEvent.add(c.m31116a(i).mo5244c());
                    }
                    i++;
                }
                m24968a(new Runnable(sendBird) {
                    final /* synthetic */ SendBird f22721c;

                    public void run() {
                        Iterator it = this.f22721c.f22830d.values().iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                });
            }
        } catch (SendBird sendBird2) {
            sendBird2.printStackTrace();
        }
    }
}
