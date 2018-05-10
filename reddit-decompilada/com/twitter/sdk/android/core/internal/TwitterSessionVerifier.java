package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import com.twitter.sdk.android.core.services.AccountService;

public class TwitterSessionVerifier implements SessionVerifier<TwitterSession> {
    private final AccountServiceProvider f30715a = new AccountServiceProvider();
    private final DefaultScribeClient f30716b = TwitterCoreScribeClientHolder.m25887a();

    protected static class AccountServiceProvider {
        protected AccountServiceProvider() {
        }

        public static AccountService m25861a(TwitterSession twitterSession) {
            return new TwitterApiClient(twitterSession).m25844a();
        }
    }

    public final /* synthetic */ void mo5483a(com.twitter.sdk.android.core.Session r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = (com.twitter.sdk.android.core.TwitterSession) r6;
        r6 = com.twitter.sdk.android.core.internal.TwitterSessionVerifier.AccountServiceProvider.m25861a(r6);
        r0 = r5.f30716b;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r1 = 0;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r2 = 1;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        if (r0 == 0) goto L_0x0036;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
    L_0x000c:
        r0 = new com.twitter.sdk.android.core.internal.scribe.EventNamespace$Builder;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.<init>();	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = "android";	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.f23969a = r3;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = "credentials";	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.f23970b = r3;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = "";	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.f23971c = r3;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = "";	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.f23972d = r3;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = "";	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.f23973e = r3;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = "impression";	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0.f23974f = r3;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r0 = r0.m25878a();	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3 = r5.f30716b;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r4 = new com.twitter.sdk.android.core.internal.scribe.EventNamespace[r2];	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r4[r1] = r0;	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r3.m31752a(r4);	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
    L_0x0036:
        r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r6 = r6.verifyCredentials(r0, r1);	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        r6.a();	 Catch:{ IOException -> 0x0046, IOException -> 0x0046 }
        return;
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.TwitterSessionVerifier.a(com.twitter.sdk.android.core.Session):void");
    }
}
