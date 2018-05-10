package com.reddit.frontpage.util;

import android.accounts.Account;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager;
import com.reddit.datalibrary.social.data.session.ChatConnectionManager.Companion;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBird.ConnectionState;
import timber.log.Timber;

public class SessionUtil {
    public static boolean m23894a() {
        return SessionManager.b().c.isAnonymous();
    }

    public static boolean m23895a(Session session, String str) {
        return session == null ? str == null : (str == null || session.isAnonymous() || str.equalsIgnoreCase(session.getUsername()) == null) ? false : true;
    }

    public static Session m23892a(Account account, String str) {
        try {
            return SessionManager.b().a(account);
        } catch (Account account2) {
            Timber.c(account2, str, new Object[0]);
            return null;
        }
    }

    public static void m23896b() {
        PushUtil.m23873a(SessionManager.b().c);
        SessionManager.b().f();
    }

    public static void m23897c() {
        RedditFlowDatabase.b();
        PushUtil.m23875b();
        VoteUtil.m24065a();
        SubredditUtil.m23922b();
        ProviderManager providerManager = ProviderManager.b;
        ProviderManager.a();
        InboxCountRepository inboxCountRepository = InboxCountRepository.a;
        InboxCountRepository.e();
        if (SendBird.m24995h() == ConnectionState.CONNECTING || SendBird.m24995h() == ConnectionState.OPEN) {
            SendBird.m25000j();
        }
        Companion companion = ChatConnectionManager.f19854b;
        Companion.m21751a(true);
    }

    public static String m23898d() {
        String e = m23899e();
        if (e == null) {
            return null;
        }
        com.reddit.datalibrary.frontpage.requests.models.v1.Account account = (com.reddit.datalibrary.frontpage.requests.models.v1.Account) AccountStorage.b.a(e);
        if (account == null) {
            return null;
        }
        return m23893a(account.getId());
    }

    public static String m23899e() {
        return SessionManager.b().c == null ? null : SessionManager.b().c.getUsername();
    }

    public static String m23893a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("t2_")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("t2_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
