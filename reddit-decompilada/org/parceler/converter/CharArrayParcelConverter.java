package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

public class CharArrayParcelConverter implements ParcelConverter<char[]> {
    public final /* synthetic */ void mo6362c(Object obj, Parcel parcel) {
        char[] cArr = (char[]) obj;
        if (cArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(cArr.length);
        parcel.writeCharArray(cArr);
    }

    public final /* synthetic */ Object mo6361c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        char[] cArr = new char[readInt];
        parcel.readCharArray(cArr);
        return cArr;
    }
}
