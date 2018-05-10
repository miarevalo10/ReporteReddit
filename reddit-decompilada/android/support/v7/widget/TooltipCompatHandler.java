package android.support.v7.widget;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityManager;

class TooltipCompatHandler implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static TooltipCompatHandler f2645i;
    private static TooltipCompatHandler f2646j;
    private final View f2647a;
    private final CharSequence f2648b;
    private final Runnable f2649c = new C02361(this);
    private final Runnable f2650d = new C02372(this);
    private int f2651e;
    private int f2652f;
    private TooltipPopup f2653g;
    private boolean f2654h;

    class C02361 implements Runnable {
        final /* synthetic */ TooltipCompatHandler f2643a;

        C02361(TooltipCompatHandler tooltipCompatHandler) {
            this.f2643a = tooltipCompatHandler;
        }

        public void run() {
            this.f2643a.m2353a(false);
        }
    }

    class C02372 implements Runnable {
        final /* synthetic */ TooltipCompatHandler f2644a;

        C02372(TooltipCompatHandler tooltipCompatHandler) {
            this.f2644a = tooltipCompatHandler;
        }

        public void run() {
            this.f2644a.m2350a();
        }
    }

    public void onViewAttachedToWindow(View view) {
    }

    public static void m2352a(View view, CharSequence charSequence) {
        if (f2645i != null && f2645i.f2647a == view) {
            m2355c(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (f2646j != null && f2646j.f2647a == view) {
                f2646j.m2350a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(null);
            view.setOnHoverListener(null);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler = new TooltipCompatHandler(view, charSequence);
    }

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f2647a = view;
        this.f2648b = charSequence;
        this.f2647a.setOnLongClickListener(this);
        this.f2647a.setOnHoverListener(this);
    }

    public boolean onLongClick(View view) {
        this.f2651e = view.getWidth() / 2;
        this.f2652f = view.getHeight() / 2;
        m2353a(true);
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2653g != null && this.f2654h != null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2647a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() != null) {
            return false;
        }
        view = motionEvent.getAction();
        if (view != 7) {
            if (view == 10) {
                m2350a();
            }
        } else if (this.f2647a.isEnabled() != null && this.f2653g == null) {
            this.f2651e = (int) motionEvent.getX();
            this.f2652f = (int) motionEvent.getY();
            m2355c(this);
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        m2350a();
    }

    private void m2353a(boolean z) {
        if (ViewCompat.m1209J(this.f2647a)) {
            int i;
            long j;
            m2355c(null);
            if (f2646j != null) {
                f2646j.m2350a();
            }
            f2646j = this;
            this.f2654h = z;
            this.f2653g = new TooltipPopup(this.f2647a.getContext());
            z = this.f2653g;
            View view = this.f2647a;
            int i2 = this.f2651e;
            int i3 = this.f2652f;
            boolean z2 = this.f2654h;
            CharSequence charSequence = this.f2648b;
            if (z.m2358b()) {
                z.m2357a();
            }
            z.f2657c.setText(charSequence);
            LayoutParams layoutParams = z.f2658d;
            int dimensionPixelOffset = z.f2655a.getResources().getDimensionPixelOffset(C0164R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i2 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                dimensionPixelOffset = z.f2655a.getResources().getDimensionPixelOffset(C0164R.dimen.tooltip_precise_anchor_extra_offset);
                i = i3 + dimensionPixelOffset;
                i3 -= dimensionPixelOffset;
            } else {
                i = view.getHeight();
                i3 = 0;
            }
            layoutParams.gravity = 49;
            dimensionPixelOffset = z.f2655a.getResources().getDimensionPixelOffset(z2 ? C0164R.dimen.tooltip_y_offset_touch : C0164R.dimen.tooltip_y_offset_non_touch);
            View a = TooltipPopup.m2356a(view);
            if (a == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                a.getWindowVisibleDisplayFrame(z.f2659e);
                if (z.f2659e.left < 0 && z.f2659e.top < 0) {
                    Resources resources = z.f2655a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    identifier = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    z.f2659e.set(0, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                a.getLocationOnScreen(z.f2661g);
                view.getLocationOnScreen(z.f2660f);
                int[] iArr = z.f2660f;
                iArr[0] = iArr[0] - z.f2661g[0];
                iArr = z.f2660f;
                iArr[1] = iArr[1] - z.f2661g[1];
                layoutParams.x = (z.f2660f[0] + i2) - (z.f2659e.width() / 2);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                z.f2656b.measure(makeMeasureSpec, makeMeasureSpec);
                makeMeasureSpec = z.f2656b.getMeasuredHeight();
                i2 = ((z.f2660f[1] + i3) - dimensionPixelOffset) - makeMeasureSpec;
                i3 = (z.f2660f[1] + i) + dimensionPixelOffset;
                if (z2) {
                    if (i2 < 0) {
                        layoutParams.y = i3;
                    }
                } else if (makeMeasureSpec + i3 <= z.f2659e.height()) {
                    layoutParams.y = i3;
                }
                layoutParams.y = i2;
            }
            ((WindowManager) z.f2655a.getSystemService("window")).addView(z.f2656b, z.f2658d);
            this.f2647a.addOnAttachStateChangeListener(this);
            if (this.f2654h) {
                j = 2500;
            } else if (ViewCompat.m1263x(this.f2647a) & true) {
                j = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                j = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f2647a.removeCallbacks(this.f2650d);
            this.f2647a.postDelayed(this.f2650d, j);
        }
    }

    private void m2350a() {
        if (f2646j == this) {
            f2646j = null;
            if (this.f2653g != null) {
                this.f2653g.m2357a();
                this.f2653g = null;
                this.f2647a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2645i == this) {
            m2355c(null);
        }
        this.f2647a.removeCallbacks(this.f2650d);
    }

    private static void m2355c(TooltipCompatHandler tooltipCompatHandler) {
        if (f2645i != null) {
            TooltipCompatHandler tooltipCompatHandler2 = f2645i;
            tooltipCompatHandler2.f2647a.removeCallbacks(tooltipCompatHandler2.f2649c);
        }
        f2645i = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler = f2645i;
            tooltipCompatHandler.f2647a.postDelayed(tooltipCompatHandler.f2649c, (long) ViewConfiguration.getLongPressTimeout());
        }
    }
}
