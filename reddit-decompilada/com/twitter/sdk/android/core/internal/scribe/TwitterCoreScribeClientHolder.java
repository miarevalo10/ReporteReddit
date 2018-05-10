package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.services.common.IdManager;

public class TwitterCoreScribeClientHolder {
    private static DefaultScribeClient f24022a;

    public static DefaultScribeClient m25887a() {
        return f24022a;
    }

    public static void m25888a(TwitterCore twitterCore, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, IdManager idManager) {
        f24022a = new DefaultScribeClient(twitterCore, "TwitterCore", sessionManager, guestSessionProvider, idManager);
    }
}
