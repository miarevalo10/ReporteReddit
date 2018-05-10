package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

public class Session<T extends AuthToken> {
    @SerializedName(a = "auth_token")
    public final T f23922a;
    @SerializedName(a = "id")
    public final long f23923b;

    public Session(T t) {
        if (t == null) {
            throw new IllegalArgumentException("AuthToken must not be null.");
        }
        this.f23922a = t;
        this.f23923b = 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                Session session = (Session) obj;
                if (this.f23923b != session.f23923b) {
                    return false;
                }
                if (this.f23922a != null) {
                    return this.f23922a.equals(session.f23922a);
                }
                return session.f23922a == null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * (this.f23922a != null ? this.f23922a.hashCode() : 0)) + ((int) (this.f23923b ^ (this.f23923b >>> 32)));
    }
}
