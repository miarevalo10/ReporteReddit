package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new C03901();
    public final SchemeData[] f4247a;
    public final int f4248b;
    private int f4249c;

    static class C03901 implements Creator<DrmInitData> {
        C03901() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrmInitData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }
    }

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR = new C03911();
        final UUID f4241a;
        public final String f4242b;
        public final String f4243c;
        public final byte[] f4244d;
        public final boolean f4245e;
        private int f4246f;

        static class C03911 implements Creator<SchemeData> {
            C03911() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SchemeData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            this.f4241a = (UUID) Assertions.m4182a((Object) uuid);
            this.f4242b = str;
            this.f4243c = (String) Assertions.m4182a((Object) str2);
            this.f4244d = (byte[]) Assertions.m4182a((Object) bArr);
            this.f4245e = z;
        }

        SchemeData(Parcel parcel) {
            this.f4241a = new UUID(parcel.readLong(), parcel.readLong());
            this.f4242b = parcel.readString();
            this.f4243c = parcel.readString();
            this.f4244d = parcel.createByteArray();
            this.f4245e = parcel.readByte() != null ? true : null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return this.f4243c.equals(schemeData.f4243c) && Util.m4313a(this.f4241a, schemeData.f4241a) && Util.m4313a(this.f4242b, schemeData.f4242b) && Arrays.equals(this.f4244d, schemeData.f4244d) != null;
        }

        public final int hashCode() {
            if (this.f4246f == 0) {
                this.f4246f = (31 * ((((this.f4241a.hashCode() * 31) + (this.f4242b == null ? 0 : this.f4242b.hashCode())) * 31) + this.f4243c.hashCode())) + Arrays.hashCode(this.f4244d);
            }
            return this.f4246f;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f4241a.getMostSignificantBits());
            parcel.writeLong(this.f4241a.getLeastSignificantBits());
            parcel.writeString(this.f4242b);
            parcel.writeString(this.f4243c);
            parcel.writeByteArray(this.f4244d);
            parcel.writeByte((byte) this.f4245e);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (C0377C.f3971b.equals(schemeData.f4241a)) {
            return C0377C.f3971b.equals(schemeData2.f4241a) != null ? null : 1;
        } else {
            return schemeData.f4241a.compareTo(schemeData2.f4241a);
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        if (z) {
            schemeDataArr = (SchemeData[]) schemeDataArr.clone();
        }
        Arrays.sort(schemeDataArr, this);
        for (z = true; z < schemeDataArr.length; z++) {
            if (schemeDataArr[z - 1].f4241a.equals(schemeDataArr[z].f4241a)) {
                StringBuilder stringBuilder = new StringBuilder("Duplicate data for uuid: ");
                stringBuilder.append(schemeDataArr[z].f4241a);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        this.f4247a = schemeDataArr;
        this.f4248b = schemeDataArr.length;
    }

    DrmInitData(Parcel parcel) {
        this.f4247a = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f4248b = this.f4247a.length;
    }

    public final DrmInitData m3725a(String str) {
        int i;
        int i2 = 0;
        for (SchemeData schemeData : this.f4247a) {
            if (!Util.m4313a(schemeData.f4242b, (Object) str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return this;
        }
        SchemeData[] schemeDataArr = new SchemeData[this.f4247a.length];
        while (i2 < schemeDataArr.length) {
            SchemeData schemeData2 = this.f4247a[i2];
            if (!Util.m4313a(schemeData2.f4242b, (Object) str)) {
                schemeData2 = new SchemeData(schemeData2.f4241a, str, schemeData2.f4243c, schemeData2.f4244d, schemeData2.f4245e);
            }
            schemeDataArr[i2] = schemeData2;
            i2++;
        }
        return new DrmInitData(schemeDataArr);
    }

    public final int hashCode() {
        if (this.f4249c == 0) {
            this.f4249c = Arrays.hashCode(this.f4247a);
        }
        return this.f4249c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return Arrays.equals(this.f4247a, ((DrmInitData) obj).f4247a);
            }
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f4247a, 0);
    }
}
