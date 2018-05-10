package com.instabug.library.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.instabug.library.C0593R;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.screenshot.C0753a.C0752a;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.BitmapUtils.C0771a;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Subscription;
import rx.functions.Action1;

public class ExtraScreenshotHelper {
    private ImageButton captureButton;
    private Subscription currentActivityLifeCycleSubscription;
    private boolean isCaptureButtonShown = false;
    private OnCaptureListener onCaptureListener;

    public interface OnCaptureListener {
        void onExtraScreenshotCaptured(Uri uri);
    }

    class C13963 implements Action1<ActivityLifeCycleEvent> {
        final /* synthetic */ ExtraScreenshotHelper f15546a;

        C13963(ExtraScreenshotHelper extraScreenshotHelper) {
            this.f15546a = extraScreenshotHelper;
        }

        public final /* synthetic */ void m15456a(Object obj) {
            switch ((ActivityLifeCycleEvent) obj) {
                case RESUMED:
                    this.f15546a.handleCurrentActivityResumeEvent();
                    return;
                case PAUSED:
                    this.f15546a.handleCurrentActivityPauseEvent();
                    break;
                default:
                    break;
            }
        }
    }

    public void init(OnCaptureListener onCaptureListener) {
        this.onCaptureListener = onCaptureListener;
        subscribeToCurranActivityLifeCycle();
        C1381b.m15431c().f15519d = false;
    }

    public void release() {
        this.captureButton = null;
        this.onCaptureListener = null;
        if (!(this.currentActivityLifeCycleSubscription == null || this.currentActivityLifeCycleSubscription.d())) {
            this.currentActivityLifeCycleSubscription.c();
        }
        C1381b.m15431c().f15519d = true;
    }

    private void show(final Activity activity) {
        if (this.isCaptureButtonShown) {
            InstabugSDKLogger.m8360v(this, "bar already shown");
            return;
        }
        this.captureButton = createCaptureButton(activity);
        activity.getWindow().addContentView(this.captureButton, createCaptureButtonContainer(activity));
        this.isCaptureButtonShown = true;
        this.captureButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExtraScreenshotHelper f9853b;

            public void onClick(View view) {
                this.f9853b.hide();
                this.f9853b.captureExtraScreenshot(activity, this.f9853b.onCaptureListener);
            }
        });
    }

    private ImageButton createCaptureButton(Activity activity) {
        ImageButton imageButton = new ImageButton(activity);
        imageButton.setId(C0593R.id.instabug_extra_screenshot_button);
        imageButton.setScaleType(ScaleType.CENTER);
        imageButton.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(ContextCompat.m714a((Context) activity, C0593R.drawable.instabug_bg_white_oval)));
        imageButton.setImageResource(C0593R.drawable.instabug_ic_capture_screenshot);
        return imageButton;
    }

    private LayoutParams createCaptureButtonContainer(Activity activity) {
        LayoutParams layoutParams = new LayoutParams(-2, -2, 81);
        layoutParams.setMargins(0, 0, 0, 20);
        Resources resources = activity.getResources();
        if (VERSION.SDK_INT >= 21 && hasNavBar(resources) && activity.findViewById(16908336) == null) {
            layoutParams.bottomMargin += getNavigationBarHeight(resources);
        }
        return layoutParams;
    }

    private void captureExtraScreenshot(final Activity activity, final OnCaptureListener onCaptureListener) {
        C0753a.m8313a(activity, new C0752a(this) {
            final /* synthetic */ ExtraScreenshotHelper f15545c;

            class C13941 implements C0771a {
                final /* synthetic */ C13952 f15542a;

                C13941(C13952 c13952) {
                    this.f15542a = c13952;
                }

                public final void mo2581a(Uri uri) {
                    onCaptureListener.onExtraScreenshotCaptured(uri);
                }

                public final void mo2582a(Throwable th) {
                    InstabugSDKLogger.m8358e(ExtraScreenshotHelper.class, th.getMessage(), th);
                }
            }

            public final void mo2583a(Bitmap bitmap) {
                BitmapUtils.saveBitmap(bitmap, activity, new C13941(this));
            }

            public final void mo2584a(Throwable th) {
                InstabugSDKLogger.m8358e(ExtraScreenshotHelper.class, th.getMessage(), th);
            }
        });
    }

    private void hide() {
        if (this.isCaptureButtonShown && this.captureButton != null && this.captureButton.getParent() != null && (this.captureButton.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.captureButton.getParent()).removeView(this.captureButton);
            this.isCaptureButtonShown = false;
        }
    }

    private void subscribeToCurranActivityLifeCycle() {
        this.currentActivityLifeCycleSubscription = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new C13963(this));
    }

    private void handleCurrentActivityResumeEvent() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            show(currentActivity);
        } else {
            InstabugSDKLogger.m8360v(ExtraScreenshotHelper.class, "current activity equal null");
        }
    }

    private void handleCurrentActivityPauseEvent() {
        hide();
    }

    private int getNavigationBarHeight(Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : null;
    }

    private boolean hasNavBar(Resources resources) {
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        return (identifier <= 0 || resources.getBoolean(identifier) == null) ? null : true;
    }
}
