package paperparcel.internal;

import android.os.Parcel;
import java.lang.reflect.Array;
import paperparcel.TypeAdapter;

public final class ArrayAdapter<T> implements TypeAdapter<T[]> {
    private final Class<T> f41557a;
    private final TypeAdapter<T> f41558b;

    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        parcel.writeInt(r1);
        for (Object a : (Object[]) obj) {
            this.f41558b.mo7873a(a, parcel, i);
        }
    }

    public ArrayAdapter(Class<T> cls, TypeAdapter<T> typeAdapter) {
        this.f41557a = cls;
        this.f41558b = typeAdapter;
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        int readInt = parcel.readInt();
        Object[] objArr = (Object[]) Array.newInstance(this.f41557a, readInt);
        for (int i = 0; i < readInt; i++) {
            objArr[i] = this.f41558b.mo7872a(parcel);
        }
        return objArr;
    }
}
