package android.support.constraint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.view.View;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import org.jcodec.codecs.mjpeg.JpegConst;

public class Placeholder extends View {
    int f183a;
    View f184b;
    int f185c;

    public void setEmptyVisibility(int i) {
        this.f185c = i;
    }

    public int getEmptyVisibility() {
        return this.f185c;
    }

    public View getContent() {
        return this.f184b;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, JpegConst.RST2, JpegConst.RST2, JpegConst.RST2);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Align.LEFT);
            String str = Operation.EMPTY_PARAM;
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i) {
        if (this.f183a != i) {
            if (this.f184b != null) {
                this.f184b.setVisibility(0);
                ((LayoutParams) this.f184b.getLayoutParams()).aa = false;
                this.f184b = null;
            }
            this.f183a = i;
            if (i != -1) {
                i = ((View) getParent()).findViewById(i);
                if (i != 0) {
                    i.setVisibility(8);
                }
            }
        }
    }
}
