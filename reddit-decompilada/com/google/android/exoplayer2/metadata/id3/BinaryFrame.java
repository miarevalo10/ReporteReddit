package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Creator<BinaryFrame> CREATOR = new C03951();
    public final byte[] f16867a;

    static class C03951 implements Creator<BinaryFrame> {
        C03951() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BinaryFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f16867a = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.f16867a = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                BinaryFrame binaryFrame = (BinaryFrame) obj;
                return this.f.equals(binaryFrame.f) && Arrays.equals(this.f16867a, binaryFrame.f16867a) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (527 + this.f.hashCode())) + Arrays.hashCode(this.f16867a);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeByteArray(this.f16867a);
    }
}
