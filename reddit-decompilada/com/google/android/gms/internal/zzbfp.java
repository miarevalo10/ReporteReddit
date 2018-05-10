package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class zzbfp {
    public static int m5536a(Parcel parcel) {
        return m5555b(parcel, 20293);
    }

    public static void m5537a(Parcel parcel, int i) {
        m5558c(parcel, i);
    }

    public static void m5538a(Parcel parcel, int i, double d) {
        m5556b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m5539a(Parcel parcel, int i, float f) {
        m5556b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m5540a(Parcel parcel, int i, int i2) {
        m5556b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m5541a(Parcel parcel, int i, long j) {
        m5556b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m5542a(Parcel parcel, int i, Bundle bundle) {
        if (bundle != null) {
            i = m5555b(parcel, i);
            parcel.writeBundle(bundle);
            m5558c(parcel, i);
        }
    }

    public static void m5543a(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder != null) {
            i = m5555b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m5558c(parcel, i);
        }
    }

    public static void m5544a(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable != null) {
            i = m5555b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m5558c(parcel, i);
        }
    }

    public static void m5545a(Parcel parcel, int i, String str) {
        if (str != null) {
            i = m5555b(parcel, i);
            parcel.writeString(str);
            m5558c(parcel, i);
        }
    }

    public static void m5546a(Parcel parcel, int i, List<Integer> list) {
        if (list != null) {
            i = m5555b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            m5558c(parcel, i);
        }
    }

    public static void m5547a(Parcel parcel, int i, boolean z) {
        m5556b(parcel, i, 4);
        parcel.writeInt(z);
    }

    public static void m5548a(Parcel parcel, int i, byte[] bArr) {
        if (bArr != null) {
            i = m5555b(parcel, i);
            parcel.writeByteArray(bArr);
            m5558c(parcel, i);
        }
    }

    public static <T extends Parcelable> void m5549a(Parcel parcel, int i, T[] tArr, int i2) {
        if (tArr != null) {
            i = m5555b(parcel, i);
            parcel.writeInt(r1);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m5551a(parcel, parcelable, i2);
                }
            }
            m5558c(parcel, i);
        }
    }

    public static void m5550a(Parcel parcel, int i, String[] strArr) {
        if (strArr != null) {
            i = m5555b(parcel, i);
            parcel.writeStringArray(strArr);
            m5558c(parcel, i);
        }
    }

    private static <T extends Parcelable> void m5551a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void m5552a(Parcel parcel, Double d) {
        if (d != null) {
            m5556b(parcel, 8, 8);
            parcel.writeDouble(d.doubleValue());
        }
    }

    public static void m5553a(Parcel parcel, Long l) {
        if (l != null) {
            m5556b(parcel, 4, 8);
            parcel.writeLong(l.longValue());
        }
    }

    public static void m5554a(Parcel parcel, short s) {
        m5556b(parcel, 3, 4);
        parcel.writeInt(s);
    }

    private static int m5555b(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m5556b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    public static void m5557b(Parcel parcel, int i, List<String> list) {
        if (list != null) {
            i = m5555b(parcel, i);
            parcel.writeStringList(list);
            m5558c(parcel, i);
        }
    }

    private static void m5558c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void m5559c(Parcel parcel, int i, List<T> list) {
        if (list != null) {
            i = m5555b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m5551a(parcel, parcelable, 0);
                }
            }
            m5558c(parcel, i);
        }
    }
}
