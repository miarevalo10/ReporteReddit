package com.reddit.frontpage.ui.detail;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.ui.view.OnboardingLinkHeaderView;
import com.reddit.frontpage.ui.detail.LinkEditCache.BodyEditCacheEntry;
import com.reddit.frontpage.ui.listing.adapter.ads.LegacyAdsNavigator;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.LinkFooterView;
import com.reddit.frontpage.widgets.SubscribeDetailHeaderView;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
public class DetailListHeader extends LinearLayout {
    public Runnable f21168a;
    SubscribeDetailHeaderView f21169b;
    private OnboardingLinkHeaderView f21170c;
    @BindView
    LinearLayout clickContainer;
    @BindView
    LinkFooterView commentBar;
    @BindView
    ViewGroup commentStackContainer;
    @BindView
    FrameLayout contentPreviewContainer;
    private boolean f21171d;
    @BindView
    LinkFlairView flairView;
    @BindView
    ViewStub headerMetadataStub;
    @BindView
    TextView linkTitle;
    @BindView
    ImageView modMode;
    @BindView
    BaseHtmlTextView selfTextView;
    @BindView
    RelativeLayout singleCommentThreadContainer;
    @BindView
    TextView sortBar;
    @BindView
    FrameLayout sortBarContainer;
    @BindView
    TextView viewAll;
    @BindView
    TextView viewCount;

    public void setModerationEnabledListener(Runnable runnable) {
        this.f21168a = runnable;
    }

    public DetailListHeader(Context context) {
        super(context);
        m23337a();
    }

    public DetailListHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23337a();
    }

    public DetailListHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23337a();
    }

    @TargetApi(21)
    public DetailListHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m23337a();
    }

    private void m23337a() {
        setOrientation(1);
        inflate(getContext(), C1761R.layout.merge_listheader_link_detail_legacy, this);
        setLayoutParams(new LayoutParams(-1, -2));
        ButterKnife.a(this);
    }

    public SubscribeDetailHeaderView getSubscribeDetailHeaderView() {
        if (this.f21171d) {
            throw new IllegalStateException("Tried to access subscribe header in onboarding flow");
        }
        if (this.f21169b == null) {
            this.headerMetadataStub.setLayoutResource(C1761R.layout.listheader_subscribe_detail_legacy);
            this.f21169b = (SubscribeDetailHeaderView) this.headerMetadataStub.inflate();
        }
        return this.f21169b;
    }

    public OnboardingLinkHeaderView getOnboardingLinkHeaderView() {
        if (this.f21171d) {
            if (this.f21170c == null) {
                this.headerMetadataStub.setLayoutResource(C1761R.layout.onboarding_link_header_view);
                this.f21170c = (OnboardingLinkHeaderView) this.headerMetadataStub.inflate();
            }
            return this.f21170c;
        }
        throw new IllegalStateException("Tried to access onboarding header in regular mode");
    }

    public final void m23338a(Link link) {
        Object obj;
        if (this.f21171d) {
            String str;
            String str2;
            OnboardingLinkHeaderView onboardingLinkHeaderView = this.f21170c;
            Intrinsics.m26847b(link, "link");
            Object subredditNamePrefixed = link.getSubredditNamePrefixed();
            Intrinsics.m26843a(subredditNamePrefixed, "link.subredditNamePrefixed");
            Subreddit subredditDetail = link.getSubredditDetail();
            if (subredditDetail != null) {
                str = subredditDetail.icon_img;
            } else {
                str = null;
            }
            Subreddit subredditDetail2 = link.getSubredditDetail();
            if (subredditDetail2 != null) {
                str2 = subredditDetail2.key_color;
            } else {
                str2 = null;
            }
            onboardingLinkHeaderView.m29720a(subredditNamePrefixed, str, str2);
        } else {
            this.f21169b.m24149a(link);
            ModUtil.m23826a(link.getSubredditDetail(), this.modMode, this.f21168a);
        }
        this.linkTitle.setText(link.getTitle());
        this.flairView.m23474a(link);
        BodyEditCacheEntry bodyEditCacheEntry = (BodyEditCacheEntry) LinkEditCache.getLinkBodyEditCache().get(link.getName());
        if (bodyEditCacheEntry != null) {
            obj = bodyEditCacheEntry.f21173b;
        } else {
            obj = link.getSelfTextHtml();
        }
        if (TextUtils.isEmpty(obj)) {
            this.selfTextView.setVisibility(8);
        } else {
            this.selfTextView.setHtmlFromString(obj);
            this.selfTextView.setVisibility(0);
        }
        if (link.getViewCount() > 0) {
            this.viewCount.setText(Util.m23960a((int) C1761R.string.fmt_num_views, CountUtil.m23674a(link.getViewCount())));
            this.viewCount.setVisibility(0);
        } else {
            this.viewCount.setVisibility(8);
        }
        if (LegacyAdsNavigator.m23458a(link)) {
            this.clickContainer.setOnClickListener(new DetailListHeader$$Lambda$0(this, link));
        } else {
            this.clickContainer.setOnClickListener(null);
        }
    }

    public FrameLayout getContentPreviewContainer() {
        return this.contentPreviewContainer;
    }

    public ViewGroup getCommentStackContainer() {
        return this.commentStackContainer;
    }

    public LinkFooterView getCommentBar() {
        return this.commentBar;
    }

    public void setSortBarOnClickListener(OnClickListener onClickListener) {
        this.sortBar.setOnClickListener(onClickListener);
    }

    public void setSort(int i) {
        this.sortBar.setText(getContext().getString(Sorting.m21809c(i)));
        int i2 = C1761R.drawable.ic_icon_sort_best;
        switch (i) {
            case 0:
            case 8:
                break;
            case 1:
            case 9:
                i2 = C1761R.drawable.ic_icon_sort_new;
                break;
            case 3:
                i2 = C1761R.drawable.ic_icon_sort_top;
                break;
            case 5:
                i2 = C1761R.drawable.ic_icon_sort_qa;
                break;
            case 6:
                i2 = C1761R.drawable.ic_icon_sort_controversial;
                break;
            case 7:
                i2 = C1761R.drawable.ic_icon_sort_recent;
                break;
            default:
                i2 = C1761R.drawable.ic_icon_sort;
                break;
        }
        this.sortBar.setCompoundDrawablesRelative(ResourcesUtil.m22726c(getContext(), i2), null, ResourcesUtil.m22725b(getContext(), ResourcesUtil.m22732e(getContext(), (int) C1761R.drawable.ind_dropdown)), null);
    }

    public void setViewAllThreadClickListener(OnClickListener onClickListener) {
        this.viewAll.setOnClickListener(onClickListener);
    }

    public void setOnboardingMode(boolean z) {
        this.f21171d = z;
    }
}
