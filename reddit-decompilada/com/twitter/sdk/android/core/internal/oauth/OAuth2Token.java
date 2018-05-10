package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

public class OAuth2Token extends AuthToken implements Parcelable {
    public static final Creator<OAuth2Token> CREATOR = new C20661();
    @SerializedName(a = "token_type")
    public final String f30723c;
    @SerializedName(a = "access_token")
    public final String f30724d;

    static class C20661 implements Creator<OAuth2Token> {
        C20661() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OAuth2Token[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OAuth2Token(parcel);
        }
    }

    public boolean mo6583a() {
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public OAuth2Token(String str, String str2) {
        this.f30723c = str;
        this.f30724d = str2;
    }

    private OAuth2Token(Parcel parcel) {
        this.f30723c = parcel.readString();
        this.f30724d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f30723c);
        parcel.writeString(this.f30724d);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x003d;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x003d;
    L_0x0012:
        r5 = (com.twitter.sdk.android.core.internal.oauth.OAuth2Token) r5;
        r2 = r4.f30724d;
        if (r2 == 0) goto L_0x0023;
    L_0x0018:
        r2 = r4.f30724d;
        r3 = r5.f30724d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0028;
    L_0x0022:
        goto L_0x0027;
    L_0x0023:
        r2 = r5.f30724d;
        if (r2 == 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r2 = r4.f30723c;
        if (r2 == 0) goto L_0x0037;
    L_0x002c:
        r2 = r4.f30723c;
        r5 = r5.f30723c;
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x003c;
    L_0x0036:
        goto L_0x003b;
    L_0x0037:
        r5 = r5.f30723c;
        if (r5 == 0) goto L_0x003c;
    L_0x003b:
        return r1;
    L_0x003c:
        return r0;
    L_0x003d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.oauth.OAuth2Token.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.f30723c != null ? this.f30723c.hashCode() : 0);
        if (this.f30724d != null) {
            i = this.f30724d.hashCode();
        }
        return hashCode + i;
    }
}
