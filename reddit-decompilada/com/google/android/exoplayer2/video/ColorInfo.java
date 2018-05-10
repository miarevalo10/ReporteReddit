package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Creator<ColorInfo> CREATOR = new C04281();
    public final int f5297a;
    public final int f5298b;
    public final int f5299c;
    public final byte[] f5300d;
    private int f5301e;

    static class C04281 implements Creator<ColorInfo> {
        C04281() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ColorInfo[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.f5297a = i;
        this.f5298b = i2;
        this.f5299c = i3;
        this.f5300d = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.f5297a = parcel.readInt();
        this.f5298b = parcel.readInt();
        this.f5299c = parcel.readInt();
        this.f5300d = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ColorInfo colorInfo = (ColorInfo) obj;
                if (this.f5297a == colorInfo.f5297a && this.f5298b == colorInfo.f5298b && this.f5299c == colorInfo.f5299c) {
                    if (Arrays.equals(this.f5300d, colorInfo.f5300d) != null) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ColorInfo(");
        stringBuilder.append(this.f5297a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5298b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5299c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5300d != null);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        if (this.f5301e == 0) {
            this.f5301e = (31 * (((((527 + this.f5297a) * 31) + this.f5298b) * 31) + this.f5299c)) + Arrays.hashCode(this.f5300d);
        }
        return this.f5301e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5297a);
        parcel.writeInt(this.f5298b);
        parcel.writeInt(this.f5299c);
        parcel.writeInt(this.f5300d != 0 ? 1 : 0);
        if (this.f5300d != 0) {
            parcel.writeByteArray(this.f5300d);
        }
    }
}
