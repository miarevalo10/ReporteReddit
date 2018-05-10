package com.instabug.library.internal.view.floatingactionbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.instabug.library.C0593R;

/* compiled from: StopFloatingActionButton */
public class C1653c extends C1371a {
    public C1653c(Context context) {
        this(context, (byte) 0);
    }

    private C1653c(Context context, byte b) {
        super(context);
    }

    final void mo3678a(Context context, AttributeSet attributeSet) {
        super.mo3678a(context, attributeSet);
        setSize(1);
        setId(C0593R.id.instabug_video_stop_button);
    }

    Drawable getIconDrawable() {
        final float a = m15397a(C0593R.dimen.instabug_fab_icon_size_mini);
        final float a2 = m15397a(C0593R.dimen.instabug_fab_size_mini);
        final float f = a / 2.0f;
        final float a3 = m15397a(C0593R.dimen.instabug_fab_circle_icon_stroke);
        Drawable shapeDrawable = new ShapeDrawable(new Shape(this) {
            final /* synthetic */ C1653c f9712e;

            public void draw(Canvas canvas, Paint paint) {
                paint.setColor(-65536);
                paint.setStyle(Style.STROKE);
                paint.setStrokeWidth(a3);
                canvas.drawCircle(f, f, a2 / 2.0f, paint);
                paint.setStyle(Style.FILL);
                RectF rectF = new RectF(0.0f, 0.0f, a, a);
                rectF.inset(a3 / 2.0f, a3 / 2.0f);
                canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
            }
        });
        shapeDrawable.getPaint().setAntiAlias(true);
        return shapeDrawable;
    }
}
