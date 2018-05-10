package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: collections.kt */
public final class CollectionsKt {
    public static final <K, V> Map<K, V> m28091a(Iterable<? extends K> iterable, Function1<? super K, ? extends V> function1) {
        Intrinsics.m26847b(iterable, "$receiver");
        Intrinsics.m26847b(function1, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : iterable) {
            Object a = function1.mo6492a(next);
            if (a != null) {
                linkedHashMap.put(next, a);
            }
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Integer> m28090a(Iterable<? extends K> iterable) {
        Intrinsics.m26847b(iterable, "$receiver");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        iterable = CollectionsKt___CollectionsKt.m41452q(iterable).iterator();
        while (iterable.hasNext()) {
            IndexedValue indexedValue = (IndexedValue) iterable.next();
            Map map = linkedHashMap;
            map.put(indexedValue.f25278b, Integer.valueOf(indexedValue.f25277a));
        }
        return linkedHashMap;
    }

    public static final <T> List<T> m28087a(T t) {
        return CollectionsKt__CollectionsKt.m26794b((Object) t);
    }

    public static final <T> void m28092a(Collection<T> collection, T t) {
        Intrinsics.m26847b(collection, "$receiver");
        if (t != null) {
            collection.add(t);
        }
    }

    public static final <K, V> HashMap<K, V> m28085a() {
        return new HashMap(m28093b(4));
    }

    public static final <E> HashSet<E> m28086a(int i) {
        return new HashSet(m28093b(i));
    }

    private static final int m28093b(int i) {
        return i < 3 ? 3 : (i + (i / 3)) + 1;
    }

    public static final <T> List<T> m28089a(Collection<? extends T> collection) {
        Intrinsics.m26847b(collection, "$receiver");
        switch (collection.size()) {
            case 0:
                return CollectionsKt__CollectionsKt.m26790a();
            case 1:
                return CollectionsKt__CollectionsKt.m26791a((Object) CollectionsKt___CollectionsKt.m41429d((Iterable) collection));
            default:
                return new ArrayList(collection);
        }
    }

    public static final <T> List<T> m28088a(ArrayList<T> arrayList) {
        Intrinsics.m26847b(arrayList, "$receiver");
        switch (arrayList.size()) {
            case 0:
                return CollectionsKt__CollectionsKt.m26790a();
            case 1:
                return CollectionsKt__CollectionsKt.m26791a((Object) CollectionsKt___CollectionsKt.m41430d((List) arrayList));
            default:
                arrayList.trimToSize();
                return arrayList;
        }
    }

    public static final <T> List<T> m28094b(T t) {
        return t != null ? CollectionsKt__CollectionsKt.m26791a((Object) t) : CollectionsKt__CollectionsKt.m26790a();
    }
}
