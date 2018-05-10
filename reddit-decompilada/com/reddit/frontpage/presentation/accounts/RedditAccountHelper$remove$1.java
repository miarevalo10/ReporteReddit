package com.reddit.frontpage.presentation.accounts;

import android.accounts.Account;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.PushUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountHelper.kt */
final class RedditAccountHelper$remove$1 implements Runnable {
    final /* synthetic */ Account f20319a;

    RedditAccountHelper$remove$1(Account account) {
        this.f20319a = account;
    }

    public final void run() {
        PushUtil.m23873a(SessionManager.b().a(this.f20319a));
    }
}
