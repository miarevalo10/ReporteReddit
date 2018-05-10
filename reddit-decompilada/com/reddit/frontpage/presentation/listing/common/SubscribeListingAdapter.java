package com.reddit.frontpage.presentation.listing.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.common.SortableLoadMoreListingAdapter.DefaultImpls;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.model.SortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeader;
import com.reddit.frontpage.presentation.listing.ui.view.SubscribeLinkHeaderView;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 Q*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003*\u0004\b\u0001\u0010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u00052\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\n2\u00020\u000b:\u0001QB\u0001\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00140\u001e\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\u0010\"J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020BH\u0014J\b\u0010C\u001a\u00020\u001cH\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u000fH\u0016J\b\u0010F\u001a\u00020\u000fH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0011\u0010I\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0001J\b\u0010J\u001a\u00020\u0018H\u0014J\u0011\u0010K\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020LH\u0001J4\u0010M\u001a\u00020\u00142\u0006\u0010@\u001a\u00020L2!\u0010N\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020\u00140\u0012H\u0001R\u0018\u0010#\u001a\u00020\bX\u000f¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00020\u0007X\u000f¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\t05X\u000f¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b;\u0010*R\u0013\u0010\u0010\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u000e\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/SubscribeListingAdapter;", "T", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingModeratorActions;", "S", "Lcom/reddit/frontpage/presentation/listing/common/PresentationListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/SortableLoadMoreListingAdapter;", "Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/common/ListableListingHeaderFooterAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "context", "Landroid/content/Context;", "options", "", "presenter", "retainPlayersInFeed", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "geopopularText", "", "screenSourcePage", "isCompact", "Lkotlin/Function0;", "", "onSortClick", "Lkotlin/Function2;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "onViewModeClick", "onGeopopularClick", "(Landroid/content/Context;ILcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;Lkotlin/jvm/functions/Function1;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "footerIndex", "getFooterIndex", "()I", "footerState", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "getFooterState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "header", "getHeader", "()Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;", "setHeader", "(Lcom/reddit/frontpage/presentation/listing/model/SortHeaderPresentationModel;)V", "listing", "", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "listingItemCount", "getListingItemCount", "getPresenter", "()Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/MutableListingLinkActions;", "bindViewHolder", "holder", "model", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "getCompact", "getItem", "position", "getItemCount", "getItemId", "", "getModelPosition", "getSourcePage", "getUnadjustedLinkPosition", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "withUnadjustedLinkPosition", "action", "Lkotlin/ParameterName;", "name", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubscribeListingAdapter.kt */
public class SubscribeListingAdapter<T extends MutableListingLinkActions & ListingModeratorActions, S> extends PresentationListingAdapter<T, S> implements LoadMoreListingAdapter, SortableLoadMoreListingAdapter<SortHeaderPresentationModel, LoadingFooterPresentationModel, Listable> {
    public static final Companion f36615b = new Companion();
    final T f36616a;
    public final /* synthetic */ RedditSortableLoadMoreListingAdapter f36617c;
    private final String f36618p;
    private final Function0<Boolean> f36619q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/SubscribeListingAdapter$Companion;", "", "()V", "DEFAULT_ADAPTER_OPTIONS", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubscribeListingAdapter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final void mo6937a(ViewHolder viewHolder, Function1<? super Integer, Unit> function1) {
        Intrinsics.m26847b(viewHolder, "holder");
        Intrinsics.m26847b(function1, "action");
        this.f36617c.m34715a(viewHolder, function1);
    }

    public final void m37030a(LoadingFooterPresentationModel loadingFooterPresentationModel) {
        Intrinsics.m26847b(loadingFooterPresentationModel, "<set-?>");
        this.f36617c.m34716a(loadingFooterPresentationModel);
    }

    public final void m37031a(SortHeaderPresentationModel sortHeaderPresentationModel) {
        Intrinsics.m26847b(sortHeaderPresentationModel, "<set-?>");
        this.f36617c.m34717a(sortHeaderPresentationModel);
    }

    public final void mo6470a(List<Listable> list) {
        Intrinsics.m26847b(list, "<set-?>");
        this.f36617c.mo6470a((List) list);
    }

    public final int mo6471d(ViewHolder viewHolder) {
        Intrinsics.m26847b(viewHolder, "holder");
        return this.f36617c.mo6471d(viewHolder);
    }

    public final /* synthetic */ Object mo4996g(int i) {
        return mo6476c(i);
    }

    private SubscribeListingAdapter(Context context, T t, Function1<? super LinkViewHolder, Unit> function1, ListingViewMode listingViewMode, String str, String str2, Function0<Boolean> function0, Function2<? super S, ? super SortTimeFrame, Unit> function2, Function0<Unit> function02, Function0<Unit> function03) {
        T t2 = t;
        ListingViewMode listingViewMode2 = listingViewMode;
        String str3 = str2;
        Function0<Boolean> function04 = function0;
        Context context2 = context;
        Intrinsics.m26847b(context2, "context");
        Intrinsics.m26847b(t2, "presenter");
        Function1<? super LinkViewHolder, Unit> function12 = function1;
        Intrinsics.m26847b(function12, "retainPlayersInFeed");
        Intrinsics.m26847b(listingViewMode2, "viewMode");
        Intrinsics.m26847b(str3, "screenSourcePage");
        Intrinsics.m26847b(function04, "isCompact");
        Function2<? super S, ? super SortTimeFrame, Unit> function22 = function2;
        Intrinsics.m26847b(function22, "onSortClick");
        Function0<Unit> function05 = function02;
        Intrinsics.m26847b(function05, "onViewModeClick");
        Function0<Unit> function06 = function03;
        Intrinsics.m26847b(function06, "onGeopopularClick");
        super(context2, t2, function12, function22, function05, function06);
        this.f36617c = new RedditSortableLoadMoreListingAdapter(listingViewMode2, str);
        this.f36616a = t2;
        this.f36618p = str3;
        this.f36619q = function04;
    }

    public final int mo4926b() {
        return DefaultImpls.m22942a((SortableLoadMoreListingAdapter) this);
    }

    protected final String mo6479f() {
        return this.f36618p;
    }

    public final boolean mo6477c() {
        return ((Boolean) this.f36619q.invoke()).booleanValue();
    }

    protected final void mo6464a(LinkViewHolder linkViewHolder, LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkViewHolder, "holder");
        Intrinsics.m26847b(linkPresentationModel, "model");
        super.mo6464a(linkViewHolder, linkPresentationModel);
        if (!((Boolean) this.f36619q.invoke()).booleanValue()) {
            if (linkViewHolder.m34771M() instanceof SubscribeLinkHeaderView) {
                LinkHeader M = linkViewHolder.m34771M();
                if (M == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.SubscribeLinkHeaderView");
                }
                SubscribeLinkHeaderView subscribeLinkHeaderView = (SubscribeLinkHeaderView) M;
                boolean d = SubredditUtil.m23933d(linkPresentationModel.af) ^ 1;
                int dimensionPixelSize = subscribeLinkHeaderView.getResources().getDimensionPixelSize(C1761R.dimen.metadata_subreddit_icon_size);
                int dimensionPixelSize2 = d ? subscribeLinkHeaderView.getResources().getDimensionPixelSize(C1761R.dimen.half_pad) : 0;
                ShapedIconView subredditIconView = subscribeLinkHeaderView.getSubredditIconView();
                LayoutParams layoutParams = new LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.setMargins(dimensionPixelSize2, 0, 0, 0);
                subredditIconView.setLayoutParams(layoutParams);
                ViewsKt.m24106b(subscribeLinkHeaderView.getSubscribeToggle(), d);
                if (SubredditUtil.m23933d(linkPresentationModel.af) == null) {
                    subscribeLinkHeaderView.getSubscribeContainer().setOnClickListener((OnClickListener) new SubscribeListingAdapter$inlined$sam$OnClickListener$i$7f478c20(new SubscribeListingAdapter$bindViewHolder$1(this, linkViewHolder)));
                } else {
                    subscribeLinkHeaderView.getSubscribeContainer().setOnClickListener((OnClickListener) new SubscribeListingAdapter$inlined$sam$OnClickListener$i$7f478c20(new SubscribeListingAdapter$bindViewHolder$2(this, linkViewHolder)));
                }
            }
        }
    }

    public final Listable mo6476c(int i) {
        return (Listable) this.f36617c.f33898c.get(i);
    }

    public final int m37027a() {
        return this.f36617c.f33898c.size();
    }

    public final long m37028a(int i) {
        return ((Listable) this.f36617c.f33898c.get(i)).getUniqueID();
    }

    public final FooterState F_() {
        return this.f36617c.f33897b.f34003a;
    }

    public final List<Listable> mo6473i() {
        return this.f36617c.f33898c;
    }

    public final int mo4927j() {
        return DefaultImpls.m22944b(this.f36617c);
    }

    public final int mo6472h(int i) {
        return DefaultImpls.m22940a(i);
    }
}
