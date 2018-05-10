package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class zzew {
    private static final ClassLoader f7373a = zzew.class.getClassLoader();

    private zzew() {
    }

    public static <T extends Parcelable> T m5937a(Parcel parcel, Creator<T> creator) {
        return parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel);
    }

    public static void m5938a(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static void m5939a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void m5940a(Parcel parcel, boolean z) {
        parcel.writeInt(z);
    }

    public static boolean m5941a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static ArrayList m5942b(Parcel parcel) {
        return parcel.readArrayList(f7373a);
    }

    public static void m5943b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }
}
