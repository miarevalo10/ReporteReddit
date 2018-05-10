package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class Lists {

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        final List<F> f8437a;
        final Function<? super F, ? extends T> f8438b;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.f8437a = (List) Preconditions.m6908a((Object) list);
            this.f8438b = (Function) Preconditions.m6908a((Object) function);
        }

        public void clear() {
            this.f8437a.clear();
        }

        public T get(int i) {
            return this.f8438b.apply(this.f8437a.get(i));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new TransformedListIterator<F, T>(this, this.f8437a.listIterator(i)) {
                final /* synthetic */ TransformingRandomAccessList f18452a;

                final T mo2401a(F f) {
                    return this.f18452a.f8438b.apply(f);
                }
            };
        }

        public boolean isEmpty() {
            return this.f8437a.isEmpty();
        }

        public T remove(int i) {
            return this.f8438b.apply(this.f8437a.remove(i));
        }

        public int size() {
            return this.f8437a.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        final List<F> f8439a;
        final Function<? super F, ? extends T> f8440b;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.f8439a = (List) Preconditions.m6908a((Object) list);
            this.f8440b = (Function) Preconditions.m6908a((Object) function);
        }

        public void clear() {
            this.f8439a.clear();
        }

        public int size() {
            return this.f8439a.size();
        }

        public ListIterator<T> listIterator(int i) {
            return new TransformedListIterator<F, T>(this, this.f8439a.listIterator(i)) {
                final /* synthetic */ TransformingSequentialList f18453a;

                final T mo2401a(F f) {
                    return this.f18453a.f8440b.apply(f);
                }
            };
        }
    }

    @SafeVarargs
    public static <E> ArrayList<E> m7162a(E... eArr) {
        Preconditions.m6908a((Object) eArr);
        CollectPreconditions.m7080a(2, "arraySize");
        Object arrayList = new ArrayList(Ints.m7284b(7));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> m7160a(int i) {
        CollectPreconditions.m7080a(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static <F, T> List<T> m7163a(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    static boolean m7164a(List<?> list, Object obj) {
        if (obj == Preconditions.m6908a((Object) list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.m7152a(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.m14557a(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int m7165b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (list.get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(list.get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        list = list.listIterator();
        while (list.hasNext()) {
            if (Objects.m14557a(obj, list.next())) {
                return list.previousIndex();
            }
        }
        return -1;
    }

    static int m7166c(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            if (obj == null) {
                for (obj = list.size() - 1; obj >= null; obj--) {
                    if (list.get(obj) == null) {
                        return obj;
                    }
                }
            } else {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (obj.equals(list.get(size))) {
                        return size;
                    }
                }
            }
            return -1;
        }
        list = list.listIterator(list.size());
        while (list.hasPrevious()) {
            if (Objects.m14557a(obj, list.previous())) {
                return list.nextIndex();
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> m7161a(Iterator<? extends E> it) {
        Collection arrayList = new ArrayList();
        Iterators.m7149a(arrayList, (Iterator) it);
        return arrayList;
    }
}
