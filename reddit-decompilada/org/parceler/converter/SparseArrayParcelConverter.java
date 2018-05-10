package org.parceler.converter;

import android.os.Parcel;
import android.util.SparseArray;
import org.parceler.ParcelConverter;

public abstract class SparseArrayParcelConverter<T> implements ParcelConverter<SparseArray<T>> {
    public abstract T mo7136a(Parcel parcel);

    public abstract void mo7137a(T t, Parcel parcel);

    public final /* synthetic */ void mo6362c(Object obj, Parcel parcel) {
        SparseArray sparseArray = (SparseArray) obj;
        if (sparseArray == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            parcel.writeInt(sparseArray.keyAt(i));
            mo7137a(sparseArray.valueAt(i), parcel);
        }
    }

    public final /* synthetic */ Object mo6361c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray(readInt);
        for (int i = 0; i < readInt; i++) {
            sparseArray.append(parcel.readInt(), mo7136a(parcel));
        }
        return sparseArray;
    }
}
