package com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Icon;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Text;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.anko.CustomViewPropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001GB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u000208H\u0002J\u0010\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0018\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u0007H\u0002JH\u0010B\u001a\u0002082\u0006\u0010$\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\"\b\u0002\u0010(\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0018\u00010'J\b\u0010C\u001a\u000208H\u0002J\u0014\u0010D\u001a\u00020\u0016*\u00020E2\u0006\u0010F\u001a\u00020\u0007H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070 j\u0002`!0\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000RX\u0010(\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0018\u00010'2 \u0010&\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0016\u0018\u00010'@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0017\u00101\u001a\b\u0012\u0004\u0012\u0002020\n¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000fR\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000f¨\u0006H"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomIconIndicatorViews", "", "Landroid/widget/ImageView;", "bottomIconItemIndicators", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Icon;", "getBottomIconItemIndicators", "()Ljava/util/List;", "color", "Landroid/content/res/ColorStateList;", "getItemIndicator", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "isSetup", "", "()Z", "isUpdateItemIndicatorsPosted", "itemIndicatorSelectedCallbacks", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollView$ItemIndicatorSelectedCallback;", "getItemIndicatorSelectedCallbacks", "itemIndicators", "", "getItemIndicators", "itemIndicatorsWithPositions", "Lkotlin/Pair;", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/ItemIndicatorWithPosition;", "lastScrolledPosition", "Ljava/lang/Integer;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "value", "Lkotlin/Function3;", "showIndicator", "getShowIndicator", "()Lkotlin/jvm/functions/Function3;", "setShowIndicator", "(Lkotlin/jvm/functions/Function3;)V", "smoothScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "textIndicatorsView", "Landroid/widget/TextView;", "textItemIndicators", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator$Text;", "getTextItemIndicators", "topIconIndicatorViews", "topIconItemIndicators", "getTopIconItemIndicators", "bindItemIndicatorViews", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postUpdateItemIndicators", "scrollToPosition", "position", "selectItemIndicator", "indicator", "indicatorCenterY", "setupWithRecyclerView", "updateItemIndicators", "containsY", "Landroid/view/View;", "y", "ItemIndicatorSelectedCallback", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FastScrollView.kt */
public final class FastScrollView extends LinearLayout {
    private final List<ItemIndicatorSelectedCallback> f20423a;
    private final TextView f20424b;
    private final List<ImageView> f20425c;
    private final List<ImageView> f20426d;
    private final ColorStateList f20427e;
    private RecyclerView f20428f;
    private Function1<? super Integer, ? extends FastScrollItemIndicator> f20429g;
    private Function3<? super FastScrollItemIndicator, ? super Integer, ? super Integer, Boolean> f20430h;
    private Integer f20431i;
    private boolean f20432j;
    private final List<Pair<FastScrollItemIndicator, Integer>> f20433k;
    private final List<Text> f20434l;
    private final List<Icon> f20435m;
    private final List<Icon> f20436n;
    private SmoothScroller f20437o;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollView$ItemIndicatorSelectedCallback;", "", "onItemIndicatorSelected", "", "indicator", "Lcom/reddit/frontpage/presentation/common/ui/view/recyclerfastscroll/FastScrollItemIndicator;", "indicatorCenterY", "", "itemPosition", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: FastScrollView.kt */
    public interface ItemIndicatorSelectedCallback {
        void mo4795a(FastScrollItemIndicator fastScrollItemIndicator, int i);
    }

    public FastScrollView(Context context) {
        this(context, null, 0, 6, null);
    }

    public FastScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FastScrollView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public FastScrollView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20423a = new ArrayList();
        this.f20425c = new ArrayList();
        this.f20426d = new ArrayList();
        r2 = new int[2][];
        r2[0] = new int[]{16842919};
        r2[1] = new int[]{-16842919};
        this.f20427e = new ColorStateList(r2, new int[]{ResourcesUtil.m22740i(context, C1761R.attr.rdt_active_color), ResourcesUtil.m22740i(context, C1761R.attr.rdt_subheader_text_color)});
        this.f20433k = new ArrayList();
        this.f20434l = new ArrayList();
        this.f20435m = new ArrayList();
        this.f20436n = new ArrayList();
        attributeSet = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.FastScrollView, i, 0);
        int resourceId = attributeSet.getResourceId(0, ContextsKt.m24077b(context, 16842804));
        attributeSet.recycle();
        setFocusableInTouchMode(true);
        setClickable(true);
        setOrientation(1);
        setGravity(16);
        ViewGroupsKt.m24100a(this, C1761R.layout.fast_scroll_view, true);
        Object findViewById = findViewById(C1761R.id.fast_scroll_text);
        Intrinsics.m26843a(findViewById, "findViewById(R.id.fast_scroll_text)");
        this.f20424b = (TextView) findViewById;
        CustomViewPropertiesKt.m28404a(this.f20424b, resourceId);
        this.f20424b.setTextColor(this.f20427e);
        if (isInEditMode() != null) {
            CollectionsKt__MutableCollectionsKt.m38194a((Collection) this.f20433k, (Iterable) CollectionsKt__CollectionsKt.m26796b((Object[]) new Pair[]{new Pair(new Text("A"), Integer.valueOf(0)), new Pair(new Text("B"), Integer.valueOf(1)), new Pair(new Text("C"), Integer.valueOf(2)), new Pair(new Text("D"), Integer.valueOf(3)), new Pair(new Text("E"), Integer.valueOf(4))}));
            Collection collection = (Collection) this.f20434l;
            Collection collection2 = (Collection) new ArrayList();
            for (Object next : getItemIndicators()) {
                if (next instanceof Text) {
                    collection2.add(next);
                }
            }
            CollectionsKt__MutableCollectionsKt.m38194a(collection, (Iterable) (List) collection2);
            m22780c();
        }
    }

    public final List<ItemIndicatorSelectedCallback> getItemIndicatorSelectedCallbacks() {
        return this.f20423a;
    }

    public final Function3<FastScrollItemIndicator, Integer, Integer, Boolean> getShowIndicator() {
        return this.f20430h;
    }

    public final void setShowIndicator(Function3<? super FastScrollItemIndicator, ? super Integer, ? super Integer, Boolean> function3) {
        this.f20430h = function3;
        m22773a();
    }

    public final List<FastScrollItemIndicator> getItemIndicators() {
        Iterable<Pair> iterable = this.f20433k;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Pair pair : iterable) {
            arrayList.add(pair.f25267a);
        }
        return (List) arrayList;
    }

    public final List<Text> getTextItemIndicators() {
        return this.f20434l;
    }

    public final List<Icon> getTopIconItemIndicators() {
        return this.f20435m;
    }

    public final List<Icon> getBottomIconItemIndicators() {
        return this.f20436n;
    }

    public static /* synthetic */ void m22776a(FastScrollView fastScrollView, RecyclerView recyclerView, Function1 function1) {
        Intrinsics.m26847b(recyclerView, "recyclerView");
        Intrinsics.m26847b(function1, "getItemIndicator");
        if ((fastScrollView.f20428f != null ? 1 : null) != null) {
            throw ((Throwable) new IllegalStateException("Only set this view's RecyclerView once!"));
        }
        fastScrollView.f20428f = recyclerView;
        fastScrollView.f20429g = function1;
        fastScrollView.setShowIndicator(null);
        fastScrollView.m22779b();
        recyclerView.getAdapter().a((AdapterDataObserver) new FastScrollView$setupWithRecyclerView$1(fastScrollView));
        fastScrollView.f20437o = (SmoothScroller) new FastScrollView$setupWithRecyclerView$2(fastScrollView, fastScrollView.getContext());
    }

    private final void m22773a() {
        if (!this.f20432j) {
            this.f20432j = true;
            post(new FastScrollView$postUpdateItemIndicators$1(this));
        }
    }

    private final void m22779b() {
        this.f20433k.clear();
        RecyclerView recyclerView = this.f20428f;
        if (recyclerView == null) {
            Intrinsics.m26842a();
        }
        Object adapter = recyclerView.getAdapter();
        Intrinsics.m26843a(adapter, "recyclerView!!.adapter");
        int i = 0;
        Collection arrayList = new ArrayList();
        Iterator it = RangesKt___RangesKt.m32854b(0, adapter.a()).iterator();
        while (it.hasNext()) {
            int a = ((IntIterator) it).mo6663a();
            Function1 function1 = this.f20429g;
            if (function1 == null) {
                Intrinsics.m26844a("getItemIndicator");
            }
            FastScrollItemIndicator fastScrollItemIndicator = (FastScrollItemIndicator) function1.mo6492a(Integer.valueOf(a));
            Object pair = fastScrollItemIndicator != null ? new Pair(fastScrollItemIndicator, Integer.valueOf(a)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterable iterable = (List) arrayList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : iterable) {
            if (hashSet.add(((Pair) next).f25267a)) {
                arrayList2.add(next);
            }
        }
        List list = arrayList2;
        Function3 function3 = this.f20430h;
        if (function3 != null) {
            Collection arrayList3 = new ArrayList();
            for (Object pair2 : list) {
                int i2 = i + 1;
                if (((Boolean) function3.mo6509a((FastScrollItemIndicator) ((Pair) pair2).f25267a, Integer.valueOf(i), Integer.valueOf(list.size()))).booleanValue()) {
                    arrayList3.add(pair2);
                }
                i = i2;
            }
            list = (List) arrayList3;
        }
        CollectionsKt___CollectionsKt.m41421b((Iterable) list, (Collection) this.f20433k);
        this.f20434l.clear();
        Collection arrayList4 = new ArrayList();
        for (Object next2 : getItemIndicators()) {
            if (next2 instanceof Text) {
                arrayList4.add(next2);
            }
        }
        CollectionsKt___CollectionsKt.m41421b((Iterable) (List) arrayList4, (Collection) this.f20434l);
        this.f20435m.clear();
        Iterable itemIndicators = getItemIndicators();
        ArrayList arrayList5 = new ArrayList();
        for (Object next22 : itemIndicators) {
            if (!(((FastScrollItemIndicator) next22) instanceof Icon)) {
                break;
            }
            arrayList5.add(next22);
        }
        Iterable<FastScrollItemIndicator> iterable2 = arrayList5;
        Collection arrayList6 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
        for (FastScrollItemIndicator fastScrollItemIndicator2 : iterable2) {
            if (fastScrollItemIndicator2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Icon");
            }
            arrayList6.add((Icon) fastScrollItemIndicator2);
        }
        CollectionsKt___CollectionsKt.m41421b((Iterable) (List) arrayList6, (Collection) this.f20435m);
        this.f20436n.clear();
        Iterable<FastScrollItemIndicator> subList = getItemIndicators().subList(this.f20435m.size() + this.f20434l.size(), getItemIndicators().size());
        arrayList4 = new ArrayList(CollectionsKt__IterablesKt.m32812b(subList));
        for (FastScrollItemIndicator fastScrollItemIndicator22 : subList) {
            if (fastScrollItemIndicator22 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollItemIndicator.Icon");
            }
            arrayList4.add((Icon) fastScrollItemIndicator22);
        }
        CollectionsKt___CollectionsKt.m41421b((Iterable) (List) arrayList4, (Collection) this.f20436n);
        m22780c();
    }

    private final void m22780c() {
        this.f20424b.setText(CollectionsKt___CollectionsKt.m41412a((Iterable) this.f20434l, (CharSequence) "\n", null, null, 0, null, (Function1) FastScrollView$bindItemIndicatorViews$1.f36403a, 30));
        ViewsKt.m24103a((View) this.f20424b, this.f20434l.isEmpty() ^ 1);
        FastScrollView$bindItemIndicatorViews$3 fastScrollView$bindItemIndicatorViews$3 = new FastScrollView$bindItemIndicatorViews$3(this);
        for (View removeView : this.f20425c) {
            removeView(removeView);
        }
        this.f20425c.clear();
        for (View removeView2 : this.f20426d) {
            removeView(removeView2);
        }
        this.f20426d.clear();
        Iterable<Icon> iterable = this.f20435m;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Icon a : iterable) {
            arrayList.add(fastScrollView$bindItemIndicatorViews$3.m36788a(a));
        }
        int i = 0;
        for (AppCompatImageView appCompatImageView : (List) arrayList) {
            int i2 = i + 1;
            addView(appCompatImageView, i);
            this.f20425c.add(appCompatImageView);
            i = i2;
        }
        iterable = this.f20436n;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Icon a2 : iterable) {
            arrayList.add(fastScrollView$bindItemIndicatorViews$3.m36788a(a2));
        }
        for (AppCompatImageView appCompatImageView2 : (List) arrayList) {
            addView(appCompatImageView2, getChildCount());
            this.f20426d.add(appCompatImageView2);
        }
    }

    private final void m22774a(FastScrollItemIndicator fastScrollItemIndicator, int i) {
        for (Pair pair : this.f20433k) {
            if (Intrinsics.m26845a((FastScrollItemIndicator) pair.f25267a, (Object) fastScrollItemIndicator)) {
                int intValue = ((Number) pair.f25268b).intValue();
                Integer num = this.f20431i;
                if (num != null) {
                    if (intValue == num.intValue()) {
                        return;
                    }
                }
                RecyclerView recyclerView = this.f20428f;
                if (recyclerView == null) {
                    Intrinsics.m26842a();
                }
                recyclerView.stopScroll();
                SmoothScroller smoothScroller = this.f20437o;
                if (smoothScroller == null) {
                    Intrinsics.m26844a("smoothScroller");
                }
                smoothScroller.d(intValue);
                LayoutManager layoutManager = recyclerView.getLayoutManager();
                smoothScroller = this.f20437o;
                if (smoothScroller == null) {
                    Intrinsics.m26844a("smoothScroller");
                }
                layoutManager.a(smoothScroller);
                this.f20431i = Integer.valueOf(intValue);
                performHapticFeedback(4);
                for (ItemIndicatorSelectedCallback a : this.f20423a) {
                    a.mo4795a(fastScrollItemIndicator, i);
                }
                return;
            }
        }
        throw ((Throwable) new NoSuchElementException("Collection contains no element matching the predicate."));
    }

    private static boolean m22777a(View view, int i) {
        int top = view.getTop();
        view = view.getBottom();
        if (top <= i) {
            if (view > i) {
                return true;
            }
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.m26847b(motionEvent, "event");
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            this.f20431i = null;
            return onTouchEvent;
        }
        int y = (int) motionEvent.getY();
        if (m22777a((View) this.f20424b, y)) {
            int measuredHeight = this.f20424b.getMeasuredHeight() / this.f20434l.size();
            int min = Math.min((y - this.f20424b.getTop()) / measuredHeight, CollectionsKt__CollectionsKt.m26787a(this.f20434l));
            m22774a((FastScrollItemIndicator) (Text) this.f20434l.get(min), (((int) this.f20424b.getY()) + (measuredHeight / 2)) + (min * measuredHeight));
            onTouchEvent = true;
        }
        for (Pair pair : CollectionsKt___CollectionsKt.m41423b((Collection) CollectionsKt___CollectionsKt.m41417a((Iterable) this.f20425c, (Iterable) this.f20435m), (Iterable) CollectionsKt___CollectionsKt.m41417a((Iterable) this.f20426d, (Iterable) this.f20436n))) {
            ImageView imageView = (ImageView) pair.f25267a;
            Icon icon = (Icon) pair.f25268b;
            if (m22777a((View) imageView, y)) {
                m22774a((FastScrollItemIndicator) icon, ((int) imageView.getY()) + (imageView.getMeasuredHeight() / 2));
                onTouchEvent = true;
                break;
            }
        }
        return onTouchEvent;
    }
}
