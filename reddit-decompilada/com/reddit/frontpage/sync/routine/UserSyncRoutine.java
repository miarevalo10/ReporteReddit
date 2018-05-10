package com.reddit.frontpage.sync.routine;

import android.accounts.Account;
import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.Session.SessionId;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.InternalAccountUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.util.ChatUtilKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/sync/routine/UserSyncRoutine;", "Lcom/reddit/frontpage/sync/routine/SyncRoutine;", "()V", "lastSyncedSessionId", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session$SessionId;", "remoteRedditApiDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "getRemoteRedditApiDataSource", "()Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "setRemoteRedditApiDataSource", "(Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;)V", "sync", "", "account", "Landroid/accounts/Account;", "context", "Landroid/content/Context;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSyncRoutine.kt */
public final class UserSyncRoutine extends SyncRoutine {
    public static final int f28859b = 0;
    public static final Companion f28860c = new Companion();
    private static final String f28861e = "UserSyncRoutine";
    @Inject
    public RemoteRedditApiDataSource f28862a;
    private SessionId f28863d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/sync/routine/UserSyncRoutine$Companion;", "", "()V", "SYNC_ID", "", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserSyncRoutine.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public UserSyncRoutine() {
        super(f28859b);
        FrontpageApplication.m28877m().mo4606a(this);
    }

    public final boolean mo4941a(Account account, Context context) {
        Intrinsics.m26847b(account, "account");
        Intrinsics.m26847b(context, "context");
        Timber.b("User sync starting", new Object[0]);
        if (AccountUtil.a(account) != null) {
            Timber.b("Aborting user sync, this is the default user.", new Object[0]);
            return true;
        }
        account = SessionUtil.m23892a(account, f28861e);
        if (account == null) {
            return false;
        }
        Timber.b("Syncing session is for %s", new Object[]{account.getUsername()});
        try {
            if (this.f28862a == null) {
                Intrinsics.m26844a("remoteRedditApiDataSource");
            }
            com.reddit.datalibrary.frontpage.requests.models.v1.Account account2 = (com.reddit.datalibrary.frontpage.requests.models.v1.Account) RemoteRedditApiDataSource.c().blockingGet();
            if (account2.is_employee) {
                account2.gold_creddits = 50;
            }
            AccountStorage.b.a(account.getUsername(), account2);
            ChatUtilKt.m24754a();
            if (Intrinsics.m26845a(account.a(), this.f28863d)) {
                InboxCountRepository inboxCountRepository = InboxCountRepository.a;
                InboxCountRepository.e();
            }
            this.f28863d = account.a();
            if (account2.is_employee || InternalAccountUtil.m23767a(account2.getName()) != null) {
                InternalSettings.a().n();
            }
            Timber.b("User sync complete: %s", new Object[]{account.getUsername()});
            return true;
        } catch (Account account3) {
            Timber.a((Throwable) account3, f28861e, new Object[0]);
            return false;
        }
    }
}
