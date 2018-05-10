package paperparcel;

import android.os.Parcel;

public interface TypeAdapter<T> {
    T mo7872a(Parcel parcel);

    void mo7873a(T t, Parcel parcel, int i);
}
