package android.support.v4.util;

import java.util.ConcurrentModificationException;

public class SimpleArrayMap<K, V> {
    static Object[] f1412b;
    static int f1413c;
    static Object[] f1414d;
    static int f1415e;
    int[] f1416f;
    Object[] f1417g;
    int f1418h;

    private int m1044a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.SimpleArrayMap.a():int
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.a():int");
    }

    private int m1045a(java.lang.Object r1, int r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.SimpleArrayMap.a(java.lang.Object, int):int
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.a(java.lang.Object, int):int");
    }

    public V put(K r1, V r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.SimpleArrayMap.put(java.lang.Object, java.lang.Object):V
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.put(java.lang.Object, java.lang.Object):V");
    }

    private static int m1046a(int[] r0, int r1, int r2) {
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
        r0 = android.support.v4.util.ContainerHelpers.m1006a(r0, r1, r2);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new java.util.ConcurrentModificationException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.a(int[], int, int):int");
    }

    private void m1048e(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f1414d != null) {
                    i = f1414d;
                    this.f1417g = i;
                    f1414d = (Object[]) i[0];
                    this.f1416f = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    f1415e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f1412b != null) {
                    i = f1412b;
                    this.f1417g = i;
                    f1412b = (Object[]) i[0];
                    this.f1416f = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    f1413c--;
                    return;
                }
            }
        }
        this.f1416f = new int[i];
        this.f1417g = new Object[(i << 1)];
    }

    private static void m1047a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f1415e < 10) {
                    objArr[0] = f1414d;
                    objArr[1] = iArr;
                    for (iArr = (i << 1) - 1; iArr >= 2; iArr--) {
                        objArr[iArr] = null;
                    }
                    f1414d = objArr;
                    f1415e += 1;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f1413c < 10) {
                    objArr[0] = f1412b;
                    objArr[1] = iArr;
                    for (iArr = (i << 1) - 1; iArr >= 2; iArr--) {
                        objArr[iArr] = null;
                    }
                    f1412b = objArr;
                    f1413c += 1;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.f1416f = ContainerHelpers.f1385a;
        this.f1417g = ContainerHelpers.f1387c;
        this.f1418h = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f1416f = ContainerHelpers.f1385a;
            this.f1417g = ContainerHelpers.f1387c;
        } else {
            m1048e(i);
        }
        this.f1418h = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            m1051a((SimpleArrayMap) simpleArrayMap);
        }
    }

    public void clear() {
        if (this.f1418h > 0) {
            int[] iArr = this.f1416f;
            Object[] objArr = this.f1417g;
            int i = this.f1418h;
            this.f1416f = ContainerHelpers.f1385a;
            this.f1417g = ContainerHelpers.f1387c;
            this.f1418h = 0;
            m1047a(iArr, objArr, i);
        }
        if (this.f1418h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void m1050a(int i) {
        int i2 = this.f1418h;
        if (this.f1416f.length < i) {
            int[] iArr = this.f1416f;
            Object[] objArr = this.f1417g;
            m1048e(i);
            if (this.f1418h > 0) {
                System.arraycopy(iArr, 0, this.f1416f, 0, i2);
                System.arraycopy(objArr, 0, this.f1417g, 0, i2 << 1);
            }
            m1047a(iArr, objArr, i2);
        }
        if (this.f1418h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m1049a(obj) >= null ? true : null;
    }

    public final int m1049a(Object obj) {
        return obj == null ? m1044a() : m1045a(obj, obj.hashCode());
    }

    final int m1052b(Object obj) {
        int i = this.f1418h * 2;
        Object[] objArr = this.f1417g;
        if (obj == null) {
            for (obj = 1; obj < i; obj += 2) {
                if (objArr[obj] == null) {
                    return obj >> 1;
                }
            }
        } else {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (obj.equals(objArr[i2])) {
                    return i2 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m1052b(obj) >= null ? true : null;
    }

    public V get(Object obj) {
        obj = m1049a(obj);
        return obj >= null ? this.f1417g[(obj << 1) + 1] : null;
    }

    public final K m1053b(int i) {
        return this.f1417g[i << 1];
    }

    public final V m1054c(int i) {
        return this.f1417g[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.f1418h <= 0;
    }

    public final void m1051a(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f1418h;
        m1050a(this.f1418h + i);
        int i2 = 0;
        if (this.f1418h != 0) {
            while (i2 < i) {
                put(simpleArrayMap.m1053b(i2), simpleArrayMap.m1054c(i2));
                i2++;
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f1416f, 0, this.f1416f, 0, i);
            System.arraycopy(simpleArrayMap.f1417g, 0, this.f1417g, 0, i << 1);
            this.f1418h = i;
        }
    }

    public V remove(Object obj) {
        obj = m1049a(obj);
        return obj >= null ? m1055d(obj) : null;
    }

    public final V m1055d(int i) {
        int i2 = i << 1;
        V v = this.f1417g[i2 + 1];
        int i3 = this.f1418h;
        int i4 = 0;
        if (i3 <= 1) {
            m1047a(this.f1416f, this.f1417g, i3);
            this.f1416f = ContainerHelpers.f1385a;
            this.f1417g = ContainerHelpers.f1387c;
        } else {
            int i5 = i3 - 1;
            int i6 = 8;
            if (this.f1416f.length <= 8 || this.f1418h >= this.f1416f.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(this.f1416f, i7, this.f1416f, i, i8);
                    System.arraycopy(this.f1417g, i7 << 1, this.f1417g, i2, i8 << 1);
                }
                i2 = i5 << 1;
                this.f1417g[i2] = null;
                this.f1417g[i2 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                Object obj = this.f1416f;
                Object obj2 = this.f1417g;
                m1048e(i6);
                if (i3 != this.f1418h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f1416f, 0, i);
                    System.arraycopy(obj2, 0, this.f1417g, 0, i2);
                }
                if (i < i5) {
                    i4 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(obj, i4, this.f1416f, i, i9);
                    System.arraycopy(obj2, i4 << 1, this.f1417g, i2, i9 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.f1418h) {
            throw new ConcurrentModificationException();
        }
        this.f1418h = i4;
        return v;
    }

    public int size() {
        return this.f1418h;
    }

    public boolean equals(java.lang.Object r7) {
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
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r7 instanceof android.support.v4.util.SimpleArrayMap;
        r2 = 0;
        if (r1 == 0) goto L_0x003f;
    L_0x0009:
        r7 = (android.support.v4.util.SimpleArrayMap) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r6.f1418h;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r1 >= r3) goto L_0x003c;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x001b:
        r3 = r6.m1053b(r1);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        r4 = r6.m1054c(r1);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0029:
        if (r5 != 0) goto L_0x0031;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x002b:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r3 != 0) goto L_0x0039;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0031:
        return r2;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0032:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r3 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x003c:
        return r0;
    L_0x003d:
        return r2;
    L_0x003e:
        return r2;
    L_0x003f:
        r1 = r7 instanceof java.util.Map;
        if (r1 == 0) goto L_0x0079;
    L_0x0043:
        r7 = (java.util.Map) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x0050;
    L_0x004f:
        return r2;
    L_0x0050:
        r1 = r2;
    L_0x0051:
        r3 = r6.f1418h;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r1 >= r3) goto L_0x0076;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x0055:
        r3 = r6.m1053b(r1);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        r4 = r6.m1054c(r1);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r4 != 0) goto L_0x006c;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x0063:
        if (r5 != 0) goto L_0x006b;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x0065:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r3 != 0) goto L_0x0073;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x006b:
        return r2;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x006c:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r3 != 0) goto L_0x0073;
    L_0x0072:
        return r2;
    L_0x0073:
        r1 = r1 + 1;
        goto L_0x0051;
    L_0x0076:
        return r0;
    L_0x0077:
        return r2;
    L_0x0078:
        return r2;
    L_0x0079:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int[] iArr = this.f1416f;
        Object[] objArr = this.f1417g;
        int i = this.f1418h;
        int i2 = 1;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1418h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1418h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            SimpleArrayMap b = m1053b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1054c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
