package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzf implements Creator<DataHolder> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = strArr;
        Bundle bundle = cursorWindowArr;
        int i2 = 0;
        int i3 = i2;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 != 1000) {
                switch (i4) {
                    case 1:
                        strArr = zzbfn.m5531o(parcel, readInt);
                        break;
                    case 2:
                        cursorWindowArr = (CursorWindow[]) zzbfn.m5517b(parcel, readInt, CursorWindow.CREATOR);
                        break;
                    case 3:
                        i3 = zzbfn.m5520d(parcel, readInt);
                        break;
                    case 4:
                        bundle = zzbfn.m5529m(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i2 = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        Parcel dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.f17317b = new Bundle();
        for (a = 0; a < dataHolder.f17316a.length; a++) {
            dataHolder.f17317b.putInt(dataHolder.f17316a[a], a);
        }
        dataHolder.f17319d = new int[dataHolder.f17318c.length];
        a = 0;
        while (i < dataHolder.f17318c.length) {
            dataHolder.f17319d[i] = a;
            a += dataHolder.f17318c[i].getNumRows() - (a - dataHolder.f17318c[i].getStartPosition());
            i++;
        }
        dataHolder.f17320e = a;
        return dataHolder;
    }
}
