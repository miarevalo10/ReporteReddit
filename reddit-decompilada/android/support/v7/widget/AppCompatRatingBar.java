package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper f2165a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.ratingBarStyle);
    }

    private AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2165a = new AppCompatProgressBarHelper(this);
        this.f2165a.mo588a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        i2 = this.f2165a.f2163a;
        if (i2 != 0) {
            setMeasuredDimension(View.resolveSizeAndState(i2.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
