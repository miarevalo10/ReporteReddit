package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.SerializationStrategy;

public class TwitterSession extends Session<TwitterAuthToken> {
    @SerializedName(a = "user_name")
    public final String f30704c;

    static class Serializer implements SerializationStrategy<TwitterSession> {
        private final Gson f30703a = new Gson();

        public final /* synthetic */ Object mo5461a(String str) {
            return m31729b(str);
        }

        private TwitterSession m31729b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return (TwitterSession) this.f30703a.a(str, TwitterSession.class);
                } catch (String str2) {
                    Fabric.m26243b().mo5562a("Twitter", str2.getMessage());
                }
            }
            return null;
        }

        private String m31728a(TwitterSession twitterSession) {
            if (!(twitterSession == null || twitterSession.f23922a == null)) {
                try {
                    return this.f30703a.b(twitterSession);
                } catch (TwitterSession twitterSession2) {
                    Fabric.m26243b().mo5562a("Twitter", twitterSession2.getMessage());
                }
            }
            return "";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                if (!super.equals(obj)) {
                    return false;
                }
                TwitterSession twitterSession = (TwitterSession) obj;
                if (this.f30704c != null) {
                    return this.f30704c.equals(twitterSession.f30704c);
                }
                return twitterSession.f30704c == null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.f30704c != null ? this.f30704c.hashCode() : 0);
    }
}
