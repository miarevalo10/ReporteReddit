package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Creator<GeobFrame> CREATOR = new C03991();
    public final String f16882a;
    public final String f16883b;
    public final String f16884c;
    public final byte[] f16885d;

    static class C03991 implements Creator<GeobFrame> {
        C03991() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeobFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f16882a = str;
        this.f16883b = str2;
        this.f16884c = str3;
        this.f16885d = bArr;
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f16882a = parcel.readString();
        this.f16883b = parcel.readString();
        this.f16884c = parcel.readString();
        this.f16885d = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                GeobFrame geobFrame = (GeobFrame) obj;
                return Util.m4313a(this.f16882a, geobFrame.f16882a) && Util.m4313a(this.f16883b, geobFrame.f16883b) && Util.m4313a(this.f16884c, geobFrame.f16884c) && Arrays.equals(this.f16885d, geobFrame.f16885d) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((527 + (this.f16882a != null ? this.f16882a.hashCode() : 0)) * 31) + (this.f16883b != null ? this.f16883b.hashCode() : 0)) * 31;
        if (this.f16884c != null) {
            i = this.f16884c.hashCode();
        }
        return (31 * (hashCode + i)) + Arrays.hashCode(this.f16885d);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16882a);
        parcel.writeString(this.f16883b);
        parcel.writeString(this.f16884c);
        parcel.writeByteArray(this.f16885d);
    }
}
