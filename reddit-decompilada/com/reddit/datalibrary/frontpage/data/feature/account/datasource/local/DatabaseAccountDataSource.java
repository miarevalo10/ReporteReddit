package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import com.google.common.base.Converter;
import com.google.common.base.Optional;
import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.reddit.datalibrary.frontpage.data.common.RxModelQueriablesKt;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.AccountDataModel;
import com.reddit.datalibrary.frontpage.data.model.AccountDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel_Table;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/DatabaseAccountDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;", "()V", "getByUsername", "Lio/reactivex/Single;", "Lcom/google/common/base/Optional;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "username", "", "saveOrUpdate", "", "account", "AccountConverter", "UserSubredditConverter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DatabaseAccountDataSource.kt */
public final class DatabaseAccountDataSource implements LocalAccountDataSource {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/DatabaseAccountDataSource$AccountConverter;", "Lcom/google/common/base/Converter;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "Lcom/reddit/datalibrary/frontpage/data/model/AccountDataModel;", "()V", "doBackward", "dataModel", "doForward", "account", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DatabaseAccountDataSource.kt */
    private static final class AccountConverter extends Converter<Account, AccountDataModel> {
        public static final AccountConverter f18678a = new AccountConverter();

        private AccountConverter() {
        }

        public final /* synthetic */ Object mo3583a(Object obj) {
            Account account = (Account) obj;
            Intrinsics.b(account, "account");
            return new AccountDataModel(0, account.getId(), account.getUsername(), account.getCreatedUtc(), account.isEmployee(), account.isFriend(), account.isSuspended(), account.getSuspensionExpiration(), account.getHideFromRobots(), account.getLinkKarma(), account.getCommentKarma(), account.isGold(), account.isMod(), account.getHasVerifiedEmail(), account.getInboxCount(), account.getHasMail(), account.getHasModMail(), account.getHideAds(), account.getGoldCredits(), account.getIconUrl(), account.getShowMyActiveCommunities(), 1, null);
        }

        public final /* synthetic */ Object mo3584b(Object obj) {
            AccountDataModel accountDataModel = (AccountDataModel) obj;
            Intrinsics.b(accountDataModel, "dataModel");
            return new Account(accountDataModel.getAccountId(), accountDataModel.getName(), accountDataModel.getCreatedUtc(), accountDataModel.isEmployee(), accountDataModel.isFriend(), accountDataModel.isSuspended(), accountDataModel.getSuspensionExpiration(), accountDataModel.getHideFromRobots(), accountDataModel.getLinkKarma(), accountDataModel.getCommentKarma(), accountDataModel.isGold(), accountDataModel.isMod(), accountDataModel.getHasVerifiedEmail(), accountDataModel.getInboxCount(), accountDataModel.getHasMail(), accountDataModel.getHasModMail(), accountDataModel.getHideAds(), accountDataModel.getGoldCredits(), null, accountDataModel.getIconUrl(), accountDataModel.getShowMyActiveCommunities(), 262144, null);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0014J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/DatabaseAccountDataSource$UserSubredditConverter;", "Lcom/google/common/base/Converter;", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/UserSubredditDataModel;", "username", "", "(Ljava/lang/String;)V", "doBackward", "dataModel", "doForward", "userSubreddit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DatabaseAccountDataSource.kt */
    private static final class UserSubredditConverter extends Converter<UserSubreddit, UserSubredditDataModel> {
        private final String f18679a;

        public final /* synthetic */ Object mo3583a(Object obj) {
            UserSubreddit userSubreddit = (UserSubreddit) obj;
            Intrinsics.b(userSubreddit, "userSubreddit");
            String str = this.f18679a;
            String bannerImg = userSubreddit.getBannerImg();
            Boolean userIsBanned = userSubreddit.getUserIsBanned();
            String description = userSubreddit.getDescription();
            String publicDescription = userSubreddit.getPublicDescription();
            Boolean userIsMuted = userSubreddit.getUserIsMuted();
            Boolean userIsContributor = userSubreddit.getUserIsContributor();
            Boolean userIsModerator = userSubreddit.getUserIsModerator();
            Boolean userIsSubscriber = userSubreddit.getUserIsSubscriber();
            return new UserSubredditDataModel(0, str, bannerImg, userIsBanned, description, userIsMuted, userSubreddit.getDisplayName(), userSubreddit.getHeaderImg(), userSubreddit.getTitle(), userIsModerator, userSubreddit.getOver18(), userSubreddit.getIconImg(), userSubreddit.getDisplayNamePrefixed(), userSubreddit.getSubscribers(), userSubreddit.isDefaultIcon(), userSubreddit.getKeyColor(), userSubreddit.getKindWithId(), userSubreddit.isDefaultBanner(), userSubreddit.getUrl(), userIsContributor, publicDescription, userSubreddit.getSubredditType(), userIsSubscriber, userSubreddit.getShowInDefaultSubreddits(), 1, null);
        }

        public final /* synthetic */ Object mo3584b(Object obj) {
            UserSubredditDataModel userSubredditDataModel = (UserSubredditDataModel) obj;
            Intrinsics.b(userSubredditDataModel, "dataModel");
            String bannerImg = userSubredditDataModel.getBannerImg();
            Boolean userIsBanned = userSubredditDataModel.getUserIsBanned();
            String description = userSubredditDataModel.getDescription();
            String publicDescription = userSubredditDataModel.getPublicDescription();
            Boolean userIsMuted = userSubredditDataModel.getUserIsMuted();
            Boolean userIsContributor = userSubredditDataModel.getUserIsContributor();
            Boolean userIsModerator = userSubredditDataModel.getUserIsModerator();
            Boolean userIsSubscriber = userSubredditDataModel.getUserIsSubscriber();
            return new UserSubreddit(userSubredditDataModel.getName(), bannerImg, userIsBanned, description, userIsMuted, userSubredditDataModel.getDisplayName(), userSubredditDataModel.getHeaderImg(), userSubredditDataModel.getTitle(), userIsModerator, userSubredditDataModel.getOver18(), userSubredditDataModel.getIconImg(), userSubredditDataModel.getDisplayNamePrefixed(), userSubredditDataModel.getSubscribers(), userSubredditDataModel.isDefaultIcon(), userSubredditDataModel.getKeyColor(), userSubredditDataModel.isDefaultBanner(), userSubredditDataModel.getUrl(), userIsContributor, publicDescription, userSubredditDataModel.getSubredditType(), userIsSubscriber, userSubredditDataModel.getShowInDefaultSubreddits());
        }

        public UserSubredditConverter(String str) {
            Intrinsics.b(str, "username");
            this.f18679a = str;
        }
    }

    public final Single<Boolean> mo2913a(Account account) {
        Single save;
        Intrinsics.b(account, "account");
        if (account.getSubreddit() != null) {
            Object c = new UserSubredditConverter(account.getUsername()).m14544c(account.getSubreddit());
            if (c == null) {
                Intrinsics.a();
            }
            save = ((UserSubredditDataModel) c).save();
        } else {
            save = Single.just(Boolean.valueOf(true));
        }
        account = AccountConverter.f18678a.m14544c(account);
        if (account == null) {
            Intrinsics.a();
        }
        account = ((AccountDataModel) account).save().flatMap(new DatabaseAccountDataSource$saveOrUpdate$1(save));
        Intrinsics.a(account, "accountSave.flatMap { su…)\n            }\n        }");
        return account;
    }

    public final Single<Optional<Account>> mo2914a(String str) {
        Intrinsics.b(str, "username");
        if ((((CharSequence) str).length() > 0 ? 1 : 0) == 0) {
            throw new IllegalArgumentException("Username shouldn't be empty".toString());
        }
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where where = QueryExtensionsKt.from(select, Reflection.a(AccountDataModel.class)).where(AccountDataModel_Table.name.eq((Object) str).collate(Collate.NOCASE));
        Intrinsics.a(where, "select.from(AccountDataM….collate(Collate.NOCASE))");
        Single map = RxModelQueriablesKt.m8756a(com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) where)).map(DatabaseAccountDataSource$getByUsername$accountSelect$1.f15748a);
        Select select2 = SQLite.select(new IProperty[0]);
        Intrinsics.a(select2, "SQLite.select()");
        Where where2 = QueryExtensionsKt.from(select2, Reflection.a(UserSubredditDataModel.class)).where(UserSubredditDataModel_Table.username.eq((Object) str).collate(Collate.NOCASE));
        Intrinsics.a(where2, "select.from(UserSubreddi….collate(Collate.NOCASE))");
        str = map.zipWith(RxModelQueriablesKt.m8756a(com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) where2)).map(new DatabaseAccountDataSource$getByUsername$subredditSelect$1(str)), DatabaseAccountDataSource$getByUsername$2.f15747a);
        Intrinsics.a(str, "accountSelect.zipWith(\n …    })\n                })");
        return str;
    }
}
