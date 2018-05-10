package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class DefaultDataSource implements DataSource {
    private final Context f13659a;
    private final TransferListener<? super DataSource> f13660b;
    private final DataSource f13661c;
    private DataSource f13662d;
    private DataSource f13663e;
    private DataSource f13664f;
    private DataSource f13665g;
    private DataSource f13666h;

    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, DataSource dataSource) {
        this.f13659a = context.getApplicationContext();
        this.f13660b = transferListener;
        this.f13661c = (DataSource) Assertions.m4182a((Object) dataSource);
    }

    public final long mo1435a(DataSpec dataSpec) throws IOException {
        Assertions.m4186b(this.f13666h == null);
        String scheme = dataSpec.f5167a.getScheme();
        if (Util.m4312a(dataSpec.f5167a)) {
            if (dataSpec.f5167a.getPath().startsWith("/android_asset/")) {
                this.f13666h = m12676c();
            } else {
                if (this.f13662d == null) {
                    this.f13662d = new FileDataSource(this.f13660b);
                }
                this.f13666h = this.f13662d;
            }
        } else if ("asset".equals(scheme)) {
            this.f13666h = m12676c();
        } else if ("content".equals(scheme)) {
            if (this.f13664f == null) {
                this.f13664f = new ContentDataSource(this.f13659a, this.f13660b);
            }
            this.f13666h = this.f13664f;
        } else if ("rtmp".equals(scheme)) {
            this.f13666h = m12677d();
        } else {
            this.f13666h = this.f13661c;
        }
        return this.f13666h.mo1435a(dataSpec);
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws IOException {
        return this.f13666h.mo1434a(bArr, i, i2);
    }

    public final Uri mo1437b() {
        return this.f13666h == null ? null : this.f13666h.mo1437b();
    }

    public final void mo1436a() throws IOException {
        if (this.f13666h != null) {
            try {
                this.f13666h.mo1436a();
            } finally {
                this.f13666h = null;
            }
        }
    }

    private DataSource m12676c() {
        if (this.f13663e == null) {
            this.f13663e = new AssetDataSource(this.f13659a, this.f13660b);
        }
        return this.f13663e;
    }

    private com.google.android.exoplayer2.upstream.DataSource m12677d() {
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
        r3 = this;
        r0 = r3.f13665g;
        if (r0 != 0) goto L_0x004f;
    L_0x0004:
        r0 = "com.google.android.exoplayer2.ext.rtmp.RtmpDataSource";	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r2 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = r0.newInstance(r1);	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = (com.google.android.exoplayer2.upstream.DataSource) r0;	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r3.f13665g = r0;	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        goto L_0x0047;
    L_0x001c:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x0025:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x002e:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x0037:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x0040:
        r0 = "DefaultDataSource";
        r1 = "Attempting to play RTMP stream without depending on the RTMP extension";
        android.util.Log.w(r0, r1);
    L_0x0047:
        r0 = r3.f13665g;
        if (r0 != 0) goto L_0x004f;
    L_0x004b:
        r0 = r3.f13661c;
        r3.f13665g = r0;
    L_0x004f:
        r0 = r3.f13665g;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultDataSource.d():com.google.android.exoplayer2.upstream.DataSource");
    }
}
