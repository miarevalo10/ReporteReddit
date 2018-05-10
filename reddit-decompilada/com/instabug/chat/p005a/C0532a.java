package com.instabug.chat.p005a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.instabug.chat.C0520R;
import com.instabug.chat.a.a.AnonymousClass11;
import com.instabug.chat.model.C0552c;
import com.instabug.chat.p005a.C0532a;
import com.instabug.chat.settings.C0554a;
import com.instabug.chat.ui.view.CircularImageView;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.AssetsCacheManager.OnDownloadFinished;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.model.AssetEntity.AssetType;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileInputStream;
import rx.functions.Action1;

/* compiled from: NotificationBarInvoker */
public class C0532a {
    private View f9229a;
    private boolean f9230b = false;
    private boolean f9231c;
    private boolean f9232d;
    private C0552c f9233e;
    private C0530b f9234f;

    /* compiled from: NotificationBarInvoker */
    class C05221 implements OnClickListener {
        final /* synthetic */ C0532a f9215a;

        public void onClick(View view) {
        }

        C05221(C0532a c0532a) {
            this.f9215a = c0532a;
        }
    }

    /* compiled from: NotificationBarInvoker */
    class C05278 implements OnClickListener {
        final /* synthetic */ C0532a f9225a;

        C05278(C0532a c0532a) {
            this.f9225a = c0532a;
        }

        public void onClick(View view) {
            this.f9225a.f9233e = null;
            this.f9225a.m7854a(false);
            this.f9225a.f9234f.mo2565a();
        }
    }

    /* compiled from: NotificationBarInvoker */
    class C05289 implements OnClickListener {
        final /* synthetic */ C0532a f9226a;

        C05289(C0532a c0532a) {
            this.f9226a = c0532a;
        }

        public void onClick(View view) {
            this.f9226a.f9233e = null;
            this.f9226a.m7854a(true);
        }
    }

    /* compiled from: NotificationBarInvoker */
    private class C0529a implements AnimatorListener {
        final /* synthetic */ C0532a f9227b;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        private C0529a(C0532a c0532a) {
            this.f9227b = c0532a;
        }
    }

    /* compiled from: NotificationBarInvoker */
    public interface C0530b {
        void mo2565a();
    }

    /* compiled from: NotificationBarInvoker */
    public abstract class C0531c implements Runnable {
        final /* synthetic */ C0532a f9228d;

        abstract void mo2563a();

        abstract void mo2564b();

        public C0531c(C0532a c0532a) {
            this.f9228d = c0532a;
        }

        public void run() {
            mo2563a();
        }
    }

    /* compiled from: NotificationBarInvoker */
    class C12943 implements Action1<ActivityLifeCycleEvent> {
        final /* synthetic */ C0532a f15353a;

        C12943(C0532a c0532a) {
            this.f15353a = c0532a;
        }

        public final /* synthetic */ void m15257a(Object obj) {
            switch ((ActivityLifeCycleEvent) obj) {
                case RESUMED:
                    C0532a.m7864i(this.f15353a);
                    return;
                case PAUSED:
                    this.f15353a.m7854a(false);
                    break;
                default:
                    break;
            }
        }
    }

    public C0532a() {
        CurrentActivityLifeCycleEventBus.getInstance().subscribe(new C12943(this));
    }

    public final void m7866a(final Activity activity, final C0552c c0552c, C0530b c0530b) {
        this.f9233e = c0552c;
        this.f9234f = c0530b;
        c0530b = new C0531c(this) {
            final /* synthetic */ C0532a f15356c;

            final void mo2563a() {
                this.f15356c.f9229a.setY((float) C0532a.m7856b(activity));
                C0532a.m7852a(this.f15356c, activity, c0552c);
            }

            public final void mo2564b() {
                C0532a.m7852a(this.f15356c, activity, c0552c);
            }
        };
        c0552c = activity.findViewById(C0520R.id.instabug_in_app_notification);
        if (c0552c != null) {
            this.f9229a = c0552c;
            c0530b.mo2564b();
        } else {
            c0552c = null;
            m7854a(false);
            this.f9229a = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(C0520R.layout.instabug_lyt_notification, null);
            this.f9229a.setVisibility(4);
            this.f9229a.setOnClickListener(new C05221(this));
            final LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            Resources resources = activity.getResources();
            if (VERSION.SDK_INT >= 21) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if ((displayMetrics.widthPixels > displayMetrics.heightPixels ? 1 : null) != null) {
                    int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
                    if (identifier > 0 && resources.getBoolean(identifier)) {
                        c0552c = 1;
                    }
                    if (c0552c != null) {
                        c0552c = activity.getWindowManager().getDefaultDisplay().getRotation();
                        if (c0552c == 1) {
                            layoutParams.rightMargin = C0532a.m7849a(resources);
                        } else if (c0552c == 3) {
                            layoutParams.leftMargin = C0532a.m7849a(resources);
                        }
                    }
                }
            }
            this.f9229a.setLayoutParams(layoutParams);
            activity.runOnUiThread(new Runnable(this) {
                final /* synthetic */ C0532a f9222d;

                public void run() {
                    ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f9222d.f9229a, layoutParams);
                    this.f9222d.f9229a.postDelayed(c0530b, 100);
                }
            });
            activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ C0532a f9224b;

                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = activity.getWindow().getDecorView().getRootView().getHeight();
                    if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
                        this.f9224b.f9231c = true;
                        return;
                    }
                    this.f9224b.f9231c = false;
                    if (this.f9224b.f9232d && !this.f9224b.f9230b) {
                        C0532a.m7851a(this.f9224b, activity);
                    }
                }
            });
        }
        Button button = (Button) this.f9229a.findViewById(C0520R.id.dismissButton);
        ((Button) this.f9229a.findViewById(C0520R.id.replyButton)).setOnClickListener(new C05278(this));
        button.setOnClickListener(new C05289(this));
    }

    private void m7854a(boolean z) {
        if (this.f9230b && this.f9229a != null) {
            int b = C0532a.m7856b((Activity) this.f9229a.getContext());
            if (z) {
                this.f9229a.animate().y((float) b).setListener(new C0529a(this) {
                    final /* synthetic */ C0532a f15352a;

                    {
                        this.f15352a = r2;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f15352a.f9229a.setVisibility(4);
                    }
                }).start();
            } else {
                this.f9229a.setY((float) b);
                this.f9229a.setVisibility(4);
            }
            this.f9230b = false;
            this.f9232d = false;
        }
    }

    private static int m7856b(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int m7849a(Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : null;
    }

    static /* synthetic */ void m7851a(C0532a c0532a, final Activity activity) {
        if (c0532a.f9231c) {
            c0532a.f9232d = true;
            return;
        }
        activity.runOnUiThread(new Runnable(c0532a) {
            final /* synthetic */ C0532a f9217b;

            public void run() {
                this.f9217b.f9229a.setVisibility(0);
                this.f9217b.f9229a.animate().y((float) (C0532a.m7856b(activity) - this.f9217b.f9229a.getHeight())).setListener(null).start();
                this.f9217b.f9230b = true;
            }
        });
        if (C0554a.m7953h() != null) {
            C0534b.m7867a().m7874a((Context) activity);
        }
    }

    static /* synthetic */ void m7852a(C0532a c0532a, final Activity activity, final C0552c c0552c) {
        final CircularImageView circularImageView = (CircularImageView) c0532a.f9229a.findViewById(C0520R.id.senderAvatarImageView);
        activity.runOnUiThread(new Runnable(c0532a) {
            final /* synthetic */ C0532a f9212c;

            public void run() {
                C0532a.m7853a(this.f9212c, Instabug.getTheme());
                circularImageView.setBackgroundResource(C0520R.drawable.instabug_ic_avatar);
                TextView textView = (TextView) this.f9212c.f9229a.findViewById(C0520R.id.senderMessageTextView);
                ((TextView) this.f9212c.f9229a.findViewById(C0520R.id.senderNameTextView)).setText(c0552c.f9290b);
                textView.setText(c0552c.f9289a);
            }
        });
        AssetsCacheManager.getAssetEntity(activity, AssetsCacheManager.createEmptyEntity(activity, c0552c.f9291c, AssetType.IMAGE), new OnDownloadFinished(c0532a) {
            final /* synthetic */ C0532a f15351c;

            public void onSuccess(AssetEntity assetEntity) {
                StringBuilder stringBuilder = new StringBuilder("Asset Entity downloaded: ");
                stringBuilder.append(assetEntity.getFile().getPath());
                InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                try {
                    assetEntity = BitmapFactory.decodeStream(new FileInputStream(assetEntity.getFile()));
                    activity.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass11 f9214b;

                        public void run() {
                            circularImageView.setBackgroundResource(0);
                            circularImageView.setImageBitmap(assetEntity);
                        }
                    });
                } catch (AssetEntity assetEntity2) {
                    InstabugSDKLogger.m8358e(this, "Asset Entity downloading got FileNotFoundException error", assetEntity2);
                }
                if (this.f15351c.f9230b == null) {
                    C0532a.m7851a(this.f15351c, activity);
                }
            }

            public void onFailed(Throwable th) {
                if (!this.f15351c.f9230b) {
                    C0532a.m7851a(this.f15351c, activity);
                }
                InstabugSDKLogger.m8358e(this, "Asset Entity downloading got error", th);
            }
        });
    }

    static /* synthetic */ void m7853a(C0532a c0532a, InstabugColorTheme instabugColorTheme) {
        View findViewById = c0532a.f9229a.findViewById(C0520R.id.instabug_notification_layout);
        Button button = (Button) c0532a.f9229a.findViewById(C0520R.id.replyButton);
        Button button2 = (Button) c0532a.f9229a.findViewById(C0520R.id.dismissButton);
        TextView textView = (TextView) c0532a.f9229a.findViewById(C0520R.id.senderNameTextView);
        TextView textView2 = (TextView) c0532a.f9229a.findViewById(C0520R.id.senderMessageTextView);
        button.getBackground().setColorFilter(Instabug.getPrimaryColor(), Mode.MULTIPLY);
        button2.getBackground().setColorFilter(-1, Mode.MULTIPLY);
        button.setTextColor(-1);
        if (instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight) {
            findViewById.setBackgroundColor(-1);
            textView.setTextColor(-11908534);
            textView2.setTextColor(-7697777);
            button2.setTextColor(-6579301);
            return;
        }
        findViewById.setBackgroundColor(-12434878);
        textView.setTextColor(-1);
        textView2.setTextColor(-2631721);
        button2.setTextColor(-6579301);
    }

    static /* synthetic */ void m7864i(C0532a c0532a) {
        if (c0532a.f9233e != null && c0532a.f9234f != null) {
            c0532a.m7866a(InstabugCore.getTargetActivity(), c0532a.f9233e, c0532a.f9234f);
        }
    }
}
