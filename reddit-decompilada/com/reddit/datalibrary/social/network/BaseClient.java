package com.reddit.datalibrary.social.network;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.datalibrary.frontpage.data.common.interceptor.TimingInterceptor;
import com.reddit.datalibrary.frontpage.data.common.interceptor.TokenValidityInterceptor;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.InstabugUtil;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0004J)\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0004¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/social/network/BaseClient;", "", "()V", "buildHeaderMap", "", "", "createRetrofitService", "T", "baseUrl", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseClient.kt */
public abstract class BaseClient {
    protected static Map<String, String> m21774a() {
        Object obj;
        String str;
        StringBuilder stringBuilder;
        Map<String, String> hashMap = new HashMap();
        Object obj2 = Config.g;
        Intrinsics.m26843a(obj2, "Config.deviceId");
        hashMap.put("Client-Vendor-ID", obj2);
        obj2 = Config.g;
        Intrinsics.m26843a(obj2, "Config.deviceId");
        hashMap.put("x-reddit-device-id", obj2);
        obj2 = Config.b;
        Intrinsics.m26843a(obj2, "Config.userAgent");
        hashMap.put("User-Agent", obj2);
        obj2 = Config.f();
        Intrinsics.m26843a(obj2, "Config.getAdvertiserId()");
        hashMap.put("X-Dev-Ad-Id", obj2);
        CharSequence charSequence = Config.f;
        obj2 = 1;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    Object obj3 = Config.f;
                    Intrinsics.m26843a(obj3, "Config.sessionId");
                    hashMap.put("x-reddit-session", obj3);
                }
                charSequence = Config.h;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    obj2 = Config.h;
                    Intrinsics.m26843a(obj2, "Config.loId");
                    hashMap.put("x-reddit-loid", obj2);
                }
                obj = SessionManager.b();
                Intrinsics.m26843a(obj, "SessionManager.getInstance()");
                obj = obj.c();
                str = HttpRequest.HEADER_AUTHORIZATION;
                stringBuilder = new StringBuilder("Bearer ");
                Intrinsics.m26843a(obj, Session.TYPE_SESSION);
                stringBuilder.append(obj.b());
                hashMap.put(str, stringBuilder.toString());
                return hashMap;
            }
        }
        obj = 1;
        if (obj == null) {
            Object obj32 = Config.f;
            Intrinsics.m26843a(obj32, "Config.sessionId");
            hashMap.put("x-reddit-session", obj32);
        }
        charSequence = Config.h;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            obj2 = Config.h;
            Intrinsics.m26843a(obj2, "Config.loId");
            hashMap.put("x-reddit-loid", obj2);
        }
        obj = SessionManager.b();
        Intrinsics.m26843a(obj, "SessionManager.getInstance()");
        obj = obj.c();
        str = HttpRequest.HEADER_AUTHORIZATION;
        stringBuilder = new StringBuilder("Bearer ");
        Intrinsics.m26843a(obj, Session.TYPE_SESSION);
        stringBuilder.append(obj.b());
        hashMap.put(str, stringBuilder.toString());
        return hashMap;
    }

    protected static <T> T m21773a(String str, Class<T> cls) {
        Intrinsics.m26847b(str, "baseUrl");
        Intrinsics.m26847b(cls, "serviceClass");
        Builder addInterceptor = new Builder().addNetworkInterceptor(InstabugUtil.f21744a).addInterceptor(new TokenValidityInterceptor());
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a = a.t();
        Intrinsics.m26843a(a, "config");
        if (a.h()) {
            addInterceptor.addInterceptor(new TimingInterceptor());
        }
        return new Retrofit.Builder().a(str).a(GsonConverterFactory.a()).a(RxJava2CallAdapterFactory.a()).a(addInterceptor.build()).a().a(cls);
    }
}
