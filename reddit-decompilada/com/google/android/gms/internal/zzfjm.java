package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzfjm<M extends zzfjm<M>> extends zzfjs {
    protected zzfjo f14454X;

    protected final boolean m13900a(com.google.android.gms.internal.zzfjj r1, int r2) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.gms.internal.zzfjm.a(com.google.android.gms.internal.zzfjj, int):boolean
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjm.a(com.google.android.gms.internal.zzfjj, int):boolean");
    }

    public final /* synthetic */ zzfjs mo1929c() throws CloneNotSupportedException {
        return (zzfjm) clone();
    }

    protected int mo1927a() {
        int i = 0;
        if (this.f14454X == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f14454X.f7548d) {
            i2 += this.f14454X.f7547c[i].m6192a();
            i++;
        }
        return i2;
    }

    public void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f14454X != null) {
            for (int i = 0; i < this.f14454X.f7548d; i++) {
                this.f14454X.f7547c[i].m6193a(com_google_android_gms_internal_zzfjk);
            }
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfjm com_google_android_gms_internal_zzfjm = (zzfjm) super.mo1929c();
        zzfjq.m6196a(this, com_google_android_gms_internal_zzfjm);
        return com_google_android_gms_internal_zzfjm;
    }
}
