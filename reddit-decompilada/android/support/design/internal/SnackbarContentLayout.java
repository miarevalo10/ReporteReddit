package android.support.design.internal;

import android.content.Context;
import android.support.design.C0016R;
import android.support.design.widget.BaseTransientBottomBar.ContentViewCallback;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private TextView f11030a;
    private Button f11031b;
    private int f11032c;
    private int f11033d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.SnackbarLayout);
        this.f11032c = context.getDimensionPixelSize(C0016R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f11033d = context.getDimensionPixelSize(C0016R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        context.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f11030a = (TextView) findViewById(C0016R.id.snackbar_text);
        this.f11031b = (Button) findViewById(C0016R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f11030a;
    }

    public Button getActionView() {
        return this.f11031b;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11032c > 0 && getMeasuredWidth() > this.f11032c) {
            i = MeasureSpec.makeMeasureSpec(this.f11032c, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0016R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0016R.dimen.design_snackbar_padding_vertical);
        int i3 = 1;
        int i4 = this.f11030a.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i4 == 0 || this.f11033d <= 0 || this.f11031b.getMeasuredWidth() <= this.f11033d) {
            if (i4 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (m9505a(0, dimensionPixelSize, dimensionPixelSize)) {
                if (i3 == 0) {
                    super.onMeasure(i, i2);
                }
            }
        } else if (m9505a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            if (i3 == 0) {
                super.onMeasure(i, i2);
            }
        }
        i3 = 0;
        if (i3 == 0) {
            super.onMeasure(i, i2);
        }
    }

    private boolean m9505a(int i, int i2, int i3) {
        if (i != getOrientation()) {
            setOrientation(i);
            i = 1;
        } else {
            i = 0;
        }
        if (this.f11030a.getPaddingTop() == i2 && this.f11030a.getPaddingBottom() == i3) {
            return i;
        }
        i = this.f11030a;
        if (ViewCompat.m1201B(i)) {
            ViewCompat.m1215a(i, ViewCompat.m1248i(i), i2, ViewCompat.m1249j(i), i3);
        } else {
            i.setPadding(i.getPaddingLeft(), i2, i.getPaddingRight(), i3);
        }
        return 1;
    }

    public final void mo57a() {
        this.f11030a.setAlpha(0.0f);
        this.f11030a.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        if (this.f11031b.getVisibility() == 0) {
            this.f11031b.setAlpha(0.0f);
            this.f11031b.animate().alpha(1.0f).setDuration(180).setStartDelay(70).start();
        }
    }

    public final void mo58b() {
        this.f11030a.setAlpha(1.0f);
        this.f11030a.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        if (this.f11031b.getVisibility() == 0) {
            this.f11031b.setAlpha(1.0f);
            this.f11031b.animate().alpha(0.0f).setDuration(180).setStartDelay(0).start();
        }
    }
}
