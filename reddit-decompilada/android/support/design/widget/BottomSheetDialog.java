package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.C0016R;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.design.widget.BottomSheetBehavior.C00261;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class BottomSheetDialog extends AppCompatDialog {
    boolean f16412a;
    boolean f16413b;
    boolean f16414c;
    private BottomSheetBehavior<FrameLayout> f16415d;
    private BottomSheetCallback f16416e;

    class C00281 implements OnClickListener {
        final /* synthetic */ BottomSheetDialog f456a;

        C00281(BottomSheetDialog bottomSheetDialog) {
            this.f456a = bottomSheetDialog;
        }

        public void onClick(View view) {
            if (this.f456a.f16412a != null && this.f456a.isShowing() != null) {
                view = this.f456a;
                if (!view.f16414c) {
                    if (VERSION.SDK_INT < 11) {
                        view.f16413b = true;
                    } else {
                        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(new int[]{16843611});
                        view.f16413b = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                    }
                    view.f16414c = true;
                }
                if (view.f16413b != null) {
                    this.f456a.cancel();
                }
            }
        }
    }

    class C00293 implements OnTouchListener {
        final /* synthetic */ BottomSheetDialog f457a;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }

        C00293(BottomSheetDialog bottomSheetDialog) {
            this.f457a = bottomSheetDialog;
        }
    }

    class C09802 extends AccessibilityDelegateCompat {
        final /* synthetic */ BottomSheetDialog f11063a;

        C09802(BottomSheetDialog bottomSheetDialog) {
            this.f11063a = bottomSheetDialog;
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            if (this.f11063a.f16412a != null) {
                accessibilityNodeInfoCompat.m1321a(1048576);
                accessibilityNodeInfoCompat.m1335e(true);
                return;
            }
            accessibilityNodeInfoCompat.m1335e(null);
        }

        public final boolean mo82a(View view, int i, Bundle bundle) {
            if (i != 1048576 || !this.f11063a.f16412a) {
                return super.mo82a(view, i, bundle);
            }
            this.f11063a.cancel();
            return true;
        }
    }

    class C09814 extends BottomSheetCallback {
        final /* synthetic */ BottomSheetDialog f11064a;

        C09814(BottomSheetDialog bottomSheetDialog) {
            this.f11064a = bottomSheetDialog;
        }

        public final void mo83a(int i) {
            if (i == 5) {
                this.f11064a.cancel();
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    public void setContentView(int i) {
        super.setContentView(m16527a(i, null, null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getWindow();
        if (bundle != null) {
            if (VERSION.SDK_INT >= 21) {
                bundle.clearFlags(67108864);
                bundle.addFlags(Integer.MIN_VALUE);
            }
            bundle.setLayout(-1, -1);
        }
    }

    public void setContentView(View view) {
        super.setContentView(m16527a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m16527a(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f16412a != z) {
            this.f16412a = z;
            if (this.f16415d != null) {
                this.f16415d.f11043c = z;
            }
        }
    }

    protected void onStart() {
        super.onStart();
        if (this.f16415d != null) {
            BottomSheetBehavior bottomSheetBehavior = this.f16415d;
            if (4 != bottomSheetBehavior.f11044d) {
                if (bottomSheetBehavior.f11047g == null) {
                    bottomSheetBehavior.f11044d = 4;
                    return;
                }
                View view = (View) bottomSheetBehavior.f11047g.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && parent.isLayoutRequested() && ViewCompat.m1209J(view)) {
                        view.post(new C00261(bottomSheetBehavior, view));
                        return;
                    }
                    bottomSheetBehavior.m9530a(view, 4);
                }
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f16412a) {
            this.f16412a = true;
        }
        this.f16413b = z;
        this.f16414c = true;
    }

    private View m16527a(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), C0016R.layout.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(C0016R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(C0016R.id.design_bottom_sheet);
        this.f16415d = BottomSheetBehavior.m9523a(view2);
        this.f16415d.f11049i = this.f16416e;
        this.f16415d.f11043c = this.f16412a;
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(C0016R.id.touch_outside).setOnClickListener(new C00281(this));
        ViewCompat.m1220a(view2, new C09802(this));
        view2.setOnTouchListener(new C00293(this));
        return frameLayout;
    }

    public BottomSheetDialog(Context context, int i) {
        if (i == 0) {
            i = new TypedValue();
            if (context.getTheme().resolveAttribute(C0016R.attr.bottomSheetDialogTheme, i, true)) {
                i = i.resourceId;
            } else {
                i = C0016R.style.Theme_Design_Light_BottomSheetDialog;
            }
        }
        super(context, i);
        this.f16412a = true;
        this.f16413b = true;
        this.f16416e = new C09814(this);
        x_();
    }
}
