package com.reddit.frontpage.ui.carousel;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.analytics.ListItemViewAttachListener;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012F\b\u0002\u0010\u0006\u001a@\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010\u00121\b\u0002\u0010\u0011\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014¢\u0006\u0002\u0010\u0015J\u0004\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022Y\u00103\u001aU\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(5\u0012\u0013\u0012\u001106¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u000104j\u0004\u0018\u0001`82Y\u00109\u001aU\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(5\u0012\u0013\u0012\u001106¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u000104j\u0004\u0018\u0001`82Y\u0010:\u001aU\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(5\u0012\u0013\u0012\u001106¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u000104j\u0004\u0018\u0001`82\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u00122U\u0010;\u001aQ\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(<\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f04j\u0002`=2U\u0010>\u001aQ\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(<\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f04j\u0002`=21\b\u0002\u0010?\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014J\b\u0010@\u001a\u00020\bH\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020\u000fH\u0016J\u0012\u0010E\u001a\u00020\u000f2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010I\u001a\u00020\u000fH\u0016J\b\u0010J\u001a\u00020\u000fH\u0002R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R.\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R(\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u001b8B@BX\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/RL\u0010\u0006\u001a@\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010X\u0004¢\u0006\u0002\n\u0000R7\u0010\u0011\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/LinkCarouselViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "Lcom/reddit/frontpage/presentation/analytics/ListItemViewAttachListener;", "Lcom/reddit/frontpage/presentation/common/ui/Pausable;", "itemView", "Landroid/view/View;", "onCarouselImpression", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "listablePosition", "", "", "positionsSeen", "", "Lcom/reddit/frontpage/ui/carousel/CarouselImpressionListener;", "onOverflowClicked", "Lkotlin/Function1;", "isSeen", "Lcom/reddit/frontpage/ui/carousel/OverflowClickListener;", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselAdapter;", "carouselId", "carouselStateMap", "Ljava/util/HashMap;", "Landroid/os/Parcelable;", "Lkotlin/collections/HashMap;", "getUnAdjustedLinkPosition", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "idsSeen", "", "getIdsSeen", "()Ljava/util/Set;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutStateKey", "getLayoutStateKey", "()Ljava/lang/String;", "value", "layoutStateParcelable", "getLayoutStateParcelable", "()Landroid/os/Parcelable;", "setLayoutStateParcelable", "(Landroid/os/Parcelable;)V", "bind", "collection", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "onItemSubscribeListener", "Lkotlin/Function3;", "carouselItemPosition", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "item", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselClickListener;", "onItemClickListener", "onItemHeaderClickListener", "onCarouselClickListener", "carouselPosition", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselActionListener;", "onCarouselSubscribeListener", "onOverflowClickListener", "getCategory", "onAttachedToWindow", "isVisible", "", "onPause", "onRestoreViewState", "bundle", "Landroid/os/Bundle;", "onSaveViewState", "onViewRecycled", "saveLayoutState", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkCarouselViewHolder.kt */
public final class LinkCarouselViewHolder extends ListingViewHolder implements ListItemViewAttachListener {
    public static final Companion f34225a = new Companion();
    private String f34226b;
    private final HashMap<String, Parcelable> f34227p;
    private Function1<? super ViewHolder, Integer> f34228q;
    private final LinkCarouselAdapter f34229r;
    private final Function2<Integer, Set<String>, Unit> f34230s;
    private Function1<? super Set<String>, Unit> f34231t;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2F\b\u0002\u0010\r\u001a@\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000ej\u0004\u0018\u0001`\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/LinkCarouselViewHolder$Companion;", "", "()V", "DEFAULT_CAROUSEL_ID_VALUE", "", "LAYOUT_STATE_PREPEND_KEY", "SHOW_SUBSCRIBE_DISPLAY_CHILD", "", "SHOW_UNSUBSCRIBE_DISPLAY_CHILD", "create", "Lcom/reddit/frontpage/ui/carousel/LinkCarouselViewHolder;", "parent", "Landroid/view/ViewGroup;", "onCarouselImpression", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "listablePosition", "", "positionsSeen", "", "Lcom/reddit/frontpage/ui/carousel/CarouselImpressionListener;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkCarouselViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LinkCarouselViewHolder m23326a(ViewGroup viewGroup, Function2<? super Integer, ? super Set<String>, Unit> function2) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new LinkCarouselViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.layout_link_carousel, false), function2);
        }
    }

    public static final LinkCarouselViewHolder m34934a(ViewGroup viewGroup, Function2<? super Integer, ? super Set<String>, Unit> function2) {
        return Companion.m23326a(viewGroup, function2);
    }

    public final int mo6480Q() {
        return 9;
    }

    private LinkCarouselViewHolder(View view, Function2<? super Integer, ? super Set<String>, Unit> function2) {
        Intrinsics.m26847b(view, "itemView");
        super(view);
        this.f34230s = function2;
        this.f34231t = null;
        this.f34226b = "";
        this.f34227p = new HashMap();
        function2 = new LinkCarouselAdapter();
        function2.a(true);
        this.f34229r = function2;
        CarouselRecyclerView carouselRecyclerView = (CarouselRecyclerView) view.findViewById(C1761R.id.carousel_recyclerview);
        carouselRecyclerView.setAdapter(this.f34229r);
        carouselRecyclerView.setAllowSnapping(false);
        carouselRecyclerView.setSnapListener(new LinkCarouselViewHolder$2$1(carouselRecyclerView));
        Object obj = (ImageButton) view.findViewById(C1761R.id.overflow);
        Intrinsics.m26843a(obj, "itemView.overflow");
        ((View) obj).setOnClickListener(new LinkCarouselViewHolder$inlined$sam$OnClickListener$i$7f478c20((Function1) new Function1<View, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                obj = this.f34231t;
                if (obj != null) {
                    obj.mo6492a(this.m34939x());
                }
                return Unit.f25273a;
            }
        }));
    }

    private final String m34937v() {
        StringBuilder stringBuilder = new StringBuilder("layout_state_");
        stringBuilder.append(this.f34226b);
        return stringBuilder.toString();
    }

    private final LinearLayoutManager m34938w() {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        obj = (CarouselRecyclerView) obj.findViewById(C1761R.id.carousel_recyclerview);
        Intrinsics.m26843a(obj, "itemView.carousel_recyclerview");
        LayoutManager layoutManager = obj.getLayoutManager();
        if (layoutManager != null) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }

    public final void ab_() {
        Function1 function1 = this.f34228q;
        if (function1 == null) {
            Intrinsics.m26844a("getUnAdjustedLinkPosition");
        }
        int intValue = ((Number) function1.mo6492a(this)).intValue();
        Function2 function2 = this.f34230s;
        if (function2 != null) {
            function2.mo6497a(Integer.valueOf(intValue), m34939x());
        }
    }

    private final Set<String> m34939x() {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        return ((CarouselRecyclerView) obj.findViewById(C1761R.id.carousel_recyclerview)).getIdsSeen();
    }

    public final void mo6494a(Bundle bundle) {
        if (bundle != null) {
            m34938w().a(bundle.getParcelable(m34937v()));
        }
    }

    public final void mo6493F() {
        m34940y();
    }

    public final void mo6496b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        m34940y();
        bundle.putParcelable(m34937v(), m34938w().d());
    }

    private final void m34940y() {
        this.f34227p.put(m34937v(), m34938w().d());
    }

    public final void m34944a(LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel, Function3<? super Integer, ? super LinkCarouselItemPresentationModel, ? super Set<String>, Unit> function3, Function3<? super Integer, ? super LinkCarouselItemPresentationModel, ? super Set<String>, Unit> function32, Function3<? super Integer, ? super LinkCarouselItemPresentationModel, ? super Set<String>, Unit> function33, Function1<? super ViewHolder, Integer> function1, Function3<? super Integer, ? super LinkCarouselCollectionPresentationModel, ? super Set<String>, Unit> function34, Function3<? super Integer, ? super LinkCarouselCollectionPresentationModel, ? super Set<String>, Unit> function35, Function1<? super Set<String>, Unit> function12) {
        Object obj;
        LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel2 = linkCarouselCollectionPresentationModel;
        Function1<? super ViewHolder, Integer> function13 = function1;
        Function1<? super Set<String>, Unit> function14 = function12;
        Intrinsics.m26847b(linkCarouselCollectionPresentationModel2, "collection");
        Intrinsics.m26847b(function13, "getUnAdjustedLinkPosition");
        Function3<? super Integer, ? super LinkCarouselCollectionPresentationModel, ? super Set<String>, Unit> function36 = function34;
        Intrinsics.m26847b(function36, "onCarouselClickListener");
        Function3<? super Integer, ? super LinkCarouselCollectionPresentationModel, ? super Set<String>, Unit> function37 = function35;
        Intrinsics.m26847b(function37, "onCarouselSubscribeListener");
        this.f34226b = linkCarouselCollectionPresentationModel2.f36375l;
        this.f34228q = function13;
        this.f34231t = function14;
        View view = this.c;
        TextView textView = (TextView) view.findViewById(C1761R.id.title);
        Intrinsics.m26843a((Object) textView, "title");
        TextViewsKt.m24097a(textView, linkCarouselCollectionPresentationModel2.f36365b);
        Function2 function2 = null;
        if (StringsKt__StringsJVMKt.m41943a((CharSequence) linkCarouselCollectionPresentationModel2.f36366c)) {
            obj = (TextView) view.findViewById(C1761R.id.subtitle);
            Intrinsics.m26843a(obj, "subtitle");
            ViewsKt.m24109d((View) obj);
        } else {
            Drawable drawable;
            obj = (TextView) view.findViewById(C1761R.id.subtitle);
            Intrinsics.m26843a(obj, "subtitle");
            obj.setText(linkCarouselCollectionPresentationModel2.f36366c);
            if (linkCarouselCollectionPresentationModel2.f36367d == null) {
                drawable = null;
            } else {
                obj = r6.c;
                Intrinsics.m26843a(obj, "itemView");
                drawable = ContextCompat.a(obj.getContext(), linkCarouselCollectionPresentationModel2.f36367d.intValue());
            }
            ((TextView) view.findViewById(C1761R.id.subtitle)).setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
        }
        obj = (ImageButton) view.findViewById(C1761R.id.overflow);
        Intrinsics.m26843a(obj, "overflow");
        ViewsKt.m24106b((View) obj, function14 != null);
        if (linkCarouselCollectionPresentationModel2.f36377n.options.contains("unit_show_subreddit_header")) {
            Object findViewById = view.findViewById(C1761R.id.subreddit_header);
            Intrinsics.m26843a(findViewById, "subreddit_header");
            LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel3 = linkCarouselCollectionPresentationModel2;
            Function1<? super Set<String>, Unit> function15 = function14;
            Function3<? super Integer, ? super LinkCarouselCollectionPresentationModel, ? super Set<String>, Unit> function38 = function36;
            Function3<? super Integer, ? super LinkCarouselCollectionPresentationModel, ? super Set<String>, Unit> function39 = function37;
            findViewById.setOnClickListener(new LinkCarouselViewHolder$inlined$sam$OnClickListener$i$7f478c20(new LinkCarouselViewHolder$bind$$inlined$apply$lambda$1(r6, linkCarouselCollectionPresentationModel3, function15, function38, function39)));
            obj = (TextView) view.findViewById(C1761R.id.title);
            Intrinsics.m26843a(obj, "title");
            ((View) obj).setOnClickListener(new LinkCarouselViewHolder$inlined$sam$OnClickListener$i$7f478c20(new LinkCarouselViewHolder$bind$$inlined$apply$lambda$2(r6, linkCarouselCollectionPresentationModel3, function15, function38, function39)));
            obj = (TextView) view.findViewById(C1761R.id.subtitle);
            Intrinsics.m26843a(obj, "subtitle");
            ((View) obj).setOnClickListener(new LinkCarouselViewHolder$inlined$sam$OnClickListener$i$7f478c20(new LinkCarouselViewHolder$bind$$inlined$apply$lambda$3(r6, linkCarouselCollectionPresentationModel3, function15, function38, function39)));
            textView = (TextView) view.findViewById(C1761R.id.subreddit_name);
            Intrinsics.m26843a((Object) textView, "subreddit_name");
            TextViewsKt.m24097a(textView, linkCarouselCollectionPresentationModel2.f36368e);
            obj = (TextView) view.findViewById(C1761R.id.subreddit_metadata);
            Intrinsics.m26843a(obj, "subreddit_metadata");
            obj.setText(linkCarouselCollectionPresentationModel2.f36369f);
            obj = (TextView) view.findViewById(C1761R.id.subreddit_description);
            Intrinsics.m26843a(obj, "subreddit_description");
            obj.setText(linkCarouselCollectionPresentationModel2.f36370g);
            Util.m23982a((ShapedIconView) view.findViewById(C1761R.id.subreddit_icon), linkCarouselCollectionPresentationModel2.f36371h, null);
            obj = view.findViewById(C1761R.id.subreddit_header);
            Intrinsics.m26843a(obj, "subreddit_header");
            ViewsKt.m24107c(obj);
        } else {
            obj = view.findViewById(C1761R.id.subreddit_header);
            Intrinsics.m26843a(obj, "subreddit_header");
            ViewsKt.m24109d(obj);
        }
        if (linkCarouselCollectionPresentationModel2.f36372i) {
            obj = (TextView) view.findViewById(C1761R.id.subreddit_description);
            Intrinsics.m26843a(obj, "subreddit_description");
            ViewsKt.m24109d((View) obj);
            obj = (ViewSwitcher) view.findViewById(C1761R.id.subscribe_viewswitcher);
            Intrinsics.m26843a(obj, "subscribe_viewswitcher");
            ViewsKt.m24109d((View) obj);
        } else {
            ViewSwitcher viewSwitcher = (ViewSwitcher) view.findViewById(C1761R.id.subscribe_viewswitcher);
            view = viewSwitcher;
            ViewsKt.m24103a(view, linkCarouselCollectionPresentationModel2.f36377n.c());
            viewSwitcher.setDisplayedChild(linkCarouselCollectionPresentationModel2.f36373j);
            obj = (Button) view.findViewById(C1761R.id.subscribe);
            Intrinsics.m26843a(obj, "subscribe");
            linkCarouselCollectionPresentationModel3 = linkCarouselCollectionPresentationModel2;
            function15 = function14;
            function38 = function36;
            function39 = function37;
            ((View) obj).setOnClickListener(new LinkCarouselViewHolder$inlined$sam$OnClickListener$i$7f478c20(new LinkCarouselViewHolder$bind$$inlined$apply$lambda$4(r6, linkCarouselCollectionPresentationModel3, function15, function38, function39)));
            obj = (Button) view.findViewById(C1761R.id.unsubscribe);
            Intrinsics.m26843a(obj, "unsubscribe");
            ((View) obj).setOnClickListener(new LinkCarouselViewHolder$inlined$sam$OnClickListener$i$7f478c20(new LinkCarouselViewHolder$bind$$inlined$apply$lambda$5(r6, linkCarouselCollectionPresentationModel3, function15, function38, function39)));
        }
        LinkCarouselAdapter linkCarouselAdapter = r6.f34229r;
        if (function3 != null) {
            function2 = new LinkCarouselViewHolder$bind$$inlined$apply$lambda$6(r6, function3, function32, function33, linkCarouselCollectionPresentationModel2);
        }
        linkCarouselAdapter.f28916a = function2;
        Function3<? super Integer, ? super LinkCarouselItemPresentationModel, ? super Set<String>, Unit> function310 = function3;
        Function3<? super Integer, ? super LinkCarouselItemPresentationModel, ? super Set<String>, Unit> function311 = function32;
        Function3<? super Integer, ? super LinkCarouselItemPresentationModel, ? super Set<String>, Unit> function312 = function33;
        LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel4 = linkCarouselCollectionPresentationModel2;
        linkCarouselAdapter.f28917b = new LinkCarouselViewHolder$bind$$inlined$apply$lambda$7(r6, function310, function311, function312, linkCarouselCollectionPresentationModel4);
        linkCarouselAdapter.f28918c = new LinkCarouselViewHolder$bind$$inlined$apply$lambda$8(r6, function310, function311, function312, linkCarouselCollectionPresentationModel4);
        List list = linkCarouselAdapter.f28919f;
        list.clear();
        list.addAll(linkCarouselCollectionPresentationModel2.f36374k);
        linkCarouselAdapter.e();
        m34938w().a((Parcelable) r6.f34227p.get(m34937v()));
    }
}
