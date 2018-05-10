package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.support.v7.appcompat.C0164R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class TooltipPopup {
    final Context f2655a;
    final View f2656b;
    final TextView f2657c;
    final LayoutParams f2658d = new LayoutParams();
    final Rect f2659e = new Rect();
    final int[] f2660f = new int[2];
    final int[] f2661g = new int[2];

    TooltipPopup(Context context) {
        this.f2655a = context;
        this.f2656b = LayoutInflater.from(this.f2655a).inflate(C0164R.layout.tooltip, null);
        this.f2657c = (TextView) this.f2656b.findViewById(C0164R.id.message);
        this.f2658d.setTitle(getClass().getSimpleName());
        this.f2658d.packageName = this.f2655a.getPackageName();
        this.f2658d.type = 1002;
        this.f2658d.width = -2;
        this.f2658d.height = -2;
        this.f2658d.format = -3;
        this.f2658d.windowAnimations = C0164R.style.Animation_AppCompat_Tooltip;
        this.f2658d.flags = 24;
    }

    final void m2357a() {
        if (m2358b()) {
            ((WindowManager) this.f2655a.getSystemService("window")).removeView(this.f2656b);
        }
    }

    final boolean m2358b() {
        return this.f2656b.getParent() != null;
    }

    static View m2356a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return view.getRootView();
    }
}
