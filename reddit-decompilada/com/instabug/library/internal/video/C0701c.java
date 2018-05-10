package com.instabug.library.internal.video;

import android.os.AsyncTask;
import android.os.Handler;
import com.instabug.library.C0654c;
import com.instabug.library.C0654c.C0649a;
import com.instabug.library.Instabug;
import com.instabug.library.internal.media.C0679a;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.screenshot.C0753a;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.util.Arrays;

@SuppressFBWarnings({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
/* compiled from: VideoFrameSnapper */
public class C0701c {
    private static C0701c f9666g;
    C0699a f9667a;
    boolean f9668b = false;
    Handler f9669c = new Handler();
    Runnable f9670d = new C06971(this);
    C0679a f9671e;
    String f9672f;

    /* compiled from: VideoFrameSnapper */
    class C06971 implements Runnable {
        final /* synthetic */ C0701c f9659a;

        C06971(C0701c c0701c) {
            this.f9659a = c0701c;
        }

        public void run() {
            InstabugSDKLogger.m8359i(this, "Time limit has been reached, stopping recording");
            InternalScreenRecordHelper.getInstance().stop();
        }
    }

    /* compiled from: VideoFrameSnapper */
    private class C0699a extends AsyncTask<Void, Void, Void> {
        boolean f9661a = null;
        final /* synthetic */ C0701c f9662b;
        private C0700b f9663c;
        private Handler f9664d;
        private C0649a[] f9665e = null;

        /* compiled from: VideoFrameSnapper */
        class C06981 implements Runnable {
            final /* synthetic */ C0699a f9660a;

            C06981(C0699a c0699a) {
                this.f9660a = c0699a;
            }

            public void run() {
                if (this.f9660a.f9661a) {
                    this.f9660a.f9664d.removeCallbacks(this);
                    if (this.f9660a.isCancelled()) {
                        this.f9660a.onCancelled();
                        return;
                    } else {
                        this.f9660a.f9663c.onFramesCapturingFinished(this.f9660a.f9662b.f9672f);
                        return;
                    }
                }
                C0649a[] c0649aArr;
                C0699a c0699a = this.f9660a;
                C0654c a = C0654c.m8154a();
                if (a.f9583a == null) {
                    c0649aArr = null;
                } else {
                    c0649aArr = (C0649a[]) Arrays.copyOf(a.f9583a, a.f9583a.length);
                }
                c0699a.f9665e = c0649aArr;
                C0701c.m8219a(this.f9660a.f9665e);
                this.f9660a.f9665e = null;
                if (!this.f9660a.isCancelled()) {
                    this.f9660a.f9664d.postDelayed(this, 125);
                }
            }
        }

        public C0699a(C0701c c0701c, C0700b c0700b) {
            this.f9662b = c0701c;
            this.f9663c = c0700b;
            this.f9664d = new Handler();
        }

        protected void onCancelled() {
            super.onCancelled();
            InstabugSDKLogger.m8359i(this, "Cancelling video recording");
            File[] listFiles = AttachmentsUtility.getVideoRecordingFramesDirectory(Instabug.getApplicationContext()).listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
            InstabugSDKLogger.m8356d(this, "Video frames are removed");
            C1381b.m15431c().m15437a(null);
            C1381b.m15431c().m15439d();
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            objArr = new StringBuilder("Video recording status: ");
            objArr.append(String.valueOf(isCancelled()));
            InstabugSDKLogger.m8359i(this, objArr.toString());
            if (isCancelled() == null) {
                this.f9664d.post(new C06981(this));
            }
            return null;
        }
    }

    /* compiled from: VideoFrameSnapper */
    public interface C0700b {
        void onFramesCapturingFinished(String str);
    }

    public static C0701c m8217a() {
        if (f9666g == null) {
            f9666g = new C0701c();
        }
        return f9666g;
    }

    public static void m8219a(C0649a[] c0649aArr) {
        C0753a.m8314a(InstabugInternalTrackingDelegate.getInstance().getTargetActivity(), c0649aArr);
    }
}
