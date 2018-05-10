package android.support.design.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class DirectedAcyclicGraph<T> {
    final Pool<ArrayList<T>> f562a = new SimplePool(10);
    final SimpleArrayMap<T, ArrayList<T>> f563b = new SimpleArrayMap();
    private final ArrayList<T> f564c = new ArrayList();
    private final HashSet<T> f565d = new HashSet();

    DirectedAcyclicGraph() {
    }

    final void m250a(T t) {
        if (!this.f563b.containsKey(t)) {
            this.f563b.put(t, null);
        }
    }

    final List m251b(T t) {
        return (List) this.f563b.get(t);
    }

    final ArrayList<T> m249a() {
        this.f564c.clear();
        this.f565d.clear();
        int size = this.f563b.size();
        for (int i = 0; i < size; i++) {
            m248a(this.f563b.m1053b(i), this.f564c, this.f565d);
        }
        return this.f564c;
    }

    private void m248a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.f563b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m248a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }
}
