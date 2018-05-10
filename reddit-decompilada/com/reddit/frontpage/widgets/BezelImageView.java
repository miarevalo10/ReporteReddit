package com.reddit.frontpage.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.reddit.frontpage.C1761R;

@Deprecated
public class BezelImageView extends AppCompatImageView {
    private final Paint f34505a;
    private final Paint f34506b;
    private Rect f34507c;
    private RectF f34508d;
    private Drawable f34509e;
    private Drawable f34510f;
    private ColorMatrixColorFilter f34511g;
    private boolean f34512h;
    private boolean f34513i;
    private Bitmap f34514j;
    private int f34515k;
    private int f34516l;

    public BezelImageView(Context context) {
        this(context, null);
    }

    public BezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34512h = false;
        this.f34513i = false;
        context = context.obtainStyledAttributes(attributeSet, C1761R.styleable.BezelNetworkImageView, i, 0);
        this.f34510f = context.getDrawable(2);
        if (this.f34510f != null) {
            this.f34510f.setCallback(this);
        }
        this.f34509e = context.getDrawable(0);
        if (this.f34509e != null) {
            this.f34509e.setCallback(this);
        }
        this.f34512h = context.getBoolean(1, this.f34512h);
        context.recycle();
        this.f34505a = new Paint();
        this.f34505a.setColor(-16777216);
        this.f34506b = new Paint();
        this.f34506b.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.f34514j = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        if (this.f34512h != null) {
            context = new ColorMatrix();
            context.setSaturation(null);
            this.f34511g = new ColorMatrixColorFilter(context);
        }
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.f34507c = new Rect(0, 0, i3 - i, i4 - i2);
        this.f34508d = new RectF(this.f34507c);
        if (this.f34509e != 0) {
            this.f34509e.setBounds(this.f34507c);
        }
        if (this.f34510f != 0) {
            this.f34510f.setBounds(this.f34507c);
        }
        if (frame) {
            this.f34513i = false;
        }
        return frame;
    }

    @SuppressLint({"WrongConstant"})
    protected void onDraw(Canvas canvas) {
        if (this.f34507c != null) {
            int width = this.f34507c.width();
            int height = this.f34507c.height();
            if (width != 0) {
                if (height != 0) {
                    if (!(this.f34513i && width == this.f34515k && height == this.f34516l)) {
                        if (width == this.f34515k && height == this.f34516l) {
                            this.f34514j.eraseColor(0);
                        } else {
                            this.f34514j.recycle();
                            this.f34514j = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                            this.f34515k = width;
                            this.f34516l = height;
                        }
                        Canvas canvas2 = new Canvas(this.f34514j);
                        if (this.f34510f != null) {
                            height = canvas2.save();
                            this.f34510f.draw(canvas2);
                            Paint paint = this.f34506b;
                            ColorFilter colorFilter = (this.f34512h && isPressed()) ? this.f34511g : null;
                            paint.setColorFilter(colorFilter);
                            canvas2.saveLayer(this.f34508d, this.f34506b, 12);
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(height);
                        } else if (this.f34512h && isPressed()) {
                            height = canvas2.save();
                            canvas2.drawRect(0.0f, 0.0f, (float) this.f34515k, (float) this.f34516l, this.f34505a);
                            this.f34506b.setColorFilter(this.f34511g);
                            canvas2.saveLayer(this.f34508d, this.f34506b, 12);
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(height);
                        } else {
                            super.onDraw(canvas2);
                        }
                        if (this.f34509e != null) {
                            this.f34509e.draw(canvas2);
                        }
                    }
                    canvas.drawBitmap(this.f34514j, (float) this.f34507c.left, (float) this.f34507c.top, null);
                }
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f34509e != null && this.f34509e.isStateful()) {
            this.f34509e.setState(getDrawableState());
        }
        if (this.f34510f != null && this.f34510f.isStateful()) {
            this.f34510f.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.c(this);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable != this.f34509e) {
            if (drawable != this.f34510f) {
                super.invalidateDrawable(drawable);
                return;
            }
        }
        invalidate();
    }

    public void setBorderDrawable(Drawable drawable) {
        if (drawable != this.f34509e) {
            if (this.f34509e != null) {
                this.f34509e.setCallback(null);
            }
            this.f34509e = drawable;
            if (this.f34509e != null) {
                this.f34509e.setCallback(this);
            }
            this.f34513i = null;
            invalidate();
        }
    }

    public void setMaskDrawable(Drawable drawable) {
        if (drawable != this.f34510f) {
            if (this.f34510f != null) {
                this.f34510f.setCallback(null);
            }
            this.f34510f = drawable;
            if (this.f34510f != null) {
                this.f34510f.setCallback(this);
            }
            this.f34513i = null;
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!(drawable == this.f34509e || drawable == this.f34510f)) {
            if (super.verifyDrawable(drawable) == null) {
                return null;
            }
        }
        return true;
    }
}
