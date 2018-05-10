package paperparcel.internal;

import android.os.Parcel;
import java.io.Serializable;
import paperparcel.TypeAdapter;

public final class SerializableAdapter<T extends Serializable> implements TypeAdapter<T> {
    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        parcel.writeSerializable((Serializable) obj);
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        return parcel.readSerializable();
    }
}
