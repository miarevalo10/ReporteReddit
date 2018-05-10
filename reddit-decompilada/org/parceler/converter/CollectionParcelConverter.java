package org.parceler.converter;

import android.os.Parcel;
import java.util.Collection;
import org.parceler.TypeRangeParcelConverter;

public abstract class CollectionParcelConverter<T, C extends Collection<T>> implements TypeRangeParcelConverter<Collection<T>, C> {
    public abstract T mo7130a(Parcel parcel);

    public abstract C mo6863a();

    public abstract void mo7131a(T t, Parcel parcel);

    public final /* synthetic */ void mo6362c(Object obj, Parcel parcel) {
        Collection<Object> collection = (Collection) obj;
        if (collection == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(collection.size());
        for (Object a : collection) {
            mo7131a(a, parcel);
        }
    }

    public final /* synthetic */ Object mo6361c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Collection a = mo6863a();
        for (int i = 0; i < readInt; i++) {
            a.add(mo7130a(parcel));
        }
        return a;
    }
}
