package android.support.constraint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Constraints extends ViewGroup {
    ConstraintSet f182a;

    public static class LayoutParams extends android.support.constraint.ConstraintLayout.LayoutParams {
        public float an;
        public boolean ao;
        public float ap;
        public float aq;
        public float ar;
        public float as;
        public float at;
        public float au;
        public float av;
        public float aw;
        public float ax;
        public float ay;
        public float az;

        public LayoutParams() {
            this.an = 1.0f;
            this.ao = false;
            this.ap = 0.0f;
            this.aq = 0.0f;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 1.0f;
            this.au = 1.0f;
            this.av = 0.0f;
            this.aw = 0.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.an = 1.0f;
            int i = 0;
            this.ao = false;
            this.ap = 0.0f;
            this.aq = 0.0f;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 1.0f;
            this.au = 1.0f;
            this.av = 0.0f;
            this.aw = 0.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
            context = context.obtainStyledAttributes(attributeSet, C0004R.styleable.ConstraintSet);
            attributeSet = context.getIndexCount();
            while (i < attributeSet) {
                int index = context.getIndex(i);
                if (index == C0004R.styleable.ConstraintSet_android_alpha) {
                    this.an = context.getFloat(index, this.an);
                } else if (index == C0004R.styleable.ConstraintSet_android_elevation) {
                    this.ap = context.getFloat(index, this.ap);
                    this.ao = true;
                } else if (index == C0004R.styleable.ConstraintSet_android_rotationX) {
                    this.ar = context.getFloat(index, this.ar);
                } else if (index == C0004R.styleable.ConstraintSet_android_rotationY) {
                    this.as = context.getFloat(index, this.as);
                } else if (index == C0004R.styleable.ConstraintSet_android_rotation) {
                    this.aq = context.getFloat(index, this.aq);
                } else if (index == C0004R.styleable.ConstraintSet_android_scaleX) {
                    this.at = context.getFloat(index, this.at);
                } else if (index == C0004R.styleable.ConstraintSet_android_scaleY) {
                    this.au = context.getFloat(index, this.au);
                } else if (index == C0004R.styleable.ConstraintSet_android_transformPivotX) {
                    this.av = context.getFloat(index, this.av);
                } else if (index == C0004R.styleable.ConstraintSet_android_transformPivotY) {
                    this.aw = context.getFloat(index, this.aw);
                } else if (index == C0004R.styleable.ConstraintSet_android_translationX) {
                    this.ax = context.getFloat(index, this.ax);
                } else if (index == C0004R.styleable.ConstraintSet_android_translationY) {
                    this.ay = context.getFloat(index, this.ay);
                } else if (index == C0004R.styleable.ConstraintSet_android_translationZ) {
                    this.ax = context.getFloat(index, this.az);
                }
                i++;
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new android.support.constraint.ConstraintLayout.LayoutParams(layoutParams);
    }

    public ConstraintSet getConstraintSet() {
        if (this.f182a == null) {
            this.f182a = new ConstraintSet();
        }
        ConstraintSet constraintSet = this.f182a;
        int childCount = getChildCount();
        constraintSet.f181a.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!constraintSet.f181a.containsKey(Integer.valueOf(id))) {
                constraintSet.f181a.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) constraintSet.f181a.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                Constraint.m32a(constraint, (ConstraintHelper) childAt, id, layoutParams);
            }
            constraint.m30a(id, layoutParams);
        }
        return this.f182a;
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
