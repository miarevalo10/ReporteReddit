package com.reddit.frontpage.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.google.common.collect.ImmutableList;
import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentsProvider;
import com.reddit.datalibrary.frontpage.data.provider.CommentsProvider.Callbacks;
import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.job.DeletePostJob.ResultEvent;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.UpdatePostFlairJob;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountPrefs;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Kind;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.SubmitVideoResultEvent;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.ReplyActivityLegacy;
import com.reddit.frontpage.animation.HighlightInAnimator;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.CommentPerformanceEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.listener.AnalyticsOnScrollListener;
import com.reddit.frontpage.commons.analytics.performance.CommentsPerformanceTracker;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.presentation.listing.ui.view.OnboardingLinkHeaderView;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.HasToolbar;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.color.ColorSource;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import com.reddit.frontpage.ui.color.ColorSourceHelper;
import com.reddit.frontpage.ui.detail.OnLinkActionListener.HideLinkActionEvent;
import com.reddit.frontpage.ui.detail.OnLinkActionListener.UnhideLinkActionEvent;
import com.reddit.frontpage.ui.detail.comments.CommentTreeAdapter;
import com.reddit.frontpage.ui.detail.comments.CommentTreeAdapter.CommentAdapterCallbacks;
import com.reddit.frontpage.ui.detail.comments.CommentTreeAdapter.MoreViewHolder;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.HolderCallbacks;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnCommentEditListener;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnReplyListener;
import com.reddit.frontpage.ui.detail.comments.ReplyableTreeNode;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import com.reddit.frontpage.ui.layout.StickyHeaderLinearLayoutManager;
import com.reddit.frontpage.ui.listing.adapter.RecyclerHeaderFooterAdapter;
import com.reddit.frontpage.ui.listing.adapter.ads.AdImpressionCalculator;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen.LinkFlairSelectedListener;
import com.reddit.frontpage.ui.submit.ReplyFragmentLegacy.ReplyEvent;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.GoldUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.ListUtil;
import com.reddit.frontpage.util.ModCacheLinks;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView;
import com.reddit.frontpage.widgets.SubscribeDetailHeaderView;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import de.greenrobot.event.EventBus;
import io.reactivex.Completable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcels;
import timber.log.Timber;

public abstract class BaseDetailScreen extends BaseScreen implements Callbacks, HasToolbar, ColorSource, OnCommentEditListener, OnReplyListener, LinkFlairSelectedListener, ModModeable {
    protected static final Subject<Boolean> f39142P = PublishSubject.create();
    static final List<SortOption<CommentSortType>> f39143V = ImmutableList.a(an, ao, ap, aq, ar, as, at);
    static final List<SortOption<CommentSortType>> f39144W = ImmutableList.a(an, ao, ap, aq, ar, as);
    private static final SortOption an = new SortOption(C1761R.drawable.ic_icon_sort_best, C1761R.string.label_sort_best, CommentSortType.a, false);
    private static final SortOption ao = new SortOption(C1761R.drawable.ic_icon_sort_top, C1761R.string.label_sort_top, CommentSortType.b, false);
    private static final SortOption ap = new SortOption(C1761R.drawable.ic_icon_sort_new, C1761R.string.label_sort_new, CommentSortType.c, false);
    private static final SortOption aq = new SortOption(C1761R.drawable.ic_icon_sort_controversial, C1761R.string.label_sort_controversial, CommentSortType.d, false);
    private static final SortOption ar = new SortOption(C1761R.drawable.ic_icon_sort_recent, C1761R.string.label_sort_old, CommentSortType.e, false);
    private static final SortOption as = new SortOption(C1761R.drawable.ic_icon_sort_qa, C1761R.string.label_sort_qa, CommentSortType.f, false);
    private static final SortOption at = new SortOption(C1761R.drawable.ic_icon_sort_new, C1761R.string.label_sort_live, CommentSortType.g, false);
    public static final int f39145v = ("com.reddit.request_code.reply".hashCode() & 65535);
    public static final int f39146w = ("com.reddit.request_code.edit_comment".hashCode() & 65535);
    public static final int f39147x = ("com.reddit.request_code.edit_link".hashCode() & 65535);
    LinkFooterView f39148A;
    ViewGroup f39149B;
    final ColorSourceHelper f39150C = new ColorSourceHelper();
    FrameLayout f39151D;
    View f39152E;
    protected Link f39153F;
    RecyclerHeaderFooterAdapter f39154G;
    CommentsProvider f39155H;
    String f39156M;
    protected int f39157N;
    protected View f39158O;
    String f39159Q = null;
    String f39160R = "post_detail";
    public AdVisibilityTracker f39161S = null;
    final AdImpressionCalculator<Link> f39162T = new AdImpressionCalculator(new BaseDetailScreen$$Lambda$0(this), new BaseDetailScreen$$Lambda$1(this));
    final PublishSubject<SortSelection<CommentSortType>> f39163U = PublishSubject.create();
    @Inject
    protected LegacyLinkRepository f39164X;
    int f39165Y = 0;
    boolean f39166Z = false;
    private Button aa;
    private View ab;
    private View ac;
    private CommentTreeAdapter ad;
    private boolean ae;
    private String af;
    private String ag;
    private AnalyticsOnScrollListener ah;
    private boolean ai;
    private DetailCommentAdapterCallbacks aj;
    private StickyHeaderLinearLayoutManager ak;
    private boolean al;
    private final CompositeDisposable am = new CompositeDisposable();
    @BindView
    protected AppBarLayout appBarLayout;
    private Disposable au;
    private boolean av = true;
    @BindView
    FrameLayout bottomStickyContainer;
    @BindView
    protected CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView
    protected RecyclerView detailList;
    @BindView
    View loadingSnoo;
    @State
    int replyToPosition = -1;
    @BindView
    View replyView;
    @BindView
    protected SimpleExoPlayerView simpleExoPlayerView;
    @BindView
    protected View speedReadView;
    @BindView
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView
    public Toolbar toolbar;
    @BindView
    protected View toolbarDivider;
    @BindView
    protected ImageView toolbarImageView;
    @BindView
    TextView toolbarTitle;
    @BindView
    FrameLayout topStickyContainer;
    @BindView
    protected FrameLayout videoContainer;
    protected FrameLayout f39167y;
    protected DetailListHeader f39168z;

    class C23262 implements HolderCallbacks {
        final /* synthetic */ BaseDetailScreen f28940a;

        C23262(BaseDetailScreen baseDetailScreen) {
            this.f28940a = baseDetailScreen;
        }

        public final Link mo4956a() {
            return this.f28940a.f39153F;
        }

        public final void mo4957a(ReplyableTreeNode replyableTreeNode) {
            this.f28940a.detailList.smoothScrollToPosition(this.f28940a.f39154G.m35095f() + this.f28940a.f39155H.a(replyableTreeNode));
            CommentsProvider b = this.f28940a.f39155H;
            int a = b.a(replyableTreeNode);
            CollapseTree collapseTree = b.a;
            replyableTreeNode = collapseTree.m23360a(collapseTree.m23369f(replyableTreeNode));
            if (collapseTree.m23368e(replyableTreeNode)) {
                replyableTreeNode = collapseTree.m23366c(replyableTreeNode);
            } else {
                replyableTreeNode = null;
            }
            b.a(a, replyableTreeNode);
        }
    }

    class C23273 extends OnScrollListener {
        final /* synthetic */ BaseDetailScreen f28941a;

        C23273(BaseDetailScreen baseDetailScreen) {
            this.f28941a = baseDetailScreen;
        }

        public final void m29997a(RecyclerView recyclerView, int i, int i2) {
            boolean z = false;
            if (this.f28941a.al && !this.f28941a.m39095Q()) {
                this.f28941a.al = false;
                BaseDetailScreen.f39142P.onNext(Boolean.valueOf(true));
            } else if (!this.f28941a.al && this.f28941a.m39095Q()) {
                this.f28941a.al = true;
            }
            super.a(recyclerView, i, i2);
            recyclerView = this.f28941a.f39155H.sortId == 9 ? 1 : null;
            if (i2 < 0) {
                z = true;
            }
            if (recyclerView != null && r1 && this.f28941a.mo7689b(0) == null) {
                this.f28941a.f39165Y = 0;
                this.f28941a.f39148A.setLiveCommentCount(this.f28941a.f39165Y);
            }
        }

        public final void m29996a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (this.f28941a.appBarLayout != null && this.f28941a.appBarLayout.isAttachedToWindow() != null && i == 0 && this.f28941a.ak.l() == null) {
                this.f28941a.appBarLayout.a(true, true, true);
            }
        }
    }

    class C23284 implements Observer<SortSelection<CommentSortType>> {
        final /* synthetic */ BaseDetailScreen f28942a;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        C23284(BaseDetailScreen baseDetailScreen) {
            this.f28942a = baseDetailScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            SortSelection sortSelection = (SortSelection) obj;
            if (this.f28942a.e) {
                BaseDetailScreen.m39072a(this.f28942a, sortSelection.a);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f28942a.am.mo5631a(disposable);
        }
    }

    public class DetailCommentAdapterCallbacks implements CommentAdapterCallbacks {
        CollapseTree f28946a;
        final /* synthetic */ BaseDetailScreen f28947b;

        public DetailCommentAdapterCallbacks(BaseDetailScreen baseDetailScreen) {
            this.f28947b = baseDetailScreen;
        }

        public final ReplyableTreeNode mo4963a(int i) {
            if (m30000c()) {
                return this.f28946a.m23360a(i);
            }
            return 0;
        }

        public final int mo4962a() {
            if (m30000c()) {
                return this.f28946a.f21186b.size();
            }
            return 0;
        }

        public final void mo4964a(Comment comment) {
            CollapseTree collapseTree = this.f28946a;
            comment = comment.getName();
            Object obj = null;
            Object obj2 = null;
            int i = -1;
            int i2 = i;
            for (int size = collapseTree.f21186b.size() - 1; size >= 0; size--) {
                ReplyableTreeNode replyableTreeNode = (ReplyableTreeNode) collapseTree.f21186b.get(size);
                if (i == -1) {
                    if (replyableTreeNode.f21182a.getName().equals(comment)) {
                        i2 = replyableTreeNode.f21183b;
                        if (i2 == 0) {
                            i = size;
                            obj2 = replyableTreeNode;
                            break;
                        }
                        i = size;
                        obj2 = replyableTreeNode;
                    } else {
                        continue;
                    }
                } else if (replyableTreeNode.f21183b == i2 - 1) {
                    obj = replyableTreeNode;
                    break;
                }
            }
            if (i >= 0) {
                collapseTree.f21186b.remove(i);
                if (obj != null) {
                    List list = (List) collapseTree.f21185a.remove(obj2);
                    List list2 = (List) collapseTree.f21185a.remove(obj);
                    list2.remove(obj2);
                    if (list != null) {
                        list2.addAll(list);
                    }
                    collapseTree.f21185a.put(obj, list2);
                }
            }
        }

        public final void mo4966a(LegacyCommentViewHolder legacyCommentViewHolder, final ReplyableTreeNode replyableTreeNode) {
            legacyCommentViewHolder.c.setOnClickListener(new BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$0(this, replyableTreeNode));
            legacyCommentViewHolder.c.setOnLongClickListener(new BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$1(this, replyableTreeNode));
            if (this.f28947b.f39156M != null) {
                legacyCommentViewHolder.body.setBackgroundColor(ResourcesUtil.m22740i(this.f28947b.am_(), TextUtils.equals(this.f28947b.f39156M, ((Comment) ((CommentWrapper) replyableTreeNode.f21182a).getData()).getId()) ? C1761R.attr.rdt_highlight_color : C1761R.attr.rdt_body_color));
            } else {
                legacyCommentViewHolder.body.setBackground(null);
            }
            legacyCommentViewHolder.f34263p = this.f28947b;
            legacyCommentViewHolder.f34265r = this.f28947b;
            if (this.f28947b.m39101W()) {
                final OnVoteChangeListener a = LinkUtil.m23777a(this.f28947b.am_());
                legacyCommentViewHolder.f34268u = new OnVoteChangeListener(this) {
                    final /* synthetic */ DetailCommentAdapterCallbacks f28945c;

                    public final boolean mo4894a() {
                        return a.mo4894a();
                    }

                    public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
                        a.mo4893a(str, i, adAnalyticsInfo);
                        ((OnboardingEventBuilder) this.f28945c.f28947b.ar().m21893b(replyableTreeNode.f21182a.a(), ThingUtil.a(this.f28945c.f28947b.f39153F.getName(), ThingType.c))).m28959a(Source.COMMENT).m28956a(Action.CLICK).m28954a(i).m21891a();
                    }
                };
            }
        }

        public final void mo4965a(MoreViewHolder moreViewHolder, ReplyableTreeNode replyableTreeNode) {
            moreViewHolder.replyCount.setOnClickListener(new BaseDetailScreen$DetailCommentAdapterCallbacks$$Lambda$2(this, replyableTreeNode, moreViewHolder));
        }

        final /* synthetic */ void m30006a(ReplyableTreeNode replyableTreeNode, MoreViewHolder moreViewHolder) {
            Timber.b("Node is being expanded", new Object[0]);
            this.f28947b.f39155H.b(replyableTreeNode);
            moreViewHolder.replyCount.setText(C1761R.string.label_loading);
            if (this.f28947b.m39101W() != null) {
                ((OnboardingEventBuilder) this.f28947b.ar().m21893b(replyableTreeNode.f21182a.a(), ThingUtil.a(this.f28947b.f39153F.getName(), ThingType.c))).m28959a(Source.COMMENT).m28956a(Action.CLICK).m28957a(Noun.LOAD_MORE_COMMENTS).m21891a();
            }
        }

        public final boolean mo4967b() {
            return !this.f28947b.m39101W();
        }

        private boolean m30000c() {
            if (this.f28946a == null) {
                CollapseTree collapseTree;
                if (this.f28947b.f39155H != null) {
                    collapseTree = this.f28947b.f39155H.a;
                } else {
                    collapseTree = null;
                }
                this.f28946a = collapseTree;
            }
            return this.f28946a != null;
        }
    }

    private class OnboardingVoteChangeListener implements OnVoteChangeListener {
        final /* synthetic */ BaseDetailScreen f28948a;
        private final OnVoteChangeListener f28949b;

        private OnboardingVoteChangeListener(BaseDetailScreen baseDetailScreen, OnVoteChangeListener onVoteChangeListener) {
            this.f28948a = baseDetailScreen;
            this.f28949b = onVoteChangeListener;
        }

        public final boolean mo4894a() {
            return this.f28949b.mo4894a();
        }

        public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
            this.f28949b.mo4893a(str, i, adAnalyticsInfo);
            this.f28948a.ar().m28959a(Source.POST).m28956a(Action.CLICK).m28954a(i).m21891a();
        }
    }

    public abstract void mo7431S();

    public abstract View mo7682T();

    public void mo7685V() {
    }

    final /* synthetic */ void af() {
        ak();
    }

    public void mo7690f(boolean z) {
    }

    public final int mo7141s() {
        return C1761R.layout.screen_base_detail;
    }

    protected BaseDetailScreen(Bundle bundle) {
        super(bundle);
    }

    protected final void mo7142t() {
        super.mo7142t();
        FrontpageApplication.m28868d().a(this);
        this.f39153F = (Link) Parcels.m28673a(this.a.getParcelable("com.reddit.arg.link"));
        if (this.a.getBoolean("com.reddit.arg.mark_read", true)) {
            LinkUtil.m23786a(this.f39153F, this.f39164X);
        }
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = this.a.getBundle("com.reddit.arg.context");
        if (layoutInflater != null) {
            this.f39156M = layoutInflater.getString("comment");
            this.af = layoutInflater.getString("context");
            this.ag = layoutInflater.getString("com.reddit.arg.sourcePage");
            this.f39157N = layoutInflater.getInt("com.reddit.arg.position", -1);
            this.ai = layoutInflater.getBoolean("com.reddit.arg.enableScreenViewEvents", true);
            this.f39155H.a(this.f39156M, this.af);
        }
        BaseActivity baseActivity = (BaseActivity) am_();
        baseActivity.a(this.toolbar);
        baseActivity.c().a().c(false);
        baseActivity.c().a().b(true);
        mo7683a(ResourcesUtil.m22740i(am_(), C1761R.attr.rdt_default_key_color));
        this.appBarLayout.a(new BaseDetailScreen$$Lambda$2(this));
        Util.m23970a(this.swipeRefreshLayout);
        this.swipeRefreshLayout.setOnRefreshListener(new BaseDetailScreen$$Lambda$3(this));
        this.ah = new AnalyticsOnScrollListener(this, getAnalyticsScreenName()) {
            final /* synthetic */ BaseDetailScreen f34240b;

            protected final void mo6461a(ScrollPayload scrollPayload) {
                int computeVerticalScrollRange = this.f34240b.detailList.computeVerticalScrollRange();
                int computeVerticalScrollOffset = this.f34240b.detailList.computeVerticalScrollOffset();
                if (computeVerticalScrollRange != 0) {
                    scrollPayload.scroll_percentage = ((float) computeVerticalScrollOffset) / ((float) computeVerticalScrollRange);
                }
                scrollPayload.sr_name = this.f34240b.f39153F.getSubreddit();
                if (this.f34240b.f39153F.getSubredditDetail() != null) {
                    scrollPayload.sr_id = this.f34240b.f39153F.getSubredditDetail().getId();
                }
                scrollPayload.target_fullname = this.f34240b.f39153F.getName();
                scrollPayload.target_type = this.f34240b.f39153F.isSelf() ? "self" : "link";
            }

            public final void mo6498a(RecyclerView recyclerView, int i, int i2) {
                super.mo6498a(recyclerView, i, i2);
                this.f34240b.mo7691P();
            }
        };
        this.detailList.addOnScrollListener(this.ah);
        this.f39168z = (DetailListHeader) LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_detail_list_header_legacy, this.detailList, false);
        this.f39168z.setOnboardingMode(m39101W());
        viewGroup = SubredditUtil.m23911a(this.f39153F.getSubreddit(), false);
        if (m39101W()) {
            this.toolbarTitle.setText(aq().getName());
            this.toolbarTitle.setVisibility(0);
            OnboardingLinkHeaderView onboardingLinkHeaderView = this.f39168z.getOnboardingLinkHeaderView();
            onboardingLinkHeaderView.setSubscribed(viewGroup.booleanValue());
            onboardingLinkHeaderView.setSubscriberCount(this.a.getString("com.reddit.arg.subscriberCount"));
            onboardingLinkHeaderView.setCategoryColor(Integer.valueOf(OnboardingUtil.m23161a(baseActivity, aq())));
            onboardingLinkHeaderView.setSubscribeClickListener(new BaseDetailScreen$$Lambda$4(this, onboardingLinkHeaderView));
        } else {
            this.f39168z.setModerationEnabledListener(new BaseDetailScreen$$Lambda$5(this));
            boolean isAnonymous = SessionManager.b().c.isAnonymous();
            boolean z = !isAnonymous && SessionManager.b().c.getUsername().equals(this.f39153F.getAuthor());
            SubscribeDetailHeaderView subscribeDetailHeaderView = this.f39168z.getSubscribeDetailHeaderView();
            boolean z2 = !isAnonymous && viewGroup.booleanValue();
            subscribeDetailHeaderView.setSubscribeIcon(Boolean.valueOf(z2));
            DetailListHeader detailListHeader = this.f39168z;
            z = (viewGroup.booleanValue() || z) ? false : true;
            Boolean valueOf = Boolean.valueOf(z);
            if (detailListHeader.f21169b != null) {
                detailListHeader.f21169b.m24150a(valueOf.booleanValue());
                if (valueOf.booleanValue()) {
                    detailListHeader.f21169b.getLayoutParams().height = detailListHeader.f21169b.getSubscribeContainer().getLayoutParams().height;
                }
            }
            if (isAnonymous) {
                viewGroup = new BaseDetailScreen$$Lambda$6(this, isAnonymous);
            } else if (viewGroup.booleanValue() == null) {
                viewGroup = new BaseDetailScreen$$Lambda$7(this, subscribeDetailHeaderView);
            } else {
                viewGroup = new BaseDetailScreen$$Lambda$8(this);
            }
            subscribeDetailHeaderView.getSubscribeContainer().setOnClickListener(viewGroup);
        }
        this.f39167y = this.f39168z.getContentPreviewContainer();
        this.f39149B = this.f39168z.getCommentStackContainer();
        this.f39148A = this.f39168z.getCommentBar();
        this.ak = (StickyHeaderLinearLayoutManager) this.detailList.getLayoutManager();
        this.ak.f34304a = this.f39148A;
        this.ak.f34305b = this.f39149B;
        this.ak.f34306c = this.topStickyContainer;
        this.ak.f34307d = this.bottomStickyContainer;
        viewGroup = LinkUtil.m23777a(am_());
        if (m39101W()) {
            this.f39148A.setOnVoteChangeListener(new OnboardingVoteChangeListener(viewGroup));
        } else {
            this.f39148A.setOnVoteChangeListener(viewGroup);
        }
        this.f39148A.setOnShareListener(new BaseDetailScreen$$Lambda$9(this));
        viewGroup = this.f39148A;
        am_();
        viewGroup.setOnModerateListener(LinkUtil.m23776a());
        this.f39148A.setCommentClickListener(new BaseDetailScreen$$Lambda$10(this));
        this.f39148A.setOnModActionCompletedListener(new BaseDetailScreen$$Lambda$11(this));
        this.replyView.setOnClickListener(new BaseDetailScreen$$Lambda$12(this));
        viewGroup = new C23262(this);
        this.aj = new DetailCommentAdapterCallbacks(this);
        this.ad = new CommentTreeAdapter(this.aj);
        this.ad.f28955a = this.f39153F;
        this.ad.f28956b = viewGroup;
        this.f39154G = new RecyclerHeaderFooterAdapter(this.ad);
        this.f39154G.f34364b = this.f39168z;
        this.f39152E = LayoutInflater.from(am_()).inflate(C1761R.layout.widget_detail_footer, this.detailList, false);
        this.f39151D = (FrameLayout) this.f39152E.findViewById(C1761R.id.show_rest);
        this.aa = (Button) this.f39151D.findViewById(C1761R.id.show_rest_button);
        this.aa.setOnClickListener(new BaseDetailScreen$$Lambda$13(this));
        this.ac = this.f39152E.findViewById(C1761R.id.empty_comments);
        this.ab = this.f39152E.findViewById(C1761R.id.comments_loading);
        this.ab.setBackground(AnimUtil.m23637a(am_()));
        this.f39154G.f34365c = this.f39152E;
        this.detailList.setAdapter(this.f39154G);
        Timber.b("%s header added", new Object[]{this.f39153F.getId()});
        this.f39168z.setViewAllThreadClickListener(new BaseDetailScreen$$Lambda$14(this));
        this.f39168z.setSortBarOnClickListener(new BaseDetailScreen$$Lambda$15(this, baseActivity));
        this.f39163U.subscribeOn(FrontpageApplication.m28875k().mo4632t().a()).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new C23284(this));
        if (Util.m24031g(this.f39153F) != null) {
            if (InternalSettings.a().q() == null) {
                this.K.post(new BaseDetailScreen$$Lambda$16(this));
                this.detailList.addOnScrollListener(new C23273(this));
                this.loadingSnoo.setBackground(AnimUtil.m23637a(am_()));
                this.speedReadView.setOnClickListener(new BaseDetailScreen$$Lambda$17(this));
                if (!(this.f39153F.getSubredditDetail() == null || this.f39153F.getSubredditDetail().user_is_moderator != null || ModUtil.m23831a((Screen) this) == null)) {
                    ModUtil.m23832b();
                }
                return this.K;
            }
        }
        ak();
        this.detailList.addOnScrollListener(new C23273(this));
        this.loadingSnoo.setBackground(AnimUtil.m23637a(am_()));
        this.speedReadView.setOnClickListener(new BaseDetailScreen$$Lambda$17(this));
        ModUtil.m23832b();
        return this.K;
    }

    final /* synthetic */ void ad() {
        mo7684x();
        ag();
        ai();
    }

    final /* synthetic */ Unit m39107a(OnboardingLinkHeaderView onboardingLinkHeaderView) {
        Action action;
        boolean booleanValue = SubredditUtil.m23911a(this.f39153F.getSubreddit(), false).booleanValue();
        Session session;
        if (booleanValue) {
            session = SessionManager.b().c;
            SubredditUtil.m23925b(this.f39153F, (BaseScreen) this);
            action = Action.DESELECT;
        } else {
            session = SessionManager.b().c;
            SubredditUtil.m23916a(this.f39153F, (BaseScreen) this);
            action = Action.SELECT;
        }
        onboardingLinkHeaderView.setSubscribed(booleanValue ^ 1);
        ar().m28959a(Source.POST).m28956a(action).m28957a(Noun.SUBSCRIBE).m21891a();
        return Unit.f25273a;
    }

    final /* synthetic */ void m39123a(String str, Link link) {
        if (m39101W()) {
            ar().m28959a(Source.POST).m28956a(Action.CLICK).m28957a(Noun.SHARE).m21891a();
        } else {
            new ShareEventBuilder().m21941a(ShareEventBuilder.Source.PostDetail).m21939a(ShareEventBuilder.Action.Clicked).m21940a(ShareEventBuilder.Noun.Share).m21938a(link).m21937a(link.getSubredditDetail()).m21944a();
        }
        new ShareEventBuilder().m21941a(ShareEventBuilder.Source.PostShareComplete).m21939a(ShareEventBuilder.Action.ShareComplete).m21940a(ShareEventBuilder.Noun.ShareSuccess).m21938a(link).m21937a(link.getSubredditDetail()).m21945b();
        mo7685V();
        LinkUtil.m23780a(am_(), str);
    }

    final /* synthetic */ void ac() {
        ai();
    }

    final /* synthetic */ void ab() {
        SessionManager b = SessionManager.b();
        if (b.c.isAnonymous()) {
            SessionManager.b().a(Util.m24019e(am_()), true);
        } else if (AccountUtil.a(b)) {
            RedditAlertDialog.m23312a(am_()).m23323a();
        } else {
            mo7685V();
            this.replyToPosition = 0;
            Intent intent = new Intent(am_(), ReplyActivityLegacy.class);
            intent.putExtra("wrapper", Parcels.m28672a(this.f39153F));
            a(intent, f39145v);
        }
    }

    final /* synthetic */ void aa() {
        ap();
    }

    final /* synthetic */ void m39104Z() {
        ap();
    }

    protected final void mo7185a(ActionBar actionBar) {
        super.mo7185a(actionBar);
        actionBar.c(false);
    }

    public final void mo6987a(View view) {
        super.mo6987a(view);
        mo7684x();
        this.f39155H.c();
    }

    public void mo6992b(View view) {
        super.mo6992b(view);
        this.f39155H.d = this;
        n();
        Runnable baseDetailScreen$$Lambda$18 = new BaseDetailScreen$$Lambda$18(this, view);
        if (this.f39155H.sortId != 9) {
            if (!this.a.getBoolean("com.reddit.arg.immediate_view", true)) {
                view.postDelayed(baseDetailScreen$$Lambda$18, 500);
                if (this.f39161S != null) {
                    this.f39161S.m23451a(this.f39168z, new BaseDetailScreen$$Lambda$19(this));
                }
            }
        }
        baseDetailScreen$$Lambda$18.run();
        if (this.f39161S != null) {
            this.f39161S.m23451a(this.f39168z, new BaseDetailScreen$$Lambda$19(this));
        }
    }

    public void mo7209b(Activity activity) {
        super.mo7209b(activity);
        m39093O();
    }

    final void m39093O() {
        if (this.f39148A != null && this.ad != null) {
            this.f39148A.m24175a(this.f39153F);
            this.ad.a_.b();
        }
    }

    public void mo6993c(View view) {
        super.mo6993c(view);
        this.f39155H.d = null;
        if (this.au != null) {
            this.au.mo5626a();
        }
        if (this.am != null) {
            this.am.m32077c();
        }
        if (this.f39161S != null) {
            this.f39161S.m23450a(this.f39168z);
        }
    }

    protected final boolean mo7210c(Screen screen) {
        return screen instanceof OnLinkActionListener;
    }

    protected final boolean m39095Q() {
        if (this.detailList == null || ((LinearLayoutManager) this.detailList.getLayoutManager()).k() != 0) {
            return false;
        }
        return true;
    }

    private boolean mo7689b(int i) {
        i += this.f39154G.m35095f();
        if (this.ak.k() < i) {
            return false;
        }
        if (this.ak.k() > i) {
            return true;
        }
        return (this.ak.k() == i) && this.ak.a(i).getTop() < 0;
    }

    private void mo7684x() {
        if (this.ah != null) {
            this.ah.mo6460a(this.detailList);
        }
    }

    private void mo6971y() {
        this.ab.setVisibility(0);
        this.ac.setVisibility(8);
    }

    private void ag() {
        mo6971y();
        int b = this.f39155H.b();
        this.f39155H.a();
        this.aj.f28946a = null;
        this.f39154G.d(this.f39154G.m35095f(), b);
    }

    private void ah() {
        if (this.swipeRefreshLayout.b) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
        this.ab.setVisibility(8);
        this.aj.f28946a = null;
        if (this.f39155H.b() == 0) {
            this.ac.setVisibility(0);
        } else {
            this.ac.setVisibility(8);
            if (this.f39156M != null) {
                m39124a(this.f39156M, false, true);
                this.f39168z.post(new BaseDetailScreen$$Lambda$20(this));
            } else {
                this.f39151D.setVisibility(8);
            }
        }
        aj();
    }

    final /* synthetic */ void m39103Y() {
        DetailListHeader detailListHeader = this.f39168z;
        detailListHeader.sortBarContainer.setVisibility(8);
        detailListHeader.singleCommentThreadContainer.setVisibility(0);
    }

    private void ai() {
        this.f39168z.m23338a(this.f39153F);
    }

    final SortOption<CommentSortType> m39134d(boolean z) {
        int al = al();
        if (al == 8) {
            return (SortOption) f39143V.get(0);
        }
        if (al == 3) {
            return (SortOption) f39143V.get(1);
        }
        if (al == 1) {
            return (SortOption) f39143V.get(2);
        }
        if (al == 6) {
            return (SortOption) f39143V.get(3);
        }
        if (al == 7) {
            return (SortOption) f39143V.get(4);
        }
        if (al == 5) {
            return (SortOption) f39143V.get(5);
        }
        if (al == 9 && z) {
            return (SortOption) f39143V.get(6);
        }
        return (SortOption) f39143V.get(0);
    }

    final SortOption<CommentSortType> m39135e(boolean z) {
        int i = this.f39155H.sortId;
        for (SortOption<CommentSortType> sortOption : f39143V) {
            if (SortingsLegacyMapper.a((CommentSortType) sortOption.f20414c) == i) {
                return sortOption;
            }
        }
        return m39134d(z);
    }

    public final void m39096R() {
        if (this.f39153F != null && this.f39153F.isPromoted()) {
            RedditAdsAnalytics.m22651a(am_(), this.f39153F, 3);
        }
    }

    public void mo7683a(int i) {
        if (this.toolbar != null) {
            this.toolbar.setBackgroundColor(i);
        }
    }

    public final void m39121a(AdVisibilityTracker adVisibilityTracker) {
        this.f39161S = adVisibilityTracker;
    }

    private void aj() {
        int i;
        View view = this.speedReadView;
        CommentsProvider commentsProvider = this.f39155H;
        int i2 = 0;
        if (commentsProvider.a == null) {
            i = 0;
        } else {
            Iterator it = commentsProvider.a.f21186b.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((ReplyableTreeNode) it.next()).f21183b == 0) {
                    i++;
                }
            }
        }
        if (i <= 1) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    private void ak() {
        if (am_() != null) {
            int parseColor;
            boolean z;
            boolean z2;
            DetailListHeader detailListHeader;
            View view;
            ModCacheLinks a;
            ModCacheLinks a2;
            boolean value;
            ThemeOption themeOption = ((RedditThemedActivity) am_()).f40551f;
            if (themeOption != ThemeOption.f20981c) {
                if (themeOption != ThemeOption.f20984f) {
                    if (this.toolbarDivider != null) {
                        this.toolbarDivider.setVisibility(8);
                    }
                    if (!m39101W() || aq() == null) {
                        if (this.f39153F.getSubredditDetail() != null) {
                            if (!TextUtils.isEmpty(this.f39153F.getSubredditDetail().key_color)) {
                                parseColor = Color.parseColor(this.f39153F.getSubredditDetail().key_color);
                                mo4951a(Integer.valueOf(parseColor));
                                mo7683a(parseColor);
                                this.aa.getBackground().setColorFilter(parseColor, Mode.MULTIPLY);
                                ai();
                                this.f39158O = mo7682T();
                                z = true;
                                z2 = this.detailList == null && this.detailList.isNestedScrollingEnabled();
                                if (z2) {
                                    mo4953b(this.f39150C.f28924a);
                                }
                                this.f39148A.m24175a(this.f39153F);
                                if (this.f39158O != null && this.f39158O.getParent() == null) {
                                    detailListHeader = this.f39168z;
                                    view = this.f39158O;
                                    if (view != null) {
                                        detailListHeader.contentPreviewContainer.addView(view);
                                    }
                                }
                                if (FrontpageSettings.a().d()) {
                                    ContextCompat.c(am_(), C1761R.color.rdt_black);
                                }
                                a = ModUtil.m23824a();
                                z2 = a.getValue(a.f29390d, this.f39153F.getName(), Boolean.valueOf(false));
                                a2 = ModUtil.m23824a();
                                value = a2.getValue(a2.f29391e, this.f39153F.getName(), Boolean.valueOf(false));
                                if (z2 || value) {
                                    z = false;
                                }
                                this.ae = z;
                                if (this.replyView != null) {
                                    this.replyView.setVisibility(this.f39153F.isArchived() ? 8 : 0);
                                }
                                if (this.loadingSnoo != null) {
                                    this.loadingSnoo.setVisibility(8);
                                }
                                if (this.detailList != null) {
                                    this.detailList.setVisibility(0);
                                }
                                if (this.f39149B != null) {
                                    this.f39149B.setVisibility(0);
                                }
                            }
                        }
                        parseColor = ResourcesUtil.m22740i(am_(), C1761R.attr.rdt_default_key_color);
                        mo4951a(Integer.valueOf(parseColor));
                        mo7683a(parseColor);
                        this.aa.getBackground().setColorFilter(parseColor, Mode.MULTIPLY);
                        ai();
                        this.f39158O = mo7682T();
                        z = true;
                        if (this.detailList == null) {
                        }
                        if (z2) {
                            mo4953b(this.f39150C.f28924a);
                        }
                        this.f39148A.m24175a(this.f39153F);
                        detailListHeader = this.f39168z;
                        view = this.f39158O;
                        if (view != null) {
                            detailListHeader.contentPreviewContainer.addView(view);
                        }
                        if (FrontpageSettings.a().d()) {
                            ContextCompat.c(am_(), C1761R.color.rdt_black);
                        }
                        a = ModUtil.m23824a();
                        z2 = a.getValue(a.f29390d, this.f39153F.getName(), Boolean.valueOf(false));
                        a2 = ModUtil.m23824a();
                        value = a2.getValue(a2.f29391e, this.f39153F.getName(), Boolean.valueOf(false));
                        if (z2) {
                        }
                        z = false;
                        this.ae = z;
                        if (this.replyView != null) {
                            if (this.f39153F.isArchived()) {
                            }
                            this.replyView.setVisibility(this.f39153F.isArchived() ? 8 : 0);
                        }
                        if (this.loadingSnoo != null) {
                            this.loadingSnoo.setVisibility(8);
                        }
                        if (this.detailList != null) {
                            this.detailList.setVisibility(0);
                        }
                        if (this.f39149B != null) {
                            this.f39149B.setVisibility(0);
                        }
                    }
                    parseColor = OnboardingUtil.m23161a(am_(), aq());
                    mo4951a(Integer.valueOf(parseColor));
                    mo7683a(parseColor);
                    this.aa.getBackground().setColorFilter(parseColor, Mode.MULTIPLY);
                    ai();
                    this.f39158O = mo7682T();
                    z = true;
                    if (this.detailList == null) {
                    }
                    if (z2) {
                        mo4953b(this.f39150C.f28924a);
                    }
                    this.f39148A.m24175a(this.f39153F);
                    detailListHeader = this.f39168z;
                    view = this.f39158O;
                    if (view != null) {
                        detailListHeader.contentPreviewContainer.addView(view);
                    }
                    if (FrontpageSettings.a().d()) {
                        ContextCompat.c(am_(), C1761R.color.rdt_black);
                    }
                    a = ModUtil.m23824a();
                    z2 = a.getValue(a.f29390d, this.f39153F.getName(), Boolean.valueOf(false));
                    a2 = ModUtil.m23824a();
                    value = a2.getValue(a2.f29391e, this.f39153F.getName(), Boolean.valueOf(false));
                    if (z2) {
                    }
                    z = false;
                    this.ae = z;
                    if (this.replyView != null) {
                        if (this.f39153F.isArchived()) {
                        }
                        this.replyView.setVisibility(this.f39153F.isArchived() ? 8 : 0);
                    }
                    if (this.loadingSnoo != null) {
                        this.loadingSnoo.setVisibility(8);
                    }
                    if (this.detailList != null) {
                        this.detailList.setVisibility(0);
                    }
                    if (this.f39149B != null) {
                        this.f39149B.setVisibility(0);
                    }
                }
            }
            parseColor = ResourcesUtil.m22740i(am_(), C1761R.attr.rdt_body_color);
            mo4951a(Integer.valueOf(parseColor));
            mo7683a(parseColor);
            this.aa.getBackground().setColorFilter(parseColor, Mode.MULTIPLY);
            ai();
            this.f39158O = mo7682T();
            z = true;
            if (this.detailList == null) {
            }
            if (z2) {
                mo4953b(this.f39150C.f28924a);
            }
            this.f39148A.m24175a(this.f39153F);
            detailListHeader = this.f39168z;
            view = this.f39158O;
            if (view != null) {
                detailListHeader.contentPreviewContainer.addView(view);
            }
            if (FrontpageSettings.a().d()) {
                ContextCompat.c(am_(), C1761R.color.rdt_black);
            }
            a = ModUtil.m23824a();
            z2 = a.getValue(a.f29390d, this.f39153F.getName(), Boolean.valueOf(false));
            a2 = ModUtil.m23824a();
            value = a2.getValue(a2.f29391e, this.f39153F.getName(), Boolean.valueOf(false));
            if (z2) {
            }
            z = false;
            this.ae = z;
            if (this.replyView != null) {
                if (this.f39153F.isArchived()) {
                }
                this.replyView.setVisibility(this.f39153F.isArchived() ? 8 : 0);
            }
            if (this.loadingSnoo != null) {
                this.loadingSnoo.setVisibility(8);
            }
            if (this.detailList != null) {
                this.detailList.setVisibility(0);
            }
            if (this.f39149B != null) {
                this.f39149B.setVisibility(0);
            }
        }
    }

    protected final void mo7144v() {
        int al = al();
        an();
        ProviderManager providerManager = ProviderManager.b;
        String str = this.l;
        Link link = this.f39153F;
        Intrinsics.m26847b(str, "ownerId");
        Intrinsics.m26847b(link, "link");
        BaseOtherProvider baseOtherProvider = (BaseOtherProvider) ProviderManager.b().get(str);
        if (baseOtherProvider == null) {
            baseOtherProvider = new CommentsProvider(link, al);
            ProviderManager.b().put(str, baseOtherProvider);
        }
        this.f39155H = (CommentsProvider) baseOtherProvider;
        this.f39155H.a(this.f39156M, this.af);
        m37523a(this.f39155H);
    }

    private int al() {
        String suggestedSort;
        AccountPrefs accountPrefs = UserSettingsStorage.a().a(SessionManager.b().c).a;
        if (accountPrefs == null || !accountPrefs.ignore_suggested_sort) {
            suggestedSort = this.f39153F.getSuggestedSort();
            if (TextUtils.isEmpty(suggestedSort)) {
                suggestedSort = "confidence";
            }
        } else {
            suggestedSort = accountPrefs.default_comment_sort;
        }
        if (TextUtils.equals(suggestedSort, "new") && FrontpageSettings.a().t().b()) {
            suggestedSort = Kind.LIVE;
        }
        return Sorting.m21805a(suggestedSort);
    }

    protected final Link m39099U() {
        return this.f39153F;
    }

    public final Toolbar mo7208b() {
        return this.toolbar;
    }

    public final void m39115a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        if (!m39101W()) {
            Session session = SessionManager.b().c;
            boolean ao = ao();
            menuInflater.inflate(C1761R.menu.menu_detail, menu);
            if (!session.isAnonymous()) {
                menuInflater.inflate(ao ? C1761R.menu.menu_detail_author : C1761R.menu.menu_detail_viewer, menu);
                if (this.f39153F != null) {
                    menu = menu.findItem(C1761R.id.action_edit_link);
                    menuInflater = (this.f39153F.isSelf() == null || !ao) ? null : true;
                    if (menu != null) {
                        menu.setVisible(menuInflater);
                    }
                }
            }
        }
    }

    public final void m39114a(Menu menu) {
        super.a(menu);
        boolean z = false;
        int i = (ao() && this.f39153F.getSubredditDetail() != null && this.f39153F.getSubredditDetail().user_is_moderator) ? 1 : false;
        Timber.b("updating bookmark icon state; isSaved: %s", new Object[]{Boolean.valueOf(this.ae)});
        m39077b(menu.findItem(C1761R.id.action_save));
        MenuItem findItem = menu.findItem(C1761R.id.action_share);
        if (findItem != null) {
            boolean z2 = this.f39153F.getSubredditDetail() != null && this.f39153F.getSubredditDetail().user_is_moderator;
            findItem.setVisible(z2);
        }
        findItem = menu.findItem(C1761R.id.action_add_flair);
        MenuItem findItem2 = menu.findItem(C1761R.id.action_change_flair);
        boolean isEmpty = TextUtils.isEmpty(this.f39153F.getLinkFlairText()) ^ true;
        if (findItem != null) {
            findItem.setVisible(!isEmpty);
        }
        if (findItem2 != null) {
            findItem2.setVisible(isEmpty);
        }
        findItem = menu.findItem(C1761R.id.action_hide);
        findItem2 = menu.findItem(C1761R.id.action_unhide);
        if (findItem != null) {
            findItem.setVisible(this.f39153F.isHidden() ^ true);
        }
        if (findItem2 != null) {
            findItem2.setVisible(this.f39153F.isHidden());
        }
        findItem = menu.findItem(C1761R.id.action_mark_nsfw);
        findItem2 = menu.findItem(C1761R.id.action_unmark_nsfw);
        if (findItem != null) {
            isEmpty = !this.f39153F.isNsfw() && i == 0;
            findItem.setVisible(isEmpty);
        }
        if (findItem2 != null) {
            boolean z3 = this.f39153F.isNsfw() && i == 0;
            findItem2.setVisible(z3);
        }
        findItem = menu.findItem(C1761R.id.action_mark_spoiler);
        findItem2 = menu.findItem(C1761R.id.action_unmark_spoiler);
        if (findItem != null) {
            isEmpty = !this.f39153F.isSpoiler() && i == 0;
            findItem.setVisible(isEmpty);
        }
        if (findItem2 != null) {
            boolean z4 = this.f39153F.isSpoiler() && i == 0;
            findItem2.setVisible(z4);
        }
        menu = menu.findItem(C1761R.id.action_give_gold);
        if (menu != null) {
            if (GoldUtil.m23705a() > 0) {
                z = true;
            }
            menu.setVisible(z);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        SessionManager b = SessionManager.b();
        Session session = b.c;
        switch (itemId) {
            case C1761R.id.action_add_flair:
            case C1761R.id.action_change_flair:
                if (this.au != null && this.au.mo5627b() == null) {
                    this.au.mo5626a();
                }
                menuItem = new FlairProvider();
                this.au = FlairProvider.a(this.f39153F.getSubreddit()).observeOn(SchedulerProvider.m23887c()).subscribe(new BaseDetailScreen$$Lambda$21(this), BaseDetailScreen$$Lambda$22.f28936a);
                return true;
            case C1761R.id.action_delete:
                RedditAlertDialog.m23316a(am_(), new BaseDetailScreen$$Lambda$24(this, this.f39153F, session)).m23323a();
                return true;
            case C1761R.id.action_edit_link:
                a(IntentUtil.m23742a(am_(), this.f39153F), f39147x);
                return true;
            case C1761R.id.action_give_gold:
                RedditAlertDialog.m23313a(am_(), GoldUtil.m23705a(), new BaseDetailScreen$$Lambda$23(this)).m23323a();
                return true;
            case C1761R.id.action_hide:
                menuItem = this.f39153F;
                ClickEventBuilder a = AppAnalytics.m21858b().m21823a(this.j);
                a.f19955b = "post_hide";
                a.m21825a();
                LinkUtil.m23800d(menuItem.getName());
                EventBus.getDefault().postSticky(new HideLinkActionEvent(this.f39157N));
                menuItem = am();
                if (menuItem != null) {
                    menuItem.mo7147y();
                }
                return true;
            case C1761R.id.action_mark_nsfw:
                LinkUtil.m23797c(session, this.f39153F.getName());
                return true;
            case C1761R.id.action_mark_spoiler:
                LinkUtil.m23801e(session, this.f39153F.getName());
                return true;
            case C1761R.id.action_report:
                if (AccountUtil.a(b) != null) {
                    RedditAlertDialog.m23312a(am_()).m23323a();
                } else {
                    RedditAlertDialog.m23310a(this.f39153F.getAuthor(), am_().getString(C1761R.string.action_report_post), am_(), this.f39153F, this.f39153F, null).m29514c();
                }
                return true;
            case C1761R.id.action_save:
                String str = this.ae ? "post_unsave" : "post_save";
                ClickEventBuilder b2 = AppAnalytics.m21858b();
                b2.f19954a = getAnalyticsScreenName();
                b2.f19955b = str;
                b2.f19956c = this.f39153F.getUrl();
                b2.f19957d = this.f39153F.getName();
                b2.f19959f = this.f39153F.getDomain();
                b2.m21825a();
                if (b.c.isAnonymous()) {
                    SessionManager.b().a(Util.m24019e(am_()), true);
                } else {
                    this.ae ^= true;
                    m39077b(menuItem);
                    if (this.ae != null) {
                        LinkUtil.m23782a(session, this.f39153F.getName());
                        ModUtil.m23824a().m30460e(this.f39153F.getName(), Boolean.valueOf(true));
                        ModUtil.m23824a().m30461f(this.f39153F.getName(), Boolean.valueOf(false));
                    } else {
                        LinkUtil.m23792b(session, this.f39153F.getName());
                        ModUtil.m23824a().m30461f(this.f39153F.getName(), Boolean.valueOf(true));
                        ModUtil.m23824a().m30460e(this.f39153F.getName(), Boolean.valueOf(false));
                    }
                }
                return true;
            case C1761R.id.action_share:
                mo7685V();
                LinkUtil.m23779a(am_(), this.f39153F);
                return true;
            case C1761R.id.action_unhide:
                LinkUtil.m23802e(this.f39153F.getName());
                EventBus.getDefault().postSticky(new UnhideLinkActionEvent(this.f39157N));
                menuItem = am();
                if (menuItem != null) {
                    menuItem.q_();
                }
                return true;
            case C1761R.id.action_unmark_nsfw:
                LinkUtil.m23799d(session, this.f39153F.getName());
                return true;
            case C1761R.id.action_unmark_spoiler:
                LinkUtil.m23803f(session, this.f39153F.getName());
                return true;
            default:
                return super.mo7201a(menuItem);
        }
    }

    final /* synthetic */ Unit m39102X() {
        GoldUtil.m23707b(this.f39153F.getName(), this.f39153F.getGilded());
        ai();
        return Unit.f25273a;
    }

    public void onEventMainThread(SubmitVideoResultEvent submitVideoResultEvent) {
        this.f39159Q = submitVideoResultEvent.requestId;
    }

    private OnLinkActionListener am() {
        return (mo7220H() == null || !(mo7220H() instanceof OnLinkActionListener)) ? null : (OnLinkActionListener) mo7220H();
    }

    public String getAnalyticsScreenName() {
        return m39101W() ? PageType.POST_DETAIL.value : "post_detail";
    }

    public String getAnalyticsPageType() {
        if (m39101W()) {
            return PageType.POST_DETAIL.value;
        }
        return this.f39160R;
    }

    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        AnalyticsHeartbeatParams analyticsHeartbeatParams = super.getAnalyticsHeartbeatParams();
        if (!(this.f39153F.getSubredditDetail() == null || this.f39153F.getSubredditDetail().getName() == null || this.f39153F.getSubredditDetail().display_name == null)) {
            analyticsHeartbeatParams.m21905a(this.f39153F.getSubredditDetail().getName(), this.f39153F.getSubredditDetail().display_name);
        }
        return analyticsHeartbeatParams;
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        String name;
        String str;
        ScreenviewEventBuilder analyticsScreenviewEvent = super.getAnalyticsScreenviewEvent();
        if (this.f39153F.getSubredditDetail() != null) {
            name = this.f39153F.getSubredditDetail().getName();
            str = this.f39153F.getSubredditDetail().display_name;
            if (!(name == null || str == null)) {
                analyticsScreenviewEvent.m21929a(name, str);
            }
        }
        analyticsScreenviewEvent.m21928a(this.f39153F.getName(), AppAnalytics.m21848a(this.f39153F.getLinkType()), this.f39153F.getTitle(), Boolean.valueOf(this.f39153F.isOver18()), Boolean.valueOf(this.f39153F.isSpoiler()), this.f39153F.getUrl(), this.f39153F.getDomain(), Long.valueOf(this.f39153F.getCreatedUtc()));
        if (!(this.f39156M == null || this.f39155H.a == null)) {
            int a = this.f39155H.a(this.f39156M);
            if (a >= 0) {
                CommentWrapper commentWrapper = (CommentWrapper) this.f39155H.a(a).f21182a;
                str = this.f39156M;
                name = ((Comment) commentWrapper.getData()).c();
                Intrinsics.m26847b(str, "id");
                Intrinsics.m26847b(name, "authorId");
                analyticsScreenviewEvent.commentId = ThingUtil.a(str, ThingType.a);
                analyticsScreenviewEvent.commentAuthorId = ThingUtil.a(name, ThingType.b);
            }
        }
        return analyticsScreenviewEvent;
    }

    protected final void E_() {
        if (this.ai) {
            super.E_();
        }
    }

    public ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        ((ScreenViewPayload) N.payload).target_fullname = this.f39153F.getName();
        ((ScreenViewPayload) N.payload).target_url = this.f39153F.getUrl();
        ((ScreenViewPayload) N.payload).target_url_domain = this.f39153F.getDomain();
        ((ScreenViewPayload) N.payload).target_type = this.f39153F.isSelf() ? "self" : "link";
        ((ScreenViewPayload) N.payload).target_title = this.f39153F.getTitle();
        ((ScreenViewPayload) N.payload).source_page = this.ag;
        ((ScreenViewPayload) N.payload).sr_name = this.f39153F.getSubreddit();
        if (this.f39153F.getSubredditDetail() != null) {
            ((ScreenViewPayload) N.payload).sr_id = this.f39153F.getSubredditDetail().getId();
        }
        return N;
    }

    public void mo7202a(int i, int i2, Intent intent) {
        super.mo7202a(i, i2, intent);
        if (i == f39146w) {
            switch (i2) {
                case -1:
                    CommentWrapper commentWrapper = (CommentWrapper) intent.getExtras().getBundle("comment_bundle").getSerializable("comment");
                    if (m39079b((Comment) commentWrapper.getData()) != 0) {
                        ReplyableTreeNode replyableTreeNode;
                        List list;
                        i2 = this.f39155H.a;
                        intent = ((Comment) commentWrapper.getData()).getName();
                        Object obj = null;
                        int i3 = -1;
                        int i4 = i3;
                        Object obj2 = null;
                        for (int size = i2.f21186b.size() - 1; size >= 0; size--) {
                            ReplyableTreeNode replyableTreeNode2 = (ReplyableTreeNode) i2.f21186b.get(size);
                            if (obj2 == null && r5 == -1) {
                                if (replyableTreeNode2.f21182a.getName().equals(intent)) {
                                    i4 = replyableTreeNode2.f21183b;
                                    obj2 = new ReplyableTreeNode(commentWrapper, i4);
                                    if (i4 != 0) {
                                        i3 = size;
                                    } else {
                                        i3 = size;
                                        replyableTreeNode = (ReplyableTreeNode) i2.f21186b.set(i3, obj2);
                                        list = (List) i2.f21185a.remove(replyableTreeNode);
                                        if (list != null) {
                                            i2.f21185a.put(obj2, list);
                                        }
                                        list = (List) i2.f21185a.remove(obj);
                                        list.set(list.indexOf(replyableTreeNode), obj2);
                                        i2.f21185a.put(obj, list);
                                        m39076b(i3, 1, 1);
                                        return;
                                    }
                                }
                                continue;
                            } else if (replyableTreeNode2.f21183b == i4 - 1) {
                                obj = replyableTreeNode2;
                                if (obj2 != null && i3 >= 0) {
                                    replyableTreeNode = (ReplyableTreeNode) i2.f21186b.set(i3, obj2);
                                    list = (List) i2.f21185a.remove(replyableTreeNode);
                                    if (list != null) {
                                        i2.f21185a.put(obj2, list);
                                    }
                                    if (i4 > 0 && obj != null) {
                                        list = (List) i2.f21185a.remove(obj);
                                        list.set(list.indexOf(replyableTreeNode), obj2);
                                        i2.f21185a.put(obj, list);
                                    }
                                }
                                m39076b(i3, 1, 1);
                                return;
                            }
                        }
                        replyableTreeNode = (ReplyableTreeNode) i2.f21186b.set(i3, obj2);
                        list = (List) i2.f21185a.remove(replyableTreeNode);
                        if (list != null) {
                            i2.f21185a.put(obj2, list);
                        }
                        list = (List) i2.f21185a.remove(obj);
                        list.set(list.indexOf(replyableTreeNode), obj2);
                        i2.f21185a.put(obj, list);
                        m39076b(i3, 1, 1);
                        return;
                    }
                    break;
                case 0:
                    return;
                default:
                    Timber.b("Unrecognized result code %d in BaseDetailFragment", new Object[]{Integer.valueOf(i)});
                    return;
            }
        } else if (i == f39145v && i2 == -1 && this.f39153F.isPromoted() != 0) {
            RedditAdsAnalytics.m22651a(am_(), this.f39153F, 6);
        }
    }

    private void m39076b(int i, int i2, int i3) {
        int f = this.f39154G.m35095f() + i;
        if (i2 != i3 && this.f39154G.m35096g() > 0) {
            i = i3 - i2;
            i2 = this.f39154G.mo6510a();
            this.ad.b((i2 - i) - 1, i2 - 1);
        }
        this.ad.a(f, i3);
        ah();
    }

    private void m39080c(int i, int i2) {
        if (i2 > 0) {
            this.ad.c(this.f39154G.m35095f() + i, i2);
            ah();
        }
    }

    public void onEventMainThread(ReplyEvent replyEvent) {
        if (replyEvent.f29328a instanceof CommentWrapper) {
            if (m39079b((Comment) ((CommentWrapper) replyEvent.f29328a).getData())) {
                EventBus.getDefault().removeStickyEvent((Object) replyEvent);
                if (this.f39155H.sortId != 9 && this.replyToPosition >= 0) {
                    CommentsProvider commentsProvider = this.f39155H;
                    commentsProvider.a.m23361a(this.replyToPosition, (CommentWrapper) replyEvent.f29328a);
                    m39080c(this.replyToPosition, 1);
                }
            }
        }
    }

    private void m39077b(MenuItem menuItem) {
        if (menuItem != null) {
            if (this.ae) {
                Timber.b("setting bookmark to SAVED", new Object[0]);
                menuItem.setIcon(ResourcesUtil.m22736g(am_(), (int) C1761R.drawable.ic_icon_saved));
                return;
            }
            Timber.b("setting bookmark to UNSAVED", new Object[0]);
            menuItem.setIcon(ResourcesUtil.m22736g(am_(), (int) C1761R.drawable.ic_icon_save));
        }
    }

    public final void mo7207a(LegacyCommentViewHolder legacyCommentViewHolder) {
        Context am_ = am_();
        if (SessionManager.b().c.isAnonymous()) {
            SessionManager.b().a(Util.m24019e(am_()), true);
            return;
        }
        this.replyToPosition = legacyCommentViewHolder.d();
        am_.startActivityForResult(IntentUtil.m23740a(am_, legacyCommentViewHolder.m34974w()), f39145v);
    }

    public final void mo5009a(Comment comment) {
        a(IntentUtil.m23741a(am_(), comment), f39146w);
    }

    private void an() {
        if (!this.av) {
            this.detailList.setItemAnimator(new DefaultItemAnimator());
            this.av = true;
        }
    }

    private boolean ao() {
        return this.f39153F != null && SessionUtil.m23895a(SessionManager.b().c, this.f39153F.getAuthor());
    }

    final void m39124a(String str, boolean z, boolean z2) {
        if (!str.equals(this.f39156M) || !this.f39166Z) {
            this.detailList.post(new BaseDetailScreen$$Lambda$26(this, str, z2, z));
        }
    }

    private void ap() {
        this.f39151D.setVisibility(8);
        DetailListHeader detailListHeader = this.f39168z;
        detailListHeader.sortBarContainer.setVisibility(0);
        detailListHeader.singleCommentThreadContainer.setVisibility(8);
        this.f39160R = "post_detail";
        this.f39155H.a(null, null);
        this.f39156M = null;
        this.af = null;
        if (mo7220H() instanceof OnViewAllCommentsListener) {
            ((OnViewAllCommentsListener) mo7220H()).mo7145w();
        }
        ag();
    }

    public final void mo7206a(LinkFlair linkFlair, String str, Thing thing) {
        RedditJobManager.a().a(new UpdatePostFlairJob(SessionManager.b().c, linkFlair, str, thing.getName()));
        if (TextUtils.isEmpty(str)) {
            str = linkFlair != null ? linkFlair.getText() : "";
        }
        LinkEditCache.getLinkFlairEditCache().put(thing.getName(), str);
    }

    public final Integer mo4954w() {
        return this.f39150C.f28924a;
    }

    public final Integer mo4949M() {
        return this.f39150C.f28925b;
    }

    public final void mo4951a(Integer num) {
        this.f39150C.mo4951a(num);
    }

    public final void mo4953b(Integer num) {
        this.f39150C.mo4953b(num);
    }

    public final void mo4950a(OnColorChangedCallback onColorChangedCallback) {
        this.f39150C.mo4950a(onColorChangedCallback);
    }

    public final void mo4952b(OnColorChangedCallback onColorChangedCallback) {
        this.f39150C.mo4952b(onColorChangedCallback);
    }

    private OnboardingEventBuilder ar() {
        return new OnboardingEventBuilder().m28958a(PageType.POST_DETAIL).m28960a(aq()).m28955a(this.f39153F).m28961b(this.f39153F);
    }

    public void mo7691P() {
        if (this.e) {
            this.swipeRefreshLayout.setEnabled(ListUtil.m23810a((LinearLayoutManager) this.detailList.getLayoutManager()));
        }
    }

    public final void m39108a() {
        if (this.e) {
            Timber.b("%s: comments unchanged event", new Object[]{this.eventRequestId});
            ah();
        }
    }

    public final void m39111a(int i, int i2, int i3) {
        if (this.e) {
            Timber.b("%s: comments changed event", new Object[]{this.eventRequestId});
            an();
            m39076b(i, i2, i3);
        }
    }

    public final void m39110a(int i, int i2) {
        if (this.e) {
            Timber.b("%s: comments inserted event", new Object[]{this.eventRequestId});
            int i3 = this.f39155H.sortId;
            if (this.av && i3 == 9) {
                this.detailList.setItemAnimator(new HighlightInAnimator(am_()));
                this.av = false;
            } else if (i3 != 9) {
                an();
            }
            m39080c(i, i2);
            if (this.f39155H.sortId == 9 && mo7689b(i) != 0) {
                this.f39165Y += i2;
                this.f39148A.setLiveCommentCount(this.f39165Y);
            }
        }
    }

    public final void m39127b(int i, int i2) {
        if (this.e) {
            Timber.b("%s: comments removed event", new Object[]{this.eventRequestId});
            an();
            if (i2 > 0) {
                this.ad.d(this.f39154G.m35095f() + i, i2);
                ah();
            }
        }
    }

    private boolean m39079b(Comment comment) {
        return TextUtils.equals(comment.link_id, this.f39153F.getName());
    }

    protected final boolean m39101W() {
        return this.a.getBoolean("com.reddit.arg.fromOnboarding", false);
    }

    private SubredditCategory aq() {
        return (SubredditCategory) this.a.getParcelable("com.reddit.arg.subredditCategory");
    }

    final /* synthetic */ Unit m39106a(Link link, Session session) {
        Completable.fromRunnable(new BaseDetailScreen$$Lambda$25(this, link)).subscribeOn(SchedulerProvider.m23886b()).subscribe();
        LinkUtil.m23807j(session, link.getName());
        EventBus.getDefault().postSticky(new ResultEvent(this.f39157N));
        link = am();
        if (link != null) {
            link.mo7146x();
        }
        return Unit.f25273a;
    }

    final /* synthetic */ void m39136f(View view) {
        if (this.e) {
            this.f39168z.setSort(this.f39155H.sortId);
            mo6971y();
            CommentsProvider commentsProvider = this.f39155H;
            commentsProvider.a(commentsProvider.sortId == 9, CommentsPerformanceTracker.m21953a(CommentPerformanceEventBuilder.Source.PostDetail));
            view.post(new BaseDetailScreen$$Lambda$27(this));
            an();
            aj();
        }
    }

    static /* synthetic */ void m39072a(BaseDetailScreen baseDetailScreen, SortOption sortOption) {
        baseDetailScreen.mo7684x();
        sortOption = SortingsLegacyMapper.a((CommentSortType) sortOption.f20414c);
        baseDetailScreen.f39155H.sortId = sortOption;
        baseDetailScreen.f39168z.setSort(sortOption);
        baseDetailScreen.an();
        baseDetailScreen.detailList.smoothScrollToPosition((baseDetailScreen.f39154G.m35095f() + baseDetailScreen.f39154G.m35096g()) - 1);
        baseDetailScreen.ag();
    }
}
