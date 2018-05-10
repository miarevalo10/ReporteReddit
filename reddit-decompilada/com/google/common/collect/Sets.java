package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public final class Sets {

    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.m7258a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.m6908a((Object) collection));
        }
    }

    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements Serializable, NavigableSet<E> {
        private final NavigableSet<E> f19722a;
        private final SortedSet<E> f19723b;
        private transient UnmodifiableNavigableSet<E> f19724c;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.f19722a = (NavigableSet) Preconditions.m6908a((Object) navigableSet);
            this.f19723b = Collections.unmodifiableSortedSet(navigableSet);
        }

        protected final SortedSet<E> mo4298c() {
            return this.f19723b;
        }

        public final E lower(E e) {
            return this.f19722a.lower(e);
        }

        public final E floor(E e) {
            return this.f19722a.floor(e);
        }

        public final E ceiling(E e) {
            return this.f19722a.ceiling(e);
        }

        public final E higher(E e) {
            return this.f19722a.higher(e);
        }

        public final E pollFirst() {
            throw new UnsupportedOperationException();
        }

        public final E pollLast() {
            throw new UnsupportedOperationException();
        }

        public final NavigableSet<E> descendingSet() {
            NavigableSet<E> navigableSet = this.f19724c;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableSet unmodifiableNavigableSet = new UnmodifiableNavigableSet(this.f19722a.descendingSet());
            this.f19724c = unmodifiableNavigableSet;
            unmodifiableNavigableSet.f19724c = this;
            return unmodifiableNavigableSet;
        }

        public final Iterator<E> descendingIterator() {
            return Iterators.m7147a(this.f19722a.descendingIterator());
        }

        public final NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.m7256a(this.f19722a.subSet(e, z, e2, z2));
        }

        public final NavigableSet<E> headSet(E e, boolean z) {
            return Sets.m7256a(this.f19722a.headSet(e, z));
        }

        public final NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.m7256a(this.f19722a.tailSet(e, z));
        }

        protected final /* bridge */ /* synthetic */ Set mo4055b() {
            return this.f19723b;
        }

        protected final /* bridge */ /* synthetic */ Collection mo3603a() {
            return this.f19723b;
        }

        protected final /* bridge */ /* synthetic */ Object delegate() {
            return this.f19723b;
        }
    }

    static int m7252a(java.util.Set<?> r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.common.collect.Sets.a(java.util.Set):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 7 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.a(java.util.Set):int");
    }

    public static <E extends Enum<E>> ImmutableSet<E> m7253a(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return ImmutableSet.m14751e();
            }
            return ImmutableEnumSet.m19272a(EnumSet.copyOf(collection));
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return ImmutableSet.m14751e();
        }
        Collection of = EnumSet.of((Enum) it.next());
        Iterators.m7149a(of, it);
        return ImmutableEnumSet.m19272a(of);
    }

    public static <E> HashSet<E> m7254a() {
        return new HashSet();
    }

    public static <E> HashSet<E> m7255a(int i) {
        return new HashSet(Maps.m7220a(i));
    }

    public static <E> LinkedHashSet<E> m7260b() {
        return new LinkedHashSet();
    }

    static boolean m7257a(java.util.Set<?> r4, java.lang.Object r5) {
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
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x001e;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();	 Catch:{ NullPointerException -> 0x001d, NullPointerException -> 0x001d }
        r3 = r5.size();	 Catch:{ NullPointerException -> 0x001d, NullPointerException -> 0x001d }
        if (r1 != r3) goto L_0x001c;	 Catch:{ NullPointerException -> 0x001d, NullPointerException -> 0x001d }
    L_0x0015:
        r4 = r4.containsAll(r5);	 Catch:{ NullPointerException -> 0x001d, NullPointerException -> 0x001d }
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        return r2;
    L_0x001d:
        return r2;
    L_0x001e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.a(java.util.Set, java.lang.Object):boolean");
    }

    public static <E> NavigableSet<E> m7256a(NavigableSet<E> navigableSet) {
        if (!(navigableSet instanceof ImmutableCollection)) {
            if (!(navigableSet instanceof UnmodifiableNavigableSet)) {
                return new UnmodifiableNavigableSet(navigableSet);
            }
        }
        return navigableSet;
    }

    static boolean m7259a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean m7258a(Set<?> set, Collection<?> collection) {
        Preconditions.m6908a((Object) collection);
        if (collection instanceof Multiset) {
            Collection a = ((Multiset) collection).m7237a();
        }
        if (!(a instanceof Set) || a.size() <= set.size()) {
            return m7259a((Set) set, a.iterator());
        }
        return Iterators.m7151a(set.iterator(), a);
    }
}
