package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class StandardGifDecoder implements GifDecoder {
    private static final String f12281a = "StandardGifDecoder";
    private int[] f12282b;
    private final int[] f12283c;
    private final BitmapProvider f12284d;
    private ByteBuffer f12285e;
    private byte[] f12286f;
    private short[] f12287g;
    private byte[] f12288h;
    private byte[] f12289i;
    private byte[] f12290j;
    private int[] f12291k;
    private int f12292l;
    private GifHeader f12293m;
    private Bitmap f12294n;
    private boolean f12295o;
    private int f12296p;
    private int f12297q;
    private int f12298r;
    private int f12299s;
    private Boolean f12300t;
    private Config f12301u;

    public StandardGifDecoder(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        m11210a(gifHeader, byteBuffer, i);
    }

    private StandardGifDecoder(BitmapProvider bitmapProvider) {
        this.f12283c = new int[256];
        this.f12301u = Config.ARGB_8888;
        this.f12284d = bitmapProvider;
        this.f12293m = new GifHeader();
    }

    public final ByteBuffer mo874a() {
        return this.f12285e;
    }

    public final void mo876b() {
        this.f12292l = (this.f12292l + 1) % this.f12293m.f3294c;
    }

    public final int mo877c() {
        if (this.f12293m.f3294c > 0) {
            if (this.f12292l >= 0) {
                int i = this.f12292l;
                int i2 = -1;
                if (i >= 0 && i < this.f12293m.f3294c) {
                    i2 = ((GifFrame) this.f12293m.f3296e.get(i)).f3289i;
                }
                return i2;
            }
        }
        return 0;
    }

    public final int mo878d() {
        return this.f12293m.f3294c;
    }

    public final int mo879e() {
        return this.f12292l;
    }

    public final void mo880f() {
        this.f12292l = -1;
    }

    public final int mo881g() {
        return (this.f12285e.limit() + this.f12290j.length) + (this.f12291k.length * 4);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Bitmap mo882h() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.f12293m;	 Catch:{ all -> 0x00e1 }
        r0 = r0.f3294c;	 Catch:{ all -> 0x00e1 }
        r1 = 3;
        r2 = 1;
        if (r0 <= 0) goto L_0x000d;
    L_0x0009:
        r0 = r7.f12292l;	 Catch:{ all -> 0x00e1 }
        if (r0 >= 0) goto L_0x0038;
    L_0x000d:
        r0 = f12281a;	 Catch:{ all -> 0x00e1 }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00e1 }
        if (r0 == 0) goto L_0x0036;
    L_0x0015:
        r0 = f12281a;	 Catch:{ all -> 0x00e1 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e1 }
        r4 = "Unable to decode frame, frameCount=";
        r3.<init>(r4);	 Catch:{ all -> 0x00e1 }
        r4 = r7.f12293m;	 Catch:{ all -> 0x00e1 }
        r4 = r4.f3294c;	 Catch:{ all -> 0x00e1 }
        r3.append(r4);	 Catch:{ all -> 0x00e1 }
        r4 = ", framePointer=";
        r3.append(r4);	 Catch:{ all -> 0x00e1 }
        r4 = r7.f12292l;	 Catch:{ all -> 0x00e1 }
        r3.append(r4);	 Catch:{ all -> 0x00e1 }
        r3 = r3.toString();	 Catch:{ all -> 0x00e1 }
        android.util.Log.d(r0, r3);	 Catch:{ all -> 0x00e1 }
    L_0x0036:
        r7.f12296p = r2;	 Catch:{ all -> 0x00e1 }
    L_0x0038:
        r0 = r7.f12296p;	 Catch:{ all -> 0x00e1 }
        r3 = 0;
        if (r0 == r2) goto L_0x00c2;
    L_0x003d:
        r0 = r7.f12296p;	 Catch:{ all -> 0x00e1 }
        r4 = 2;
        if (r0 != r4) goto L_0x0044;
    L_0x0042:
        goto L_0x00c2;
    L_0x0044:
        r0 = 0;
        r7.f12296p = r0;	 Catch:{ all -> 0x00e1 }
        r4 = r7.f12286f;	 Catch:{ all -> 0x00e1 }
        if (r4 != 0) goto L_0x0055;
    L_0x004b:
        r4 = r7.f12284d;	 Catch:{ all -> 0x00e1 }
        r5 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = r4.mo999a(r5);	 Catch:{ all -> 0x00e1 }
        r7.f12286f = r4;	 Catch:{ all -> 0x00e1 }
    L_0x0055:
        r4 = r7.f12293m;	 Catch:{ all -> 0x00e1 }
        r4 = r4.f3296e;	 Catch:{ all -> 0x00e1 }
        r5 = r7.f12292l;	 Catch:{ all -> 0x00e1 }
        r4 = r4.get(r5);	 Catch:{ all -> 0x00e1 }
        r4 = (com.bumptech.glide.gifdecoder.GifFrame) r4;	 Catch:{ all -> 0x00e1 }
        r5 = r7.f12292l;	 Catch:{ all -> 0x00e1 }
        r5 = r5 - r2;
        if (r5 < 0) goto L_0x0071;
    L_0x0066:
        r6 = r7.f12293m;	 Catch:{ all -> 0x00e1 }
        r6 = r6.f3296e;	 Catch:{ all -> 0x00e1 }
        r5 = r6.get(r5);	 Catch:{ all -> 0x00e1 }
        r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5;	 Catch:{ all -> 0x00e1 }
        goto L_0x0072;
    L_0x0071:
        r5 = r3;
    L_0x0072:
        r6 = r4.f3291k;	 Catch:{ all -> 0x00e1 }
        if (r6 == 0) goto L_0x0079;
    L_0x0076:
        r6 = r4.f3291k;	 Catch:{ all -> 0x00e1 }
        goto L_0x007d;
    L_0x0079:
        r6 = r7.f12293m;	 Catch:{ all -> 0x00e1 }
        r6 = r6.f3292a;	 Catch:{ all -> 0x00e1 }
    L_0x007d:
        r7.f12282b = r6;	 Catch:{ all -> 0x00e1 }
        r6 = r7.f12282b;	 Catch:{ all -> 0x00e1 }
        if (r6 != 0) goto L_0x00a4;
    L_0x0083:
        r0 = f12281a;	 Catch:{ all -> 0x00e1 }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00e1 }
        if (r0 == 0) goto L_0x00a0;
    L_0x008b:
        r0 = f12281a;	 Catch:{ all -> 0x00e1 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e1 }
        r4 = "No valid color table found for frame #";
        r1.<init>(r4);	 Catch:{ all -> 0x00e1 }
        r4 = r7.f12292l;	 Catch:{ all -> 0x00e1 }
        r1.append(r4);	 Catch:{ all -> 0x00e1 }
        r1 = r1.toString();	 Catch:{ all -> 0x00e1 }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x00e1 }
    L_0x00a0:
        r7.f12296p = r2;	 Catch:{ all -> 0x00e1 }
        monitor-exit(r7);
        return r3;
    L_0x00a4:
        r1 = r4.f3286f;	 Catch:{ all -> 0x00e1 }
        if (r1 == 0) goto L_0x00bc;
    L_0x00a8:
        r1 = r7.f12282b;	 Catch:{ all -> 0x00e1 }
        r2 = r7.f12283c;	 Catch:{ all -> 0x00e1 }
        r3 = r7.f12282b;	 Catch:{ all -> 0x00e1 }
        r3 = r3.length;	 Catch:{ all -> 0x00e1 }
        java.lang.System.arraycopy(r1, r0, r2, r0, r3);	 Catch:{ all -> 0x00e1 }
        r1 = r7.f12283c;	 Catch:{ all -> 0x00e1 }
        r7.f12282b = r1;	 Catch:{ all -> 0x00e1 }
        r1 = r7.f12282b;	 Catch:{ all -> 0x00e1 }
        r2 = r4.f3288h;	 Catch:{ all -> 0x00e1 }
        r1[r2] = r0;	 Catch:{ all -> 0x00e1 }
    L_0x00bc:
        r0 = r7.m11209a(r4, r5);	 Catch:{ all -> 0x00e1 }
        monitor-exit(r7);
        return r0;
    L_0x00c2:
        r0 = f12281a;	 Catch:{ all -> 0x00e1 }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00e1 }
        if (r0 == 0) goto L_0x00df;
    L_0x00ca:
        r0 = f12281a;	 Catch:{ all -> 0x00e1 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e1 }
        r2 = "Unable to decode frame, status=";
        r1.<init>(r2);	 Catch:{ all -> 0x00e1 }
        r2 = r7.f12296p;	 Catch:{ all -> 0x00e1 }
        r1.append(r2);	 Catch:{ all -> 0x00e1 }
        r1 = r1.toString();	 Catch:{ all -> 0x00e1 }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x00e1 }
    L_0x00df:
        monitor-exit(r7);
        return r3;
    L_0x00e1:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.h():android.graphics.Bitmap");
    }

    public final void mo883i() {
        this.f12293m = null;
        if (this.f12290j != null) {
            this.f12284d.mo997a(this.f12290j);
        }
        if (this.f12291k != null) {
            this.f12284d.mo998a(this.f12291k);
        }
        if (this.f12294n != null) {
            this.f12284d.mo996a(this.f12294n);
        }
        this.f12294n = null;
        this.f12285e = null;
        this.f12300t = null;
        if (this.f12286f != null) {
            this.f12284d.mo997a(this.f12286f);
        }
    }

    private synchronized void m11210a(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            byteBuffer = new StringBuilder("Sample size must be >=0, not: ");
            byteBuffer.append(i);
            throw new IllegalArgumentException(byteBuffer.toString());
        }
        i = Integer.highestOneBit(i);
        this.f12296p = 0;
        this.f12293m = gifHeader;
        this.f12292l = -1;
        this.f12285e = byteBuffer.asReadOnlyBuffer();
        this.f12285e.position(0);
        this.f12285e.order(ByteOrder.LITTLE_ENDIAN);
        this.f12295o = false;
        for (GifFrame gifFrame : gifHeader.f3296e) {
            if (gifFrame.f3287g == 3) {
                this.f12295o = true;
                break;
            }
        }
        this.f12297q = i;
        this.f12299s = gifHeader.f3297f / i;
        this.f12298r = gifHeader.f3298g / i;
        this.f12290j = this.f12284d.mo999a(gifHeader.f3297f * gifHeader.f3298g);
        this.f12291k = this.f12284d.mo1000b(this.f12299s * this.f12298r);
    }

    public final void mo875a(Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.f12301u = config;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported format: ");
        stringBuilder.append(config);
        stringBuilder.append(", must be one of ");
        stringBuilder.append(Config.ARGB_8888);
        stringBuilder.append(" or ");
        stringBuilder.append(Config.RGB_565);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private Bitmap m11209a(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int j;
        int i7;
        byte b;
        int[] iArr;
        int[] iArr2;
        Bitmap k;
        Boolean bool;
        GifFrame gifFrame3 = gifFrame;
        GifFrame gifFrame4 = gifFrame2;
        int[] iArr3 = this.f12291k;
        byte b2 = (byte) 0;
        if (gifFrame4 == null) {
            if (r0.f12294n != null) {
                r0.f12284d.mo996a(r0.f12294n);
            }
            r0.f12294n = null;
            Arrays.fill(iArr3, 0);
        }
        Object obj = 3;
        if (gifFrame4 != null && gifFrame4.f3287g == 3 && r0.f12294n == null) {
            Arrays.fill(iArr3, 0);
        }
        if (gifFrame4 != null && gifFrame4.f3287g > 0) {
            if (gifFrame4.f3287g == 2) {
                int i8;
                if (!gifFrame3.f3286f) {
                    i = r0.f12293m.f3303l;
                    if (gifFrame3.f3291k != null && r0.f12293m.f3301j == gifFrame3.f3288h) {
                    }
                    i2 = gifFrame4.f3283c / r0.f12297q;
                    i3 = ((gifFrame4.f3282b / r0.f12297q) * r0.f12299s) + (gifFrame4.f3281a / r0.f12297q);
                    i4 = ((gifFrame4.f3284d / r0.f12297q) * r0.f12299s) + i3;
                    while (i3 < i4) {
                        i5 = i3 + i2;
                        for (i8 = i3; i8 < i5; i8++) {
                            iArr3[i8] = i;
                        }
                        i3 += r0.f12299s;
                    }
                } else if (r0.f12292l == 0) {
                    r0.f12300t = Boolean.valueOf(true);
                }
                i = 0;
                i2 = gifFrame4.f3283c / r0.f12297q;
                i3 = ((gifFrame4.f3282b / r0.f12297q) * r0.f12299s) + (gifFrame4.f3281a / r0.f12297q);
                i4 = ((gifFrame4.f3284d / r0.f12297q) * r0.f12299s) + i3;
                while (i3 < i4) {
                    i5 = i3 + i2;
                    for (i8 = i3; i8 < i5; i8++) {
                        iArr3[i8] = i;
                    }
                    i3 += r0.f12299s;
                }
            } else if (gifFrame4.f3287g == 3 && r0.f12294n != null) {
                r0.f12294n.getPixels(iArr3, 0, r0.f12299s, 0, 0, r0.f12299s, r0.f12298r);
            }
        }
        if (gifFrame3 != null) {
            r0.f12285e.position(gifFrame3.f3290j);
        }
        if (gifFrame3 == null) {
            i5 = r0.f12293m.f3297f;
            i = r0.f12293m.f3298g;
        } else {
            i5 = gifFrame3.f3283c;
            i = gifFrame3.f3284d;
        }
        short s = i5 * i;
        if (r0.f12290j == null || r0.f12290j.length < s) {
            r0.f12290j = r0.f12284d.mo999a((int) s);
        }
        byte[] bArr = r0.f12290j;
        if (r0.f12287g == null) {
            r0.f12287g = new short[4096];
        }
        short[] sArr = r0.f12287g;
        if (r0.f12288h == null) {
            r0.f12288h = new byte[4096];
        }
        byte[] bArr2 = r0.f12288h;
        if (r0.f12289i == null) {
            r0.f12289i = new byte[4097];
        }
        byte[] bArr3 = r0.f12289i;
        int j2 = m11211j();
        int i9 = 1 << j2;
        int i10 = i9 + 1;
        int i11 = i9 + 2;
        j2++;
        int i12 = (1 << j2) - 1;
        for (i6 = 0; i6 < i9; i6++) {
            sArr[i6] = (short) 0;
            bArr2[i6] = (byte) i6;
        }
        byte[] bArr4 = r0.f12286f;
        int i13 = j2;
        short s2 = (short) 0;
        int i14 = s2;
        int i15 = i14;
        int i16 = i15;
        int i17 = i16;
        int i18 = i17;
        short s3 = i18;
        int i19 = s3;
        int i20 = i11;
        int i21 = i12;
        int i22 = -1;
        while (s2 < s) {
            int i23;
            int i24;
            if (i14 == 0) {
                j = m11211j();
                if (j <= 0) {
                    i23 = j2;
                    i24 = s2;
                } else {
                    i23 = j2;
                    i24 = s2;
                    r0.f12285e.get(r0.f12286f, 0, Math.min(j, r0.f12285e.remaining()));
                }
                if (j <= 0) {
                    r0.f12296p = 3;
                    i7 = i15;
                    b = (byte) 0;
                    break;
                }
                i18 = 0;
            } else {
                i23 = j2;
                Object obj2 = obj;
                i24 = s2;
                j = i14;
            }
            i17 += (bArr4[i18] & 255) << i16;
            i18++;
            i14 = j - 1;
            int i25 = i16 + 8;
            j2 = i20;
            i6 = i13;
            j = i22;
            short s4 = s3;
            while (i25 >= i6) {
                i7 = i17 & i21;
                i17 >>= i6;
                i25 -= i6;
                if (i7 != i9) {
                    if (i7 == i10) {
                        break;
                    }
                    byte[] bArr5 = bArr4;
                    if (j == -1) {
                        bArr3[i19] = bArr2[i7];
                        i19++;
                        j = i7;
                        s4 = j;
                        bArr4 = bArr5;
                    } else {
                        if (i7 >= j2) {
                            bArr3[i19] = (byte) s4;
                            i19++;
                            i3 = j;
                        } else {
                            i3 = i7;
                        }
                        while (i3 >= i9) {
                            bArr3[i19] = bArr2[i3];
                            i19++;
                            i3 = sArr[i3];
                        }
                        short s5 = bArr2[i3] & 255;
                        int i26 = i9;
                        byte b3 = (byte) s5;
                        bArr[i15] = b3;
                        i15++;
                        i24++;
                        while (i19 > 0) {
                            i19--;
                            bArr[i15] = bArr3[i19];
                            i15++;
                            i24++;
                        }
                        short s6 = s5;
                        if (j2 < 4096) {
                            sArr[j2] = (short) j;
                            bArr2[j2] = b3;
                            j2++;
                            if ((j2 & i21) == 0 && j2 < 4096) {
                                i6++;
                                i21 += j2;
                            }
                        }
                        j = i7;
                        bArr4 = bArr5;
                        i9 = i26;
                        s4 = s6;
                    }
                } else {
                    j2 = i11;
                    i21 = i12;
                    i6 = i23;
                    j = -1;
                }
            }
            i20 = j2;
            s3 = s4;
            i16 = i25;
            i13 = i6;
            i22 = j;
            j2 = i23;
            s2 = i24;
            b2 = (byte) 0;
            obj = 3;
        }
        b = b2;
        i7 = i15;
        Arrays.fill(bArr, i7, s, b);
        if (!gifFrame3.f3285e) {
            if (r0.f12297q == 1) {
                iArr = r0.f12291k;
                i = gifFrame3.f3284d;
                i4 = gifFrame3.f3282b;
                i3 = gifFrame3.f3283c;
                i2 = gifFrame3.f3281a;
                byte b4 = r0.f12292l == 0 ? (byte) 1 : b;
                j2 = r0.f12299s;
                byte[] bArr6 = r0.f12290j;
                int[] iArr4 = r0.f12282b;
                i25 = b;
                j = -1;
                while (i25 < i) {
                    int i27;
                    int i28;
                    i10 = (i25 + i4) * j2;
                    i11 = i10 + i2;
                    i6 = i11 + i3;
                    i10 += j2;
                    if (i10 < i6) {
                        i6 = i10;
                    }
                    i10 = gifFrame3.f3283c * i25;
                    int i29 = i;
                    i = j;
                    j = i11;
                    while (j < i6) {
                        i27 = i4;
                        byte b5 = bArr6[i10];
                        i28 = i3;
                        i3 = b5 & 255;
                        if (i3 != i) {
                            i3 = iArr4[i3];
                            if (i3 != 0) {
                                iArr[j] = i3;
                            } else {
                                i = b5;
                            }
                        }
                        i10++;
                        j++;
                        i4 = i27;
                        i3 = i28;
                    }
                    i27 = i4;
                    i28 = i3;
                    i25++;
                    j = i;
                    i = i29;
                }
                boolean z = (r0.f12300t != null || b4 == (byte) 0 || j == -1) ? false : true;
                r0.f12300t = Boolean.valueOf(z);
                iArr2 = iArr3;
                if (r0.f12295o && (gifFrame3.f3287g == 0 || gifFrame3.f3287g == 1)) {
                    if (r0.f12294n == null) {
                        r0.f12294n = m11212k();
                    }
                    r0.f12294n.setPixels(iArr2, 0, r0.f12299s, 0, 0, r0.f12299s, r0.f12298r);
                }
                k = m11212k();
                k.setPixels(iArr2, 0, r0.f12299s, 0, 0, r0.f12299s, r0.f12298r);
                return k;
            }
        }
        iArr = r0.f12291k;
        i = gifFrame3.f3284d / r0.f12297q;
        i4 = gifFrame3.f3282b / r0.f12297q;
        i3 = gifFrame3.f3283c / r0.f12297q;
        i2 = gifFrame3.f3281a / r0.f12297q;
        Object obj3 = r0.f12292l == 0 ? 1 : null;
        j2 = r0.f12297q;
        i9 = r0.f12299s;
        i7 = r0.f12298r;
        byte[] bArr7 = r0.f12290j;
        int[] iArr5 = r0.f12282b;
        iArr2 = iArr3;
        Boolean bool2 = r0.f12300t;
        i12 = 8;
        j = 0;
        i10 = 0;
        i11 = 1;
        while (j < i) {
            int i30;
            int i31;
            int i32;
            int i33;
            bool = bool2;
            if (gifFrame3.f3285e) {
                if (i10 >= i) {
                    i11++;
                    switch (i11) {
                        case 2:
                            i10 = 4;
                            break;
                        case 3:
                            i12 = 4;
                            i10 = 2;
                            break;
                        case 4:
                            i10 = 1;
                            i12 = 2;
                            break;
                        default:
                            break;
                    }
                }
                i30 = i10 + i12;
            } else {
                i30 = i10;
                i10 = j;
            }
            i10 += i4;
            int i34 = i;
            Object obj4 = j2 == 1 ? 1 : null;
            if (i10 < i7) {
                i10 *= i9;
                int i35 = i10 + i2;
                i31 = i4;
                i4 = i35 + i3;
                i10 += i9;
                if (i10 >= i4) {
                    i10 = i4;
                }
                i32 = i3;
                i4 = (j * j2) * gifFrame3.f3283c;
                if (obj4 != null) {
                    for (i = i35; i < i10; i++) {
                        i3 = iArr5[bArr7[i4] & 255];
                        if (i3 != 0) {
                            iArr[i] = i3;
                        } else if (obj3 != null && r42 == null) {
                            bool = Boolean.valueOf(true);
                        }
                        i4 += j2;
                    }
                } else {
                    i = ((i10 - i35) * j2) + i4;
                    i3 = i4;
                    i4 = i35;
                    while (i4 < i10) {
                        int i36;
                        int i37 = i2;
                        i2 = gifFrame3.f3283c;
                        int i38 = i9;
                        i33 = i30;
                        i35 = 0;
                        int i39 = 0;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i9 = i3;
                        while (i9 < r0.f12297q + i3 && i9 < r0.f12290j.length && i9 < i) {
                            i36 = i7;
                            i30 = r0.f12282b[r0.f12290j[i9] & 255];
                            if (i30 != 0) {
                                i35 += (i30 >> 24) & 255;
                                i39 += (i30 >> 16) & 255;
                                i14 += (i30 >> 8) & 255;
                                i15 += i30 & 255;
                                i16++;
                            }
                            i9++;
                            i7 = i36;
                        }
                        i36 = i7;
                        i2 += i3;
                        i9 = i2;
                        while (i9 < r0.f12297q + i2 && i9 < r0.f12290j.length && i9 < i) {
                            i30 = r0.f12282b[r0.f12290j[i9] & 255];
                            if (i30 != 0) {
                                i35 += (i30 >> 24) & 255;
                                i39 += (i30 >> 16) & 255;
                                i14 += (i30 >> 8) & 255;
                                i15 += i30 & 255;
                                i16++;
                            }
                            i9++;
                        }
                        if (i16 == 0) {
                            i7 = 0;
                        } else {
                            i7 = ((((i35 / i16) << 24) | ((i39 / i16) << 16)) | ((i14 / i16) << 8)) | (i15 / i16);
                        }
                        if (i7 != 0) {
                            iArr[i4] = i7;
                        } else if (obj3 != null && r42 == null) {
                            bool = Boolean.valueOf(true);
                        }
                        i3 += j2;
                        i4++;
                        i2 = i37;
                        i9 = i38;
                        i30 = i33;
                        i7 = i36;
                    }
                }
            } else {
                i31 = i4;
                i32 = i3;
            }
            i33 = i30;
            bool2 = bool;
            j++;
            i = i34;
            i4 = i31;
            i3 = i32;
            i2 = i2;
            i9 = i9;
            i10 = i33;
            i7 = i7;
        }
        bool = bool2;
        if (r0.f12300t == null) {
            boolean z2;
            if (bool == null) {
                z2 = false;
            } else {
                z2 = bool.booleanValue();
            }
            r0.f12300t = Boolean.valueOf(z2);
        }
        if (r0.f12294n == null) {
            r0.f12294n = m11212k();
        }
        r0.f12294n.setPixels(iArr2, 0, r0.f12299s, 0, 0, r0.f12299s, r0.f12298r);
        k = m11212k();
        k.setPixels(iArr2, 0, r0.f12299s, 0, 0, r0.f12299s, r0.f12298r);
        return k;
    }

    private int m11211j() {
        return this.f12285e.get() & 255;
    }

    private Bitmap m11212k() {
        Config config;
        Bitmap a;
        if (this.f12300t != null) {
            if (!this.f12300t.booleanValue()) {
                config = this.f12301u;
                a = this.f12284d.mo995a(this.f12299s, this.f12298r, config);
                a.setHasAlpha(true);
                return a;
            }
        }
        config = Config.ARGB_8888;
        a = this.f12284d.mo995a(this.f12299s, this.f12298r, config);
        a.setHasAlpha(true);
        return a;
    }
}
