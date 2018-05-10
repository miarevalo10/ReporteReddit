package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

public abstract class NullableParcelConverter<T> implements ParcelConverter<T> {
    private static final int NOT_NULL = 1;
    private static final int NULL = -1;

    public abstract T mo6866a(Parcel parcel);

    public abstract void mo6867a(T t, Parcel parcel);

    public final void mo6362c(T t, Parcel parcel) {
        if (t == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        mo6867a(t, parcel);
    }

    public final T mo6361c(Parcel parcel) {
        if (parcel.readInt() == -1) {
            return null;
        }
        return mo6866a(parcel);
    }
}
