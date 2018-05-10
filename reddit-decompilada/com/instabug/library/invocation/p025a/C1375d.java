package com.instabug.library.invocation.p025a;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.invocation.C0729a;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;

/* compiled from: ScreenshotGestureInvoker */
public class C1375d implements C0711a<Void> {
    private boolean f15502a = true;
    private List<C0727a> f15503b = new ArrayList();

    /* compiled from: ScreenshotGestureInvoker */
    private static class C0727a extends FileObserver {
        private String f9771a;
        private long f9772b;
        private final Handler f9773c = new Handler();
        private Runnable f9774d;
        private C0729a f9775e;
        private String f9776f;
        private String f9777g;

        /* compiled from: ScreenshotGestureInvoker */
        class C07261 implements Runnable {
            final /* synthetic */ C0727a f9770a;

            C07261(C0727a c0727a) {
                this.f9770a = c0727a;
            }

            public void run() {
                File file = new File(this.f9770a.f9771a);
                if (file.listFiles() != null) {
                    StringBuilder stringBuilder = new StringBuilder("The path is directory: ");
                    stringBuilder.append(file.isDirectory());
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                StringBuilder stringBuilder2 = new StringBuilder("File name: ");
                                stringBuilder2.append(file2.getName());
                                stringBuilder2.append("File last modified: ");
                                stringBuilder2.append(file2.lastModified());
                                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                                if (this.f9770a.m8276a(file2.getName())) {
                                    stringBuilder2 = new StringBuilder("Screenshot taken: ");
                                    stringBuilder2.append(file2.getPath());
                                    stringBuilder2.append(", invoking SDK");
                                    InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                                    this.f9770a.f9775e.mo2600a(Uri.fromFile(file2));
                                }
                            }
                        }
                    }
                }
                this.f9770a.f9773c.postDelayed(this.f9770a.f9774d, 1000);
            }
        }

        C0727a(String str, C0729a c0729a) {
            super(str);
            this.f9771a = str;
            this.f9775e = c0729a;
        }

        public void onEvent(int i, String str) {
            StringBuilder stringBuilder = new StringBuilder("Event:");
            stringBuilder.append(i);
            stringBuilder.append("\t");
            stringBuilder.append(str);
            InstabugSDKLogger.m8359i(this, stringBuilder.toString());
            if (str == null) {
                InstabugSDKLogger.m8359i(this, "Ignore this event.");
                return;
            }
            if (i == 256 || i == 32) {
                this.f9776f = str;
            }
            if (i == 2 && this.f9776f.equals(str)) {
                this.f9777g = str;
            }
            if (!(i != 8 || this.f9777g.equals(this.f9776f) == 0 || this.f9777g.equals(str) == 0 || m8276a(str) == 0)) {
                i = new StringBuilder("Screenshot taken: ");
                i.append(this.f9771a);
                i.append(Operation.DIVISION);
                i.append(str);
                i.append(", invoking SDK");
                InstabugSDKLogger.m8356d(this, i.toString());
                i = this.f9775e;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.f9771a);
                stringBuilder2.append(Operation.DIVISION);
                stringBuilder2.append(str);
                i.mo2600a(Uri.fromFile(new File(stringBuilder2.toString())));
            }
        }

        public final void m8280a() {
            if (VERSION.SDK_INT == 23) {
                startWatching();
            } else {
                super.startWatching();
            }
        }

        public final void m8281b() {
            if (VERSION.SDK_INT == 23) {
                stopWatching();
            } else {
                super.stopWatching();
            }
        }

        public void startWatching() {
            this.f9774d = new C07261(this);
            this.f9773c.post(this.f9774d);
        }

        public void stopWatching() {
            this.f9773c.removeCallbacks(this.f9774d);
        }

        private boolean m8276a(String str) {
            if (str.toLowerCase().contains("screenshot")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f9771a);
                stringBuilder.append(Operation.DIVISION);
                stringBuilder.append(str);
                File file = new File(stringBuilder.toString());
                if (this.f9772b == file.lastModified()) {
                    return false;
                }
                this.f9772b = file.lastModified();
                long currentTimeMillis = System.currentTimeMillis() - this.f9772b;
                str = new StringBuilder("Difference time between file lastUpdate and currentTime: ");
                str.append(currentTimeMillis);
                InstabugSDKLogger.m8356d(this, str.toString());
                if (currentTimeMillis < 1800) {
                    InstabugSDKLogger.m8356d(this, "Send event to listener.");
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: ScreenshotGestureInvoker */
    class C13741 implements Action1<SessionState> {
        final /* synthetic */ C1375d f15501a;

        C13741(C1375d c1375d) {
            this.f15501a = c1375d;
        }

        public final /* synthetic */ void m15408a(Object obj) {
            if (((SessionState) obj).equals(SessionState.START) != null) {
                this.f15501a.f15502a = true;
            }
        }
    }

    public C1375d(C0729a c0729a) {
        this.f15503b.add(new C0727a(C1375d.m15409a(Environment.DIRECTORY_PICTURES), c0729a));
        this.f15503b.add(new C0727a(C1375d.m15409a(Environment.DIRECTORY_DCIM), c0729a));
        SessionStateEventBus.getInstance().subscribe(new C13741(this));
    }

    public final void mo2596a() {
        if (!this.f15502a || C1375d.m15411c()) {
            if (C1375d.m15411c()) {
                for (C0727a a : this.f15503b) {
                    a.m8280a();
                }
            }
            return;
        }
        if (C1381b.m15431c().f15517b == InstabugInvocationEvent.SCREENSHOT_GESTURE) {
            Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                PermissionsUtils.requestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 1, null, null);
                this.f15502a = false;
            }
        }
    }

    private static boolean m15411c() {
        Context currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        return currentActivity != null ? PermissionsUtils.isPermissionGranted(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE") : false;
    }

    public final void mo2597b() {
        for (C0727a b : this.f15503b) {
            b.m8281b();
        }
    }

    private static String m15409a(String str) {
        return new File(Environment.getExternalStoragePublicDirectory(str), "Screenshots").getAbsolutePath();
    }
}
