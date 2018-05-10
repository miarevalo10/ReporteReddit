package com.instabug.library.annotation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.instabug.library.C0593R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorPickerPopUpView extends View {
    private static final int f9459a = Color.argb(255, 247, 247, 247);
    private static final int f9460b = Color.argb(255, 190, 190, 190);
    private RectF f9461c;
    private C0613c f9462d;
    private int f9463e;
    private int f9464f;
    private C0612b f9465g;
    private int[] f9466h = new int[]{-65536, -15925503, -65028, -15893761, -33280, -1024, -4737097};
    private int f9467i;
    private List<C0611a> f9468j;

    static class C0611a {
        RectF f9453a = new RectF();
        int f9454b;
        boolean f9455c;

        public C0611a(int i) {
            this.f9454b = i;
        }
    }

    public interface C0612b {
        void mo2572a(int i);
    }

    public enum C0613c {
        VERTICAL,
        HORIZONTAL
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ColorPickerPopUpView(android.content.Context r2) {
        /*
        r1 = this;
        r1.<init>(r2);
        r2 = 7;
        r2 = new int[r2];
        r2 = {-65536, -15925503, -65028, -15893761, -33280, -1024, -4737097};
        r1.f9466h = r2;
        r2 = 0;
        r0 = 0;
        r1.m8036a(r2, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.ColorPickerPopUpView.<init>(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ColorPickerPopUpView(android.content.Context r1, android.util.AttributeSet r2) {
        /*
        r0 = this;
        r0.<init>(r1, r2);
        r1 = 7;
        r1 = new int[r1];
        r1 = {-65536, -15925503, -65028, -15893761, -33280, -1024, -4737097};
        r0.f9466h = r1;
        r1 = 0;
        r0.m8036a(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.ColorPickerPopUpView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ColorPickerPopUpView(android.content.Context r1, android.util.AttributeSet r2, int r3) {
        /*
        r0 = this;
        r0.<init>(r1, r2, r3);
        r1 = 7;
        r1 = new int[r1];
        r1 = {-65536, -15925503, -65028, -15893761, -33280, -1024, -4737097};
        r0.f9466h = r1;
        r0.m8036a(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.ColorPickerPopUpView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void m8036a(AttributeSet attributeSet, int i) {
        attributeSet = getContext().obtainStyledAttributes(attributeSet, C0593R.styleable.ColorPickerPopUpView, i, 0);
        if (attributeSet.getInt(C0593R.styleable.ColorPickerPopUpView_view_orientation, -1) == 0) {
            this.f9462d = C0613c.VERTICAL;
        } else {
            this.f9462d = C0613c.HORIZONTAL;
        }
        attributeSet.recycle();
        this.f9463e = f9459a;
        this.f9464f = f9460b;
        this.f9468j = new ArrayList();
        for (int c0611a : this.f9466h) {
            this.f9468j.add(new C0611a(c0611a));
        }
        setSelectedColor(0);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f9462d == C0613c.VERTICAL) {
            i = getMeasuredHeight();
            i2 = (i * 55) / 426;
        } else {
            i2 = getMeasuredWidth();
            i = (i2 * 55) / 426;
        }
        setMeasuredDimension(i2, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = MotionEventCompat.m1120a(motionEvent);
        float x = motionEvent.getX();
        motionEvent = motionEvent.getY();
        if (a == 1) {
            for (a = 0; a < this.f9468j.size(); a++) {
                C0611a c0611a = (C0611a) this.f9468j.get(a);
                RectF rectF = new RectF();
                rectF.set(c0611a.f9453a);
                rectF.inset((-c0611a.f9453a.width()) / 3.0f, (-c0611a.f9453a.height()) / 3.0f);
                if (rectF.contains(x, motionEvent)) {
                    setSelectedColor(a);
                    break;
                }
            }
        }
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f9462d == C0613c.VERTICAL) {
            r0.f9461c = new RectF(0.0f, 0.0f, ((float) (i6 * 55)) / 426.0f, (float) i6);
            ((C0611a) r0.f9468j.get(0)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.04429f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.09857f) + 0.5f))));
            ((C0611a) r0.f9468j.get(1)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.18786f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.24214f) + 0.5f))));
            ((C0611a) r0.f9468j.get(2)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.33071f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.385f) + 0.5f))));
            ((C0611a) r0.f9468j.get(3)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.47357f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.52786f) + 0.5f))));
            ((C0611a) r0.f9468j.get(4)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.61643f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.67071f) + 0.5f))));
            ((C0611a) r0.f9468j.get(5)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.75929f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.81357f) + 0.5f))));
            ((C0611a) r0.f9468j.get(6)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.15603f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.90357f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.69504f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.95786f) + 0.5f))));
            return;
        }
        r0.f9461c = new RectF(0.0f, 0.0f, (float) i5, ((float) (i5 * 55)) / 426.0f);
        ((C0611a) r0.f9468j.get(0)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.04429f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.09857f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
        ((C0611a) r0.f9468j.get(1)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.18714f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.24143f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
        ((C0611a) r0.f9468j.get(2)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.33f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.38429f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
        ((C0611a) r0.f9468j.get(3)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.47286f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.52714f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
        ((C0611a) r0.f9468j.get(4)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.61571f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.67f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
        ((C0611a) r0.f9468j.get(5)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.75857f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.81286f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
        ((C0611a) r0.f9468j.get(6)).f9453a = new RectF(r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.90143f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.15603f) + 0.5f))), r0.f9461c.left + ((float) Math.floor((double) ((r0.f9461c.width() * 0.95571f) + 0.5f))), r0.f9461c.top + ((float) Math.floor((double) ((r0.f9461c.height() * 0.69504f) + 0.5f))));
    }

    protected void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.f9462d == C0613c.VERTICAL) {
            Path path = new Path();
            path.moveTo(r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.00929f));
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.00929f), r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.04834f), r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.11085f));
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.91373f), r0.f9461c.top + (r0.f9461c.height() * 0.11701f), r0.f9461c.left + (r0.f9461c.width() * 0.99193f), r0.f9461c.top + (r0.f9461c.height() * 0.12488f), r0.f9461c.left + (r0.f9461c.width() * 0.99193f), r0.f9461c.top + (r0.f9461c.height() * 0.12488f));
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.99193f), r0.f9461c.top + (r0.f9461c.height() * 0.12488f), r0.f9461c.left + (r0.f9461c.width() * 0.90758f), r0.f9461c.top + (r0.f9461c.height() * 0.13338f), r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.13891f));
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.40548f), r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.99036f), r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.99036f));
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.99549f), r0.f9461c.left + (r0.f9461c.width() * 0.81135f), r0.f9461c.top + (r0.f9461c.height() * 0.99964f), r0.f9461c.left + (r0.f9461c.width() * 0.76043f), r0.f9461c.top + (r0.f9461c.height() * 0.99964f));
            path.lineTo(r0.f9461c.left + (r0.f9461c.width() * 0.0922f), r0.f9461c.top + (r0.f9461c.height() * 0.99964f));
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.04128f), r0.f9461c.top + (r0.f9461c.height() * 0.99964f), r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.99549f), r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.99036f));
            path.cubicTo(r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.99036f), r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.98973f), r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.9885f));
            path.cubicTo(r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.94121f), r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.00929f), r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.00929f));
            path.cubicTo(r0.f9461c.left, r0.f9461c.top + (r0.f9461c.height() * 0.00416f), r0.f9461c.left + (r0.f9461c.width() * 0.04128f), r0.f9461c.top, r0.f9461c.left + (r0.f9461c.width() * 0.0922f), r0.f9461c.top);
            path.lineTo(r0.f9461c.left + (r0.f9461c.width() * 0.76043f), r0.f9461c.top);
            path.cubicTo(r0.f9461c.left + (r0.f9461c.width() * 0.81135f), r0.f9461c.top, r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.00416f), r0.f9461c.left + (r0.f9461c.width() * 0.85262f), r0.f9461c.top + (r0.f9461c.height() * 0.00929f));
            path.close();
            Paint paint = new Paint(1);
            paint.setStyle(Style.FILL);
            paint.setColor(r0.f9463e);
            canvas2.drawPath(path, paint);
            paint = new Paint(1);
            paint.setStrokeWidth(1.0f);
            paint.setStrokeMiter(10.0f);
            canvas.save();
            paint.setStyle(Style.STROKE);
            paint.setColor(r0.f9464f);
            paint.setStrokeWidth(1.0f * getContext().getResources().getDisplayMetrics().density);
            canvas2.drawPath(path, paint);
            canvas.restore();
            for (C0611a a : r0.f9468j) {
                m8035a(canvas2, a);
            }
            return;
        }
        m8034a(canvas);
    }

    private static void m8035a(Canvas canvas, C0611a c0611a) {
        RectF rectF = c0611a.f9453a;
        int i = c0611a.f9454b;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.left + ((float) Math.floor((double) (rectF.height() + 0.5f))), rectF.top + ((float) Math.floor((double) (rectF.height() + 0.5f))));
        Path path = new Path();
        path.addOval(rectF2, Direction.CW);
        Paint paint = new Paint(1);
        paint.setStyle(Style.FILL);
        paint.setColor(i);
        canvas.drawPath(path, paint);
        if (c0611a.f9455c != null) {
            c0611a = new Path();
            c0611a.moveTo(rectF.left + (rectF.height() * 0.20313f), rectF.top + (rectF.height() * 0.51758f));
            c0611a.lineTo(rectF.left + (rectF.height() * 0.39844f), rectF.top + (rectF.height() * 0.71875f));
            c0611a.lineTo(rectF.left + (rectF.height() * 0.79492f), rectF.top + (rectF.height() * 0.33008f));
            c0611a.lineTo(rectF.left + (rectF.height() * 0.74805f), rectF.top + (rectF.height() * 0.28125f));
            c0611a.lineTo(rectF.left + (rectF.height() * 0.39844f), rectF.top + (rectF.height() * 0.625f));
            c0611a.lineTo(rectF.left + (rectF.height() * 0.25f), rectF.top + (rectF.height() * 0.47266f));
            c0611a.lineTo(rectF.left + (rectF.height() * 0.20313f), rectF.top + (rectF.height() * 0.51758f));
            c0611a.close();
            Paint paint2 = new Paint(1);
            paint2.setStyle(Style.FILL);
            paint2.setColor(-1);
            canvas.drawPath(c0611a, paint2);
        }
    }

    private void m8034a(Canvas canvas) {
        Canvas canvas2 = canvas;
        Path path = new Path();
        path.moveTo(this.f9461c.left + (this.f9461c.width() * 0.99964f), this.f9461c.top + (this.f9461c.height() * 0.09474f));
        path.lineTo(this.f9461c.left + (this.f9461c.width() * 0.99964f), this.f9461c.top + (this.f9461c.height() * 0.75789f));
        path.cubicTo((this.f9461c.width() * 0.99964f) + this.f9461c.left, (this.f9461c.height() * 0.81021f) + this.f9461c.top, (this.f9461c.width() * 0.99538f) + this.f9461c.left, (this.f9461c.height() * 0.85263f) + this.f9461c.top, (this.f9461c.width() * 0.99012f) + this.f9461c.left, (this.f9461c.height() * 0.85263f) + this.f9461c.top);
        path.lineTo(this.f9461c.left + (this.f9461c.width() * 0.13866f), this.f9461c.top + (this.f9461c.height() * 0.85274f));
        path.cubicTo((this.f9461c.width() * 0.13198f) + this.f9461c.left, (this.f9461c.height() * 0.91794f) + this.f9461c.top, (this.f9461c.width() * 0.12496f) + this.f9461c.left, (this.f9461c.height() * 0.98936f) + this.f9461c.top, (this.f9461c.width() * 0.12496f) + this.f9461c.left, (this.f9461c.height() * 0.98936f) + this.f9461c.top);
        path.cubicTo((this.f9461c.width() * 0.12496f) + this.f9461c.left, (this.f9461c.height() * 0.98936f) + this.f9461c.top, (this.f9461c.width() * 0.11802f) + this.f9461c.left, (this.f9461c.height() * 0.91774f) + this.f9461c.top, (this.f9461c.width() * 0.11125f) + this.f9461c.left, (this.f9461c.height() * 0.85274f) + this.f9461c.top);
        path.lineTo(this.f9461c.left + (this.f9461c.width() * 0.00952f), this.f9461c.top + (this.f9461c.height() * 0.85263f));
        path.cubicTo((this.f9461c.width() * 0.00426f) + this.f9461c.left, (this.f9461c.height() * 0.85263f) + this.f9461c.top, this.f9461c.left, (this.f9461c.height() * 0.81021f) + this.f9461c.top, this.f9461c.left, (this.f9461c.height() * 0.75789f) + this.f9461c.top);
        path.lineTo(this.f9461c.left, this.f9461c.top + (this.f9461c.height() * 0.09474f));
        path.cubicTo(this.f9461c.left, (this.f9461c.height() * 0.04241f) + this.f9461c.top, (this.f9461c.width() * 0.00426f) + this.f9461c.left, this.f9461c.top, (this.f9461c.width() * 0.00952f) + this.f9461c.left, this.f9461c.top);
        path.lineTo(this.f9461c.left + (this.f9461c.width() * 0.99012f), this.f9461c.top);
        path.cubicTo((this.f9461c.width() * 0.99538f) + this.f9461c.left, this.f9461c.top, (this.f9461c.width() * 0.99964f) + this.f9461c.left, (this.f9461c.height() * 0.04241f) + this.f9461c.top, (this.f9461c.width() * 0.99964f) + this.f9461c.left, (this.f9461c.height() * 0.09474f) + this.f9461c.top);
        path.close();
        Paint paint = new Paint(1);
        paint.setStyle(Style.FILL);
        paint.setColor(this.f9463e);
        canvas2.drawPath(path, paint);
        paint = new Paint(1);
        paint.setStrokeWidth(1.0f);
        paint.setStrokeMiter(10.0f);
        canvas.save();
        paint.setStyle(Style.STROKE);
        paint.setColor(this.f9464f);
        paint.setStrokeWidth(1.0f * getContext().getResources().getDisplayMetrics().density);
        canvas2.drawPath(path, paint);
        canvas.restore();
        for (C0611a a : this.f9468j) {
            m8035a(canvas2, a);
        }
    }

    public void setColors(int[] iArr) {
        this.f9466h = Arrays.copyOf(iArr, iArr.length);
    }

    public void setPopUpBackgroundColor(int i) {
        this.f9463e = i;
        invalidate();
    }

    public void setPopUpBorderColor(int i) {
        this.f9464f = i;
        invalidate();
    }

    public void setOrientation(C0613c c0613c) {
        this.f9462d = c0613c;
    }

    public int getSelectedColor() {
        return this.f9467i;
    }

    private void setSelectedColor(int i) {
        this.f9467i = this.f9466h[i];
        for (int i2 = 0; i2 < this.f9468j.size(); i2++) {
            if (i2 == i) {
                ((C0611a) this.f9468j.get(i2)).f9455c = true;
            } else {
                ((C0611a) this.f9468j.get(i2)).f9455c = false;
            }
        }
        invalidate();
        if (this.f9465g != 0) {
            this.f9465g.mo2572a(this.f9467i);
        }
    }

    public void setOnColorSelectionListener(C0612b c0612b) {
        this.f9465g = c0612b;
    }
}
