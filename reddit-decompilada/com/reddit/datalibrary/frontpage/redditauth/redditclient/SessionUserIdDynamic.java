package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.api.v1.Dynamic;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import java.util.Map;
import timber.log.Timber;

public class SessionUserIdDynamic implements Dynamic {
    private final Session f16321a;

    public SessionUserIdDynamic(Session session) {
        this.f16321a = session;
    }

    public SessionUserIdDynamic() {
        this.f16321a = null;
    }

    public final void mo3034a(Map<String, String> map) {
        Session session = this.f16321a != null ? this.f16321a : SessionManager.m9191b().f10840c;
        if (!session.isAnonymous()) {
            try {
                Account a = AccountStorage.f15744b.m15829a(session);
                if (a != null) {
                    map.put("Reddit-User_Id", a.getId());
                }
            } catch (Map<String, String> map2) {
                Timber.c(map2, "Unable to make /me call to retrieve account info.", new Object[0]);
            }
        }
    }
}
