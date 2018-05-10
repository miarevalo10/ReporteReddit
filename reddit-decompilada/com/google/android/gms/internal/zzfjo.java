package com.google.android.gms.internal;

public final class zzfjo implements Cloneable {
    static final zzfjp f7545a = new zzfjp();
    int[] f7546b;
    zzfjp[] f7547c;
    int f7548d;
    private boolean f7549e;

    zzfjo() {
        this(10);
    }

    private zzfjo(int i) {
        this.f7549e = false;
        i = m6187a(i);
        this.f7546b = new int[i];
        this.f7547c = new zzfjp[i];
        this.f7548d = 0;
    }

    static int m6187a(int i) {
        i <<= 2;
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                i = i3;
                break;
            }
        }
        return i / 4;
    }

    public final boolean m6188a() {
        return this.f7548d == 0;
    }

    final int m6189b(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.gms.internal.zzfjo.b(int):int
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjo.b(int):int");
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.f7548d;
        zzfjo com_google_android_gms_internal_zzfjo = new zzfjo(i);
        int i2 = 0;
        System.arraycopy(this.f7546b, 0, com_google_android_gms_internal_zzfjo.f7546b, 0, i);
        while (i2 < i) {
            if (this.f7547c[i2] != null) {
                com_google_android_gms_internal_zzfjo.f7547c[i2] = (zzfjp) this.f7547c[i2].clone();
            }
            i2++;
        }
        com_google_android_gms_internal_zzfjo.f7548d = i;
        return com_google_android_gms_internal_zzfjo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfjo)) {
            return false;
        }
        zzfjo com_google_android_gms_internal_zzfjo = (zzfjo) obj;
        if (this.f7548d != com_google_android_gms_internal_zzfjo.f7548d) {
            return false;
        }
        boolean z;
        int[] iArr = this.f7546b;
        int[] iArr2 = com_google_android_gms_internal_zzfjo.f7546b;
        int i = this.f7548d;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            boolean z2;
            zzfjp[] com_google_android_gms_internal_zzfjpArr = this.f7547c;
            zzfjp[] com_google_android_gms_internal_zzfjpArr2 = com_google_android_gms_internal_zzfjo.f7547c;
            int i3 = this.f7548d;
            for (i = 0; i < i3; i++) {
                if (!com_google_android_gms_internal_zzfjpArr[i].equals(com_google_android_gms_internal_zzfjpArr2[i])) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f7548d; i2++) {
            i = (((i * 31) + this.f7546b[i2]) * 31) + this.f7547c[i2].hashCode();
        }
        return i;
    }
}
