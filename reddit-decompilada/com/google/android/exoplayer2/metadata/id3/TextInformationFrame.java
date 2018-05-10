package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class TextInformationFrame extends Id3Frame {
    public static final Creator<TextInformationFrame> CREATOR = new C04011();
    public final String f16888a;
    public final String f16889b;

    static class C04011 implements Creator<TextInformationFrame> {
        C04011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TextInformationFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f16888a = str2;
        this.f16889b = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.f16888a = parcel.readString();
        this.f16889b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
                return this.f.equals(textInformationFrame.f) && Util.m4313a(this.f16888a, textInformationFrame.f16888a) && Util.m4313a(this.f16889b, textInformationFrame.f16889b) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * (((527 + this.f.hashCode()) * 31) + (this.f16888a != null ? this.f16888a.hashCode() : 0));
        if (this.f16889b != null) {
            i = this.f16889b.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f16888a);
        parcel.writeString(this.f16889b);
    }
}
