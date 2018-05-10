package com.twitter.sdk.android.core.internal.oauth;

import com.google.gson.annotations.SerializedName;

public class GuestAuthToken extends OAuth2Token {
    @SerializedName(a = "guest_token")
    public final String f34639b;

    public GuestAuthToken(String str, String str2, String str3) {
        super(str, str2);
        this.f34639b = str3;
    }

    public final boolean mo6583a() {
        return System.currentTimeMillis() >= this.a + 10800000;
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
                GuestAuthToken guestAuthToken = (GuestAuthToken) obj;
                if (this.f34639b == null) {
                    return guestAuthToken.f34639b == null;
                } else {
                    if (this.f34639b.equals(guestAuthToken.f34639b) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.f34639b != null ? this.f34639b.hashCode() : 0);
    }
}
