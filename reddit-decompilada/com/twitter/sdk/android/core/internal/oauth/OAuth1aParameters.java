package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.network.HttpRequest.Base64;
import io.fabric.sdk.android.services.network.UrlUtils;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

class OAuth1aParameters {
    private static final SecureRandom f23955g = new SecureRandom();
    final TwitterAuthConfig f23956a;
    final TwitterAuthToken f23957b;
    final String f23958c;
    final String f23959d;
    final String f23960e;
    final Map<String, String> f23961f;

    public OAuth1aParameters(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        this.f23956a = twitterAuthConfig;
        this.f23957b = twitterAuthToken;
        this.f23958c = str;
        this.f23959d = str2;
        this.f23960e = str3;
        this.f23961f = map;
    }

    static String m25873a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(System.nanoTime()));
        stringBuilder.append(String.valueOf(Math.abs(f23955g.nextLong())));
        return stringBuilder.toString();
    }

    static String m25876b() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    static String m25874a(TreeMap<String, String> treeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = treeMap.size();
        treeMap = treeMap.entrySet().iterator();
        int i = 0;
        while (treeMap.hasNext()) {
            Entry entry = (Entry) treeMap.next();
            stringBuilder.append(UrlUtils.m26424b(UrlUtils.m26424b((String) entry.getKey())));
            stringBuilder.append("%3D");
            stringBuilder.append(UrlUtils.m26424b(UrlUtils.m26424b((String) entry.getValue())));
            i++;
            if (i < size) {
                stringBuilder.append("%26");
            }
        }
        return stringBuilder.toString();
    }

    static void m25875a(StringBuilder stringBuilder, String str, String str2) {
        if (str2 != null) {
            stringBuilder.append(' ');
            stringBuilder.append(UrlUtils.m26424b(str));
            stringBuilder.append("=\"");
            stringBuilder.append(UrlUtils.m26424b(str2));
            stringBuilder.append("\",");
        }
    }

    final String m25877a(String str) {
        try {
            String str2 = this.f23957b != null ? this.f23957b.f30692c : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UrlUtils.m26421a(this.f23956a.f23927b));
            stringBuilder.append('&');
            stringBuilder.append(UrlUtils.m26421a(str2));
            str2 = stringBuilder.toString();
            str = str.getBytes("UTF8");
            Key secretKeySpec = new SecretKeySpec(str2.getBytes("UTF8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            str = instance.doFinal(str);
            return new String(Base64.m26401a(str, str.length), "UTF8");
        } catch (String str3) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to calculate signature", str3);
            return "";
        } catch (String str32) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to calculate signature", str32);
            return "";
        } catch (String str322) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to calculate signature", str322);
            return "";
        }
    }
}
