package com.google.android.exoplayer2.upstream;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource implements DataSource {
    private final Resources f13689a;
    private final TransferListener<? super RawResourceDataSource> f13690b;
    private Uri f13691c;
    private AssetFileDescriptor f13692d;
    private InputStream f13693e;
    private long f13694f;
    private boolean f13695g;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public final long mo1435a(com.google.android.exoplayer2.upstream.DataSpec r6) throws com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException {
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
        r5 = this;
        r0 = r6.f5167a;	 Catch:{ IOException -> 0x008d }
        r5.f13691c = r0;	 Catch:{ IOException -> 0x008d }
        r0 = "rawresource";	 Catch:{ IOException -> 0x008d }
        r1 = r5.f13691c;	 Catch:{ IOException -> 0x008d }
        r1 = r1.getScheme();	 Catch:{ IOException -> 0x008d }
        r0 = android.text.TextUtils.equals(r0, r1);	 Catch:{ IOException -> 0x008d }
        if (r0 != 0) goto L_0x001a;	 Catch:{ IOException -> 0x008d }
    L_0x0012:
        r6 = new com.google.android.exoplayer2.upstream.RawResourceDataSource$RawResourceDataSourceException;	 Catch:{ IOException -> 0x008d }
        r0 = "URI must use scheme rawresource";	 Catch:{ IOException -> 0x008d }
        r6.<init>(r0);	 Catch:{ IOException -> 0x008d }
        throw r6;	 Catch:{ IOException -> 0x008d }
    L_0x001a:
        r0 = r5.f13691c;	 Catch:{ NumberFormatException -> 0x0085 }
        r0 = r0.getLastPathSegment();	 Catch:{ NumberFormatException -> 0x0085 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0085 }
        r1 = r5.f13689a;	 Catch:{ IOException -> 0x008d }
        r0 = r1.openRawResourceFd(r0);	 Catch:{ IOException -> 0x008d }
        r5.f13692d = r0;	 Catch:{ IOException -> 0x008d }
        r0 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x008d }
        r1 = r5.f13692d;	 Catch:{ IOException -> 0x008d }
        r1 = r1.getFileDescriptor();	 Catch:{ IOException -> 0x008d }
        r0.<init>(r1);	 Catch:{ IOException -> 0x008d }
        r5.f13693e = r0;	 Catch:{ IOException -> 0x008d }
        r0 = r5.f13693e;	 Catch:{ IOException -> 0x008d }
        r1 = r5.f13692d;	 Catch:{ IOException -> 0x008d }
        r1 = r1.getStartOffset();	 Catch:{ IOException -> 0x008d }
        r0.skip(r1);	 Catch:{ IOException -> 0x008d }
        r0 = r5.f13693e;	 Catch:{ IOException -> 0x008d }
        r1 = r6.f5170d;	 Catch:{ IOException -> 0x008d }
        r0 = r0.skip(r1);	 Catch:{ IOException -> 0x008d }
        r2 = r6.f5170d;	 Catch:{ IOException -> 0x008d }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ IOException -> 0x008d }
        if (r0 >= 0) goto L_0x0058;	 Catch:{ IOException -> 0x008d }
    L_0x0052:
        r6 = new java.io.EOFException;	 Catch:{ IOException -> 0x008d }
        r6.<init>();	 Catch:{ IOException -> 0x008d }
        throw r6;	 Catch:{ IOException -> 0x008d }
    L_0x0058:
        r0 = r6.f5171e;	 Catch:{ IOException -> 0x008d }
        r2 = -1;	 Catch:{ IOException -> 0x008d }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ IOException -> 0x008d }
        if (r0 == 0) goto L_0x0065;	 Catch:{ IOException -> 0x008d }
    L_0x0060:
        r0 = r6.f5171e;	 Catch:{ IOException -> 0x008d }
        r5.f13694f = r0;	 Catch:{ IOException -> 0x008d }
        goto L_0x0076;	 Catch:{ IOException -> 0x008d }
    L_0x0065:
        r0 = r5.f13692d;	 Catch:{ IOException -> 0x008d }
        r0 = r0.getLength();	 Catch:{ IOException -> 0x008d }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ IOException -> 0x008d }
        if (r4 != 0) goto L_0x0070;	 Catch:{ IOException -> 0x008d }
    L_0x006f:
        goto L_0x0074;	 Catch:{ IOException -> 0x008d }
    L_0x0070:
        r2 = r6.f5170d;	 Catch:{ IOException -> 0x008d }
        r2 = r0 - r2;	 Catch:{ IOException -> 0x008d }
    L_0x0074:
        r5.f13694f = r2;	 Catch:{ IOException -> 0x008d }
    L_0x0076:
        r6 = 1;
        r5.f13695g = r6;
        r6 = r5.f13690b;
        if (r6 == 0) goto L_0x0082;
    L_0x007d:
        r6 = r5.f13690b;
        r6.mo1473b();
    L_0x0082:
        r0 = r5.f13694f;
        return r0;
    L_0x0085:
        r6 = new com.google.android.exoplayer2.upstream.RawResourceDataSource$RawResourceDataSourceException;	 Catch:{ IOException -> 0x008d }
        r0 = "Resource identifier must be an integer.";	 Catch:{ IOException -> 0x008d }
        r6.<init>(r0);	 Catch:{ IOException -> 0x008d }
        throw r6;	 Catch:{ IOException -> 0x008d }
    L_0x008d:
        r6 = move-exception;
        r0 = new com.google.android.exoplayer2.upstream.RawResourceDataSource$RawResourceDataSourceException;
        r0.<init>(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.RawResourceDataSource.a(com.google.android.exoplayer2.upstream.DataSpec):long");
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return null;
        }
        if (this.f13694f == 0) {
            return -1;
        }
        try {
            if (this.f13694f != -1) {
                i2 = (int) Math.min(this.f13694f, (long) i2);
            }
            bArr = this.f13693e.read(bArr, i, i2);
            if (bArr != -1) {
                if (this.f13694f != -1) {
                    this.f13694f -= (long) bArr;
                }
                if (this.f13690b != 0) {
                    this.f13690b.mo1472a(bArr);
                }
                return bArr;
            } else if (this.f13694f == -1) {
                return -1;
            } else {
                throw new RawResourceDataSourceException(new EOFException());
            }
        } catch (IOException e) {
            throw new RawResourceDataSourceException(e);
        }
    }

    public final Uri mo1437b() {
        return this.f13691c;
    }

    public final void mo1436a() throws RawResourceDataSourceException {
        this.f13691c = null;
        try {
            if (this.f13693e != null) {
                this.f13693e.close();
            }
            this.f13693e = null;
            try {
                if (this.f13692d != null) {
                    this.f13692d.close();
                }
                this.f13692d = null;
                if (this.f13695g) {
                    this.f13695g = false;
                    if (this.f13690b != null) {
                        this.f13690b.mo1474c();
                    }
                }
            } catch (IOException e) {
                throw new RawResourceDataSourceException(e);
            } catch (Throwable th) {
                this.f13692d = null;
                if (this.f13695g) {
                    this.f13695g = false;
                    if (this.f13690b != null) {
                        this.f13690b.mo1474c();
                    }
                }
            }
        } catch (IOException e2) {
            throw new RawResourceDataSourceException(e2);
        } catch (Throwable th2) {
            this.f13693e = null;
            try {
                if (this.f13692d != null) {
                    this.f13692d.close();
                }
                this.f13692d = null;
                if (this.f13695g) {
                    this.f13695g = false;
                    if (this.f13690b != null) {
                        this.f13690b.mo1474c();
                    }
                }
            } catch (IOException e22) {
                throw new RawResourceDataSourceException(e22);
            } catch (Throwable th3) {
                this.f13692d = null;
                if (this.f13695g) {
                    this.f13695g = false;
                    if (this.f13690b != null) {
                        this.f13690b.mo1474c();
                    }
                }
            }
        }
    }
}
