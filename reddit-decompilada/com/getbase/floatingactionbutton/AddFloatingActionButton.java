package com.getbase.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;

public class AddFloatingActionButton extends FloatingActionButton {
    int f12745a;

    public AddFloatingActionButton(Context context) {
        this(context, (byte) 0);
    }

    private AddFloatingActionButton(Context context, byte b) {
        super(context, (byte) 0);
    }

    final void mo1254a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0376R.styleable.AddFloatingActionButton, 0, 0);
        this.f12745a = obtainStyledAttributes.getColor(C0376R.styleable.AddFloatingActionButton_fab_plusIconColor, m3510a(17170443));
        obtainStyledAttributes.recycle();
        super.mo1254a(context, attributeSet);
    }

    public int getPlusColor() {
        return this.f12745a;
    }

    public void setPlusColorResId(int i) {
        setPlusColor(m3510a(i));
    }

    public void setPlusColor(int i) {
        if (this.f12745a != i) {
            this.f12745a = i;
            mo3301a();
        }
    }

    public void setIcon(int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    Drawable getIconDrawable() {
        final float b = m3513b(C0376R.dimen.fab_icon_size);
        final float f = b / 2.0f;
        final float b2 = m3513b(C0376R.dimen.fab_plus_icon_stroke) / 2.0f;
        final float b3 = (b - m3513b(C0376R.dimen.fab_plus_icon_size)) / 2.0f;
        Drawable shapeDrawable = new ShapeDrawable(new Shape(this) {
            final /* synthetic */ AddFloatingActionButton f3890e;

            public void draw(Canvas canvas, Paint paint) {
                canvas.drawRect(b3, f - b2, b - b3, b2 + f, paint);
                canvas.drawRect(f - b2, b3, f + b2, b - b3, paint);
            }
        });
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.f12745a);
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }
}
