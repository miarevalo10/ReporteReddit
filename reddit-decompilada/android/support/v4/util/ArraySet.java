package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    static Object[] f1374a;
    static int f1375b;
    static Object[] f1376c;
    static int f1377d;
    private static final int[] f1378j = new int[0];
    private static final Object[] f1379k = new Object[0];
    final boolean f1380e;
    int[] f1381f;
    public Object[] f1382g;
    int f1383h;
    MapCollections<E, E> f1384i;

    class C10071 extends MapCollections<E, E> {
        final /* synthetic */ ArraySet f11445a;

        C10071(ArraySet arraySet) {
            this.f11445a = arraySet;
        }

        protected final int mo353a() {
            return this.f11445a.f1383h;
        }

        protected final Object mo355a(int i, int i2) {
            return this.f11445a.f1382g[i];
        }

        protected final int mo354a(Object obj) {
            return this.f11445a.m1003a(obj);
        }

        protected final int mo359b(Object obj) {
            return this.f11445a.m1003a(obj);
        }

        protected final Map<E, E> mo360b() {
            throw new UnsupportedOperationException("not a map");
        }

        protected final void mo358a(E e, E e2) {
            this.f11445a.add(e);
        }

        protected final E mo356a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        protected final void mo357a(int i) {
            this.f11445a.m1004a(i);
        }

        protected final void mo361c() {
            this.f11445a.clear();
        }
    }

    private int m999a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.ArraySet.a():int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.ArraySet.a():int");
    }

    private int m1000a(java.lang.Object r1, int r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.ArraySet.a(java.lang.Object, int):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.ArraySet.a(java.lang.Object, int):int");
    }

    public final boolean add(E r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.ArraySet.add(java.lang.Object):boolean
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.ArraySet.add(java.lang.Object):boolean");
    }

    private void m1002b(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (f1376c != null) {
                    i = f1376c;
                    this.f1382g = i;
                    f1376c = (Object[]) i[0];
                    this.f1381f = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    f1377d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (f1374a != null) {
                    i = f1374a;
                    this.f1382g = i;
                    f1374a = (Object[]) i[0];
                    this.f1381f = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    f1375b--;
                    return;
                }
            }
        }
        this.f1381f = new int[i];
        this.f1382g = new Object[i];
    }

    private static void m1001a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f1377d < 10) {
                    objArr[0] = f1376c;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    f1376c = objArr;
                    f1377d += 1;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f1375b < 10) {
                    objArr[0] = f1374a;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    f1374a = objArr;
                    f1375b += 1;
                }
            }
        }
    }

    public ArraySet() {
        this(0);
    }

    public ArraySet(byte b) {
        this((int) (byte) 7);
    }

    private ArraySet(int i) {
        this.f1380e = false;
        if (i == 0) {
            this.f1381f = f1378j;
            this.f1382g = f1379k;
        } else {
            m1002b(i);
        }
        this.f1383h = 0;
    }

    public final void clear() {
        if (this.f1383h != 0) {
            m1001a(this.f1381f, this.f1382g, this.f1383h);
            this.f1381f = f1378j;
            this.f1382g = f1379k;
            this.f1383h = 0;
        }
    }

    public final boolean contains(Object obj) {
        return m1003a(obj) >= null ? true : null;
    }

    public final int m1003a(Object obj) {
        if (obj == null) {
            return m999a();
        }
        return m1000a(obj, this.f1380e ? System.identityHashCode(obj) : obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.f1383h <= 0;
    }

    public final boolean remove(Object obj) {
        int a = m1003a(obj);
        if (a < null) {
            return null;
        }
        m1004a(a);
        return true;
    }

    public final E m1004a(int i) {
        E e = this.f1382g[i];
        if (this.f1383h <= 1) {
            m1001a(this.f1381f, this.f1382g, this.f1383h);
            this.f1381f = f1378j;
            this.f1382g = f1379k;
            this.f1383h = 0;
        } else {
            int i2 = 8;
            int i3;
            if (this.f1381f.length <= 8 || this.f1383h >= this.f1381f.length / 3) {
                this.f1383h--;
                if (i < this.f1383h) {
                    i3 = i + 1;
                    System.arraycopy(this.f1381f, i3, this.f1381f, i, this.f1383h - i);
                    System.arraycopy(this.f1382g, i3, this.f1382g, i, this.f1383h - i);
                }
                this.f1382g[this.f1383h] = null;
            } else {
                if (this.f1383h > 8) {
                    i2 = (this.f1383h >> 1) + this.f1383h;
                }
                Object obj = this.f1381f;
                Object obj2 = this.f1382g;
                m1002b(i2);
                this.f1383h--;
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f1381f, 0, i);
                    System.arraycopy(obj2, 0, this.f1382g, 0, i);
                }
                if (i < this.f1383h) {
                    i3 = i + 1;
                    System.arraycopy(obj, i3, this.f1381f, i, this.f1383h - i);
                    System.arraycopy(obj2, i3, this.f1382g, i, this.f1383h - i);
                }
            }
        }
        return e;
    }

    public final int size() {
        return this.f1383h;
    }

    public final Object[] toArray() {
        Object obj = new Object[this.f1383h];
        System.arraycopy(this.f1382g, 0, obj, 0, this.f1383h);
        return obj;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1383h) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1383h);
        }
        System.arraycopy(this.f1382g, 0, tArr, 0, this.f1383h);
        if (tArr.length > this.f1383h) {
            tArr[this.f1383h] = null;
        }
        return tArr;
    }

    public final boolean equals(java.lang.Object r5) {
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
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x002c;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();
        r3 = r5.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r4.f1383h;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        if (r1 >= r3) goto L_0x0029;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
    L_0x001b:
        r3 = r4.f1382g;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        r3 = r3[r1];	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        r3 = r5.contains(r3);	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        if (r3 != 0) goto L_0x0026;
    L_0x0025:
        return r2;
    L_0x0026:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x0029:
        return r0;
    L_0x002a:
        return r2;
    L_0x002b:
        return r2;
    L_0x002c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.ArraySet.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int[] iArr = this.f1381f;
        int i = 0;
        int i2 = 0;
        while (i < this.f1383h) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1383h * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1383h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            ArraySet arraySet = this.f1382g[i];
            if (arraySet != this) {
                stringBuilder.append(arraySet);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return null;
            }
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int size = this.f1383h + collection.size();
        boolean z = false;
        if (this.f1381f.length < size) {
            Object obj = this.f1381f;
            Object obj2 = this.f1382g;
            m1002b(size);
            if (this.f1383h > 0) {
                System.arraycopy(obj, 0, this.f1381f, 0, this.f1383h);
                System.arraycopy(obj2, 0, this.f1382g, 0, this.f1383h);
            }
            m1001a(obj, obj2, this.f1383h);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1383h - 1; i >= 0; i--) {
            if (!collection.contains(this.f1382g[i])) {
                m1004a(i);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.f1384i == null) {
            this.f1384i = new C10071(this);
        }
        return this.f1384i.m1036d().iterator();
    }
}
