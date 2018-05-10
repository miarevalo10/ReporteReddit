package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.Geofence;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Locale;

public final class zzcfs extends zzbfm implements Geofence {
    public static final Creator<zzcfs> CREATOR = new zzcft();
    private final String f17750a;
    private final long f17751b;
    private final short f17752c;
    private final double f17753d;
    private final double f17754e;
    private final float f17755f;
    private final int f17756g;
    private final int f17757h;
    private final int f17758i;

    public zzcfs(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        if (str != null) {
            if (str.length() <= 100) {
                StringBuilder stringBuilder;
                if (f <= 0.0f) {
                    stringBuilder = new StringBuilder(31);
                    stringBuilder.append("invalid radius: ");
                    stringBuilder.append(f);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                if (d <= 90.0d) {
                    if (d >= -90.0d) {
                        if (d2 <= 180.0d) {
                            if (d2 >= -180.0d) {
                                int i4 = i & 7;
                                if (i4 == 0) {
                                    StringBuilder stringBuilder2 = new StringBuilder(46);
                                    stringBuilder2.append("No supported transition specified: ");
                                    stringBuilder2.append(i);
                                    throw new IllegalArgumentException(stringBuilder2.toString());
                                }
                                this.f17752c = s;
                                this.f17750a = str;
                                this.f17753d = d;
                                this.f17754e = d2;
                                this.f17755f = f;
                                this.f17751b = j;
                                this.f17756g = i4;
                                this.f17757h = i2;
                                this.f17758i = i3;
                                return;
                            }
                        }
                        stringBuilder = new StringBuilder(43);
                        stringBuilder.append("invalid longitude: ");
                        stringBuilder.append(d2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder(42);
                stringBuilder.append("invalid latitude: ");
                stringBuilder.append(d);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        String str2 = "requestId is null or too long: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzcfs)) {
            return false;
        }
        zzcfs com_google_android_gms_internal_zzcfs = (zzcfs) obj;
        return this.f17755f == com_google_android_gms_internal_zzcfs.f17755f && this.f17753d == com_google_android_gms_internal_zzcfs.f17753d && this.f17754e == com_google_android_gms_internal_zzcfs.f17754e && this.f17752c == com_google_android_gms_internal_zzcfs.f17752c;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f17753d);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f17754e);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f17755f)) * 31) + this.f17752c) * 31) + this.f17756g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        String str = "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]";
        Object[] objArr = new Object[9];
        objArr[0] = this.f17752c != (short) 1 ? null : "CIRCLE";
        objArr[1] = this.f17750a.replaceAll("\\p{C}", Operation.EMPTY_PARAM);
        objArr[2] = Integer.valueOf(this.f17756g);
        objArr[3] = Double.valueOf(this.f17753d);
        objArr[4] = Double.valueOf(this.f17754e);
        objArr[5] = Float.valueOf(this.f17755f);
        objArr[6] = Integer.valueOf(this.f17757h / 1000);
        objArr[7] = Integer.valueOf(this.f17758i);
        objArr[8] = Long.valueOf(this.f17751b);
        return String.format(locale, str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f17750a);
        zzbfp.m5541a(parcel, 2, this.f17751b);
        zzbfp.m5554a(parcel, this.f17752c);
        zzbfp.m5538a(parcel, 4, this.f17753d);
        zzbfp.m5538a(parcel, 5, this.f17754e);
        zzbfp.m5539a(parcel, 6, this.f17755f);
        zzbfp.m5540a(parcel, 7, this.f17756g);
        zzbfp.m5540a(parcel, 8, this.f17757h);
        zzbfp.m5540a(parcel, 9, this.f17758i);
        zzbfp.m5537a(parcel, i);
    }
}
