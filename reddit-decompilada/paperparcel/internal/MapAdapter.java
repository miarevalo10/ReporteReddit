package paperparcel.internal;

import android.os.Parcel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import paperparcel.TypeAdapter;

public final class MapAdapter<K, V> implements TypeAdapter<Map<K, V>> {
    private final TypeAdapter<K> f41561a;
    private final TypeAdapter<V> f41562b;

    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        Map map = (Map) obj;
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            this.f41561a.mo7873a(entry.getKey(), parcel, i);
            this.f41562b.mo7873a(entry.getValue(), parcel, i);
        }
    }

    public MapAdapter(TypeAdapter<K> typeAdapter, TypeAdapter<V> typeAdapter2) {
        this.f41561a = typeAdapter;
        this.f41562b = typeAdapter2;
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        int readInt = parcel.readInt();
        Map linkedHashMap = new LinkedHashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            linkedHashMap.put(this.f41561a.mo7872a(parcel), this.f41562b.mo7872a(parcel));
        }
        return linkedHashMap;
    }
}
