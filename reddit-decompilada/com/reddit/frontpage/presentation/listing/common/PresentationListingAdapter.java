package com.reddit.frontpage.presentation.listing.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Banner;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.common.ListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.history.HistorySortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LiveUpdateEventPresentationModel;
import com.reddit.frontpage.presentation.listing.model.SortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.LinkFooterView;
import com.reddit.frontpage.presentation.listing.ui.view.LinkFooterView.OnModerateListener;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder$setOnModerateListener$$inlined$apply$lambda$1;
import com.reddit.frontpage.presentation.listing.ui.viewholder.OnLinkHiddenListener;
import com.reddit.frontpage.presentation.listing.ui.viewholder.SortHeaderViewHolder;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.BannerViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LiveThreadViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003*\u0004\b\u0001\u0010\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006Bo\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00100\u0012\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u0010\u0017J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020 H\u0014J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020!H\u0014J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u000fH\u0014J\u001c\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000fH\u0002R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00100\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001c\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "context", "Landroid/content/Context;", "options", "", "presenter", "retainPlayersInFeed", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "", "onSortClick", "Lkotlin/Function2;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "onViewModeClick", "Lkotlin/Function0;", "onGeopopularClick", "(Landroid/content/Context;ILcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onLinkHiddenListener", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnLinkHiddenListener;", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "bindViewHolder", "holder", "model", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/SortHeaderViewHolder;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "Lcom/reddit/frontpage/ui/listing/newcard/BannerViewHolder;", "banner", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Banner;", "Lcom/reddit/frontpage/ui/listing/newcard/LiveThreadViewHolder;", "liveBanner", "Lcom/reddit/frontpage/presentation/listing/model/LiveUpdateEventPresentationModel;", "configure", "viewHolder", "navigateToPostDetail", "linkViewHolder", "Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "prepareToNavigate", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PresentationListingAdapter.kt */
public abstract class PresentationListingAdapter<T extends MutableListingLinkActions & ListingModeratorActions, Sort> extends CardLinkAdapter implements ListingAdapter<Listable> {
    private final OnLinkHiddenListener f33884a;
    private final T f33885b;
    private final Function1<LinkViewHolder, Unit> f33886c;
    private final Function2<Sort, SortTimeFrame, Unit> f33887p;
    private final Function0<Unit> f33888q;
    private final Function0<Unit> f33889r;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "Sort", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: PresentationListingAdapter.kt */
    static final class C28632 extends Lambda implements Function0<Unit> {
        public static final C28632 f36538a = new C28632();

        C28632() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return Unit.f25273a;
        }
    }

    protected final void mo6468a(com.reddit.frontpage.ui.listing.newcard.LinkViewHolder linkViewHolder, Link link) {
    }

    public void mo6937a(ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
        Intrinsics.m26847b(viewHolder, "holder");
        Intrinsics.m26847b(function1, "action");
        DefaultImpls.m22874a(this, viewHolder, function1);
    }

    public PresentationListingAdapter(Context context, T t, Function1<? super LinkViewHolder, Unit> function1, Function2<? super Sort, ? super SortTimeFrame, Unit> function2, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(t, "presenter");
        Intrinsics.m26847b(function1, "retainPlayersInFeed");
        Intrinsics.m26847b(function2, "onSortClick");
        Intrinsics.m26847b(function0, "onViewModeClick");
        Intrinsics.m26847b(function02, "onGeopopularClick");
        super(context, 11);
        this.f33885b = t;
        this.f33886c = function1;
        this.f33887p = function2;
        this.f33888q = function0;
        this.f33889r = function02;
        this.f33884a = (OnLinkHiddenListener) new PresentationListingAdapter$onLinkHiddenListener$1(this);
    }

    protected void mo6464a(LinkViewHolder linkViewHolder, LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkViewHolder, "holder");
        Intrinsics.m26847b(linkPresentationModel, "model");
        super.mo6464a(linkViewHolder, linkPresentationModel);
        linkViewHolder.f34046s = this.f33884a;
        Object obj = linkViewHolder.c;
        Intrinsics.m26843a(obj, "holder.itemView");
        obj.setOnClickListener(new C1825xa52db3fa(new PresentationListingAdapter$bindViewHolder$1(this, linkViewHolder)));
        linkViewHolder.m34771M().setClickListener(new PresentationListingAdapter$bindViewHolder$2(this, linkViewHolder));
        linkViewHolder.m34780a((Function0) new PresentationListingAdapter$bindViewHolder$3(this, linkViewHolder));
        linkViewHolder.m34781b((Function0) new PresentationListingAdapter$bindViewHolder$4(this, linkViewHolder));
    }

    protected final void mo6463a(LinkViewHolder linkViewHolder) {
        Intrinsics.m26847b(linkViewHolder, "viewHolder");
        super.mo6463a(linkViewHolder);
        linkViewHolder.f34045r = new PresentationListingAdapter$configure$1(this, linkViewHolder);
        OnModerateListener presentationListingAdapter$configure$2 = new PresentationListingAdapter$configure$2(this, linkViewHolder);
        Intrinsics.m26847b(presentationListingAdapter$configure$2, "listener");
        LinkFooterView N = linkViewHolder.m34772N();
        N.setOnModerateListener(presentationListingAdapter$configure$2);
        N.setOnModActionCompletedListener(new LinkViewHolder$setOnModerateListener$$inlined$apply$lambda$1(N, linkViewHolder, presentationListingAdapter$configure$2));
    }

    protected final void mo6469a(LiveThreadViewHolder liveThreadViewHolder, LiveUpdateEventPresentationModel liveUpdateEventPresentationModel) {
        Intrinsics.m26847b(liveThreadViewHolder, "holder");
        Intrinsics.m26847b(liveUpdateEventPresentationModel, "liveBanner");
        super.mo6469a(liveThreadViewHolder, liveUpdateEventPresentationModel);
        Object obj = liveThreadViewHolder.c;
        Intrinsics.m26843a(obj, "holder.itemView");
        obj.setOnClickListener((OnClickListener) new C1825xa52db3fa(new PresentationListingAdapter$bindViewHolder$5(liveThreadViewHolder, liveUpdateEventPresentationModel)));
    }

    protected final void mo6467a(BannerViewHolder bannerViewHolder, Banner banner) {
        Intrinsics.m26847b(bannerViewHolder, "holder");
        Intrinsics.m26847b(banner, "banner");
        super.mo6467a(bannerViewHolder, banner);
        Object obj = bannerViewHolder.c;
        Intrinsics.m26843a(obj, "holder.itemView");
        obj.setOnClickListener((OnClickListener) new C1825xa52db3fa(new PresentationListingAdapter$bindViewHolder$6(banner)));
    }

    protected final void mo6466a(SortHeaderViewHolder sortHeaderViewHolder, SortHeaderPresentationModel sortHeaderPresentationModel) {
        Intrinsics.m26847b(sortHeaderViewHolder, "holder");
        Intrinsics.m26847b(sortHeaderPresentationModel, "model");
        super.mo6466a(sortHeaderViewHolder, sortHeaderPresentationModel);
        sortHeaderViewHolder.m34791a(new C1820x6806beb0(this, sortHeaderPresentationModel));
        sortHeaderViewHolder.m34792b(new C1821x6806beb1(this, sortHeaderPresentationModel));
        String str = sortHeaderPresentationModel.f34008d;
        if (str != null) {
            if (!Intrinsics.m26845a(sortHeaderPresentationModel.f34005a, SortType.c)) {
                str = null;
            }
            if (str != null) {
                OnClickListener c1822x6806beb2 = new C1822x6806beb2(sortHeaderViewHolder, this, sortHeaderPresentationModel);
                Object obj = sortHeaderViewHolder.c;
                Intrinsics.m26843a(obj, "itemView");
                ((ListingFilterBarView) obj.findViewById(C1761R.id.listing_filter_bar)).setGeopopularOnClickListener(c1822x6806beb2);
            }
        }
    }

    protected final void mo6465a(SortHeaderViewHolder sortHeaderViewHolder, HistorySortHeaderPresentationModel historySortHeaderPresentationModel) {
        Intrinsics.m26847b(sortHeaderViewHolder, "holder");
        Intrinsics.m26847b(historySortHeaderPresentationModel, "model");
        super.mo6465a(sortHeaderViewHolder, historySortHeaderPresentationModel);
        sortHeaderViewHolder.m34791a(new C1823x6806beb3(this, historySortHeaderPresentationModel));
        sortHeaderViewHolder.m34792b(new C1824x6806beb4(this, historySortHeaderPresentationModel));
    }

    public static final /* synthetic */ void m34700a(PresentationListingAdapter presentationListingAdapter, LinkViewHolder linkViewHolder) {
        linkViewHolder.mo6969w();
        presentationListingAdapter.f33886c.mo6492a(null);
        if ((linkViewHolder instanceof VisibilityDependent) != null) {
            ((VisibilityDependent) linkViewHolder).aq();
        }
    }
}
