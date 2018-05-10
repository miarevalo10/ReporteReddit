package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* compiled from: SmartSet.kt */
public final class SmartSet<T> extends AbstractSet<T> {
    public static final Companion f26429a = new Companion();
    private static final int f26430d = 5;
    private Object f26431b;
    private int f26432c;

    /* compiled from: SmartSet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static <T> SmartSet<T> m28116a() {
            return new SmartSet();
        }

        public static <T> SmartSet<T> m28117a(Collection<? extends T> collection) {
            Intrinsics.m26847b(collection, "set");
            SmartSet<T> smartSet = new SmartSet();
            smartSet.addAll(collection);
            return smartSet;
        }
    }

    /* compiled from: SmartSet.kt */
    private static final class ArrayIterator<T> implements Iterator<T>, KMutableIterator {
        private final Iterator<T> f36191a;

        public ArrayIterator(T[] tArr) {
            Intrinsics.m26847b(tArr, "array");
            this.f36191a = ArrayIteratorKt.m26834a(tArr);
        }

        public final boolean hasNext() {
            return this.f36191a.hasNext();
        }

        public final T next() {
            return this.f36191a.next();
        }

        public final /* synthetic */ void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: SmartSet.kt */
    private static final class SingletonIterator<T> implements Iterator<T>, KMutableIterator {
        private boolean f36192a = true;
        private final T f36193b;

        public SingletonIterator(T t) {
            this.f36193b = t;
        }

        public final T next() {
            if (this.f36192a) {
                this.f36192a = false;
                return this.f36193b;
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            return this.f36192a;
        }

        public final /* synthetic */ void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final <T> SmartSet<T> m28120b() {
        return Companion.m28116a();
    }

    private SmartSet() {
    }

    public final Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new SingletonIterator(this.f26431b);
        }
        if (size() < f26430d) {
            Object obj = this.f26431b;
            if (obj != null) {
                return new ArrayIterator((Object[]) obj);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object obj2 = this.f26431b;
        if (obj2 != null) {
            return TypeIntrinsics.m26873c(obj2).iterator();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
    }

    public final boolean add(T t) {
        if (size() == 0) {
            this.f26431b = t;
        } else if (size() == 1) {
            if (Intrinsics.m26845a(this.f26431b, (Object) t)) {
                return false;
            }
            this.f26431b = new Object[]{this.f26431b, t};
        } else if (size() < f26430d) {
            r0 = this.f26431b;
            if (r0 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Object[] objArr = (Object[]) r0;
            if (ArraysKt___ArraysKt.m36088a(objArr, (Object) t)) {
                return false;
            }
            if (size() == f26430d - 1) {
                r0 = SetsKt__SetsKt.m26804c(Arrays.copyOf(objArr, objArr.length));
                ((LinkedHashSet) r0).add(t);
            } else {
                r0 = Arrays.copyOf(objArr, size() + 1);
                Object[] objArr2 = (Object[]) r0;
                objArr2[objArr2.length - 1] = t;
            }
            this.f26431b = r0;
        } else {
            r0 = this.f26431b;
            if (r0 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
            } else if (TypeIntrinsics.m26873c(r0).add(t) == null) {
                return false;
            }
        }
        this.f26432c = size() + 1;
        return true;
    }

    public final void clear() {
        this.f26431b = null;
        this.f26432c = 0;
    }

    public final boolean contains(Object obj) {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return Intrinsics.m26845a(this.f26431b, obj);
        }
        Object obj2;
        if (size() < f26430d) {
            obj2 = this.f26431b;
            if (obj2 != null) {
                return ArraysKt___ArraysKt.m36088a((Object[]) obj2, obj);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        obj2 = this.f26431b;
        if (obj2 != null) {
            return ((Set) obj2).contains(obj);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Set<T>");
    }

    public final /* bridge */ int size() {
        return this.f26432c;
    }
}
