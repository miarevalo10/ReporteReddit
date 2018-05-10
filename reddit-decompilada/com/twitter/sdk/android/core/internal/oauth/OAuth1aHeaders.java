package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import io.fabric.sdk.android.services.network.UrlUtils;
import java.net.URI;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class OAuth1aHeaders {
    public static String m25872a(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        OAuth1aParameters oAuth1aParameters = new OAuth1aParameters(twitterAuthConfig, twitterAuthToken, str, str2, str3, map);
        twitterAuthConfig = OAuth1aParameters.m25873a();
        twitterAuthToken = OAuth1aParameters.m25876b();
        URI create = URI.create(oAuth1aParameters.f23960e);
        TreeMap a = UrlUtils.m26423a(create, true);
        if (oAuth1aParameters.f23961f != null) {
            a.putAll(oAuth1aParameters.f23961f);
        }
        if (oAuth1aParameters.f23958c != null) {
            a.put("oauth_callback", oAuth1aParameters.f23958c);
        }
        a.put("oauth_consumer_key", oAuth1aParameters.f23956a.f23926a);
        a.put("oauth_nonce", twitterAuthConfig);
        a.put("oauth_signature_method", "HMAC-SHA1");
        a.put("oauth_timestamp", twitterAuthToken);
        if (!(oAuth1aParameters.f23957b == null || oAuth1aParameters.f23957b.f30691b == null)) {
            a.put("oauth_token", oAuth1aParameters.f23957b.f30691b);
        }
        a.put("oauth_version", "1.0");
        map = new StringBuilder();
        map.append(create.getScheme());
        map.append("://");
        map.append(create.getHost());
        map.append(create.getPath());
        str = map.toString();
        map = new StringBuilder();
        map.append(oAuth1aParameters.f23959d.toUpperCase(Locale.ENGLISH));
        map.append('&');
        map.append(UrlUtils.m26424b(str));
        map.append('&');
        map.append(OAuth1aParameters.m25874a(a));
        str = oAuth1aParameters.m25877a(map.toString());
        str3 = new StringBuilder("OAuth");
        OAuth1aParameters.m25875a(str3, "oauth_callback", oAuth1aParameters.f23958c);
        OAuth1aParameters.m25875a(str3, "oauth_consumer_key", oAuth1aParameters.f23956a.f23926a);
        OAuth1aParameters.m25875a(str3, "oauth_nonce", twitterAuthConfig);
        OAuth1aParameters.m25875a(str3, "oauth_signature", str);
        OAuth1aParameters.m25875a(str3, "oauth_signature_method", "HMAC-SHA1");
        OAuth1aParameters.m25875a(str3, "oauth_timestamp", twitterAuthToken);
        OAuth1aParameters.m25875a(str3, "oauth_token", oAuth1aParameters.f23957b != null ? oAuth1aParameters.f23957b.f30691b : null);
        OAuth1aParameters.m25875a(str3, "oauth_version", "1.0");
        return str3.substring(null, str3.length() - 1);
    }
}
