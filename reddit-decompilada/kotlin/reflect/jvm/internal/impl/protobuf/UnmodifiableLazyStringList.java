package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements RandomAccess, LazyStringList {
    private final LazyStringList f36134a;

    class C21442 implements Iterator<String> {
        Iterator<String> f25963a = this.f25964b.f36134a.iterator();
        final /* synthetic */ UnmodifiableLazyStringList f25964b;

        C21442(UnmodifiableLazyStringList unmodifiableLazyStringList) {
            this.f25964b = unmodifiableLazyStringList;
        }

        public boolean hasNext() {
            return this.f25963a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ Object next() {
            return (String) this.f25963a.next();
        }
    }

    public final LazyStringList mo6728b() {
        return this;
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f36134a = lazyStringList;
    }

    public int size() {
        return this.f36134a.size();
    }

    public final void mo6727a(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>(this) {
            ListIterator<String> f25960a = this.f25962c.f36134a.listIterator(i);
            final /* synthetic */ UnmodifiableLazyStringList f25962c;

            public boolean hasNext() {
                return this.f25960a.hasNext();
            }

            public boolean hasPrevious() {
                return this.f25960a.hasPrevious();
            }

            public int nextIndex() {
                return this.f25960a.nextIndex();
            }

            public int previousIndex() {
                return this.f25960a.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public /* synthetic */ void add(Object obj) {
                throw new UnsupportedOperationException();
            }

            public /* synthetic */ void set(Object obj) {
                throw new UnsupportedOperationException();
            }

            public /* bridge */ /* synthetic */ Object previous() {
                return (String) this.f25960a.previous();
            }

            public /* bridge */ /* synthetic */ Object next() {
                return (String) this.f25960a.next();
            }
        };
    }

    public Iterator<String> iterator() {
        return new C21442(this);
    }

    public final List<?> mo6726a() {
        return this.f36134a.mo6726a();
    }

    public /* bridge */ /* synthetic */ Object get(int i) {
        return (String) this.f36134a.get(i);
    }
}
