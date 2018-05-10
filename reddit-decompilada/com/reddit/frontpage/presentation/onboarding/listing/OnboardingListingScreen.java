package com.reddit.frontpage.presentation.onboarding.listing;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerOnboardingListingViewComponent;
import com.reddit.frontpage.di.component.OnboardingListingViewComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.ListingAdapter;
import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.common.LoadMoreListingAdapter;
import com.reddit.frontpage.presentation.listing.common.LoadMoreOnScrollListener;
import com.reddit.frontpage.presentation.listing.common.ViewDiffResult;
import com.reddit.frontpage.presentation.listing.model.FooterState;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeader;
import com.reddit.frontpage.presentation.listing.ui.view.OnboardingLinkHeaderView;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LoadingFooterViewHolder;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.Parameters;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.View;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0002LMB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020!H\u0016J\u0018\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020!H\u0016J\u0018\u00100\u001a\u00020&2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020!H\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0016J\b\u00103\u001a\u00020&H\u0016J\b\u00104\u001a\u00020&H\u0016J\b\u00105\u001a\u00020&H\u0016J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0014J\u0018\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020&H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010@\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0014J\u0010\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u000208H\u0014J\b\u0010C\u001a\u00020&H\u0014J\u0016\u0010D\u001a\u00020&2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH\u0016J\b\u0010H\u001a\u00020&H\u0016J\b\u0010I\u001a\u00020&H\u0016J\b\u0010J\u001a\u00020&H\u0016J\b\u0010K\u001a\u00020&H\u0016R\u001f\u0010\u0004\u001a\u00060\u0005R\u00020\u00008TX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$View;", "()V", "adapter", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter;", "getAdapter", "()Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "getCategory", "()Lcom/reddit/frontpage/domain/model/SubredditCategory;", "setCategory", "(Lcom/reddit/frontpage/domain/model/SubredditCategory;)V", "listingViewActions", "Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "getListingViewActions", "()Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "setListingViewActions", "(Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;)V", "presenter", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingPresenter;)V", "refresh", "", "visible", "visibleViewBacklog", "", "", "getLayoutId", "getViewModePreference", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "hideLoading", "", "hideLoadingMore", "notifyDiffResult", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "notifyLinkChanged", "position", "notifyLinksInserted", "startPosition", "numItems", "notifyLinksRemoved", "notifyListingChanged", "notifyLoadError", "notifyLoadMoreError", "notifyOffScreen", "notifyOnScreen", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDetach", "onErrorInflated", "inflated", "onInitialize", "setListing", "posts", "", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingLinkPresentationModel;", "showContentListView", "showEmptyListView", "showLoading", "showLoadingMore", "Companion", "OnboardingListingAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingScreen.kt */
public final class OnboardingListingScreen extends LinkListingScreen implements View {
    static final /* synthetic */ KProperty[] f40593v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingListingScreen.class), "adapter", "getAdapter()Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter;"))};
    public static final Companion f40594y = new Companion();
    private boolean f40595M;
    private final List<Integer> f40596N = new ArrayList();
    private final Lazy f40597O = LazyKt.m26777a(new OnboardingListingScreen$adapter$2(this));
    @State
    public SubredditCategory category;
    @Inject
    public OnboardingListingPresenter f40598w;
    @Inject
    public ListingViewActions f40599x;
    private boolean f40600z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$Companion;", "", "()V", "FOOTER_COUNT", "", "newInstance", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "refresh", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static OnboardingListingScreen m23164a(SubredditCategory subredditCategory, boolean z) {
            Intrinsics.m26847b(subredditCategory, "category");
            OnboardingListingScreen onboardingListingScreen = new OnboardingListingScreen();
            Intrinsics.m26847b(subredditCategory, "<set-?>");
            onboardingListingScreen.category = subredditCategory;
            onboardingListingScreen.f40600z = z;
            return onboardingListingScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u000f\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020%2\u0006\u0010#\u001a\u00020\tH\u0014J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\"H\u0014J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u00020\u00102\u0006\u0010!\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0014R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012¨\u00069"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/presentation/listing/common/LoadMoreListingAdapter;", "context", "Landroid/content/Context;", "(Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;Landroid/content/Context;)V", "value", "Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "footer", "getFooter", "()Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "setFooter", "(Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;)V", "footerIndex", "", "getFooterIndex", "()I", "footerState", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "getFooterState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "", "listing", "getListing", "()Ljava/util/List;", "setListing", "(Ljava/util/List;)V", "listingItemCount", "getListingItemCount", "bindViewHolder", "", "holder", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "model", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LoadingFooterViewHolder;", "configure", "viewHolder", "getItem", "position", "getItemCount", "getItemId", "", "getModelPosition", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getSourcePage", "", "getUnadjustedLinkPosition", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "navigateToPostDetail", "linkViewHolder", "Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingListingScreen.kt */
    public final class OnboardingListingAdapter extends CardLinkAdapter implements ListingAdapter<Listable>, LoadMoreListingAdapter {
        List<Listable> f34141a = ((List) new ArrayList());
        final /* synthetic */ OnboardingListingScreen f34142b;
        private LoadingFooterPresentationModel f34143c = new LoadingFooterPresentationModel((FooterState) null, 3);

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
            Intrinsics.m26847b(linkViewHolder, "linkViewHolder");
            Intrinsics.m26847b(link, "link");
        }

        protected final String mo6479f() {
            return "onboarding";
        }

        public final int mo6472h(int i) {
            return i;
        }

        public OnboardingListingAdapter(OnboardingListingScreen onboardingListingScreen, Context context) {
            Intrinsics.m26847b(context, "context");
            this.f34142b = onboardingListingScreen;
            super(context, 17);
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        public final void m34851a(LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterPresentationModel, "value");
            this.f34143c = loadingFooterPresentationModel;
            this.f34141a.set(CollectionsKt__CollectionsKt.m26787a(this.f34141a), this.f34143c);
        }

        public final FooterState F_() {
            return this.f34143c.f34003a;
        }

        public final int mo4927j() {
            return m34849a() - 1;
        }

        public final List<Listable> mo6473i() {
            return this.f34141a;
        }

        public final void mo6470a(List<Listable> list) {
            Intrinsics.m26847b(list, "value");
            list.add(this.f34143c);
            this.f34141a = list;
        }

        public final int mo6471d(ViewHolder viewHolder) {
            Intrinsics.m26847b(viewHolder, "holder");
            return viewHolder.d();
        }

        protected final void mo6464a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder, LinkPresentationModel linkPresentationModel) {
            Intrinsics.m26847b(linkViewHolder, "holder");
            Intrinsics.m26847b(linkPresentationModel, "model");
            super.mo6464a(linkViewHolder, linkPresentationModel);
            LinkHeader M = linkViewHolder.m34771M();
            if (!(M instanceof OnboardingLinkHeaderView)) {
                M = null;
            }
            OnboardingLinkHeaderView onboardingLinkHeaderView = (OnboardingLinkHeaderView) M;
            if (onboardingLinkHeaderView != null) {
                onboardingLinkHeaderView.setSubscribed(SubredditUtil.m23933d(linkPresentationModel.af));
                onboardingLinkHeaderView.setSubscribeClickListener(new C2884xecf034b3(this, linkPresentationModel, linkViewHolder));
                linkViewHolder = this.f34141a.get(linkViewHolder.d());
                if ((linkViewHolder instanceof OnboardingLinkPresentationModel) == null) {
                    linkViewHolder = null;
                }
                OnboardingLinkPresentationModel onboardingLinkPresentationModel = (OnboardingLinkPresentationModel) linkViewHolder;
                if (onboardingLinkPresentationModel != null) {
                    onboardingLinkHeaderView.setSubscriberCount(onboardingLinkPresentationModel.f34115b);
                    Object context = onboardingLinkHeaderView.getContext();
                    Intrinsics.m26843a(context, "view.context");
                    onboardingLinkHeaderView.setCategoryColor(Integer.valueOf(OnboardingUtil.m23161a(context, onboardingLinkPresentationModel.f34116c)));
                }
            }
        }

        protected final void mo6474a(LoadingFooterViewHolder loadingFooterViewHolder, LoadingFooterPresentationModel loadingFooterPresentationModel) {
            Intrinsics.m26847b(loadingFooterViewHolder, "holder");
            Intrinsics.m26847b(loadingFooterPresentationModel, "model");
            super.mo6474a(loadingFooterViewHolder, loadingFooterPresentationModel);
            loadingFooterViewHolder.m34788a((OnClickListener) new C1867x8740eb2b(this));
        }

        protected final RecyclerView mo6490h() {
            return this.f34142b.K == null ? null : this.f34142b.af();
        }

        protected final void mo6463a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder) {
            Intrinsics.m26847b(linkViewHolder, "viewHolder");
            super.mo6463a(linkViewHolder);
            Object obj = linkViewHolder.c;
            Intrinsics.m26843a(obj, "viewHolder.itemView");
            obj.setOnClickListener(new C1868x81ae808a(new OnboardingListingScreen$OnboardingListingAdapter$configure$1(this, linkViewHolder)));
            linkViewHolder.m34771M().setClickListener(new OnboardingListingScreen$OnboardingListingAdapter$configure$2(this, linkViewHolder));
            linkViewHolder.m34780a((Function0) new OnboardingListingScreen$OnboardingListingAdapter$configure$3(this, linkViewHolder));
            linkViewHolder.m34781b((Function0) new OnboardingListingScreen$OnboardingListingAdapter$configure$4(this, linkViewHolder));
            linkViewHolder.f34045r = new OnboardingListingScreen$OnboardingListingAdapter$configure$5(this, linkViewHolder);
            linkViewHolder.m34779a((OnVoteChangeListener) new OnboardingListingScreen$OnboardingListingAdapter$configure$6(this, linkViewHolder));
        }

        public final int mo4926b() {
            return CollectionsKt__CollectionsKt.m26787a(this.f34141a);
        }

        public final Listable mo6476c(int i) {
            Object obj = this.f34141a.get(i);
            if (!(obj instanceof OnboardingLinkPresentationModel)) {
                obj = null;
            }
            OnboardingLinkPresentationModel onboardingLinkPresentationModel = (OnboardingLinkPresentationModel) obj;
            if (onboardingLinkPresentationModel != null) {
                LinkPresentationModel linkPresentationModel = onboardingLinkPresentationModel.f34114a;
                if (linkPresentationModel != null) {
                    return linkPresentationModel;
                }
            }
            return (Listable) this.f34141a.get(i);
        }

        public final long m34850a(int i) {
            return ((Listable) this.f34141a.get(i)).getUniqueID();
        }

        public final int m34849a() {
            return this.f34141a.size();
        }
    }

    protected final OnboardingListingAdapter m42129P() {
        return (OnboardingListingAdapter) this.f40597O.mo5678b();
    }

    public final int mo7141s() {
        return C1761R.layout.onboarding_listing_layout;
    }

    public final /* synthetic */ CardLinkAdapter mo7617M() {
        return m42129P();
    }

    public final OnboardingListingPresenter mo7641w() {
        OnboardingListingPresenter onboardingListingPresenter = this.f40598w;
        if (onboardingListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return onboardingListingPresenter;
    }

    public final void mo7330b(List<OnboardingLinkPresentationModel> list) {
        Intrinsics.m26847b(list, "posts");
        m42129P().mo6470a(CollectionsKt___CollectionsKt.m41428c(list));
    }

    public final void mo7335x() {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4864a((CardLinkAdapter) m42129P());
    }

    public final void mo7328b(int i) {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4860a(i, (CardLinkAdapter) m42129P());
    }

    public final void mo7323a(int i, int i2) {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4859a(i, i2, m42129P());
    }

    public final void mo7322a(int i) {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4867b(i, m42129P());
    }

    public final void mo7336y() {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        LinkListingScreen linkListingScreen = this;
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        String string = am_.getString(C1761R.string.error_network_error);
        Intrinsics.m26843a((Object) string, "activity!!.getString(R.string.error_network_error)");
        listingViewActions.mo4863a(linkListingScreen, string);
    }

    public final void Z_() {
        OnboardingListingAdapter P = m42129P();
        FooterState footerState = FooterState.ERROR;
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        P.m34851a(new LoadingFooterPresentationModel(footerState, am_.getString(C1761R.string.error_network_error)));
        m42129P().d(CollectionsKt__CollectionsKt.m26787a(m42129P().f34141a));
    }

    public final void mo7677a() {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4868b(this);
    }

    public final void mo7678b() {
        ViewsKt.m24109d(am());
    }

    public final void mo7679c() {
        m42129P().m34851a(new LoadingFooterPresentationModel(FooterState.LOADING, 2));
        m42129P().d(CollectionsKt__CollectionsKt.m26787a(m42129P().f34141a));
    }

    public final void mo7680d() {
        m42129P().m34851a(new LoadingFooterPresentationModel(FooterState.NONE, 2));
        m42129P().d(CollectionsKt__CollectionsKt.m26787a(m42129P().f34141a));
    }

    public final void mo7681e() {
        ListingViewActions listingViewActions = this.f40599x;
        if (listingViewActions == null) {
            Intrinsics.m26844a("listingViewActions");
        }
        listingViewActions.mo4861a((LinkListingScreen) this);
        ai().setEnabled(false);
    }

    protected final void mo7142t() {
        super.mo7142t();
        Builder a = DaggerOnboardingListingViewComponent.m29220a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a = a.mo4702a(k);
        SubredditCategory subredditCategory = this.category;
        if (subredditCategory == null) {
            Intrinsics.m26844a("category");
        }
        a.mo4703a(new Parameters(subredditCategory, this.f40600z)).mo4704a((View) this).mo4708b(LazyKt.m26777a(new OnboardingListingScreen$onInitialize$1(this))).mo4706a(LazyKt.m26777a(new OnboardingListingScreen$onInitialize$2(this))).mo4705a("onboarding").mo4707a().mo4709a(this);
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40598w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo7191l();
        view = this.f40598w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        this.I.m24081a();
    }

    public final void mo7191l() {
        super.mo7191l();
        OnboardingListingPresenter onboardingListingPresenter = this.f40598w;
        if (onboardingListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        onboardingListingPresenter.destroy();
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = af();
        LinearLayoutManager ag = ag();
        LoadMoreListingAdapter P = m42129P();
        OnboardingListingPresenter onboardingListingPresenter = this.f40598w;
        if (onboardingListingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.addOnScrollListener((OnScrollListener) new LoadMoreOnScrollListener(ag, P, new OnboardingListingScreen$onCreateView$1(onboardingListingPresenter)));
        af().addOnChildAttachStateChangeListener((OnChildAttachStateChangeListener) new OnboardingListingScreen$onCreateView$listener$1(this));
        layoutInflater = ai();
        layoutInflater.setRefreshing(false);
        layoutInflater.setEnabled(false);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final ListingViewMode ab() {
        return ListingViewMode.f20612a;
    }

    protected final void mo7639f(android.view.View view) {
        Intrinsics.m26847b(view, "inflated");
        super.mo7639f(view);
        view.setOnClickListener(new OnboardingListingScreen$onErrorInflated$1(this));
    }

    public final void aq() {
        super.aq();
        this.f40595M = false;
    }

    public final void ap() {
        super.ap();
        this.f40595M = true;
        CollectionsKt__MutableCollectionsKt.m38197b(this.f40596N, (Function1) new OnboardingListingScreen$notifyOnScreen$1(this));
    }

    public final void mo7324a(ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        viewDiffResult.f20594a.a(m42129P());
    }
}
