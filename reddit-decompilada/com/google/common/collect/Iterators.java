package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class Iterators {

    private static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> f8433a;
        private Iterator<? extends T> f8434b = Iterators.m7145a();
        private Iterator<? extends Iterator<? extends T>> f8435c;
        private Deque<Iterator<? extends Iterator<? extends T>>> f8436d;

        ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it) {
            this.f8435c = (Iterator) Preconditions.m6908a((Object) it);
        }

        public boolean hasNext() {
            while (!((Iterator) Preconditions.m6908a(this.f8434b)).hasNext()) {
                Iterator it;
                while (true) {
                    if (this.f8435c != null) {
                        if (this.f8435c.hasNext()) {
                            break;
                        }
                    }
                    if (this.f8436d == null || this.f8436d.isEmpty()) {
                        it = null;
                    } else {
                        this.f8435c = (Iterator) this.f8436d.removeFirst();
                    }
                }
                it = this.f8435c;
                this.f8435c = it;
                if (this.f8435c == null) {
                    return false;
                }
                this.f8434b = (Iterator) this.f8435c.next();
                if (this.f8434b instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) this.f8434b;
                    this.f8434b = concatenatedIterator.f8434b;
                    if (this.f8436d == null) {
                        this.f8436d = new ArrayDeque();
                    }
                    this.f8436d.addFirst(this.f8435c);
                    if (concatenatedIterator.f8436d != null) {
                        while (!concatenatedIterator.f8436d.isEmpty()) {
                            this.f8436d.addFirst(concatenatedIterator.f8436d.removeLast());
                        }
                    }
                    this.f8435c = concatenatedIterator.f8435c;
                }
            }
            return true;
        }

        public T next() {
            if (hasNext()) {
                this.f8433a = this.f8434b;
                return this.f8434b.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.m7082a(this.f8433a != null);
            this.f8433a.remove();
            this.f8433a = null;
        }
    }

    private static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        static final UnmodifiableListIterator<Object> f19262a = new ArrayItr(new Object[0]);
        private final T[] f19263b;
        private final int f19264c = 0;

        private ArrayItr(T[] tArr) {
            super(0, 0);
            this.f19263b = tArr;
        }

        protected final T mo4056a(int i) {
            return this.f19263b[this.f19264c + i];
        }
    }

    public static <T> UnmodifiableIterator<T> m7147a(final Iterator<? extends T> it) {
        Preconditions.m6908a((Object) it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new UnmodifiableIterator<T>() {
            public final boolean hasNext() {
                return it.hasNext();
            }

            public final T next() {
                return it.next();
            }
        };
    }

    public static boolean m7151a(Iterator<?> it, Collection<?> collection) {
        Preconditions.m6908a((Object) collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean m7150a(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.m6908a((Object) predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.mo2326a(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean m7152a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!Objects.m14557a(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext() == null) {
            return true;
        }
        return false;
    }

    public static String m7154b(Iterator<?> it) {
        StringBuilder stringBuilder = new StringBuilder("[");
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            obj = null;
            stringBuilder.append(it.next());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static <T> T m7155c(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder("expected one element but was: <");
        stringBuilder.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            stringBuilder.append(", ");
            stringBuilder.append(it.next());
        }
        if (it.hasNext() != null) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> boolean m7149a(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.m6908a((Object) collection);
        Preconditions.m6908a((Object) it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> Iterator<T> m7156d(Iterator<? extends Iterator<? extends T>> it) {
        return new ConcatenatedIterator(it);
    }

    public static <T> UnmodifiableIterator<T> m7153b(final Iterator<T> it, final Predicate<? super T> predicate) {
        Preconditions.m6908a((Object) it);
        Preconditions.m6908a((Object) predicate);
        return new AbstractIterator<T>() {
            protected final T mo3613a() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (predicate.mo2326a(next)) {
                        return next;
                    }
                }
                this.f14868a = State.DONE;
                return null;
            }
        };
    }

    public static <F, T> Iterator<T> m7148a(Iterator<F> it, final Function<? super F, ? extends T> function) {
        Preconditions.m6908a((Object) function);
        return new TransformedIterator<F, T>(it) {
            final T mo2401a(F f) {
                return function.apply(f);
            }
        };
    }

    static <T> T m7157e(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    static void m7158f(Iterator<?> it) {
        Preconditions.m6908a((Object) it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> UnmodifiableIterator<T> m7146a(final T t) {
        return new UnmodifiableIterator<T>() {
            boolean f14902a;

            public final boolean hasNext() {
                return !this.f14902a;
            }

            public final T next() {
                if (this.f14902a) {
                    throw new NoSuchElementException();
                }
                this.f14902a = true;
                return t;
            }
        };
    }

    static <T> ListIterator<T> m7159g(Iterator<T> it) {
        return (ListIterator) it;
    }

    static <T> UnmodifiableIterator<T> m7145a() {
        return ArrayItr.f19262a;
    }
}
