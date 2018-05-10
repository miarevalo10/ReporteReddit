package com.getbase.floatingactionbutton;

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
import android.widget.ImageButton;
import android.widget.TextView;

public class FloatingActionButton extends ImageButton {
    private int f3898a;
    int f3899b;
    int f3900c;
    int f3901d;
    String f3902e;
    boolean f3903f;
    private Drawable f3904g;
    private int f3905h;
    private float f3906i;
    private float f3907j;
    private float f3908k;
    private int f3909l;

    private static class TranslucentLayerDrawable extends LayerDrawable {
        private final int f3897a;

        public TranslucentLayerDrawable(int i, Drawable... drawableArr) {
            super(drawableArr);
            this.f3897a = i;
        }

        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f3897a, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1254a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1254a(context, attributeSet);
    }

    void mo1254a(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, C0376R.styleable.FloatingActionButton, 0, 0);
        this.f3899b = context.getColor(C0376R.styleable.FloatingActionButton_fab_colorNormal, m3510a(17170451));
        this.f3900c = context.getColor(C0376R.styleable.FloatingActionButton_fab_colorPressed, m3510a(17170450));
        this.f3901d = context.getColor(C0376R.styleable.FloatingActionButton_fab_colorDisabled, m3510a(17170432));
        this.f3905h = context.getInt(C0376R.styleable.FloatingActionButton_fab_size, 0);
        this.f3898a = context.getResourceId(C0376R.styleable.FloatingActionButton_fab_icon, 0);
        this.f3902e = context.getString(C0376R.styleable.FloatingActionButton_fab_title);
        this.f3903f = context.getBoolean(C0376R.styleable.FloatingActionButton_fab_stroke_visible, true);
        context.recycle();
        m3509c();
        this.f3907j = m3513b(C0376R.dimen.fab_shadow_radius);
        this.f3908k = m3513b(C0376R.dimen.fab_shadow_offset);
        m3507b();
        mo3301a();
    }

    private void m3507b() {
        this.f3909l = (int) (this.f3906i + (2.0f * this.f3907j));
    }

    private void m3509c() {
        this.f3906i = m3513b(this.f3905h == 0 ? C0376R.dimen.fab_size_normal : C0376R.dimen.fab_size_mini);
    }

    public void setSize(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        } else if (this.f3905h != i) {
            this.f3905h = i;
            m3509c();
            m3507b();
            mo3301a();
        }
    }

    public int getSize() {
        return this.f3905h;
    }

    public void setIcon(int i) {
        if (this.f3898a != i) {
            this.f3898a = i;
            this.f3904g = 0;
            mo3301a();
        }
    }

    public void setIconDrawable(Drawable drawable) {
        if (this.f3904g != drawable) {
            this.f3898a = 0;
            this.f3904g = drawable;
            mo3301a();
        }
    }

    public int getColorNormal() {
        return this.f3899b;
    }

    public void setColorNormalResId(int i) {
        setColorNormal(m3510a(i));
    }

    public void setColorNormal(int i) {
        if (this.f3899b != i) {
            this.f3899b = i;
            mo3301a();
        }
    }

    public int getColorPressed() {
        return this.f3900c;
    }

    public void setColorPressedResId(int i) {
        setColorPressed(m3510a(i));
    }

    public void setColorPressed(int i) {
        if (this.f3900c != i) {
            this.f3900c = i;
            mo3301a();
        }
    }

    public int getColorDisabled() {
        return this.f3901d;
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(m3510a(i));
    }

    public void setColorDisabled(int i) {
        if (this.f3901d != i) {
            this.f3901d = i;
            mo3301a();
        }
    }

    public void setStrokeVisible(boolean z) {
        if (this.f3903f != z) {
            this.f3903f = z;
            mo3301a();
        }
    }

    final int m3510a(int i) {
        return getResources().getColor(i);
    }

    final float m3513b(int i) {
        return getResources().getDimension(i);
    }

    public void setTitle(String str) {
        this.f3902e = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    TextView getLabelView() {
        return (TextView) getTag(C0376R.id.fab_label);
    }

    public String getTitle() {
        return this.f3902e;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f3909l, this.f3909l);
    }

    void mo3301a() {
        float b = m3513b(C0376R.dimen.fab_stroke_width);
        float f = b / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        drawableArr[0] = getResources().getDrawable(this.f3905h == 0 ? C0376R.drawable.fab_bg_normal : C0376R.drawable.fab_bg_mini);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, m3505a(this.f3901d, b));
        stateListDrawable.addState(new int[]{16842919}, m3505a(this.f3900c, b));
        stateListDrawable.addState(new int[0], m3505a(this.f3899b, b));
        drawableArr[1] = stateListDrawable;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(b);
        paint.setStyle(Style.STROKE);
        paint.setColor(-16777216);
        paint.setAlpha(5);
        drawableArr[2] = shapeDrawable;
        drawableArr[3] = getIconDrawable();
        Drawable layerDrawable = new LayerDrawable(drawableArr);
        int b2 = ((int) (this.f3906i - m3513b(C0376R.dimen.fab_icon_size))) / 2;
        int i = (int) this.f3907j;
        int i2 = (int) (this.f3907j - this.f3908k);
        int i3 = (int) (this.f3907j + this.f3908k);
        layerDrawable.setLayerInset(1, i, i2, i, i3);
        int i4 = (int) (((float) i) - f);
        Drawable drawable = layerDrawable;
        drawable.setLayerInset(2, i4, (int) (((float) i2) - f), i4, (int) (((float) i3) - f));
        i4 = i + b2;
        drawable.setLayerInset(3, i4, i2 + b2, i4, i3 + b2);
        setBackgroundCompat(layerDrawable);
    }

    Drawable getIconDrawable() {
        if (this.f3904g != null) {
            return this.f3904g;
        }
        if (this.f3898a != 0) {
            return getResources().getDrawable(this.f3898a);
        }
        return new ColorDrawable(0);
    }

    private Drawable m3505a(int i, float f) {
        int alpha = Color.alpha(i);
        final int rgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
        i = new ShapeDrawable(new OvalShape());
        Paint paint = i.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(rgb);
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = i;
        if (this.f3903f == 0) {
            i = new ColorDrawable(0);
        } else {
            i = new ShapeDrawable(new OvalShape());
            final int b = m3506b(rgb, 0.9f);
            final int c = m3508c(b);
            final int b2 = m3506b(rgb, 1.1f);
            final int c2 = m3508c(b2);
            Paint paint2 = i.getPaint();
            paint2.setAntiAlias(true);
            paint2.setStrokeWidth(f);
            paint2.setStyle(Style.STROKE);
            i.setShaderFactory(new ShaderFactory(this) {
                final /* synthetic */ FloatingActionButton f3896f;

                public Shader resize(int i, int i2) {
                    float f = (float) (i / 2);
                    return new LinearGradient(f, 0.0f, f, (float) i2, new int[]{b2, c2, rgb, c, b}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, TileMode.CLAMP);
                }
            });
        }
        drawableArr[1] = i;
        if (alpha != 255) {
            if (this.f3903f != 0) {
                i = new TranslucentLayerDrawable(alpha, drawableArr);
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

    private static int m3506b(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = Math.min(fArr[2] * f, 1.0f);
        return Color.HSVToColor(Color.alpha(i), fArr);
    }

    private static int m3508c(int i) {
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
