package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    private final AppCompatSeekBarHelper f2166a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.seekBarStyle);
    }

    private AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2166a = new AppCompatSeekBarHelper(this);
        this.f2166a.mo588a(attributeSet, i);
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        AppCompatSeekBarHelper appCompatSeekBarHelper = this.f2166a;
        if (appCompatSeekBarHelper.f11900c != null) {
            int max = appCompatSeekBarHelper.f11899b.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = appCompatSeekBarHelper.f11900c.getIntrinsicWidth();
                int intrinsicHeight = appCompatSeekBarHelper.f11900c.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                appCompatSeekBarHelper.f11900c.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((appCompatSeekBarHelper.f11899b.getWidth() - appCompatSeekBarHelper.f11899b.getPaddingLeft()) - appCompatSeekBarHelper.f11899b.getPaddingRight())) / ((float) max);
                intrinsicWidth = canvas.save();
                canvas.translate((float) appCompatSeekBarHelper.f11899b.getPaddingLeft(), (float) (appCompatSeekBarHelper.f11899b.getHeight() / 2));
                for (intrinsicHeight = 0; intrinsicHeight <= max; intrinsicHeight++) {
                    appCompatSeekBarHelper.f11900c.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicWidth);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatSeekBarHelper appCompatSeekBarHelper = this.f2166a;
        Drawable drawable = appCompatSeekBarHelper.f11900c;
        if (drawable != null && drawable.isStateful() && drawable.setState(appCompatSeekBarHelper.f11899b.getDrawableState())) {
            appCompatSeekBarHelper.f11899b.invalidateDrawable(drawable);
        }
    }

    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        AppCompatSeekBarHelper appCompatSeekBarHelper = this.f2166a;
        if (appCompatSeekBarHelper.f11900c != null) {
            appCompatSeekBarHelper.f11900c.jumpToCurrentState();
        }
    }
}
