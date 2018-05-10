package android.support.constraint;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class Barrier extends ConstraintHelper {
    private int f10985f = 0;
    private int f10986g = 0;
    private android.support.constraint.solver.widgets.Barrier f10987h;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f10985f;
    }

    public void setType(int i) {
        this.f10985f = i;
        this.f10986g = i;
        if (VERSION.SDK_INT >= 17) {
            if ((1 == getResources().getConfiguration().getLayoutDirection() ? 1 : 0) != 0) {
                if (this.f10985f == 5) {
                    this.f10986g = 1;
                } else if (this.f10985f == 6) {
                    this.f10986g = 0;
                }
            } else if (this.f10985f == 5) {
                this.f10986g = 0;
            } else if (this.f10985f == 6) {
                this.f10986g = 1;
            }
        } else if (this.f10985f == 5) {
            this.f10986g = 0;
        } else if (this.f10985f == 6) {
            this.f10986g = 1;
        }
        this.f10987h.f16395a = this.f10986g;
    }

    protected final void mo5a(AttributeSet attributeSet) {
        super.mo5a(attributeSet);
        this.f10987h = new android.support.constraint.solver.widgets.Barrier();
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, C0004R.styleable.ConstraintLayout_Layout);
            int indexCount = attributeSet.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = attributeSet.getIndex(i);
                if (index == C0004R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(attributeSet.getInt(index, 0));
                }
            }
        }
        this.d = this.f10987h;
        m21a();
    }
}
