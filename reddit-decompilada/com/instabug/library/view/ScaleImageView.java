package com.instabug.library.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ScaleImageView extends ImageView implements OnTouchListener {
    private float MAX_SCALE;
    private boolean isScaling;
    private Context mContext;
    private GestureDetector mDetector;
    private int mHeight;
    private int mIntrinsicHeight;
    private int mIntrinsicWidth;
    private Matrix mMatrix;
    private final float[] mMatrixValues;
    private float mMinScale;
    private float mPrevDistance;
    private int mPrevMoveX;
    private int mPrevMoveY;
    private float mScale;
    private int mWidth;

    class C07781 extends SimpleOnGestureListener {
        final /* synthetic */ ScaleImageView f9913a;

        C07781(ScaleImageView scaleImageView) {
            this.f9913a = scaleImageView;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f9913a.maxZoomTo((int) motionEvent.getX(), (int) motionEvent.getY());
            this.f9913a.cutting();
            return super.onDoubleTap(motionEvent);
        }
    }

    public ScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MAX_SCALE = 5.0f;
        this.mMatrixValues = new float[9];
        this.mContext = context;
        initialize();
    }

    public ScaleImageView(Context context) {
        super(context);
        this.MAX_SCALE = 5.0f;
        this.mMatrixValues = new float[9];
        this.mContext = context;
        initialize();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initialize();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        initialize();
    }

    private void initialize() {
        setScaleType(ScaleType.MATRIX);
        this.mMatrix = new Matrix();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.mIntrinsicWidth = drawable.getIntrinsicWidth();
            this.mIntrinsicHeight = drawable.getIntrinsicHeight();
            setOnTouchListener(this);
        }
        this.mDetector = new GestureDetector(this.mContext, new C07781(this));
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        this.mWidth = i5;
        this.mHeight = i4 - i2;
        this.mMatrix.reset();
        this.mScale = ((float) i5) / ((float) this.mIntrinsicWidth);
        int i6 = 0;
        if (this.mScale * ((float) this.mIntrinsicHeight) > ((float) this.mHeight)) {
            this.mScale = ((float) this.mHeight) / ((float) this.mIntrinsicHeight);
            this.mMatrix.postScale(this.mScale, this.mScale);
            i5 = (i3 - this.mWidth) / 2;
        } else {
            this.mMatrix.postScale(this.mScale, this.mScale);
            i6 = (i4 - this.mHeight) / 2;
            i5 = 0;
        }
        this.mMatrix.postTranslate((float) i5, (float) i6);
        setImageMatrix(this.mMatrix);
        this.mMinScale = this.mScale;
        zoomTo(this.mScale, this.mWidth / 2, this.mHeight / 2);
        cutting();
        return super.setFrame(i, i2, i3, i4);
    }

    protected float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    protected float getScale() {
        return getValue(this.mMatrix, 0);
    }

    public float getTranslateX() {
        return getValue(this.mMatrix, 2);
    }

    protected float getTranslateY() {
        return getValue(this.mMatrix, 5);
    }

    protected void maxZoomTo(int i, int i2) {
        if (this.mMinScale == getScale() || getScale() - this.mMinScale <= 0.1f) {
            zoomTo(this.MAX_SCALE / getScale(), i, i2);
        } else {
            zoomTo(this.mMinScale / getScale(), i, i2);
        }
    }

    public void zoomTo(float f, int i, int i2) {
        if (getScale() * f >= this.mMinScale) {
            if (f < 1.0f || getScale() * f <= this.MAX_SCALE) {
                this.mMatrix.postScale(f, f);
                this.mMatrix.postTranslate((-((((float) this.mWidth) * f) - ((float) this.mWidth))) / 2.0f, (-((((float) this.mHeight) * f) - ((float) this.mHeight))) / 2.0f);
                this.mMatrix.postTranslate(((float) (-(i - (this.mWidth / 2)))) * f, 0.0f);
                this.mMatrix.postTranslate(0.0f, ((float) (-(i2 - (this.mHeight / 2)))) * f);
                setImageMatrix(this.mMatrix);
            }
        }
    }

    public void cutting() {
        int scale = (int) (((float) this.mIntrinsicWidth) * getScale());
        int scale2 = (int) (((float) this.mIntrinsicHeight) * getScale());
        if (getTranslateX() < ((float) (-(scale - this.mWidth)))) {
            this.mMatrix.postTranslate(-((getTranslateX() + ((float) scale)) - ((float) this.mWidth)), 0.0f);
        }
        if (getTranslateX() > 0.0f) {
            this.mMatrix.postTranslate(-getTranslateX(), 0.0f);
        }
        if (getTranslateY() < ((float) (-(scale2 - this.mHeight)))) {
            this.mMatrix.postTranslate(0.0f, -((getTranslateY() + ((float) scale2)) - ((float) this.mHeight)));
        }
        if (getTranslateY() > 0.0f) {
            this.mMatrix.postTranslate(0.0f, -getTranslateY());
        }
        if (scale < this.mWidth) {
            this.mMatrix.postTranslate(((float) (this.mWidth - scale)) / 2.0f, 0.0f);
        }
        if (scale2 < this.mHeight) {
            this.mMatrix.postTranslate(0.0f, ((float) (this.mHeight - scale2)) / 2.0f);
        }
        setImageMatrix(this.mMatrix);
    }

    private float distance(float f, float f2, float f3, float f4) {
        f -= f2;
        f3 -= f4;
        return (float) Math.sqrt((double) ((f * f) + (f3 * f3)));
    }

    private float dispDistance() {
        return (float) Math.sqrt((double) ((this.mWidth * this.mWidth) + (this.mHeight * this.mHeight)));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        int pointerCount = motionEvent.getPointerCount();
        switch (motionEvent.getAction()) {
            case 0:
            case 5:
            case 261:
                if (pointerCount < 2) {
                    this.mPrevMoveX = (int) motionEvent.getX();
                    this.mPrevMoveY = (int) motionEvent.getY();
                    break;
                }
                this.mPrevDistance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                this.isScaling = true;
                break;
            case 1:
            case 6:
            case 262:
                if (motionEvent.getPointerCount() <= 1) {
                    this.isScaling = false;
                    break;
                }
                break;
            case 2:
                if (pointerCount < 2 || !this.isScaling) {
                    if (!this.isScaling) {
                        pointerCount = this.mPrevMoveX - ((int) motionEvent.getX());
                        int y = this.mPrevMoveY - ((int) motionEvent.getY());
                        this.mPrevMoveX = (int) motionEvent.getX();
                        this.mPrevMoveY = (int) motionEvent.getY();
                        this.mMatrix.postTranslate((float) (-pointerCount), (float) (-y));
                        cutting();
                        break;
                    }
                }
                motionEvent = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                float dispDistance = (motionEvent - this.mPrevDistance) / dispDistance();
                this.mPrevDistance = motionEvent;
                dispDistance += 1.0f;
                zoomTo(dispDistance * dispDistance, this.mWidth / 2, this.mHeight / 2);
                cutting();
                break;
                break;
            default:
                break;
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
