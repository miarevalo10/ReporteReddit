package com.instabug.library.internal.view.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.view.IconView;

/* compiled from: FloatingActionButton */
public class C1371a extends IconView {
    int f15475a;
    int f15476b;
    int f15477c;
    String f15478d;
    boolean f15479e;
    private int f15480f;
    private Drawable f15481k;
    private int f15482l;
    private float f15483m;
    private float f15484n;
    private float f15485o;
    private int f15486p;

    /* compiled from: FloatingActionButton */
    private static class C0708a extends LayerDrawable {
        private final int f9702a;

        public C0708a(int i, Drawable... drawableArr) {
            super(drawableArr);
            this.f9702a = i;
        }

        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f9702a, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public C1371a(Context context) {
        super(context, null);
        mo3678a(context, null);
    }

    void mo3678a(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, C0593R.styleable.FloatingActionButton, 0, 0);
        this.f15475a = context.getColor(C0593R.styleable.FloatingActionButton_instabug_fab_colorNormal, -1);
        this.f15476b = context.getColor(C0593R.styleable.FloatingActionButton_instabug_fab_colorPressed, -3355444);
        this.f15477c = context.getColor(C0593R.styleable.FloatingActionButton_instabug_fab_colorDisabled, m15392b(17170432));
        this.f15482l = context.getInt(C0593R.styleable.FloatingActionButton_instabug_fab_size, 0);
        this.f15480f = context.getResourceId(C0593R.styleable.FloatingActionButton_instabug_fab_icon, 0);
        this.f15478d = context.getString(C0593R.styleable.FloatingActionButton_instabug_fab_title);
        this.f15479e = context.getBoolean(C0593R.styleable.FloatingActionButton_instabug_fab_stroke_visible, true);
        context.recycle();
        mo3682c();
        this.f15484n = m15397a(C0593R.dimen.instabug_fab_shadow_radius);
        this.f15485o = m15397a(C0593R.dimen.instabug_fab_shadow_offset);
        mo3681b();
        m15398a();
    }

    private void mo3681b() {
        this.f15486p = (int) (this.f15483m + (2.0f * this.f15484n));
    }

    private void mo3682c() {
        this.f15483m = m15397a(this.f15482l == 0 ? C0593R.dimen.instabug_fab_size_normal : C0593R.dimen.instabug_fab_size_mini);
    }

    public void setSize(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        } else if (this.f15482l != i) {
            this.f15482l = i;
            mo3682c();
            mo3681b();
            m15398a();
        }
    }

    public int getSize() {
        return this.f15482l;
    }

    public void setIcon(int i) {
        if (this.f15480f != i) {
            this.f15480f = i;
            this.f15481k = 0;
            m15398a();
        }
    }

    public void setIconDrawable(Drawable drawable) {
        if (this.f15481k != drawable) {
            this.f15480f = 0;
            this.f15481k = drawable;
            m15398a();
        }
    }

    public int getColorNormal() {
        return this.f15475a;
    }

    public void setColorNormalResId(int i) {
        setColorNormal(m15392b(i));
    }

    public void setColorNormal(int i) {
        if (this.f15475a != i) {
            this.f15475a = i;
            m15398a();
        }
    }

    public int getColorPressed() {
        return this.f15476b;
    }

    public void setColorPressedResId(int i) {
        setColorPressed(m15392b(i));
    }

    public void setColorPressed(int i) {
        if (this.f15476b != i) {
            this.f15476b = i;
            m15398a();
        }
    }

    public int getColorDisabled() {
        return this.f15477c;
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(m15392b(i));
    }

    public void setColorDisabled(int i) {
        if (this.f15477c != i) {
            this.f15477c = i;
            m15398a();
        }
    }

    public void setStrokeVisible(boolean z) {
        if (this.f15479e != z) {
            this.f15479e = z;
            m15398a();
        }
    }

    private int m15392b(int i) {
        return getResources().getColor(i);
    }

    final float m15397a(int i) {
        return getResources().getDimension(i);
    }

    public void setTitle(String str) {
        this.f15478d = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    TextView getLabelView() {
        return (TextView) getTag(C0593R.id.instabug_fab_label);
    }

    public String getTitle() {
        return this.f15478d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f15486p, this.f15486p);
    }

    final void m15398a() {
        int a;
        float a2 = m15397a(C0593R.dimen.instabug_fab_stroke_width);
        float f = a2 / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        drawableArr[0] = getResources().getDrawable(this.f15482l == 0 ? C0593R.drawable.instabug_fab_bg_normal : C0593R.drawable.instabug_fab_bg_mini);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, m15391a(this.f15477c, a2));
        stateListDrawable.addState(new int[]{16842919}, m15391a(this.f15476b, a2));
        stateListDrawable.addState(new int[0], m15391a(this.f15475a, a2));
        drawableArr[1] = stateListDrawable;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(a2);
        paint.setStyle(Style.STROKE);
        paint.setColor(-16777216);
        paint.setAlpha(5);
        drawableArr[2] = shapeDrawable;
        drawableArr[3] = getIconDrawable();
        Drawable layerDrawable = new LayerDrawable(drawableArr);
        if (this.f15482l == 0) {
            a = ((int) (this.f15483m - m15397a(C0593R.dimen.instabug_fab_icon_size_normal))) / 2;
        } else {
            a = ((int) (this.f15483m - m15397a(C0593R.dimen.instabug_fab_icon_size_mini))) / 2;
        }
        int i = a;
        int i2 = (int) this.f15484n;
        int i3 = (int) (this.f15484n - this.f15485o);
        int i4 = (int) (this.f15484n + this.f15485o);
        layerDrawable.setLayerInset(1, i2, i3, i2, i4);
        int i5 = (int) (((float) i2) - f);
        Drawable drawable = layerDrawable;
        drawable.setLayerInset(2, i5, (int) (((float) i3) - f), i5, (int) (((float) i4) - f));
        i5 = i2 + i;
        drawable.setLayerInset(3, i5, i3 + i, i5, i4 + i);
        setBackgroundCompat(layerDrawable);
    }

    Drawable getIconDrawable() {
        if (this.f15481k != null) {
            return this.f15481k;
        }
        if (this.f15480f != 0) {
            return getResources().getDrawable(this.f15480f);
        }
        return new ColorDrawable(0);
    }

    private Drawable m15391a(int i, float f) {
        int alpha = Color.alpha(i);
        final int rgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
        i = new ShapeDrawable(new OvalShape());
        Paint paint = i.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(rgb);
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = i;
        if (this.f15479e == 0) {
            i = new ColorDrawable(0);
        } else {
            i = new ShapeDrawable(new OvalShape());
            final int b = C1371a.m15393b(rgb, 0.9f);
            final int c = C1371a.m15395c(b);
            final int b2 = C1371a.m15393b(rgb, 1.1f);
            final int c2 = C1371a.m15395c(b2);
            Paint paint2 = i.getPaint();
            paint2.setAntiAlias(true);
            paint2.setStrokeWidth(f);
            paint2.setStyle(Style.STROKE);
            i.setShaderFactory(new ShaderFactory(this) {
                final /* synthetic */ C1371a f9701f;

                public Shader resize(int i, int i2) {
                    float f = ((float) i) / 2.0f;
                    return new LinearGradient(f, 0.0f, f, (float) i2, new int[]{b2, c2, rgb, c, b}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, TileMode.CLAMP);
                }
            });
        }
        drawableArr[1] = i;
        if (alpha != 255) {
            if (this.f15479e != 0) {
                i = new C0708a(alpha, drawableArr);
                rgb = (int) (f / 2.0f);
                i.setLayerInset(1, rgb, rgb, rgb, rgb);
                return i;
            }
        }
        i = new LayerDrawable(drawableArr);
        rgb = (int) (f / 2.0f);
        i.setLayerInset(1, rgb, rgb, rgb, rgb);
        return i;
    }

    private static int m15393b(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = Math.min(fArr[2] * f, 1.0f);
        return Color.HSVToColor(Color.alpha(i), fArr);
    }

    private static int m15395c(int i) {
        return Color.argb(Color.alpha(i) / 2, Color.red(i), Color.green(i), Color.blue(i));
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public void setVisibility(int i) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
        }
        super.setVisibility(i);
    }
}
