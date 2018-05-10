package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;

@TargetApi(16)
public final class VideoFrameReleaseTimeHelper {
    final VSyncSampler f5328a;
    final boolean f5329b;
    final long f5330c;
    final long f5331d;
    long f5332e;
    long f5333f;
    long f5334g;
    boolean f5335h;
    long f5336i;
    long f5337j;
    long f5338k;

    private static final class VSyncSampler implements Callback, FrameCallback {
        private static final VSyncSampler f5322c = new VSyncSampler();
        public volatile long f5323a;
        final Handler f5324b;
        private final HandlerThread f5325d = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer f5326e;
        private int f5327f;

        public static VSyncSampler m4340a() {
            return f5322c;
        }

        private VSyncSampler() {
            this.f5325d.start();
            this.f5324b = new Handler(this.f5325d.getLooper(), this);
            this.f5324b.sendEmptyMessage(0);
        }

        public final void doFrame(long j) {
            this.f5323a = j;
            this.f5326e.postFrameCallbackDelayed(this, 500);
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case null:
                    this.f5326e = Choreographer.getInstance();
                    return true;
                case 1:
                    this.f5327f += 1;
                    if (this.f5327f == 1) {
                        this.f5326e.postFrameCallback(this);
                    }
                    return true;
                case 2:
                    this.f5327f -= 1;
                    if (this.f5327f == null) {
                        this.f5326e.removeFrameCallback(this);
                        this.f5323a = 0;
                    }
                    return true;
                default:
                    return null;
            }
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(-1.0d);
    }

    private VideoFrameReleaseTimeHelper(double d) {
        this.f5329b = d != -1.0d;
        if (this.f5329b) {
            this.f5328a = VSyncSampler.m4340a();
            this.f5330c = (long) (1.0E9d / d);
            this.f5331d = (this.f5330c * 80) / 100;
            return;
        }
        this.f5328a = 0.0d;
        this.f5330c = -1;
        this.f5331d = -1;
    }

    final boolean m4342a(long j, long j2) {
        return Math.abs((j2 - this.f5336i) - (j - this.f5337j)) > 20000000 ? 1 : 0;
    }

    static long m4341a(long j, long j2, long j3) {
        j2 += ((j - j2) / j3) * j3;
        if (j <= j2) {
            j3 = j2 - j3;
        } else {
            long j4 = j2;
            j2 = j3 + j2;
            j3 = j4;
        }
        return j2 - j < j - j3 ? j2 : j3;
    }

    public VideoFrameReleaseTimeHelper(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this(windowManager.getDefaultDisplay() != null ? (double) windowManager.getDefaultDisplay().getRefreshRate() : -1.0d);
    }
}
