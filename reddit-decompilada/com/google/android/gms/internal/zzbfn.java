package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class zzbfn {
    public static int m5511a(Parcel parcel) {
        int readInt = parcel.readInt();
        int s = m5535s(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new zzbfo(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        s += dataPosition;
        if (s >= dataPosition) {
            if (s <= parcel.dataSize()) {
                return s;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Size read is invalid start=");
        stringBuilder.append(dataPosition);
        stringBuilder.append(" end=");
        stringBuilder.append(s);
        throw new zzbfo(stringBuilder.toString(), parcel);
    }

    public static <T extends Parcelable> T m5512a(Parcel parcel, int i, Creator<T> creator) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + i);
        return parcelable;
    }

    public static void m5513a(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m5535s(parcel, i));
    }

    private static void m5514a(Parcel parcel, int i, int i2) {
        i = m5535s(parcel, i);
        if (i != i2) {
            String toHexString = Integer.toHexString(i);
            StringBuilder stringBuilder = new StringBuilder(46 + String.valueOf(toHexString).length());
            stringBuilder.append("Expected size ");
            stringBuilder.append(i2);
            stringBuilder.append(" got ");
            stringBuilder.append(i);
            stringBuilder.append(" (0x");
            stringBuilder.append(toHexString);
            stringBuilder.append(")");
            throw new zzbfo(stringBuilder.toString(), parcel);
        }
    }

    private static void m5515b(Parcel parcel, int i, int i2) {
        if (i != i2) {
            String toHexString = Integer.toHexString(i);
            StringBuilder stringBuilder = new StringBuilder(46 + String.valueOf(toHexString).length());
            stringBuilder.append("Expected size ");
            stringBuilder.append(i2);
            stringBuilder.append(" got ");
            stringBuilder.append(i);
            stringBuilder.append(" (0x");
            stringBuilder.append(toHexString);
            stringBuilder.append(")");
            throw new zzbfo(stringBuilder.toString(), parcel);
        }
    }

    public static boolean m5516b(Parcel parcel, int i) {
        m5514a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static <T> T[] m5517b(Parcel parcel, int i, Creator<T> creator) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + i);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m5518c(Parcel parcel, int i, Creator<T> creator) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + i);
        return createTypedArrayList;
    }

    public static short m5519c(Parcel parcel, int i) {
        m5514a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m5520d(Parcel parcel, int i) {
        m5514a(parcel, i, 4);
        return parcel.readInt();
    }

    public static long m5521e(Parcel parcel, int i) {
        m5514a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m5522f(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        if (i == 0) {
            return null;
        }
        m5515b(parcel, i, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static float m5523g(Parcel parcel, int i) {
        m5514a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float m5524h(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        if (i == 0) {
            return null;
        }
        m5515b(parcel, i, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double m5525i(Parcel parcel, int i) {
        m5514a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double m5526j(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        if (i == 0) {
            return null;
        }
        m5515b(parcel, i, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static String m5527k(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + i);
        return readString;
    }

    public static IBinder m5528l(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + i);
        return readStrongBinder;
    }

    public static Bundle m5529m(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + i);
        return readBundle;
    }

    public static byte[] m5530n(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + i);
        return createByteArray;
    }

    public static String[] m5531o(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + i);
        return createStringArray;
    }

    public static ArrayList<Integer> m5532p(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + i);
        return arrayList;
    }

    public static ArrayList<String> m5533q(Parcel parcel, int i) {
        i = m5535s(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + i);
        return createStringArrayList;
    }

    public static void m5534r(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder stringBuilder = new StringBuilder(37);
            stringBuilder.append("Overread allowed size end=");
            stringBuilder.append(i);
            throw new zzbfo(stringBuilder.toString(), parcel);
        }
    }

    private static int m5535s(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }
}
