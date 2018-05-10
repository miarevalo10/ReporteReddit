package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.SerializationStrategy;

public class GuestSession extends Session<GuestAuthToken> {

    public static class Serializer implements SerializationStrategy<GuestSession> {
        private final Gson f30678a = new GsonBuilder().a(GuestAuthToken.class, new AuthTokenAdapter()).a();

        public final /* synthetic */ Object mo5461a(String str) {
            return m31706b(str);
        }

        private GuestSession m31706b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return (GuestSession) this.f30678a.a(str, GuestSession.class);
                } catch (String str2) {
                    StringBuilder stringBuilder = new StringBuilder("Failed to deserialize session ");
                    stringBuilder.append(str2.getMessage());
                    Fabric.m26243b().mo5562a("Twitter", stringBuilder.toString());
                }
            }
            return null;
        }

        private String m31705a(GuestSession guestSession) {
            if (!(guestSession == null || guestSession.f23922a == null)) {
                try {
                    return this.f30678a.b(guestSession);
                } catch (GuestSession guestSession2) {
                    StringBuilder stringBuilder = new StringBuilder("Failed to serialize session ");
                    stringBuilder.append(guestSession2.getMessage());
                    Fabric.m26243b().mo5562a("Twitter", stringBuilder.toString());
                }
            }
            return "";
        }
    }

    public GuestSession(GuestAuthToken guestAuthToken) {
        super(guestAuthToken);
    }
}
