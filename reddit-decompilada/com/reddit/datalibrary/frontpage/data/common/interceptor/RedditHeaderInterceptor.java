package com.reddit.datalibrary.frontpage.data.common.interceptor;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/RedditHeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditHeaderInterceptor.kt */
public final class RedditHeaderInterceptor implements Interceptor {
    public static final Companion f15731a = new Companion();
    private static final String f15732b = "x-reddit-loid";
    private static final String f15733c = "x-reddit-session";
    private static final String f15734d = "x-reddit-device-id";
    private static final String f15735e = "Client-Vendor-ID";
    private static final String f15736f = "Reddit-User_Id";
    private static final String f15737g = "User-Agent";
    private static final String f15738h = "X-Dev-Ad-Id";
    private static final String f15739i = "gateway.reddit.com";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/RedditHeaderInterceptor$Companion;", "", "()V", "HEADER_DEVICE_ID", "", "getHEADER_DEVICE_ID", "()Ljava/lang/String;", "HEADER_DEV_AD_ID", "getHEADER_DEV_AD_ID", "HEADER_SERVER_LOID", "getHEADER_SERVER_LOID", "HEADER_SESSION_ID", "getHEADER_SESSION_ID", "HEADER_USER_AGENT", "getHEADER_USER_AGENT", "HEADER_USER_ID", "getHEADER_USER_ID", "HEADER_VENDOR_ID", "getHEADER_VENDOR_ID", "REDDIT_GATEWAY_HOST", "getREDDIT_GATEWAY_HOST", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditHeaderInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final Response intercept(Chain chain) {
        Object obj;
        SessionManager b;
        Session c;
        Account a;
        String header;
        Intrinsics.b(chain, "chain");
        Request request = chain.request();
        Builder header2 = request.newBuilder().header(f15735e, Config.f10819g).header(f15734d, Config.f10819g).header(f15737g, Config.f10814b).header(f15738h, Config.m9162f());
        CharSequence charSequence = Config.f10818f;
        Object obj2 = 1;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    header2.header(f15733c, Config.f10818f);
                }
                charSequence = Config.f10820h;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        obj = null;
                        if (obj == null) {
                            header2.header(f15732b, Config.f10820h);
                        }
                        charSequence = Config.f10822j;
                        if (charSequence != null) {
                            if (charSequence.length() != 0) {
                                obj2 = null;
                            }
                        }
                        if (obj2 == null) {
                            header2.header("x-reddaid", Config.f10822j);
                        }
                        if (Intrinsics.a(request.url().host(), f15739i)) {
                            b = SessionManager.m9191b();
                            Intrinsics.a(b, "SessionManager.getInstance()");
                            c = b.m9203c();
                            if (!c.isAnonymous()) {
                                a = AccountStorage.f15744b.m15829a(c);
                                if (a != null) {
                                    header2.header(f15736f, a.getId());
                                }
                            }
                        }
                        chain = chain.proceed(header2.build());
                        header = chain.header(f15733c);
                        if (header != null) {
                            Config.m9155b(header);
                        }
                        header = chain.header(f15732b);
                        if (header != null) {
                            Config.m9152a(header);
                        }
                        Intrinsics.a(chain, "chain.proceed(requestBui…onfig.setLoId(it) }\n    }");
                        return chain;
                    }
                }
                obj = 1;
                if (obj == null) {
                    header2.header(f15732b, Config.f10820h);
                }
                charSequence = Config.f10822j;
                if (charSequence != null) {
                    if (charSequence.length() != 0) {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    header2.header("x-reddaid", Config.f10822j);
                }
                if (Intrinsics.a(request.url().host(), f15739i)) {
                    b = SessionManager.m9191b();
                    Intrinsics.a(b, "SessionManager.getInstance()");
                    c = b.m9203c();
                    if (c.isAnonymous()) {
                        a = AccountStorage.f15744b.m15829a(c);
                        if (a != null) {
                            header2.header(f15736f, a.getId());
                        }
                    }
                }
                chain = chain.proceed(header2.build());
                header = chain.header(f15733c);
                if (header != null) {
                    Config.m9155b(header);
                }
                header = chain.header(f15732b);
                if (header != null) {
                    Config.m9152a(header);
                }
                Intrinsics.a(chain, "chain.proceed(requestBui…onfig.setLoId(it) }\n    }");
                return chain;
            }
        }
        obj = 1;
        if (obj == null) {
            header2.header(f15733c, Config.f10818f);
        }
        charSequence = Config.f10820h;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                obj = null;
                if (obj == null) {
                    header2.header(f15732b, Config.f10820h);
                }
                charSequence = Config.f10822j;
                if (charSequence != null) {
                    if (charSequence.length() != 0) {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    header2.header("x-reddaid", Config.f10822j);
                }
                if (Intrinsics.a(request.url().host(), f15739i)) {
                    b = SessionManager.m9191b();
                    Intrinsics.a(b, "SessionManager.getInstance()");
                    c = b.m9203c();
                    if (c.isAnonymous()) {
                        a = AccountStorage.f15744b.m15829a(c);
                        if (a != null) {
                            header2.header(f15736f, a.getId());
                        }
                    }
                }
                chain = chain.proceed(header2.build());
                header = chain.header(f15733c);
                if (header != null) {
                    Config.m9155b(header);
                }
                header = chain.header(f15732b);
                if (header != null) {
                    Config.m9152a(header);
                }
                Intrinsics.a(chain, "chain.proceed(requestBui…onfig.setLoId(it) }\n    }");
                return chain;
            }
        }
        obj = 1;
        if (obj == null) {
            header2.header(f15732b, Config.f10820h);
        }
        charSequence = Config.f10822j;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            header2.header("x-reddaid", Config.f10822j);
        }
        if (Intrinsics.a(request.url().host(), f15739i)) {
            b = SessionManager.m9191b();
            Intrinsics.a(b, "SessionManager.getInstance()");
            c = b.m9203c();
            if (c.isAnonymous()) {
                a = AccountStorage.f15744b.m15829a(c);
                if (a != null) {
                    header2.header(f15736f, a.getId());
                }
            }
        }
        chain = chain.proceed(header2.build());
        header = chain.header(f15733c);
        if (header != null) {
            Config.m9155b(header);
        }
        header = chain.header(f15732b);
        if (header != null) {
            Config.m9152a(header);
        }
        Intrinsics.a(chain, "chain.proceed(requestBui…onfig.setLoId(it) }\n    }");
        return chain;
    }
}
