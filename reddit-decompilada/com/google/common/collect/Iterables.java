package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class Iterables {
    public static <T> boolean m7138a(Iterable<T> iterable, Predicate<? super T> predicate) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            return m7139a((List) iterable, (Predicate) Preconditions.m6908a((Object) predicate));
        }
        return Iterators.m7150a(iterable.iterator(), (Predicate) predicate);
    }

    private static <T> boolean m7139a(java.util.List<T> r6, com.google.common.base.Predicate<? super T> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = r0;
        r2 = r1;
    L_0x0003:
        r3 = r6.size();
        r4 = 1;
        if (r1 >= r3) goto L_0x0027;
    L_0x000a:
        r3 = r6.get(r1);
        r5 = r7.mo2326a(r3);
        if (r5 != 0) goto L_0x0024;
    L_0x0014:
        if (r1 <= r2) goto L_0x0022;
    L_0x0016:
        r6.set(r2, r3);	 Catch:{ UnsupportedOperationException -> 0x001e, IllegalArgumentException -> 0x001a }
        goto L_0x0022;
    L_0x001a:
        m7137a(r6, r7, r2, r1);
        return r4;
    L_0x001e:
        m7137a(r6, r7, r2, r1);
        return r4;
    L_0x0022:
        r2 = r2 + 1;
    L_0x0024:
        r1 = r1 + 1;
        goto L_0x0003;
    L_0x0027:
        r7 = r6.size();
        r6 = r6.subList(r2, r7);
        r6.clear();
        if (r1 == r2) goto L_0x0035;
    L_0x0034:
        return r4;
    L_0x0035:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterables.a(java.util.List, com.google.common.base.Predicate):boolean");
    }

    private static <T> void m7137a(List<T> list, Predicate<? super T> predicate, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (predicate.mo2326a(list.get(size))) {
                list.remove(size);
            }
        }
        for (i2--; i2 >= i; i2--) {
            list.remove(i2);
        }
    }

    public static String m7136a(Iterable<?> iterable) {
        return Iterators.m7154b(iterable.iterator());
    }

    public static <T> T m7142b(Iterable<T> iterable) {
        return Iterators.m7155c(iterable.iterator());
    }

    public static <T> T[] m7140a(Iterable<? extends T> iterable, Class<T> cls) {
        return m7144d(iterable).toArray(ObjectArrays.m7239a((Class) cls, 0));
    }

    static Object[] m7143c(Iterable<?> iterable) {
        return m7144d(iterable).toArray();
    }

    private static <E> Collection<E> m7144d(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.m7161a(iterable.iterator());
    }

    public static <T> Iterable<T> m7141b(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        Preconditions.m6908a((Object) iterable);
        Preconditions.m6908a((Object) predicate);
        return new FluentIterable<T>() {
            public final Iterator<T> iterator() {
                return Iterators.m7153b(iterable.iterator(), predicate);
            }
        };
    }

    public static <F, T> Iterable<T> m7135a(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.m6908a((Object) iterable);
        Preconditions.m6908a((Object) function);
        return new FluentIterable<T>() {
            public final Iterator<T> iterator() {
                return Iterators.m7148a(iterable.iterator(), function);
            }
        };
    }
}
