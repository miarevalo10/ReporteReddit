package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.twitter.sdk.android.core.TwitterAuthToken;

public class OAuthResponse implements Parcelable {
    public static final Creator<OAuthResponse> CREATOR = new C20671();
    public final TwitterAuthToken f23962a;
    public final String f23963b;
    public final long f23964c;

    static class C20671 implements Creator<OAuthResponse> {
        C20671() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OAuthResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OAuthResponse(parcel);
        }
    }

    public int describeContents() {
        return 0;
    }

    public OAuthResponse(TwitterAuthToken twitterAuthToken, String str, long j) {
        this.f23962a = twitterAuthToken;
        this.f23963b = str;
        this.f23964c = j;
    }

    private OAuthResponse(Parcel parcel) {
        this.f23962a = (TwitterAuthToken) parcel.readParcelable(TwitterAuthToken.class.getClassLoader());
        this.f23963b = parcel.readString();
        this.f23964c = parcel.readLong();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("authToken=");
        stringBuilder.append(this.f23962a);
        stringBuilder.append(",userName=");
        stringBuilder.append(this.f23963b);
        stringBuilder.append(",userId=");
        stringBuilder.append(this.f23964c);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f23962a, i);
        parcel.writeString(this.f23963b);
        parcel.writeLong(this.f23964c);
    }
}
