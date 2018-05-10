package com.instabug.library.core;

import android.graphics.Bitmap;
import android.net.Uri;
import com.instabug.library.screenshot.C0753a;
import com.instabug.library.screenshot.C0753a.C0752a;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.BitmapUtils.C0771a;
import com.instabug.library.util.InstabugSDKLogger;

public class InitialScreenshotHelper {

    public interface InitialScreenshotCapturingListener {
        void onScreenshotCapturedSuccessfully(Uri uri);

        void onScreenshotCapturingFailed(Throwable th);
    }

    public static void captureScreenshot(final InitialScreenshotCapturingListener initialScreenshotCapturingListener) {
        C0753a.m8313a(InstabugInternalTrackingDelegate.getInstance().getTargetActivity(), new C0752a() {

            class C13541 implements C0771a {
                final /* synthetic */ C13551 f15460a;

                C13541(C13551 c13551) {
                    this.f15460a = c13551;
                }

                public final void mo2581a(Uri uri) {
                    initialScreenshotCapturingListener.onScreenshotCapturedSuccessfully(uri);
                }

                public final void mo2582a(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("initial screenshot capturing got error: ");
                    stringBuilder.append(th.getMessage());
                    stringBuilder.append(", time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
                    initialScreenshotCapturingListener.onScreenshotCapturingFailed(th);
                }
            }

            public final void mo2583a(Bitmap bitmap) {
                BitmapUtils.saveBitmap(bitmap, InstabugInternalTrackingDelegate.getInstance().getTargetActivity(), new C13541(this));
            }

            public final void mo2584a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("initial screenshot capturing got error: ");
                stringBuilder.append(th.getMessage());
                stringBuilder.append(", time in MS: ");
                stringBuilder.append(System.currentTimeMillis());
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
                initialScreenshotCapturingListener.onScreenshotCapturingFailed(th);
            }
        });
    }
}
