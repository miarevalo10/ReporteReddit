package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

public class SessionMonitor<T extends Session> {
    protected final MonitorState f23941a;
    private final SystemCurrentTimeProvider f23942b;
    private final SessionManager<T> f23943c;
    private final ExecutorService f23944d;
    private final SessionVerifier f23945e;

    class C20642 implements Runnable {
        final /* synthetic */ SessionMonitor f23940a;

        C20642(SessionMonitor sessionMonitor) {
            this.f23940a = sessionMonitor;
        }

        public void run() {
            this.f23940a.m25859b();
        }
    }

    protected static class MonitorState {
        private static final long TIME_THRESHOLD_IN_MILLIS = 21600000;
        public long lastVerification;
        private final Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        public boolean verifying;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean beginVerification(long r6) {
            /*
            r5 = this;
            monitor-enter(r5);
            r0 = r5.lastVerification;	 Catch:{ all -> 0x0026 }
            r0 = r6 - r0;
            r2 = 21600000; // 0x1499700 float:3.7026207E-38 double:1.0671818E-316;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            r1 = 0;
            r2 = 1;
            if (r0 <= 0) goto L_0x0010;
        L_0x000e:
            r0 = r2;
            goto L_0x0011;
        L_0x0010:
            r0 = r1;
        L_0x0011:
            r3 = r5.lastVerification;	 Catch:{ all -> 0x0026 }
            r6 = r5.isOnSameDate(r6, r3);	 Catch:{ all -> 0x0026 }
            r6 = r6 ^ r2;
            r7 = r5.verifying;	 Catch:{ all -> 0x0026 }
            if (r7 != 0) goto L_0x0024;
        L_0x001c:
            if (r0 != 0) goto L_0x0020;
        L_0x001e:
            if (r6 == 0) goto L_0x0024;
        L_0x0020:
            r5.verifying = r2;	 Catch:{ all -> 0x0026 }
            monitor-exit(r5);
            return r2;
        L_0x0024:
            monitor-exit(r5);
            return r1;
        L_0x0026:
            r6 = move-exception;
            monitor-exit(r5);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.SessionMonitor.MonitorState.beginVerification(long):boolean");
        }

        public synchronized void endVerification(long j) {
            this.verifying = false;
            this.lastVerification = j;
        }

        private boolean isOnSameDate(long j, long j2) {
            this.utcCalendar.setTimeInMillis(j);
            j = this.utcCalendar.get(6);
            int i = this.utcCalendar.get(1);
            this.utcCalendar.setTimeInMillis(j2);
            int i2 = this.utcCalendar.get(6);
            j2 = this.utcCalendar.get(1);
            if (j == i2 && i == j2) {
                return true;
            }
            return 0;
        }
    }

    class C25251 extends Callbacks {
        final /* synthetic */ SessionMonitor f30714a;

        public C25251(SessionMonitor sessionMonitor) {
            this.f30714a = sessionMonitor;
        }

        public void onActivityStarted(Activity activity) {
            this.f30714a.m25858a();
        }
    }

    public SessionMonitor(SessionManager<T> sessionManager, ExecutorService executorService, SessionVerifier<T> sessionVerifier) {
        this(sessionManager, new SystemCurrentTimeProvider(), executorService, new MonitorState(), sessionVerifier);
    }

    private SessionMonitor(SessionManager<T> sessionManager, SystemCurrentTimeProvider systemCurrentTimeProvider, ExecutorService executorService, MonitorState monitorState, SessionVerifier sessionVerifier) {
        this.f23942b = systemCurrentTimeProvider;
        this.f23943c = sessionManager;
        this.f23944d = executorService;
        this.f23941a = monitorState;
        this.f23945e = sessionVerifier;
    }

    public final void m25858a() {
        Object obj = (this.f23943c.mo5463a() == null || !this.f23941a.beginVerification(System.currentTimeMillis())) ? null : 1;
        if (obj != null) {
            this.f23944d.submit(new C20642(this));
        }
    }

    protected final void m25859b() {
        for (Session a : this.f23943c.mo5466b().values()) {
            this.f23945e.mo5483a(a);
        }
        this.f23941a.endVerification(System.currentTimeMillis());
    }
}
