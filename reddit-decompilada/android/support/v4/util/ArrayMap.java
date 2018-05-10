package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    MapCollections<K, V> f11444a;

    class C10061 extends MapCollections<K, V> {
        final /* synthetic */ ArrayMap f11443a;

        C10061(ArrayMap arrayMap) {
            this.f11443a = arrayMap;
        }

        protected final int mo353a() {
            return this.f11443a.h;
        }

        protected final Object mo355a(int i, int i2) {
            return this.f11443a.g[(i << 1) + i2];
        }

        protected final int mo354a(Object obj) {
            return this.f11443a.m1049a(obj);
        }

        protected final int mo359b(Object obj) {
            return this.f11443a.m1052b(obj);
        }

        protected final Map<K, V> mo360b() {
            return this.f11443a;
        }

        protected final void mo358a(K k, V v) {
            this.f11443a.put(k, v);
        }

        protected final V mo356a(int i, V v) {
            SimpleArrayMap simpleArrayMap = this.f11443a;
            i = (i << 1) + 1;
            V v2 = simpleArrayMap.f1417g[i];
            simpleArrayMap.f1417g[i] = v;
            return v2;
        }

        protected final void mo357a(int i) {
            this.f11443a.m1055d(i);
        }

        protected final void mo361c() {
            this.f11443a.clear();
        }
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private MapCollections<K, V> m10127a() {
        if (this.f11444a == null) {
            this.f11444a = new C10061(this);
        }
        return this.f11444a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1050a(this.h + map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        MapCollections a = m10127a();
        if (a.f1407b == null) {
            a.f1407b = new EntrySet(a);
        }
        return a.f1407b;
    }

    public Set<K> keySet() {
        return m10127a().m1036d();
    }

    public Collection<V> values() {
        MapCollections a = m10127a();
        if (a.f1409d == null) {
            a.f1409d = new ValuesCollection(a);
        }
        return a.f1409d;
    }
}
