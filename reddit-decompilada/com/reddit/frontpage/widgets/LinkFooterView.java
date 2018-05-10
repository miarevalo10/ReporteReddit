package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.HomeScreen;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.listing.BaseLinkListingScreen;
import com.reddit.frontpage.ui.modtools.PopupPostModOptions;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.ShareRequestUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.modtools.modview.ModView;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import com.reddit.frontpage.widgets.vote.VoteView;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

public class LinkFooterView extends LinearLayout {
    Link f21899a;
    public boolean f21900b;
    Disposable f21901c;
    @BindView
    View commentContainer;
    @BindView
    TextView commentCountText;
    OnShareListener f21902d;
    OnModerateListener f21903e;
    @BindView
    View extraActionContainer;
    @BindView
    DrawableTextView extraActionText;
    OnModActionCompletedListener f21904f;
    OnViewCommentsListener f21905g;
    private boolean f21906h;
    @BindView
    TextView liveCommentCountText;
    @BindView
    ImageView liveCommentIcon;
    @BindView
    ModView modView;
    @BindView
    VoteView voteView;

    public interface OnModActionCompletedListener {
        void mo4891a();
    }

    public interface OnModerateListener {
        void mo5031a(Thing thing);

        void mo5032a(Thing thing, Screen screen);

        void mo5033a(Thing thing, boolean z);

        void mo5034b(Thing thing);

        void mo5035b(Thing thing, boolean z);

        void mo5036c(Thing thing);

        void mo5037c(Thing thing, boolean z);

        void mo5038d(Thing thing, boolean z);

        void mo5039e(Thing thing, boolean z);
    }

    public interface OnShareListener {
        void mo4945a(String str, Link link);
    }

    public interface OnViewCommentsListener {
        void mo4990a();
    }

    public LinkFooterView(Context context) {
        this(context, null);
    }

    public LinkFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1761R.attr.linkFooterViewStyle);
    }

    @TargetApi(21)
    public LinkFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21900b = true;
        m24172b();
    }

    @TargetApi(21)
    public LinkFooterView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f21900b = true;
        m24172b();
    }

    private void m24172b() {
        inflate(getContext(), C1761R.layout.merge_link_footer, this);
        ButterKnife.a(this);
    }

    final void m24176a(boolean z) {
        PopupPostModOptions popupPostModOptions = new PopupPostModOptions(getContext(), this.f21899a, this.f21903e, AppAnalytics.m21849a((View) this), null, z);
        popupPostModOptions.m23581a(new LinkFooterView$$Lambda$2(this));
        popupPostModOptions.f21479b = this.f21904f;
        popupPostModOptions.f21478a.m23284a();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private ShareEventBuilder getShareEventBuilder() {
        boolean c = FrontpageSettings.a().c();
        boolean d = FrontpageSettings.a().d();
        Screen a = Routing.m22617a(getContext());
        String str = null;
        String str2 = a instanceof BaseDetailScreen ? ShareEvent.SOURCE_DETAILS_SCREEN : a instanceof BaseLinkListingScreen ? ShareEvent.SOURCE_LISTINGS_SCREEN : null;
        if (this.f21899a.getSubredditDetail() != null) {
            str = this.f21899a.getSubredditDetail().getId();
        }
        String str3 = this.f21899a.isSelf() ? "self" : "link";
        ShareEventBuilder a2 = AppAnalytics.m21868e().m21834a(this.extraActionContainer);
        a2.f19993c = c;
        a2.f19994d = d;
        a2.f19996f = this.f21899a.getName();
        a2.f19995e = this.f21899a.getUrl();
        a2.f19998h = this.f21899a.getDomain();
        a2.f19997g = str3;
        a2.f19999i = this.f21899a.getTitle();
        a2.f19992b = str2;
        a2.f20000j = this.f21899a.getSubreddit();
        a2.f20001k = str;
        return a2;
    }

    public void setOnVoteChangeListener(final OnVoteChangeListener onVoteChangeListener) {
        this.voteView.setOnVoteChangeListener(new OnVoteChangeListener(this) {
            final /* synthetic */ LinkFooterView f29457b;

            public final boolean mo4894a() {
                return onVoteChangeListener.mo4894a();
            }

            public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
                onVoteChangeListener.mo4893a(str, i, adAnalyticsInfo);
                if (i == 1 && FrontpageSettings.a().n() != null) {
                    ShareRequestUtil.m23901a(Routing.m22617a(this.f29457b.voteView.getContext()).j, this.f29457b.f21899a.getTitle(), this.f29457b.f21899a.getUrl(), this.f29457b.f21899a.getName(), this.f29457b.getShareEventBuilder());
                } else if (i == 1 && FrontpageSettings.a().t().d() != null) {
                    this.f29457b.extraActionText.startAnimation(AnimUtil.m23638a(this.f29457b.extraActionText.getWidth(), this.f29457b.extraActionText.getHeight()));
                }
                FrontpageSettings.a().k("com.reddit.frontpage.last_upvote_timestamp");
            }
        });
    }

    public void setOnShareListener(OnShareListener onShareListener) {
        this.f21902d = onShareListener;
    }

    public void setOnModerateListener(OnModerateListener onModerateListener) {
        this.f21903e = onModerateListener;
        this.modView.setModerateListener(onModerateListener);
    }

    public void setOnModActionCompletedListener(OnModActionCompletedListener onModActionCompletedListener) {
        this.f21904f = new LinkFooterView$$Lambda$3(this, onModActionCompletedListener);
        this.modView.setActionCompletedListener(onModActionCompletedListener);
    }

    final void m24174a() {
        if (this.f21901c != null) {
            this.f21901c.mo5626a();
        }
    }

    public void setOnViewCommentsListener(OnViewCommentsListener onViewCommentsListener) {
        this.f21905g = onViewCommentsListener;
    }

    public final void m24175a(Link link) {
        CharSequence string;
        this.f21899a = link;
        boolean z = (link.getSubredditDetail() != null && link.getSubredditDetail().user_is_moderator) || ModUtil.m23834b(Routing.m22617a(this.modView.getContext()));
        this.f21906h = z;
        if (this.f21900b) {
            Screen a = Routing.m22617a(getContext());
            if (a != null && a.getClass().getName().equals(HomeScreen.class.getName()) && ModUtil.m23831a(a)) {
                ModUtil.m23832b();
            }
            if (ModUtil.m23831a(a) && this.f21906h) {
                ModView modView = this.modView;
                Intrinsics.m26847b(link, "link");
                modView.setLink(link);
                this.modView.setVisibility(0);
            } else {
                this.modView.setVisibility(8);
            }
        }
        long numComments = link.getNumComments();
        z = ModUtil.m23824a().m30457c(link.getName(), link.isLocked());
        if (numComments <= 0) {
            if (!z) {
                string = getResources().getString(C1761R.string.label_comment);
                this.commentCountText.setText(string);
                this.voteView.m24414a((Votable) link, AdAnalyticsInfo.b(link));
                this.voteView.setEnabled(link.isArchived() ^ true);
                this.commentContainer.setOnClickListener(new LinkFooterView$$Lambda$4(this));
                this.commentCountText.setCompoundDrawablesRelative(m24169a(this.commentCountText.getCompoundDrawablesRelative()[0]), null, null, null);
                if (this.f21906h || ModUtil.m23831a(Routing.m22617a(getContext()))) {
                    this.extraActionText.setEnabled(true);
                    this.extraActionText.setText(C1761R.string.action_share);
                    this.extraActionText.setCompoundDrawablesRelative(m24169a(Util.m24032h((int) C1761R.drawable.ic_icon_share)), null, null, null);
                    this.extraActionText.setEnabled(true ^ link.isArchived());
                    this.extraActionContainer.setOnClickListener(new LinkFooterView$$Lambda$6(this, link));
                } else {
                    this.extraActionText.setEnabled(link.isArchived() ^ true);
                    this.extraActionText.setText(C1761R.string.action_moderate);
                    this.extraActionText.setCompoundDrawablesRelative(m24169a(Util.m24032h((int) C1761R.drawable.ic_icon_moderate)), null, null, null);
                    this.extraActionText.setEnabled(link.isArchived() ^ 1);
                    this.extraActionContainer.setOnClickListener(new LinkFooterView$$Lambda$5(this));
                }
                this.extraActionText.setVisibility(0);
            }
        }
        string = CountUtil.m23674a(numComments);
        this.commentCountText.setText(string);
        this.voteView.m24414a((Votable) link, AdAnalyticsInfo.b(link));
        this.voteView.setEnabled(link.isArchived() ^ true);
        this.commentContainer.setOnClickListener(new LinkFooterView$$Lambda$4(this));
        this.commentCountText.setCompoundDrawablesRelative(m24169a(this.commentCountText.getCompoundDrawablesRelative()[0]), null, null, null);
        if (this.f21906h) {
        }
        this.extraActionText.setEnabled(true);
        this.extraActionText.setText(C1761R.string.action_share);
        this.extraActionText.setCompoundDrawablesRelative(m24169a(Util.m24032h((int) C1761R.drawable.ic_icon_share)), null, null, null);
        this.extraActionText.setEnabled(true ^ link.isArchived());
        this.extraActionContainer.setOnClickListener(new LinkFooterView$$Lambda$6(this, link));
        this.extraActionText.setVisibility(0);
    }

    public void setLiveCommentCount(int i) {
        if (i > 0) {
            this.liveCommentIcon.setVisibility(0);
            this.liveCommentCountText.setVisibility(0);
            this.commentCountText.setVisibility(8);
            this.commentContainer.setBackgroundDrawable(Util.m24032h((int) C1761R.drawable.live_comment_update_counter));
            i = CountUtil.m23674a((long) i);
            this.liveCommentCountText.setText(Util.m23960a((int) C1761R.string.live_comment_count, i));
            return;
        }
        this.liveCommentIcon.setVisibility(8);
        this.liveCommentCountText.setVisibility(8);
        this.commentCountText.setVisibility(0);
        this.commentContainer.setBackgroundDrawable(null);
    }

    public void setCommentClickListener(OnClickListener onClickListener) {
        this.commentContainer.setOnClickListener(onClickListener);
    }

    private Drawable m24169a(Drawable drawable) {
        return ResourcesUtil.m22733e(getContext(), drawable);
    }
}
