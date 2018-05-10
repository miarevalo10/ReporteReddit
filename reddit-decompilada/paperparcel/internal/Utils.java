package paperparcel.internal;

import android.os.Parcel;
import paperparcel.TypeAdapter;

public final class Utils {
    public static <T> TypeAdapter<T> m43242a(final TypeAdapter<T> typeAdapter) {
        return new TypeAdapter<T>() {
            public final T mo7872a(Parcel parcel) {
                return Utils.m43241a(parcel, typeAdapter);
            }

            public final void mo7873a(T t, Parcel parcel, int i) {
                Utils.m43243a(t, parcel, i, typeAdapter);
            }
        };
    }

    public static <T> T m43241a(Parcel parcel, TypeAdapter<T> typeAdapter) {
        return parcel.readInt() == 1 ? typeAdapter.mo7872a(parcel) : null;
    }

    public static <T> void m43243a(T t, Parcel parcel, int i, TypeAdapter<T> typeAdapter) {
        if (t == null) {
            parcel.writeInt(null);
            return;
        }
        parcel.writeInt(1);
        typeAdapter.mo7873a(t, parcel, i);
    }
}
