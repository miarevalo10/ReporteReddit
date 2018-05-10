package com.instabug.library.internal.view.floatingactionbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.instabug.library.C0593R;
import com.instabug.library.view.C0779a;

/* compiled from: MuteFloatingActionButton */
public class C1652b extends C1371a {
    public boolean f18566f;

    public C1652b(Context context) {
        this(context, (byte) 0);
    }

    private C1652b(Context context, byte b) {
        super(context);
    }

    final void mo3678a(Context context, AttributeSet attributeSet) {
        super.mo3678a(context, attributeSet);
        setSize(1);
        setId(C0593R.id.instabug_video_mute_button);
        setText(C0779a.m8368a(1));
        setGravity(17);
        mo3682c();
    }

    Drawable getIconDrawable() {
        final float a = m15397a(C0593R.dimen.instabug_fab_icon_size_mini);
        final float a2 = m15397a(C0593R.dimen.instabug_fab_size_mini);
        final float f = a / 2.0f;
        final float a3 = m15397a(C0593R.dimen.instabug_fab_circle_icon_stroke);
        Drawable shapeDrawable = new ShapeDrawable(new Shape(this) {
            final /* synthetic */ C1652b f9707e;

            public void draw(Canvas canvas, Paint paint) {
                if (this.f9707e.f18566f) {
                    paint.setColor(-65536);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    paint.setStrokeWidth(a3);
                    canvas.drawCircle(f, f, a2 / 2.0f, paint);
                    return;
                }
                paint.setColor(-16777216);
                paint.setStrokeWidth(a3);
                canvas.drawLine(0.0f, a3, a, a + a3, paint);
            }
        });
        shapeDrawable.getPaint().setAntiAlias(true);
        return shapeDrawable;
    }

    public final void mo3681b() {
        this.f18566f = true;
        m15398a();
        setTextColor(-1);
    }

    public final void mo3682c() {
        this.f18566f = false;
        m15398a();
        setTextColor(-16777216);
    }
}
