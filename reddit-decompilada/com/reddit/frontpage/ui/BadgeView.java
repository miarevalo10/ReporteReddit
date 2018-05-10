package com.reddit.frontpage.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v7.widget.AppCompatTextView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import com.reddit.frontpage.C1761R;

public class BadgeView extends AppCompatTextView {
    private static final int f34196d = Color.parseColor("#CCFF0000");
    private static Animation f34197e;
    private static Animation f34198f;
    public int f34199b;
    public int f34200c;
    private Context f34201g;
    private View f34202h;
    private int f34203i;
    private int f34204j;
    private boolean f34205k;
    private ShapeDrawable f34206l;
    private int f34207m;

    public BadgeView(Context context, View view) {
        this(context, view, (byte) 0);
    }

    private BadgeView(Context context, View view, byte b) {
        super(context, (byte) 0, C1761R.attr.textAppearanceRedditBadge);
        this.f34201g = context;
        this.f34202h = view;
        this.f34207m = 0;
        this.f34203i = 2;
        this.f34199b = m34893a(5);
        this.f34200c = this.f34199b;
        this.f34204j = f34196d;
        view = m34893a(5);
        setPadding(view, 0, view, 0);
        view = new AlphaAnimation(0.0f, 1.0f);
        f34197e = view;
        view.setInterpolator(new DecelerateInterpolator());
        f34197e.setDuration(200);
        view = new AlphaAnimation(1.0f, 0.0f);
        f34198f = view;
        view.setInterpolator(new AccelerateInterpolator());
        f34198f.setDuration(200);
        this.f34205k = false;
        if (this.f34202h != null) {
            context = this.f34202h;
            view = context.getLayoutParams();
            b = context.getParent();
            View frameLayout = new FrameLayout(this.f34201g);
            if (context instanceof TabWidget) {
                context = ((TabWidget) context).getChildTabViewAt(this.f34207m);
                this.f34202h = context;
                ((ViewGroup) context).addView(frameLayout, new LayoutParams(-1, -1));
                setVisibility(8);
                frameLayout.addView(this);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b;
            int indexOfChild = viewGroup.indexOfChild(context);
            viewGroup.removeView(context);
            viewGroup.addView(frameLayout, indexOfChild, view);
            frameLayout.addView(context);
            setVisibility(8);
            frameLayout.addView(this);
            viewGroup.invalidate();
            return;
        }
        m34894a();
    }

    private ShapeDrawable getDefaultBackground() {
        r0 = new float[8];
        float a = (float) m34893a(8);
        r0[0] = a;
        r0[1] = a;
        r0[2] = a;
        r0[3] = a;
        r0[4] = a;
        r0[5] = a;
        r0[6] = a;
        r0[7] = a;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(r0, null, null));
        shapeDrawable.getPaint().setColor(this.f34204j);
        return shapeDrawable;
    }

    public View getTarget() {
        return this.f34202h;
    }

    public boolean isShown() {
        return this.f34205k;
    }

    public int getBadgePosition() {
        return this.f34203i;
    }

    public void setBadgePosition(int i) {
        this.f34203i = i;
    }

    public int getHorizontalBadgeMargin() {
        return this.f34199b;
    }

    public int getVerticalBadgeMargin() {
        return this.f34200c;
    }

    public void setBadgeMargin(int i) {
        this.f34199b = i;
        this.f34200c = i;
    }

    public int getBadgeBackgroundColor() {
        return this.f34204j;
    }

    public void setBadgeBackgroundColor(int i) {
        this.f34204j = i;
        this.f34206l = getDefaultBackground();
    }

    private int m34893a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public final void m34894a() {
        if (getBackground() == null) {
            if (this.f34206l == null) {
                this.f34206l = getDefaultBackground();
            }
            setBackgroundDrawable(this.f34206l);
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        switch (this.f34203i) {
            case 1:
                layoutParams.gravity = 51;
                layoutParams.setMargins(this.f34199b, this.f34200c, 0, 0);
                break;
            case 2:
                layoutParams.gravity = 53;
                layoutParams.setMargins(0, this.f34200c, this.f34199b, 0);
                break;
            case 3:
                layoutParams.gravity = 83;
                layoutParams.setMargins(this.f34199b, 0, 0, this.f34200c);
                break;
            case 4:
                layoutParams.gravity = 85;
                layoutParams.setMargins(0, 0, this.f34199b, this.f34200c);
                break;
            case 5:
                layoutParams.gravity = 17;
                layoutParams.setMargins(0, 0, 0, 0);
                break;
            default:
                break;
        }
        setLayoutParams(layoutParams);
        setVisibility(0);
        this.f34205k = true;
    }

    public final void m34895b() {
        setVisibility(8);
        this.f34205k = false;
    }
}
