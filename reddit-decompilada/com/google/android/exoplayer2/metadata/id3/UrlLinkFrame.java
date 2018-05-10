package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class UrlLinkFrame extends Id3Frame {
    public static final Creator<UrlLinkFrame> CREATOR = new C04021();
    public final String f16890a;
    public final String f16891b;

    static class C04021 implements Creator<UrlLinkFrame> {
        C04021() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UrlLinkFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f16890a = str2;
        this.f16891b = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.f16890a = parcel.readString();
        this.f16891b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
                return this.f.equals(urlLinkFrame.f) && Util.m4313a(this.f16890a, urlLinkFrame.f16890a) && Util.m4313a(this.f16891b, urlLinkFrame.f16891b) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * (((527 + this.f.hashCode()) * 31) + (this.f16890a != null ? this.f16890a.hashCode() : 0));
        if (this.f16891b != null) {
            i = this.f16891b.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f16890a);
        parcel.writeString(this.f16891b);
    }
}
