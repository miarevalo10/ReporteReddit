package paperparcel.internal;

import android.os.Parcel;
import java.util.LinkedHashSet;
import java.util.Set;
import paperparcel.TypeAdapter;

public final class SetAdapter<T> implements TypeAdapter<Set<T>> {
    private final TypeAdapter<T> f41564a;

    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        Set<Object> set = (Set) obj;
        parcel.writeInt(set.size());
        for (Object a : set) {
            this.f41564a.mo7873a(a, parcel, i);
        }
    }

    public SetAdapter(TypeAdapter<T> typeAdapter) {
        this.f41564a = typeAdapter;
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        int readInt = parcel.readInt();
        Set linkedHashSet = new LinkedHashSet(readInt);
        for (int i = 0; i < readInt; i++) {
            linkedHashSet.add(this.f41564a.mo7872a(parcel));
        }
        return linkedHashSet;
    }
}
