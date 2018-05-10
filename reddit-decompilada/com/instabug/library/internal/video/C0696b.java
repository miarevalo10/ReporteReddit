package com.instabug.library.internal.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

@TargetApi(21)
/* compiled from: RecordingSession */
final class C0696b {
    String f9648a;
    private final Context f9649b;
    private final C0694a f9650c;
    private final int f9651d;
    private final Intent f9652e;
    private final File f9653f;
    private final MediaProjectionManager f9654g;
    private MediaRecorder f9655h;
    private MediaProjection f9656i;
    private VirtualDisplay f9657j;
    private boolean f9658k;

    /* compiled from: RecordingSession */
    class C06921 implements Runnable {
        final /* synthetic */ C0696b f9641a;

        C06921(C0696b c0696b) {
            this.f9641a = c0696b;
        }

        public void run() {
            if (new File(this.f9641a.f9648a).delete()) {
                InstabugSDKLogger.m8356d(this, "Screen recording file deleted");
            }
        }
    }

    /* compiled from: RecordingSession */
    class C06932 implements Runnable {
        final /* synthetic */ int f9642a;
        final /* synthetic */ C0696b f9643b;

        C06932(C0696b c0696b, int i) {
            this.f9643b = c0696b;
            this.f9642a = i;
        }

        public void run() {
            try {
                InternalAutoScreenRecorderHelper.getInstance().setAutoScreenRecordingFile(InstabugVideoUtils.startTrim(new File(this.f9643b.f9648a), AttachmentManager.getAutoScreenRecordingFile(this.f9643b.f9649b), this.f9642a));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: RecordingSession */
    interface C0694a {
    }

    /* compiled from: RecordingSession */
    static final class C0695b {
        final int f9644a;
        final int f9645b;
        final int f9646c;
        final int f9647d;

        C0695b(int i, int i2, int i3, int i4) {
            this.f9644a = i;
            this.f9645b = i2;
            this.f9646c = i3;
            this.f9647d = i4;
        }
    }

    C0696b(Context context, C0694a c0694a, int i, Intent intent) {
        this.f9649b = context;
        this.f9650c = c0694a;
        this.f9651d = i;
        this.f9652e = intent;
        this.f9653f = AttachmentManager.getAutoScreenRecordingVideosDirectory(context);
        this.f9654g = (MediaProjectionManager) context.getSystemService("media_projection");
        if (this.f9653f.exists() == null && this.f9653f.mkdirs() == null) {
            InstabugSDKLogger.m8356d(this, "Unable to create output directory.\nCannot record screen.");
            return;
        }
        CamcorderProfile camcorderProfile;
        int i2;
        context = new DisplayMetrics();
        ((WindowManager) this.f9649b.getSystemService("window")).getDefaultDisplay().getRealMetrics(context);
        c0694a = context.widthPixels;
        i = context.heightPixels;
        context = context.densityDpi;
        intent = this.f9649b.getResources().getConfiguration().orientation == 2 ? 1 : null;
        if (CamcorderProfile.hasProfile(1007)) {
            camcorderProfile = CamcorderProfile.get(1007);
        } else {
            camcorderProfile = CamcorderProfile.get(0);
        }
        int i3 = camcorderProfile != null ? camcorderProfile.videoFrameWidth : -1;
        int i4 = camcorderProfile != null ? camcorderProfile.videoFrameHeight : -1;
        if (camcorderProfile != null) {
            i2 = camcorderProfile.videoFrameRate;
        } else {
            i2 = 30;
        }
        c0694a = (c0694a * 50) / 100;
        i = (i * 50) / 100;
        if (i3 == -1 && i4 == -1) {
            intent = new C0695b(c0694a, i, i2, context);
        } else {
            int i5 = intent != null ? i3 : i4;
            if (intent != null) {
                i3 = i4;
            }
            if (i5 < c0694a || i3 < i) {
                if (intent != null) {
                    i5 = (c0694a * i3) / i;
                } else {
                    i3 = (i * i5) / c0694a;
                }
                intent = new C0695b(i5, i3, i2, context);
            } else {
                intent = new C0695b(c0694a, i, i2, context);
            }
        }
        this.f9655h = new MediaRecorder();
        this.f9655h.setVideoSource(2);
        this.f9655h.setOutputFormat(2);
        this.f9655h.setVideoFrameRate(intent.f9646c);
        this.f9655h.setVideoEncoder(2);
        this.f9655h.setVideoSize(intent.f9644a, intent.f9645b);
        this.f9655h.setVideoEncodingBitRate(8000000);
        this.f9648a = AttachmentManager.getAutoScreenRecordingFile(this.f9649b).getAbsolutePath();
        this.f9655h.setOutputFile(this.f9648a);
        try {
            this.f9655h.prepare();
            this.f9656i = this.f9654g.getMediaProjection(this.f9651d, this.f9652e);
            this.f9657j = this.f9656i.createVirtualDisplay(SettingsManager.INSTABUG_SHARED_PREF_NAME, intent.f9644a, intent.f9645b, intent.f9647d, 2, this.f9655h.getSurface(), null, null);
            this.f9655h.start();
            this.f9658k = true;
            InstabugSDKLogger.m8359i(this, "Screen recording started");
        } catch (Context context2) {
            throw new RuntimeException("Unable to prepare MediaRecorder.", context2);
        }
    }

    final void m8210a() {
        if (!this.f9658k) {
            return;
        }
        if (this.f9658k) {
            this.f9658k = false;
            this.f9656i.stop();
            this.f9655h.stop();
            this.f9655h.reset();
            this.f9655h.release();
            this.f9657j.release();
            InstabugSDKLogger.m8356d(this, "Screen recording stopped");
            return;
        }
        throw new IllegalStateException("Not running.");
    }
}
