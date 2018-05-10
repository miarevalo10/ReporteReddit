package org.parceler.converter;

import android.os.Parcel;
import java.util.Map;
import java.util.Map.Entry;
import org.parceler.TypeRangeParcelConverter;

public abstract class MapParcelConverter<K, V, M extends Map<K, V>> implements TypeRangeParcelConverter<Map<K, V>, M> {
    public abstract K mo7132a(Parcel parcel);

    public abstract M mo6864a();

    public abstract void mo7133a(K k, Parcel parcel);

    public abstract V mo7134b(Parcel parcel);

    public abstract void mo7135b(V v, Parcel parcel);

    public final /* synthetic */ void mo6362c(Object obj, Parcel parcel) {
        Map map = (Map) obj;
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            mo7133a(entry.getKey(), parcel);
            mo7135b(entry.getValue(), parcel);
        }
    }

    public final /* synthetic */ Object mo6361c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Map a = mo6864a();
        for (int i = 0; i < readInt; i++) {
            a.put(mo7132a(parcel), mo7134b(parcel));
        }
        return a;
    }
}
