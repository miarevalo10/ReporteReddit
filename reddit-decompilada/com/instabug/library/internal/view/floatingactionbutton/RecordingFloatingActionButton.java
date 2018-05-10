package com.instabug.library.internal.view.floatingactionbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.instabug.library.C0593R;

public class RecordingFloatingActionButton extends C1371a {
    private RecordingState f18562f;
    private Paint f18563k;
    private String f18564l;
    private float f18565m;

    public enum RecordingState {
        RECORDING,
        STOPPED
    }

    public RecordingFloatingActionButton(Context context) {
        this(context, (byte) 0);
    }

    private RecordingFloatingActionButton(Context context, byte b) {
        super(context);
    }

    final void mo3678a(Context context, AttributeSet attributeSet) {
        super.mo3678a(context, attributeSet);
        this.f18563k = new Paint(1);
        this.f18563k.setColor(-1);
        this.f18563k.setTextAlign(Align.CENTER);
        this.f18563k.setTextSize(context.getResources().getDimension(C0593R.dimen.instabug_fab_text_size));
        this.f18565m = m15397a(C0593R.dimen.instabug_fab_circle_icon_stroke);
    }

    Drawable getIconDrawable() {
        float a;
        float a2;
        if (getSize() == 0) {
            a = m15397a(C0593R.dimen.instabug_fab_size_normal);
            a2 = m15397a(C0593R.dimen.instabug_fab_icon_size_normal);
        } else {
            a = m15397a(C0593R.dimen.instabug_fab_size_mini);
            a2 = m15397a(C0593R.dimen.instabug_fab_icon_size_mini);
        }
        final float f = a;
        final float f2 = a2;
        final float f3 = f2 / 2.0f;
        final float a3 = m15397a(C0593R.dimen.instabug_fab_circle_icon_stroke);
        Drawable shapeDrawable = new ShapeDrawable(new Shape(this) {
            final /* synthetic */ RecordingFloatingActionButton f9695e;

            public void draw(Canvas canvas, Paint paint) {
                paint.setColor(-65536);
                if (this.f9695e.f18562f == RecordingState.RECORDING) {
                    paint.setStyle(Style.FILL_AND_STROKE);
                    paint.setStrokeWidth(a3);
                    canvas.drawCircle(f3, f3, f / 2.0f, paint);
                    return;
                }
                paint.setStyle(Style.STROKE);
                paint.setStrokeWidth(a3);
                canvas.drawCircle(f3, f3, f / 2.0f, paint);
                paint.setStyle(Style.FILL);
                canvas.drawOval(new RectF(0.0f, 0.0f, f2, f2), paint);
            }
        });
        shapeDrawable.getPaint().setAntiAlias(true);
        return shapeDrawable;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18564l != null) {
            canvas.drawText(this.f18564l, (float) (canvas.getWidth() / 2), (float) ((int) (((((float) canvas.getHeight()) / 2.0f) - ((this.f18563k.descent() + this.f18563k.ascent()) / 2.0f)) - this.f18565m)), this.f18563k);
        }
    }

    public void setText(String str) {
        this.f18564l = str;
        invalidate();
    }

    public void setRecordingState(RecordingState recordingState) {
        this.f18562f = recordingState;
        m15398a();
    }
}
