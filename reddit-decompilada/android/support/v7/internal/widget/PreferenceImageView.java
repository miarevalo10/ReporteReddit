package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.preference.C0177R;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class PreferenceImageView extends ImageView {
    private int f1862a;
    private int f1863b;

    public PreferenceImageView(Context context) {
        this(context, null);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1862a = RedditJobManager.f10810d;
        this.f1863b = RedditJobManager.f10810d;
        context = context.obtainStyledAttributes(attributeSet, C0177R.styleable.PreferenceImageView, i, 0);
        setMaxWidth(context.getDimensionPixelSize(C0177R.styleable.PreferenceImageView_maxWidth, RedditJobManager.f10810d));
        setMaxHeight(context.getDimensionPixelSize(C0177R.styleable.PreferenceImageView_maxHeight, RedditJobManager.f10810d));
        context.recycle();
    }

    public void setMaxWidth(int i) {
        this.f1862a = i;
        super.setMaxWidth(i);
    }

    public int getMaxWidth() {
        return this.f1862a;
    }

    public void setMaxHeight(int i) {
        this.f1863b = i;
        super.setMaxHeight(i);
    }

    public int getMaxHeight() {
        return this.f1863b;
    }

    protected void onMeasure(int i, int i2) {
        int maxWidth;
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = MeasureSpec.getSize(i);
            maxWidth = getMaxWidth();
            if (maxWidth != RedditJobManager.f10810d && (maxWidth < size || mode == 0)) {
                i = MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        mode = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            size = MeasureSpec.getSize(i2);
            maxWidth = getMaxHeight();
            if (maxWidth != RedditJobManager.f10810d && (maxWidth < size || mode == 0)) {
                i2 = MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i, i2);
    }
}
