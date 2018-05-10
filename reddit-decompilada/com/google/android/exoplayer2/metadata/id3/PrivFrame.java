package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Creator<PrivFrame> CREATOR = new C04001();
    public final String f16886a;
    public final byte[] f16887b;

    static class C04001 implements Creator<PrivFrame> {
        C04001() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PrivFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f16886a = str;
        this.f16887b = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f16886a = parcel.readString();
        this.f16887b = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                PrivFrame privFrame = (PrivFrame) obj;
                return Util.m4313a(this.f16886a, privFrame.f16886a) && Arrays.equals(this.f16887b, privFrame.f16887b) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (527 + (this.f16886a != null ? this.f16886a.hashCode() : 0))) + Arrays.hashCode(this.f16887b);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16886a);
        parcel.writeByteArray(this.f16887b);
    }
}
