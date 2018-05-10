package com.reddit.frontpage.presentation.accounts;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.content.Context;
import android.os.AsyncTask;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/RedditAccountHelper;", "Lcom/reddit/frontpage/presentation/accounts/AccountHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accounts", "", "Landroid/accounts/Account;", "getAccounts", "()Ljava/util/List;", "activeAccount", "getActiveAccount", "()Landroid/accounts/Account;", "getContext", "()Landroid/content/Context;", "getAccount", "username", "", "login", "", "remove", "callback", "Landroid/accounts/AccountManagerCallback;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountHelper.kt */
public final class RedditAccountHelper implements AccountHelper {
    private final Context f28060a;

    public RedditAccountHelper(Context context) {
        Intrinsics.m26847b(context, "context");
        this.f28060a = context;
    }

    public final List<Account> mo4767a() {
        Object b = AccountUtil.b(this.f28060a);
        Intrinsics.m26843a(b, "AccountUtil.getAccounts(context)");
        return (List) b;
    }

    public final Account mo4770b() {
        return AccountUtil.a(this.f28060a);
    }

    public final boolean mo4768a(String str) {
        if (str != null) {
            Object b = m29382b(str);
            if ((Intrinsics.m26845a(b, AccountUtil.a(this.f28060a)) ^ 1) == 0) {
                return false;
            }
            SessionManager.b().a(b.name, b.type, false);
            return true;
        }
        SessionManager.b().f();
        return true;
    }

    public final boolean mo4769a(String str, AccountManagerCallback<?> accountManagerCallback) {
        Intrinsics.m26847b(str, "username");
        Account b = m29382b(str);
        SessionManager.b().b(b);
        FrontpageSettings.a(this.f28060a, str);
        AsyncTask.execute((Runnable) new RedditAccountHelper$remove$1(b));
        return AccountUtil.a(this.f28060a, b, accountManagerCallback);
    }

    private final Account m29382b(String str) {
        Account b = AccountUtil.b(this.f28060a, AccountUtil.a(str));
        return b == null ? new Account(str, "com.reddit.account") : b;
    }
}
