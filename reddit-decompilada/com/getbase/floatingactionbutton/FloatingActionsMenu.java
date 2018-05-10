package com.getbase.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

public class FloatingActionsMenu extends ViewGroup {
    private static Interpolator f3920v = new OvershootInterpolator();
    private static Interpolator f3921w = new DecelerateInterpolator(3.0f);
    private static Interpolator f3922x = new DecelerateInterpolator();
    public boolean f3923a;
    private int f3924b;
    private int f3925c;
    private int f3926d;
    private int f3927e;
    private boolean f3928f;
    private int f3929g;
    private int f3930h;
    private int f3931i;
    private int f3932j;
    private AnimatorSet f3933k;
    private AnimatorSet f3934l;
    private AddFloatingActionButton f3935m;
    private RotatingDrawable f3936n;
    private int f3937o;
    private int f3938p;
    private int f3939q;
    private int f3940r;
    private int f3941s;
    private TouchDelegateGroup f3942t;
    private OnFloatingActionsMenuUpdateListener f3943u;

    class C03732 implements OnClickListener {
        final /* synthetic */ FloatingActionsMenu f3910a;

        C03732(FloatingActionsMenu floatingActionsMenu) {
            this.f3910a = floatingActionsMenu;
        }

        public void onClick(View view) {
            this.f3910a.m3533b();
        }
    }

    private class LayoutParams extends android.view.ViewGroup.LayoutParams {
        final /* synthetic */ FloatingActionsMenu f3913a;
        private ObjectAnimator f3914b = new ObjectAnimator();
        private ObjectAnimator f3915c = new ObjectAnimator();
        private ObjectAnimator f3916d = new ObjectAnimator();
        private ObjectAnimator f3917e = new ObjectAnimator();
        private boolean f3918f;

        public LayoutParams(FloatingActionsMenu floatingActionsMenu, android.view.ViewGroup.LayoutParams layoutParams) {
            this.f3913a = floatingActionsMenu;
            super(layoutParams);
            this.f3914b.setInterpolator(FloatingActionsMenu.f3920v);
            this.f3915c.setInterpolator(FloatingActionsMenu.f3922x);
            this.f3916d.setInterpolator(FloatingActionsMenu.f3921w);
            this.f3917e.setInterpolator(FloatingActionsMenu.f3921w);
            this.f3917e.setProperty(View.ALPHA);
            this.f3917e.setFloatValues(new float[]{1.0f, 0.0f});
            this.f3915c.setProperty(View.ALPHA);
            this.f3915c.setFloatValues(new float[]{0.0f, 1.0f});
            switch (floatingActionsMenu.f3929g) {
                case null:
                case 1:
                    this.f3916d.setProperty(View.TRANSLATION_Y);
                    this.f3914b.setProperty(View.TRANSLATION_Y);
                    return;
                case 2:
                case 3:
                    this.f3916d.setProperty(View.TRANSLATION_X);
                    this.f3914b.setProperty(View.TRANSLATION_X);
                    break;
                default:
                    break;
            }
        }

        public final void m3517a(View view) {
            this.f3917e.setTarget(view);
            this.f3916d.setTarget(view);
            this.f3915c.setTarget(view);
            this.f3914b.setTarget(view);
            if (!this.f3918f) {
                m3515a(this.f3914b, view);
                m3515a(this.f3916d, view);
                this.f3913a.f3934l.play(this.f3917e);
                this.f3913a.f3934l.play(this.f3916d);
                this.f3913a.f3933k.play(this.f3915c);
                this.f3913a.f3933k.play(this.f3914b);
                this.f3918f = true;
            }
        }

        private void m3515a(Animator animator, final View view) {
            animator.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ LayoutParams f3912b;

                public void onAnimationEnd(Animator animator) {
                    view.setLayerType(0, null);
                }

                public void onAnimationStart(Animator animator) {
                    view.setLayerType(2, null);
                }
            });
        }
    }

    public interface OnFloatingActionsMenuUpdateListener {
    }

    private static class RotatingDrawable extends LayerDrawable {
        private float f3919a;

        public RotatingDrawable(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        public float getRotation() {
            return this.f3919a;
        }

        public void setRotation(float f) {
            this.f3919a = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.f3919a, (float) getBounds().centerX(), (float) getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C03751();
        public boolean mExpanded;

        static class C03751 implements Creator<SavedState> {
            C03751() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.mExpanded = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mExpanded);
        }
    }

    public FloatingActionsMenu(Context context) {
        this(context, null);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3933k = new AnimatorSet().setDuration(300);
        this.f3934l = new AnimatorSet().setDuration(300);
        m3521a(context, attributeSet);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3933k = new AnimatorSet().setDuration(300);
        this.f3934l = new AnimatorSet().setDuration(300);
        m3521a(context, attributeSet);
    }

    private void m3521a(Context context, AttributeSet attributeSet) {
        this.f3930h = (int) ((getResources().getDimension(C0376R.dimen.fab_actions_spacing) - getResources().getDimension(C0376R.dimen.fab_shadow_radius)) - getResources().getDimension(C0376R.dimen.fab_shadow_offset));
        this.f3931i = getResources().getDimensionPixelSize(C0376R.dimen.fab_labels_margin);
        this.f3932j = getResources().getDimensionPixelSize(C0376R.dimen.fab_shadow_offset);
        this.f3942t = new TouchDelegateGroup(this);
        setTouchDelegate(this.f3942t);
        attributeSet = context.obtainStyledAttributes(attributeSet, C0376R.styleable.FloatingActionsMenu, 0, 0);
        this.f3924b = attributeSet.getColor(C0376R.styleable.FloatingActionsMenu_fab_addButtonPlusIconColor, m3518a(17170443));
        this.f3925c = attributeSet.getColor(C0376R.styleable.FloatingActionsMenu_fab_addButtonColorNormal, m3518a(17170451));
        this.f3926d = attributeSet.getColor(C0376R.styleable.FloatingActionsMenu_fab_addButtonColorPressed, m3518a(17170450));
        this.f3927e = attributeSet.getInt(C0376R.styleable.FloatingActionsMenu_fab_addButtonSize, 0);
        this.f3928f = attributeSet.getBoolean(C0376R.styleable.FloatingActionsMenu_fab_addButtonStrokeVisible, true);
        this.f3929g = attributeSet.getInt(C0376R.styleable.FloatingActionsMenu_fab_expandDirection, 0);
        this.f3939q = attributeSet.getResourceId(C0376R.styleable.FloatingActionsMenu_fab_labelStyle, 0);
        this.f3940r = attributeSet.getInt(C0376R.styleable.FloatingActionsMenu_fab_labelsPosition, 0);
        attributeSet.recycle();
        if (this.f3939q == null || m3530f() == null) {
            this.f3935m = new AddFloatingActionButton(this, context) {
                final /* synthetic */ FloatingActionsMenu f16756g;

                final void mo3301a() {
                    this.a = this.f16756g.f3924b;
                    this.b = this.f16756g.f3925c;
                    this.c = this.f16756g.f3926d;
                    this.f = this.f16756g.f3928f;
                    super.mo3301a();
                }

                Drawable getIconDrawable() {
                    RotatingDrawable rotatingDrawable = new RotatingDrawable(super.getIconDrawable());
                    this.f16756g.f3936n = rotatingDrawable;
                    TimeInterpolator overshootInterpolator = new OvershootInterpolator();
                    Animator ofFloat = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", new float[]{135.0f, 0.0f});
                    Animator ofFloat2 = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", new float[]{0.0f, 135.0f});
                    ofFloat.setInterpolator(overshootInterpolator);
                    ofFloat2.setInterpolator(overshootInterpolator);
                    this.f16756g.f3933k.play(ofFloat2);
                    this.f16756g.f3934l.play(ofFloat);
                    return rotatingDrawable;
                }
            };
            this.f3935m.setId(C0376R.id.fab_expand_menu_button);
            this.f3935m.setSize(this.f3927e);
            this.f3935m.setOnClickListener(new C03732(this));
            addView(this.f3935m, super.generateDefaultLayoutParams());
            this.f3941s += 1;
            return;
        }
        throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
    }

    public void setOnFloatingActionsMenuUpdateListener(OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener) {
        this.f3943u = onFloatingActionsMenuUpdateListener;
    }

    private boolean m3530f() {
        if (this.f3929g != 2) {
            if (this.f3929g != 3) {
                return false;
            }
        }
        return true;
    }

    private int m3518a(int i) {
        return getResources().getColor(i);
    }

    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        i = 0;
        this.f3937o = 0;
        this.f3938p = 0;
        i2 = 0;
        int i3 = i2;
        int i4 = i3;
        int i5 = i4;
        while (i2 < this.f3941s) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                switch (this.f3929g) {
                    case 0:
                    case 1:
                        this.f3937o = Math.max(this.f3937o, childAt.getMeasuredWidth());
                        i4 += childAt.getMeasuredHeight();
                        break;
                    case 2:
                    case 3:
                        i5 += childAt.getMeasuredWidth();
                        this.f3938p = Math.max(this.f3938p, childAt.getMeasuredHeight());
                        break;
                    default:
                        break;
                }
                if (!m3530f()) {
                    TextView textView = (TextView) childAt.getTag(C0376R.id.fab_label);
                    if (textView != null) {
                        i3 = Math.max(i3, textView.getMeasuredWidth());
                    }
                }
            }
            i2++;
        }
        if (m3530f() == 0) {
            i2 = this.f3937o;
            if (i3 > 0) {
                i = this.f3931i + i3;
            }
            i5 = i2 + i;
        } else {
            i4 = this.f3938p;
        }
        switch (this.f3929g) {
            case 0:
            case 1:
                i4 = ((i4 + (this.f3930h * (this.f3941s - 1))) * 12) / 10;
                break;
            case 2:
            case 3:
                i5 = ((i5 + (this.f3930h * (this.f3941s - 1))) * 12) / 10;
                break;
            default:
                break;
        }
        setMeasuredDimension(i5, i4);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 8;
        int i6 = 1;
        int i7 = 0;
        float f = 0.0f;
        int measuredHeight;
        int i8;
        int measuredWidth;
        int i9;
        int i10;
        View childAt;
        int i11;
        switch (this.f3929g) {
            case 0:
            case 1:
                int i12 = r0.f3929g == 0 ? 1 : 0;
                if (z) {
                    TouchDelegateGroup touchDelegateGroup = r0.f3942t;
                    touchDelegateGroup.f3945a.clear();
                    touchDelegateGroup.f3946b = null;
                }
                measuredHeight = i12 != 0 ? (i4 - i2) - r0.f3935m.getMeasuredHeight() : 0;
                i8 = r0.f3940r == 0 ? (i3 - i) - (r0.f3937o / 2) : r0.f3937o / 2;
                measuredWidth = i8 - (r0.f3935m.getMeasuredWidth() / 2);
                r0.f3935m.layout(measuredWidth, measuredHeight, r0.f3935m.getMeasuredWidth() + measuredWidth, r0.f3935m.getMeasuredHeight() + measuredHeight);
                measuredWidth = (r0.f3937o / 2) + r0.f3931i;
                measuredWidth = r0.f3940r == 0 ? i8 - measuredWidth : measuredWidth + i8;
                if (i12 != 0) {
                    i9 = measuredHeight - r0.f3930h;
                } else {
                    i9 = (r0.f3935m.getMeasuredHeight() + measuredHeight) + r0.f3930h;
                }
                i10 = r0.f3941s - 1;
                while (i10 >= 0) {
                    int i13;
                    int i14;
                    childAt = getChildAt(i10);
                    if (childAt == r0.f3935m || childAt.getVisibility() == r6) {
                        i13 = i8;
                        i14 = i6;
                        i11 = i7;
                    } else {
                        i11 = i8 - (childAt.getMeasuredWidth() / 2);
                        if (i12 != 0) {
                            i9 -= childAt.getMeasuredHeight();
                        }
                        childAt.layout(i11, i9, childAt.getMeasuredWidth() + i11, childAt.getMeasuredHeight() + i9);
                        float f2 = (float) (measuredHeight - i9);
                        childAt.setTranslationY(r0.f3923a ? f : f2);
                        childAt.setAlpha(r0.f3923a ? 1.0f : f);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        i13 = i8;
                        layoutParams.f3916d.setFloatValues(new float[]{f, f2});
                        layoutParams.f3914b.setFloatValues(new float[]{f2, f});
                        layoutParams.m3517a(childAt);
                        View view = (View) childAt.getTag(C0376R.id.fab_label);
                        if (view != null) {
                            if (r0.f3940r == 0) {
                                i5 = measuredWidth - view.getMeasuredWidth();
                            } else {
                                i5 = view.getMeasuredWidth() + measuredWidth;
                            }
                            i14 = r0.f3940r == 0 ? i5 : measuredWidth;
                            if (r0.f3940r == 0) {
                                i5 = measuredWidth;
                            }
                            i6 = (i9 - r0.f3932j) + ((childAt.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                            view.layout(i14, i6, i5, i6 + view.getMeasuredHeight());
                            r0.f3942t.f3945a.add(new TouchDelegate(new Rect(Math.min(i11, i14), i9 - (r0.f3930h / 2), Math.max(i11 + childAt.getMeasuredWidth(), i5), (childAt.getMeasuredHeight() + i9) + (r0.f3930h / 2)), childAt));
                            view.setTranslationY(r0.f3923a ? 0.0f : f2);
                            view.setAlpha(r0.f3923a ? 1.0f : 0.0f);
                            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                            ObjectAnimator a = layoutParams2.f3916d;
                            float[] fArr = new float[2];
                            f = 0.0f;
                            i11 = 0;
                            fArr[0] = 0.0f;
                            i14 = 1;
                            fArr[1] = f2;
                            a.setFloatValues(fArr);
                            layoutParams2.f3914b.setFloatValues(new float[]{f2, 0.0f});
                            layoutParams2.m3517a(view);
                        } else {
                            i14 = i6;
                            i11 = i7;
                        }
                        if (i12 != 0) {
                            i9 -= r0.f3930h;
                        } else {
                            i9 = (i9 + childAt.getMeasuredHeight()) + r0.f3930h;
                        }
                    }
                    i10--;
                    i7 = i11;
                    i6 = i14;
                    i8 = i13;
                    i5 = 8;
                }
                return;
            case 2:
            case 3:
                i10 = r0.f3929g == 2 ? 1 : 0;
                i8 = i10 != 0 ? (i3 - i) - r0.f3935m.getMeasuredWidth() : 0;
                measuredHeight = ((i4 - i2) - r0.f3938p) + ((r0.f3938p - r0.f3935m.getMeasuredHeight()) / 2);
                r0.f3935m.layout(i8, measuredHeight, r0.f3935m.getMeasuredWidth() + i8, r0.f3935m.getMeasuredHeight() + measuredHeight);
                if (i10 != 0) {
                    measuredWidth = i8 - r0.f3930h;
                } else {
                    measuredWidth = (r0.f3935m.getMeasuredWidth() + 0) + r0.f3930h;
                }
                for (i9 = r0.f3941s - 1; i9 >= 0; i9--) {
                    childAt = getChildAt(i9);
                    if (!(childAt == r0.f3935m || childAt.getVisibility() == 8)) {
                        if (i10 != 0) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                        i11 = ((r0.f3935m.getMeasuredHeight() - childAt.getMeasuredHeight()) / 2) + measuredHeight;
                        childAt.layout(measuredWidth, i11, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i11);
                        childAt.setTranslationX(r0.f3923a ? 0.0f : (float) (i8 - measuredWidth));
                        childAt.setAlpha(r0.f3923a ? 1.0f : 0.0f);
                        LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                        layoutParams3.f3916d.setFloatValues(new float[]{0.0f, r13});
                        layoutParams3.f3914b.setFloatValues(new float[]{r13, 0.0f});
                        layoutParams3.m3517a(childAt);
                        if (i10 != 0) {
                            measuredWidth -= r0.f3930h;
                        } else {
                            measuredWidth = (measuredWidth + childAt.getMeasuredWidth()) + r0.f3930h;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(this, super.generateDefaultLayoutParams());
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this, super.generateLayoutParams(attributeSet));
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(this, super.generateLayoutParams(layoutParams));
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f3935m);
        this.f3941s = getChildCount();
        if (this.f3939q != 0) {
            Context contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f3939q);
            for (int i = 0; i < this.f3941s; i++) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
                String title = floatingActionButton.getTitle();
                if (!(floatingActionButton == this.f3935m || title == null || floatingActionButton.getTag(C0376R.id.fab_label) != null)) {
                    View textView = new TextView(contextThemeWrapper);
                    textView.setTextAppearance(getContext(), this.f3939q);
                    textView.setText(floatingActionButton.getTitle());
                    addView(textView);
                    floatingActionButton.setTag(C0376R.id.fab_label, textView);
                }
            }
        }
    }

    public final void m3533b() {
        if (this.f3923a) {
            m3532a();
            return;
        }
        if (!this.f3923a) {
            this.f3923a = true;
            this.f3942t.f3947c = true;
            this.f3934l.cancel();
            this.f3933k.start();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f3935m.setEnabled(z);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.mExpanded = this.f3923a;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f3923a = savedState.mExpanded;
            this.f3942t.f3947c = this.f3923a;
            if (this.f3936n != null) {
                this.f3936n.setRotation(this.f3923a ? 135.0f : 0.0f);
            }
            super.onRestoreInstanceState(savedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public final void m3532a() {
        if (this.f3923a) {
            this.f3923a = false;
            this.f3942t.f3947c = false;
            this.f3934l.setDuration(300);
            this.f3934l.start();
            this.f3933k.cancel();
        }
    }
}
