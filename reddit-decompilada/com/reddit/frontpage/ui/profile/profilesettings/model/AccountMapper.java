package com.reddit.frontpage.ui.profile.profilesettings.model;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountMapper;", "", "()V", "toCommunityPresentationModel", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "toPresentationModel", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountMapper.kt */
public final class AccountMapper {
    public static final AccountMapper f21543a = new AccountMapper();

    private AccountMapper() {
    }

    public static AccountPresentationModel m23602a(Account account) {
        Intrinsics.m26847b(account, "account");
        UserSubreddit subreddit = account.getSubreddit();
        if (subreddit == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        account = account.getShowMyActiveCommunities();
        if (account == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        boolean booleanValue = account.booleanValue();
        return new AccountPresentationModel(subreddit.getTitle(), subreddit.getPublicDescription(), booleanValue, subreddit.getShowInDefaultSubreddits(), subreddit.getBannerImg(), subreddit.getIconImg(), subreddit.isDefaultIcon(), subreddit.isDefaultBanner());
    }

    public static CommunityPresentationModel m23603b(Account account) {
        Intrinsics.m26847b(account, "account");
        UserSubreddit subreddit = account.getSubreddit();
        if (subreddit == null) {
            Intrinsics.m26842a();
        }
        String id = account.getId();
        CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20485c;
        CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20492f;
        String displayNamePrefixed = subreddit.getDisplayNamePrefixed();
        String displayName = subreddit.getDisplayName();
        String iconImg = subreddit.getIconImg();
        String keyColor = subreddit.getKeyColor();
        Boolean valueOf = Boolean.valueOf(false);
        Companion companion = CommunityPresentationModel.f20468o;
        return new CommunityPresentationModel(id, communityPresentationModelType, communityPresentationSection, displayNamePrefixed, displayName, iconImg, keyColor, valueOf, null, null, null, true, Companion.m22800a(account.getId(), new String[0]), subreddit.getOver18(), 1792);
    }
}
