package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-J\u000e\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u000200J\u0014\u00101\u001a\u00020'2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403J\u0010\u00105\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u00106\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-J\u001a\u00107\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u00072\b\b\u0001\u00108\u001a\u00020\u0007J\u0018\u00109\u001a\u00020'2\u0006\u0010:\u001a\u0002002\b\b\u0001\u0010;\u001a\u00020\u0007J\u0012\u0010<\u001a\u00020'2\b\b\u0001\u0010=\u001a\u00020\u0007H\u0002J\u000e\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020@R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\u000eR\u001b\u0010\u001e\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010!\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b\"\u0010\u000e¨\u0006A"}, d2 = {"Lcom/reddit/frontpage/widgets/ListingFilterBarView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "geoIcon", "Landroid/widget/ImageView;", "getGeoIcon", "()Landroid/widget/ImageView;", "geoIcon$delegate", "Lkotlin/Lazy;", "geopopularSelection", "Landroid/view/View;", "getGeopopularSelection", "()Landroid/view/View;", "geopopularSelection$delegate", "geopopularSelectionText", "Landroid/widget/TextView;", "getGeopopularSelectionText", "()Landroid/widget/TextView;", "geopopularSelectionText$delegate", "modModeButton", "getModModeButton", "modModeButton$delegate", "sortView", "getSortView", "sortView$delegate", "viewMode", "getViewMode", "viewMode$delegate", "getGeopopularTextPosition", "Landroid/graphics/Point;", "initGeopopularVisibility", "", "sortType", "isGeopopularShown", "", "setGeopopularOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setGeopopularText", "text", "", "setHistorySort", "sort", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "setOnSortClickListener", "setOnViewModeClickListener", "setPostsSort", "sortTimeFrame", "setSort", "label", "icon", "setSortIcons", "iconResId", "setViewMode", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingFilterBarView.kt */
public final class ListingFilterBarView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f21917a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ListingFilterBarView.class), "sortView", "getSortView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ListingFilterBarView.class), "geoIcon", "getGeoIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ListingFilterBarView.class), "geopopularSelection", "getGeopopularSelection()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ListingFilterBarView.class), "geopopularSelectionText", "getGeopopularSelectionText()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ListingFilterBarView.class), "viewMode", "getViewMode()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ListingFilterBarView.class), "modModeButton", "getModModeButton()Landroid/widget/ImageView;"))};
    private final Lazy f21918b;
    private final Lazy f21919c;
    private final Lazy f21920d;
    private final Lazy f21921e;
    private final Lazy f21922f;
    private final Lazy f21923g;
    private HashMap f21924h;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21916a;

        static {
            int[] iArr = new int[ListingViewMode.values().length];
            f21916a = iArr;
            iArr[ListingViewMode.f20612a.ordinal()] = 1;
            f21916a[ListingViewMode.f20613b.ordinal()] = 2;
            f21916a[ListingViewMode.f20614c.ordinal()] = 3;
        }
    }

    public ListingFilterBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final ImageView getGeoIcon() {
        return (ImageView) this.f21919c.mo5678b();
    }

    private final TextView getGeopopularSelectionText() {
        return (TextView) this.f21921e.mo5678b();
    }

    private final TextView getSortView() {
        return (TextView) this.f21918b.mo5678b();
    }

    private final ImageView getViewMode() {
        return (ImageView) this.f21922f.mo5678b();
    }

    public final View m24181b(int i) {
        if (this.f21924h == null) {
            this.f21924h = new HashMap();
        }
        View view = (View) this.f21924h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f21924h.put(Integer.valueOf(i), view);
        return view;
    }

    public final View getGeopopularSelection() {
        return (View) this.f21920d.mo5678b();
    }

    public final ImageView getModModeButton() {
        return (ImageView) this.f21923g.mo5678b();
    }

    public /* synthetic */ ListingFilterBarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ListingFilterBarView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        this.f21918b = LazyKt.m26777a((Function0) new ListingFilterBarView$sortView$2(this));
        this.f21919c = LazyKt.m26777a((Function0) new ListingFilterBarView$geoIcon$2(this));
        this.f21920d = LazyKt.m26777a((Function0) new ListingFilterBarView$geopopularSelection$2(this));
        this.f21921e = LazyKt.m26777a((Function0) new ListingFilterBarView$geopopularSelectionText$2(this));
        this.f21922f = LazyKt.m26777a((Function0) new ListingFilterBarView$viewMode$2(this));
        this.f21923g = LazyKt.m26777a((Function0) new ListingFilterBarView$modModeButton$2(this));
        View.inflate(getContext(), C1761R.layout.merge_sort_bar, this);
        context = getGeoIcon();
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        Drawable drawable = getGeoIcon().getDrawable();
        Intrinsics.m26843a((Object) drawable, "geoIcon.drawable");
        context.setImageDrawable(ResourcesUtil.m22731d(context2, drawable));
        context = getModModeButton();
        context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        drawable = getModModeButton().getDrawable();
        Intrinsics.m26843a((Object) drawable, "modModeButton.drawable");
        context.setImageDrawable(ResourcesUtil.m22733e(context2, drawable));
    }

    @TargetApi(21)
    public ListingFilterBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f21918b = LazyKt.m26777a((Function0) new ListingFilterBarView$sortView$2(this));
        this.f21919c = LazyKt.m26777a((Function0) new ListingFilterBarView$geoIcon$2(this));
        this.f21920d = LazyKt.m26777a((Function0) new ListingFilterBarView$geopopularSelection$2(this));
        this.f21921e = LazyKt.m26777a((Function0) new ListingFilterBarView$geopopularSelectionText$2(this));
        this.f21922f = LazyKt.m26777a((Function0) new ListingFilterBarView$viewMode$2(this));
        this.f21923g = LazyKt.m26777a((Function0) new ListingFilterBarView$modModeButton$2(this));
        View.inflate(getContext(), C1761R.layout.merge_sort_bar, this);
        context = getGeoIcon();
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        Drawable drawable = getGeoIcon().getDrawable();
        Intrinsics.m26843a((Object) drawable, "geoIcon.drawable");
        context.setImageDrawable(ResourcesUtil.m22731d(context2, drawable));
        context = getModModeButton();
        context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        drawable = getModModeButton().getDrawable();
        Intrinsics.m26843a((Object) drawable, "modModeButton.drawable");
        context.setImageDrawable(ResourcesUtil.m22733e(context2, drawable));
    }

    public final void setOnSortClickListener(OnClickListener onClickListener) {
        getSortView().setOnClickListener(onClickListener);
    }

    public final void setGeopopularOnClickListener(OnClickListener onClickListener) {
        View geopopularSelection = getGeopopularSelection();
        geopopularSelection.setOnClickListener(onClickListener);
        ViewsKt.m24103a(geopopularSelection, onClickListener != null ? true : null);
    }

    public final void setGeopopularText(String str) {
        Intrinsics.m26847b(str, "text");
        getGeopopularSelectionText().setText(str);
    }

    public final void m24179a(int i, int i2) {
        TextView sortView = getSortView();
        if (Sorting.m21812f(i)) {
            i2 = Util.m23960a((int) C1761R.string.fmt_sort_timeframe, Util.m24027f(Sorting.m21807b(i)), Util.m24027f(Sorting.m21811e(i2)));
        } else {
            i2 = Util.m23960a((int) C1761R.string.fmt_sort, Util.m24027f(Sorting.m21807b(i)));
        }
        sortView.setText(i2);
        setSortIcons(Sorting.m21813g(i));
        m24178a(i);
    }

    public final void setHistorySort(SortOption<HistorySortType> sortOption) {
        Intrinsics.m26847b(sortOption, "sort");
        getSortView().setText(Util.m24027f(sortOption.f20413b));
        setSortIcons(sortOption.f20412a);
    }

    public final void m24178a(int i) {
        if (i != 2 || getGeopopularSelection().hasOnClickListeners() == 0) {
            ViewsKt.m24109d(getGeopopularSelection());
        } else {
            ViewsKt.m24107c(getGeopopularSelection());
        }
    }

    public final void m24180a(String str, int i) {
        Intrinsics.m26847b(str, "label");
        getSortView().setText(str);
        setSortIcons(i);
    }

    public final Point getGeopopularTextPosition() {
        Point e = ViewsKt.m24110e(getGeopopularSelectionText());
        return new Point(e.x + (getGeopopularSelectionText().getWidth() / 2), e.y + getGeopopularSelectionText().getHeight());
    }

    public final void setViewMode(ListingViewMode listingViewMode) {
        int i;
        Intrinsics.m26847b(listingViewMode, "mode");
        ViewsKt.m24106b(getViewMode(), true);
        switch (WhenMappings.f21916a[listingViewMode.ordinal()]) {
            case 1:
                i = C1761R.drawable.ic_view_card;
                break;
            case 2:
                i = C1761R.drawable.ic_view_compact;
                break;
            case 3:
                i = C1761R.drawable.ic_view_gallery;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        ImageView viewMode = getViewMode();
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        viewMode.setImageDrawable(ResourcesUtil.m22732e(context, i));
    }

    public final void setOnViewModeClickListener(OnClickListener onClickListener) {
        getViewMode().setOnClickListener(onClickListener);
    }

    private final void setSortIcons(int i) {
        TextView sortView = getSortView();
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        i = ResourcesUtil.m22726c(context, i);
        context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        sortView.setCompoundDrawablesRelative(i, null, ResourcesUtil.m22725b(context, ResourcesUtil.m22732e(context2, (int) C1761R.drawable.ind_dropdown)), null);
    }
}
