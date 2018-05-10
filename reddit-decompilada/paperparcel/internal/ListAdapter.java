package paperparcel.internal;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import paperparcel.TypeAdapter;

public final class ListAdapter<T> implements TypeAdapter<List<T>> {
    private final TypeAdapter<T> f41560a;

    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        List list = (List) obj;
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f41560a.mo7873a(list.get(i2), parcel, i);
        }
    }

    public ListAdapter(TypeAdapter<T> typeAdapter) {
        this.f41560a = typeAdapter;
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(this.f41560a.mo7872a(parcel));
        }
        return arrayList;
    }
}
