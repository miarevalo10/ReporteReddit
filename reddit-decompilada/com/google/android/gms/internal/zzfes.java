package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

public abstract class zzfes implements Serializable, Iterable<Byte> {
    public static final zzfes f7377a = new zzfez(zzffz.f7418b);
    private static final zzfew f7378c;
    int f7379b = 0;

    static {
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
        r0 = new com.google.android.gms.internal.zzfez;
        r1 = com.google.android.gms.internal.zzffz.f7418b;
        r0.<init>(r1);
        f7377a = r0;
        r0 = 0;
        r1 = "android.content.Context";	 Catch:{ ClassNotFoundException -> 0x0011 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0011 }
        r1 = 1;
        goto L_0x0012;
    L_0x0011:
        r1 = r0;
    L_0x0012:
        if (r1 == 0) goto L_0x001a;
    L_0x0014:
        r1 = new com.google.android.gms.internal.zzffa;
        r1.<init>(r0);
        goto L_0x001f;
    L_0x001a:
        r1 = new com.google.android.gms.internal.zzfeu;
        r1.<init>(r0);
    L_0x001f:
        f7378c = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfes.<clinit>():void");
    }

    zzfes() {
    }

    static int m5946a(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((((i | i2) | i4) | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Beginning index: ");
            stringBuilder.append(i);
            stringBuilder.append(" < 0");
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i2 < i) {
            r1 = new StringBuilder(66);
            r1.append("Beginning index larger than ending index: ");
            r1.append(i);
            r1.append(", ");
            r1.append(i2);
            throw new IndexOutOfBoundsException(r1.toString());
        } else {
            r1 = new StringBuilder(37);
            r1.append("End index: ");
            r1.append(i2);
            r1.append(" >= ");
            r1.append(i3);
            throw new IndexOutOfBoundsException(r1.toString());
        }
    }

    public static zzfes m5947a(String str) {
        return new zzfez(str.getBytes(zzffz.f7417a));
    }

    public static zzfes m5948a(byte[] bArr) {
        return m5949a(bArr, 0, bArr.length);
    }

    public static zzfes m5949a(byte[] bArr, int i, int i2) {
        return new zzfez(f7378c.mo1877a(bArr, i, i2));
    }

    static zzfes m5950b(byte[] bArr) {
        return new zzfez(bArr);
    }

    static zzfex m5951c(int i) {
        return new zzfex(i);
    }

    public abstract byte mo3502a(int i);

    public abstract int mo3503a();

    protected abstract int mo3504a(int i, int i2);

    abstract void mo3505a(zzfer com_google_android_gms_internal_zzfer) throws IOException;

    protected abstract void mo3506a(byte[] bArr, int i);

    public abstract zzfes mo3508b(int i);

    public final boolean m5958b() {
        return mo3503a() == 0;
    }

    public final byte[] m5959c() {
        int a = mo3503a();
        if (a == 0) {
            return zzffz.f7418b;
        }
        byte[] bArr = new byte[a];
        mo3506a(bArr, a);
        return bArr;
    }

    public abstract zzffb mo3509d();

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f7379b;
        if (i == 0) {
            i = mo3503a();
            i = mo3504a(i, i);
            if (i == 0) {
                i = 1;
            }
            this.f7379b = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfet(this);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo3503a())});
    }
}
