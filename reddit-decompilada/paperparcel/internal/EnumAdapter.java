package paperparcel.internal;

import android.os.Parcel;
import paperparcel.TypeAdapter;

public final class EnumAdapter<T extends Enum<T>> implements TypeAdapter<T> {
    private final Class<T> f41559a;

    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        parcel.writeString(((Enum) obj).name());
    }

    public EnumAdapter(Class<T> cls) {
        this.f41559a = cls;
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        return Enum.valueOf(this.f41559a, parcel.readString());
    }
}
