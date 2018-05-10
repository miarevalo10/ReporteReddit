package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new C03791();
    private int f4012A;
    public final String f4013a;
    public final int f4014b;
    public final String f4015c;
    public final Metadata f4016d;
    public final String f4017e;
    public final String f4018f;
    public final int f4019g;
    public final List<byte[]> f4020h;
    public final DrmInitData f4021i;
    public final int f4022j;
    public final int f4023k;
    public final float f4024l;
    public final int f4025m;
    public final float f4026n;
    public final int f4027o;
    public final byte[] f4028p;
    public final ColorInfo f4029q;
    public final int f4030r;
    public final int f4031s;
    public final int f4032t;
    public final int f4033u;
    public final int f4034v;
    public final long f4035w;
    public final int f4036x;
    public final String f4037y;
    public final int f4038z;

    static class C03791 implements Creator<Format> {
        C03791() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Format[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public static Format m3566a(String str, String str2, String str3, String str4, int i, int i2, int i3, float f, List<byte[]> list, int i4) {
        return new Format(str, str2, str3, str4, i, -1, i2, i3, f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format m3560a(String str, String str2, int i, int i2, List<byte[]> list, float f) {
        return m3559a(str, str2, -1, i, i2, list, -1, f, null, -1, null, null);
    }

    public static Format m3559a(String str, String str2, int i, int i2, int i3, List<byte[]> list, int i4, float f, byte[] bArr, int i5, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, null, -1, i, i2, i3, -1.0f, i4, f, bArr, i5, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format m3567a(String str, String str2, String str3, String str4, int i, int i2, int i3, List<byte[]> list, int i4, String str5) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str5, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format m3558a(String str, String str2, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, String str3) {
        return m3557a(str, str2, i, i2, i3, i4, -1, list, drmInitData, 0, str3);
    }

    public static Format m3557a(String str, String str2, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str3) {
        return m3556a(str, str2, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str3, null);
    }

    public static Format m3556a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str3, Metadata metadata) {
        return new Format(str, null, str2, null, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str3, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format m3565a(String str, String str2, String str3, int i, int i2, String str4) {
        return m3569a(str, str2, str3, null, i, i2, str4, -1);
    }

    public static Format m3569a(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, Long.MAX_VALUE, null, null, null);
    }

    public static Format m3555a(String str, String str2) {
        return m3563a(str, str2, 0, null, null);
    }

    public static Format m3563a(String str, String str2, int i, String str3, DrmInitData drmInitData) {
        return m3562a(str, str2, i, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format m3561a(String str, String str2, int i, String str3, int i2) {
        return m3562a(str, str2, i, str3, i2, null, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format m3564a(String str, String str2, long j) {
        return m3562a(null, str, 0, str2, -1, null, j, Collections.emptyList());
    }

    public static Format m3562a(String str, String str2, int i, String str3, int i2, DrmInitData drmInitData, long j, List<byte[]> list) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, i2, j, list, drmInitData, null);
    }

    public static Format m3570a(String str, String str2, List<byte[]> list, String str3, DrmInitData drmInitData) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str3, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format m3568a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format m3554a(String str, long j) {
        return new Format(null, null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
    }

    public static Format m3573b(String str, String str2) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.f4013a = str;
        this.f4017e = str2;
        this.f4018f = str3;
        this.f4015c = str4;
        this.f4014b = i;
        this.f4019g = i2;
        this.f4022j = i3;
        this.f4023k = i4;
        this.f4024l = f;
        this.f4025m = i5;
        this.f4026n = f2;
        this.f4028p = bArr;
        this.f4027o = i6;
        this.f4029q = colorInfo;
        this.f4030r = i7;
        this.f4031s = i8;
        this.f4032t = i9;
        this.f4033u = i10;
        this.f4034v = i11;
        this.f4036x = i12;
        this.f4037y = str5;
        this.f4038z = i13;
        this.f4035w = j;
        r0.f4020h = list == null ? Collections.emptyList() : list;
        r0.f4021i = drmInitData;
        r0.f4016d = metadata;
    }

    Format(Parcel parcel) {
        this.f4013a = parcel.readString();
        this.f4017e = parcel.readString();
        this.f4018f = parcel.readString();
        this.f4015c = parcel.readString();
        this.f4014b = parcel.readInt();
        this.f4019g = parcel.readInt();
        this.f4022j = parcel.readInt();
        this.f4023k = parcel.readInt();
        this.f4024l = parcel.readFloat();
        this.f4025m = parcel.readInt();
        this.f4026n = parcel.readFloat();
        int i = 0;
        this.f4028p = (parcel.readInt() != 0 ? 1 : 0) != 0 ? parcel.createByteArray() : null;
        this.f4027o = parcel.readInt();
        this.f4029q = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.f4030r = parcel.readInt();
        this.f4031s = parcel.readInt();
        this.f4032t = parcel.readInt();
        this.f4033u = parcel.readInt();
        this.f4034v = parcel.readInt();
        this.f4036x = parcel.readInt();
        this.f4037y = parcel.readString();
        this.f4038z = parcel.readInt();
        this.f4035w = parcel.readLong();
        int readInt = parcel.readInt();
        this.f4020h = new ArrayList(readInt);
        while (i < readInt) {
            this.f4020h.add(parcel.createByteArray());
            i++;
        }
        this.f4021i = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f4016d = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public final Format m3575a(long j) {
        String str = this.f4013a;
        String str2 = this.f4017e;
        String str3 = this.f4018f;
        String str4 = this.f4015c;
        int i = this.f4014b;
        int i2 = this.f4019g;
        int i3 = this.f4022j;
        int i4 = this.f4023k;
        float f = this.f4024l;
        int i5 = this.f4025m;
        float f2 = this.f4026n;
        byte[] bArr = this.f4028p;
        int i6 = this.f4027o;
        ColorInfo colorInfo = this.f4029q;
        ColorInfo colorInfo2 = colorInfo;
        return new Format(str, str2, str3, str4, i, i2, i3, i4, f, i5, f2, bArr, i6, colorInfo2, this.f4030r, this.f4031s, this.f4032t, this.f4033u, this.f4034v, this.f4036x, this.f4037y, this.f4038z, j, this.f4020h, this.f4021i, this.f4016d);
    }

    public final Format m3576a(DrmInitData drmInitData) {
        String str = this.f4013a;
        String str2 = this.f4017e;
        String str3 = this.f4018f;
        String str4 = this.f4015c;
        int i = this.f4014b;
        int i2 = this.f4019g;
        int i3 = this.f4022j;
        int i4 = this.f4023k;
        float f = this.f4024l;
        int i5 = this.f4025m;
        float f2 = this.f4026n;
        byte[] bArr = this.f4028p;
        int i6 = this.f4027o;
        ColorInfo colorInfo = this.f4029q;
        int i7 = this.f4030r;
        ColorInfo colorInfo2 = colorInfo;
        int i8 = this.f4031s;
        int i9 = this.f4032t;
        int i10 = this.f4033u;
        int i11 = this.f4034v;
        int i12 = this.f4036x;
        String str5 = this.f4037y;
        int i13 = i6;
        int i14 = this.f4038z;
        long j = this.f4035w;
        List list = this.f4020h;
        List list2 = list;
        return new Format(str, str2, str3, str4, i, i2, i3, i4, f, i5, f2, bArr, i13, colorInfo2, i7, i8, i9, i10, i11, i12, str5, i14, j, list2, drmInitData, this.f4016d);
    }

    public final int m3574a() {
        if (this.f4022j != -1) {
            if (this.f4023k != -1) {
                return this.f4022j * this.f4023k;
            }
        }
        return -1;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat m3577b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f4018f);
        String str = "language";
        String str2 = this.f4037y;
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
        m3572a(mediaFormat, "max-input-size", this.f4019g);
        m3572a(mediaFormat, "width", this.f4022j);
        m3572a(mediaFormat, "height", this.f4023k);
        str = "frame-rate";
        float f = this.f4024l;
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
        m3572a(mediaFormat, "rotation-degrees", this.f4025m);
        m3572a(mediaFormat, "channel-count", this.f4030r);
        m3572a(mediaFormat, "sample-rate", this.f4031s);
        m3572a(mediaFormat, "encoder-delay", this.f4033u);
        m3572a(mediaFormat, "encoder-padding", this.f4034v);
        for (int i = 0; i < this.f4020h.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder("csd-");
            stringBuilder.append(i);
            mediaFormat.setByteBuffer(stringBuilder.toString(), ByteBuffer.wrap((byte[]) this.f4020h.get(i)));
        }
        ColorInfo colorInfo = this.f4029q;
        if (colorInfo != null) {
            m3572a(mediaFormat, "color-transfer", colorInfo.f5299c);
            m3572a(mediaFormat, "color-standard", colorInfo.f5297a);
            m3572a(mediaFormat, "color-range", colorInfo.f5298b);
            str2 = "hdr-static-info";
            byte[] bArr = colorInfo.f5300d;
            if (bArr != null) {
                mediaFormat.setByteBuffer(str2, ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Format(");
        stringBuilder.append(this.f4013a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4017e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4018f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4014b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4037y);
        stringBuilder.append(", [");
        stringBuilder.append(this.f4022j);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4023k);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4024l);
        stringBuilder.append("], [");
        stringBuilder.append(this.f4030r);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4031s);
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        if (this.f4012A == 0) {
            int i = 0;
            int hashCode = 31 * (((((((((((((((((((((((527 + (this.f4013a == null ? 0 : this.f4013a.hashCode())) * 31) + (this.f4017e == null ? 0 : this.f4017e.hashCode())) * 31) + (this.f4018f == null ? 0 : this.f4018f.hashCode())) * 31) + (this.f4015c == null ? 0 : this.f4015c.hashCode())) * 31) + this.f4014b) * 31) + this.f4022j) * 31) + this.f4023k) * 31) + this.f4030r) * 31) + this.f4031s) * 31) + (this.f4037y == null ? 0 : this.f4037y.hashCode())) * 31) + this.f4038z) * 31) + (this.f4021i == null ? 0 : this.f4021i.hashCode()));
            if (this.f4016d != null) {
                i = this.f4016d.hashCode();
            }
            this.f4012A = hashCode + i;
        }
        return this.f4012A;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                Format format = (Format) obj;
                if (this.f4014b == format.f4014b && this.f4019g == format.f4019g && this.f4022j == format.f4022j && this.f4023k == format.f4023k && this.f4024l == format.f4024l && this.f4025m == format.f4025m && this.f4026n == format.f4026n && this.f4027o == format.f4027o && this.f4030r == format.f4030r && this.f4031s == format.f4031s && this.f4032t == format.f4032t && this.f4033u == format.f4033u && this.f4034v == format.f4034v && this.f4035w == format.f4035w && this.f4036x == format.f4036x && Util.m4313a(this.f4013a, format.f4013a) && Util.m4313a(this.f4037y, format.f4037y) && this.f4038z == format.f4038z && Util.m4313a(this.f4017e, format.f4017e) && Util.m4313a(this.f4018f, format.f4018f) && Util.m4313a(this.f4015c, format.f4015c) && Util.m4313a(this.f4021i, format.f4021i) && Util.m4313a(this.f4016d, format.f4016d) && Util.m4313a(this.f4029q, format.f4029q) && Arrays.equals(this.f4028p, format.f4028p)) {
                    if (this.f4020h.size() == format.f4020h.size()) {
                        for (int i = 0; i < this.f4020h.size(); i++) {
                            if (!Arrays.equals((byte[]) this.f4020h.get(i), (byte[]) format.f4020h.get(i))) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @TargetApi(16)
    private static void m3572a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static String m3571a(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=");
        stringBuilder.append(format.f4013a);
        stringBuilder.append(", mimeType=");
        stringBuilder.append(format.f4018f);
        if (format.f4014b != -1) {
            stringBuilder.append(", bitrate=");
            stringBuilder.append(format.f4014b);
        }
        if (!(format.f4022j == -1 || format.f4023k == -1)) {
            stringBuilder.append(", res=");
            stringBuilder.append(format.f4022j);
            stringBuilder.append("x");
            stringBuilder.append(format.f4023k);
        }
        if (format.f4024l != -1.0f) {
            stringBuilder.append(", fps=");
            stringBuilder.append(format.f4024l);
        }
        if (format.f4030r != -1) {
            stringBuilder.append(", channels=");
            stringBuilder.append(format.f4030r);
        }
        if (format.f4031s != -1) {
            stringBuilder.append(", sample_rate=");
            stringBuilder.append(format.f4031s);
        }
        if (format.f4037y != null) {
            stringBuilder.append(", language=");
            stringBuilder.append(format.f4037y);
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4013a);
        parcel.writeString(this.f4017e);
        parcel.writeString(this.f4018f);
        parcel.writeString(this.f4015c);
        parcel.writeInt(this.f4014b);
        parcel.writeInt(this.f4019g);
        parcel.writeInt(this.f4022j);
        parcel.writeInt(this.f4023k);
        parcel.writeFloat(this.f4024l);
        parcel.writeInt(this.f4025m);
        parcel.writeFloat(this.f4026n);
        parcel.writeInt(this.f4028p != null ? 1 : 0);
        if (this.f4028p != null) {
            parcel.writeByteArray(this.f4028p);
        }
        parcel.writeInt(this.f4027o);
        parcel.writeParcelable(this.f4029q, i);
        parcel.writeInt(this.f4030r);
        parcel.writeInt(this.f4031s);
        parcel.writeInt(this.f4032t);
        parcel.writeInt(this.f4033u);
        parcel.writeInt(this.f4034v);
        parcel.writeInt(this.f4036x);
        parcel.writeString(this.f4037y);
        parcel.writeInt(this.f4038z);
        parcel.writeLong(this.f4035w);
        i = this.f4020h.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            parcel.writeByteArray((byte[]) this.f4020h.get(i2));
        }
        parcel.writeParcelable(this.f4021i, 0);
        parcel.writeParcelable(this.f4016d, 0);
    }
}
