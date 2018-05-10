package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Creator<ApicFrame> CREATOR = new C03941();
    public final String f16863a;
    public final String f16864b;
    public final int f16865c;
    public final byte[] f16866d;

    static class C03941 implements Creator<ApicFrame> {
        C03941() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ApicFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f16863a = str;
        this.f16864b = str2;
        this.f16865c = i;
        this.f16866d = bArr;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f16863a = parcel.readString();
        this.f16864b = parcel.readString();
        this.f16865c = parcel.readInt();
        this.f16866d = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ApicFrame apicFrame = (ApicFrame) obj;
                return this.f16865c == apicFrame.f16865c && Util.m4313a(this.f16863a, apicFrame.f16863a) && Util.m4313a(this.f16864b, apicFrame.f16864b) && Arrays.equals(this.f16866d, apicFrame.f16866d) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((527 + this.f16865c) * 31) + (this.f16863a != null ? this.f16863a.hashCode() : 0)) * 31;
        if (this.f16864b != null) {
            i = this.f16864b.hashCode();
        }
        return (31 * (hashCode + i)) + Arrays.hashCode(this.f16866d);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16863a);
        parcel.writeString(this.f16864b);
        parcel.writeInt(this.f16865c);
        parcel.writeByteArray(this.f16866d);
    }
}
