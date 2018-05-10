package com.instabug.library.internal.video;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.internal.video.AutoScreenRecordingService.Action;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import java.io.File;
import rx.Subscription;
import rx.functions.Action1;

public class InternalAutoScreenRecorderHelper implements AutoScreenRecordingContract {
    private static InternalAutoScreenRecorderHelper INSTANCE;
    private Subscription activityLifeCycleSubscription;
    private AutoScreenRecordingFileHolder fileHolder = new AutoScreenRecordingFileHolder();
    private boolean isCrashOccurred = false;
    private Subscription sessionSubscription;

    static /* synthetic */ class C06883 {
        static final /* synthetic */ int[] f9627a = new int[ActivityLifeCycleEvent.values().length];

        static {
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = com.instabug.library.tracking.ActivityLifeCycleEvent.values();
            r0 = r0.length;
            r0 = new int[r0];
            f9627a = r0;
            r0 = f9627a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.instabug.library.tracking.ActivityLifeCycleEvent.RESUMED;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.InternalAutoScreenRecorderHelper.3.<clinit>():void");
        }
    }

    class C13671 implements Action1<SessionState> {
        final /* synthetic */ InternalAutoScreenRecorderHelper f15470a;

        C13671(InternalAutoScreenRecorderHelper internalAutoScreenRecorderHelper) {
            this.f15470a = internalAutoScreenRecorderHelper;
        }

        public final /* synthetic */ void m15386a(Object obj) {
            if (((SessionState) obj) == SessionState.FINISH && this.f15470a.isCrashOccurred() == null) {
                AutoScreenRecordingEventBus.getInstance().post(Action.STOP_DELETE);
                SettingsManager.getInstance().setAutoScreenRecordingDenied(false);
                this.f15470a.unsubscribeFromSessionEvents();
            }
        }
    }

    class C13682 implements Action1<ActivityLifeCycleEvent> {
        final /* synthetic */ InternalAutoScreenRecorderHelper f15471a;

        class C06871 implements Runnable {
            final /* synthetic */ C13682 f9626a;

            C06871(C13682 c13682) {
                this.f9626a = c13682;
            }

            public void run() {
                InternalAutoScreenRecorderHelper.getInstance().start();
            }
        }

        C13682(InternalAutoScreenRecorderHelper internalAutoScreenRecorderHelper) {
            this.f15471a = internalAutoScreenRecorderHelper;
        }

        public final /* synthetic */ void m15387a(Object obj) {
            if (C06883.f9627a[((ActivityLifeCycleEvent) obj).ordinal()] == 1) {
                this.f15471a.subscribeToSessionEvents();
                new Handler().postDelayed(new C06871(this), 500);
            }
        }
    }

    public static InternalAutoScreenRecorderHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InternalAutoScreenRecorderHelper();
        }
        return INSTANCE;
    }

    public InternalAutoScreenRecorderHelper() {
        subscribeToSessionEvents();
        subscribeToActivityLifeCycleEvents();
    }

    public Uri getAutoScreenRecordingFileUri() {
        return this.fileHolder.getAutoScreenRecordingFileUri();
    }

    public void setAutoScreenRecordingFile(File file) {
        this.fileHolder.setAutoScreenRecordingFile(file);
    }

    public void delete() {
        this.fileHolder.delete();
    }

    public void clear() {
        this.fileHolder.clear();
    }

    public boolean isEnabled() {
        return SettingsManager.getInstance().autoScreenRecordingEnabled();
    }

    public boolean isCrashOccurred() {
        return this.isCrashOccurred;
    }

    public void setCrashOccurred(boolean z) {
        this.isCrashOccurred = z;
    }

    private void subscribeToSessionEvents() {
        if (this.sessionSubscription == null || this.sessionSubscription.d()) {
            this.sessionSubscription = SessionStateEventBus.getInstance().subscribe(new C13671(this));
        }
    }

    private void subscribeToActivityLifeCycleEvents() {
        if (this.activityLifeCycleSubscription == null || this.activityLifeCycleSubscription.d()) {
            this.activityLifeCycleSubscription = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new C13682(this));
        }
    }

    private void unsubscribeFromSessionEvents() {
        if (!this.sessionSubscription.d()) {
            this.sessionSubscription.c();
        }
    }

    public void start() {
        if (!(SettingsManager.getInstance().isScreenCurrentlyRecorded() || SettingsManager.getInstance().isAutoScreenRecordingDenied())) {
            if (isEnabled()) {
                Context targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
                if (!(targetActivity == null || (targetActivity instanceof _InstabugActivity) || !SettingsManager.getInstance().isAppOnForeground() || Instabug.getState() != InstabugState.ENABLED || InstabugCore.isForegroundBusy())) {
                    targetActivity.startActivity(new Intent(targetActivity, RequestPermissionActivity.class));
                    targetActivity.overridePendingTransition(0, 0);
                }
            }
        }
    }
}
