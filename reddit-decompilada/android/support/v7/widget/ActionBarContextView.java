package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends AbsActionBarView {
    public View f11808g;
    public boolean f11809h;
    private CharSequence f11810i;
    private CharSequence f11811j;
    private View f11812k;
    private LinearLayout f11813l;
    private TextView f11814m;
    private TextView f11815n;
    private int f11816o;
    private int f11817p;
    private int f11818q;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat mo548a(int i, long j) {
        return super.mo548a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = TintTypedArray.m2308a(context, attributeSet, C0164R.styleable.ActionMode, i, 0);
        ViewCompat.m1219a((View) this, context.m2311a(C0164R.styleable.ActionMode_background));
        this.f11816o = context.m2323g(C0164R.styleable.ActionMode_titleTextStyle, 0);
        this.f11817p = context.m2323g(C0164R.styleable.ActionMode_subtitleTextStyle, 0);
        this.e = context.m2321f(C0164R.styleable.ActionMode_height, 0);
        this.f11818q = context.m2323g(C0164R.styleable.ActionMode_closeItemLayout, C0164R.layout.abc_action_mode_close_item_material);
        context.f2595b.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m16897g();
            this.d.m16899i();
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f11812k != null) {
            removeView(this.f11812k);
        }
        this.f11812k = view;
        if (!(view == null || this.f11813l == null)) {
            removeView(this.f11813l);
            this.f11813l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f11810i = charSequence;
        m10517c();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f11811j = charSequence;
        m10517c();
    }

    public CharSequence getTitle() {
        return this.f11810i;
    }

    public CharSequence getSubtitle() {
        return this.f11811j;
    }

    private void m10517c() {
        if (this.f11813l == null) {
            LayoutInflater.from(getContext()).inflate(C0164R.layout.abc_action_bar_title_item, this);
            this.f11813l = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f11814m = (TextView) this.f11813l.findViewById(C0164R.id.action_bar_title);
            this.f11815n = (TextView) this.f11813l.findViewById(C0164R.id.action_bar_subtitle);
            if (this.f11816o != 0) {
                this.f11814m.setTextAppearance(getContext(), this.f11816o);
            }
            if (this.f11817p != 0) {
                this.f11815n.setTextAppearance(getContext(), this.f11817p);
            }
        }
        this.f11814m.setText(this.f11810i);
        this.f11815n.setText(this.f11811j);
        int isEmpty = TextUtils.isEmpty(this.f11810i) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(this.f11811j) ^ 1;
        int i = 8;
        this.f11815n.setVisibility(isEmpty2 != 0 ? 0 : 8);
        LinearLayout linearLayout = this.f11813l;
        if (!(isEmpty == 0 && isEmpty2 == 0)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f11813l.getParent() == null) {
            addView(this.f11813l);
        }
    }

    public final void m10519a(final ActionMode actionMode) {
        if (this.f11808g == null) {
            this.f11808g = LayoutInflater.from(getContext()).inflate(this.f11818q, this, false);
            addView(this.f11808g);
        } else if (this.f11808g.getParent() == null) {
            addView(this.f11808g);
        }
        this.f11808g.findViewById(C0164R.id.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView f2070b;

            public void onClick(View view) {
                actionMode.mo469c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.mo466b();
        if (this.d != null) {
            this.d.m16898h();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.m16895e();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo3223a((ViewGroup) this);
        ViewCompat.m1219a(this.c, null);
        addView(this.c, layoutParams);
    }

    public final void m10521b() {
        removeAllViews();
        this.f11812k = null;
        this.c = null;
    }

    public final boolean mo549a() {
        return this.d != null ? this.d.m16896f() : false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (MeasureSpec.getMode(i) != 1073741824) {
            i2 = new StringBuilder();
            i2.append(getClass().getSimpleName());
            i2.append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(i2.toString());
        } else if (MeasureSpec.getMode(i2) == 0) {
            i2 = new StringBuilder();
            i2.append(getClass().getSimpleName());
            i2.append(" can only be used with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(i2.toString());
        } else {
            int i4;
            i = MeasureSpec.getSize(i);
            if (this.e > 0) {
                i2 = this.e;
            } else {
                i2 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            int i5 = i2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f11808g != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f11808g.getLayoutParams();
                paddingLeft = AbsActionBarView.m1747a(this.f11808g, paddingLeft, makeMeasureSpec) - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = AbsActionBarView.m1747a(this.c, paddingLeft, makeMeasureSpec);
            }
            int i6 = 0;
            if (this.f11813l != null && this.f11812k == null) {
                if (this.f11809h) {
                    this.f11813l.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    makeMeasureSpec = this.f11813l.getMeasuredWidth();
                    i4 = makeMeasureSpec <= paddingLeft ? 1 : 0;
                    if (i4 != 0) {
                        paddingLeft -= makeMeasureSpec;
                    }
                    this.f11813l.setVisibility(i4 != 0 ? 0 : 8);
                } else {
                    paddingLeft = AbsActionBarView.m1747a(this.f11813l, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.f11812k != null) {
                LayoutParams layoutParams = this.f11812k.getLayoutParams();
                i4 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i5);
                }
                this.f11812k.measure(MeasureSpec.makeMeasureSpec(paddingLeft, i4), MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.e <= 0) {
                i2 = getChildCount();
                i3 = 0;
                while (i6 < i2) {
                    paddingLeft = getChildAt(i6).getMeasuredHeight() + paddingTop;
                    if (paddingLeft > i3) {
                        i3 = paddingLeft;
                    }
                    i6++;
                }
                setMeasuredDimension(i, i3);
                return;
            }
            setMeasuredDimension(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = ViewUtils.m2390a(this);
        int paddingRight = z ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        i4 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.f11808g == 0 || this.f11808g.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f11808g.getLayoutParams();
            int i5 = z ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i2 = z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = AbsActionBarView.m1746a(paddingRight, i5, z);
            paddingRight = AbsActionBarView.m1746a(paddingRight + AbsActionBarView.m1748a(this.f11808g, paddingRight, paddingTop, i4, z), i2, z);
        }
        if (!(this.f11813l == 0 || this.f11812k != 0 || this.f11813l.getVisibility() == 8)) {
            paddingRight += AbsActionBarView.m1748a(this.f11813l, paddingRight, paddingTop, i4, z);
        }
        if (this.f11812k != 0) {
            AbsActionBarView.m1748a(this.f11812k, paddingRight, paddingTop, i4, z);
        }
        i = z ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != 0) {
            AbsActionBarView.m1748a(this.c, i, paddingTop, i4, z ^ 1);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f11810i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f11809h) {
            requestLayout();
        }
        this.f11809h = z;
    }
}
