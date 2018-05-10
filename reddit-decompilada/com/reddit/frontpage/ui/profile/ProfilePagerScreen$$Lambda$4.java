package com.reddit.frontpage.ui.profile;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bumptech.glide.request.RequestOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.TexturedBackground;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.ui.listing.UserCommentsListingScreen;
import com.reddit.frontpage.ui.listing.UserSubmittedListingScreen;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.InternalAccountUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

final /* synthetic */ class ProfilePagerScreen$$Lambda$4 implements Consumer {
    private final ProfilePagerScreen f29228a;

    ProfilePagerScreen$$Lambda$4(ProfilePagerScreen profilePagerScreen) {
        this.f29228a = profilePagerScreen;
    }

    public final void accept(Object obj) {
        String iconImg;
        String bannerImg;
        boolean z;
        boolean z2;
        int i;
        int i2;
        BaseAccountScreen baseAccountScreen;
        Single observeOn;
        UserCommentsListingScreen userCommentsListingScreen;
        UserSubmittedListingScreen userSubmittedListingScreen;
        ProfilePagerScreen profilePagerScreen = this.f29228a;
        Account account = (Account) obj;
        UserSubreddit subreddit = account.getSubreddit();
        profilePagerScreen.userId = SessionUtil.m23893a(account.getId());
        boolean z3 = false;
        profilePagerScreen.following = false;
        String str = null;
        if (subreddit != null) {
            boolean over18 = subreddit.getOver18();
            String keyColor = subreddit.getKeyColor();
            iconImg = subreddit.getIconImg();
            bannerImg = subreddit.getBannerImg();
            if (subreddit.getUserIsSubscriber() != null) {
                profilePagerScreen.following = subreddit.getUserIsSubscriber().booleanValue();
            }
            profilePagerScreen.subredditId = subreddit.getKindWithId();
            profilePagerScreen.subredditName = subreddit.getDisplayName();
            if (TextUtils.isEmpty(subreddit.getTitle())) {
                profilePagerScreen.userTitleView.setText(profilePagerScreen.username);
            } else {
                profilePagerScreen.userTitleView.setText(subreddit.getTitle());
            }
            if (TextUtils.isEmpty(subreddit.getPublicDescription())) {
                profilePagerScreen.profileDescription.setVisibility(8);
            } else {
                profilePagerScreen.profileDescription.setText(subreddit.getPublicDescription());
                profilePagerScreen.profileDescription.setVisibility(0);
                profilePagerScreen.profileDescription.setOnClickListener(new ProfilePagerScreen$$Lambda$9(profilePagerScreen));
            }
            z = over18;
            str = keyColor;
            z2 = true;
        } else {
            iconImg = account.getIconUrl();
            profilePagerScreen.profileDescription.setVisibility(8);
            z = false;
            z2 = z;
            bannerImg = null;
        }
        boolean equals = TextUtils.equals(SessionManager.b().c.getUsername(), profilePagerScreen.username);
        if (InternalAccountUtil.m23768b(profilePagerScreen.username) && equals && subreddit != null) {
            ViewsKt.m24107c(profilePagerScreen.editButton);
        }
        profilePagerScreen.editButton.setOnClickListener(new ProfilePagerScreen$$Lambda$6(profilePagerScreen, subreddit));
        profilePagerScreen.profileDetail1.setText(Util.m23960a((int) C1761R.string.fmt_num_karma, Integer.valueOf(account.getLinkKarma() + account.getCommentKarma())));
        profilePagerScreen.profileDetail2.setText(DateUtil.m22704a(TimeUnit.SECONDS.toMillis(account.getCreatedUtc()), 1));
        if (TextUtils.isEmpty(str)) {
            i = ResourcesUtil.m22740i(profilePagerScreen.am_(), C1761R.attr.rdt_default_user_key_color);
        } else {
            i = Color.parseColor(str);
        }
        profilePagerScreen.f39260z.mo4951a(Integer.valueOf(i));
        ThemeOption c = FrontpageSettings.a().c(true);
        if (c != ThemeOption.f20981c) {
            if (c != ThemeOption.f20984f) {
                i2 = i;
                profilePagerScreen.f39260z.mo4953b(Integer.valueOf(i2));
                profilePagerScreen.collapsingToolbar.setContentScrimColor(i2);
                z = AccountPrefsUtil.m23630a(profilePagerScreen.username, Boolean.valueOf(z));
                Util.m23988a(profilePagerScreen.userIconView, iconImg, str, true, z);
                profilePagerScreen.userIconView.setVisibility(0);
                if (!TextUtils.isEmpty(bannerImg) || z) {
                    GlideApp.a(profilePagerScreen.am_()).a(profilePagerScreen.bannerView);
                    TexturedBackground.m22745a(profilePagerScreen.am_(), str, profilePagerScreen.bannerView);
                } else {
                    Drawable snooProgressDrawable = new SnooProgressDrawable(profilePagerScreen.am_());
                    GlideApp.a(profilePagerScreen.am_()).b(bannerImg).placeholder(snooProgressDrawable).apply(RequestOptions.a(snooProgressDrawable)).listener(ImageProgressLoadListener.a(snooProgressDrawable, bannerImg)).into(profilePagerScreen.bannerView);
                    profilePagerScreen.bannerShadow.setVisibility(0);
                }
                if (z2) {
                    profilePagerScreen.m39391d(false);
                } else {
                    profilePagerScreen.m39379a(i, false);
                    profilePagerScreen.m39391d(profilePagerScreen.self ^ true);
                    profilePagerScreen.followButton.setOnClickListener(new ProfilePagerScreen$$Lambda$7(profilePagerScreen, subreddit, i));
                }
                baseAccountScreen = (BaseAccountScreen) profilePagerScreen.f39254A.m35102d(2);
                if (!(baseAccountScreen == null || account == null)) {
                    baseAccountScreen.m39363a(account);
                    observeOn = profilePagerScreen.f39256v.m22509a(profilePagerScreen.username).observeOn(profilePagerScreen.f39259y.a());
                    baseAccountScreen.getClass();
                    profilePagerScreen.f39255B.mo5631a(observeOn.subscribe(ProfilePagerScreen$$Lambda$0.m30326a(baseAccountScreen), new ProfilePagerScreen$$Lambda$1(profilePagerScreen)));
                }
                userCommentsListingScreen = (UserCommentsListingScreen) profilePagerScreen.f39254A.m35102d(1);
                if (!(userCommentsListingScreen == null || account == null)) {
                    userCommentsListingScreen.isContributor = account.getSubreddit() == null;
                }
                userSubmittedListingScreen = (UserSubmittedListingScreen) profilePagerScreen.f39254A.m35102d(0);
                if (userSubmittedListingScreen != null) {
                    if (account != null) {
                        if (account.getSubreddit() != null) {
                            z3 = true;
                        }
                        userSubmittedListingScreen.isContributor = z3;
                        if (userSubmittedListingScreen.isContributor != null && userSubmittedListingScreen.f40167v == null) {
                            userSubmittedListingScreen.mo7459w();
                        }
                    }
                    AppAnalytics.m21852a(userSubmittedListingScreen.mo7203N());
                }
            }
        }
        i2 = ResourcesUtil.m22740i(profilePagerScreen.am_(), C1761R.attr.rdt_body_color);
        profilePagerScreen.f39260z.mo4953b(Integer.valueOf(i2));
        profilePagerScreen.collapsingToolbar.setContentScrimColor(i2);
        z = AccountPrefsUtil.m23630a(profilePagerScreen.username, Boolean.valueOf(z));
        Util.m23988a(profilePagerScreen.userIconView, iconImg, str, true, z);
        profilePagerScreen.userIconView.setVisibility(0);
        if (TextUtils.isEmpty(bannerImg)) {
        }
        GlideApp.a(profilePagerScreen.am_()).a(profilePagerScreen.bannerView);
        TexturedBackground.m22745a(profilePagerScreen.am_(), str, profilePagerScreen.bannerView);
        if (z2) {
            profilePagerScreen.m39391d(false);
        } else {
            profilePagerScreen.m39379a(i, false);
            profilePagerScreen.m39391d(profilePagerScreen.self ^ true);
            profilePagerScreen.followButton.setOnClickListener(new ProfilePagerScreen$$Lambda$7(profilePagerScreen, subreddit, i));
        }
        baseAccountScreen = (BaseAccountScreen) profilePagerScreen.f39254A.m35102d(2);
        baseAccountScreen.m39363a(account);
        observeOn = profilePagerScreen.f39256v.m22509a(profilePagerScreen.username).observeOn(profilePagerScreen.f39259y.a());
        baseAccountScreen.getClass();
        profilePagerScreen.f39255B.mo5631a(observeOn.subscribe(ProfilePagerScreen$$Lambda$0.m30326a(baseAccountScreen), new ProfilePagerScreen$$Lambda$1(profilePagerScreen)));
        userCommentsListingScreen = (UserCommentsListingScreen) profilePagerScreen.f39254A.m35102d(1);
        if (account.getSubreddit() == null) {
        }
        userCommentsListingScreen.isContributor = account.getSubreddit() == null;
        userSubmittedListingScreen = (UserSubmittedListingScreen) profilePagerScreen.f39254A.m35102d(0);
        if (userSubmittedListingScreen != null) {
            if (account != null) {
                if (account.getSubreddit() != null) {
                    z3 = true;
                }
                userSubmittedListingScreen.isContributor = z3;
                userSubmittedListingScreen.mo7459w();
            }
            AppAnalytics.m21852a(userSubmittedListingScreen.mo7203N());
        }
    }
}
