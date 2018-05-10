package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ActionBarPolicy;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ScrollingTabContainerView extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2482i = new DecelerateInterpolator();
    Runnable f2483a;
    LinearLayoutCompat f2484b;
    int f2485c;
    int f2486d;
    int f2487e;
    private Spinner f2488f;
    private boolean f2489g;
    private int f2490h;

    private class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView f2481a;

        public long getItemId(int i) {
            return (long) i;
        }

        TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
            this.f2481a = scrollingTabContainerView;
        }

        public int getCount() {
            return this.f2481a.f2484b.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) this.f2481a.f2484b.getChildAt(i)).f12045a;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f2481a;
                View tabView = new TabView(view, view.getContext(), (Tab) getItem(i));
                tabView.setBackgroundDrawable(0);
                tabView.setLayoutParams(new LayoutParams(-1, view.f2487e));
                return tabView;
            }
            TabView tabView2 = (TabView) view;
            tabView2.f12045a = (Tab) getItem(i);
            tabView2.m10827a();
            return view;
        }
    }

    private class TabView extends LinearLayoutCompat {
        Tab f12045a;
        final /* synthetic */ ScrollingTabContainerView f12046b;
        private final int[] f12047c = new int[]{16842964};
        private TextView f12048d;
        private ImageView f12049e;
        private View f12050f;

        public TabView(ScrollingTabContainerView scrollingTabContainerView, Context context, Tab tab) {
            this.f12046b = scrollingTabContainerView;
            super(context, null, C0164R.attr.actionBarTabStyle);
            this.f12045a = tab;
            scrollingTabContainerView = TintTypedArray.m2308a(context, null, this.f12047c, C0164R.attr.actionBarTabStyle, 0);
            if (scrollingTabContainerView.m2322f(0) != null) {
                setBackgroundDrawable(scrollingTabContainerView.m2311a(0));
            }
            scrollingTabContainerView.f2595b.recycle();
            setGravity(8388627);
            m10827a();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(true);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Tab.class.getName());
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f12046b.f2485c > 0 && getMeasuredWidth() > this.f12046b.f2485c) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f12046b.f2485c, 1073741824), i2);
            }
        }

        public final void m10827a() {
            Tab tab = this.f12045a;
            View c = tab.m1472c();
            CharSequence charSequence = null;
            if (c != null) {
                TabView parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f12050f = c;
                if (this.f12048d != null) {
                    this.f12048d.setVisibility(8);
                }
                if (this.f12049e != null) {
                    this.f12049e.setVisibility(8);
                    this.f12049e.setImageDrawable(null);
                }
                return;
            }
            if (this.f12050f != null) {
                removeView(this.f12050f);
                this.f12050f = null;
            }
            Drawable a = tab.m1470a();
            CharSequence b = tab.m1471b();
            if (a != null) {
                if (this.f12049e == null) {
                    View appCompatImageView = new AppCompatImageView(getContext());
                    ViewGroup.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.f2299h = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f12049e = appCompatImageView;
                }
                this.f12049e.setImageDrawable(a);
                this.f12049e.setVisibility(0);
            } else if (this.f12049e != null) {
                this.f12049e.setVisibility(8);
                this.f12049e.setImageDrawable(null);
            }
            int isEmpty = TextUtils.isEmpty(b) ^ 1;
            if (isEmpty != 0) {
                if (this.f12048d == null) {
                    View appCompatTextView = new AppCompatTextView(getContext(), null, C0164R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TruncateAt.END);
                    ViewGroup.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams2.f2299h = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f12048d = appCompatTextView;
                }
                this.f12048d.setText(b);
                this.f12048d.setVisibility(0);
            } else if (this.f12048d != null) {
                this.f12048d.setVisibility(8);
                this.f12048d.setText(null);
            }
            if (this.f12049e != null) {
                this.f12049e.setContentDescription(tab.m1473d());
            }
            if (isEmpty == 0) {
                charSequence = tab.m1473d();
            }
            TooltipCompat.m2349a(this, charSequence);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onMeasure(int i, int i2) {
        i2 = MeasureSpec.getMode(i);
        int i3 = 1;
        boolean z = i2 == 1073741824;
        setFillViewport(z);
        int childCount = this.f2484b.getChildCount();
        if (childCount <= 1 || !(i2 == 1073741824 || i2 == Integer.MIN_VALUE)) {
            this.f2485c = -1;
        } else {
            if (childCount > 2) {
                this.f2485c = (int) (((float) MeasureSpec.getSize(i)) * 1053609165);
            } else {
                this.f2485c = MeasureSpec.getSize(i) / 2;
            }
            this.f2485c = Math.min(this.f2485c, this.f2486d);
        }
        i2 = MeasureSpec.makeMeasureSpec(this.f2487e, 1073741824);
        if (z || !this.f2489g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2484b.measure(0, i2);
            if (this.f2484b.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                m2260b();
            } else if (!m2259a()) {
                if (this.f2488f == null) {
                    Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, C0164R.attr.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.f2488f = appCompatSpinner;
                }
                removeView(this.f2484b);
                addView(this.f2488f, new ViewGroup.LayoutParams(-2, -1));
                if (this.f2488f.getAdapter() == null) {
                    this.f2488f.setAdapter(new TabAdapter(this));
                }
                if (this.f2483a != null) {
                    removeCallbacks(this.f2483a);
                    this.f2483a = null;
                }
                this.f2488f.setSelection(this.f2490h);
            }
        } else {
            m2260b();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        i = getMeasuredWidth();
        if (z && measuredWidth != i) {
            setTabSelected(this.f2490h);
        }
    }

    private boolean m2259a() {
        return this.f2488f != null && this.f2488f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f2489g = z;
    }

    private boolean m2260b() {
        if (!m2259a()) {
            return false;
        }
        removeView(this.f2488f);
        addView(this.f2484b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f2488f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.f2490h = i;
        int childCount = this.f2484b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2484b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                childAt = this.f2484b.getChildAt(i);
                if (this.f2483a != null) {
                    removeCallbacks(this.f2483a);
                }
                this.f2483a = new Runnable(this) {
                    final /* synthetic */ ScrollingTabContainerView f2480b;

                    public void run() {
                        this.f2480b.smoothScrollTo(childAt.getLeft() - ((this.f2480b.getWidth() - childAt.getWidth()) / 2), 0);
                        this.f2480b.f2483a = null;
                    }
                };
                post(this.f2483a);
            }
            i2++;
        }
        if (this.f2488f != null && i >= 0) {
            this.f2488f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f2487e = i;
        requestLayout();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = ActionBarPolicy.m1671a(getContext());
        TypedArray obtainStyledAttributes = configuration.f1959a.obtainStyledAttributes(null, C0164R.styleable.ActionBar, C0164R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0164R.styleable.ActionBar_height, 0);
        Resources resources = configuration.f1959a.getResources();
        if (!configuration.m1673b()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0164R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.f2486d = configuration.f1959a.getResources().getDimensionPixelSize(C0164R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2483a != null) {
            post(this.f2483a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2483a != null) {
            removeCallbacks(this.f2483a);
        }
    }
}
