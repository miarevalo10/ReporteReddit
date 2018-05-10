package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

public class BooleanArrayParcelConverter implements ParcelConverter<boolean[]> {
    public final /* synthetic */ void mo6362c(Object obj, Parcel parcel) {
        boolean[] zArr = (boolean[]) obj;
        if (zArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(zArr.length);
        parcel.writeBooleanArray(zArr);
    }

    public final /* synthetic */ Object mo6361c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        parcel.readBooleanArray(zArr);
        return zArr;
    }
}
