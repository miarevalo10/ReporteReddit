package com.reddit.frontpage.ui;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.job.SaveMediaJob.SavedMediaErrorEvent;
import com.reddit.datalibrary.frontpage.job.SaveMediaJob.SavedMediaEvent;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Source;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.listener.SwipeDismissListener;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.ViewUtils;
import com.reddit.frontpage.widgets.LinkFooterView;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import timber.log.Timber;

public abstract class SaveMediaScreen extends BaseScreen {
    @BindView
    View background;
    @BindView
    LinkFooterView footerView;
    @BindView
    LinearLayout lightboxTitleHeader;
    @BindView
    TextView lightboxTitleHeaderDetails;
    @BindView
    TextView lightboxTitleHeaderTitle;
    @State
    protected Link link;
    @State
    protected String mediaUri;
    @State
    protected String sourcePage;
    @BindView
    ViewGroup topBottom;
    Handler f39137v = new Handler();
    Runnable f39138w = new SaveMediaScreen$$Lambda$0(this);
    private int f39139x;

    public void mo7438P() {
    }

    public void mo7439Q() {
    }

    public abstract String mo7433T();

    public abstract String mo7434U();

    public String getAnalyticsScreenName() {
        return "lightbox";
    }

    public final int mo7143u() {
        return 2;
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.f39139x = am_().getWindow().getDecorView().getSystemUiVisibility();
        this.footerView.f21900b = false;
        if (this.link != null) {
            this.footerView.m24175a(this.link);
            layoutInflater = LinkUtil.m23777a(am_());
            this.footerView.setOnVoteChangeListener(new OnVoteChangeListener(this) {
                final /* synthetic */ SaveMediaScreen f28888b;

                public final boolean mo4894a() {
                    return layoutInflater.mo4894a();
                }

                public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
                    if (this.f28888b.mo7435X()) {
                        this.f28888b.m39038Y().m28956a(Action.CLICK).m28954a(i).m21891a();
                        return;
                    }
                    TheaterModeEventBuilder.m21947a("click", i == 1 ? TheaterModeEvents.NOUN_UPVOTE : TheaterModeEvents.NOUN_DOWNVOTE);
                    layoutInflater.mo4893a(str, i, adAnalyticsInfo);
                }
            });
            this.footerView.setOnShareListener(new SaveMediaScreen$$Lambda$1(this));
            layoutInflater = this.footerView;
            am_();
            layoutInflater.setOnModerateListener(LinkUtil.m23776a());
            this.footerView.setCommentClickListener(new SaveMediaScreen$$Lambda$2(this));
            layoutInflater = DateUtil.m23684b(this.link.getCreatedUtc());
            viewGroup = Util.m23960a((int) C1761R.string.fmt_u_name, this.link.getAuthor());
            String f = Util.m24027f((int) C1761R.string.unicode_delimiter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.link.getSubredditNamePrefixed());
            stringBuilder.append(f);
            stringBuilder.append(viewGroup);
            stringBuilder.append(f);
            stringBuilder.append(layoutInflater);
            this.lightboxTitleHeaderDetails.setText(stringBuilder.toString());
            this.lightboxTitleHeaderTitle.setText(this.link.getTitle());
        }
        return this.K;
    }

    final /* synthetic */ void m39056a(String str, Link link) {
        if (mo7435X()) {
            m39038Y().m28956a(Action.CLICK).m28957a(Noun.SHARE).m21891a();
        } else {
            new ShareEventBuilder().m21941a(Source.TheaterMode).m21939a(ShareEventBuilder.Action.Clicked).m21940a(ShareEventBuilder.Noun.Share).m21937a(link.getSubredditDetail()).m21938a(link).m21944a();
        }
        new ShareEventBuilder().m21941a(Source.PostShareComplete).m21939a(ShareEventBuilder.Action.ShareComplete).m21940a(ShareEventBuilder.Noun.ShareSuccess).m21937a(link.getSubredditDetail()).m21938a(link).m21945b();
        LinkUtil.m23780a(am_(), str);
    }

    final /* synthetic */ void m39049V() {
        m39063w();
        if (mo7435X()) {
            m39038Y().m28956a(Action.CLICK).m28957a(Noun.COMMENTS).m21891a();
        }
    }

    protected final void m39063w() {
        if (!"post_detail".equals(this.sourcePage)) {
            if (!"onboarding_post_detail".equals(this.sourcePage)) {
                a(IntentUtil.m23745a(am_(), DetailHolderScreen.m38887b(this.link.getId(), null, null)));
                am_().finish();
                return;
            }
        }
        am_().finish();
    }

    public final void m39052a(int i, String[] strArr, int[] iArr) {
        super.a(i, strArr, iArr);
        if (i == 10) {
            mo7440a(iArr);
        }
    }

    public void mo6992b(View view) {
        super.mo6992b(view);
        if (VERSION.SDK_INT >= 21) {
            am_().getWindow().setFlags(201326592, 201326592);
        }
        if (this.link == null && this.footerView != null) {
            this.footerView.setAlpha(0.0f);
        }
        m39046S();
        this.f39137v.postDelayed(this.f39138w, 3000);
        if (Util.m24022e(this.link) == null) {
            mo7438P();
        }
    }

    public void mo6993c(View view) {
        super.mo6993c(view);
        this.f39137v.removeCallbacks(this.f39138w);
    }

    public final void m39054a(Menu menu) {
        super.a(menu);
        menu.findItem(C1761R.id.action_share).setVisible(this.link == null);
    }

    public boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.mo7201a(menuItem);
        }
        am_().finish();
        return true;
    }

    public SwipeDismissListener mo7442y() {
        return new SwipeDismissListener(this, this.topBottom, this.background) {
            final /* synthetic */ SaveMediaScreen f28889a;

            public final void mo4946a() {
                if (this.f28889a.e) {
                    this.f28889a.mo7437O();
                }
            }
        };
    }

    public void mo7437O() {
        TheaterModeEventBuilder.m21947a(TheaterModeEvents.ACTION_SWIPE, TheaterModeEvents.NOUN_SEE_POST);
        if (mo7435X()) {
            m39038Y().m28956a(Action.CLICK).m28957a(Noun.EXIT_FEED).m21891a();
        }
        am_().getWindow().getDecorView().setSystemUiVisibility(0);
        am_().finish();
    }

    protected final void m39045R() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_();
        if (appCompatActivity != null) {
            if (appCompatActivity.c().a() != null) {
                appCompatActivity.c().a().c();
            }
            this.lightboxTitleHeader.setVisibility(8);
            appCompatActivity.getWindow().getDecorView().setSystemUiVisibility(3846);
            mo7441d(false);
        }
        this.f39137v.removeCallbacks(this.f39138w);
    }

    public void mo7441d(boolean z) {
        this.footerView.setVisibility(z ? false : true);
    }

    protected final void m39046S() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_();
        if (appCompatActivity != null) {
            appCompatActivity.getWindow().getDecorView().setSystemUiVisibility(this.f39139x);
            if (appCompatActivity.c().a() != null) {
                appCompatActivity.c().a().b();
            }
            if (this.link != null) {
                this.lightboxTitleHeader.setVisibility(0);
            }
            if (!(this.link == null || this.footerView == null)) {
                mo7441d(true);
            }
        }
        this.f39137v.removeCallbacks(this.f39138w);
    }

    public void mo7440a(int[] iArr) {
        if (PermissionUtil.m23866a(iArr) == null || TextUtils.isEmpty(this.mediaUri) != null) {
            mo7204a(ao_().getString(C1761R.string.error_unable_save_media_permission));
        } else {
            Util.m24020e(this.mediaUri);
        }
    }

    protected final void mo7185a(ActionBar actionBar) {
        super.mo7185a(actionBar);
        actionBar.b(true);
        actionBar.a(true);
        actionBar.c(false);
        actionBar.a(ResourcesUtil.m22730d(am_(), C1761R.drawable.ic_icon_back, Color.parseColor("#FFFFFFFF")));
    }

    public void onEvent(SavedMediaEvent savedMediaEvent) {
        mo7204a(mo7433T());
    }

    public void onEvent(SavedMediaErrorEvent savedMediaErrorEvent) {
        CharSequence U = mo7434U();
        mo7204a(U);
        Timber.c(savedMediaErrorEvent.exception, U, new Object[0]);
    }

    public final void mo7204a(CharSequence charSequence) {
        charSequence = ViewUtils.m24060a(this.K, charSequence, 0);
        ((LayoutParams) charSequence.d.getLayoutParams()).bottomMargin = this.topBottom.getPaddingBottom();
        charSequence.a();
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        ScreenviewEventBuilder analyticsScreenviewEvent = super.getAnalyticsScreenviewEvent();
        if (this.link != null) {
            analyticsScreenviewEvent.m21928a(this.link.getName(), AppAnalytics.m21848a(this.link.getLinkType()), this.link.getTitle(), Boolean.valueOf(this.link.isOver18()), Boolean.valueOf(this.link.isSpoiler()), this.link.getUrl(), this.link.getDomain(), Long.valueOf(this.link.getCreatedUtc()));
        }
        return analyticsScreenviewEvent;
    }

    public final ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        ((ScreenViewPayload) N.payload).source_page = this.sourcePage;
        if (this.link != null) {
            ((ScreenViewPayload) N.payload).target_fullname = this.link.getName();
        }
        return N;
    }

    private boolean mo7435X() {
        if (!"onboarding".equals(this.sourcePage)) {
            if (!"onboarding_post_detail".equals(this.sourcePage)) {
                return false;
            }
        }
        return true;
    }

    private OnboardingEventBuilder m39038Y() {
        OnboardingEventBuilder a = new OnboardingEventBuilder().m28959a(OnboardingEventBuilder.Source.THEATER_MODE);
        if ("onboarding".equals(this.sourcePage)) {
            a.m28958a(PageType.RECOMMENDATIONS);
        } else if ("onboarding_post_detail".equals(this.sourcePage)) {
            a.m28958a(PageType.POST_DETAIL);
        }
        a.m28955a(this.link);
        a.m28961b(this.link);
        return a;
    }

    public final void m39064x() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_();
        Object obj = (appCompatActivity == null || appCompatActivity.c().a() == null || !appCompatActivity.c().a().d()) ? null : 1;
        if (obj == null) {
            m39046S();
        } else {
            m39045R();
        }
    }

    final /* synthetic */ void m39050W() {
        m39045R();
        mo7439Q();
    }
}
