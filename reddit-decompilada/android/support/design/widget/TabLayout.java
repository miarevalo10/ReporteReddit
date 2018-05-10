package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0016R;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@DecorView
public class TabLayout extends HorizontalScrollView {
    private static final Pool<Tab> f660n = new SynchronizedPool(16);
    private DataSetObserver f661A;
    private TabLayoutOnPageChangeListener f662B;
    private AdapterChangeListener f663C;
    private boolean f664D;
    private final Pool<TabView> f665E;
    int f666a;
    int f667b;
    int f668c;
    int f669d;
    int f670e;
    ColorStateList f671f;
    float f672g;
    float f673h;
    final int f674i;
    int f675j;
    int f676k;
    int f677l;
    ViewPager f678m;
    private final ArrayList<Tab> f679o;
    private Tab f680p;
    private final SlidingTabStrip f681q;
    private final int f682r;
    private final int f683s;
    private final int f684t;
    private int f685u;
    private OnTabSelectedListener f686v;
    private final ArrayList<OnTabSelectedListener> f687w;
    private OnTabSelectedListener f688x;
    private ValueAnimator f689y;
    private PagerAdapter f690z;

    class C00391 implements AnimatorUpdateListener {
        final /* synthetic */ TabLayout f626a;

        C00391(TabLayout tabLayout) {
            this.f626a = tabLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f626a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public interface OnTabSelectedListener {
        void mo121a(Tab tab);
    }

    private class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ TabLayout f627a;

        PagerAdapterObserver(TabLayout tabLayout) {
            this.f627a = tabLayout;
        }

        public void onChanged() {
            this.f627a.m324a();
        }

        public void onInvalidated() {
            this.f627a.m324a();
        }
    }

    private class SlidingTabStrip extends LinearLayout {
        int f635a = -1;
        float f636b;
        ValueAnimator f637c;
        final /* synthetic */ TabLayout f638d;
        private int f639e;
        private final Paint f640f;
        private int f641g = -1;
        private int f642h = -1;
        private int f643i = -1;

        SlidingTabStrip(TabLayout tabLayout, Context context) {
            this.f638d = tabLayout;
            super(context);
            setWillNotDraw(null);
            this.f640f = new Paint();
        }

        final void m300a(int i) {
            if (this.f640f.getColor() != i) {
                this.f640f.setColor(i);
                ViewCompat.m1234c(this);
            }
        }

        final void m302b(int i) {
            if (this.f639e != i) {
                this.f639e = i;
                ViewCompat.m1234c(this);
            }
        }

        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (VERSION.SDK_INT < 23 && this.f641g != i) {
                requestLayout();
                this.f641g = i;
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824) {
                int i3 = 1;
                if (this.f638d.f677l == 1 && this.f638d.f676k == 1) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = i5;
                    while (i5 < childCount) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i6 = Math.max(i6, childAt.getMeasuredWidth());
                        }
                        i5++;
                    }
                    if (i6 > 0) {
                        if (i6 * childCount <= getMeasuredWidth() - (this.f638d.m332b(16) * 2)) {
                            i5 = 0;
                            while (i4 < childCount) {
                                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                                if (layoutParams.width != i6 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i6;
                                    layoutParams.weight = 0.0f;
                                    i5 = 1;
                                }
                                i4++;
                            }
                            i3 = i5;
                        } else {
                            this.f638d.f676k = 0;
                            this.f638d.m331a(false);
                        }
                        if (i3 != 0) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f637c && this.f637c.isRunning()) {
                this.f637c.cancel();
                m303b(this.f635a, Math.round((1065353216 - this.f637c.getAnimatedFraction()) * ((float) this.f637c.getDuration())));
                return;
            }
            m299a();
        }

        final void m299a() {
            int i;
            int i2;
            View childAt = getChildAt(this.f635a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.f636b > 0.0f && this.f635a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f635a + 1);
                    i = (int) ((this.f636b * ((float) childAt2.getLeft())) + ((1.0f - this.f636b) * ((float) i)));
                    i2 = (int) ((this.f636b * ((float) childAt2.getRight())) + ((1.0f - this.f636b) * ((float) i2)));
                }
            }
            m301a(i, i2);
        }

        final void m301a(int i, int i2) {
            if (i != this.f642h || i2 != this.f643i) {
                this.f642h = i;
                this.f643i = i2;
                ViewCompat.m1234c(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m303b(final int r10, int r11) {
            /*
            r9 = this;
            r0 = r9.f637c;
            if (r0 == 0) goto L_0x0011;
        L_0x0004:
            r0 = r9.f637c;
            r0 = r0.isRunning();
            if (r0 == 0) goto L_0x0011;
        L_0x000c:
            r0 = r9.f637c;
            r0.cancel();
        L_0x0011:
            r0 = android.support.v4.view.ViewCompat.m1242f(r9);
            r1 = 1;
            if (r0 != r1) goto L_0x001a;
        L_0x0018:
            r0 = r1;
            goto L_0x001b;
        L_0x001a:
            r0 = 0;
        L_0x001b:
            r2 = r9.getChildAt(r10);
            if (r2 != 0) goto L_0x0025;
        L_0x0021:
            r9.m299a();
            return;
        L_0x0025:
            r6 = r2.getLeft();
            r8 = r2.getRight();
            r2 = r9.f635a;
            r2 = r10 - r2;
            r2 = java.lang.Math.abs(r2);
            if (r2 > r1) goto L_0x003e;
        L_0x0037:
            r0 = r9.f642h;
            r1 = r9.f643i;
            r5 = r0;
            r7 = r1;
            goto L_0x0058;
        L_0x003e:
            r1 = r9.f638d;
            r2 = 24;
            r1 = r1.m332b(r2);
            r2 = r9.f635a;
            if (r10 >= r2) goto L_0x0050;
        L_0x004a:
            if (r0 != 0) goto L_0x0054;
        L_0x004c:
            r1 = r1 + r8;
        L_0x004d:
            r5 = r1;
        L_0x004e:
            r7 = r5;
            goto L_0x0058;
        L_0x0050:
            if (r0 == 0) goto L_0x0054;
        L_0x0052:
            r1 = r1 + r8;
            goto L_0x004d;
        L_0x0054:
            r0 = r6 - r1;
            r5 = r0;
            goto L_0x004e;
        L_0x0058:
            if (r5 != r6) goto L_0x005c;
        L_0x005a:
            if (r7 == r8) goto L_0x008a;
        L_0x005c:
            r0 = new android.animation.ValueAnimator;
            r0.<init>();
            r9.f637c = r0;
            r1 = android.support.design.widget.AnimationUtils.f407b;
            r0.setInterpolator(r1);
            r1 = (long) r11;
            r0.setDuration(r1);
            r11 = 2;
            r11 = new float[r11];
            r11 = {0, 1065353216};
            r0.setFloatValues(r11);
            r11 = new android.support.design.widget.TabLayout$SlidingTabStrip$1;
            r3 = r11;
            r4 = r9;
            r3.<init>(r4, r5, r6, r7, r8);
            r0.addUpdateListener(r11);
            r11 = new android.support.design.widget.TabLayout$SlidingTabStrip$2;
            r11.<init>(r9, r10);
            r0.addListener(r11);
            r0.start();
        L_0x008a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TabLayout.SlidingTabStrip.b(int, int):void");
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f642h >= 0 && this.f643i > this.f642h) {
                canvas.drawRect((float) this.f642h, (float) (getHeight() - this.f639e), (float) this.f643i, (float) getHeight(), this.f640f);
            }
        }
    }

    public static final class Tab {
        Object f644a;
        Drawable f645b;
        CharSequence f646c;
        CharSequence f647d;
        public int f648e = -1;
        View f649f;
        TabLayout f650g;
        TabView f651h;

        Tab() {
        }

        public final Tab m304a(View view) {
            this.f649f = view;
            m307b();
            return this;
        }

        public final Tab m305a(CharSequence charSequence) {
            this.f646c = charSequence;
            m307b();
            return this;
        }

        public final void m306a() {
            if (this.f650g == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f650g.m328a(this);
        }

        final void m307b() {
            if (this.f651h != null) {
                this.f651h.m309a();
            }
        }
    }

    class TabView extends LinearLayout {
        final /* synthetic */ TabLayout f652a;
        private Tab f653b;
        private TextView f654c;
        private ImageView f655d;
        private View f656e;
        private TextView f657f;
        private ImageView f658g;
        private int f659h = 2;

        public TabView(TabLayout tabLayout, Context context) {
            this.f652a = tabLayout;
            super(context);
            if (tabLayout.f674i != 0) {
                ViewCompat.m1219a((View) this, AppCompatResources.m1570b(context, tabLayout.f674i));
            }
            ViewCompat.m1215a(this, tabLayout.f666a, tabLayout.f667b, tabLayout.f668c, tabLayout.f669d);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.m1222a((View) this, PointerIconCompat.m1147a(getContext()));
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f653b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f653b.m306a();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f654c != null) {
                this.f654c.setSelected(z);
            }
            if (this.f655d != null) {
                this.f655d.setSelected(z);
            }
            if (this.f656e != null) {
                this.f656e.setSelected(z);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.Tab.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int tabMaxWidth = this.f652a.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = MeasureSpec.makeMeasureSpec(this.f652a.f675j, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f654c != null) {
                getResources();
                float f = this.f652a.f672g;
                mode = this.f659h;
                int i3 = 1;
                if (this.f655d != null && this.f655d.getVisibility() == 0) {
                    mode = 1;
                } else if (this.f654c != null && this.f654c.getLineCount() > 1) {
                    f = this.f652a.f673h;
                }
                float textSize = this.f654c.getTextSize();
                int lineCount = this.f654c.getLineCount();
                int a = TextViewCompat.m1428a(this.f654c);
                tabMaxWidth = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                if (tabMaxWidth != 0 || (a >= 0 && mode != a)) {
                    if (this.f652a.f677l == 1 && tabMaxWidth > 0 && lineCount == 1) {
                        Layout layout = this.f654c.getLayout();
                        if (layout == null || layout.getLineWidth(0) * (f / layout.getPaint().getTextSize()) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.f654c.setTextSize(0, f);
                        this.f654c.setMaxLines(mode);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        final void m310a(Tab tab) {
            if (tab != this.f653b) {
                this.f653b = tab;
                m309a();
            }
        }

        final void m309a() {
            View view;
            Tab tab = this.f653b;
            if (tab != null) {
                view = tab.f649f;
            } else {
                view = null;
            }
            if (view != null) {
                TabView parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(view);
                    }
                    addView(view);
                }
                this.f656e = view;
                if (this.f654c != null) {
                    this.f654c.setVisibility(8);
                }
                if (this.f655d != null) {
                    this.f655d.setVisibility(8);
                    this.f655d.setImageDrawable(null);
                }
                this.f657f = (TextView) view.findViewById(16908308);
                if (this.f657f != null) {
                    this.f659h = TextViewCompat.m1428a(this.f657f);
                }
                this.f658g = (ImageView) view.findViewById(16908294);
            } else {
                if (this.f656e != null) {
                    removeView(this.f656e);
                    this.f656e = null;
                }
                this.f657f = null;
                this.f658g = null;
            }
            if (this.f656e == null) {
                if (this.f655d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C0016R.layout.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.f655d = imageView;
                }
                if (this.f654c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0016R.layout.design_layout_tab_text, this, false);
                    addView(textView);
                    this.f654c = textView;
                    this.f659h = TextViewCompat.m1428a(this.f654c);
                }
                TextViewCompat.m1429a(this.f654c, this.f652a.f670e);
                if (this.f652a.f671f != null) {
                    this.f654c.setTextColor(this.f652a.f671f);
                }
                m308a(this.f654c, this.f655d);
            } else if (!(this.f657f == null && this.f658g == null)) {
                m308a(this.f657f, this.f658g);
            }
            boolean z = true;
            if (tab != null) {
                if (tab.f650g == null) {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                if (tab.f650g.getSelectedTabPosition() == tab.f648e) {
                    setSelected(z);
                }
            }
            z = false;
            setSelected(z);
        }

        private void m308a(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            CharSequence charSequence3 = null;
            if (this.f653b != null) {
                drawable = this.f653b.f645b;
            } else {
                drawable = null;
            }
            if (this.f653b != null) {
                charSequence = this.f653b.f646c;
            } else {
                charSequence = null;
            }
            if (this.f653b != null) {
                charSequence2 = this.f653b.f647d;
            } else {
                charSequence2 = null;
            }
            int i = 0;
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            int isEmpty = TextUtils.isEmpty(charSequence) ^ 1;
            if (textView != null) {
                if (isEmpty != 0) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (isEmpty != 0 && imageView.getVisibility() == 0) {
                    i = this.f652a.m332b(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            if (isEmpty == 0) {
                charSequence3 = charSequence2;
            }
            TooltipCompat.m2349a(this, charSequence3);
        }
    }

    private class AdapterChangeListener implements OnAdapterChangeListener {
        boolean f11129a;
        final /* synthetic */ TabLayout f11130b;

        AdapterChangeListener(TabLayout tabLayout) {
            this.f11130b = tabLayout;
        }

        public final void mo117a(ViewPager viewPager, PagerAdapter pagerAdapter) {
            if (this.f11130b.f678m == viewPager) {
                this.f11130b.m330a(pagerAdapter, this.f11129a);
            }
        }
    }

    public static class TabLayoutOnPageChangeListener implements OnPageChangeListener {
        int f11131a;
        int f11132b;
        private final WeakReference<TabLayout> f11133c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f11133c = new WeakReference(tabLayout);
        }

        public final void mo118a(int i) {
            this.f11131a = this.f11132b;
            this.f11132b = i;
        }

        public final void mo119a(int i, float f) {
            TabLayout tabLayout = (TabLayout) this.f11133c.get();
            if (tabLayout != null) {
                boolean z;
                boolean z2 = false;
                if (this.f11132b == 2) {
                    if (this.f11131a != 1) {
                        z = false;
                        if (!(this.f11132b == 2 && this.f11131a == 0)) {
                            z2 = true;
                        }
                        tabLayout.m325a(i, f, z, z2);
                    }
                }
                z = true;
                z2 = true;
                tabLayout.m325a(i, f, z, z2);
            }
        }

        public final void mo120b(int i) {
            TabLayout tabLayout = (TabLayout) this.f11133c.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z;
                if (this.f11132b != 0) {
                    if (this.f11132b != 2 || this.f11131a != 0) {
                        z = false;
                        tabLayout.m329a(tabLayout.m323a(i), z);
                    }
                }
                z = true;
                tabLayout.m329a(tabLayout.m323a(i), z);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager f11134a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f11134a = viewPager;
        }

        public final void mo121a(Tab tab) {
            this.f11134a.setCurrentItem(tab.f648e);
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f679o = new ArrayList();
        this.f675j = RedditJobManager.f10810d;
        this.f687w = new ArrayList();
        this.f665E = new SimplePool(12);
        ThemeUtils.m333a(context);
        setHorizontalScrollBarEnabled(false);
        this.f681q = new SlidingTabStrip(this, context);
        super.addView(this.f681q, 0, new FrameLayout.LayoutParams(-2, -1));
        attributeSet = context.obtainStyledAttributes(attributeSet, C0016R.styleable.TabLayout, i, C0016R.style.Widget_Design_TabLayout);
        this.f681q.m302b(attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabIndicatorHeight, 0));
        this.f681q.m300a(attributeSet.getColor(C0016R.styleable.TabLayout_tabIndicatorColor, 0));
        i = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabPadding, 0);
        this.f669d = i;
        this.f668c = i;
        this.f667b = i;
        this.f666a = i;
        this.f666a = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabPaddingStart, this.f666a);
        this.f667b = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabPaddingTop, this.f667b);
        this.f668c = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabPaddingEnd, this.f668c);
        this.f669d = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabPaddingBottom, this.f669d);
        this.f670e = attributeSet.getResourceId(C0016R.styleable.TabLayout_tabTextAppearance, C0016R.style.TextAppearance_Design_Tab);
        context = context.obtainStyledAttributes(this.f670e, C0164R.styleable.TextAppearance);
        try {
            this.f672g = (float) context.getDimensionPixelSize(C0164R.styleable.TextAppearance_android_textSize, 0);
            this.f671f = context.getColorStateList(C0164R.styleable.TextAppearance_android_textColor);
            if (attributeSet.hasValue(C0016R.styleable.TabLayout_tabTextColor) != null) {
                this.f671f = attributeSet.getColorStateList(C0016R.styleable.TabLayout_tabTextColor);
            }
            if (attributeSet.hasValue(C0016R.styleable.TabLayout_tabSelectedTextColor) != null) {
                this.f671f = m316b(this.f671f.getDefaultColor(), attributeSet.getColor(C0016R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.f682r = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabMinWidth, -1);
            this.f683s = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabMaxWidth, -1);
            this.f674i = attributeSet.getResourceId(C0016R.styleable.TabLayout_tabBackground, 0);
            this.f685u = attributeSet.getDimensionPixelSize(C0016R.styleable.TabLayout_tabContentStart, 0);
            this.f677l = attributeSet.getInt(C0016R.styleable.TabLayout_tabMode, 1);
            this.f676k = attributeSet.getInt(C0016R.styleable.TabLayout_tabGravity, 0);
            attributeSet.recycle();
            context = getResources();
            this.f673h = (float) context.getDimensionPixelSize(C0016R.dimen.design_tab_text_size_2line);
            this.f684t = context.getDimensionPixelSize(C0016R.dimen.design_tab_scrollable_min_width);
            m322d();
        } finally {
            context.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f681q.m300a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f681q.m302b(i);
    }

    private void setScrollPosition$4867b5c2(int i) {
        m325a(i, 0.0f, true, true);
    }

    final void m325a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0) {
            if (round < this.f681q.getChildCount()) {
                if (z2) {
                    z2 = this.f681q;
                    if (z2.f637c != null && z2.f637c.isRunning()) {
                        z2.f637c.cancel();
                    }
                    z2.f635a = i;
                    z2.f636b = f;
                    z2.m299a();
                }
                if (this.f689y && this.f689y.isRunning()) {
                    this.f689y.cancel();
                }
                scrollTo(m311a(i, f), 0.0f);
                if (z) {
                    setSelectedTabView(round);
                }
            }
        }
    }

    private float getScrollPosition() {
        SlidingTabStrip slidingTabStrip = this.f681q;
        return ((float) slidingTabStrip.f635a) + slidingTabStrip.f636b;
    }

    private void m319b(Tab tab, boolean z) {
        int size = this.f679o.size();
        if (tab.f650g != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m312a(tab, size);
        View view = tab.f651h;
        SlidingTabStrip slidingTabStrip = this.f681q;
        int i = tab.f648e;
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m315a(layoutParams);
        slidingTabStrip.addView(view, i, layoutParams);
        if (z) {
            tab.m306a();
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (this.f686v != null) {
            m318b(this.f686v);
        }
        this.f686v = onTabSelectedListener;
        if (onTabSelectedListener != null) {
            m327a(onTabSelectedListener);
        }
    }

    public final void m327a(OnTabSelectedListener onTabSelectedListener) {
        if (!this.f687w.contains(onTabSelectedListener)) {
            this.f687w.add(onTabSelectedListener);
        }
    }

    private void m318b(OnTabSelectedListener onTabSelectedListener) {
        this.f687w.remove(onTabSelectedListener);
    }

    private Tab m317b() {
        Tab tab = (Tab) f660n.mo362a();
        if (tab == null) {
            tab = new Tab();
        }
        tab.f650g = this;
        TabView tabView = this.f665E != null ? (TabView) this.f665E.mo362a() : null;
        if (tabView == null) {
            tabView = new TabView(this, getContext());
        }
        tabView.m310a(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        tab.f651h = tabView;
        return tab;
    }

    public int getTabCount() {
        return this.f679o.size();
    }

    public final Tab m323a(int i) {
        if (i >= 0) {
            if (i < getTabCount()) {
                return (Tab) this.f679o.get(i);
            }
        }
        return 0;
    }

    public int getSelectedTabPosition() {
        return this.f680p != null ? this.f680p.f648e : -1;
    }

    public void setTabMode(int i) {
        if (i != this.f677l) {
            this.f677l = i;
            m322d();
        }
    }

    public int getTabMode() {
        return this.f677l;
    }

    public void setTabGravity(int i) {
        if (this.f676k != i) {
            this.f676k = i;
            m322d();
        }
    }

    public int getTabGravity() {
        return this.f676k;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f671f != colorStateList) {
            this.f671f = colorStateList;
            int size = this.f679o.size();
            for (colorStateList = null; colorStateList < size; colorStateList++) {
                ((Tab) this.f679o.get(colorStateList)).m307b();
            }
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f671f;
    }

    public final void m326a(int i, int i2) {
        setTabTextColors(m316b(i, i2));
    }

    private void m313a(ViewPager viewPager, boolean z) {
        if (this.f678m != null) {
            if (this.f662B != null) {
                this.f678m.removeOnPageChangeListener(this.f662B);
            }
            if (this.f663C != null) {
                this.f678m.removeOnAdapterChangeListener(this.f663C);
            }
        }
        if (this.f688x != null) {
            m318b(this.f688x);
            this.f688x = null;
        }
        if (viewPager != null) {
            this.f678m = viewPager;
            if (this.f662B == null) {
                this.f662B = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.f662B;
            tabLayoutOnPageChangeListener.f11132b = 0;
            tabLayoutOnPageChangeListener.f11131a = 0;
            viewPager.addOnPageChangeListener(this.f662B);
            this.f688x = new ViewPagerOnTabSelectedListener(viewPager);
            m327a(this.f688x);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                m330a(adapter, true);
            }
            if (this.f663C == null) {
                this.f663C = new AdapterChangeListener(this);
            }
            this.f663C.f11129a = true;
            viewPager.addOnAdapterChangeListener(this.f663C);
            setScrollPosition$4867b5c2(viewPager.getCurrentItem());
        } else {
            this.f678m = null;
            m330a(null, false);
        }
        this.f664D = z;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        m330a(pagerAdapter, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f678m == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m313a((ViewPager) parent, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f664D) {
            setupWithViewPager(null);
            this.f664D = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f681q.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    final void m330a(PagerAdapter pagerAdapter, boolean z) {
        if (!(this.f690z == null || this.f661A == null)) {
            PagerAdapter pagerAdapter2 = this.f690z;
            pagerAdapter2.f1449a.unregisterObserver(this.f661A);
        }
        this.f690z = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (!this.f661A) {
                this.f661A = new PagerAdapterObserver(this);
            }
            pagerAdapter.f1449a.registerObserver(this.f661A);
        }
        m324a();
    }

    public void addView(View view) {
        m314a(view);
    }

    public void addView(View view, int i) {
        m314a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m314a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m314a(view);
    }

    private void m314a(View view) {
        if (view instanceof TabItem) {
            TabItem tabItem = (TabItem) view;
            Tab b = m317b();
            if (tabItem.f623a != null) {
                b.m305a(tabItem.f623a);
            }
            if (tabItem.f624b != null) {
                b.f645b = tabItem.f624b;
                b.m307b();
            }
            if (tabItem.f625c != 0) {
                b.m304a(LayoutInflater.from(b.f651h.getContext()).inflate(tabItem.f625c, b.f651h, false));
            }
            if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
                b.f647d = tabItem.getContentDescription();
                b.m307b();
            }
            m319b(b, this.f679o.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void m315a(LayoutParams layoutParams) {
        if (this.f677l == 1 && this.f676k == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    final int m332b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r6, int r7) {
        /*
        r5 = this;
        r0 = r5.getDefaultHeight();
        r0 = r5.m332b(r0);
        r1 = r5.getPaddingTop();
        r0 = r0 + r1;
        r1 = r5.getPaddingBottom();
        r0 = r0 + r1;
        r1 = android.view.View.MeasureSpec.getMode(r7);
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r1 == r2) goto L_0x0024;
    L_0x001c:
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0030;
    L_0x001f:
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3);
        goto L_0x0030;
    L_0x0024:
        r7 = android.view.View.MeasureSpec.getSize(r7);
        r7 = java.lang.Math.min(r0, r7);
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3);
    L_0x0030:
        r0 = android.view.View.MeasureSpec.getSize(r6);
        r1 = android.view.View.MeasureSpec.getMode(r6);
        if (r1 == 0) goto L_0x004a;
    L_0x003a:
        r1 = r5.f683s;
        if (r1 <= 0) goto L_0x0041;
    L_0x003e:
        r0 = r5.f683s;
        goto L_0x0048;
    L_0x0041:
        r1 = 56;
        r1 = r5.m332b(r1);
        r0 = r0 - r1;
    L_0x0048:
        r5.f675j = r0;
    L_0x004a:
        super.onMeasure(r6, r7);
        r6 = r5.getChildCount();
        r0 = 1;
        if (r6 != r0) goto L_0x0096;
    L_0x0054:
        r6 = 0;
        r1 = r5.getChildAt(r6);
        r2 = r5.f677l;
        switch(r2) {
            case 0: goto L_0x006b;
            case 1: goto L_0x005f;
            default: goto L_0x005e;
        };
    L_0x005e:
        goto L_0x0076;
    L_0x005f:
        r2 = r1.getMeasuredWidth();
        r4 = r5.getMeasuredWidth();
        if (r2 == r4) goto L_0x0076;
    L_0x0069:
        r6 = r0;
        goto L_0x0076;
    L_0x006b:
        r2 = r1.getMeasuredWidth();
        r4 = r5.getMeasuredWidth();
        if (r2 >= r4) goto L_0x0076;
    L_0x0075:
        goto L_0x0069;
    L_0x0076:
        if (r6 == 0) goto L_0x0096;
    L_0x0078:
        r6 = r5.getPaddingTop();
        r0 = r5.getPaddingBottom();
        r6 = r6 + r0;
        r0 = r1.getLayoutParams();
        r0 = r0.height;
        r6 = getChildMeasureSpec(r7, r6, r0);
        r7 = r5.getMeasuredWidth();
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3);
        r1.measure(r7, r6);
    L_0x0096:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TabLayout.onMeasure(int, int):void");
    }

    private void m321c(int i) {
        if (i != -1) {
            if (getWindowToken() != null && ViewCompat.m1206G(this)) {
                int i2;
                SlidingTabStrip slidingTabStrip = this.f681q;
                int childCount = slidingTabStrip.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (slidingTabStrip.getChildAt(i3).getWidth() <= 0) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    if (getScrollX() != m311a(i, 0.0f)) {
                        m320c();
                        this.f689y.setIntValues(new int[]{i2, childCount});
                        this.f689y.start();
                    }
                    this.f681q.m303b(i, 300);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i);
        }
    }

    private void m320c() {
        if (this.f689y == null) {
            this.f689y = new ValueAnimator();
            this.f689y.setInterpolator(AnimationUtils.f407b);
            this.f689y.setDuration(300);
            this.f689y.addUpdateListener(new C00391(this));
        }
    }

    void setScrollAnimatorListener(AnimatorListener animatorListener) {
        m320c();
        this.f689y.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f681q.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f681q.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    final void m328a(Tab tab) {
        m329a(tab, true);
    }

    final void m329a(Tab tab, boolean z) {
        Tab tab2 = this.f680p;
        if (tab2 != tab) {
            int i;
            if (tab != null) {
                i = tab.f648e;
            } else {
                i = -1;
            }
            if (z) {
                if ((tab2 == null || tab2.f648e) && i != -1) {
                    setScrollPosition$4867b5c2(i);
                } else {
                    m321c(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
            }
            if (tab2 != null) {
                for (z = this.f687w.size() - 1; z < false; z--) {
                    this.f687w.get(z);
                }
            }
            this.f680p = tab;
            if (tab != null) {
                for (z = this.f687w.size() - 1; z < false; z--) {
                    ((OnTabSelectedListener) this.f687w.get(z)).mo121a(tab);
                }
            }
        } else if (tab2 != null) {
            for (z = this.f687w.size() - 1; z < false; z--) {
                this.f687w.get(z);
            }
            m321c(tab.f648e);
        }
    }

    private int m311a(int i, float f) {
        int i2 = 0;
        if (this.f677l != 0) {
            return 0;
        }
        View childAt = this.f681q.getChildAt(i);
        i++;
        i = i < this.f681q.getChildCount() ? this.f681q.getChildAt(i) : 0;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (i != 0) {
            i2 = i.getWidth();
        }
        i = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        f = (int) ((((float) (width + i2)) * 0.5f) * f);
        return ViewCompat.m1242f(this) == 0 ? i + f : i - f;
    }

    private void m322d() {
        ViewCompat.m1215a(this.f681q, this.f677l == 0 ? Math.max(0, this.f685u - this.f666a) : 0, 0, 0, 0);
        switch (this.f677l) {
            case 0:
                this.f681q.setGravity(8388611);
                break;
            case 1:
                this.f681q.setGravity(1);
                break;
            default:
                break;
        }
        m331a(true);
    }

    final void m331a(boolean z) {
        for (int i = 0; i < this.f681q.getChildCount(); i++) {
            View childAt = this.f681q.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m315a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList m316b(int i, int i2) {
        r1 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r1[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r1, iArr);
    }

    private int getDefaultHeight() {
        int size = this.f679o.size();
        Object obj = null;
        for (int i = 0; i < size; i++) {
            Tab tab = (Tab) this.f679o.get(i);
            if (tab != null && tab.f645b != null && !TextUtils.isEmpty(tab.f646c)) {
                obj = 1;
                break;
            }
        }
        return obj != null ? 72 : 48;
    }

    private int getTabMinWidth() {
        if (this.f682r != -1) {
            return this.f682r;
        }
        return this.f677l == 0 ? this.f684t : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.f675j;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m313a(viewPager, false);
    }

    final void m324a() {
        int childCount;
        for (childCount = this.f681q.getChildCount() - 1; childCount >= 0; childCount--) {
            TabView tabView = (TabView) this.f681q.getChildAt(childCount);
            this.f681q.removeViewAt(childCount);
            if (tabView != null) {
                tabView.m310a(null);
                tabView.setSelected(false);
                this.f665E.mo363a(tabView);
            }
            requestLayout();
        }
        Iterator it = this.f679o.iterator();
        while (it.hasNext()) {
            Tab tab = (Tab) it.next();
            it.remove();
            tab.f650g = null;
            tab.f651h = null;
            tab.f644a = null;
            tab.f645b = null;
            tab.f646c = null;
            tab.f647d = null;
            tab.f648e = -1;
            tab.f649f = null;
            f660n.mo363a(tab);
        }
        this.f680p = null;
        if (this.f690z != null) {
            childCount = this.f690z.mo3684c();
            for (int i = 0; i < childCount; i++) {
                m319b(m317b().m305a(this.f690z.m1144b(i)), false);
            }
            if (this.f678m != null && childCount > 0) {
                childCount = this.f678m.getCurrentItem();
                if (childCount != getSelectedTabPosition() && childCount < getTabCount()) {
                    m329a(m323a(childCount), true);
                }
            }
        }
    }

    private void m312a(Tab tab, int i) {
        tab.f648e = i;
        this.f679o.add(i, tab);
        tab = this.f679o.size();
        while (true) {
            i++;
            if (i < tab) {
                ((Tab) this.f679o.get(i)).f648e = i;
            } else {
                return;
            }
        }
    }
}
