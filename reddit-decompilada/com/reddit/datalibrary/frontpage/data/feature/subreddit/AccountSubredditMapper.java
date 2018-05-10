package com.reddit.datalibrary.frontpage.data.feature.subreddit;

import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/AccountSubredditMapper;", "", "()V", "map", "Lcom/reddit/frontpage/domain/model/Subreddit;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountSubredditMapper.kt */
public final class AccountSubredditMapper {
    public static final AccountSubredditMapper f10773a = new AccountSubredditMapper();

    private AccountSubredditMapper() {
    }

    public static Subreddit m9096a(Account account) {
        Intrinsics.b(account, "account");
        UserSubreddit subreddit = account.getSubreddit();
        if (subreddit == null) {
            Intrinsics.a();
        }
        String b = ThingUtil.m8720b(subreddit.getKindWithId());
        String kindWithId = account.getSubreddit().getKindWithId();
        String displayName = account.getSubreddit().getDisplayName();
        String displayNamePrefixed = account.getSubreddit().getDisplayNamePrefixed();
        String iconImg = account.getSubreddit().getIconImg();
        String bannerImg = account.getSubreddit().getBannerImg();
        Boolean userIsModerator = account.getSubreddit().getUserIsModerator();
        String description = account.getSubreddit().getDescription();
        String keyColor = account.getSubreddit().getKeyColor();
        String url = account.getSubreddit().getUrl();
        long linkKarma = (long) (account.getLinkKarma() + account.getCommentKarma());
        long j = linkKarma;
        return new Subreddit(b, kindWithId, displayName, displayNamePrefixed, iconImg, keyColor, bannerImg, null, null, description, null, account.getSubreddit().getPublicDescription(), null, j, null, account.getCreatedUtc(), "user", url, false, null, null, null, null, null, null, null, userIsModerator, null, null, 469521792, null);
    }
}
