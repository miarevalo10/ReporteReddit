package com.instabug.library.internal.video;

import android.net.Uri;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.internal.media.C0679a;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.video.C0701c.C0699a;
import com.instabug.library.internal.video.C0701c.C0700b;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.p025a.C0725c;
import com.instabug.library.invocation.p025a.C0725c.C0724c;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.C0775c;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import rx.Subscription;
import rx.functions.Action1;

public class InternalScreenRecordHelper implements C0700b, C0724c {
    private static InternalScreenRecordHelper INSTANCE;
    private C0725c fab;
    private Subscription sessionSubscription;

    class C13691 implements Action1<SessionState> {
        final /* synthetic */ InternalScreenRecordHelper f15472a;

        C13691(InternalScreenRecordHelper internalScreenRecordHelper) {
            this.f15472a = internalScreenRecordHelper;
        }

        public final /* synthetic */ void m15388a(Object obj) {
            if (((SessionState) obj) == SessionState.FINISH) {
                this.f15472a.cancel();
            }
        }
    }

    public void pause() {
    }

    private InternalScreenRecordHelper() {
    }

    public static InternalScreenRecordHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InternalScreenRecordHelper();
        }
        return INSTANCE;
    }

    public void init() {
        C1381b.m15431c().f15519d = false;
        if (this.fab == null) {
            this.fab = new C0725c(this);
        }
        this.fab.m8272a();
    }

    public void start() {
        subscribeToSessionEvents();
        startSnapping();
    }

    public void stop() {
        C0701c a = C0701c.m8217a();
        if (a.f9667a != null) {
            a.f9667a.f9661a = true;
            a.f9668b = false;
            a.f9669c.removeCallbacks(a.f9670d);
            if (a.f9671e != null) {
                a.f9671e.m8189b();
            }
        }
        release();
    }

    public void release() {
        if (this.fab != null) {
            this.fab.m8273b();
        }
        unsubscribeFromSessionEvents();
        C1381b.m15431c().f15519d = true;
        C0775c.m8366b(Instabug.getApplicationContext());
    }

    public void cancel() {
        if (isRecording()) {
            C0701c a = C0701c.m8217a();
            StringBuilder stringBuilder = new StringBuilder("Frame Snapper: ");
            stringBuilder.append(String.valueOf(a.f9667a != null));
            InstabugSDKLogger.m8359i(a, stringBuilder.toString());
            if (a.f9667a != null) {
                a.f9667a.cancel(true);
                a.f9667a.f9661a = true;
                a.f9668b = false;
                a.f9669c.removeCallbacks(a.f9670d);
                if (a.f9671e != null) {
                    a.f9671e.m8189b();
                }
                new File(a.f9672f).delete();
            }
            C0775c.m8366b(Instabug.getApplicationContext());
            if (this.fab != null) {
                this.fab.m8273b();
                this.fab.m8272a();
            }
            InstabugSDKLogger.m8356d(this, "Cancelling screen recording");
            SettingsManager.getInstance().setVideoProcessorBusy(false);
        }
    }

    private void startSnapping() {
        if (!C0701c.m8217a().f9668b) {
            C0701c a = C0701c.m8217a();
            a.f9667a = new C0699a(a, this);
            a.f9667a.execute(new Void[0]);
            a.f9668b = true;
            a.f9669c.postDelayed(a.f9670d, 30000);
            if (C0775c.m8365a()) {
                InstabugSDKLogger.m8359i(a, "Audio permission granted");
                File instabugDirectory = DiskUtils.getInstabugDirectory(Instabug.getApplicationContext());
                StringBuilder stringBuilder = new StringBuilder("audioMessage_");
                stringBuilder.append(String.valueOf(System.currentTimeMillis()));
                stringBuilder.append(".mp4");
                a.f9672f = new File(instabugDirectory, stringBuilder.toString()).getAbsolutePath();
                a.f9671e = new C0679a(a.f9672f);
                C0775c.m8364a(Instabug.getApplicationContext());
                a.f9671e.m8188a();
                return;
            }
            InstabugSDKLogger.m8357e(a, "Audio permission is not granted");
        }
    }

    public boolean isRecording() {
        if (!C0701c.m8217a().f9668b) {
            if (!SettingsManager.getInstance().isVideoProcessorBusy()) {
                return false;
            }
        }
        return true;
    }

    private void subscribeToSessionEvents() {
        if (this.sessionSubscription == null || this.sessionSubscription.d()) {
            this.sessionSubscription = SessionStateEventBus.getInstance().subscribe(new C13691(this));
        }
    }

    private void unsubscribeFromSessionEvents() {
        if (!this.sessionSubscription.d()) {
            this.sessionSubscription.c();
        }
    }

    public void onFramesCapturingFinished(String str) {
        File videoFile = AttachmentsUtility.getVideoFile(Instabug.getApplicationContext());
        ScreenRecordingEventBus.getInstance().post(new ScreenRecordEvent(0, Uri.fromFile(videoFile)));
        InstabugSDKLogger.m8359i(this, "Encoding...");
        VideoProcessingService.m8205a(Instabug.getApplicationContext(), videoFile.getPath(), str);
    }
}
