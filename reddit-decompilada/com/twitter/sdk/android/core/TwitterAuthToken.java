package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class TwitterAuthToken extends AuthToken implements Parcelable {
    public static final Creator<TwitterAuthToken> CREATOR = new C20631();
    @SerializedName(a = "token")
    public final String f30691b;
    @SerializedName(a = "secret")
    public final String f30692c;

    static class C20631 implements Creator<TwitterAuthToken> {
        C20631() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TwitterAuthToken[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TwitterAuthToken(parcel);
        }
    }

    public int describeContents() {
        return 0;
    }

    public TwitterAuthToken(String str, String str2) {
        this.f30691b = str;
        this.f30692c = str2;
    }

    private TwitterAuthToken(Parcel parcel) {
        this.f30691b = parcel.readString();
        this.f30692c = parcel.readString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("token=");
        stringBuilder.append(this.f30691b);
        stringBuilder.append(",secret=");
        stringBuilder.append(this.f30692c);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f30691b);
        parcel.writeString(this.f30692c);
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
        r1 = r5 instanceof com.twitter.sdk.android.core.TwitterAuthToken;
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r5 = (com.twitter.sdk.android.core.TwitterAuthToken) r5;
        r1 = r4.f30692c;
        if (r1 == 0) goto L_0x001b;
    L_0x0010:
        r1 = r4.f30692c;
        r3 = r5.f30692c;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0020;
    L_0x001a:
        goto L_0x001f;
    L_0x001b:
        r1 = r5.f30692c;
        if (r1 == 0) goto L_0x0020;
    L_0x001f:
        return r2;
    L_0x0020:
        r1 = r4.f30691b;
        if (r1 == 0) goto L_0x002f;
    L_0x0024:
        r1 = r4.f30691b;
        r5 = r5.f30691b;
        r5 = r1.equals(r5);
        if (r5 != 0) goto L_0x0034;
    L_0x002e:
        goto L_0x0033;
    L_0x002f:
        r5 = r5.f30691b;
        if (r5 == 0) goto L_0x0034;
    L_0x0033:
        return r2;
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.TwitterAuthToken.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.f30691b != null ? this.f30691b.hashCode() : 0);
        if (this.f30692c != null) {
            i = this.f30692c.hashCode();
        }
        return hashCode + i;
    }
}
