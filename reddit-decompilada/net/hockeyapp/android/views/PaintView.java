package net.hockeyapp.android.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.Stack;
import net.hockeyapp.android.utils.HockeyLog;
import net.hockeyapp.android.utils.ImageUtils;

@SuppressLint({"ViewConstructor"})
public class PaintView extends ImageView {
    public Stack<Path> f26654a = new Stack();
    private Path f26655b = new Path();
    private Paint f26656c = new Paint();
    private float f26657d;
    private float f26658e;

    class C21701 extends AsyncTask<Object, Void, Bitmap> {
        final /* synthetic */ PaintView f26653a;

        C21701(PaintView paintView) {
            this.f26653a = paintView;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return C21701.m28262a(objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.f26653a.setImageBitmap(bitmap);
            }
        }

        protected void onPreExecute() {
            this.f26653a.setAdjustViewBounds(true);
        }

        private static Bitmap m28262a(Object... objArr) {
            try {
                return ImageUtils.m28220a((Context) objArr[0], (Uri) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            } catch (Throwable e) {
                HockeyLog.m28206a("Could not load image into ImageView.", e);
                return null;
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public PaintView(Context context, Uri uri, int i, int i2) {
        super(context);
        this.f26656c.setAntiAlias(true);
        this.f26656c.setDither(true);
        this.f26656c.setColor(-65536);
        this.f26656c.setStyle(Style.STROKE);
        this.f26656c.setStrokeJoin(Join.ROUND);
        this.f26656c.setStrokeCap(Cap.ROUND);
        this.f26656c.setStrokeWidth(12.0f);
        new C21701(this).execute(new Object[]{context, uri, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator it = this.f26654a.iterator();
        while (it.hasNext()) {
            canvas.drawPath((Path) it.next(), this.f26656c);
        }
        canvas.drawPath(this.f26655b, this.f26656c);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case null:
                this.f26655b.reset();
                this.f26655b.moveTo(x, y);
                this.f26657d = x;
                this.f26658e = y;
                invalidate();
                break;
            case 1:
                this.f26655b.lineTo(this.f26657d, this.f26658e);
                this.f26654a.push(this.f26655b);
                this.f26655b = new Path();
                invalidate();
                break;
            case 2:
                motionEvent = Math.abs(x - this.f26657d);
                float abs = Math.abs(y - this.f26658e);
                if (motionEvent >= 1082130432 || abs >= 4.0f) {
                    this.f26655b.quadTo(this.f26657d, this.f26658e, (this.f26657d + x) / 2.0f, (this.f26658e + y) / 2.0f);
                    this.f26657d = x;
                    this.f26658e = y;
                }
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
