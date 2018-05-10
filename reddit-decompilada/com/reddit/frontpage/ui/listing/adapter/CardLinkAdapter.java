package com.reddit.frontpage.ui.listing.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.common.base.Verify;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.ads.NativeAdInfoPresentationModel;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Banner;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.reddit.frontpage.commons.analytics.outboundlinks.OutboundLinkTracker;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics;
import com.reddit.frontpage.presentation.carousel.RedditCarouselActions.SubscribeResult.SubscribeAction;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.options.CarouselOptionsContract.Presenter;
import com.reddit.frontpage.presentation.carousel.options.CarouselOptionsScreen;
import com.reddit.frontpage.presentation.listing.history.HistorySortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LiveUpdateEventPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LoadingFooterPresentationModel;
import com.reddit.frontpage.presentation.listing.model.SortHeaderPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.CrossPostVideoCardLinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.CompactCardLinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.CrossPostCompactCardLinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.CrossPostImageCardLinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.CrossPostLegacyVideoCardLinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.CrossPostSmallCardLinkViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LoadingFooterViewHolder;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LoadingFooterViewHolder.WhenMappings;
import com.reddit.frontpage.presentation.listing.ui.viewholder.SortHeaderViewHolder;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import com.reddit.frontpage.ui.carousel.LargeCarouselViewHolder;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnModQueueCommentSelectedListener;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import com.reddit.frontpage.ui.listing.adapter.ads.AdImpressionCalculator;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.adapter.ads.LegacyAdsNavigator;
import com.reddit.frontpage.ui.listing.newcard.BannerViewHolder;
import com.reddit.frontpage.ui.listing.newcard.BannerViewHolder.Companion;
import com.reddit.frontpage.ui.listing.newcard.BlankAdViewHolder;
import com.reddit.frontpage.ui.listing.newcard.ImageCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder.OnViewMediaListener;
import com.reddit.frontpage.ui.listing.newcard.LiveThreadViewHolder;
import com.reddit.frontpage.ui.listing.newcard.SmallCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.SubmittedVideoLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VideoCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VideoCardLinkViewHolderLegacy;
import com.reddit.frontpage.ui.listing.newcard.VideoCardLinkViewHolderLegacy.CurrentPlayListener;
import com.reddit.frontpage.ui.listing.newcard.XPostCompactCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.XPostImageCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.XPostLegacyVideoCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.XPostSmallCardLinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.XPostVideoCardLinkViewHolder;
import com.reddit.frontpage.ui.promoted.AdViewHolder;
import com.reddit.frontpage.ui.promoted.AppInstallAdViewHolder;
import com.reddit.frontpage.ui.promoted.ContentAdViewHolder;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk21PropertiesKt;
import timber.log.Timber;

public abstract class CardLinkAdapter extends Adapter<ListingViewHolder> implements AccessibleAdapter<Listable> {
    private ModQueueCheckListener<Thing> f29106a;
    private OnModQueueCommentSelectedListener f29107b;
    private FrontpageSettings f29108c;
    public int f29109f = -1;
    public int f29110g = -1;
    public AdVisibilityTracker f29111h;
    final AdImpressionCalculator<Link> f29112i = new AdImpressionCalculator(new CardLinkAdapter$$Lambda$0(this), new CardLinkAdapter$$Lambda$1(this));
    final AdImpressionCalculator<LinkPresentationModel> f29113j = new AdImpressionCalculator(new CardLinkAdapter$$Lambda$2(this), new CardLinkAdapter$$Lambda$3(this));
    protected final Context f29114k;
    @Inject
    LegacyLinkRepository f29115l;
    public OnLinkHiddenListener f29116m;
    CarouselOptionsScreen f29117n;
    public final CompositeDisposable f29118o = new CompositeDisposable();
    private boolean f29119p;
    private CurrentPlayListener f29120q = new C23461(this);
    private final int f29121r;

    public interface OnLinkHiddenListener {
        void mo4978a(LinkViewHolder linkViewHolder);
    }

    class C23461 implements CurrentPlayListener {
        final /* synthetic */ CardLinkAdapter f29103a;

        C23461(CardLinkAdapter cardLinkAdapter) {
            this.f29103a = cardLinkAdapter;
        }

        public final boolean mo4992a() {
            return this.f29103a.f29119p;
        }

        public final void mo4991a(boolean z) {
            this.f29103a.f29119p = z;
        }
    }

    public Listing<Listable> G_() {
        return null;
    }

    public abstract void mo6468a(LinkViewHolder linkViewHolder, Link link);

    public void mo6504a(String str) {
    }

    public Integer a_(ViewHolder viewHolder) {
        return null;
    }

    public void b_(int i) {
    }

    public abstract Listable mo6476c(int i);

    public boolean mo6477c() {
        return false;
    }

    public ListingViewHolder mo6478e(ViewGroup viewGroup) {
        return null;
    }

    public String mo6479f() {
        return null;
    }

    public String mo6508g() {
        return null;
    }

    public RecyclerView mo6490h() {
        return null;
    }

    public final /* synthetic */ ViewHolder m30179a(ViewGroup viewGroup, int i) {
        return m30219c(viewGroup, i);
    }

    public final /* synthetic */ void m30192a(ViewHolder viewHolder) {
        ((ListingViewHolder) viewHolder).mo6493F();
    }

    public final /* synthetic */ void m30193a(ViewHolder viewHolder, int i) {
        ListingViewHolder listingViewHolder = (ListingViewHolder) viewHolder;
        Object obj = null;
        listingViewHolder.c.setTag(538378531, null);
        Listable c = mo6476c(i);
        switch (listingViewHolder.mo6480Q()) {
            case 1:
                if ((c instanceof LiveUpdateEventPresentationModel) != 0) {
                    mo6469a((LiveThreadViewHolder) listingViewHolder, (LiveUpdateEventPresentationModel) c);
                    return;
                } else {
                    mo6503a((LiveThreadViewHolder) listingViewHolder, (LiveThread) c);
                    return;
                }
            case 3:
                mo6467a((BannerViewHolder) listingViewHolder, (Banner) c);
                return;
            case 5:
                mo6466a((SortHeaderViewHolder) listingViewHolder, (SortHeaderPresentationModel) c);
                return;
            case 6:
                mo6474a((LoadingFooterViewHolder) listingViewHolder, (LoadingFooterPresentationModel) c);
                return;
            case 7:
                mo6464a((com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder) listingViewHolder, (LinkPresentationModel) c);
                return;
            case 8:
                mo6475a((CarouselViewHolder) listingViewHolder, (GeneralCarouselCollectionPresentationModel) c);
                return;
            case 9:
                mo6938a((LinkCarouselViewHolder) listingViewHolder, (LinkCarouselCollectionPresentationModel) c);
                return;
            case 11:
                AdViewHolder adViewHolder = (AdViewHolder) listingViewHolder;
                NativeAdInfoPresentationModel nativeAdInfoPresentationModel = (NativeAdInfoPresentationModel) c;
                boolean c2 = mo6477c();
                Intrinsics.m26847b(nativeAdInfoPresentationModel, "adInfo");
                if (adViewHolder.f34426q != nativeAdInfoPresentationModel.c) {
                    adViewHolder.f34425p = nativeAdInfoPresentationModel;
                    adViewHolder.f34426q = nativeAdInfoPresentationModel.c;
                    NativeAd nativeAd = adViewHolder.f34426q;
                    if (nativeAd == null) {
                        Intrinsics.m26842a();
                    }
                    if (!adViewHolder.mo7010b(nativeAd)) {
                        i = -1;
                    }
                    adViewHolder.f34424b = i;
                    i = adViewHolder.f34426q;
                    if (i == 0) {
                        Intrinsics.m26842a();
                    }
                    adViewHolder.mo7009a(i);
                    i = nativeAdInfoPresentationModel.d;
                    if (adViewHolder.m35187x() != null) {
                        i = Float.valueOf(i);
                        if ((((Number) i).floatValue() > 0.0f ? 1 : 0) == 0) {
                            i = 0;
                        }
                        i = i != 0 ? i.floatValue() : 1072986849;
                        ViewGroup x = adViewHolder.m35187x();
                        if (x != null) {
                            obj = x.getLayoutParams();
                        }
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        }
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) obj;
                        marginLayoutParams.width = adViewHolder.f34427r.x;
                        marginLayoutParams.height = (int) (((float) marginLayoutParams.width) / i);
                        i = adViewHolder.m35187x();
                        if (i != 0) {
                            i.setLayoutParams(marginLayoutParams);
                        }
                        i = adViewHolder.m35187x();
                        if (i != 0) {
                            i.requestLayout();
                        }
                    }
                    i = adViewHolder.m35185v();
                    NativeAd nativeAd2 = adViewHolder.f34426q;
                    if (nativeAd2 == null) {
                        Intrinsics.m26842a();
                    }
                    i.setText(adViewHolder.mo7011c(nativeAd2));
                    i = adViewHolder.m35174B();
                    nativeAd2 = adViewHolder.f34426q;
                    if (nativeAd2 == null) {
                        Intrinsics.m26842a();
                    }
                    i.setText(adViewHolder.mo7013e(nativeAd2));
                    i = adViewHolder.m35175C();
                    nativeAd2 = adViewHolder.f34426q;
                    if (nativeAd2 == null) {
                        Intrinsics.m26842a();
                    }
                    i.setText(adViewHolder.mo7014f(nativeAd2));
                    if (adViewHolder.m35173A() != 0) {
                        i = adViewHolder.f34426q;
                        if (i == 0) {
                            Intrinsics.m26842a();
                        }
                        i = adViewHolder.mo7008a(i, c2);
                        if (i != 0) {
                            Object obj2 = adViewHolder.c;
                            Intrinsics.m26843a(obj2, "itemView");
                            i = GlideApp.a(obj2.getContext()).b(i).centerCrop();
                            ImageView A = adViewHolder.m35173A();
                            if (A == null) {
                                Intrinsics.m26842a();
                            }
                            i.into(A);
                            i = adViewHolder.m35173A();
                            if (i != 0) {
                                i.setVisibility(0);
                            }
                        } else {
                            i = adViewHolder.m35173A();
                            if (i != 0) {
                                i.setVisibility(8);
                            }
                        }
                    }
                    if (adViewHolder.m35188y() != 0 && nativeAdInfoPresentationModel.a() == 0) {
                        i = adViewHolder.f34426q;
                        if (i == 0) {
                            Intrinsics.m26842a();
                        }
                        i = adViewHolder.mo7015g(i);
                        if (i != 0) {
                            Object obj3 = adViewHolder.c;
                            Intrinsics.m26843a(obj3, "itemView");
                            i = GlideApp.a(obj3.getContext()).b(i).fitCenter();
                            ImageView y = adViewHolder.m35188y();
                            if (y == null) {
                                Intrinsics.m26842a();
                            }
                            i.into(y);
                            i = adViewHolder.m35188y();
                            if (i != 0) {
                                i.setVisibility(0);
                            }
                        } else {
                            i = adViewHolder.m35188y();
                            if (i != 0) {
                                i.setVisibility(8);
                            }
                        }
                    }
                    if (adViewHolder.m35186w() != 0) {
                        i = adViewHolder.f34426q;
                        if (i == 0) {
                            Intrinsics.m26842a();
                        }
                        i = adViewHolder.mo7012d(i);
                        if (TextUtils.isEmpty(i)) {
                            viewHolder = adViewHolder.m35186w();
                            if (viewHolder != null) {
                                viewHolder.setVisibility(8);
                                return;
                            }
                        }
                        TextView w = adViewHolder.m35186w();
                        if (w != null) {
                            w.setText(i);
                        }
                        viewHolder = adViewHolder.m35186w();
                        if (viewHolder != null) {
                            viewHolder.setVisibility(0);
                        }
                        return;
                    }
                }
                return;
            case 12:
                LegacyCommentViewHolder legacyCommentViewHolder = (LegacyCommentViewHolder) listingViewHolder;
                Comment comment = (Comment) mo6476c(i);
                legacyCommentViewHolder.f34266s = ModUtil.m23823a(comment.getName());
                legacyCommentViewHolder.m34968a(comment);
                return;
            case 13:
                BlankAdViewHolder blankAdViewHolder;
                if ((c instanceof ClientLink) != 0) {
                    blankAdViewHolder = (BlankAdViewHolder) listingViewHolder;
                    Link link = (ClientLink) c;
                    if (this.f29111h == 0) {
                        Timber.e("Blank ad binded when no AdVisibilityTracker was set", new Object[0]);
                        return;
                    } else {
                        m30167a(blankAdViewHolder.c, link);
                        return;
                    }
                } else if ((c instanceof LinkPresentationModel) != 0) {
                    blankAdViewHolder = (BlankAdViewHolder) listingViewHolder;
                    LinkPresentationModel linkPresentationModel = (LinkPresentationModel) c;
                    if (this.f29111h == 0) {
                        Timber.e("Blank ad binded when no AdVisibilityTracker was set", new Object[0]);
                        return;
                    } else {
                        m30168a(blankAdViewHolder.c, linkPresentationModel);
                        return;
                    }
                }
                break;
            case 14:
                mo6465a((SortHeaderViewHolder) listingViewHolder, (HistorySortHeaderPresentationModel) c);
                return;
            default:
                mo6506b((LinkViewHolder) listingViewHolder, (Link) c);
                break;
        }
    }

    public /* synthetic */ Object mo4996g(int i) {
        return mo6476c(i);
    }

    public final void m30202a(ModQueueCheckListener<Thing> modQueueCheckListener, OnModQueueCommentSelectedListener onModQueueCommentSelectedListener) {
        this.f29106a = modQueueCheckListener;
        this.f29107b = onModQueueCommentSelectedListener;
    }

    public final int m30230k() {
        return this.f29110g;
    }

    public final int m30232l() {
        return this.f29109f;
    }

    public final void m30228i(int i) {
        this.f29109f = i;
    }

    public final void m30229j(int i) {
        this.f29110g = i;
    }

    public CardLinkAdapter(Context context, int i) {
        this.f29114k = context;
        this.f29121r = i;
        FrontpageApplication.m28868d().a(this);
        this.f29108c = FrontpageSettings.a();
    }

    public final void m30203a(OnLinkHiddenListener onLinkHiddenListener) {
        this.f29116m = onLinkHiddenListener;
    }

    public void mo6464a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder, LinkPresentationModel linkPresentationModel) {
        linkViewHolder.mo6963a(linkPresentationModel);
        if (!linkPresentationModel.aq) {
            linkViewHolder.c.setTag(538378531, linkPresentationModel.getName());
        }
        if (linkPresentationModel.f33962O) {
            m30168a(linkViewHolder.c, linkPresentationModel);
        } else if (this.f29111h != null) {
            this.f29111h.m23450a(linkViewHolder.c);
        }
    }

    public void mo6466a(SortHeaderViewHolder sortHeaderViewHolder, SortHeaderPresentationModel sortHeaderPresentationModel) {
        Intrinsics.m26847b(sortHeaderPresentationModel, "model");
        Object obj = sortHeaderViewHolder.c;
        Intrinsics.m26843a(obj, "itemView");
        ListingFilterBarView listingFilterBarView = (ListingFilterBarView) obj.findViewById(C1761R.id.listing_filter_bar);
        int a = Sorting.m21805a(sortHeaderPresentationModel.f34005a.toString());
        SortTimeFrame sortTimeFrame = sortHeaderPresentationModel.f34006b;
        listingFilterBarView.m24179a(a, Sorting.m21808b(sortTimeFrame != null ? sortTimeFrame.toString() : null));
        listingFilterBarView.setViewMode(sortHeaderPresentationModel.f34007c);
        sortHeaderPresentationModel = sortHeaderPresentationModel.f34008d;
        if (sortHeaderPresentationModel != null) {
            listingFilterBarView.setGeopopularText(sortHeaderPresentationModel);
        }
    }

    public void mo6465a(SortHeaderViewHolder sortHeaderViewHolder, HistorySortHeaderPresentationModel historySortHeaderPresentationModel) {
        Intrinsics.m26847b(historySortHeaderPresentationModel, "model");
        Object obj = sortHeaderViewHolder.c;
        Intrinsics.m26843a(obj, "itemView");
        ListingFilterBarView listingFilterBarView = (ListingFilterBarView) obj.findViewById(C1761R.id.listing_filter_bar);
        listingFilterBarView.setHistorySort(historySortHeaderPresentationModel.f33927a);
        listingFilterBarView.setViewMode(historySortHeaderPresentationModel.f33928b);
    }

    public void mo6474a(LoadingFooterViewHolder loadingFooterViewHolder, LoadingFooterPresentationModel loadingFooterPresentationModel) {
        Intrinsics.m26847b(loadingFooterPresentationModel, "model");
        switch (WhenMappings.f20846a[loadingFooterPresentationModel.f34003a.ordinal()]) {
            case 1:
                loadingFooterViewHolder.f34053a.m24184b();
                return;
            case 2:
                loadingFooterViewHolder.f34053a.m24182a();
                return;
            case 3:
                loadingFooterViewHolder = loadingFooterViewHolder.f34053a;
                loadingFooterPresentationModel = loadingFooterPresentationModel.f34004b;
                if (loadingFooterPresentationModel == null) {
                    Intrinsics.m26842a();
                }
                loadingFooterViewHolder.m24183a(loadingFooterPresentationModel);
                break;
            default:
                break;
        }
    }

    public void mo6506b(LinkViewHolder linkViewHolder, Link link) {
        linkViewHolder.mo7002a(link);
        linkViewHolder.m35118a(this.f29116m);
        if (link.trackScroll()) {
            linkViewHolder.c.setTag(538378531, link.getName());
        }
        linkViewHolder.m35120a(new CardLinkAdapter$$Lambda$4(this, linkViewHolder, link));
        linkViewHolder.c.setOnClickListener(new CardLinkAdapter$$Lambda$5(this, linkViewHolder, link));
        if (link.isPromoted()) {
            m30167a(linkViewHolder.c, link);
            linkViewHolder.c.setOnClickListener(new CardLinkAdapter$$Lambda$6(this, link, linkViewHolder));
        } else if (this.f29111h != null) {
            this.f29111h.m23450a(linkViewHolder.c);
        }
    }

    final /* synthetic */ void m30194a(Link link, LinkViewHolder linkViewHolder) {
        if (LegacyAdsNavigator.m23458a(link)) {
            LegacyAdsNavigator.m23457a(this.f29114k, link, mo6479f());
            return;
        }
        RedditAdsAnalytics.m22651a(this.f29114k, link, 2);
        mo6468a(linkViewHolder, link);
    }

    public final void m30204a(AdVisibilityTracker adVisibilityTracker) {
        this.f29111h = adVisibilityTracker;
    }

    private void m30167a(View view, Link link) {
        if (this.f29111h != null) {
            this.f29111h.m23451a(view, new CardLinkAdapter$$Lambda$7(this, link));
        }
    }

    private void m30168a(View view, LinkPresentationModel linkPresentationModel) {
        if (this.f29111h != null) {
            this.f29111h.m23451a(view, new CardLinkAdapter$$Lambda$8(this, linkPresentationModel));
        }
    }

    public void mo6467a(BannerViewHolder bannerViewHolder, Banner banner) {
        Intrinsics.m26847b(banner, "banner");
        bannerViewHolder.f34371b.setText(banner.getTitleText());
        bannerViewHolder.f34372p.setText(banner.getTitleTag());
        int i = 8;
        if (banner.getNumVotes() > 0) {
            bannerViewHolder.f34370a.setText(Util.m23959a((int) C1761R.plurals.fmt_number, banner.getNumVotes(), Integer.valueOf(banner.getNumVotes())));
            bannerViewHolder.f34370a.setVisibility(0);
        } else {
            bannerViewHolder.f34370a.setVisibility(8);
        }
        Companion companion = BannerViewHolder.f34369r;
        int a = Companion.m23464b(banner.getBackgroundColor());
        Sdk21PropertiesKt.m28412a(bannerViewHolder.f34372p, a);
        View view = bannerViewHolder.c;
        Intrinsics.m26843a((Object) view, "itemView");
        Sdk21PropertiesKt.m28409a(view, a);
        bannerViewHolder = bannerViewHolder.f34373q;
        if (banner.isShowRightArrow() != null) {
            i = 0;
        }
        bannerViewHolder.setVisibility(i);
    }

    public final int m30211b(int i) {
        i = mo6476c(i);
        boolean c = mo6477c();
        switch (i.getListableType()) {
            case 3:
                return 4;
            case 4:
                return 6;
            case 6:
                return 8;
            case 7:
                return 15;
            case 8:
                return 16;
            case 9:
                return c ? 34 : 32;
            case 10:
                return c ? 35 : 33;
            case 12:
                return 27;
            case 13:
                return 28;
            case 14:
                return 29;
            case 15:
                return 30;
            case 16:
                return 31;
            case 17:
                return 36;
            case 22:
                return 38;
            default:
                int i2 = 1;
                int i3;
                if (i.getListableType() == 11) {
                    LinkPresentationModel linkPresentationModel = (LinkPresentationModel) i;
                    if (linkPresentationModel.f33960M) {
                        return 37;
                    }
                    LinkType linkType;
                    StringBuilder stringBuilder;
                    LinkType linkType2;
                    if (!(this.f29108c.b() || linkPresentationModel.f33998y || (ModUtil.m23824a().m30453a(linkPresentationModel.getName(), linkPresentationModel.f33950C) && this.f29108c.g()))) {
                        if (!linkPresentationModel.f33953F) {
                            i3 = 0;
                            linkType = linkPresentationModel.f33975b;
                            if (linkType == LinkType.CROSSPOST) {
                                i = linkPresentationModel.am;
                                stringBuilder = new StringBuilder("Crosspost is null for ");
                                stringBuilder.append(LinkType.CROSSPOST);
                                linkPresentationModel = (LinkPresentationModel) Verify.a(i, stringBuilder.toString(), new Object[0]);
                                if (c) {
                                    return 22;
                                }
                                if (i3 == 0) {
                                    if (linkPresentationModel.aq) {
                                        return 23;
                                    }
                                    if (linkPresentationModel.ar) {
                                        return 24;
                                    }
                                    if (linkPresentationModel.as != 0) {
                                        return 25;
                                    }
                                }
                                return 26;
                            } else if (c) {
                                return 17;
                            } else {
                                if (i3 == 0) {
                                    linkType2 = linkPresentationModel.f33975b;
                                    if (linkType2 != LinkType.IMAGE) {
                                        if (linkType2 == LinkType.WEBSITE || !linkPresentationModel.f33962O || linkPresentationModel.f33954G == null) {
                                            i2 = 0;
                                        }
                                    }
                                    if (i2 != 0) {
                                        return 18;
                                    }
                                    if (linkType == LinkType.VIDEO) {
                                        return linkPresentationModel.aq == 0 ? 19 : 20;
                                    }
                                }
                                return 21;
                            }
                        }
                    }
                    i3 = 1;
                    linkType = linkPresentationModel.f33975b;
                    if (linkType == LinkType.CROSSPOST) {
                        i = linkPresentationModel.am;
                        stringBuilder = new StringBuilder("Crosspost is null for ");
                        stringBuilder.append(LinkType.CROSSPOST);
                        linkPresentationModel = (LinkPresentationModel) Verify.a(i, stringBuilder.toString(), new Object[0]);
                        if (c) {
                            return 22;
                        }
                        if (i3 == 0) {
                            if (linkPresentationModel.aq) {
                                return 23;
                            }
                            if (linkPresentationModel.ar) {
                                return 24;
                            }
                            if (linkPresentationModel.as != 0) {
                                return 25;
                            }
                        }
                        return 26;
                    } else if (c) {
                        return 17;
                    } else {
                        if (i3 == 0) {
                            linkType2 = linkPresentationModel.f33975b;
                            if (linkType2 != LinkType.IMAGE) {
                                if (linkType2 == LinkType.WEBSITE) {
                                    break;
                                }
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                return 18;
                            }
                            if (linkType == LinkType.VIDEO) {
                                if (linkPresentationModel.aq == 0) {
                                }
                            }
                        }
                        return 21;
                    }
                }
                Link link = (Link) i;
                if (link.isBlankAd()) {
                    return 37;
                }
                int linkType3;
                int linkType4;
                ClientLink clientLink;
                LinkPreview preview;
                if (!(this.f29108c.b() || link.isQuarantined() || (ModUtil.m23824a().m30453a(link.getName(), link.isNsfw()) && this.f29108c.g()))) {
                    if (!link.isSpoiler()) {
                        i3 = 0;
                        linkType3 = link.getLinkType();
                        if (linkType3 == 10) {
                            link = (ClientLink) link.getCrosspostParentList().get(0);
                            if (c) {
                                return 10;
                            }
                            if (i3 == 0) {
                                if (link.isVideo()) {
                                    return 14;
                                }
                                if (Util.m24010c(link)) {
                                    return 13;
                                }
                                if (Util.m24043l(link) != 0) {
                                    return 12;
                                }
                            }
                            return 11;
                        } else if (c) {
                            return 3;
                        } else {
                            if (i3 == 0) {
                                linkType4 = link.getLinkType();
                                if (linkType4 != 4) {
                                    if (linkType4 == 1 || !link.isPromoted() || link.getPreview() == null) {
                                        linkType4 = 0;
                                        if (linkType4 == 0) {
                                            return 1;
                                        }
                                        if (linkType3 == 5) {
                                            if (link instanceof ClientLink) {
                                                clientLink = (ClientLink) link;
                                                if (clientLink.getPreview() != null) {
                                                    preview = clientLink.getPreview();
                                                    if (FrontpageSettings.a().t().c() && preview.getRedditVideoPreview() != null) {
                                                        if (i2 == 0) {
                                                            if (link.isVideo() == 0) {
                                                                return 9;
                                                            }
                                                        }
                                                        return 2;
                                                    }
                                                }
                                            }
                                            i2 = 0;
                                            if (i2 == 0) {
                                                if (link.isVideo() == 0) {
                                                    return 9;
                                                }
                                            }
                                            return 2;
                                        }
                                    }
                                }
                                linkType4 = 1;
                                if (linkType4 == 0) {
                                    return 1;
                                }
                                if (linkType3 == 5) {
                                    if (link instanceof ClientLink) {
                                        clientLink = (ClientLink) link;
                                        if (clientLink.getPreview() != null) {
                                            preview = clientLink.getPreview();
                                            if (i2 == 0) {
                                                if (link.isVideo() == 0) {
                                                    return 9;
                                                }
                                            }
                                            return 2;
                                        }
                                    }
                                    i2 = 0;
                                    if (i2 == 0) {
                                        if (link.isVideo() == 0) {
                                            return 9;
                                        }
                                    }
                                    return 2;
                                }
                            }
                            return 0;
                        }
                    }
                }
                i3 = 1;
                linkType3 = link.getLinkType();
                if (linkType3 == 10) {
                    link = (ClientLink) link.getCrosspostParentList().get(0);
                    if (c) {
                        return 10;
                    }
                    if (i3 == 0) {
                        if (link.isVideo()) {
                            return 14;
                        }
                        if (Util.m24010c(link)) {
                            return 13;
                        }
                        if (Util.m24043l(link) != 0) {
                            return 12;
                        }
                    }
                    return 11;
                } else if (c) {
                    return 3;
                } else {
                    if (i3 == 0) {
                        linkType4 = link.getLinkType();
                        if (linkType4 != 4) {
                            if (linkType4 == 1) {
                                break;
                            }
                            linkType4 = 0;
                            if (linkType4 == 0) {
                                return 1;
                            }
                            if (linkType3 == 5) {
                                if (link instanceof ClientLink) {
                                    clientLink = (ClientLink) link;
                                    if (clientLink.getPreview() != null) {
                                        preview = clientLink.getPreview();
                                        if (i2 == 0) {
                                            if (link.isVideo() == 0) {
                                                return 9;
                                            }
                                        }
                                        return 2;
                                    }
                                }
                                i2 = 0;
                                if (i2 == 0) {
                                    if (link.isVideo() == 0) {
                                        return 9;
                                    }
                                }
                                return 2;
                            }
                        }
                        linkType4 = 1;
                        if (linkType4 == 0) {
                            return 1;
                        }
                        if (linkType3 == 5) {
                            if (link instanceof ClientLink) {
                                clientLink = (ClientLink) link;
                                if (clientLink.getPreview() != null) {
                                    preview = clientLink.getPreview();
                                    if (i2 == 0) {
                                        if (link.isVideo() == 0) {
                                            return 9;
                                        }
                                    }
                                    return 2;
                                }
                            }
                            i2 = 0;
                            if (i2 == 0) {
                                if (link.isVideo() == 0) {
                                    return 9;
                                }
                            }
                            return 2;
                        }
                    }
                    return 0;
                }
        }
    }

    public final boolean m30231k(int i) {
        if (a() > 0 && i >= 0) {
            if (i < a()) {
                i = mo6476c(i);
                if (i.getListableType() == 1) {
                    return ((Link) i).isBlankAd();
                }
                if (i.getListableType() == 11) {
                    return ((LinkPresentationModel) i).f33960M;
                }
                return false;
            }
        }
        return false;
    }

    public final ListingViewHolder m30219c(ViewGroup viewGroup, int i) {
        LinkViewHolder a;
        Consumer cardLinkAdapter$$Lambda$9 = new CardLinkAdapter$$Lambda$9(this);
        com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder = null;
        switch (i) {
            case 0:
                a = SmallCardLinkViewHolder.m37627a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 1:
                a = ImageCardLinkViewHolder.m37622a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 2:
                if (InternalSettings.a().q() == 0) {
                    a = VideoCardLinkViewHolder.m37649a(viewGroup, cardLinkAdapter$$Lambda$9, new CardLinkAdapter$$Lambda$10(this));
                    break;
                }
                a = VideoCardLinkViewHolderLegacy.m37664a(viewGroup);
                ((VideoCardLinkViewHolderLegacy) a).f37309v = this.f29120q;
                break;
            case 4:
                return LiveThreadViewHolder.m35128a(viewGroup);
            case 6:
                return BannerViewHolder.m35106a(viewGroup);
            case 8:
                a = SubmittedVideoLinkViewHolder.m37633a(viewGroup);
                break;
            case 9:
                a = VideoCardLinkViewHolderLegacy.m37665a(viewGroup, cardLinkAdapter$$Lambda$9);
                ((VideoCardLinkViewHolderLegacy) a).f37309v = this.f29120q;
                break;
            case 10:
                a = XPostCompactCardLinkViewHolder.m37671a(viewGroup);
                break;
            case 11:
                a = XPostSmallCardLinkViewHolder.m37694a(viewGroup);
                break;
            case 12:
                a = XPostImageCardLinkViewHolder.m37679a(viewGroup);
                break;
            case 13:
                a = XPostLegacyVideoCardLinkViewHolder.m37686a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 14:
                a = XPostVideoCardLinkViewHolder.m37701a(viewGroup, cardLinkAdapter$$Lambda$9, new CardLinkAdapter$$Lambda$11(this));
                break;
            case 15:
                return SortHeaderViewHolder.m34789a(viewGroup, 5);
            case 16:
                return LoadingFooterViewHolder.m34786a(viewGroup);
            case 17:
                viewGroup = CompactCardLinkViewHolder.m37258a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 18:
                viewGroup = com.reddit.frontpage.presentation.listing.ui.viewholder.ImageCardLinkViewHolder.m37291a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 19:
                if (InternalSettings.a().q() == 0) {
                    viewGroup = com.reddit.frontpage.presentation.listing.ui.viewholder.VideoCardLinkViewHolder.m37306a(viewGroup, cardLinkAdapter$$Lambda$9, new CardLinkAdapter$$Lambda$12(this));
                    break;
                }
                viewGroup = com.reddit.frontpage.presentation.listing.ui.viewholder.VideoCardLinkViewHolderLegacy.m37331a(viewGroup);
                break;
            case 20:
                viewGroup = com.reddit.frontpage.presentation.listing.ui.viewholder.VideoCardLinkViewHolderLegacy.m37332a(viewGroup, cardLinkAdapter$$Lambda$9);
                com.reddit.frontpage.presentation.listing.ui.viewholder.VideoCardLinkViewHolderLegacy videoCardLinkViewHolderLegacy = (com.reddit.frontpage.presentation.listing.ui.viewholder.VideoCardLinkViewHolderLegacy) viewGroup;
                CurrentPlayListener currentPlayListener = this.f29120q;
                Intrinsics.m26847b(currentPlayListener, "<set-?>");
                videoCardLinkViewHolderLegacy.f36954b = currentPlayListener;
                break;
            case 21:
                viewGroup = com.reddit.frontpage.presentation.listing.ui.viewholder.SmallCardLinkViewHolder.m37296a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 22:
                viewGroup = CrossPostCompactCardLinkViewHolder.m37264a(viewGroup);
                break;
            case 23:
                viewGroup = CrossPostVideoCardLinkViewHolder.m37228a(viewGroup, cardLinkAdapter$$Lambda$9, new CardLinkAdapter$$Lambda$13(this));
                break;
            case 24:
                viewGroup = CrossPostLegacyVideoCardLinkViewHolder.m37277a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
            case 25:
                viewGroup = CrossPostImageCardLinkViewHolder.m37270a(viewGroup);
                break;
            case 26:
                viewGroup = CrossPostSmallCardLinkViewHolder.m37286a(viewGroup);
                break;
            case 27:
                return mo6941d(viewGroup);
            case 28:
                return mo6939b(viewGroup);
            case 29:
                return mo6940c(viewGroup);
            case 30:
                return mo6936a(viewGroup);
            case 31:
                return mo6478e(viewGroup);
            case 32:
            case 34:
                return AppInstallAdViewHolder.m37781a(viewGroup, mo6477c());
            case 33:
            case 35:
                return ContentAdViewHolder.m37792a(viewGroup, mo6477c());
            case 36:
                return LegacyCommentViewHolder.m34955a(viewGroup, this.f29106a, this.f29107b);
            case 37:
                return BlankAdViewHolder.m35108a(viewGroup);
            case 38:
                return SortHeaderViewHolder.m34789a(viewGroup, 14);
            default:
                a = com.reddit.frontpage.ui.listing.newcard.CompactCardLinkViewHolder.m37616a(viewGroup, cardLinkAdapter$$Lambda$9);
                break;
        }
        linkViewHolder = viewGroup;
        a = null;
        if (linkViewHolder != null) {
            mo6463a(linkViewHolder);
            return linkViewHolder;
        }
        if (a.mo7005v() == 0) {
            LinkUtil.m23788a(a);
            boolean z = false;
            a.mo7004c((this.f29121r & 8) != 0 ? 1 : 0);
            a.f34385u = (this.f29121r & 4) != 0 ? 1 : 0;
            a.f34384t = (this.f29121r & 2) != 0 ? 1 : 0;
            if ((this.f29121r & 1) != 0) {
                z = true;
            }
            a.f34379b.setDisplaySubredditName(z);
            a.m35119a(new OnViewMediaListener(this) {
                final /* synthetic */ CardLinkAdapter f29105b;

                public final void mo4993a(Link link) {
                    int linkType;
                    LinkUtil.m23786a(link, this.f29105b.f29115l);
                    if (link.isPromoted()) {
                        boolean z;
                        linkType = link.getLinkType();
                        if (linkType != 1) {
                            switch (linkType) {
                                case 3:
                                case 4:
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                        }
                        z = LegacyAdsNavigator.m23457a(this.f29105b.f29114k, link, this.f29105b.mo6479f());
                        if (!z) {
                            RedditAdsAnalytics.m22651a(this.f29105b.f29114k, link, 2);
                        } else {
                            return;
                        }
                    }
                    linkType = link.getLinkType();
                    if (linkType != 1) {
                        if (linkType != 9) {
                            switch (linkType) {
                                case 3:
                                case 4:
                                    LinkPreview preview = link.getPreview();
                                    if (!(preview == null || preview.getSource() == null)) {
                                        Timber.b("Loading image thumbnailView URL: %s", new Object[]{preview.getSourceUrl()});
                                        Context context = a.c.getContext();
                                        context.startActivity(IntentUtil.m23760b(context, link, this.f29105b.mo6479f()));
                                    }
                                    return;
                                case 5:
                                    break;
                                default:
                                    Timber.e("Unexpected link type for viewing media: %d", new Object[]{Integer.valueOf(link.getLinkType())});
                                    return;
                            }
                        }
                        TheaterModeEventBuilder.m21947a("click", (this.f29105b.f29121r & 1) != 0 ? TheaterModeEvents.NOUN_ENTER_SUBREDDIT : TheaterModeEvents.NOUN_ENTER_FEED);
                        IntentUtil.m23757a(this.f29105b.f29114k, link, this.f29105b.mo6479f());
                        return;
                    }
                    m30162d(link);
                }

                public final void mo4994b(Link link) {
                    m30162d(link);
                }

                public final void mo4995c(Link link) {
                    Routing.m22627b(Routing.m22617a(this.f29105b.f29114k), Nav.m22541a(link));
                }

                private void m30162d(Link link) {
                    String str;
                    if (link.getSubredditDetail() != null) {
                        str = link.getSubredditDetail().key_color;
                    } else {
                        str = null;
                    }
                    Util.m23967a(Util.m24014d(this.f29105b.f29114k), Uri.parse(link.getUrl()), Util.m23951a(this.f29105b.f29114k, str), link.getName(), this.f29105b.mo6508g());
                    OutboundLinkTracker.m21950a(link.getUrl(), link, this.f29105b.mo6508g());
                }
            });
        }
        return a;
    }

    public void mo6463a(com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder linkViewHolder) {
        com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder.m34762P();
        LinkUtil.m23787a(linkViewHolder);
        boolean z = false;
        if ((this.f29121r & 16) != 0) {
            linkViewHolder.m34775R();
        } else {
            linkViewHolder.mo6973c((this.f29121r & 8) != 0);
        }
        linkViewHolder.f34049v = (this.f29121r & 4) != 0;
        linkViewHolder.f34048u = (this.f29121r & 2) != 0;
        if ((this.f29121r & 1) != 0) {
            z = true;
        }
        linkViewHolder.m34784d(z);
    }

    public LargeCarouselViewHolder mo6940c(ViewGroup viewGroup) {
        return LargeCarouselViewHolder.m37554a(viewGroup, m30178o(), new CardLinkAdapter$$Lambda$14(this));
    }

    public SmallCarouselViewHolder mo6941d(ViewGroup viewGroup) {
        return SmallCarouselViewHolder.m37570a(viewGroup, m30178o(), new CardLinkAdapter$$Lambda$15(this));
    }

    public SmallCarouselViewHolder mo6939b(ViewGroup viewGroup) {
        return SmallCarouselViewHolder.m37570a(viewGroup, m30178o(), new CardLinkAdapter$$Lambda$16(this));
    }

    public ListingViewHolder mo6936a(ViewGroup viewGroup) {
        return LinkCarouselViewHolder.m34934a(viewGroup, new CardLinkAdapter$$Lambda$17(this));
    }

    final /* synthetic */ Unit m30186a(LinkCarouselViewHolder linkCarouselViewHolder, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel, Set set) {
        m30169a((CarouselCollectionPresentationModel) linkCarouselCollectionPresentationModel, set, a_(linkCarouselViewHolder).intValue(), m30177n(linkCarouselViewHolder.d()));
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30188a(LinkCarouselViewHolder linkCarouselViewHolder, Integer num, LinkCarouselItemPresentationModel linkCarouselItemPresentationModel, Set set) {
        linkCarouselViewHolder.d();
        linkCarouselViewHolder = a_(linkCarouselViewHolder).intValue();
        num.intValue();
        num = m30234m(linkCarouselViewHolder);
        Routing.m22619a(this.f29114k, Nav.m22542a(new ClientLink(linkCarouselItemPresentationModel.f28083l), mo6479f()));
        m30175m().mo4771a(set, linkCarouselViewHolder, num, mo6508g());
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30187a(LinkCarouselViewHolder linkCarouselViewHolder, Integer num, LinkCarouselItemPresentationModel linkCarouselItemPresentationModel) {
        linkCarouselViewHolder.d();
        a_(linkCarouselViewHolder).intValue();
        num.intValue();
        Routing.m22619a(this.f29114k, Nav.m22566b(linkCarouselItemPresentationModel.f28083l.af));
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30189a(Integer num, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel, Set set) {
        num.intValue();
        Routing.m22619a(this.f29114k, Nav.m22566b(((LinkCarouselItemPresentationModel) linkCarouselCollectionPresentationModel.f36374k.get(0)).f28083l.af));
        m30175m().mo4773a(set, linkCarouselCollectionPresentationModel, mo6508g());
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30184a(CarouselViewHolder carouselViewHolder, GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel, Set set) {
        m30169a((CarouselCollectionPresentationModel) generalCarouselCollectionPresentationModel, set, a_(carouselViewHolder).intValue(), m30177n(carouselViewHolder.d()));
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30185a(CarouselViewHolder carouselViewHolder, Integer num, ICarouselItemPresentationModel iCarouselItemPresentationModel, Set set) {
        Screen j;
        carouselViewHolder.d();
        carouselViewHolder = a_(carouselViewHolder).intValue();
        num.intValue();
        num = m30233l(carouselViewHolder);
        if (iCarouselItemPresentationModel.mo6438e()) {
            j = Nav.m22594j(SubredditUtil.m23921b(iCarouselItemPresentationModel.mo6435b()));
        } else {
            j = Nav.m22566b(SubredditUtil.m23912a(iCarouselItemPresentationModel.mo6435b()));
        }
        Routing.m22619a(this.f29114k, j);
        m30175m().mo4771a(set, carouselViewHolder, num, mo6508g());
        return Unit.f25273a;
    }

    private Presenter m30177n(int i) {
        return new CardLinkAdapter$$Lambda$30(this, i);
    }

    final void m30223e(int i, int i2) {
        G_().remove(i2);
        f(i);
        b_(i2);
    }

    static CarouselAnalytics m30175m() {
        return FrontpageApplication.m28875k().mo4616d();
    }

    private static SubredditRepository mo4927j() {
        return FrontpageApplication.m28875k().mo4635w();
    }

    static PostExecutionThread m30176n() {
        return FrontpageApplication.m28875k().mo4633u();
    }

    final void m30190a(int i, Set<String> set) {
        m30175m().mo4776c(set, m30233l(i), mo6508g());
    }

    final void m30210a(boolean z, String str) {
        int intValue;
        Completable g;
        Integer a;
        if (SubredditUtil.m23920a((CharSequence) str)) {
            if (z) {
                a = SubscribeAction.f20332c.mo4785a();
            } else {
                a = SubscribeAction.f20333d.mo4785a();
            }
            intValue = a.intValue();
        } else {
            if (z) {
                a = SubscribeAction.f20330a.mo4785a();
            } else {
                a = SubscribeAction.f20331b.mo4785a();
            }
            intValue = a.intValue();
        }
        mo6504a(Util.m23960a(intValue, str));
        if (z) {
            g = mo4927j().m22506g(str);
        } else {
            g = mo4927j().m22507h(str);
        }
        if (SubredditUtil.m23920a((CharSequence) str)) {
            str = str.replaceFirst("u/", "u_");
        } else {
            str = SubredditUtil.m23912a(str);
        }
        SubredditUtil.m23928b(str, z);
        this.f29118o.mo5631a(g.observeOn(m30176n().a()).onErrorComplete().subscribe());
    }

    private void m30169a(CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, int i, Presenter presenter) {
        this.f29117n = new CarouselOptionsScreen(this.f29114k, presenter, carouselCollectionPresentationModel, set, i);
        this.f29117n.show();
    }

    final GeneralCarouselCollectionPresentationModel<ICarouselItemPresentationModel> m30233l(int i) {
        return (GeneralCarouselCollectionPresentationModel) G_().get(i);
    }

    final LinkCarouselCollectionPresentationModel m30234m(int i) {
        return (LinkCarouselCollectionPresentationModel) G_().get(i);
    }

    public final void m30191a(Bundle bundle) {
        RecyclerView h = mo6490h();
        if (h != null) {
            for (ListingViewHolder b : m30181a((LinearLayoutManager) h.getLayoutManager())) {
                b.mo6496b(bundle);
            }
        }
    }

    public final void m30215b(Bundle bundle) {
        if (mo6490h() != null) {
            ViewsKt.m24102a(mo6490h(), new CardLinkAdapter$$Lambda$32(this, bundle));
        }
    }

    final List<ListingViewHolder> m30181a(LinearLayoutManager linearLayoutManager) {
        List<ListingViewHolder> arrayList = new ArrayList();
        for (int i = 0; i < linearLayoutManager.q(); i++) {
            arrayList.add((ListingViewHolder) mo6490h().getChildViewHolder(linearLayoutManager.e(i)));
        }
        return arrayList;
    }

    private static int m30178o() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public void mo6503a(LiveThreadViewHolder liveThreadViewHolder, LiveThread liveThread) {
        liveThreadViewHolder.title.setText(liveThread.getTitle());
        liveThread = liveThread.getViewerCount();
        liveThreadViewHolder.viewers.setText(liveThreadViewHolder.c.getResources().getQuantityString(C1761R.plurals.fmt_live_viewers, liveThread, new Object[]{Integer.valueOf(liveThread)}));
    }

    public void mo6469a(LiveThreadViewHolder liveThreadViewHolder, LiveUpdateEventPresentationModel liveUpdateEventPresentationModel) {
        liveThreadViewHolder.title.setText(liveUpdateEventPresentationModel.f34001b);
        liveUpdateEventPresentationModel = liveUpdateEventPresentationModel.f34002c;
        liveThreadViewHolder.viewers.setText(liveThreadViewHolder.c.getResources().getQuantityString(C1761R.plurals.fmt_live_viewers, liveUpdateEventPresentationModel, new Object[]{Integer.valueOf(liveUpdateEventPresentationModel)}));
    }

    public void mo6938a(LinkCarouselViewHolder linkCarouselViewHolder, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel) {
        DiscoveryUnit discoveryUnit = linkCarouselCollectionPresentationModel.f36377n;
        Function3 cardLinkAdapter$$Lambda$18 = new CardLinkAdapter$$Lambda$18(this, linkCarouselViewHolder);
        CardLinkAdapter$$Lambda$19 cardLinkAdapter$$Lambda$19 = (discoveryUnit == null || !discoveryUnit.e()) ? null : new CardLinkAdapter$$Lambda$19(this, linkCarouselViewHolder, linkCarouselCollectionPresentationModel);
        linkCarouselViewHolder.m34944a(linkCarouselCollectionPresentationModel, cardLinkAdapter$$Lambda$18, new CardLinkAdapter$$Lambda$20(this, linkCarouselViewHolder), new CardLinkAdapter$$Lambda$21(this, linkCarouselViewHolder), new CardLinkAdapter$$Lambda$22(this), new CardLinkAdapter$$Lambda$23(this), new CardLinkAdapter$$Lambda$24(this, linkCarouselViewHolder), cardLinkAdapter$$Lambda$19);
    }

    public void mo6475a(CarouselViewHolder carouselViewHolder, GeneralCarouselCollectionPresentationModel<ICarouselItemPresentationModel> generalCarouselCollectionPresentationModel) {
        DiscoveryUnit discoveryUnit = generalCarouselCollectionPresentationModel.f36361i;
        CardLinkAdapter$$Lambda$27 cardLinkAdapter$$Lambda$27 = null;
        Function3 cardLinkAdapter$$Lambda$25 = (discoveryUnit == null || !discoveryUnit.d()) ? null : new CardLinkAdapter$$Lambda$25(this, carouselViewHolder);
        Function3 cardLinkAdapter$$Lambda$26 = (discoveryUnit == null || !discoveryUnit.c()) ? null : new CardLinkAdapter$$Lambda$26(this, carouselViewHolder);
        if (discoveryUnit != null && discoveryUnit.e()) {
            cardLinkAdapter$$Lambda$27 = new CardLinkAdapter$$Lambda$27(this, carouselViewHolder, generalCarouselCollectionPresentationModel);
        }
        carouselViewHolder.m34914a(generalCarouselCollectionPresentationModel, cardLinkAdapter$$Lambda$25, cardLinkAdapter$$Lambda$26, new CardLinkAdapter$$Lambda$28(this, carouselViewHolder), new CardLinkAdapter$$Lambda$29(this), cardLinkAdapter$$Lambda$27);
    }

    final /* synthetic */ Unit m30183a(LinkPresentationModel linkPresentationModel) {
        if (this.f29114k != null) {
            RedditAdsAnalytics.m22653a(this.f29114k, linkPresentationModel, 7);
        }
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30214b(LinkPresentationModel linkPresentationModel) {
        if (this.f29114k != null) {
            RedditAdsAnalytics.m22653a(this.f29114k, linkPresentationModel, 1);
        }
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30182a(Link link) {
        if (this.f29114k != null) {
            RedditAdsAnalytics.m22651a(this.f29114k, link, 7);
        }
        return Unit.f25273a;
    }

    final /* synthetic */ Unit m30213b(Link link) {
        if (this.f29114k != null) {
            RedditAdsAnalytics.m22651a(this.f29114k, link, 1);
        }
        return Unit.f25273a;
    }
}
