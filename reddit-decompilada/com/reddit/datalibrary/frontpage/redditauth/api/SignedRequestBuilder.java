package com.reddit.datalibrary.frontpage.redditauth.api;

import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.frontpage.auth.KeyUtil;
import com.reddit.frontpage.util.CryptoUtil;
import com.reddit.frontpage.util.URLEncoder;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

public class SignedRequestBuilder<T> extends RequestBuilder<T> {
    public SignedRequestBuilder(Cannon cannon, Type type) {
        super(cannon, type);
    }

    public final void mo3033a() {
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        String a = m16315a(this.i);
        byte[] bytes = KeyUtil.decryptSigningKey("a0c1e177d7afd4faaa3ee14f6ef712917c576a33dccd7381c63fed3312658bd8").getBytes();
        String a2 = m16315a(this.i);
        m16316a("X-hmac-signed-body", CryptoUtil.a(String.format(Locale.US, "Epoch:%d|Body:%s", new Object[]{Long.valueOf(toSeconds), a2}), bytes), toSeconds);
        m16316a("X-hmac-signed-result", CryptoUtil.a(String.format(Locale.US, "Epoch:%d|User-Agent:%s|Client-Vendor-ID:%s", new Object[]{Long.valueOf(toSeconds), Config.f10814b, Config.f10819g}), bytes), toSeconds);
        try {
            m9329a(a.getBytes("UTF-8"));
        } catch (Throwable e) {
            Timber.c(e, "Encoding not supported: %s", new Object[]{"UTF-8"});
        }
    }

    private void m16316a(String str, String str2, long j) {
        m9336c(str, String.format(Locale.US, "%d:%s:%d:%d:%s", new Object[]{Integer.valueOf(1), "android", Integer.valueOf(1), Long.valueOf(j), str2}));
    }

    private static String m16315a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                stringBuilder.append(URLEncoder.a((String) entry.getKey(), "UTF-8"));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.a((String) entry.getValue(), "UTF-8"));
                stringBuilder.append('&');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } catch (Map<String, String> map2) {
            Timber.c(map2, "Encoding not supported: %s", new Object[]{"UTF-8"});
            return null;
        }
    }
}
