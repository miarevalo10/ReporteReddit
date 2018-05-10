package com.reddit.frontpage.ui.carousel;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.analytics.ListItemViewAttachListener;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012F\b\u0002\u0010\t\u001a@\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nj\u0004\u0018\u0001`\u0012\u00121\b\u0002\u0010\u0013\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0004\u0018\u0001`\u0016¢\u0006\u0002\u0010\u0017Jì\u0002\u00102\u001a\u00020\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u000205042Y\u00106\u001aU\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(8\u0012\u0013\u0012\u001105¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(9\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0011\u0018\u000107j\u0004\u0018\u0001`:2Y\u0010;\u001aU\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(8\u0012\u0013\u0012\u001105¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(9\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0011\u0018\u000107j\u0004\u0018\u0001`:2Y\u0010<\u001aU\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(8\u0012\u0013\u0012\u001105¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(9\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0011\u0018\u000107j\u0004\u0018\u0001`:2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001421\b\u0002\u0010=\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0004\u0018\u0001`\u0016J \u0010>\u001a\u00020?2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020BH\u0002J \u0010>\u001a\u00020?2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010C\u001a\u00020\u00112\n\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0002J\u001a\u0010D\u001a\u00020?2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010BH\u0002J\b\u0010F\u001a\u00020\u0006H\u0016J\u0006\u0010G\u001a\u00020\u0006J\u000e\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006J\u0010\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020LH\u0016J\u0012\u0010M\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010P\u001a\u00020\u00112\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010Q\u001a\u00020\u0011H\u0016J\b\u0010R\u001a\u00020\u0011H\u0002J\u0016\u0010S\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0006R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R.\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cj\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0014X.¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010\u001d2\b\u0010,\u001a\u0004\u0018\u00010\u001d8B@BX\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101RL\u0010\t\u001a@\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nj\u0004\u0018\u0001`\u0012X\u0004¢\u0006\u0002\n\u0000R7\u0010\u0013\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014j\u0004\u0018\u0001`\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/CarouselViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "Lcom/reddit/frontpage/presentation/analytics/ListItemViewAttachListener;", "itemView", "Landroid/view/View;", "screenWidth", "", "layout", "Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;", "onCarouselImpression", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "listablePosition", "", "", "positionsSeen", "", "Lcom/reddit/frontpage/ui/carousel/CarouselImpressionListener;", "onOverflowClicked", "Lkotlin/Function1;", "isSeen", "Lcom/reddit/frontpage/ui/carousel/OverflowClickListener;", "(Landroid/view/View;ILcom/reddit/frontpage/ui/carousel/CarouselItemLayout;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/reddit/frontpage/ui/carousel/CarouselAdapter;", "carouselId", "carouselStateMap", "Ljava/util/HashMap;", "Landroid/os/Parcelable;", "Lkotlin/collections/HashMap;", "getUnAdjustedLinkPosition", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "idsSeen", "", "getIdsSeen", "()Ljava/util/Set;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutStateKey", "getLayoutStateKey", "()Ljava/lang/String;", "value", "layoutStateParcelable", "getLayoutStateParcelable", "()Landroid/os/Parcelable;", "setLayoutStateParcelable", "(Landroid/os/Parcelable;)V", "bind", "collection", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "onDismissListener", "Lkotlin/Function3;", "carouselItemPosition", "item", "Lcom/reddit/frontpage/ui/carousel/CarouselClickListener;", "onSubscribeListener", "onClickListener", "onOverflowClickListener", "calculateCardWidth", "", "padding", "unit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "diffAndSetOnView", "getCardWidth", "discoveryUnit", "getCategory", "getCurrentPosition", "getLeftPositionOfViewPosition", "position", "onAttachedToWindow", "isVisible", "", "onRestoreViewState", "bundle", "Landroid/os/Bundle;", "onSaveViewState", "onViewRecycled", "saveLayoutState", "scrollToPositionWithOffset", "offset", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselViewHolder.kt */
public class CarouselViewHolder extends ListingViewHolder implements ListItemViewAttachListener {
    public static final Companion f34213a = new Companion();
    private Function1<? super ViewHolder, Integer> f34214b;
    private final CarouselAdapter f34215p;
    private String f34216q;
    private final HashMap<String, Parcelable> f34217r;
    private final int f34218s;
    private final CarouselItemLayout f34219t;
    private final Function2<Integer, Set<String>, Unit> f34220u;
    private Function1<? super Set<String>, Unit> f34221v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/ui/carousel/CarouselViewHolder$Companion;", "", "()V", "DEFAULT_CAROUSEL_ID_VALUE", "", "LAYOUT_STATE_PREPEND_KEY", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21117a;

        static {
            int[] iArr = new int[CarouselItemLayout.values().length];
            f21117a = iArr;
            iArr[CarouselItemLayout.SMALL.ordinal()] = 1;
            f21117a[CarouselItemLayout.LARGE.ordinal()] = 2;
        }
    }

    public final int mo6480Q() {
        return 8;
    }

    public /* synthetic */ CarouselViewHolder(View view, int i, CarouselItemLayout carouselItemLayout, Function2 function2, int i2) {
        if ((i2 & 8) != 0) {
            function2 = null;
        }
        this(view, i, carouselItemLayout, function2);
    }

    public CarouselViewHolder(View view, int i, CarouselItemLayout carouselItemLayout, Function2<? super Integer, ? super Set<String>, Unit> function2) {
        Intrinsics.m26847b(view, "itemView");
        Intrinsics.m26847b(carouselItemLayout, "layout");
        super(view);
        this.f34218s = i;
        this.f34219t = carouselItemLayout;
        this.f34220u = function2;
        this.f34221v = 0;
        this.f34216q = "";
        this.f34217r = new HashMap();
        i = new CarouselAdapter(this.f34219t);
        i.a(true);
        this.f34215p = i;
        CarouselRecyclerView carouselRecyclerView = (CarouselRecyclerView) view.findViewById(C1761R.id.carousel_recyclerview);
        carouselRecyclerView.setAdapter((Adapter) this.f34215p);
        carouselRecyclerView.setAllowSnapping(this.f34219t.getSnappingSupported());
        ((ImageButton) view.findViewById(C1761R.id.overflow)).setOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                view = this.f34221v;
                if (view != null) {
                    view.mo6492a(this.m34909x());
                }
            }
        });
    }

    private final String m34908w() {
        StringBuilder stringBuilder = new StringBuilder("layout_state_");
        stringBuilder.append(this.f34216q);
        return stringBuilder.toString();
    }

    public final LinearLayoutManager m34916v() {
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

    private final Set<String> m34909x() {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        return ((CarouselRecyclerView) obj.findViewById(C1761R.id.carousel_recyclerview)).getIdsSeen();
    }

    public final void mo6494a(Bundle bundle) {
        if (bundle != null) {
            m34916v().a(bundle.getParcelable(m34908w()));
        }
    }

    public final void mo6496b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        m34910y();
        bundle.putParcelable(m34908w(), m34916v().d());
    }

    public final void mo6493F() {
        m34910y();
    }

    private final void m34910y() {
        this.f34217r.put(m34908w(), m34916v().d());
    }

    public final void ab_() {
        Function1 function1 = this.f34214b;
        if (function1 == null) {
            Intrinsics.m26844a("getUnAdjustedLinkPosition");
        }
        int intValue = ((Number) function1.mo6492a(this)).intValue();
        Function2 function2 = this.f34220u;
        if (function2 != null) {
            function2.mo6497a(Integer.valueOf(intValue), m34909x());
        }
    }

    private static double m34904a(int i, int i2, CarouselItemLayout carouselItemLayout) {
        return ((double) (i - i2)) / ((double) carouselItemLayout.getItemsPerScreen());
    }

    public final void m34914a(GeneralCarouselCollectionPresentationModel<? extends ICarouselItemPresentationModel> generalCarouselCollectionPresentationModel, Function3<? super Integer, ? super ICarouselItemPresentationModel, ? super Set<String>, Unit> function3, Function3<? super Integer, ? super ICarouselItemPresentationModel, ? super Set<String>, Unit> function32, Function3<? super Integer, ? super ICarouselItemPresentationModel, ? super Set<String>, Unit> function33, Function1<? super ViewHolder, Integer> function1, Function1<? super Set<String>, Unit> function12) {
        double a;
        Function2 function2;
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "collection");
        Intrinsics.m26847b(function1, "getUnAdjustedLinkPosition");
        this.f34216q = generalCarouselCollectionPresentationModel.f36358f;
        this.f34214b = function1;
        function1 = this.c;
        View findViewById = function1.findViewById(C1761R.id.separator);
        Intrinsics.m26843a((Object) findViewById, "separator");
        ViewsKt.m24103a(findViewById, generalCarouselCollectionPresentationModel.f36360h);
        TextView textView = (TextView) function1.findViewById(C1761R.id.title);
        ViewsKt.m24103a((View) textView, generalCarouselCollectionPresentationModel.f36360h);
        textView.setText(generalCarouselCollectionPresentationModel.f36354b);
        Object obj = (ImageButton) function1.findViewById(C1761R.id.overflow);
        Intrinsics.m26843a(obj, "overflow");
        ViewsKt.m24103a((View) obj, function12 != null);
        function1 = this.f34215p;
        int i = this.f34218s;
        DiscoveryUnit discoveryUnit = generalCarouselCollectionPresentationModel.f36361i;
        int d = Util.m24012d((int) C1761R.dimen.triple_pad);
        if (discoveryUnit == null) {
            a = m34904a(i, d, CarouselItemLayout.SMALL);
        } else {
            switch (WhenMappings.f21117a[discoveryUnit.layout.ordinal()]) {
                case 1:
                    if (!discoveryUnit.f()) {
                        a = m34904a(i, d, CarouselItemLayout.SMALL);
                        break;
                    } else {
                        a = (double) Util.m24012d((int) C1761R.dimen.carousel_item_small_max_width);
                        break;
                    }
                case 2:
                    a = m34904a(i, d, CarouselItemLayout.LARGE);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        function1.f28900a = a;
        Function2 function22 = null;
        if (function3 == null) {
            function2 = null;
        } else {
            function2 = new CarouselViewHolder$bind$$inlined$apply$lambda$1(this, generalCarouselCollectionPresentationModel, function3, function32, function33);
        }
        function1.f28901b = function2;
        if (function32 != null) {
            function22 = new CarouselViewHolder$bind$$inlined$apply$lambda$2(this, generalCarouselCollectionPresentationModel, function3, function32, function33);
        }
        function1.f28902c = function22;
        function1.f28903f = new CarouselViewHolder$bind$$inlined$apply$lambda$3(this, generalCarouselCollectionPresentationModel, function3, function32, function33);
        this.f34221v = function12;
        function3 = DiffUtil.a((Callback) new CarouselViewHolder$diffAndSetOnView$result$1(this.f34215p.f28904g, generalCarouselCollectionPresentationModel.f36357e), false);
        function32 = this.f34215p.f28904g;
        function32.clear();
        function32.addAll((Collection) generalCarouselCollectionPresentationModel.f36357e);
        function3.a((Adapter) this.f34215p);
        m34916v().a((Parcelable) this.f34217r.get(m34908w()));
    }
}
