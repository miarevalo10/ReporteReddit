package com.reddit.datalibrary.frontpage.requests.images;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/images/AdCookieExtractor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdCookieExtractor.kt */
public final class AdCookieExtractor implements Interceptor {
    public static final Companion f16334a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/images/AdCookieExtractor$Companion;", "", "()V", "REDDAID_COOKIE_KEY", "", "SET_COOKIE_HEADER", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdCookieExtractor.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final Response intercept(Chain chain) {
        boolean z;
        String header;
        CharSequence charSequence;
        int a;
        Intrinsics.b(chain, "chain");
        chain = chain.proceed(chain.request());
        CharSequence charSequence2 = Config.f10822j;
        if (charSequence2 != null) {
            if (charSequence2.length() != 0) {
                z = false;
                if (z) {
                    Intrinsics.a(chain, "response");
                    return chain;
                }
                header = chain.header("set-cookie");
                if (header != null) {
                    Intrinsics.a(chain, "response");
                    return chain;
                }
                Intrinsics.a(header, "cookie");
                charSequence = header;
                a = StringsKt.a(charSequence, "reddaid", 0, false, 6);
                if (a != -1) {
                    Intrinsics.a(chain, "response");
                    return chain;
                }
                header = header.substring(StringsKt.a(charSequence, Operation.EQUALS, a, false, 4) + 1, StringsKt.a(charSequence, ";", a, false, 4));
                Intrinsics.a(header, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Config.m9159d(header);
                Intrinsics.a(chain, "response");
                return chain;
            }
        }
        z = true;
        if (z) {
            header = chain.header("set-cookie");
            if (header != null) {
                Intrinsics.a(header, "cookie");
                charSequence = header;
                a = StringsKt.a(charSequence, "reddaid", 0, false, 6);
                if (a != -1) {
                    header = header.substring(StringsKt.a(charSequence, Operation.EQUALS, a, false, 4) + 1, StringsKt.a(charSequence, ";", a, false, 4));
                    Intrinsics.a(header, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Config.m9159d(header);
                    Intrinsics.a(chain, "response");
                    return chain;
                }
                Intrinsics.a(chain, "response");
                return chain;
            }
            Intrinsics.a(chain, "response");
            return chain;
        }
        Intrinsics.a(chain, "response");
        return chain;
    }
}
