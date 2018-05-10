package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TwitterAuthConfig implements Parcelable {
    public static final Creator<TwitterAuthConfig> CREATOR = new C20621();
    public final String f23926a;
    public final String f23927b;

    static class C20621 implements Creator<TwitterAuthConfig> {
        C20621() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TwitterAuthConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TwitterAuthConfig(parcel);
        }
    }

    public int describeContents() {
        return 0;
    }

    public TwitterAuthConfig(String str, String str2) {
        this.f23926a = m25848a(str);
        this.f23927b = m25848a(str2);
    }

    private TwitterAuthConfig(Parcel parcel) {
        this.f23926a = parcel.readString();
        this.f23927b = parcel.readString();
    }

    private static String m25848a(String str) {
        return str != null ? str.trim() : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23926a);
        parcel.writeString(this.f23927b);
    }
}
