package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public final class Collections2 {

    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> f8392a;
        final Function<? super F, ? extends T> f8393b;

        TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.f8392a = (Collection) Preconditions.m6908a((Object) collection);
            this.f8393b = (Function) Preconditions.m6908a((Object) function);
        }

        public void clear() {
            this.f8392a.clear();
        }

        public boolean isEmpty() {
            return this.f8392a.isEmpty();
        }

        public Iterator<T> iterator() {
            return Iterators.m7148a(this.f8392a.iterator(), this.f8393b);
        }

        public int size() {
            return this.f8392a.size();
        }
    }

    static boolean m7085a(java.util.Collection<?> r0, java.lang.Object r1) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        com.google.common.base.Preconditions.m6908a(r0);
        r0 = r0.contains(r1);	 Catch:{ ClassCastException -> 0x0008, ClassCastException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Collections2.a(java.util.Collection, java.lang.Object):boolean");
    }

    public static <F, T> Collection<T> m7084a(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }

    static StringBuilder m7083a(int i) {
        CollectPreconditions.m7080a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }
}
