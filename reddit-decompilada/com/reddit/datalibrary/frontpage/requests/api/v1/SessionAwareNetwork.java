package com.reddit.datalibrary.frontpage.requests.api.v1;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpStack;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.Session.SessionId;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class SessionAwareNetwork extends BasicNetwork {
    private static final ConcurrentMap<SessionId, TokenRefreshGeneration> f18804d = new ConcurrentHashMap();
    private static final AtomicBoolean f18805e = new AtomicBoolean(false);

    private class TokenRefreshGeneration {
        volatile CountDownLatch f10917a;
        volatile boolean f10918b;
        volatile boolean f10919c;
        final /* synthetic */ SessionAwareNetwork f10920d;

        private TokenRefreshGeneration(SessionAwareNetwork sessionAwareNetwork) {
            this.f10920d = sessionAwareNetwork;
            this.f10918b = false;
            this.f10919c = false;
        }

        private boolean m9339a() throws VolleyError {
            if (!this.f10918b) {
                return false;
            }
            if (this.f10919c) {
                return true;
            }
            throw new AuthFailureError();
        }

        static /* synthetic */ void m9338a(com.reddit.datalibrary.frontpage.requests.api.v1.SessionAwareNetwork.TokenRefreshGeneration r7, com.reddit.datalibrary.frontpage.redditauth.account.Session r8) throws com.android.volley.VolleyError {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = r7.f10917a;
            r1 = r8.f16289b;
            if (r0 == 0) goto L_0x0017;
        L_0x0006:
            r0.await();	 Catch:{ InterruptedException -> 0x0011 }
            r0 = r7.m9339a();
            if (r0 != 0) goto L_0x0010;
        L_0x000f:
            goto L_0x0017;
        L_0x0010:
            return;
        L_0x0011:
            r7 = new com.android.volley.TimeoutError;
            r7.<init>();
            throw r7;
        L_0x0017:
            r0 = r8.f16288a;
            monitor-enter(r0);
            r2 = r7.m9339a();	 Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0022;	 Catch:{ all -> 0x0081 }
        L_0x0020:
            monitor-exit(r0);	 Catch:{ all -> 0x0081 }
            return;	 Catch:{ all -> 0x0081 }
        L_0x0022:
            r2 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x0081 }
            r3 = 1;	 Catch:{ all -> 0x0081 }
            r2.<init>(r3);	 Catch:{ all -> 0x0081 }
            r7.f10917a = r2;	 Catch:{ all -> 0x0081 }
            r2 = 0;
            r4 = 0;
            r7.f10918b = r3;	 Catch:{ TokenRotationError -> 0x0062 }
            r5 = "refreshing token before request; %s";	 Catch:{ TokenRotationError -> 0x0062 }
            r6 = new java.lang.Object[r3];	 Catch:{ TokenRotationError -> 0x0062 }
            r6[r4] = r1;	 Catch:{ TokenRotationError -> 0x0062 }
            timber.log.Timber.b(r5, r6);	 Catch:{ TokenRotationError -> 0x0062 }
            r5 = com.reddit.datalibrary.frontpage.redditauth.account.SessionManager.m9191b();	 Catch:{ TokenRotationError -> 0x0062 }
            r5.m9204c(r8);	 Catch:{ TokenRotationError -> 0x0062 }
            r5 = "done refreshing token, old token was %s new token is %s";	 Catch:{ TokenRotationError -> 0x0062 }
            r6 = 2;	 Catch:{ TokenRotationError -> 0x0062 }
            r6 = new java.lang.Object[r6];	 Catch:{ TokenRotationError -> 0x0062 }
            r6[r4] = r1;	 Catch:{ TokenRotationError -> 0x0062 }
            r1 = r8.f16289b;	 Catch:{ TokenRotationError -> 0x0062 }
            r6[r3] = r1;	 Catch:{ TokenRotationError -> 0x0062 }
            timber.log.Timber.b(r5, r6);	 Catch:{ TokenRotationError -> 0x0062 }
            r7.f10919c = r3;	 Catch:{ TokenRotationError -> 0x0062 }
            r1 = r7.f10917a;	 Catch:{ all -> 0x0081 }
            r1.countDown();	 Catch:{ all -> 0x0081 }
            r7.f10917a = r2;	 Catch:{ all -> 0x0081 }
            r1 = com.reddit.datalibrary.frontpage.requests.api.v1.SessionAwareNetwork.f18804d;	 Catch:{ all -> 0x0081 }
            r8 = r8.f16288a;	 Catch:{ all -> 0x0081 }
            r1.remove(r8, r7);	 Catch:{ all -> 0x0081 }
            monitor-exit(r0);	 Catch:{ all -> 0x0081 }
            return;
        L_0x0060:
            r1 = move-exception;
            goto L_0x0070;
        L_0x0062:
            r1 = move-exception;
            r3 = "Failed to retrieve a new token";	 Catch:{ all -> 0x0060 }
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0060 }
            timber.log.Timber.c(r1, r3, r4);	 Catch:{ all -> 0x0060 }
            r1 = new com.android.volley.AuthFailureError;	 Catch:{ all -> 0x0060 }
            r1.<init>();	 Catch:{ all -> 0x0060 }
            throw r1;	 Catch:{ all -> 0x0060 }
        L_0x0070:
            r3 = r7.f10917a;	 Catch:{ all -> 0x0081 }
            r3.countDown();	 Catch:{ all -> 0x0081 }
            r7.f10917a = r2;	 Catch:{ all -> 0x0081 }
            r2 = com.reddit.datalibrary.frontpage.requests.api.v1.SessionAwareNetwork.f18804d;	 Catch:{ all -> 0x0081 }
            r8 = r8.f16288a;	 Catch:{ all -> 0x0081 }
            r2.remove(r8, r7);	 Catch:{ all -> 0x0081 }
            throw r1;	 Catch:{ all -> 0x0081 }
        L_0x0081:
            r7 = move-exception;	 Catch:{ all -> 0x0081 }
            monitor-exit(r0);	 Catch:{ all -> 0x0081 }
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.api.v1.SessionAwareNetwork.TokenRefreshGeneration.a(com.reddit.datalibrary.frontpage.requests.api.v1.SessionAwareNetwork$TokenRefreshGeneration, com.reddit.datalibrary.frontpage.redditauth.account.Session):void");
        }
    }

    public SessionAwareNetwork(HttpStack httpStack) {
        super(httpStack);
    }

    public final NetworkResponse mo777a(Request<?> request) throws VolleyError {
        Object tag = request.getTag();
        if (tag instanceof Session) {
            Session session = (Session) tag;
            if (session.m16313d()) {
                TokenRefreshGeneration tokenRefreshGeneration = (TokenRefreshGeneration) f18804d.get(session.f16288a);
                if (tokenRefreshGeneration == null) {
                    synchronized (session.f16288a) {
                        tokenRefreshGeneration = (TokenRefreshGeneration) f18804d.get(session.f16288a);
                        if (tokenRefreshGeneration == null) {
                            tokenRefreshGeneration = new TokenRefreshGeneration();
                            f18804d.put(session.f16288a, tokenRefreshGeneration);
                        }
                    }
                }
                TokenRefreshGeneration.m9338a(tokenRefreshGeneration, session);
            }
        }
        return super.mo777a((Request) request);
    }
}
