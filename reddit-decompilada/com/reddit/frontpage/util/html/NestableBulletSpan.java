package com.reddit.frontpage.util.html;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public class NestableBulletSpan implements LeadingMarginSpan {
    private static Path f21827d;
    private final int f21828a;
    private final int f21829b;
    private final int f21830c;

    public NestableBulletSpan(int i, int i2, int i3) {
        this.f21830c = i;
        this.f21828a = i2;
        this.f21829b = i3;
    }

    public int getLeadingMargin(boolean z) {
        return (this.f21830c + (2 * this.f21828a)) + this.f21829b;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            i4 = paint.getStyle();
            paint.setStyle(Style.FILL);
            if (canvas.isHardwareAccelerated() != null) {
                if (f21827d == null) {
                    charSequence = new Path();
                    f21827d = charSequence;
                    charSequence.addCircle(0.0f, 0.0f, 1067030938 * ((float) this.f21828a), Direction.CW);
                }
                canvas.save();
                canvas.translate((float) ((i + (i2 * this.f21828a)) + this.f21830c), ((float) (i3 + i5)) / 1073741824);
                canvas.drawPath(f21827d, paint);
                canvas.restore();
            } else {
                canvas.drawCircle((float) ((i + (i2 * this.f21828a)) + this.f21830c), ((float) (i3 + i5)) / 1073741824, (float) this.f21828a, paint);
            }
            paint.setStyle(i4);
        }
    }
}
