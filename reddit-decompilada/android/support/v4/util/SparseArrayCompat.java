package android.support.v4.util;

public class SparseArrayCompat<E> implements Cloneable {
    public static final Object f1419a = new Object();
    public boolean f1420b;
    public Object[] f1421c;
    private int[] f1422d;
    private int f1423e;

    public final void m1060a(int r1, E r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v4.util.SparseArrayCompat.a(int, java.lang.Object):void
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SparseArrayCompat.a(int, java.lang.Object):void");
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1056c();
    }

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f1420b = false;
        if (i == 0) {
            this.f1422d = ContainerHelpers.f1385a;
            this.f1421c = ContainerHelpers.f1387c;
        } else {
            i = ContainerHelpers.m1005a(i);
            this.f1422d = new int[i];
            this.f1421c = new Object[i];
        }
        this.f1423e = 0;
    }

    private android.support.v4.util.SparseArrayCompat<E> m1056c() {
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
        r2 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001b }
        r0 = (android.support.v4.util.SparseArrayCompat) r0;	 Catch:{ CloneNotSupportedException -> 0x001b }
        r1 = r2.f1422d;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (int[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.f1422d = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r2.f1421c;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (java.lang.Object[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.f1421c = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        goto L_0x001c;
    L_0x001b:
        r0 = 0;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SparseArrayCompat.c():android.support.v4.util.SparseArrayCompat<E>");
    }

    private void m1057d() {
        int i = this.f1423e;
        int[] iArr = this.f1422d;
        Object[] objArr = this.f1421c;
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            Object obj = objArr[i2];
            if (obj != f1419a) {
                if (i2 != i3) {
                    iArr[i3] = iArr[i2];
                    objArr[i3] = obj;
                    objArr[i2] = null;
                }
                i3++;
            }
            i2++;
        }
        this.f1420b = false;
        this.f1423e = i3;
    }

    public final int m1058a() {
        if (this.f1420b) {
            m1057d();
        }
        return this.f1423e;
    }

    public final int m1064c(int i) {
        if (this.f1420b) {
            m1057d();
        }
        return this.f1422d[i];
    }

    public final E m1065d(int i) {
        if (this.f1420b) {
            m1057d();
        }
        return this.f1421c[i];
    }

    public final int m1066e(int i) {
        if (this.f1420b) {
            m1057d();
        }
        return ContainerHelpers.m1006a(this.f1422d, this.f1423e, i);
    }

    public final void m1061b() {
        int i = this.f1423e;
        Object[] objArr = this.f1421c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1423e = 0;
        this.f1420b = false;
    }

    public final void m1063b(int i, E e) {
        if (this.f1423e == 0 || i > this.f1422d[this.f1423e - 1]) {
            if (this.f1420b && this.f1423e >= this.f1422d.length) {
                m1057d();
            }
            int i2 = this.f1423e;
            if (i2 >= this.f1422d.length) {
                int a = ContainerHelpers.m1005a(i2 + 1);
                Object obj = new int[a];
                Object obj2 = new Object[a];
                System.arraycopy(this.f1422d, 0, obj, 0, this.f1422d.length);
                System.arraycopy(this.f1421c, 0, obj2, 0, this.f1421c.length);
                this.f1422d = obj;
                this.f1421c = obj2;
            }
            this.f1422d[i2] = i;
            this.f1421c[i2] = e;
            this.f1423e = i2 + 1;
            return;
        }
        m1060a(i, e);
    }

    public String toString() {
        if (m1058a() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1423e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1423e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1064c(i));
            stringBuilder.append('=');
            SparseArrayCompat d = m1065d(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final E m1059a(int i) {
        i = ContainerHelpers.m1006a(this.f1422d, this.f1423e, i);
        if (i >= 0) {
            if (this.f1421c[i] != f1419a) {
                return this.f1421c[i];
            }
        }
        return null;
    }

    public final void m1062b(int i) {
        i = ContainerHelpers.m1006a(this.f1422d, this.f1423e, i);
        if (i >= 0 && this.f1421c[i] != f1419a) {
            this.f1421c[i] = f1419a;
            this.f1420b = true;
        }
    }
}
