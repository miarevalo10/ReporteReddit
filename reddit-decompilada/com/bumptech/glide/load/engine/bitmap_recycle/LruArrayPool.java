package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {
    private final GroupedLinkedMap<Key, Object> f12474a;
    private final KeyPool f12475b;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f12476c;
    private final Map<Class<?>, ArrayAdapterInterface<?>> f12477d;
    private final int f12478e;
    private int f12479f;

    private static final class Key implements Poolable {
        int f12471a;
        Class<?> f12472b;
        private final KeyPool f12473c;

        Key(KeyPool keyPool) {
            this.f12473c = keyPool;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f12471a == key.f12471a && this.f12472b == key.f12472b) {
                return true;
            }
            return false;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Key{size=");
            stringBuilder.append(this.f12471a);
            stringBuilder.append("array=");
            stringBuilder.append(this.f12472b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final void mo929a() {
            this.f12473c.m2945a(this);
        }

        public final int hashCode() {
            return (31 * this.f12471a) + (this.f12472b != null ? this.f12472b.hashCode() : 0);
        }
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        final Key m11388a(int i, Class<?> cls) {
            Key key = (Key) m2946b();
            key.f12471a = i;
            key.f12472b = cls;
            return key;
        }

        protected final /* synthetic */ Poolable mo930a() {
            return new Key(this);
        }
    }

    public LruArrayPool() {
        this.f12474a = new GroupedLinkedMap();
        this.f12475b = new KeyPool();
        this.f12476c = new HashMap();
        this.f12477d = new HashMap();
        this.f12478e = 4194304;
    }

    public LruArrayPool(int i) {
        this.f12474a = new GroupedLinkedMap();
        this.f12475b = new KeyPool();
        this.f12476c = new HashMap();
        this.f12477d = new HashMap();
        this.f12478e = i;
    }

    public final synchronized <T> void mo950a(T t) {
        Class cls = t.getClass();
        ArrayAdapterInterface c = m11394c(cls);
        int a = c.mo942a((Object) t);
        int b = c.mo945b() * a;
        int i = 1;
        if ((b <= this.f12478e / 2 ? 1 : 0) != 0) {
            Key a2 = this.f12475b.m11388a(a, cls);
            this.f12474a.m2958a(a2, t);
            t = m11391b(cls);
            Integer num = (Integer) t.get(Integer.valueOf(a2.f12471a));
            Integer valueOf = Integer.valueOf(a2.f12471a);
            if (num != null) {
                i = 1 + num.intValue();
            }
            t.put(valueOf, Integer.valueOf(i));
            this.f12479f += b;
            m11392b(this.f12478e);
        }
    }

    public final synchronized <T> T mo947a(Class<T> cls) {
        return m11390a(this.f12475b.m11388a(8, cls), (Class) cls);
    }

    public final synchronized <T> T mo946a(int i, Class<T> cls) {
        Key a;
        Integer num = (Integer) m11391b((Class) cls).ceilingKey(Integer.valueOf(i));
        Object obj = 1;
        if (num != null) {
            Object obj2;
            if (this.f12479f != 0) {
                if (this.f12478e / this.f12479f < 2) {
                    obj2 = null;
                    if (obj2 == null) {
                        if (num.intValue() <= 8 * i) {
                        }
                    }
                    if (obj != null) {
                        a = this.f12475b.m11388a(num.intValue(), cls);
                    } else {
                        a = this.f12475b.m11388a(i, cls);
                    }
                }
            }
            obj2 = 1;
            if (obj2 == null) {
                if (num.intValue() <= 8 * i) {
                }
            }
            if (obj != null) {
                a = this.f12475b.m11388a(i, cls);
            } else {
                a = this.f12475b.m11388a(num.intValue(), cls);
            }
        }
        obj = null;
        if (obj != null) {
            a = this.f12475b.m11388a(num.intValue(), cls);
        } else {
            a = this.f12475b.m11388a(i, cls);
        }
        return m11390a(a, (Class) cls);
    }

    private <T> T m11390a(Key key, Class<T> cls) {
        ArrayAdapterInterface c = m11394c(cls);
        Object a = this.f12474a.m2957a((Poolable) key);
        if (a != null) {
            this.f12479f -= c.mo942a(a) * c.mo945b();
            m11393b(c.mo942a(a), cls);
        }
        if (a != null) {
            return a;
        }
        if (Log.isLoggable(c.mo944a(), 2) != null) {
            cls = c.mo944a();
            StringBuilder stringBuilder = new StringBuilder("Allocated ");
            stringBuilder.append(key.f12471a);
            stringBuilder.append(" bytes");
            Log.v(cls, stringBuilder.toString());
        }
        return c.mo943a(key.f12471a);
    }

    public final synchronized void mo948a() {
        m11392b(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo949a(int r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = 40;
        if (r2 < r0) goto L_0x000c;
    L_0x0005:
        r1.mo948a();	 Catch:{ all -> 0x000a }
        monitor-exit(r1);
        return;
    L_0x000a:
        r2 = move-exception;
        goto L_0x0018;
    L_0x000c:
        r0 = 20;
        if (r2 < r0) goto L_0x001a;
    L_0x0010:
        r2 = r1.f12478e;	 Catch:{ all -> 0x000a }
        r2 = r2 / 2;
        r1.m11392b(r2);	 Catch:{ all -> 0x000a }
        goto L_0x001a;
    L_0x0018:
        monitor-exit(r1);
        throw r2;
    L_0x001a:
        monitor-exit(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.a(int):void");
    }

    private void m11392b(int i) {
        while (this.f12479f > i) {
            Object a = this.f12474a.m2956a();
            Preconditions.m3217a(a);
            ArrayAdapterInterface c = m11394c(a.getClass());
            this.f12479f -= c.mo942a(a) * c.mo945b();
            m11393b(c.mo942a(a), a.getClass());
            if (Log.isLoggable(c.mo944a(), 2)) {
                String a2 = c.mo944a();
                StringBuilder stringBuilder = new StringBuilder("evicted: ");
                stringBuilder.append(c.mo942a(a));
                Log.v(a2, stringBuilder.toString());
            }
        }
    }

    private void m11393b(int i, Class<?> cls) {
        cls = m11391b((Class) cls);
        Integer num = (Integer) cls.get(Integer.valueOf(i));
        if (num == null) {
            StringBuilder stringBuilder = new StringBuilder("Tried to decrement empty size, size: ");
            stringBuilder.append(i);
            stringBuilder.append(", this: ");
            stringBuilder.append(this);
            throw new NullPointerException(stringBuilder.toString());
        } else if (num.intValue() == 1) {
            cls.remove(Integer.valueOf(i));
        } else {
            cls.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> m11391b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f12476c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.f12476c.put(cls, treeMap);
        return treeMap;
    }

    private <T> ArrayAdapterInterface<T> m11394c(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = (ArrayAdapterInterface) this.f12477d.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                StringBuilder stringBuilder = new StringBuilder("No array pool found for: ");
                stringBuilder.append(cls.getSimpleName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f12477d.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }
}
