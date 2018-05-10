package com.instabug.library.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.net.Uri;
import com.instabug.library.C0593R;
import com.instabug.library.C0654c.C0649a;
import com.instabug.library.instacapture.C0667b;
import com.instabug.library.instacapture.p022b.C1357b;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.BitmapUtils.C0771a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;

/* compiled from: ScreenshotProvider */
public class C0753a {

    /* compiled from: ScreenshotProvider */
    public interface C0752a {
        void mo2583a(Bitmap bitmap);

        void mo2584a(Throwable th);
    }

    public static synchronized void m8313a(Activity activity, final C0752a c0752a) {
        synchronized (C0753a.class) {
            StringBuilder stringBuilder = new StringBuilder("start capture screenshot, time in MS: ");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8360v(C0753a.class, stringBuilder.toString());
            if (!(activity == null || activity.isFinishing())) {
                C0667b.m8176a(activity).m8177a(new C1357b() {
                    public final void mo2585a(Bitmap bitmap) {
                        c0752a.mo2583a(bitmap);
                    }

                    public final void mo2586a(Throwable th) {
                        c0752a.mo2584a(th);
                    }
                }, new int[]{C0593R.id.instabug_decor_view, C0593R.id.instabug_extra_screenshot_button, C0593R.id.instabug_floating_button, C0593R.id.instabug_in_app_notification, C0593R.id.instabug_intro_dialog});
            }
        }
    }

    public static void m8314a(final Activity activity, final C0649a[] c0649aArr) {
        StringBuilder stringBuilder = new StringBuilder("start capture screenshot as video frame, time in MS: ");
        stringBuilder.append(System.currentTimeMillis());
        InstabugSDKLogger.m8360v(C0753a.class, stringBuilder.toString());
        if (activity != null && !activity.isFinishing()) {
            OrientationUtils.lockScreenOrientation(activity);
            C0667b.m8176a(activity).m8177a(new C1357b() {

                /* compiled from: ScreenshotProvider */
                class C13971 implements C0771a {
                    final /* synthetic */ C16672 f15547a;

                    C13971(C16672 c16672) {
                        this.f15547a = c16672;
                    }

                    public final void mo2581a(Uri uri) {
                        StringBuilder stringBuilder = new StringBuilder("capture screenshot as video frame done successfully, videoFrameUri :");
                        stringBuilder.append(uri.getPath());
                        stringBuilder.append(", time in MS: ");
                        stringBuilder.append(System.currentTimeMillis());
                        InstabugSDKLogger.m8360v(C0753a.class, stringBuilder.toString());
                    }

                    public final void mo2582a(Throwable th) {
                        StringBuilder stringBuilder = new StringBuilder("capture screenshot as video frame got error: ");
                        stringBuilder.append(th.getMessage());
                        stringBuilder.append(", time in MS: ");
                        stringBuilder.append(System.currentTimeMillis());
                        InstabugSDKLogger.m8358e(C0753a.class, stringBuilder.toString(), th);
                    }
                }

                public final void mo2585a(Bitmap bitmap) {
                    if (c0649aArr != null) {
                        Paint paint = new Paint(1);
                        paint.setStyle(Style.FILL);
                        paint.setColor(-1711341568);
                        Canvas canvas = new Canvas(bitmap);
                        for (C0649a c0649a : c0649aArr) {
                            canvas.drawCircle((float) c0649a.f9580a, (float) c0649a.f9581b, 30.0f, paint);
                        }
                    }
                    BitmapUtils.saveBitmap(bitmap, AttachmentsUtility.getVideoRecordingFramesDirectory(activity), new C13971(this));
                }

                public final void mo2586a(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("capture screenshot as video frame got error: ");
                    stringBuilder.append(th.getMessage());
                    stringBuilder.append(", time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8358e(C0753a.class, stringBuilder.toString(), th);
                }
            }, new int[]{C0593R.id.instabug_decor_view, C0593R.id.instabug_extra_screenshot_button, C0593R.id.instabug_floating_button, C0593R.id.instabug_in_app_notification, C0593R.id.instabug_video_mute_button, C0593R.id.instabug_video_stop_button});
        }
    }
}
