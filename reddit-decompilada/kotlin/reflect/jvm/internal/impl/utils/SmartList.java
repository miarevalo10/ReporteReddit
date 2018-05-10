package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private int f26427a;
    private Object f26428b;

    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator f26425a = new EmptyIterator();

        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> m28109a() {
            return f26425a;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean f26426a;

        protected abstract T mo5951a();

        protected abstract void mo5952b();

        private SingletonIteratorBase() {
        }

        public final boolean hasNext() {
            return !this.f26426a;
        }

        public final T next() {
            if (this.f26426a) {
                throw new NoSuchElementException();
            }
            this.f26426a = true;
            mo5952b();
            return mo5951a();
        }
    }

    private class SingletonIterator extends SingletonIteratorBase<E> {
        final /* synthetic */ SmartList f33100a;
        private final int f33101b;

        public SingletonIterator(SmartList smartList) {
            this.f33100a = smartList;
            super();
            this.f33101b = smartList.modCount;
        }

        protected final E mo5951a() {
            return this.f33100a.f26428b;
        }

        protected final void mo5952b() {
            if (this.f33100a.modCount != this.f33101b) {
                StringBuilder stringBuilder = new StringBuilder("ModCount: ");
                stringBuilder.append(this.f33100a.modCount);
                stringBuilder.append("; expected: ");
                stringBuilder.append(this.f33101b);
                throw new ConcurrentModificationException(stringBuilder.toString());
            }
        }

        public void remove() {
            mo5952b();
            this.f33100a.clear();
        }
    }

    public E get(int i) {
        if (i >= 0) {
            if (i < this.f26427a) {
                if (this.f26427a == 1) {
                    return this.f26428b;
                }
                return ((Object[]) this.f26428b)[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.f26427a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public boolean add(E e) {
        if (this.f26427a == 0) {
            this.f26428b = e;
        } else if (this.f26427a == 1) {
            this.f26428b = new Object[]{this.f26428b, e};
        } else {
            Object obj = (Object[]) this.f26428b;
            int length = obj.length;
            if (this.f26427a >= length) {
                int i = ((length * 3) / 2) + 1;
                int i2 = this.f26427a + 1;
                if (i >= i2) {
                    i2 = i;
                }
                Object obj2 = new Object[i2];
                this.f26428b = obj2;
                System.arraycopy(obj, 0, obj2, 0, length);
                obj = obj2;
            }
            obj[this.f26427a] = e;
        }
        this.f26427a += 1;
        this.modCount += 1;
        return true;
    }

    public void add(int i, E e) {
        if (i >= 0) {
            if (i <= this.f26427a) {
                if (this.f26427a == 0) {
                    this.f26428b = e;
                } else if (this.f26427a == 1 && i == 0) {
                    this.f26428b = new Object[]{e, this.f26428b};
                } else {
                    Object obj = new Object[(this.f26427a + 1)];
                    if (this.f26427a == 1) {
                        obj[0] = this.f26428b;
                    } else {
                        Object[] objArr = (Object[]) this.f26428b;
                        System.arraycopy(objArr, 0, obj, 0, i);
                        System.arraycopy(objArr, i, obj, i + 1, this.f26427a - i);
                    }
                    obj[i] = e;
                    this.f26428b = obj;
                }
                this.f26427a++;
                this.modCount++;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.f26427a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int size() {
        return this.f26427a;
    }

    public void clear() {
        this.f26428b = null;
        this.f26427a = 0;
        this.modCount++;
    }

    public E set(int i, E e) {
        if (i >= 0) {
            if (i < this.f26427a) {
                if (this.f26427a == 1) {
                    i = this.f26428b;
                    this.f26428b = e;
                    return i;
                }
                Object[] objArr = (Object[]) this.f26428b;
                Object obj = objArr[i];
                objArr[i] = e;
                return obj;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.f26427a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public E remove(int i) {
        if (i >= 0) {
            if (i < this.f26427a) {
                if (this.f26427a == 1) {
                    i = this.f26428b;
                    this.f26428b = null;
                } else {
                    Object[] objArr = (Object[]) this.f26428b;
                    Object obj = objArr[i];
                    if (this.f26427a == 2) {
                        this.f26428b = objArr[1 - i];
                    } else {
                        int i2 = (this.f26427a - i) - 1;
                        if (i2 > 0) {
                            System.arraycopy(objArr, i + 1, objArr, i, i2);
                        }
                        objArr[this.f26427a - 1] = null;
                    }
                    i = obj;
                }
                this.f26427a--;
                this.modCount++;
                return i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Index: ");
        stringBuilder.append(i);
        stringBuilder.append(", Size: ");
        stringBuilder.append(this.f26427a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public Iterator<E> iterator() {
        if (this.f26427a == 0) {
            Iterator a = EmptyIterator.m28109a();
            if (a != null) {
                return a;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/SmartList", "iterator"}));
        } else if (this.f26427a == 1) {
            return new SingletonIterator(this);
        } else {
            Iterator<E> it = super.iterator();
            if (it != null) {
                return it;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/SmartList", "iterator"}));
        }
    }

    public void sort(Comparator<? super E> comparator) {
        if (this.f26427a >= 2) {
            Arrays.sort((Object[]) this.f26428b, 0, this.f26427a, comparator);
        }
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"a", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"}));
        }
        int length = tArr.length;
        Object[] objArr;
        if (this.f26427a == 1) {
            if (length != 0) {
                tArr[0] = this.f26428b;
            } else {
                objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                objArr[0] = this.f26428b;
                if (objArr != null) {
                    return objArr;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"}));
            }
        } else if (length < this.f26427a) {
            objArr = Arrays.copyOf((Object[]) this.f26428b, this.f26427a, tArr.getClass());
            if (objArr != null) {
                return objArr;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"}));
        } else if (this.f26427a != 0) {
            System.arraycopy(this.f26428b, 0, tArr, 0, this.f26427a);
        }
        if (length > this.f26427a) {
            tArr[this.f26427a] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"}));
    }
}
