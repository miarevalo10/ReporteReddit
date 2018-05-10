package com.bumptech.glide.gifdecoder;

import android.util.Log;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;

public class GifHeaderParser {
    public final byte[] f3305a = new byte[256];
    public ByteBuffer f3306b;
    public GifHeader f3307c;
    public int f3308d = 0;

    public final void m2838a() {
        int i = 0;
        while (i == 0 && !m2840c() && this.f3307c.f3294c <= RedditJobManager.f10810d) {
            int g = m2837g();
            int i2;
            if (g == 33) {
                g = m2837g();
                if (g == 1) {
                    m2835e();
                } else if (g != 249) {
                    switch (g) {
                        case JpegConst.COM /*254*/:
                            m2835e();
                            break;
                        case 255:
                            m2836f();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (i2 = 0; i2 < 11; i2++) {
                                stringBuilder.append((char) this.f3305a[i2]);
                            }
                            if (!stringBuilder.toString().equals("NETSCAPE2.0")) {
                                m2835e();
                                break;
                            } else {
                                m2834d();
                                break;
                            }
                        default:
                            m2835e();
                            break;
                    }
                } else {
                    this.f3307c.f3295d = new GifFrame();
                    m2837g();
                    g = m2837g();
                    this.f3307c.f3295d.f3287g = (g & 28) >> 2;
                    if (this.f3307c.f3295d.f3287g == 0) {
                        this.f3307c.f3295d.f3287g = 1;
                    }
                    this.f3307c.f3295d.f3286f = (g & 1) != 0;
                    g = this.f3306b.getShort();
                    if (g < 2) {
                        g = 10;
                    }
                    this.f3307c.f3295d.f3289i = g * 10;
                    this.f3307c.f3295d.f3288h = m2837g();
                    m2837g();
                }
            } else if (g == 44) {
                if (this.f3307c.f3295d == null) {
                    this.f3307c.f3295d = new GifFrame();
                }
                this.f3307c.f3295d.f3281a = this.f3306b.getShort();
                this.f3307c.f3295d.f3282b = this.f3306b.getShort();
                this.f3307c.f3295d.f3283c = this.f3306b.getShort();
                this.f3307c.f3295d.f3284d = this.f3306b.getShort();
                g = m2837g();
                i2 = (g & 128) != 0 ? 1 : 0;
                int pow = (int) Math.pow(2.0d, (double) ((g & 7) + 1));
                this.f3307c.f3295d.f3285e = (g & 64) != 0;
                if (i2 != 0) {
                    this.f3307c.f3295d.f3291k = m2833a(pow);
                } else {
                    this.f3307c.f3295d.f3291k = null;
                }
                this.f3307c.f3295d.f3290j = this.f3306b.position();
                m2837g();
                m2835e();
                if (!m2840c()) {
                    GifHeader gifHeader = this.f3307c;
                    gifHeader.f3294c++;
                    this.f3307c.f3296e.add(this.f3307c.f3295d);
                }
            } else if (g != 59) {
                this.f3307c.f3293b = 1;
            } else {
                i = 1;
            }
        }
    }

    private void m2834d() {
        do {
            m2836f();
            if (this.f3305a[0] == (byte) 1) {
                this.f3307c.f3304m = (this.f3305a[1] & 255) | ((this.f3305a[2] & 255) << 8);
            }
            if (this.f3308d <= 0) {
                return;
            }
        } while (!m2840c());
    }

    public final void m2839b() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < 6; i++) {
            stringBuilder.append((char) m2837g());
        }
        if (stringBuilder.toString().startsWith("GIF")) {
            this.f3307c.f3297f = this.f3306b.getShort();
            this.f3307c.f3298g = this.f3306b.getShort();
            int g = m2837g();
            GifHeader gifHeader = this.f3307c;
            if ((g & 128) != 0) {
                z = true;
            }
            gifHeader.f3299h = z;
            this.f3307c.f3300i = (int) Math.pow(2.0d, (double) ((g & 7) + 1));
            this.f3307c.f3301j = m2837g();
            this.f3307c.f3302k = m2837g();
            if (this.f3307c.f3299h && !m2840c()) {
                this.f3307c.f3292a = m2833a(this.f3307c.f3300i);
                this.f3307c.f3303l = this.f3307c.f3292a[this.f3307c.f3301j];
            }
            return;
        }
        this.f3307c.f3293b = 1;
    }

    private int[] m2833a(int i) {
        int[] iArr;
        byte[] bArr = new byte[(3 * i)];
        try {
            this.f3306b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i2 + 1;
                    iArr[i2] = ((((bArr[i3] & 255) << 16) | -16777216) | ((bArr[i4] & 255) << 8)) | (bArr[i5] & 255);
                    i3 = i6;
                    i2 = i7;
                } catch (BufferUnderflowException e) {
                    i = e;
                }
            }
        } catch (BufferUnderflowException e2) {
            i = e2;
            iArr = null;
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", i);
            }
            this.f3307c.f3293b = 1;
            return iArr;
        }
        return iArr;
    }

    private void m2835e() {
        int g;
        do {
            g = m2837g();
            this.f3306b.position(Math.min(this.f3306b.position() + g, this.f3306b.limit()));
        } while (g > 0);
    }

    private void m2836f() {
        this.f3308d = m2837g();
        if (this.f3308d > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f3308d) {
                try {
                    i2 = this.f3308d - i;
                    this.f3306b.get(this.f3305a, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder stringBuilder = new StringBuilder("Error Reading Block n: ");
                        stringBuilder.append(i);
                        stringBuilder.append(" count: ");
                        stringBuilder.append(i2);
                        stringBuilder.append(" blockSize: ");
                        stringBuilder.append(this.f3308d);
                        Log.d("GifHeaderParser", stringBuilder.toString(), e);
                    }
                    this.f3307c.f3293b = 1;
                }
            }
        }
    }

    private int m2837g() {
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
        r0 = r2.f3306b;	 Catch:{ Exception -> 0x0009 }
        r0 = r0.get();	 Catch:{ Exception -> 0x0009 }
        r0 = r0 & 255;
        goto L_0x000f;
    L_0x0009:
        r0 = r2.f3307c;
        r1 = 1;
        r0.f3293b = r1;
        r0 = 0;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.g():int");
    }

    public final boolean m2840c() {
        return this.f3307c.f3293b != 0;
    }
}
