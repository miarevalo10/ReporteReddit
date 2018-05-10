package android.support.v4.util;

public class LongSparseArray<E> implements Cloneable {
    public static final Object f1390a = new Object();
    public boolean f1391b;
    public long[] f1392c;
    public Object[] f1393d;
    public int f1394e;

    public final void m1017a(long r1, E r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.LongSparseArray.a(long, java.lang.Object):void
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LongSparseArray.a(long, java.lang.Object):void");
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1013d();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f1391b = false;
        if (i == 0) {
            this.f1392c = ContainerHelpers.f1386b;
            this.f1393d = ContainerHelpers.f1387c;
        } else {
            i = ContainerHelpers.m1009b(i);
            this.f1392c = new long[i];
            this.f1393d = new Object[i];
        }
        this.f1394e = 0;
    }

    private android.support.v4.util.LongSparseArray<E> m1013d() {
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
        r2 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001b }
        r0 = (android.support.v4.util.LongSparseArray) r0;	 Catch:{ CloneNotSupportedException -> 0x001b }
        r1 = r2.f1392c;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (long[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.f1392c = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r2.f1393d;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (java.lang.Object[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.f1393d = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        goto L_0x001c;
    L_0x001b:
        r0 = 0;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LongSparseArray.d():android.support.v4.util.LongSparseArray<E>");
    }

    public final void m1016a() {
        int i = this.f1394e;
        long[] jArr = this.f1392c;
        Object[] objArr = this.f1393d;
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            Object obj = objArr[i2];
            if (obj != f1390a) {
                if (i2 != i3) {
                    jArr[i3] = jArr[i2];
                    objArr[i3] = obj;
                    objArr[i2] = null;
                }
                i3++;
            }
            i2++;
        }
        this.f1391b = false;
        this.f1394e = i3;
    }

    public final int m1018b() {
        if (this.f1391b) {
            m1016a();
        }
        return this.f1394e;
    }

    public final long m1014a(int i) {
        if (this.f1391b) {
            m1016a();
        }
        return this.f1392c[i];
    }

    public final E m1019b(int i) {
        if (this.f1391b) {
            m1016a();
        }
        return this.f1393d[i];
    }

    public final void m1020c() {
        int i = this.f1394e;
        Object[] objArr = this.f1393d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1394e = 0;
        this.f1391b = false;
    }

    public String toString() {
        if (m1018b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1394e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1394e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1014a(i));
            stringBuilder.append('=');
            LongSparseArray b = m1019b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final E m1015a(long j) {
        j = ContainerHelpers.m1007a(this.f1392c, this.f1394e, j);
        if (j >= null) {
            if (this.f1393d[j] != f1390a) {
                return this.f1393d[j];
            }
        }
        return null;
    }
}
