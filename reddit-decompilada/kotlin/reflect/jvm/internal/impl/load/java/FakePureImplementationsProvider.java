package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider f25624a = null;
    private static final HashMap<FqName, FqName> f25625b = null;

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
    }

    private FakePureImplementationsProvider() {
        f25624a = this;
        f25625b = new HashMap();
        m27143a(KotlinBuiltIns.f25420j.f25375V, m27141a("java.util.ArrayList", "java.util.LinkedList"));
        m27143a(KotlinBuiltIns.f25420j.f25377X, m27141a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        m27143a(KotlinBuiltIns.f25420j.f25378Y, m27141a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        m27143a(new FqName("java.util.function.Function"), m27141a("java.util.function.UnaryOperator"));
        m27143a(new FqName("java.util.function.BiFunction"), m27141a("java.util.function.BinaryOperator"));
    }

    public static FqName m27142a(FqName fqName) {
        Intrinsics.m26847b(fqName, "classFqName");
        return (FqName) f25625b.get(fqName);
    }

    private static void m27143a(FqName fqName, List<FqName> list) {
        Map map = f25625b;
        for (FqName a : list) {
            Pair a2 = TuplesKt.m26780a(a, fqName);
            map.put(a2.f25267a, a2.f25268b);
        }
    }

    private static List<FqName> m27141a(String... strArr) {
        Object[] objArr = (Object[]) strArr;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new FqName((String) obj));
        }
        return (List) arrayList;
    }
}
