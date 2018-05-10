package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList f36132a = new LazyStringArrayList().mo6728b();
    private final List<Object> f36133b;

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        this.f36133b.add(i, (String) obj);
        this.modCount++;
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return m36324a(this.f36133b.set(i, (String) obj));
    }

    public LazyStringArrayList() {
        this.f36133b = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f36133b = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public int size() {
        return this.f36133b.size();
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).mo6726a();
        }
        i = this.f36133b.addAll(i, collection);
        this.modCount++;
        return i;
    }

    public void clear() {
        this.f36133b.clear();
        this.modCount++;
    }

    public final void mo6727a(ByteString byteString) {
        this.f36133b.add(byteString);
        this.modCount++;
    }

    private static String m36324a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).m27467e();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    public final List<?> mo6726a() {
        return Collections.unmodifiableList(this.f36133b);
    }

    public final LazyStringList mo6728b() {
        return new UnmodifiableLazyStringList(this);
    }

    public /* synthetic */ Object remove(int i) {
        Object remove = this.f36133b.remove(i);
        this.modCount++;
        return m36324a(remove);
    }

    public /* synthetic */ Object get(int i) {
        Object obj = this.f36133b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        String e;
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            e = byteString.m27467e();
            if (byteString.mo5875f()) {
                this.f36133b.set(i, e);
            }
            return e;
        }
        byte[] bArr = (byte[]) obj;
        e = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f36133b.set(i, e);
        }
        return e;
    }
}
