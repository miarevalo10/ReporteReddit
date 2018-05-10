package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<DecodeFormat> f3525a = Option.m2851a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f3318d);
    public static final Option<DownsampleStrategy> f3526b = Option.m2851a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", DownsampleStrategy.f3524g);
    public static final Option<Boolean> f3527c = Option.m2851a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.valueOf(false));
    public static final Option<Boolean> f3528d = Option.m2851a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", null);
    static final DecodeCallbacks f3529e = new C10781();
    private static final Set<String> f3530f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    private static final Set<ImageType> f3531g = Collections.unmodifiableSet(EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG));
    private static final Queue<Options> f3532h = Util.m3229a(0);
    private final BitmapPool f3533i;
    private final DisplayMetrics f3534j;
    private final ArrayPool f3535k;
    private final List<ImageHeaderParser> f3536l;
    private final HardwareConfigState f3537m = HardwareConfigState.m3044a();

    public interface DecodeCallbacks {
        void mo992a();

        void mo993a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;
    }

    class C10781 implements DecodeCallbacks {
        public final void mo992a() {
        }

        public final void mo993a(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        C10781() {
        }
    }

    public static boolean m3033a() {
        return true;
    }

    public static boolean m3038b() {
        return true;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f3536l = list;
        this.f3534j = (DisplayMetrics) Preconditions.m3217a((Object) displayMetrics);
        this.f3533i = (BitmapPool) Preconditions.m3217a((Object) bitmapPool);
        this.f3535k = (ArrayPool) Preconditions.m3217a((Object) arrayPool);
    }

    public final Resource<Bitmap> m3041a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Throwable e;
        Throwable th;
        StringBuilder stringBuilder;
        Throwable th2;
        InputStream inputStream2 = inputStream;
        int i3 = i;
        int i4 = i2;
        com.bumptech.glide.load.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        Preconditions.m3221a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        Object obj = (byte[]) this.f3535k.mo946a(65536, byte[].class);
        Options c = m3039c();
        c.inTempStorage = obj;
        DecodeFormat decodeFormat = (DecodeFormat) options2.m11235a(f3525a);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.m11235a(f3526b);
        boolean booleanValue = ((Boolean) options2.m11235a(f3527c)).booleanValue();
        int i5 = (options2.m11235a(f3528d) == null || !((Boolean) options2.m11235a(f3528d)).booleanValue()) ? 0 : 1;
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
            i5 = 0;
        }
        Downsampler downsampler;
        try {
            long j;
            int b;
            int i6;
            String str;
            float f;
            StringBuilder stringBuilder2;
            boolean z;
            DecodeFormat decodeFormat2;
            ImageType imageType;
            StringBuilder stringBuilder3;
            Object obj2;
            HardwareConfigState hardwareConfigState;
            DecodeFormat decodeFormat3;
            Object obj3;
            InputStream inputStream3;
            boolean z2;
            Object obj4;
            float f2;
            float f3;
            StringBuilder stringBuilder4;
            BitmapPool bitmapPool;
            Config config;
            Bitmap b2;
            Bitmap bitmap;
            Resource a;
            long a2 = LogTime.m3213a();
            int[] a3 = m3035a(inputStream2, c, decodeCallbacks2, downsampler.f3533i);
            int i7 = i5;
            i5 = a3[0];
            int i8 = a3[1];
            String str2 = c.outMimeType;
            Object obj5 = obj;
            if (i5 == -1 || i8 == -1) {
                i7 = 0;
            }
            try {
                j = a2;
                b = ImageHeaderParserUtils.m2847b(downsampler.f3536l, inputStream2, downsampler.f3535k);
                int a4 = TransformationUtils.m3050a(b);
                boolean b3 = TransformationUtils.m3060b(b);
                i6 = b;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = i5;
                }
                b = i4 == Integer.MIN_VALUE ? i8 : i4;
                str = str2;
                ImageType a5 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream2, downsampler.f3535k);
                BitmapPool bitmapPool2 = downsampler.f3533i;
                boolean z3 = booleanValue;
                f = 1.0f;
                if (i5 > 0) {
                    if (i8 > 0) {
                        float a6;
                        SampleSizeRounding a7;
                        float f4;
                        DownsampleStrategy downsampleStrategy2;
                        float f5;
                        int i9;
                        int i10;
                        float min;
                        int i11;
                        int[] a8;
                        int i12;
                        double a9;
                        int a10;
                        int i13;
                        int i14;
                        InputStream inputStream4;
                        if (a4 != 90) {
                            if (a4 != SubsamplingScaleImageView.ORIENTATION_270) {
                                try {
                                    a6 = downsampleStrategy.mo990a(i5, i8, i3, b);
                                    if (a6 > 0.0f) {
                                        stringBuilder2 = new StringBuilder("Cannot scale with factor: ");
                                        stringBuilder2.append(a6);
                                        stringBuilder2.append(" from: ");
                                        stringBuilder2.append(downsampleStrategy);
                                        stringBuilder2.append(", source: [");
                                        stringBuilder2.append(i5);
                                        stringBuilder2.append("x");
                                        stringBuilder2.append(i8);
                                        stringBuilder2.append("], target: [");
                                        stringBuilder2.append(i3);
                                        stringBuilder2.append("x");
                                        stringBuilder2.append(b);
                                        stringBuilder2.append("]");
                                        throw new IllegalArgumentException(stringBuilder2.toString());
                                    }
                                    a7 = downsampleStrategy.mo991a();
                                    if (a7 != null) {
                                        throw new IllegalArgumentException("Cannot round with null rounding");
                                    }
                                    z = b3;
                                    f4 = (float) i5;
                                    decodeFormat2 = decodeFormat;
                                    downsampleStrategy2 = downsampleStrategy;
                                    f5 = (float) i8;
                                    try {
                                        i9 = i5 / ((int) (((double) (a6 * f4)) + 0.5d));
                                        i10 = i8 / ((int) (((double) (a6 * f5)) + 0.5d));
                                        if (a7 != SampleSizeRounding.MEMORY) {
                                            i10 = Math.max(i9, i10);
                                        } else {
                                            i10 = Math.min(i9, i10);
                                        }
                                        if (VERSION.SDK_INT <= 23 || !f3530f.contains(c.outMimeType)) {
                                            i10 = Math.max(1, Integer.highestOneBit(i10));
                                            a4 = (a7 == SampleSizeRounding.MEMORY || ((float) i10) >= 1.0f / a6) ? i10 : i10 << 1;
                                        } else {
                                            a4 = 1;
                                        }
                                        c.inSampleSize = a4;
                                        if (a5 != ImageType.JPEG) {
                                            min = (float) Math.min(a4, 8);
                                            i11 = i3;
                                            i9 = (int) Math.ceil((double) (f4 / min));
                                            i10 = (int) Math.ceil((double) (f5 / min));
                                            i3 = a4 / 8;
                                            if (i3 > 0) {
                                                i9 /= i3;
                                                i10 /= i3;
                                            }
                                        } else {
                                            i11 = i3;
                                            if (a5 != ImageType.PNG) {
                                                if (a5 == ImageType.PNG_A) {
                                                    if (a5 != ImageType.WEBP) {
                                                        if (a5 == ImageType.WEBP_A) {
                                                            if (i5 % a4 == 0) {
                                                                if (i8 % a4 != 0) {
                                                                    i9 = i5 / a4;
                                                                    i10 = i8 / a4;
                                                                }
                                                            }
                                                            a8 = m3035a(inputStream, c, decodeCallbacks2, bitmapPool2);
                                                            i12 = a8[0];
                                                            imageType = a5;
                                                            downsampleStrategy = downsampleStrategy2;
                                                            i3 = i11;
                                                            i4 = a8[1];
                                                            i9 = i12;
                                                            a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                                            if (VERSION.SDK_INT < 19) {
                                                                a10 = m3031a(a9);
                                                                i13 = a4;
                                                                a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                                i14 = i9;
                                                                c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                                c.inDensity = m3031a(a9);
                                                            } else {
                                                                i14 = i9;
                                                                i13 = a4;
                                                            }
                                                            if (m3034a(c)) {
                                                                c.inTargetDensity = 0;
                                                                c.inDensity = 0;
                                                            } else {
                                                                c.inScaled = true;
                                                            }
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                                stringBuilder3.append(i5);
                                                                stringBuilder3.append("x");
                                                                stringBuilder3.append(i8);
                                                                stringBuilder3.append("], target: [");
                                                                stringBuilder3.append(i3);
                                                                stringBuilder3.append("x");
                                                                stringBuilder3.append(b);
                                                                stringBuilder3.append("], power of two scaled: [");
                                                                stringBuilder3.append(i14);
                                                                stringBuilder3.append("x");
                                                                stringBuilder3.append(i4);
                                                                stringBuilder3.append("], exact scale factor: ");
                                                                stringBuilder3.append(a6);
                                                                stringBuilder3.append(", power of 2 sample size: ");
                                                                stringBuilder3.append(i13);
                                                                stringBuilder3.append(", adjusted scale factor: ");
                                                                stringBuilder3.append(a9);
                                                                stringBuilder3.append(", target density: ");
                                                                stringBuilder3.append(c.inTargetDensity);
                                                                stringBuilder3.append(", density: ");
                                                                stringBuilder3.append(c.inDensity);
                                                                Log.v("Downsampler", stringBuilder3.toString());
                                                            }
                                                            obj2 = imageType;
                                                            hardwareConfigState = this.f3537m;
                                                            if (i7 != 0) {
                                                                if (VERSION.SDK_INT >= 26) {
                                                                    decodeFormat3 = decodeFormat2;
                                                                    if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                                        if (!z) {
                                                                            obj3 = (i3 >= 128 || b < 128 || !hardwareConfigState.m3045b()) ? null : 1;
                                                                            if (obj3 == null) {
                                                                                c.inPreferredConfig = Config.HARDWARE;
                                                                                c.inMutable = false;
                                                                            }
                                                                            if (obj3 == null) {
                                                                                if (!(decodeFormat3 == DecodeFormat.PREFER_ARGB_8888 || decodeFormat3 == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE)) {
                                                                                    if (VERSION.SDK_INT == 16) {
                                                                                        try {
                                                                                            inputStream3 = inputStream;
                                                                                            try {
                                                                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                                            } catch (IOException e2) {
                                                                                                e = e2;
                                                                                                th = e;
                                                                                                if (Log.isLoggable("Downsampler", 3)) {
                                                                                                    stringBuilder = new StringBuilder("Cannot determine whether the image has alpha or not from header, format ");
                                                                                                    stringBuilder.append(decodeFormat3);
                                                                                                    Log.d("Downsampler", stringBuilder.toString(), th);
                                                                                                }
                                                                                                z2 = false;
                                                                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                                                                    c.inDither = true;
                                                                                                }
                                                                                                obj4 = VERSION.SDK_INT < 19 ? null : 1;
                                                                                                booleanValue = true;
                                                                                                if (VERSION.SDK_INT >= 19) {
                                                                                                    booleanValue = f3531g.contains(obj2);
                                                                                                }
                                                                                                if (booleanValue) {
                                                                                                    if (i5 >= 0) {
                                                                                                    }
                                                                                                    if (m3034a(c)) {
                                                                                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                                                    }
                                                                                                    f2 = f;
                                                                                                    i3 = c.inSampleSize;
                                                                                                    f3 = (float) i3;
                                                                                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                                                    i4 = Math.round(((float) i4) * f2);
                                                                                                    b = Math.round(((float) b) * f2);
                                                                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                                                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                                                                                        stringBuilder4.append(i4);
                                                                                                        stringBuilder4.append("x");
                                                                                                        stringBuilder4.append(b);
                                                                                                        stringBuilder4.append("] for source [");
                                                                                                        stringBuilder4.append(i5);
                                                                                                        stringBuilder4.append("x");
                                                                                                        stringBuilder4.append(i8);
                                                                                                        stringBuilder4.append("], sampleSize: ");
                                                                                                        stringBuilder4.append(i3);
                                                                                                        stringBuilder4.append(", targetDensity: ");
                                                                                                        stringBuilder4.append(c.inTargetDensity);
                                                                                                        stringBuilder4.append(", density: ");
                                                                                                        stringBuilder4.append(c.inDensity);
                                                                                                        stringBuilder4.append(", density multiplier: ");
                                                                                                        stringBuilder4.append(f2);
                                                                                                        Log.v("Downsampler", stringBuilder4.toString());
                                                                                                    }
                                                                                                    i3 = i4;
                                                                                                    bitmapPool = downsampler.f3533i;
                                                                                                    if (VERSION.SDK_INT >= 26) {
                                                                                                        config = null;
                                                                                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                                                        config = c.outConfig;
                                                                                                    }
                                                                                                    if (config == null) {
                                                                                                        config = c.inPreferredConfig;
                                                                                                    }
                                                                                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                                                }
                                                                                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                                                    stringBuilder2 = new StringBuilder("Decoded ");
                                                                                                    stringBuilder2.append(m3032a(b2));
                                                                                                    stringBuilder2.append(" from [");
                                                                                                    stringBuilder2.append(i5);
                                                                                                    stringBuilder2.append("x");
                                                                                                    stringBuilder2.append(i8);
                                                                                                    stringBuilder2.append("] ");
                                                                                                    stringBuilder2.append(str);
                                                                                                    stringBuilder2.append(" with inBitmap ");
                                                                                                    stringBuilder2.append(m3032a(c.inBitmap));
                                                                                                    stringBuilder2.append(" for [");
                                                                                                    stringBuilder2.append(i);
                                                                                                    stringBuilder2.append("x");
                                                                                                    stringBuilder2.append(i2);
                                                                                                    stringBuilder2.append("], sample size: ");
                                                                                                    stringBuilder2.append(c.inSampleSize);
                                                                                                    stringBuilder2.append(", density: ");
                                                                                                    stringBuilder2.append(c.inDensity);
                                                                                                    stringBuilder2.append(", target density: ");
                                                                                                    stringBuilder2.append(c.inTargetDensity);
                                                                                                    stringBuilder2.append(", thread: ");
                                                                                                    stringBuilder2.append(Thread.currentThread().getName());
                                                                                                    stringBuilder2.append(", duration: ");
                                                                                                    stringBuilder2.append(LogTime.m3212a(j));
                                                                                                    Log.v("Downsampler", stringBuilder2.toString());
                                                                                                }
                                                                                                if (b2 == null) {
                                                                                                    bitmap = null;
                                                                                                } else {
                                                                                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                                                                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                                                    if (!b2.equals(bitmap)) {
                                                                                                        downsampler.f3533i.mo940a(b2);
                                                                                                    }
                                                                                                }
                                                                                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                                                m3037b(c);
                                                                                                downsampler.f3535k.mo950a(obj5);
                                                                                                return a;
                                                                                            }
                                                                                        } catch (IOException e3) {
                                                                                            e = e3;
                                                                                            inputStream3 = inputStream;
                                                                                            th = e;
                                                                                            if (Log.isLoggable("Downsampler", 3)) {
                                                                                                stringBuilder = new StringBuilder("Cannot determine whether the image has alpha or not from header, format ");
                                                                                                stringBuilder.append(decodeFormat3);
                                                                                                Log.d("Downsampler", stringBuilder.toString(), th);
                                                                                            }
                                                                                            z2 = false;
                                                                                            if (z2) {
                                                                                            }
                                                                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                                                                c.inDither = true;
                                                                                            }
                                                                                            if (VERSION.SDK_INT < 19) {
                                                                                            }
                                                                                            booleanValue = true;
                                                                                            if (VERSION.SDK_INT >= 19) {
                                                                                                booleanValue = f3531g.contains(obj2);
                                                                                            }
                                                                                            if (booleanValue) {
                                                                                                if (i5 >= 0) {
                                                                                                }
                                                                                                if (m3034a(c)) {
                                                                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                                                }
                                                                                                f2 = f;
                                                                                                i3 = c.inSampleSize;
                                                                                                f3 = (float) i3;
                                                                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                                                i4 = Math.round(((float) i4) * f2);
                                                                                                b = Math.round(((float) b) * f2);
                                                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                                                                    stringBuilder4.append(i4);
                                                                                                    stringBuilder4.append("x");
                                                                                                    stringBuilder4.append(b);
                                                                                                    stringBuilder4.append("] for source [");
                                                                                                    stringBuilder4.append(i5);
                                                                                                    stringBuilder4.append("x");
                                                                                                    stringBuilder4.append(i8);
                                                                                                    stringBuilder4.append("], sampleSize: ");
                                                                                                    stringBuilder4.append(i3);
                                                                                                    stringBuilder4.append(", targetDensity: ");
                                                                                                    stringBuilder4.append(c.inTargetDensity);
                                                                                                    stringBuilder4.append(", density: ");
                                                                                                    stringBuilder4.append(c.inDensity);
                                                                                                    stringBuilder4.append(", density multiplier: ");
                                                                                                    stringBuilder4.append(f2);
                                                                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                                                                }
                                                                                                i3 = i4;
                                                                                                bitmapPool = downsampler.f3533i;
                                                                                                if (VERSION.SDK_INT >= 26) {
                                                                                                    config = null;
                                                                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                                                    config = c.outConfig;
                                                                                                }
                                                                                                if (config == null) {
                                                                                                    config = c.inPreferredConfig;
                                                                                                }
                                                                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                                            }
                                                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                                                stringBuilder2.append(m3032a(b2));
                                                                                                stringBuilder2.append(" from [");
                                                                                                stringBuilder2.append(i5);
                                                                                                stringBuilder2.append("x");
                                                                                                stringBuilder2.append(i8);
                                                                                                stringBuilder2.append("] ");
                                                                                                stringBuilder2.append(str);
                                                                                                stringBuilder2.append(" with inBitmap ");
                                                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                                                stringBuilder2.append(" for [");
                                                                                                stringBuilder2.append(i);
                                                                                                stringBuilder2.append("x");
                                                                                                stringBuilder2.append(i2);
                                                                                                stringBuilder2.append("], sample size: ");
                                                                                                stringBuilder2.append(c.inSampleSize);
                                                                                                stringBuilder2.append(", density: ");
                                                                                                stringBuilder2.append(c.inDensity);
                                                                                                stringBuilder2.append(", target density: ");
                                                                                                stringBuilder2.append(c.inTargetDensity);
                                                                                                stringBuilder2.append(", thread: ");
                                                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                                                stringBuilder2.append(", duration: ");
                                                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                                                            }
                                                                                            if (b2 == null) {
                                                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                                                if (b2.equals(bitmap)) {
                                                                                                    downsampler.f3533i.mo940a(b2);
                                                                                                }
                                                                                            } else {
                                                                                                bitmap = null;
                                                                                            }
                                                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                                            m3037b(c);
                                                                                            downsampler.f3535k.mo950a(obj5);
                                                                                            return a;
                                                                                        }
                                                                                        if (z2) {
                                                                                        }
                                                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                                                            c.inDither = true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                inputStream3 = inputStream;
                                                                                c.inPreferredConfig = Config.ARGB_8888;
                                                                            } else {
                                                                                inputStream3 = inputStream;
                                                                            }
                                                                            if (VERSION.SDK_INT < 19) {
                                                                            }
                                                                            booleanValue = true;
                                                                            if (c.inSampleSize == 1 || obj4 != null) {
                                                                                if (VERSION.SDK_INT >= 19) {
                                                                                    booleanValue = f3531g.contains(obj2);
                                                                                }
                                                                                if (booleanValue) {
                                                                                    if (i5 >= 0 || i8 < 0 || !z3 || obj4 == null) {
                                                                                        if (m3034a(c)) {
                                                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                                        }
                                                                                        f2 = f;
                                                                                        i3 = c.inSampleSize;
                                                                                        f3 = (float) i3;
                                                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                                        i4 = Math.round(((float) i4) * f2);
                                                                                        b = Math.round(((float) b) * f2);
                                                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                                                            stringBuilder4.append(i4);
                                                                                            stringBuilder4.append("x");
                                                                                            stringBuilder4.append(b);
                                                                                            stringBuilder4.append("] for source [");
                                                                                            stringBuilder4.append(i5);
                                                                                            stringBuilder4.append("x");
                                                                                            stringBuilder4.append(i8);
                                                                                            stringBuilder4.append("], sampleSize: ");
                                                                                            stringBuilder4.append(i3);
                                                                                            stringBuilder4.append(", targetDensity: ");
                                                                                            stringBuilder4.append(c.inTargetDensity);
                                                                                            stringBuilder4.append(", density: ");
                                                                                            stringBuilder4.append(c.inDensity);
                                                                                            stringBuilder4.append(", density multiplier: ");
                                                                                            stringBuilder4.append(f2);
                                                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                                                        }
                                                                                        i3 = i4;
                                                                                    }
                                                                                    if (i3 > 0 && b > 0) {
                                                                                        bitmapPool = downsampler.f3533i;
                                                                                        if (VERSION.SDK_INT >= 26) {
                                                                                            config = null;
                                                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                                            config = c.outConfig;
                                                                                        }
                                                                                        if (config == null) {
                                                                                            config = c.inPreferredConfig;
                                                                                        }
                                                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                                    }
                                                                                }
                                                                            }
                                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                                stringBuilder2.append(m3032a(b2));
                                                                                stringBuilder2.append(" from [");
                                                                                stringBuilder2.append(i5);
                                                                                stringBuilder2.append("x");
                                                                                stringBuilder2.append(i8);
                                                                                stringBuilder2.append("] ");
                                                                                stringBuilder2.append(str);
                                                                                stringBuilder2.append(" with inBitmap ");
                                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                                stringBuilder2.append(" for [");
                                                                                stringBuilder2.append(i);
                                                                                stringBuilder2.append("x");
                                                                                stringBuilder2.append(i2);
                                                                                stringBuilder2.append("], sample size: ");
                                                                                stringBuilder2.append(c.inSampleSize);
                                                                                stringBuilder2.append(", density: ");
                                                                                stringBuilder2.append(c.inDensity);
                                                                                stringBuilder2.append(", target density: ");
                                                                                stringBuilder2.append(c.inTargetDensity);
                                                                                stringBuilder2.append(", thread: ");
                                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                                stringBuilder2.append(", duration: ");
                                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                                            }
                                                                            if (b2 == null) {
                                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                                if (b2.equals(bitmap)) {
                                                                                    downsampler.f3533i.mo940a(b2);
                                                                                }
                                                                            } else {
                                                                                bitmap = null;
                                                                            }
                                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                            m3037b(c);
                                                                            downsampler.f3535k.mo950a(obj5);
                                                                            return a;
                                                                        }
                                                                    }
                                                                    obj3 = null;
                                                                    if (obj3 == null) {
                                                                        inputStream3 = inputStream;
                                                                    } else if (VERSION.SDK_INT == 16) {
                                                                        inputStream3 = inputStream;
                                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                        if (z2) {
                                                                        }
                                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                                            c.inDither = true;
                                                                        }
                                                                    } else {
                                                                        inputStream3 = inputStream;
                                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                                    }
                                                                    if (VERSION.SDK_INT < 19) {
                                                                    }
                                                                    booleanValue = true;
                                                                    if (VERSION.SDK_INT >= 19) {
                                                                        booleanValue = f3531g.contains(obj2);
                                                                    }
                                                                    if (booleanValue) {
                                                                        if (i5 >= 0) {
                                                                        }
                                                                        if (m3034a(c)) {
                                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                        }
                                                                        f2 = f;
                                                                        i3 = c.inSampleSize;
                                                                        f3 = (float) i3;
                                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                        i4 = Math.round(((float) i4) * f2);
                                                                        b = Math.round(((float) b) * f2);
                                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                                            stringBuilder4.append(i4);
                                                                            stringBuilder4.append("x");
                                                                            stringBuilder4.append(b);
                                                                            stringBuilder4.append("] for source [");
                                                                            stringBuilder4.append(i5);
                                                                            stringBuilder4.append("x");
                                                                            stringBuilder4.append(i8);
                                                                            stringBuilder4.append("], sampleSize: ");
                                                                            stringBuilder4.append(i3);
                                                                            stringBuilder4.append(", targetDensity: ");
                                                                            stringBuilder4.append(c.inTargetDensity);
                                                                            stringBuilder4.append(", density: ");
                                                                            stringBuilder4.append(c.inDensity);
                                                                            stringBuilder4.append(", density multiplier: ");
                                                                            stringBuilder4.append(f2);
                                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                                        }
                                                                        i3 = i4;
                                                                        bitmapPool = downsampler.f3533i;
                                                                        if (VERSION.SDK_INT >= 26) {
                                                                            config = null;
                                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                            config = c.outConfig;
                                                                        }
                                                                        if (config == null) {
                                                                            config = c.inPreferredConfig;
                                                                        }
                                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                    }
                                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                                        stringBuilder2.append(m3032a(b2));
                                                                        stringBuilder2.append(" from [");
                                                                        stringBuilder2.append(i5);
                                                                        stringBuilder2.append("x");
                                                                        stringBuilder2.append(i8);
                                                                        stringBuilder2.append("] ");
                                                                        stringBuilder2.append(str);
                                                                        stringBuilder2.append(" with inBitmap ");
                                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                                        stringBuilder2.append(" for [");
                                                                        stringBuilder2.append(i);
                                                                        stringBuilder2.append("x");
                                                                        stringBuilder2.append(i2);
                                                                        stringBuilder2.append("], sample size: ");
                                                                        stringBuilder2.append(c.inSampleSize);
                                                                        stringBuilder2.append(", density: ");
                                                                        stringBuilder2.append(c.inDensity);
                                                                        stringBuilder2.append(", target density: ");
                                                                        stringBuilder2.append(c.inTargetDensity);
                                                                        stringBuilder2.append(", thread: ");
                                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                                        stringBuilder2.append(", duration: ");
                                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                                    }
                                                                    if (b2 == null) {
                                                                        bitmap = null;
                                                                    } else {
                                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                        if (b2.equals(bitmap)) {
                                                                            downsampler.f3533i.mo940a(b2);
                                                                        }
                                                                    }
                                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                    m3037b(c);
                                                                    downsampler.f3535k.mo950a(obj5);
                                                                    return a;
                                                                }
                                                            }
                                                            decodeFormat3 = decodeFormat2;
                                                            obj3 = null;
                                                            if (obj3 == null) {
                                                                inputStream3 = inputStream;
                                                            } else if (VERSION.SDK_INT == 16) {
                                                                inputStream3 = inputStream;
                                                                c.inPreferredConfig = Config.ARGB_8888;
                                                            } else {
                                                                inputStream3 = inputStream;
                                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                if (z2) {
                                                                }
                                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                                    c.inDither = true;
                                                                }
                                                            }
                                                            if (VERSION.SDK_INT < 19) {
                                                            }
                                                            booleanValue = true;
                                                            if (VERSION.SDK_INT >= 19) {
                                                                booleanValue = f3531g.contains(obj2);
                                                            }
                                                            if (booleanValue) {
                                                                if (i5 >= 0) {
                                                                }
                                                                if (m3034a(c)) {
                                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                }
                                                                f2 = f;
                                                                i3 = c.inSampleSize;
                                                                f3 = (float) i3;
                                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                i4 = Math.round(((float) i4) * f2);
                                                                b = Math.round(((float) b) * f2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                                    stringBuilder4.append(i4);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(b);
                                                                    stringBuilder4.append("] for source [");
                                                                    stringBuilder4.append(i5);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(i8);
                                                                    stringBuilder4.append("], sampleSize: ");
                                                                    stringBuilder4.append(i3);
                                                                    stringBuilder4.append(", targetDensity: ");
                                                                    stringBuilder4.append(c.inTargetDensity);
                                                                    stringBuilder4.append(", density: ");
                                                                    stringBuilder4.append(c.inDensity);
                                                                    stringBuilder4.append(", density multiplier: ");
                                                                    stringBuilder4.append(f2);
                                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                                }
                                                                i3 = i4;
                                                                bitmapPool = downsampler.f3533i;
                                                                if (VERSION.SDK_INT >= 26) {
                                                                    config = null;
                                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                    config = c.outConfig;
                                                                }
                                                                if (config == null) {
                                                                    config = c.inPreferredConfig;
                                                                }
                                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                            }
                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                stringBuilder2.append(m3032a(b2));
                                                                stringBuilder2.append(" from [");
                                                                stringBuilder2.append(i5);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i8);
                                                                stringBuilder2.append("] ");
                                                                stringBuilder2.append(str);
                                                                stringBuilder2.append(" with inBitmap ");
                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                stringBuilder2.append(" for [");
                                                                stringBuilder2.append(i);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i2);
                                                                stringBuilder2.append("], sample size: ");
                                                                stringBuilder2.append(c.inSampleSize);
                                                                stringBuilder2.append(", density: ");
                                                                stringBuilder2.append(c.inDensity);
                                                                stringBuilder2.append(", target density: ");
                                                                stringBuilder2.append(c.inTargetDensity);
                                                                stringBuilder2.append(", thread: ");
                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                stringBuilder2.append(", duration: ");
                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                            }
                                                            if (b2 == null) {
                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                if (b2.equals(bitmap)) {
                                                                    downsampler.f3533i.mo940a(b2);
                                                                }
                                                            } else {
                                                                bitmap = null;
                                                            }
                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                            m3037b(c);
                                                            downsampler.f3535k.mo950a(obj5);
                                                            return a;
                                                        }
                                                    }
                                                    inputStream4 = inputStream;
                                                    if (VERSION.SDK_INT < 24) {
                                                        f2 = (float) a4;
                                                        i3 = Math.round(f4 / f2);
                                                        i9 = Math.round(f5 / f2);
                                                        imageType = a5;
                                                        downsampleStrategy = downsampleStrategy2;
                                                        i4 = i9;
                                                        i9 = i3;
                                                        i3 = i11;
                                                        a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                                        if (VERSION.SDK_INT < 19) {
                                                            i14 = i9;
                                                            i13 = a4;
                                                        } else {
                                                            a10 = m3031a(a9);
                                                            i13 = a4;
                                                            a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                            i14 = i9;
                                                            c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                            c.inDensity = m3031a(a9);
                                                        }
                                                        if (m3034a(c)) {
                                                            c.inTargetDensity = 0;
                                                            c.inDensity = 0;
                                                        } else {
                                                            c.inScaled = true;
                                                        }
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                            stringBuilder3.append(i5);
                                                            stringBuilder3.append("x");
                                                            stringBuilder3.append(i8);
                                                            stringBuilder3.append("], target: [");
                                                            stringBuilder3.append(i3);
                                                            stringBuilder3.append("x");
                                                            stringBuilder3.append(b);
                                                            stringBuilder3.append("], power of two scaled: [");
                                                            stringBuilder3.append(i14);
                                                            stringBuilder3.append("x");
                                                            stringBuilder3.append(i4);
                                                            stringBuilder3.append("], exact scale factor: ");
                                                            stringBuilder3.append(a6);
                                                            stringBuilder3.append(", power of 2 sample size: ");
                                                            stringBuilder3.append(i13);
                                                            stringBuilder3.append(", adjusted scale factor: ");
                                                            stringBuilder3.append(a9);
                                                            stringBuilder3.append(", target density: ");
                                                            stringBuilder3.append(c.inTargetDensity);
                                                            stringBuilder3.append(", density: ");
                                                            stringBuilder3.append(c.inDensity);
                                                            Log.v("Downsampler", stringBuilder3.toString());
                                                        }
                                                        obj2 = imageType;
                                                        hardwareConfigState = this.f3537m;
                                                        if (i7 != 0) {
                                                            if (VERSION.SDK_INT >= 26) {
                                                                decodeFormat3 = decodeFormat2;
                                                                if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                                    if (!z) {
                                                                        if (i3 >= 128) {
                                                                        }
                                                                        if (obj3 == null) {
                                                                            c.inPreferredConfig = Config.HARDWARE;
                                                                            c.inMutable = false;
                                                                        }
                                                                        if (obj3 == null) {
                                                                            inputStream3 = inputStream;
                                                                        } else if (VERSION.SDK_INT == 16) {
                                                                            inputStream3 = inputStream;
                                                                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                            if (z2) {
                                                                            }
                                                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                                                c.inDither = true;
                                                                            }
                                                                        } else {
                                                                            inputStream3 = inputStream;
                                                                            c.inPreferredConfig = Config.ARGB_8888;
                                                                        }
                                                                        if (VERSION.SDK_INT < 19) {
                                                                        }
                                                                        booleanValue = true;
                                                                        if (VERSION.SDK_INT >= 19) {
                                                                            booleanValue = f3531g.contains(obj2);
                                                                        }
                                                                        if (booleanValue) {
                                                                            if (i5 >= 0) {
                                                                            }
                                                                            if (m3034a(c)) {
                                                                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                            }
                                                                            f2 = f;
                                                                            i3 = c.inSampleSize;
                                                                            f3 = (float) i3;
                                                                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                            b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                            i4 = Math.round(((float) i4) * f2);
                                                                            b = Math.round(((float) b) * f2);
                                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                                stringBuilder4 = new StringBuilder("Calculated target [");
                                                                                stringBuilder4.append(i4);
                                                                                stringBuilder4.append("x");
                                                                                stringBuilder4.append(b);
                                                                                stringBuilder4.append("] for source [");
                                                                                stringBuilder4.append(i5);
                                                                                stringBuilder4.append("x");
                                                                                stringBuilder4.append(i8);
                                                                                stringBuilder4.append("], sampleSize: ");
                                                                                stringBuilder4.append(i3);
                                                                                stringBuilder4.append(", targetDensity: ");
                                                                                stringBuilder4.append(c.inTargetDensity);
                                                                                stringBuilder4.append(", density: ");
                                                                                stringBuilder4.append(c.inDensity);
                                                                                stringBuilder4.append(", density multiplier: ");
                                                                                stringBuilder4.append(f2);
                                                                                Log.v("Downsampler", stringBuilder4.toString());
                                                                            }
                                                                            i3 = i4;
                                                                            bitmapPool = downsampler.f3533i;
                                                                            if (VERSION.SDK_INT >= 26) {
                                                                                config = null;
                                                                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                                config = c.outConfig;
                                                                            }
                                                                            if (config == null) {
                                                                                config = c.inPreferredConfig;
                                                                            }
                                                                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                        }
                                                                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                                            stringBuilder2 = new StringBuilder("Decoded ");
                                                                            stringBuilder2.append(m3032a(b2));
                                                                            stringBuilder2.append(" from [");
                                                                            stringBuilder2.append(i5);
                                                                            stringBuilder2.append("x");
                                                                            stringBuilder2.append(i8);
                                                                            stringBuilder2.append("] ");
                                                                            stringBuilder2.append(str);
                                                                            stringBuilder2.append(" with inBitmap ");
                                                                            stringBuilder2.append(m3032a(c.inBitmap));
                                                                            stringBuilder2.append(" for [");
                                                                            stringBuilder2.append(i);
                                                                            stringBuilder2.append("x");
                                                                            stringBuilder2.append(i2);
                                                                            stringBuilder2.append("], sample size: ");
                                                                            stringBuilder2.append(c.inSampleSize);
                                                                            stringBuilder2.append(", density: ");
                                                                            stringBuilder2.append(c.inDensity);
                                                                            stringBuilder2.append(", target density: ");
                                                                            stringBuilder2.append(c.inTargetDensity);
                                                                            stringBuilder2.append(", thread: ");
                                                                            stringBuilder2.append(Thread.currentThread().getName());
                                                                            stringBuilder2.append(", duration: ");
                                                                            stringBuilder2.append(LogTime.m3212a(j));
                                                                            Log.v("Downsampler", stringBuilder2.toString());
                                                                        }
                                                                        if (b2 == null) {
                                                                            bitmap = null;
                                                                        } else {
                                                                            b2.setDensity(downsampler.f3534j.densityDpi);
                                                                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                            if (b2.equals(bitmap)) {
                                                                                downsampler.f3533i.mo940a(b2);
                                                                            }
                                                                        }
                                                                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                        m3037b(c);
                                                                        downsampler.f3535k.mo950a(obj5);
                                                                        return a;
                                                                    }
                                                                }
                                                                obj3 = null;
                                                                if (obj3 == null) {
                                                                    inputStream3 = inputStream;
                                                                } else if (VERSION.SDK_INT == 16) {
                                                                    inputStream3 = inputStream;
                                                                    c.inPreferredConfig = Config.ARGB_8888;
                                                                } else {
                                                                    inputStream3 = inputStream;
                                                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                    if (z2) {
                                                                    }
                                                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                    if (c.inPreferredConfig == Config.RGB_565) {
                                                                        c.inDither = true;
                                                                    }
                                                                }
                                                                if (VERSION.SDK_INT < 19) {
                                                                }
                                                                booleanValue = true;
                                                                if (VERSION.SDK_INT >= 19) {
                                                                    booleanValue = f3531g.contains(obj2);
                                                                }
                                                                if (booleanValue) {
                                                                    if (i5 >= 0) {
                                                                    }
                                                                    if (m3034a(c)) {
                                                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                    }
                                                                    f2 = f;
                                                                    i3 = c.inSampleSize;
                                                                    f3 = (float) i3;
                                                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                    i4 = Math.round(((float) i4) * f2);
                                                                    b = Math.round(((float) b) * f2);
                                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                                                        stringBuilder4.append(i4);
                                                                        stringBuilder4.append("x");
                                                                        stringBuilder4.append(b);
                                                                        stringBuilder4.append("] for source [");
                                                                        stringBuilder4.append(i5);
                                                                        stringBuilder4.append("x");
                                                                        stringBuilder4.append(i8);
                                                                        stringBuilder4.append("], sampleSize: ");
                                                                        stringBuilder4.append(i3);
                                                                        stringBuilder4.append(", targetDensity: ");
                                                                        stringBuilder4.append(c.inTargetDensity);
                                                                        stringBuilder4.append(", density: ");
                                                                        stringBuilder4.append(c.inDensity);
                                                                        stringBuilder4.append(", density multiplier: ");
                                                                        stringBuilder4.append(f2);
                                                                        Log.v("Downsampler", stringBuilder4.toString());
                                                                    }
                                                                    i3 = i4;
                                                                    bitmapPool = downsampler.f3533i;
                                                                    if (VERSION.SDK_INT >= 26) {
                                                                        config = null;
                                                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                        config = c.outConfig;
                                                                    }
                                                                    if (config == null) {
                                                                        config = c.inPreferredConfig;
                                                                    }
                                                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                }
                                                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder2 = new StringBuilder("Decoded ");
                                                                    stringBuilder2.append(m3032a(b2));
                                                                    stringBuilder2.append(" from [");
                                                                    stringBuilder2.append(i5);
                                                                    stringBuilder2.append("x");
                                                                    stringBuilder2.append(i8);
                                                                    stringBuilder2.append("] ");
                                                                    stringBuilder2.append(str);
                                                                    stringBuilder2.append(" with inBitmap ");
                                                                    stringBuilder2.append(m3032a(c.inBitmap));
                                                                    stringBuilder2.append(" for [");
                                                                    stringBuilder2.append(i);
                                                                    stringBuilder2.append("x");
                                                                    stringBuilder2.append(i2);
                                                                    stringBuilder2.append("], sample size: ");
                                                                    stringBuilder2.append(c.inSampleSize);
                                                                    stringBuilder2.append(", density: ");
                                                                    stringBuilder2.append(c.inDensity);
                                                                    stringBuilder2.append(", target density: ");
                                                                    stringBuilder2.append(c.inTargetDensity);
                                                                    stringBuilder2.append(", thread: ");
                                                                    stringBuilder2.append(Thread.currentThread().getName());
                                                                    stringBuilder2.append(", duration: ");
                                                                    stringBuilder2.append(LogTime.m3212a(j));
                                                                    Log.v("Downsampler", stringBuilder2.toString());
                                                                }
                                                                if (b2 == null) {
                                                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                    if (b2.equals(bitmap)) {
                                                                        downsampler.f3533i.mo940a(b2);
                                                                    }
                                                                } else {
                                                                    bitmap = null;
                                                                }
                                                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                m3037b(c);
                                                                downsampler.f3535k.mo950a(obj5);
                                                                return a;
                                                            }
                                                        }
                                                        decodeFormat3 = decodeFormat2;
                                                        obj3 = null;
                                                        if (obj3 == null) {
                                                            inputStream3 = inputStream;
                                                        } else if (VERSION.SDK_INT == 16) {
                                                            inputStream3 = inputStream;
                                                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                            if (z2) {
                                                            }
                                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                                c.inDither = true;
                                                            }
                                                        } else {
                                                            inputStream3 = inputStream;
                                                            c.inPreferredConfig = Config.ARGB_8888;
                                                        }
                                                        if (VERSION.SDK_INT < 19) {
                                                        }
                                                        booleanValue = true;
                                                        if (VERSION.SDK_INT >= 19) {
                                                            booleanValue = f3531g.contains(obj2);
                                                        }
                                                        if (booleanValue) {
                                                            if (i5 >= 0) {
                                                            }
                                                            if (m3034a(c)) {
                                                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                            }
                                                            f2 = f;
                                                            i3 = c.inSampleSize;
                                                            f3 = (float) i3;
                                                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                            b = (int) Math.ceil((double) (((float) i8) / f3));
                                                            i4 = Math.round(((float) i4) * f2);
                                                            b = Math.round(((float) b) * f2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder4 = new StringBuilder("Calculated target [");
                                                                stringBuilder4.append(i4);
                                                                stringBuilder4.append("x");
                                                                stringBuilder4.append(b);
                                                                stringBuilder4.append("] for source [");
                                                                stringBuilder4.append(i5);
                                                                stringBuilder4.append("x");
                                                                stringBuilder4.append(i8);
                                                                stringBuilder4.append("], sampleSize: ");
                                                                stringBuilder4.append(i3);
                                                                stringBuilder4.append(", targetDensity: ");
                                                                stringBuilder4.append(c.inTargetDensity);
                                                                stringBuilder4.append(", density: ");
                                                                stringBuilder4.append(c.inDensity);
                                                                stringBuilder4.append(", density multiplier: ");
                                                                stringBuilder4.append(f2);
                                                                Log.v("Downsampler", stringBuilder4.toString());
                                                            }
                                                            i3 = i4;
                                                            bitmapPool = downsampler.f3533i;
                                                            if (VERSION.SDK_INT >= 26) {
                                                                config = null;
                                                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                config = c.outConfig;
                                                            }
                                                            if (config == null) {
                                                                config = c.inPreferredConfig;
                                                            }
                                                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                        }
                                                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder2 = new StringBuilder("Decoded ");
                                                            stringBuilder2.append(m3032a(b2));
                                                            stringBuilder2.append(" from [");
                                                            stringBuilder2.append(i5);
                                                            stringBuilder2.append("x");
                                                            stringBuilder2.append(i8);
                                                            stringBuilder2.append("] ");
                                                            stringBuilder2.append(str);
                                                            stringBuilder2.append(" with inBitmap ");
                                                            stringBuilder2.append(m3032a(c.inBitmap));
                                                            stringBuilder2.append(" for [");
                                                            stringBuilder2.append(i);
                                                            stringBuilder2.append("x");
                                                            stringBuilder2.append(i2);
                                                            stringBuilder2.append("], sample size: ");
                                                            stringBuilder2.append(c.inSampleSize);
                                                            stringBuilder2.append(", density: ");
                                                            stringBuilder2.append(c.inDensity);
                                                            stringBuilder2.append(", target density: ");
                                                            stringBuilder2.append(c.inTargetDensity);
                                                            stringBuilder2.append(", thread: ");
                                                            stringBuilder2.append(Thread.currentThread().getName());
                                                            stringBuilder2.append(", duration: ");
                                                            stringBuilder2.append(LogTime.m3212a(j));
                                                            Log.v("Downsampler", stringBuilder2.toString());
                                                        }
                                                        if (b2 == null) {
                                                            bitmap = null;
                                                        } else {
                                                            b2.setDensity(downsampler.f3534j.densityDpi);
                                                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                            if (b2.equals(bitmap)) {
                                                                downsampler.f3533i.mo940a(b2);
                                                            }
                                                        }
                                                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                        m3037b(c);
                                                        downsampler.f3535k.mo950a(obj5);
                                                        return a;
                                                    }
                                                    f2 = (float) a4;
                                                    imageType = a5;
                                                    i3 = (int) Math.floor((double) (f4 / f2));
                                                    i9 = (int) Math.floor((double) (f5 / f2));
                                                    i4 = i9;
                                                    i9 = i3;
                                                    downsampleStrategy = downsampleStrategy2;
                                                    i3 = i11;
                                                    a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                                    if (VERSION.SDK_INT < 19) {
                                                        a10 = m3031a(a9);
                                                        i13 = a4;
                                                        a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                        i14 = i9;
                                                        c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                        c.inDensity = m3031a(a9);
                                                    } else {
                                                        i14 = i9;
                                                        i13 = a4;
                                                    }
                                                    if (m3034a(c)) {
                                                        c.inScaled = true;
                                                    } else {
                                                        c.inTargetDensity = 0;
                                                        c.inDensity = 0;
                                                    }
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                        stringBuilder3.append(i5);
                                                        stringBuilder3.append("x");
                                                        stringBuilder3.append(i8);
                                                        stringBuilder3.append("], target: [");
                                                        stringBuilder3.append(i3);
                                                        stringBuilder3.append("x");
                                                        stringBuilder3.append(b);
                                                        stringBuilder3.append("], power of two scaled: [");
                                                        stringBuilder3.append(i14);
                                                        stringBuilder3.append("x");
                                                        stringBuilder3.append(i4);
                                                        stringBuilder3.append("], exact scale factor: ");
                                                        stringBuilder3.append(a6);
                                                        stringBuilder3.append(", power of 2 sample size: ");
                                                        stringBuilder3.append(i13);
                                                        stringBuilder3.append(", adjusted scale factor: ");
                                                        stringBuilder3.append(a9);
                                                        stringBuilder3.append(", target density: ");
                                                        stringBuilder3.append(c.inTargetDensity);
                                                        stringBuilder3.append(", density: ");
                                                        stringBuilder3.append(c.inDensity);
                                                        Log.v("Downsampler", stringBuilder3.toString());
                                                    }
                                                    obj2 = imageType;
                                                    hardwareConfigState = this.f3537m;
                                                    if (i7 != 0) {
                                                        if (VERSION.SDK_INT >= 26) {
                                                            decodeFormat3 = decodeFormat2;
                                                            if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                                if (!z) {
                                                                    if (i3 >= 128) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                        c.inPreferredConfig = Config.HARDWARE;
                                                                        c.inMutable = false;
                                                                    }
                                                                    if (obj3 == null) {
                                                                        inputStream3 = inputStream;
                                                                    } else if (VERSION.SDK_INT == 16) {
                                                                        inputStream3 = inputStream;
                                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                                    } else {
                                                                        inputStream3 = inputStream;
                                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                        if (z2) {
                                                                        }
                                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                                            c.inDither = true;
                                                                        }
                                                                    }
                                                                    if (VERSION.SDK_INT < 19) {
                                                                    }
                                                                    booleanValue = true;
                                                                    if (VERSION.SDK_INT >= 19) {
                                                                        booleanValue = f3531g.contains(obj2);
                                                                    }
                                                                    if (booleanValue) {
                                                                        if (i5 >= 0) {
                                                                        }
                                                                        if (m3034a(c)) {
                                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                        }
                                                                        f2 = f;
                                                                        i3 = c.inSampleSize;
                                                                        f3 = (float) i3;
                                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                        i4 = Math.round(((float) i4) * f2);
                                                                        b = Math.round(((float) b) * f2);
                                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                                            stringBuilder4.append(i4);
                                                                            stringBuilder4.append("x");
                                                                            stringBuilder4.append(b);
                                                                            stringBuilder4.append("] for source [");
                                                                            stringBuilder4.append(i5);
                                                                            stringBuilder4.append("x");
                                                                            stringBuilder4.append(i8);
                                                                            stringBuilder4.append("], sampleSize: ");
                                                                            stringBuilder4.append(i3);
                                                                            stringBuilder4.append(", targetDensity: ");
                                                                            stringBuilder4.append(c.inTargetDensity);
                                                                            stringBuilder4.append(", density: ");
                                                                            stringBuilder4.append(c.inDensity);
                                                                            stringBuilder4.append(", density multiplier: ");
                                                                            stringBuilder4.append(f2);
                                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                                        }
                                                                        i3 = i4;
                                                                        bitmapPool = downsampler.f3533i;
                                                                        if (VERSION.SDK_INT >= 26) {
                                                                            config = null;
                                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                            config = c.outConfig;
                                                                        }
                                                                        if (config == null) {
                                                                            config = c.inPreferredConfig;
                                                                        }
                                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                    }
                                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                                        stringBuilder2.append(m3032a(b2));
                                                                        stringBuilder2.append(" from [");
                                                                        stringBuilder2.append(i5);
                                                                        stringBuilder2.append("x");
                                                                        stringBuilder2.append(i8);
                                                                        stringBuilder2.append("] ");
                                                                        stringBuilder2.append(str);
                                                                        stringBuilder2.append(" with inBitmap ");
                                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                                        stringBuilder2.append(" for [");
                                                                        stringBuilder2.append(i);
                                                                        stringBuilder2.append("x");
                                                                        stringBuilder2.append(i2);
                                                                        stringBuilder2.append("], sample size: ");
                                                                        stringBuilder2.append(c.inSampleSize);
                                                                        stringBuilder2.append(", density: ");
                                                                        stringBuilder2.append(c.inDensity);
                                                                        stringBuilder2.append(", target density: ");
                                                                        stringBuilder2.append(c.inTargetDensity);
                                                                        stringBuilder2.append(", thread: ");
                                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                                        stringBuilder2.append(", duration: ");
                                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                                    }
                                                                    if (b2 == null) {
                                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                        if (b2.equals(bitmap)) {
                                                                            downsampler.f3533i.mo940a(b2);
                                                                        }
                                                                    } else {
                                                                        bitmap = null;
                                                                    }
                                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                    m3037b(c);
                                                                    downsampler.f3535k.mo950a(obj5);
                                                                    return a;
                                                                }
                                                            }
                                                            obj3 = null;
                                                            if (obj3 == null) {
                                                                inputStream3 = inputStream;
                                                            } else if (VERSION.SDK_INT == 16) {
                                                                inputStream3 = inputStream;
                                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                if (z2) {
                                                                }
                                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                                    c.inDither = true;
                                                                }
                                                            } else {
                                                                inputStream3 = inputStream;
                                                                c.inPreferredConfig = Config.ARGB_8888;
                                                            }
                                                            if (VERSION.SDK_INT < 19) {
                                                            }
                                                            booleanValue = true;
                                                            if (VERSION.SDK_INT >= 19) {
                                                                booleanValue = f3531g.contains(obj2);
                                                            }
                                                            if (booleanValue) {
                                                                if (i5 >= 0) {
                                                                }
                                                                if (m3034a(c)) {
                                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                }
                                                                f2 = f;
                                                                i3 = c.inSampleSize;
                                                                f3 = (float) i3;
                                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                i4 = Math.round(((float) i4) * f2);
                                                                b = Math.round(((float) b) * f2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                                    stringBuilder4.append(i4);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(b);
                                                                    stringBuilder4.append("] for source [");
                                                                    stringBuilder4.append(i5);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(i8);
                                                                    stringBuilder4.append("], sampleSize: ");
                                                                    stringBuilder4.append(i3);
                                                                    stringBuilder4.append(", targetDensity: ");
                                                                    stringBuilder4.append(c.inTargetDensity);
                                                                    stringBuilder4.append(", density: ");
                                                                    stringBuilder4.append(c.inDensity);
                                                                    stringBuilder4.append(", density multiplier: ");
                                                                    stringBuilder4.append(f2);
                                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                                }
                                                                i3 = i4;
                                                                bitmapPool = downsampler.f3533i;
                                                                if (VERSION.SDK_INT >= 26) {
                                                                    config = null;
                                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                    config = c.outConfig;
                                                                }
                                                                if (config == null) {
                                                                    config = c.inPreferredConfig;
                                                                }
                                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                            }
                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                stringBuilder2.append(m3032a(b2));
                                                                stringBuilder2.append(" from [");
                                                                stringBuilder2.append(i5);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i8);
                                                                stringBuilder2.append("] ");
                                                                stringBuilder2.append(str);
                                                                stringBuilder2.append(" with inBitmap ");
                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                stringBuilder2.append(" for [");
                                                                stringBuilder2.append(i);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i2);
                                                                stringBuilder2.append("], sample size: ");
                                                                stringBuilder2.append(c.inSampleSize);
                                                                stringBuilder2.append(", density: ");
                                                                stringBuilder2.append(c.inDensity);
                                                                stringBuilder2.append(", target density: ");
                                                                stringBuilder2.append(c.inTargetDensity);
                                                                stringBuilder2.append(", thread: ");
                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                stringBuilder2.append(", duration: ");
                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                            }
                                                            if (b2 == null) {
                                                                bitmap = null;
                                                            } else {
                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                if (b2.equals(bitmap)) {
                                                                    downsampler.f3533i.mo940a(b2);
                                                                }
                                                            }
                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                            m3037b(c);
                                                            downsampler.f3535k.mo950a(obj5);
                                                            return a;
                                                        }
                                                    }
                                                    decodeFormat3 = decodeFormat2;
                                                    obj3 = null;
                                                    if (obj3 == null) {
                                                        inputStream3 = inputStream;
                                                    } else if (VERSION.SDK_INT == 16) {
                                                        inputStream3 = inputStream;
                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                    } else {
                                                        inputStream3 = inputStream;
                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                        if (z2) {
                                                        }
                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                            c.inDither = true;
                                                        }
                                                    }
                                                    if (VERSION.SDK_INT < 19) {
                                                    }
                                                    booleanValue = true;
                                                    if (VERSION.SDK_INT >= 19) {
                                                        booleanValue = f3531g.contains(obj2);
                                                    }
                                                    if (booleanValue) {
                                                        if (i5 >= 0) {
                                                        }
                                                        if (m3034a(c)) {
                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                        }
                                                        f2 = f;
                                                        i3 = c.inSampleSize;
                                                        f3 = (float) i3;
                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                        i4 = Math.round(((float) i4) * f2);
                                                        b = Math.round(((float) b) * f2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                            stringBuilder4.append(i4);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(b);
                                                            stringBuilder4.append("] for source [");
                                                            stringBuilder4.append(i5);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(i8);
                                                            stringBuilder4.append("], sampleSize: ");
                                                            stringBuilder4.append(i3);
                                                            stringBuilder4.append(", targetDensity: ");
                                                            stringBuilder4.append(c.inTargetDensity);
                                                            stringBuilder4.append(", density: ");
                                                            stringBuilder4.append(c.inDensity);
                                                            stringBuilder4.append(", density multiplier: ");
                                                            stringBuilder4.append(f2);
                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                        }
                                                        i3 = i4;
                                                        bitmapPool = downsampler.f3533i;
                                                        if (VERSION.SDK_INT >= 26) {
                                                            config = null;
                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                            config = c.outConfig;
                                                        }
                                                        if (config == null) {
                                                            config = c.inPreferredConfig;
                                                        }
                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                    }
                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                        stringBuilder2.append(m3032a(b2));
                                                        stringBuilder2.append(" from [");
                                                        stringBuilder2.append(i5);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i8);
                                                        stringBuilder2.append("] ");
                                                        stringBuilder2.append(str);
                                                        stringBuilder2.append(" with inBitmap ");
                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                        stringBuilder2.append(" for [");
                                                        stringBuilder2.append(i);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i2);
                                                        stringBuilder2.append("], sample size: ");
                                                        stringBuilder2.append(c.inSampleSize);
                                                        stringBuilder2.append(", density: ");
                                                        stringBuilder2.append(c.inDensity);
                                                        stringBuilder2.append(", target density: ");
                                                        stringBuilder2.append(c.inTargetDensity);
                                                        stringBuilder2.append(", thread: ");
                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                        stringBuilder2.append(", duration: ");
                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                    }
                                                    if (b2 == null) {
                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                        if (b2.equals(bitmap)) {
                                                            downsampler.f3533i.mo940a(b2);
                                                        }
                                                    } else {
                                                        bitmap = null;
                                                    }
                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                    m3037b(c);
                                                    downsampler.f3535k.mo950a(obj5);
                                                    return a;
                                                }
                                            }
                                            imageType = a5;
                                            inputStream4 = inputStream;
                                            f2 = (float) a4;
                                            i3 = (int) Math.floor((double) (f4 / f2));
                                            i9 = (int) Math.floor((double) (f5 / f2));
                                            i4 = i9;
                                            i9 = i3;
                                            downsampleStrategy = downsampleStrategy2;
                                            i3 = i11;
                                            a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                            if (VERSION.SDK_INT < 19) {
                                                i14 = i9;
                                                i13 = a4;
                                            } else {
                                                a10 = m3031a(a9);
                                                i13 = a4;
                                                a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                i14 = i9;
                                                c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                c.inDensity = m3031a(a9);
                                            }
                                            if (m3034a(c)) {
                                                c.inTargetDensity = 0;
                                                c.inDensity = 0;
                                            } else {
                                                c.inScaled = true;
                                            }
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                stringBuilder3.append(i5);
                                                stringBuilder3.append("x");
                                                stringBuilder3.append(i8);
                                                stringBuilder3.append("], target: [");
                                                stringBuilder3.append(i3);
                                                stringBuilder3.append("x");
                                                stringBuilder3.append(b);
                                                stringBuilder3.append("], power of two scaled: [");
                                                stringBuilder3.append(i14);
                                                stringBuilder3.append("x");
                                                stringBuilder3.append(i4);
                                                stringBuilder3.append("], exact scale factor: ");
                                                stringBuilder3.append(a6);
                                                stringBuilder3.append(", power of 2 sample size: ");
                                                stringBuilder3.append(i13);
                                                stringBuilder3.append(", adjusted scale factor: ");
                                                stringBuilder3.append(a9);
                                                stringBuilder3.append(", target density: ");
                                                stringBuilder3.append(c.inTargetDensity);
                                                stringBuilder3.append(", density: ");
                                                stringBuilder3.append(c.inDensity);
                                                Log.v("Downsampler", stringBuilder3.toString());
                                            }
                                            obj2 = imageType;
                                            hardwareConfigState = this.f3537m;
                                            if (i7 != 0) {
                                                if (VERSION.SDK_INT >= 26) {
                                                    decodeFormat3 = decodeFormat2;
                                                    if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                        if (!z) {
                                                            if (i3 >= 128) {
                                                            }
                                                            if (obj3 == null) {
                                                                c.inPreferredConfig = Config.HARDWARE;
                                                                c.inMutable = false;
                                                            }
                                                            if (obj3 == null) {
                                                                inputStream3 = inputStream;
                                                            } else if (VERSION.SDK_INT == 16) {
                                                                inputStream3 = inputStream;
                                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                if (z2) {
                                                                }
                                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                                    c.inDither = true;
                                                                }
                                                            } else {
                                                                inputStream3 = inputStream;
                                                                c.inPreferredConfig = Config.ARGB_8888;
                                                            }
                                                            if (VERSION.SDK_INT < 19) {
                                                            }
                                                            booleanValue = true;
                                                            if (VERSION.SDK_INT >= 19) {
                                                                booleanValue = f3531g.contains(obj2);
                                                            }
                                                            if (booleanValue) {
                                                                if (i5 >= 0) {
                                                                }
                                                                if (m3034a(c)) {
                                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                }
                                                                f2 = f;
                                                                i3 = c.inSampleSize;
                                                                f3 = (float) i3;
                                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                i4 = Math.round(((float) i4) * f2);
                                                                b = Math.round(((float) b) * f2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                                    stringBuilder4.append(i4);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(b);
                                                                    stringBuilder4.append("] for source [");
                                                                    stringBuilder4.append(i5);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(i8);
                                                                    stringBuilder4.append("], sampleSize: ");
                                                                    stringBuilder4.append(i3);
                                                                    stringBuilder4.append(", targetDensity: ");
                                                                    stringBuilder4.append(c.inTargetDensity);
                                                                    stringBuilder4.append(", density: ");
                                                                    stringBuilder4.append(c.inDensity);
                                                                    stringBuilder4.append(", density multiplier: ");
                                                                    stringBuilder4.append(f2);
                                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                                }
                                                                i3 = i4;
                                                                bitmapPool = downsampler.f3533i;
                                                                if (VERSION.SDK_INT >= 26) {
                                                                    config = null;
                                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                    config = c.outConfig;
                                                                }
                                                                if (config == null) {
                                                                    config = c.inPreferredConfig;
                                                                }
                                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                            }
                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                stringBuilder2.append(m3032a(b2));
                                                                stringBuilder2.append(" from [");
                                                                stringBuilder2.append(i5);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i8);
                                                                stringBuilder2.append("] ");
                                                                stringBuilder2.append(str);
                                                                stringBuilder2.append(" with inBitmap ");
                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                stringBuilder2.append(" for [");
                                                                stringBuilder2.append(i);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i2);
                                                                stringBuilder2.append("], sample size: ");
                                                                stringBuilder2.append(c.inSampleSize);
                                                                stringBuilder2.append(", density: ");
                                                                stringBuilder2.append(c.inDensity);
                                                                stringBuilder2.append(", target density: ");
                                                                stringBuilder2.append(c.inTargetDensity);
                                                                stringBuilder2.append(", thread: ");
                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                stringBuilder2.append(", duration: ");
                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                            }
                                                            if (b2 == null) {
                                                                bitmap = null;
                                                            } else {
                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                if (b2.equals(bitmap)) {
                                                                    downsampler.f3533i.mo940a(b2);
                                                                }
                                                            }
                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                            m3037b(c);
                                                            downsampler.f3535k.mo950a(obj5);
                                                            return a;
                                                        }
                                                    }
                                                    obj3 = null;
                                                    if (obj3 == null) {
                                                        inputStream3 = inputStream;
                                                    } else if (VERSION.SDK_INT == 16) {
                                                        inputStream3 = inputStream;
                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                    } else {
                                                        inputStream3 = inputStream;
                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                        if (z2) {
                                                        }
                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                            c.inDither = true;
                                                        }
                                                    }
                                                    if (VERSION.SDK_INT < 19) {
                                                    }
                                                    booleanValue = true;
                                                    if (VERSION.SDK_INT >= 19) {
                                                        booleanValue = f3531g.contains(obj2);
                                                    }
                                                    if (booleanValue) {
                                                        if (i5 >= 0) {
                                                        }
                                                        if (m3034a(c)) {
                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                        }
                                                        f2 = f;
                                                        i3 = c.inSampleSize;
                                                        f3 = (float) i3;
                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                        i4 = Math.round(((float) i4) * f2);
                                                        b = Math.round(((float) b) * f2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                            stringBuilder4.append(i4);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(b);
                                                            stringBuilder4.append("] for source [");
                                                            stringBuilder4.append(i5);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(i8);
                                                            stringBuilder4.append("], sampleSize: ");
                                                            stringBuilder4.append(i3);
                                                            stringBuilder4.append(", targetDensity: ");
                                                            stringBuilder4.append(c.inTargetDensity);
                                                            stringBuilder4.append(", density: ");
                                                            stringBuilder4.append(c.inDensity);
                                                            stringBuilder4.append(", density multiplier: ");
                                                            stringBuilder4.append(f2);
                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                        }
                                                        i3 = i4;
                                                        bitmapPool = downsampler.f3533i;
                                                        if (VERSION.SDK_INT >= 26) {
                                                            config = null;
                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                            config = c.outConfig;
                                                        }
                                                        if (config == null) {
                                                            config = c.inPreferredConfig;
                                                        }
                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                    }
                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                        stringBuilder2.append(m3032a(b2));
                                                        stringBuilder2.append(" from [");
                                                        stringBuilder2.append(i5);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i8);
                                                        stringBuilder2.append("] ");
                                                        stringBuilder2.append(str);
                                                        stringBuilder2.append(" with inBitmap ");
                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                        stringBuilder2.append(" for [");
                                                        stringBuilder2.append(i);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i2);
                                                        stringBuilder2.append("], sample size: ");
                                                        stringBuilder2.append(c.inSampleSize);
                                                        stringBuilder2.append(", density: ");
                                                        stringBuilder2.append(c.inDensity);
                                                        stringBuilder2.append(", target density: ");
                                                        stringBuilder2.append(c.inTargetDensity);
                                                        stringBuilder2.append(", thread: ");
                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                        stringBuilder2.append(", duration: ");
                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                    }
                                                    if (b2 == null) {
                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                        if (b2.equals(bitmap)) {
                                                            downsampler.f3533i.mo940a(b2);
                                                        }
                                                    } else {
                                                        bitmap = null;
                                                    }
                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                    m3037b(c);
                                                    downsampler.f3535k.mo950a(obj5);
                                                    return a;
                                                }
                                            }
                                            decodeFormat3 = decodeFormat2;
                                            obj3 = null;
                                            if (obj3 == null) {
                                                inputStream3 = inputStream;
                                            } else if (VERSION.SDK_INT == 16) {
                                                inputStream3 = inputStream;
                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                if (z2) {
                                                }
                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                    c.inDither = true;
                                                }
                                            } else {
                                                inputStream3 = inputStream;
                                                c.inPreferredConfig = Config.ARGB_8888;
                                            }
                                            if (VERSION.SDK_INT < 19) {
                                            }
                                            booleanValue = true;
                                            if (VERSION.SDK_INT >= 19) {
                                                booleanValue = f3531g.contains(obj2);
                                            }
                                            if (booleanValue) {
                                                if (i5 >= 0) {
                                                }
                                                if (m3034a(c)) {
                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                }
                                                f2 = f;
                                                i3 = c.inSampleSize;
                                                f3 = (float) i3;
                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                i4 = Math.round(((float) i4) * f2);
                                                b = Math.round(((float) b) * f2);
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                    stringBuilder4.append(i4);
                                                    stringBuilder4.append("x");
                                                    stringBuilder4.append(b);
                                                    stringBuilder4.append("] for source [");
                                                    stringBuilder4.append(i5);
                                                    stringBuilder4.append("x");
                                                    stringBuilder4.append(i8);
                                                    stringBuilder4.append("], sampleSize: ");
                                                    stringBuilder4.append(i3);
                                                    stringBuilder4.append(", targetDensity: ");
                                                    stringBuilder4.append(c.inTargetDensity);
                                                    stringBuilder4.append(", density: ");
                                                    stringBuilder4.append(c.inDensity);
                                                    stringBuilder4.append(", density multiplier: ");
                                                    stringBuilder4.append(f2);
                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                }
                                                i3 = i4;
                                                bitmapPool = downsampler.f3533i;
                                                if (VERSION.SDK_INT >= 26) {
                                                    config = null;
                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                    config = c.outConfig;
                                                }
                                                if (config == null) {
                                                    config = c.inPreferredConfig;
                                                }
                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                            }
                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                stringBuilder2.append(m3032a(b2));
                                                stringBuilder2.append(" from [");
                                                stringBuilder2.append(i5);
                                                stringBuilder2.append("x");
                                                stringBuilder2.append(i8);
                                                stringBuilder2.append("] ");
                                                stringBuilder2.append(str);
                                                stringBuilder2.append(" with inBitmap ");
                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                stringBuilder2.append(" for [");
                                                stringBuilder2.append(i);
                                                stringBuilder2.append("x");
                                                stringBuilder2.append(i2);
                                                stringBuilder2.append("], sample size: ");
                                                stringBuilder2.append(c.inSampleSize);
                                                stringBuilder2.append(", density: ");
                                                stringBuilder2.append(c.inDensity);
                                                stringBuilder2.append(", target density: ");
                                                stringBuilder2.append(c.inTargetDensity);
                                                stringBuilder2.append(", thread: ");
                                                stringBuilder2.append(Thread.currentThread().getName());
                                                stringBuilder2.append(", duration: ");
                                                stringBuilder2.append(LogTime.m3212a(j));
                                                Log.v("Downsampler", stringBuilder2.toString());
                                            }
                                            if (b2 == null) {
                                                bitmap = null;
                                            } else {
                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                if (b2.equals(bitmap)) {
                                                    downsampler.f3533i.mo940a(b2);
                                                }
                                            }
                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                            m3037b(c);
                                            downsampler.f3535k.mo950a(obj5);
                                            return a;
                                        }
                                        imageType = a5;
                                        downsampleStrategy = downsampleStrategy2;
                                        i3 = i11;
                                        i4 = i10;
                                        inputStream4 = inputStream;
                                        a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                        if (VERSION.SDK_INT < 19) {
                                            a10 = m3031a(a9);
                                            i13 = a4;
                                            a4 = (int) ((((double) a10) * a9) + 0.5d);
                                            i14 = i9;
                                            c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                            c.inDensity = m3031a(a9);
                                        } else {
                                            i14 = i9;
                                            i13 = a4;
                                        }
                                        if (m3034a(c)) {
                                            c.inScaled = true;
                                        } else {
                                            c.inTargetDensity = 0;
                                            c.inDensity = 0;
                                        }
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                            stringBuilder3.append(i5);
                                            stringBuilder3.append("x");
                                            stringBuilder3.append(i8);
                                            stringBuilder3.append("], target: [");
                                            stringBuilder3.append(i3);
                                            stringBuilder3.append("x");
                                            stringBuilder3.append(b);
                                            stringBuilder3.append("], power of two scaled: [");
                                            stringBuilder3.append(i14);
                                            stringBuilder3.append("x");
                                            stringBuilder3.append(i4);
                                            stringBuilder3.append("], exact scale factor: ");
                                            stringBuilder3.append(a6);
                                            stringBuilder3.append(", power of 2 sample size: ");
                                            stringBuilder3.append(i13);
                                            stringBuilder3.append(", adjusted scale factor: ");
                                            stringBuilder3.append(a9);
                                            stringBuilder3.append(", target density: ");
                                            stringBuilder3.append(c.inTargetDensity);
                                            stringBuilder3.append(", density: ");
                                            stringBuilder3.append(c.inDensity);
                                            Log.v("Downsampler", stringBuilder3.toString());
                                        }
                                        obj2 = imageType;
                                        hardwareConfigState = this.f3537m;
                                        if (i7 != 0) {
                                            if (VERSION.SDK_INT >= 26) {
                                                decodeFormat3 = decodeFormat2;
                                                if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                    if (!z) {
                                                        if (i3 >= 128) {
                                                        }
                                                        if (obj3 == null) {
                                                            c.inPreferredConfig = Config.HARDWARE;
                                                            c.inMutable = false;
                                                        }
                                                        if (obj3 == null) {
                                                            inputStream3 = inputStream;
                                                        } else if (VERSION.SDK_INT == 16) {
                                                            inputStream3 = inputStream;
                                                            c.inPreferredConfig = Config.ARGB_8888;
                                                        } else {
                                                            inputStream3 = inputStream;
                                                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                            if (z2) {
                                                            }
                                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                                c.inDither = true;
                                                            }
                                                        }
                                                        if (VERSION.SDK_INT < 19) {
                                                        }
                                                        booleanValue = true;
                                                        if (VERSION.SDK_INT >= 19) {
                                                            booleanValue = f3531g.contains(obj2);
                                                        }
                                                        if (booleanValue) {
                                                            if (i5 >= 0) {
                                                            }
                                                            if (m3034a(c)) {
                                                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                            }
                                                            f2 = f;
                                                            i3 = c.inSampleSize;
                                                            f3 = (float) i3;
                                                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                            b = (int) Math.ceil((double) (((float) i8) / f3));
                                                            i4 = Math.round(((float) i4) * f2);
                                                            b = Math.round(((float) b) * f2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder4 = new StringBuilder("Calculated target [");
                                                                stringBuilder4.append(i4);
                                                                stringBuilder4.append("x");
                                                                stringBuilder4.append(b);
                                                                stringBuilder4.append("] for source [");
                                                                stringBuilder4.append(i5);
                                                                stringBuilder4.append("x");
                                                                stringBuilder4.append(i8);
                                                                stringBuilder4.append("], sampleSize: ");
                                                                stringBuilder4.append(i3);
                                                                stringBuilder4.append(", targetDensity: ");
                                                                stringBuilder4.append(c.inTargetDensity);
                                                                stringBuilder4.append(", density: ");
                                                                stringBuilder4.append(c.inDensity);
                                                                stringBuilder4.append(", density multiplier: ");
                                                                stringBuilder4.append(f2);
                                                                Log.v("Downsampler", stringBuilder4.toString());
                                                            }
                                                            i3 = i4;
                                                            bitmapPool = downsampler.f3533i;
                                                            if (VERSION.SDK_INT >= 26) {
                                                                config = null;
                                                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                config = c.outConfig;
                                                            }
                                                            if (config == null) {
                                                                config = c.inPreferredConfig;
                                                            }
                                                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                        }
                                                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder2 = new StringBuilder("Decoded ");
                                                            stringBuilder2.append(m3032a(b2));
                                                            stringBuilder2.append(" from [");
                                                            stringBuilder2.append(i5);
                                                            stringBuilder2.append("x");
                                                            stringBuilder2.append(i8);
                                                            stringBuilder2.append("] ");
                                                            stringBuilder2.append(str);
                                                            stringBuilder2.append(" with inBitmap ");
                                                            stringBuilder2.append(m3032a(c.inBitmap));
                                                            stringBuilder2.append(" for [");
                                                            stringBuilder2.append(i);
                                                            stringBuilder2.append("x");
                                                            stringBuilder2.append(i2);
                                                            stringBuilder2.append("], sample size: ");
                                                            stringBuilder2.append(c.inSampleSize);
                                                            stringBuilder2.append(", density: ");
                                                            stringBuilder2.append(c.inDensity);
                                                            stringBuilder2.append(", target density: ");
                                                            stringBuilder2.append(c.inTargetDensity);
                                                            stringBuilder2.append(", thread: ");
                                                            stringBuilder2.append(Thread.currentThread().getName());
                                                            stringBuilder2.append(", duration: ");
                                                            stringBuilder2.append(LogTime.m3212a(j));
                                                            Log.v("Downsampler", stringBuilder2.toString());
                                                        }
                                                        if (b2 == null) {
                                                            b2.setDensity(downsampler.f3534j.densityDpi);
                                                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                            if (b2.equals(bitmap)) {
                                                                downsampler.f3533i.mo940a(b2);
                                                            }
                                                        } else {
                                                            bitmap = null;
                                                        }
                                                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                        m3037b(c);
                                                        downsampler.f3535k.mo950a(obj5);
                                                        return a;
                                                    }
                                                }
                                                obj3 = null;
                                                if (obj3 == null) {
                                                    inputStream3 = inputStream;
                                                } else if (VERSION.SDK_INT == 16) {
                                                    inputStream3 = inputStream;
                                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                    if (z2) {
                                                    }
                                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                    if (c.inPreferredConfig == Config.RGB_565) {
                                                        c.inDither = true;
                                                    }
                                                } else {
                                                    inputStream3 = inputStream;
                                                    c.inPreferredConfig = Config.ARGB_8888;
                                                }
                                                if (VERSION.SDK_INT < 19) {
                                                }
                                                booleanValue = true;
                                                if (VERSION.SDK_INT >= 19) {
                                                    booleanValue = f3531g.contains(obj2);
                                                }
                                                if (booleanValue) {
                                                    if (i5 >= 0) {
                                                    }
                                                    if (m3034a(c)) {
                                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                    }
                                                    f2 = f;
                                                    i3 = c.inSampleSize;
                                                    f3 = (float) i3;
                                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                                    i4 = Math.round(((float) i4) * f2);
                                                    b = Math.round(((float) b) * f2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                                        stringBuilder4.append(i4);
                                                        stringBuilder4.append("x");
                                                        stringBuilder4.append(b);
                                                        stringBuilder4.append("] for source [");
                                                        stringBuilder4.append(i5);
                                                        stringBuilder4.append("x");
                                                        stringBuilder4.append(i8);
                                                        stringBuilder4.append("], sampleSize: ");
                                                        stringBuilder4.append(i3);
                                                        stringBuilder4.append(", targetDensity: ");
                                                        stringBuilder4.append(c.inTargetDensity);
                                                        stringBuilder4.append(", density: ");
                                                        stringBuilder4.append(c.inDensity);
                                                        stringBuilder4.append(", density multiplier: ");
                                                        stringBuilder4.append(f2);
                                                        Log.v("Downsampler", stringBuilder4.toString());
                                                    }
                                                    i3 = i4;
                                                    bitmapPool = downsampler.f3533i;
                                                    if (VERSION.SDK_INT >= 26) {
                                                        config = null;
                                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                        config = c.outConfig;
                                                    }
                                                    if (config == null) {
                                                        config = c.inPreferredConfig;
                                                    }
                                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                }
                                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder2 = new StringBuilder("Decoded ");
                                                    stringBuilder2.append(m3032a(b2));
                                                    stringBuilder2.append(" from [");
                                                    stringBuilder2.append(i5);
                                                    stringBuilder2.append("x");
                                                    stringBuilder2.append(i8);
                                                    stringBuilder2.append("] ");
                                                    stringBuilder2.append(str);
                                                    stringBuilder2.append(" with inBitmap ");
                                                    stringBuilder2.append(m3032a(c.inBitmap));
                                                    stringBuilder2.append(" for [");
                                                    stringBuilder2.append(i);
                                                    stringBuilder2.append("x");
                                                    stringBuilder2.append(i2);
                                                    stringBuilder2.append("], sample size: ");
                                                    stringBuilder2.append(c.inSampleSize);
                                                    stringBuilder2.append(", density: ");
                                                    stringBuilder2.append(c.inDensity);
                                                    stringBuilder2.append(", target density: ");
                                                    stringBuilder2.append(c.inTargetDensity);
                                                    stringBuilder2.append(", thread: ");
                                                    stringBuilder2.append(Thread.currentThread().getName());
                                                    stringBuilder2.append(", duration: ");
                                                    stringBuilder2.append(LogTime.m3212a(j));
                                                    Log.v("Downsampler", stringBuilder2.toString());
                                                }
                                                if (b2 == null) {
                                                    bitmap = null;
                                                } else {
                                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                    if (b2.equals(bitmap)) {
                                                        downsampler.f3533i.mo940a(b2);
                                                    }
                                                }
                                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                m3037b(c);
                                                downsampler.f3535k.mo950a(obj5);
                                                return a;
                                            }
                                        }
                                        decodeFormat3 = decodeFormat2;
                                        obj3 = null;
                                        if (obj3 == null) {
                                            inputStream3 = inputStream;
                                        } else if (VERSION.SDK_INT == 16) {
                                            inputStream3 = inputStream;
                                            c.inPreferredConfig = Config.ARGB_8888;
                                        } else {
                                            inputStream3 = inputStream;
                                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                            if (z2) {
                                            }
                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                c.inDither = true;
                                            }
                                        }
                                        if (VERSION.SDK_INT < 19) {
                                        }
                                        booleanValue = true;
                                        if (VERSION.SDK_INT >= 19) {
                                            booleanValue = f3531g.contains(obj2);
                                        }
                                        if (booleanValue) {
                                            if (i5 >= 0) {
                                            }
                                            if (m3034a(c)) {
                                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                            }
                                            f2 = f;
                                            i3 = c.inSampleSize;
                                            f3 = (float) i3;
                                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                            b = (int) Math.ceil((double) (((float) i8) / f3));
                                            i4 = Math.round(((float) i4) * f2);
                                            b = Math.round(((float) b) * f2);
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder4 = new StringBuilder("Calculated target [");
                                                stringBuilder4.append(i4);
                                                stringBuilder4.append("x");
                                                stringBuilder4.append(b);
                                                stringBuilder4.append("] for source [");
                                                stringBuilder4.append(i5);
                                                stringBuilder4.append("x");
                                                stringBuilder4.append(i8);
                                                stringBuilder4.append("], sampleSize: ");
                                                stringBuilder4.append(i3);
                                                stringBuilder4.append(", targetDensity: ");
                                                stringBuilder4.append(c.inTargetDensity);
                                                stringBuilder4.append(", density: ");
                                                stringBuilder4.append(c.inDensity);
                                                stringBuilder4.append(", density multiplier: ");
                                                stringBuilder4.append(f2);
                                                Log.v("Downsampler", stringBuilder4.toString());
                                            }
                                            i3 = i4;
                                            bitmapPool = downsampler.f3533i;
                                            if (VERSION.SDK_INT >= 26) {
                                                config = null;
                                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                config = c.outConfig;
                                            }
                                            if (config == null) {
                                                config = c.inPreferredConfig;
                                            }
                                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                        }
                                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            stringBuilder2 = new StringBuilder("Decoded ");
                                            stringBuilder2.append(m3032a(b2));
                                            stringBuilder2.append(" from [");
                                            stringBuilder2.append(i5);
                                            stringBuilder2.append("x");
                                            stringBuilder2.append(i8);
                                            stringBuilder2.append("] ");
                                            stringBuilder2.append(str);
                                            stringBuilder2.append(" with inBitmap ");
                                            stringBuilder2.append(m3032a(c.inBitmap));
                                            stringBuilder2.append(" for [");
                                            stringBuilder2.append(i);
                                            stringBuilder2.append("x");
                                            stringBuilder2.append(i2);
                                            stringBuilder2.append("], sample size: ");
                                            stringBuilder2.append(c.inSampleSize);
                                            stringBuilder2.append(", density: ");
                                            stringBuilder2.append(c.inDensity);
                                            stringBuilder2.append(", target density: ");
                                            stringBuilder2.append(c.inTargetDensity);
                                            stringBuilder2.append(", thread: ");
                                            stringBuilder2.append(Thread.currentThread().getName());
                                            stringBuilder2.append(", duration: ");
                                            stringBuilder2.append(LogTime.m3212a(j));
                                            Log.v("Downsampler", stringBuilder2.toString());
                                        }
                                        if (b2 == null) {
                                            b2.setDensity(downsampler.f3534j.densityDpi);
                                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                            if (b2.equals(bitmap)) {
                                                downsampler.f3533i.mo940a(b2);
                                            }
                                        } else {
                                            bitmap = null;
                                        }
                                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                        m3037b(c);
                                        downsampler.f3535k.mo950a(obj5);
                                        return a;
                                    } catch (Throwable e4) {
                                        th2 = e4;
                                        obj = obj5;
                                        downsampler = this;
                                        m3037b(c);
                                        downsampler.f3535k.mo950a(obj);
                                        throw th2;
                                    }
                                } catch (Throwable e42) {
                                    th2 = e42;
                                    obj = obj5;
                                    m3037b(c);
                                    downsampler.f3535k.mo950a(obj);
                                    throw th2;
                                }
                            }
                        }
                        a6 = downsampleStrategy.mo990a(i8, i5, i3, b);
                        if (a6 > 0.0f) {
                            a7 = downsampleStrategy.mo991a();
                            if (a7 != null) {
                                z = b3;
                                f4 = (float) i5;
                                decodeFormat2 = decodeFormat;
                                downsampleStrategy2 = downsampleStrategy;
                                f5 = (float) i8;
                                i9 = i5 / ((int) (((double) (a6 * f4)) + 0.5d));
                                i10 = i8 / ((int) (((double) (a6 * f5)) + 0.5d));
                                if (a7 != SampleSizeRounding.MEMORY) {
                                    i10 = Math.min(i9, i10);
                                } else {
                                    i10 = Math.max(i9, i10);
                                }
                                if (VERSION.SDK_INT <= 23) {
                                }
                                i10 = Math.max(1, Integer.highestOneBit(i10));
                                if (a7 == SampleSizeRounding.MEMORY) {
                                }
                                c.inSampleSize = a4;
                                if (a5 != ImageType.JPEG) {
                                    i11 = i3;
                                    if (a5 != ImageType.PNG) {
                                        if (a5 == ImageType.PNG_A) {
                                            if (a5 != ImageType.WEBP) {
                                                if (a5 == ImageType.WEBP_A) {
                                                    if (i5 % a4 == 0) {
                                                        if (i8 % a4 != 0) {
                                                            i9 = i5 / a4;
                                                            i10 = i8 / a4;
                                                        }
                                                    }
                                                    a8 = m3035a(inputStream, c, decodeCallbacks2, bitmapPool2);
                                                    i12 = a8[0];
                                                    imageType = a5;
                                                    downsampleStrategy = downsampleStrategy2;
                                                    i3 = i11;
                                                    i4 = a8[1];
                                                    i9 = i12;
                                                    a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                                    if (VERSION.SDK_INT < 19) {
                                                        i14 = i9;
                                                        i13 = a4;
                                                    } else {
                                                        a10 = m3031a(a9);
                                                        i13 = a4;
                                                        a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                        i14 = i9;
                                                        c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                        c.inDensity = m3031a(a9);
                                                    }
                                                    if (m3034a(c)) {
                                                        c.inTargetDensity = 0;
                                                        c.inDensity = 0;
                                                    } else {
                                                        c.inScaled = true;
                                                    }
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                        stringBuilder3.append(i5);
                                                        stringBuilder3.append("x");
                                                        stringBuilder3.append(i8);
                                                        stringBuilder3.append("], target: [");
                                                        stringBuilder3.append(i3);
                                                        stringBuilder3.append("x");
                                                        stringBuilder3.append(b);
                                                        stringBuilder3.append("], power of two scaled: [");
                                                        stringBuilder3.append(i14);
                                                        stringBuilder3.append("x");
                                                        stringBuilder3.append(i4);
                                                        stringBuilder3.append("], exact scale factor: ");
                                                        stringBuilder3.append(a6);
                                                        stringBuilder3.append(", power of 2 sample size: ");
                                                        stringBuilder3.append(i13);
                                                        stringBuilder3.append(", adjusted scale factor: ");
                                                        stringBuilder3.append(a9);
                                                        stringBuilder3.append(", target density: ");
                                                        stringBuilder3.append(c.inTargetDensity);
                                                        stringBuilder3.append(", density: ");
                                                        stringBuilder3.append(c.inDensity);
                                                        Log.v("Downsampler", stringBuilder3.toString());
                                                    }
                                                    obj2 = imageType;
                                                    hardwareConfigState = this.f3537m;
                                                    if (i7 != 0) {
                                                        if (VERSION.SDK_INT >= 26) {
                                                            decodeFormat3 = decodeFormat2;
                                                            if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                                if (!z) {
                                                                    if (i3 >= 128) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                        c.inPreferredConfig = Config.HARDWARE;
                                                                        c.inMutable = false;
                                                                    }
                                                                    if (obj3 == null) {
                                                                        inputStream3 = inputStream;
                                                                    } else if (VERSION.SDK_INT == 16) {
                                                                        inputStream3 = inputStream;
                                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                        if (z2) {
                                                                        }
                                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                                            c.inDither = true;
                                                                        }
                                                                    } else {
                                                                        inputStream3 = inputStream;
                                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                                    }
                                                                    if (VERSION.SDK_INT < 19) {
                                                                    }
                                                                    booleanValue = true;
                                                                    if (VERSION.SDK_INT >= 19) {
                                                                        booleanValue = f3531g.contains(obj2);
                                                                    }
                                                                    if (booleanValue) {
                                                                        if (i5 >= 0) {
                                                                        }
                                                                        if (m3034a(c)) {
                                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                        }
                                                                        f2 = f;
                                                                        i3 = c.inSampleSize;
                                                                        f3 = (float) i3;
                                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                        i4 = Math.round(((float) i4) * f2);
                                                                        b = Math.round(((float) b) * f2);
                                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                                            stringBuilder4.append(i4);
                                                                            stringBuilder4.append("x");
                                                                            stringBuilder4.append(b);
                                                                            stringBuilder4.append("] for source [");
                                                                            stringBuilder4.append(i5);
                                                                            stringBuilder4.append("x");
                                                                            stringBuilder4.append(i8);
                                                                            stringBuilder4.append("], sampleSize: ");
                                                                            stringBuilder4.append(i3);
                                                                            stringBuilder4.append(", targetDensity: ");
                                                                            stringBuilder4.append(c.inTargetDensity);
                                                                            stringBuilder4.append(", density: ");
                                                                            stringBuilder4.append(c.inDensity);
                                                                            stringBuilder4.append(", density multiplier: ");
                                                                            stringBuilder4.append(f2);
                                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                                        }
                                                                        i3 = i4;
                                                                        bitmapPool = downsampler.f3533i;
                                                                        if (VERSION.SDK_INT >= 26) {
                                                                            config = null;
                                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                            config = c.outConfig;
                                                                        }
                                                                        if (config == null) {
                                                                            config = c.inPreferredConfig;
                                                                        }
                                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                    }
                                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                                        stringBuilder2.append(m3032a(b2));
                                                                        stringBuilder2.append(" from [");
                                                                        stringBuilder2.append(i5);
                                                                        stringBuilder2.append("x");
                                                                        stringBuilder2.append(i8);
                                                                        stringBuilder2.append("] ");
                                                                        stringBuilder2.append(str);
                                                                        stringBuilder2.append(" with inBitmap ");
                                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                                        stringBuilder2.append(" for [");
                                                                        stringBuilder2.append(i);
                                                                        stringBuilder2.append("x");
                                                                        stringBuilder2.append(i2);
                                                                        stringBuilder2.append("], sample size: ");
                                                                        stringBuilder2.append(c.inSampleSize);
                                                                        stringBuilder2.append(", density: ");
                                                                        stringBuilder2.append(c.inDensity);
                                                                        stringBuilder2.append(", target density: ");
                                                                        stringBuilder2.append(c.inTargetDensity);
                                                                        stringBuilder2.append(", thread: ");
                                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                                        stringBuilder2.append(", duration: ");
                                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                                    }
                                                                    if (b2 == null) {
                                                                        bitmap = null;
                                                                    } else {
                                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                        if (b2.equals(bitmap)) {
                                                                            downsampler.f3533i.mo940a(b2);
                                                                        }
                                                                    }
                                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                    m3037b(c);
                                                                    downsampler.f3535k.mo950a(obj5);
                                                                    return a;
                                                                }
                                                            }
                                                            obj3 = null;
                                                            if (obj3 == null) {
                                                                inputStream3 = inputStream;
                                                            } else if (VERSION.SDK_INT == 16) {
                                                                inputStream3 = inputStream;
                                                                c.inPreferredConfig = Config.ARGB_8888;
                                                            } else {
                                                                inputStream3 = inputStream;
                                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                if (z2) {
                                                                }
                                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                                    c.inDither = true;
                                                                }
                                                            }
                                                            if (VERSION.SDK_INT < 19) {
                                                            }
                                                            booleanValue = true;
                                                            if (VERSION.SDK_INT >= 19) {
                                                                booleanValue = f3531g.contains(obj2);
                                                            }
                                                            if (booleanValue) {
                                                                if (i5 >= 0) {
                                                                }
                                                                if (m3034a(c)) {
                                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                }
                                                                f2 = f;
                                                                i3 = c.inSampleSize;
                                                                f3 = (float) i3;
                                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                i4 = Math.round(((float) i4) * f2);
                                                                b = Math.round(((float) b) * f2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                                    stringBuilder4.append(i4);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(b);
                                                                    stringBuilder4.append("] for source [");
                                                                    stringBuilder4.append(i5);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(i8);
                                                                    stringBuilder4.append("], sampleSize: ");
                                                                    stringBuilder4.append(i3);
                                                                    stringBuilder4.append(", targetDensity: ");
                                                                    stringBuilder4.append(c.inTargetDensity);
                                                                    stringBuilder4.append(", density: ");
                                                                    stringBuilder4.append(c.inDensity);
                                                                    stringBuilder4.append(", density multiplier: ");
                                                                    stringBuilder4.append(f2);
                                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                                }
                                                                i3 = i4;
                                                                bitmapPool = downsampler.f3533i;
                                                                if (VERSION.SDK_INT >= 26) {
                                                                    config = null;
                                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                    config = c.outConfig;
                                                                }
                                                                if (config == null) {
                                                                    config = c.inPreferredConfig;
                                                                }
                                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                            }
                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                stringBuilder2.append(m3032a(b2));
                                                                stringBuilder2.append(" from [");
                                                                stringBuilder2.append(i5);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i8);
                                                                stringBuilder2.append("] ");
                                                                stringBuilder2.append(str);
                                                                stringBuilder2.append(" with inBitmap ");
                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                stringBuilder2.append(" for [");
                                                                stringBuilder2.append(i);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i2);
                                                                stringBuilder2.append("], sample size: ");
                                                                stringBuilder2.append(c.inSampleSize);
                                                                stringBuilder2.append(", density: ");
                                                                stringBuilder2.append(c.inDensity);
                                                                stringBuilder2.append(", target density: ");
                                                                stringBuilder2.append(c.inTargetDensity);
                                                                stringBuilder2.append(", thread: ");
                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                stringBuilder2.append(", duration: ");
                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                            }
                                                            if (b2 == null) {
                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                if (b2.equals(bitmap)) {
                                                                    downsampler.f3533i.mo940a(b2);
                                                                }
                                                            } else {
                                                                bitmap = null;
                                                            }
                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                            m3037b(c);
                                                            downsampler.f3535k.mo950a(obj5);
                                                            return a;
                                                        }
                                                    }
                                                    decodeFormat3 = decodeFormat2;
                                                    obj3 = null;
                                                    if (obj3 == null) {
                                                        inputStream3 = inputStream;
                                                    } else if (VERSION.SDK_INT == 16) {
                                                        inputStream3 = inputStream;
                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                        if (z2) {
                                                        }
                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                            c.inDither = true;
                                                        }
                                                    } else {
                                                        inputStream3 = inputStream;
                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                    }
                                                    if (VERSION.SDK_INT < 19) {
                                                    }
                                                    booleanValue = true;
                                                    if (VERSION.SDK_INT >= 19) {
                                                        booleanValue = f3531g.contains(obj2);
                                                    }
                                                    if (booleanValue) {
                                                        if (i5 >= 0) {
                                                        }
                                                        if (m3034a(c)) {
                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                        }
                                                        f2 = f;
                                                        i3 = c.inSampleSize;
                                                        f3 = (float) i3;
                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                        i4 = Math.round(((float) i4) * f2);
                                                        b = Math.round(((float) b) * f2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                            stringBuilder4.append(i4);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(b);
                                                            stringBuilder4.append("] for source [");
                                                            stringBuilder4.append(i5);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(i8);
                                                            stringBuilder4.append("], sampleSize: ");
                                                            stringBuilder4.append(i3);
                                                            stringBuilder4.append(", targetDensity: ");
                                                            stringBuilder4.append(c.inTargetDensity);
                                                            stringBuilder4.append(", density: ");
                                                            stringBuilder4.append(c.inDensity);
                                                            stringBuilder4.append(", density multiplier: ");
                                                            stringBuilder4.append(f2);
                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                        }
                                                        i3 = i4;
                                                        bitmapPool = downsampler.f3533i;
                                                        if (VERSION.SDK_INT >= 26) {
                                                            config = null;
                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                            config = c.outConfig;
                                                        }
                                                        if (config == null) {
                                                            config = c.inPreferredConfig;
                                                        }
                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                    }
                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                        stringBuilder2.append(m3032a(b2));
                                                        stringBuilder2.append(" from [");
                                                        stringBuilder2.append(i5);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i8);
                                                        stringBuilder2.append("] ");
                                                        stringBuilder2.append(str);
                                                        stringBuilder2.append(" with inBitmap ");
                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                        stringBuilder2.append(" for [");
                                                        stringBuilder2.append(i);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i2);
                                                        stringBuilder2.append("], sample size: ");
                                                        stringBuilder2.append(c.inSampleSize);
                                                        stringBuilder2.append(", density: ");
                                                        stringBuilder2.append(c.inDensity);
                                                        stringBuilder2.append(", target density: ");
                                                        stringBuilder2.append(c.inTargetDensity);
                                                        stringBuilder2.append(", thread: ");
                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                        stringBuilder2.append(", duration: ");
                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                    }
                                                    if (b2 == null) {
                                                        bitmap = null;
                                                    } else {
                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                        if (b2.equals(bitmap)) {
                                                            downsampler.f3533i.mo940a(b2);
                                                        }
                                                    }
                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                    m3037b(c);
                                                    downsampler.f3535k.mo950a(obj5);
                                                    return a;
                                                }
                                            }
                                            inputStream4 = inputStream;
                                            if (VERSION.SDK_INT < 24) {
                                                f2 = (float) a4;
                                                imageType = a5;
                                                i3 = (int) Math.floor((double) (f4 / f2));
                                                i9 = (int) Math.floor((double) (f5 / f2));
                                                i4 = i9;
                                                i9 = i3;
                                                downsampleStrategy = downsampleStrategy2;
                                                i3 = i11;
                                                a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                                if (VERSION.SDK_INT < 19) {
                                                    a10 = m3031a(a9);
                                                    i13 = a4;
                                                    a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                    i14 = i9;
                                                    c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                    c.inDensity = m3031a(a9);
                                                } else {
                                                    i14 = i9;
                                                    i13 = a4;
                                                }
                                                if (m3034a(c)) {
                                                    c.inScaled = true;
                                                } else {
                                                    c.inTargetDensity = 0;
                                                    c.inDensity = 0;
                                                }
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                    stringBuilder3.append(i5);
                                                    stringBuilder3.append("x");
                                                    stringBuilder3.append(i8);
                                                    stringBuilder3.append("], target: [");
                                                    stringBuilder3.append(i3);
                                                    stringBuilder3.append("x");
                                                    stringBuilder3.append(b);
                                                    stringBuilder3.append("], power of two scaled: [");
                                                    stringBuilder3.append(i14);
                                                    stringBuilder3.append("x");
                                                    stringBuilder3.append(i4);
                                                    stringBuilder3.append("], exact scale factor: ");
                                                    stringBuilder3.append(a6);
                                                    stringBuilder3.append(", power of 2 sample size: ");
                                                    stringBuilder3.append(i13);
                                                    stringBuilder3.append(", adjusted scale factor: ");
                                                    stringBuilder3.append(a9);
                                                    stringBuilder3.append(", target density: ");
                                                    stringBuilder3.append(c.inTargetDensity);
                                                    stringBuilder3.append(", density: ");
                                                    stringBuilder3.append(c.inDensity);
                                                    Log.v("Downsampler", stringBuilder3.toString());
                                                }
                                                obj2 = imageType;
                                                hardwareConfigState = this.f3537m;
                                                if (i7 != 0) {
                                                    if (VERSION.SDK_INT >= 26) {
                                                        decodeFormat3 = decodeFormat2;
                                                        if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                            if (!z) {
                                                                if (i3 >= 128) {
                                                                }
                                                                if (obj3 == null) {
                                                                    c.inPreferredConfig = Config.HARDWARE;
                                                                    c.inMutable = false;
                                                                }
                                                                if (obj3 == null) {
                                                                    inputStream3 = inputStream;
                                                                } else if (VERSION.SDK_INT == 16) {
                                                                    inputStream3 = inputStream;
                                                                    c.inPreferredConfig = Config.ARGB_8888;
                                                                } else {
                                                                    inputStream3 = inputStream;
                                                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                    if (z2) {
                                                                    }
                                                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                    if (c.inPreferredConfig == Config.RGB_565) {
                                                                        c.inDither = true;
                                                                    }
                                                                }
                                                                if (VERSION.SDK_INT < 19) {
                                                                }
                                                                booleanValue = true;
                                                                if (VERSION.SDK_INT >= 19) {
                                                                    booleanValue = f3531g.contains(obj2);
                                                                }
                                                                if (booleanValue) {
                                                                    if (i5 >= 0) {
                                                                    }
                                                                    if (m3034a(c)) {
                                                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                    }
                                                                    f2 = f;
                                                                    i3 = c.inSampleSize;
                                                                    f3 = (float) i3;
                                                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                    i4 = Math.round(((float) i4) * f2);
                                                                    b = Math.round(((float) b) * f2);
                                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                                                        stringBuilder4.append(i4);
                                                                        stringBuilder4.append("x");
                                                                        stringBuilder4.append(b);
                                                                        stringBuilder4.append("] for source [");
                                                                        stringBuilder4.append(i5);
                                                                        stringBuilder4.append("x");
                                                                        stringBuilder4.append(i8);
                                                                        stringBuilder4.append("], sampleSize: ");
                                                                        stringBuilder4.append(i3);
                                                                        stringBuilder4.append(", targetDensity: ");
                                                                        stringBuilder4.append(c.inTargetDensity);
                                                                        stringBuilder4.append(", density: ");
                                                                        stringBuilder4.append(c.inDensity);
                                                                        stringBuilder4.append(", density multiplier: ");
                                                                        stringBuilder4.append(f2);
                                                                        Log.v("Downsampler", stringBuilder4.toString());
                                                                    }
                                                                    i3 = i4;
                                                                    bitmapPool = downsampler.f3533i;
                                                                    if (VERSION.SDK_INT >= 26) {
                                                                        config = null;
                                                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                        config = c.outConfig;
                                                                    }
                                                                    if (config == null) {
                                                                        config = c.inPreferredConfig;
                                                                    }
                                                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                                }
                                                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder2 = new StringBuilder("Decoded ");
                                                                    stringBuilder2.append(m3032a(b2));
                                                                    stringBuilder2.append(" from [");
                                                                    stringBuilder2.append(i5);
                                                                    stringBuilder2.append("x");
                                                                    stringBuilder2.append(i8);
                                                                    stringBuilder2.append("] ");
                                                                    stringBuilder2.append(str);
                                                                    stringBuilder2.append(" with inBitmap ");
                                                                    stringBuilder2.append(m3032a(c.inBitmap));
                                                                    stringBuilder2.append(" for [");
                                                                    stringBuilder2.append(i);
                                                                    stringBuilder2.append("x");
                                                                    stringBuilder2.append(i2);
                                                                    stringBuilder2.append("], sample size: ");
                                                                    stringBuilder2.append(c.inSampleSize);
                                                                    stringBuilder2.append(", density: ");
                                                                    stringBuilder2.append(c.inDensity);
                                                                    stringBuilder2.append(", target density: ");
                                                                    stringBuilder2.append(c.inTargetDensity);
                                                                    stringBuilder2.append(", thread: ");
                                                                    stringBuilder2.append(Thread.currentThread().getName());
                                                                    stringBuilder2.append(", duration: ");
                                                                    stringBuilder2.append(LogTime.m3212a(j));
                                                                    Log.v("Downsampler", stringBuilder2.toString());
                                                                }
                                                                if (b2 == null) {
                                                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                    if (b2.equals(bitmap)) {
                                                                        downsampler.f3533i.mo940a(b2);
                                                                    }
                                                                } else {
                                                                    bitmap = null;
                                                                }
                                                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                                m3037b(c);
                                                                downsampler.f3535k.mo950a(obj5);
                                                                return a;
                                                            }
                                                        }
                                                        obj3 = null;
                                                        if (obj3 == null) {
                                                            inputStream3 = inputStream;
                                                        } else if (VERSION.SDK_INT == 16) {
                                                            inputStream3 = inputStream;
                                                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                            if (z2) {
                                                            }
                                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                                c.inDither = true;
                                                            }
                                                        } else {
                                                            inputStream3 = inputStream;
                                                            c.inPreferredConfig = Config.ARGB_8888;
                                                        }
                                                        if (VERSION.SDK_INT < 19) {
                                                        }
                                                        booleanValue = true;
                                                        if (VERSION.SDK_INT >= 19) {
                                                            booleanValue = f3531g.contains(obj2);
                                                        }
                                                        if (booleanValue) {
                                                            if (i5 >= 0) {
                                                            }
                                                            if (m3034a(c)) {
                                                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                            }
                                                            f2 = f;
                                                            i3 = c.inSampleSize;
                                                            f3 = (float) i3;
                                                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                            b = (int) Math.ceil((double) (((float) i8) / f3));
                                                            i4 = Math.round(((float) i4) * f2);
                                                            b = Math.round(((float) b) * f2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder4 = new StringBuilder("Calculated target [");
                                                                stringBuilder4.append(i4);
                                                                stringBuilder4.append("x");
                                                                stringBuilder4.append(b);
                                                                stringBuilder4.append("] for source [");
                                                                stringBuilder4.append(i5);
                                                                stringBuilder4.append("x");
                                                                stringBuilder4.append(i8);
                                                                stringBuilder4.append("], sampleSize: ");
                                                                stringBuilder4.append(i3);
                                                                stringBuilder4.append(", targetDensity: ");
                                                                stringBuilder4.append(c.inTargetDensity);
                                                                stringBuilder4.append(", density: ");
                                                                stringBuilder4.append(c.inDensity);
                                                                stringBuilder4.append(", density multiplier: ");
                                                                stringBuilder4.append(f2);
                                                                Log.v("Downsampler", stringBuilder4.toString());
                                                            }
                                                            i3 = i4;
                                                            bitmapPool = downsampler.f3533i;
                                                            if (VERSION.SDK_INT >= 26) {
                                                                config = null;
                                                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                config = c.outConfig;
                                                            }
                                                            if (config == null) {
                                                                config = c.inPreferredConfig;
                                                            }
                                                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                        }
                                                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder2 = new StringBuilder("Decoded ");
                                                            stringBuilder2.append(m3032a(b2));
                                                            stringBuilder2.append(" from [");
                                                            stringBuilder2.append(i5);
                                                            stringBuilder2.append("x");
                                                            stringBuilder2.append(i8);
                                                            stringBuilder2.append("] ");
                                                            stringBuilder2.append(str);
                                                            stringBuilder2.append(" with inBitmap ");
                                                            stringBuilder2.append(m3032a(c.inBitmap));
                                                            stringBuilder2.append(" for [");
                                                            stringBuilder2.append(i);
                                                            stringBuilder2.append("x");
                                                            stringBuilder2.append(i2);
                                                            stringBuilder2.append("], sample size: ");
                                                            stringBuilder2.append(c.inSampleSize);
                                                            stringBuilder2.append(", density: ");
                                                            stringBuilder2.append(c.inDensity);
                                                            stringBuilder2.append(", target density: ");
                                                            stringBuilder2.append(c.inTargetDensity);
                                                            stringBuilder2.append(", thread: ");
                                                            stringBuilder2.append(Thread.currentThread().getName());
                                                            stringBuilder2.append(", duration: ");
                                                            stringBuilder2.append(LogTime.m3212a(j));
                                                            Log.v("Downsampler", stringBuilder2.toString());
                                                        }
                                                        if (b2 == null) {
                                                            bitmap = null;
                                                        } else {
                                                            b2.setDensity(downsampler.f3534j.densityDpi);
                                                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                            if (b2.equals(bitmap)) {
                                                                downsampler.f3533i.mo940a(b2);
                                                            }
                                                        }
                                                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                        m3037b(c);
                                                        downsampler.f3535k.mo950a(obj5);
                                                        return a;
                                                    }
                                                }
                                                decodeFormat3 = decodeFormat2;
                                                obj3 = null;
                                                if (obj3 == null) {
                                                    inputStream3 = inputStream;
                                                } else if (VERSION.SDK_INT == 16) {
                                                    inputStream3 = inputStream;
                                                    c.inPreferredConfig = Config.ARGB_8888;
                                                } else {
                                                    inputStream3 = inputStream;
                                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                    if (z2) {
                                                    }
                                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                    if (c.inPreferredConfig == Config.RGB_565) {
                                                        c.inDither = true;
                                                    }
                                                }
                                                if (VERSION.SDK_INT < 19) {
                                                }
                                                booleanValue = true;
                                                if (VERSION.SDK_INT >= 19) {
                                                    booleanValue = f3531g.contains(obj2);
                                                }
                                                if (booleanValue) {
                                                    if (i5 >= 0) {
                                                    }
                                                    if (m3034a(c)) {
                                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                    }
                                                    f2 = f;
                                                    i3 = c.inSampleSize;
                                                    f3 = (float) i3;
                                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                                    i4 = Math.round(((float) i4) * f2);
                                                    b = Math.round(((float) b) * f2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                                        stringBuilder4.append(i4);
                                                        stringBuilder4.append("x");
                                                        stringBuilder4.append(b);
                                                        stringBuilder4.append("] for source [");
                                                        stringBuilder4.append(i5);
                                                        stringBuilder4.append("x");
                                                        stringBuilder4.append(i8);
                                                        stringBuilder4.append("], sampleSize: ");
                                                        stringBuilder4.append(i3);
                                                        stringBuilder4.append(", targetDensity: ");
                                                        stringBuilder4.append(c.inTargetDensity);
                                                        stringBuilder4.append(", density: ");
                                                        stringBuilder4.append(c.inDensity);
                                                        stringBuilder4.append(", density multiplier: ");
                                                        stringBuilder4.append(f2);
                                                        Log.v("Downsampler", stringBuilder4.toString());
                                                    }
                                                    i3 = i4;
                                                    bitmapPool = downsampler.f3533i;
                                                    if (VERSION.SDK_INT >= 26) {
                                                        config = null;
                                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                        config = c.outConfig;
                                                    }
                                                    if (config == null) {
                                                        config = c.inPreferredConfig;
                                                    }
                                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                }
                                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder2 = new StringBuilder("Decoded ");
                                                    stringBuilder2.append(m3032a(b2));
                                                    stringBuilder2.append(" from [");
                                                    stringBuilder2.append(i5);
                                                    stringBuilder2.append("x");
                                                    stringBuilder2.append(i8);
                                                    stringBuilder2.append("] ");
                                                    stringBuilder2.append(str);
                                                    stringBuilder2.append(" with inBitmap ");
                                                    stringBuilder2.append(m3032a(c.inBitmap));
                                                    stringBuilder2.append(" for [");
                                                    stringBuilder2.append(i);
                                                    stringBuilder2.append("x");
                                                    stringBuilder2.append(i2);
                                                    stringBuilder2.append("], sample size: ");
                                                    stringBuilder2.append(c.inSampleSize);
                                                    stringBuilder2.append(", density: ");
                                                    stringBuilder2.append(c.inDensity);
                                                    stringBuilder2.append(", target density: ");
                                                    stringBuilder2.append(c.inTargetDensity);
                                                    stringBuilder2.append(", thread: ");
                                                    stringBuilder2.append(Thread.currentThread().getName());
                                                    stringBuilder2.append(", duration: ");
                                                    stringBuilder2.append(LogTime.m3212a(j));
                                                    Log.v("Downsampler", stringBuilder2.toString());
                                                }
                                                if (b2 == null) {
                                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                    if (b2.equals(bitmap)) {
                                                        downsampler.f3533i.mo940a(b2);
                                                    }
                                                } else {
                                                    bitmap = null;
                                                }
                                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                m3037b(c);
                                                downsampler.f3535k.mo950a(obj5);
                                                return a;
                                            }
                                            f2 = (float) a4;
                                            i3 = Math.round(f4 / f2);
                                            i9 = Math.round(f5 / f2);
                                            imageType = a5;
                                            downsampleStrategy = downsampleStrategy2;
                                            i4 = i9;
                                            i9 = i3;
                                            i3 = i11;
                                            a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                            if (VERSION.SDK_INT < 19) {
                                                i14 = i9;
                                                i13 = a4;
                                            } else {
                                                a10 = m3031a(a9);
                                                i13 = a4;
                                                a4 = (int) ((((double) a10) * a9) + 0.5d);
                                                i14 = i9;
                                                c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                                c.inDensity = m3031a(a9);
                                            }
                                            if (m3034a(c)) {
                                                c.inTargetDensity = 0;
                                                c.inDensity = 0;
                                            } else {
                                                c.inScaled = true;
                                            }
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                                stringBuilder3.append(i5);
                                                stringBuilder3.append("x");
                                                stringBuilder3.append(i8);
                                                stringBuilder3.append("], target: [");
                                                stringBuilder3.append(i3);
                                                stringBuilder3.append("x");
                                                stringBuilder3.append(b);
                                                stringBuilder3.append("], power of two scaled: [");
                                                stringBuilder3.append(i14);
                                                stringBuilder3.append("x");
                                                stringBuilder3.append(i4);
                                                stringBuilder3.append("], exact scale factor: ");
                                                stringBuilder3.append(a6);
                                                stringBuilder3.append(", power of 2 sample size: ");
                                                stringBuilder3.append(i13);
                                                stringBuilder3.append(", adjusted scale factor: ");
                                                stringBuilder3.append(a9);
                                                stringBuilder3.append(", target density: ");
                                                stringBuilder3.append(c.inTargetDensity);
                                                stringBuilder3.append(", density: ");
                                                stringBuilder3.append(c.inDensity);
                                                Log.v("Downsampler", stringBuilder3.toString());
                                            }
                                            obj2 = imageType;
                                            hardwareConfigState = this.f3537m;
                                            if (i7 != 0) {
                                                if (VERSION.SDK_INT >= 26) {
                                                    decodeFormat3 = decodeFormat2;
                                                    if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                        if (!z) {
                                                            if (i3 >= 128) {
                                                            }
                                                            if (obj3 == null) {
                                                                c.inPreferredConfig = Config.HARDWARE;
                                                                c.inMutable = false;
                                                            }
                                                            if (obj3 == null) {
                                                                inputStream3 = inputStream;
                                                            } else if (VERSION.SDK_INT == 16) {
                                                                inputStream3 = inputStream;
                                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                                if (z2) {
                                                                }
                                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                                    c.inDither = true;
                                                                }
                                                            } else {
                                                                inputStream3 = inputStream;
                                                                c.inPreferredConfig = Config.ARGB_8888;
                                                            }
                                                            if (VERSION.SDK_INT < 19) {
                                                            }
                                                            booleanValue = true;
                                                            if (VERSION.SDK_INT >= 19) {
                                                                booleanValue = f3531g.contains(obj2);
                                                            }
                                                            if (booleanValue) {
                                                                if (i5 >= 0) {
                                                                }
                                                                if (m3034a(c)) {
                                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                                }
                                                                f2 = f;
                                                                i3 = c.inSampleSize;
                                                                f3 = (float) i3;
                                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                                i4 = Math.round(((float) i4) * f2);
                                                                b = Math.round(((float) b) * f2);
                                                                if (Log.isLoggable("Downsampler", 2)) {
                                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                                    stringBuilder4.append(i4);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(b);
                                                                    stringBuilder4.append("] for source [");
                                                                    stringBuilder4.append(i5);
                                                                    stringBuilder4.append("x");
                                                                    stringBuilder4.append(i8);
                                                                    stringBuilder4.append("], sampleSize: ");
                                                                    stringBuilder4.append(i3);
                                                                    stringBuilder4.append(", targetDensity: ");
                                                                    stringBuilder4.append(c.inTargetDensity);
                                                                    stringBuilder4.append(", density: ");
                                                                    stringBuilder4.append(c.inDensity);
                                                                    stringBuilder4.append(", density multiplier: ");
                                                                    stringBuilder4.append(f2);
                                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                                }
                                                                i3 = i4;
                                                                bitmapPool = downsampler.f3533i;
                                                                if (VERSION.SDK_INT >= 26) {
                                                                    config = null;
                                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                                    config = c.outConfig;
                                                                }
                                                                if (config == null) {
                                                                    config = c.inPreferredConfig;
                                                                }
                                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                            }
                                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                            if (Log.isLoggable("Downsampler", 2)) {
                                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                                stringBuilder2.append(m3032a(b2));
                                                                stringBuilder2.append(" from [");
                                                                stringBuilder2.append(i5);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i8);
                                                                stringBuilder2.append("] ");
                                                                stringBuilder2.append(str);
                                                                stringBuilder2.append(" with inBitmap ");
                                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                                stringBuilder2.append(" for [");
                                                                stringBuilder2.append(i);
                                                                stringBuilder2.append("x");
                                                                stringBuilder2.append(i2);
                                                                stringBuilder2.append("], sample size: ");
                                                                stringBuilder2.append(c.inSampleSize);
                                                                stringBuilder2.append(", density: ");
                                                                stringBuilder2.append(c.inDensity);
                                                                stringBuilder2.append(", target density: ");
                                                                stringBuilder2.append(c.inTargetDensity);
                                                                stringBuilder2.append(", thread: ");
                                                                stringBuilder2.append(Thread.currentThread().getName());
                                                                stringBuilder2.append(", duration: ");
                                                                stringBuilder2.append(LogTime.m3212a(j));
                                                                Log.v("Downsampler", stringBuilder2.toString());
                                                            }
                                                            if (b2 == null) {
                                                                bitmap = null;
                                                            } else {
                                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                                if (b2.equals(bitmap)) {
                                                                    downsampler.f3533i.mo940a(b2);
                                                                }
                                                            }
                                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                            m3037b(c);
                                                            downsampler.f3535k.mo950a(obj5);
                                                            return a;
                                                        }
                                                    }
                                                    obj3 = null;
                                                    if (obj3 == null) {
                                                        inputStream3 = inputStream;
                                                    } else if (VERSION.SDK_INT == 16) {
                                                        inputStream3 = inputStream;
                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                    } else {
                                                        inputStream3 = inputStream;
                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                        if (z2) {
                                                        }
                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                            c.inDither = true;
                                                        }
                                                    }
                                                    if (VERSION.SDK_INT < 19) {
                                                    }
                                                    booleanValue = true;
                                                    if (VERSION.SDK_INT >= 19) {
                                                        booleanValue = f3531g.contains(obj2);
                                                    }
                                                    if (booleanValue) {
                                                        if (i5 >= 0) {
                                                        }
                                                        if (m3034a(c)) {
                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                        }
                                                        f2 = f;
                                                        i3 = c.inSampleSize;
                                                        f3 = (float) i3;
                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                        i4 = Math.round(((float) i4) * f2);
                                                        b = Math.round(((float) b) * f2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                            stringBuilder4.append(i4);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(b);
                                                            stringBuilder4.append("] for source [");
                                                            stringBuilder4.append(i5);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(i8);
                                                            stringBuilder4.append("], sampleSize: ");
                                                            stringBuilder4.append(i3);
                                                            stringBuilder4.append(", targetDensity: ");
                                                            stringBuilder4.append(c.inTargetDensity);
                                                            stringBuilder4.append(", density: ");
                                                            stringBuilder4.append(c.inDensity);
                                                            stringBuilder4.append(", density multiplier: ");
                                                            stringBuilder4.append(f2);
                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                        }
                                                        i3 = i4;
                                                        bitmapPool = downsampler.f3533i;
                                                        if (VERSION.SDK_INT >= 26) {
                                                            config = null;
                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                            config = c.outConfig;
                                                        }
                                                        if (config == null) {
                                                            config = c.inPreferredConfig;
                                                        }
                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                    }
                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                        stringBuilder2.append(m3032a(b2));
                                                        stringBuilder2.append(" from [");
                                                        stringBuilder2.append(i5);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i8);
                                                        stringBuilder2.append("] ");
                                                        stringBuilder2.append(str);
                                                        stringBuilder2.append(" with inBitmap ");
                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                        stringBuilder2.append(" for [");
                                                        stringBuilder2.append(i);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i2);
                                                        stringBuilder2.append("], sample size: ");
                                                        stringBuilder2.append(c.inSampleSize);
                                                        stringBuilder2.append(", density: ");
                                                        stringBuilder2.append(c.inDensity);
                                                        stringBuilder2.append(", target density: ");
                                                        stringBuilder2.append(c.inTargetDensity);
                                                        stringBuilder2.append(", thread: ");
                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                        stringBuilder2.append(", duration: ");
                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                    }
                                                    if (b2 == null) {
                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                        if (b2.equals(bitmap)) {
                                                            downsampler.f3533i.mo940a(b2);
                                                        }
                                                    } else {
                                                        bitmap = null;
                                                    }
                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                    m3037b(c);
                                                    downsampler.f3535k.mo950a(obj5);
                                                    return a;
                                                }
                                            }
                                            decodeFormat3 = decodeFormat2;
                                            obj3 = null;
                                            if (obj3 == null) {
                                                inputStream3 = inputStream;
                                            } else if (VERSION.SDK_INT == 16) {
                                                inputStream3 = inputStream;
                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                if (z2) {
                                                }
                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                    c.inDither = true;
                                                }
                                            } else {
                                                inputStream3 = inputStream;
                                                c.inPreferredConfig = Config.ARGB_8888;
                                            }
                                            if (VERSION.SDK_INT < 19) {
                                            }
                                            booleanValue = true;
                                            if (VERSION.SDK_INT >= 19) {
                                                booleanValue = f3531g.contains(obj2);
                                            }
                                            if (booleanValue) {
                                                if (i5 >= 0) {
                                                }
                                                if (m3034a(c)) {
                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                }
                                                f2 = f;
                                                i3 = c.inSampleSize;
                                                f3 = (float) i3;
                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                i4 = Math.round(((float) i4) * f2);
                                                b = Math.round(((float) b) * f2);
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                    stringBuilder4.append(i4);
                                                    stringBuilder4.append("x");
                                                    stringBuilder4.append(b);
                                                    stringBuilder4.append("] for source [");
                                                    stringBuilder4.append(i5);
                                                    stringBuilder4.append("x");
                                                    stringBuilder4.append(i8);
                                                    stringBuilder4.append("], sampleSize: ");
                                                    stringBuilder4.append(i3);
                                                    stringBuilder4.append(", targetDensity: ");
                                                    stringBuilder4.append(c.inTargetDensity);
                                                    stringBuilder4.append(", density: ");
                                                    stringBuilder4.append(c.inDensity);
                                                    stringBuilder4.append(", density multiplier: ");
                                                    stringBuilder4.append(f2);
                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                }
                                                i3 = i4;
                                                bitmapPool = downsampler.f3533i;
                                                if (VERSION.SDK_INT >= 26) {
                                                    config = null;
                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                    config = c.outConfig;
                                                }
                                                if (config == null) {
                                                    config = c.inPreferredConfig;
                                                }
                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                            }
                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                stringBuilder2.append(m3032a(b2));
                                                stringBuilder2.append(" from [");
                                                stringBuilder2.append(i5);
                                                stringBuilder2.append("x");
                                                stringBuilder2.append(i8);
                                                stringBuilder2.append("] ");
                                                stringBuilder2.append(str);
                                                stringBuilder2.append(" with inBitmap ");
                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                stringBuilder2.append(" for [");
                                                stringBuilder2.append(i);
                                                stringBuilder2.append("x");
                                                stringBuilder2.append(i2);
                                                stringBuilder2.append("], sample size: ");
                                                stringBuilder2.append(c.inSampleSize);
                                                stringBuilder2.append(", density: ");
                                                stringBuilder2.append(c.inDensity);
                                                stringBuilder2.append(", target density: ");
                                                stringBuilder2.append(c.inTargetDensity);
                                                stringBuilder2.append(", thread: ");
                                                stringBuilder2.append(Thread.currentThread().getName());
                                                stringBuilder2.append(", duration: ");
                                                stringBuilder2.append(LogTime.m3212a(j));
                                                Log.v("Downsampler", stringBuilder2.toString());
                                            }
                                            if (b2 == null) {
                                                bitmap = null;
                                            } else {
                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                if (b2.equals(bitmap)) {
                                                    downsampler.f3533i.mo940a(b2);
                                                }
                                            }
                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                            m3037b(c);
                                            downsampler.f3535k.mo950a(obj5);
                                            return a;
                                        }
                                    }
                                    imageType = a5;
                                    inputStream4 = inputStream;
                                    f2 = (float) a4;
                                    i3 = (int) Math.floor((double) (f4 / f2));
                                    i9 = (int) Math.floor((double) (f5 / f2));
                                    i4 = i9;
                                    i9 = i3;
                                    downsampleStrategy = downsampleStrategy2;
                                    i3 = i11;
                                    a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                    if (VERSION.SDK_INT < 19) {
                                        a10 = m3031a(a9);
                                        i13 = a4;
                                        a4 = (int) ((((double) a10) * a9) + 0.5d);
                                        i14 = i9;
                                        c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                        c.inDensity = m3031a(a9);
                                    } else {
                                        i14 = i9;
                                        i13 = a4;
                                    }
                                    if (m3034a(c)) {
                                        c.inScaled = true;
                                    } else {
                                        c.inTargetDensity = 0;
                                        c.inDensity = 0;
                                    }
                                    if (Log.isLoggable("Downsampler", 2)) {
                                        stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                        stringBuilder3.append(i5);
                                        stringBuilder3.append("x");
                                        stringBuilder3.append(i8);
                                        stringBuilder3.append("], target: [");
                                        stringBuilder3.append(i3);
                                        stringBuilder3.append("x");
                                        stringBuilder3.append(b);
                                        stringBuilder3.append("], power of two scaled: [");
                                        stringBuilder3.append(i14);
                                        stringBuilder3.append("x");
                                        stringBuilder3.append(i4);
                                        stringBuilder3.append("], exact scale factor: ");
                                        stringBuilder3.append(a6);
                                        stringBuilder3.append(", power of 2 sample size: ");
                                        stringBuilder3.append(i13);
                                        stringBuilder3.append(", adjusted scale factor: ");
                                        stringBuilder3.append(a9);
                                        stringBuilder3.append(", target density: ");
                                        stringBuilder3.append(c.inTargetDensity);
                                        stringBuilder3.append(", density: ");
                                        stringBuilder3.append(c.inDensity);
                                        Log.v("Downsampler", stringBuilder3.toString());
                                    }
                                    obj2 = imageType;
                                    hardwareConfigState = this.f3537m;
                                    if (i7 != 0) {
                                        if (VERSION.SDK_INT >= 26) {
                                            decodeFormat3 = decodeFormat2;
                                            if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                                if (!z) {
                                                    if (i3 >= 128) {
                                                    }
                                                    if (obj3 == null) {
                                                        c.inPreferredConfig = Config.HARDWARE;
                                                        c.inMutable = false;
                                                    }
                                                    if (obj3 == null) {
                                                        inputStream3 = inputStream;
                                                    } else if (VERSION.SDK_INT == 16) {
                                                        inputStream3 = inputStream;
                                                        c.inPreferredConfig = Config.ARGB_8888;
                                                    } else {
                                                        inputStream3 = inputStream;
                                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                        if (z2) {
                                                        }
                                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                        if (c.inPreferredConfig == Config.RGB_565) {
                                                            c.inDither = true;
                                                        }
                                                    }
                                                    if (VERSION.SDK_INT < 19) {
                                                    }
                                                    booleanValue = true;
                                                    if (VERSION.SDK_INT >= 19) {
                                                        booleanValue = f3531g.contains(obj2);
                                                    }
                                                    if (booleanValue) {
                                                        if (i5 >= 0) {
                                                        }
                                                        if (m3034a(c)) {
                                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                        }
                                                        f2 = f;
                                                        i3 = c.inSampleSize;
                                                        f3 = (float) i3;
                                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                                        i4 = Math.round(((float) i4) * f2);
                                                        b = Math.round(((float) b) * f2);
                                                        if (Log.isLoggable("Downsampler", 2)) {
                                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                                            stringBuilder4.append(i4);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(b);
                                                            stringBuilder4.append("] for source [");
                                                            stringBuilder4.append(i5);
                                                            stringBuilder4.append("x");
                                                            stringBuilder4.append(i8);
                                                            stringBuilder4.append("], sampleSize: ");
                                                            stringBuilder4.append(i3);
                                                            stringBuilder4.append(", targetDensity: ");
                                                            stringBuilder4.append(c.inTargetDensity);
                                                            stringBuilder4.append(", density: ");
                                                            stringBuilder4.append(c.inDensity);
                                                            stringBuilder4.append(", density multiplier: ");
                                                            stringBuilder4.append(f2);
                                                            Log.v("Downsampler", stringBuilder4.toString());
                                                        }
                                                        i3 = i4;
                                                        bitmapPool = downsampler.f3533i;
                                                        if (VERSION.SDK_INT >= 26) {
                                                            config = null;
                                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                            config = c.outConfig;
                                                        }
                                                        if (config == null) {
                                                            config = c.inPreferredConfig;
                                                        }
                                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                    }
                                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder2 = new StringBuilder("Decoded ");
                                                        stringBuilder2.append(m3032a(b2));
                                                        stringBuilder2.append(" from [");
                                                        stringBuilder2.append(i5);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i8);
                                                        stringBuilder2.append("] ");
                                                        stringBuilder2.append(str);
                                                        stringBuilder2.append(" with inBitmap ");
                                                        stringBuilder2.append(m3032a(c.inBitmap));
                                                        stringBuilder2.append(" for [");
                                                        stringBuilder2.append(i);
                                                        stringBuilder2.append("x");
                                                        stringBuilder2.append(i2);
                                                        stringBuilder2.append("], sample size: ");
                                                        stringBuilder2.append(c.inSampleSize);
                                                        stringBuilder2.append(", density: ");
                                                        stringBuilder2.append(c.inDensity);
                                                        stringBuilder2.append(", target density: ");
                                                        stringBuilder2.append(c.inTargetDensity);
                                                        stringBuilder2.append(", thread: ");
                                                        stringBuilder2.append(Thread.currentThread().getName());
                                                        stringBuilder2.append(", duration: ");
                                                        stringBuilder2.append(LogTime.m3212a(j));
                                                        Log.v("Downsampler", stringBuilder2.toString());
                                                    }
                                                    if (b2 == null) {
                                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                        if (b2.equals(bitmap)) {
                                                            downsampler.f3533i.mo940a(b2);
                                                        }
                                                    } else {
                                                        bitmap = null;
                                                    }
                                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                    m3037b(c);
                                                    downsampler.f3535k.mo950a(obj5);
                                                    return a;
                                                }
                                            }
                                            obj3 = null;
                                            if (obj3 == null) {
                                                inputStream3 = inputStream;
                                            } else if (VERSION.SDK_INT == 16) {
                                                inputStream3 = inputStream;
                                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                if (z2) {
                                                }
                                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                if (c.inPreferredConfig == Config.RGB_565) {
                                                    c.inDither = true;
                                                }
                                            } else {
                                                inputStream3 = inputStream;
                                                c.inPreferredConfig = Config.ARGB_8888;
                                            }
                                            if (VERSION.SDK_INT < 19) {
                                            }
                                            booleanValue = true;
                                            if (VERSION.SDK_INT >= 19) {
                                                booleanValue = f3531g.contains(obj2);
                                            }
                                            if (booleanValue) {
                                                if (i5 >= 0) {
                                                }
                                                if (m3034a(c)) {
                                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                }
                                                f2 = f;
                                                i3 = c.inSampleSize;
                                                f3 = (float) i3;
                                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                                i4 = Math.round(((float) i4) * f2);
                                                b = Math.round(((float) b) * f2);
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                                    stringBuilder4.append(i4);
                                                    stringBuilder4.append("x");
                                                    stringBuilder4.append(b);
                                                    stringBuilder4.append("] for source [");
                                                    stringBuilder4.append(i5);
                                                    stringBuilder4.append("x");
                                                    stringBuilder4.append(i8);
                                                    stringBuilder4.append("], sampleSize: ");
                                                    stringBuilder4.append(i3);
                                                    stringBuilder4.append(", targetDensity: ");
                                                    stringBuilder4.append(c.inTargetDensity);
                                                    stringBuilder4.append(", density: ");
                                                    stringBuilder4.append(c.inDensity);
                                                    stringBuilder4.append(", density multiplier: ");
                                                    stringBuilder4.append(f2);
                                                    Log.v("Downsampler", stringBuilder4.toString());
                                                }
                                                i3 = i4;
                                                bitmapPool = downsampler.f3533i;
                                                if (VERSION.SDK_INT >= 26) {
                                                    config = null;
                                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                    config = c.outConfig;
                                                }
                                                if (config == null) {
                                                    config = c.inPreferredConfig;
                                                }
                                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                            }
                                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder2 = new StringBuilder("Decoded ");
                                                stringBuilder2.append(m3032a(b2));
                                                stringBuilder2.append(" from [");
                                                stringBuilder2.append(i5);
                                                stringBuilder2.append("x");
                                                stringBuilder2.append(i8);
                                                stringBuilder2.append("] ");
                                                stringBuilder2.append(str);
                                                stringBuilder2.append(" with inBitmap ");
                                                stringBuilder2.append(m3032a(c.inBitmap));
                                                stringBuilder2.append(" for [");
                                                stringBuilder2.append(i);
                                                stringBuilder2.append("x");
                                                stringBuilder2.append(i2);
                                                stringBuilder2.append("], sample size: ");
                                                stringBuilder2.append(c.inSampleSize);
                                                stringBuilder2.append(", density: ");
                                                stringBuilder2.append(c.inDensity);
                                                stringBuilder2.append(", target density: ");
                                                stringBuilder2.append(c.inTargetDensity);
                                                stringBuilder2.append(", thread: ");
                                                stringBuilder2.append(Thread.currentThread().getName());
                                                stringBuilder2.append(", duration: ");
                                                stringBuilder2.append(LogTime.m3212a(j));
                                                Log.v("Downsampler", stringBuilder2.toString());
                                            }
                                            if (b2 == null) {
                                                bitmap = null;
                                            } else {
                                                b2.setDensity(downsampler.f3534j.densityDpi);
                                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                if (b2.equals(bitmap)) {
                                                    downsampler.f3533i.mo940a(b2);
                                                }
                                            }
                                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                            m3037b(c);
                                            downsampler.f3535k.mo950a(obj5);
                                            return a;
                                        }
                                    }
                                    decodeFormat3 = decodeFormat2;
                                    obj3 = null;
                                    if (obj3 == null) {
                                        inputStream3 = inputStream;
                                    } else if (VERSION.SDK_INT == 16) {
                                        inputStream3 = inputStream;
                                        c.inPreferredConfig = Config.ARGB_8888;
                                    } else {
                                        inputStream3 = inputStream;
                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                        if (z2) {
                                        }
                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                        if (c.inPreferredConfig == Config.RGB_565) {
                                            c.inDither = true;
                                        }
                                    }
                                    if (VERSION.SDK_INT < 19) {
                                    }
                                    booleanValue = true;
                                    if (VERSION.SDK_INT >= 19) {
                                        booleanValue = f3531g.contains(obj2);
                                    }
                                    if (booleanValue) {
                                        if (i5 >= 0) {
                                        }
                                        if (m3034a(c)) {
                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                        }
                                        f2 = f;
                                        i3 = c.inSampleSize;
                                        f3 = (float) i3;
                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                        i4 = Math.round(((float) i4) * f2);
                                        b = Math.round(((float) b) * f2);
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                            stringBuilder4.append(i4);
                                            stringBuilder4.append("x");
                                            stringBuilder4.append(b);
                                            stringBuilder4.append("] for source [");
                                            stringBuilder4.append(i5);
                                            stringBuilder4.append("x");
                                            stringBuilder4.append(i8);
                                            stringBuilder4.append("], sampleSize: ");
                                            stringBuilder4.append(i3);
                                            stringBuilder4.append(", targetDensity: ");
                                            stringBuilder4.append(c.inTargetDensity);
                                            stringBuilder4.append(", density: ");
                                            stringBuilder4.append(c.inDensity);
                                            stringBuilder4.append(", density multiplier: ");
                                            stringBuilder4.append(f2);
                                            Log.v("Downsampler", stringBuilder4.toString());
                                        }
                                        i3 = i4;
                                        bitmapPool = downsampler.f3533i;
                                        if (VERSION.SDK_INT >= 26) {
                                            config = null;
                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                            config = c.outConfig;
                                        }
                                        if (config == null) {
                                            config = c.inPreferredConfig;
                                        }
                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                    }
                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                    if (Log.isLoggable("Downsampler", 2)) {
                                        stringBuilder2 = new StringBuilder("Decoded ");
                                        stringBuilder2.append(m3032a(b2));
                                        stringBuilder2.append(" from [");
                                        stringBuilder2.append(i5);
                                        stringBuilder2.append("x");
                                        stringBuilder2.append(i8);
                                        stringBuilder2.append("] ");
                                        stringBuilder2.append(str);
                                        stringBuilder2.append(" with inBitmap ");
                                        stringBuilder2.append(m3032a(c.inBitmap));
                                        stringBuilder2.append(" for [");
                                        stringBuilder2.append(i);
                                        stringBuilder2.append("x");
                                        stringBuilder2.append(i2);
                                        stringBuilder2.append("], sample size: ");
                                        stringBuilder2.append(c.inSampleSize);
                                        stringBuilder2.append(", density: ");
                                        stringBuilder2.append(c.inDensity);
                                        stringBuilder2.append(", target density: ");
                                        stringBuilder2.append(c.inTargetDensity);
                                        stringBuilder2.append(", thread: ");
                                        stringBuilder2.append(Thread.currentThread().getName());
                                        stringBuilder2.append(", duration: ");
                                        stringBuilder2.append(LogTime.m3212a(j));
                                        Log.v("Downsampler", stringBuilder2.toString());
                                    }
                                    if (b2 == null) {
                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                        if (b2.equals(bitmap)) {
                                            downsampler.f3533i.mo940a(b2);
                                        }
                                    } else {
                                        bitmap = null;
                                    }
                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                    m3037b(c);
                                    downsampler.f3535k.mo950a(obj5);
                                    return a;
                                }
                                min = (float) Math.min(a4, 8);
                                i11 = i3;
                                i9 = (int) Math.ceil((double) (f4 / min));
                                i10 = (int) Math.ceil((double) (f5 / min));
                                i3 = a4 / 8;
                                if (i3 > 0) {
                                    i9 /= i3;
                                    i10 /= i3;
                                }
                                imageType = a5;
                                downsampleStrategy = downsampleStrategy2;
                                i3 = i11;
                                i4 = i10;
                                inputStream4 = inputStream;
                                a9 = (double) downsampleStrategy.mo990a(i9, i4, i3, b);
                                if (VERSION.SDK_INT < 19) {
                                    i14 = i9;
                                    i13 = a4;
                                } else {
                                    a10 = m3031a(a9);
                                    i13 = a4;
                                    a4 = (int) ((((double) a10) * a9) + 0.5d);
                                    i14 = i9;
                                    c.inTargetDensity = (int) (((a9 / ((double) (((float) a4) / ((float) a10)))) * ((double) a4)) + 0.5d);
                                    c.inDensity = m3031a(a9);
                                }
                                if (m3034a(c)) {
                                    c.inTargetDensity = 0;
                                    c.inDensity = 0;
                                } else {
                                    c.inScaled = true;
                                }
                                if (Log.isLoggable("Downsampler", 2)) {
                                    stringBuilder3 = new StringBuilder("Calculate scaling, source: [");
                                    stringBuilder3.append(i5);
                                    stringBuilder3.append("x");
                                    stringBuilder3.append(i8);
                                    stringBuilder3.append("], target: [");
                                    stringBuilder3.append(i3);
                                    stringBuilder3.append("x");
                                    stringBuilder3.append(b);
                                    stringBuilder3.append("], power of two scaled: [");
                                    stringBuilder3.append(i14);
                                    stringBuilder3.append("x");
                                    stringBuilder3.append(i4);
                                    stringBuilder3.append("], exact scale factor: ");
                                    stringBuilder3.append(a6);
                                    stringBuilder3.append(", power of 2 sample size: ");
                                    stringBuilder3.append(i13);
                                    stringBuilder3.append(", adjusted scale factor: ");
                                    stringBuilder3.append(a9);
                                    stringBuilder3.append(", target density: ");
                                    stringBuilder3.append(c.inTargetDensity);
                                    stringBuilder3.append(", density: ");
                                    stringBuilder3.append(c.inDensity);
                                    Log.v("Downsampler", stringBuilder3.toString());
                                }
                                obj2 = imageType;
                                hardwareConfigState = this.f3537m;
                                if (i7 != 0) {
                                    if (VERSION.SDK_INT >= 26) {
                                        decodeFormat3 = decodeFormat2;
                                        if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                            if (!z) {
                                                if (i3 >= 128) {
                                                }
                                                if (obj3 == null) {
                                                    c.inPreferredConfig = Config.HARDWARE;
                                                    c.inMutable = false;
                                                }
                                                if (obj3 == null) {
                                                    inputStream3 = inputStream;
                                                } else if (VERSION.SDK_INT == 16) {
                                                    inputStream3 = inputStream;
                                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                                    if (z2) {
                                                    }
                                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                                    if (c.inPreferredConfig == Config.RGB_565) {
                                                        c.inDither = true;
                                                    }
                                                } else {
                                                    inputStream3 = inputStream;
                                                    c.inPreferredConfig = Config.ARGB_8888;
                                                }
                                                if (VERSION.SDK_INT < 19) {
                                                }
                                                booleanValue = true;
                                                if (VERSION.SDK_INT >= 19) {
                                                    booleanValue = f3531g.contains(obj2);
                                                }
                                                if (booleanValue) {
                                                    if (i5 >= 0) {
                                                    }
                                                    if (m3034a(c)) {
                                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                                    }
                                                    f2 = f;
                                                    i3 = c.inSampleSize;
                                                    f3 = (float) i3;
                                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                                    i4 = Math.round(((float) i4) * f2);
                                                    b = Math.round(((float) b) * f2);
                                                    if (Log.isLoggable("Downsampler", 2)) {
                                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                                        stringBuilder4.append(i4);
                                                        stringBuilder4.append("x");
                                                        stringBuilder4.append(b);
                                                        stringBuilder4.append("] for source [");
                                                        stringBuilder4.append(i5);
                                                        stringBuilder4.append("x");
                                                        stringBuilder4.append(i8);
                                                        stringBuilder4.append("], sampleSize: ");
                                                        stringBuilder4.append(i3);
                                                        stringBuilder4.append(", targetDensity: ");
                                                        stringBuilder4.append(c.inTargetDensity);
                                                        stringBuilder4.append(", density: ");
                                                        stringBuilder4.append(c.inDensity);
                                                        stringBuilder4.append(", density multiplier: ");
                                                        stringBuilder4.append(f2);
                                                        Log.v("Downsampler", stringBuilder4.toString());
                                                    }
                                                    i3 = i4;
                                                    bitmapPool = downsampler.f3533i;
                                                    if (VERSION.SDK_INT >= 26) {
                                                        config = null;
                                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                        config = c.outConfig;
                                                    }
                                                    if (config == null) {
                                                        config = c.inPreferredConfig;
                                                    }
                                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                                }
                                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                                if (Log.isLoggable("Downsampler", 2)) {
                                                    stringBuilder2 = new StringBuilder("Decoded ");
                                                    stringBuilder2.append(m3032a(b2));
                                                    stringBuilder2.append(" from [");
                                                    stringBuilder2.append(i5);
                                                    stringBuilder2.append("x");
                                                    stringBuilder2.append(i8);
                                                    stringBuilder2.append("] ");
                                                    stringBuilder2.append(str);
                                                    stringBuilder2.append(" with inBitmap ");
                                                    stringBuilder2.append(m3032a(c.inBitmap));
                                                    stringBuilder2.append(" for [");
                                                    stringBuilder2.append(i);
                                                    stringBuilder2.append("x");
                                                    stringBuilder2.append(i2);
                                                    stringBuilder2.append("], sample size: ");
                                                    stringBuilder2.append(c.inSampleSize);
                                                    stringBuilder2.append(", density: ");
                                                    stringBuilder2.append(c.inDensity);
                                                    stringBuilder2.append(", target density: ");
                                                    stringBuilder2.append(c.inTargetDensity);
                                                    stringBuilder2.append(", thread: ");
                                                    stringBuilder2.append(Thread.currentThread().getName());
                                                    stringBuilder2.append(", duration: ");
                                                    stringBuilder2.append(LogTime.m3212a(j));
                                                    Log.v("Downsampler", stringBuilder2.toString());
                                                }
                                                if (b2 == null) {
                                                    bitmap = null;
                                                } else {
                                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                                    if (b2.equals(bitmap)) {
                                                        downsampler.f3533i.mo940a(b2);
                                                    }
                                                }
                                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                                m3037b(c);
                                                downsampler.f3535k.mo950a(obj5);
                                                return a;
                                            }
                                        }
                                        obj3 = null;
                                        if (obj3 == null) {
                                            inputStream3 = inputStream;
                                        } else if (VERSION.SDK_INT == 16) {
                                            inputStream3 = inputStream;
                                            c.inPreferredConfig = Config.ARGB_8888;
                                        } else {
                                            inputStream3 = inputStream;
                                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                            if (z2) {
                                            }
                                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                            if (c.inPreferredConfig == Config.RGB_565) {
                                                c.inDither = true;
                                            }
                                        }
                                        if (VERSION.SDK_INT < 19) {
                                        }
                                        booleanValue = true;
                                        if (VERSION.SDK_INT >= 19) {
                                            booleanValue = f3531g.contains(obj2);
                                        }
                                        if (booleanValue) {
                                            if (i5 >= 0) {
                                            }
                                            if (m3034a(c)) {
                                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                            }
                                            f2 = f;
                                            i3 = c.inSampleSize;
                                            f3 = (float) i3;
                                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                            b = (int) Math.ceil((double) (((float) i8) / f3));
                                            i4 = Math.round(((float) i4) * f2);
                                            b = Math.round(((float) b) * f2);
                                            if (Log.isLoggable("Downsampler", 2)) {
                                                stringBuilder4 = new StringBuilder("Calculated target [");
                                                stringBuilder4.append(i4);
                                                stringBuilder4.append("x");
                                                stringBuilder4.append(b);
                                                stringBuilder4.append("] for source [");
                                                stringBuilder4.append(i5);
                                                stringBuilder4.append("x");
                                                stringBuilder4.append(i8);
                                                stringBuilder4.append("], sampleSize: ");
                                                stringBuilder4.append(i3);
                                                stringBuilder4.append(", targetDensity: ");
                                                stringBuilder4.append(c.inTargetDensity);
                                                stringBuilder4.append(", density: ");
                                                stringBuilder4.append(c.inDensity);
                                                stringBuilder4.append(", density multiplier: ");
                                                stringBuilder4.append(f2);
                                                Log.v("Downsampler", stringBuilder4.toString());
                                            }
                                            i3 = i4;
                                            bitmapPool = downsampler.f3533i;
                                            if (VERSION.SDK_INT >= 26) {
                                                config = null;
                                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                                config = c.outConfig;
                                            }
                                            if (config == null) {
                                                config = c.inPreferredConfig;
                                            }
                                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                        }
                                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            stringBuilder2 = new StringBuilder("Decoded ");
                                            stringBuilder2.append(m3032a(b2));
                                            stringBuilder2.append(" from [");
                                            stringBuilder2.append(i5);
                                            stringBuilder2.append("x");
                                            stringBuilder2.append(i8);
                                            stringBuilder2.append("] ");
                                            stringBuilder2.append(str);
                                            stringBuilder2.append(" with inBitmap ");
                                            stringBuilder2.append(m3032a(c.inBitmap));
                                            stringBuilder2.append(" for [");
                                            stringBuilder2.append(i);
                                            stringBuilder2.append("x");
                                            stringBuilder2.append(i2);
                                            stringBuilder2.append("], sample size: ");
                                            stringBuilder2.append(c.inSampleSize);
                                            stringBuilder2.append(", density: ");
                                            stringBuilder2.append(c.inDensity);
                                            stringBuilder2.append(", target density: ");
                                            stringBuilder2.append(c.inTargetDensity);
                                            stringBuilder2.append(", thread: ");
                                            stringBuilder2.append(Thread.currentThread().getName());
                                            stringBuilder2.append(", duration: ");
                                            stringBuilder2.append(LogTime.m3212a(j));
                                            Log.v("Downsampler", stringBuilder2.toString());
                                        }
                                        if (b2 == null) {
                                            b2.setDensity(downsampler.f3534j.densityDpi);
                                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                            if (b2.equals(bitmap)) {
                                                downsampler.f3533i.mo940a(b2);
                                            }
                                        } else {
                                            bitmap = null;
                                        }
                                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                        m3037b(c);
                                        downsampler.f3535k.mo950a(obj5);
                                        return a;
                                    }
                                }
                                decodeFormat3 = decodeFormat2;
                                obj3 = null;
                                if (obj3 == null) {
                                    inputStream3 = inputStream;
                                } else if (VERSION.SDK_INT == 16) {
                                    inputStream3 = inputStream;
                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                    if (z2) {
                                    }
                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                    if (c.inPreferredConfig == Config.RGB_565) {
                                        c.inDither = true;
                                    }
                                } else {
                                    inputStream3 = inputStream;
                                    c.inPreferredConfig = Config.ARGB_8888;
                                }
                                if (VERSION.SDK_INT < 19) {
                                }
                                booleanValue = true;
                                if (VERSION.SDK_INT >= 19) {
                                    booleanValue = f3531g.contains(obj2);
                                }
                                if (booleanValue) {
                                    if (i5 >= 0) {
                                    }
                                    if (m3034a(c)) {
                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                    }
                                    f2 = f;
                                    i3 = c.inSampleSize;
                                    f3 = (float) i3;
                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                    i4 = Math.round(((float) i4) * f2);
                                    b = Math.round(((float) b) * f2);
                                    if (Log.isLoggable("Downsampler", 2)) {
                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                        stringBuilder4.append(i4);
                                        stringBuilder4.append("x");
                                        stringBuilder4.append(b);
                                        stringBuilder4.append("] for source [");
                                        stringBuilder4.append(i5);
                                        stringBuilder4.append("x");
                                        stringBuilder4.append(i8);
                                        stringBuilder4.append("], sampleSize: ");
                                        stringBuilder4.append(i3);
                                        stringBuilder4.append(", targetDensity: ");
                                        stringBuilder4.append(c.inTargetDensity);
                                        stringBuilder4.append(", density: ");
                                        stringBuilder4.append(c.inDensity);
                                        stringBuilder4.append(", density multiplier: ");
                                        stringBuilder4.append(f2);
                                        Log.v("Downsampler", stringBuilder4.toString());
                                    }
                                    i3 = i4;
                                    bitmapPool = downsampler.f3533i;
                                    if (VERSION.SDK_INT >= 26) {
                                        config = null;
                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                        config = c.outConfig;
                                    }
                                    if (config == null) {
                                        config = c.inPreferredConfig;
                                    }
                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                }
                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                if (Log.isLoggable("Downsampler", 2)) {
                                    stringBuilder2 = new StringBuilder("Decoded ");
                                    stringBuilder2.append(m3032a(b2));
                                    stringBuilder2.append(" from [");
                                    stringBuilder2.append(i5);
                                    stringBuilder2.append("x");
                                    stringBuilder2.append(i8);
                                    stringBuilder2.append("] ");
                                    stringBuilder2.append(str);
                                    stringBuilder2.append(" with inBitmap ");
                                    stringBuilder2.append(m3032a(c.inBitmap));
                                    stringBuilder2.append(" for [");
                                    stringBuilder2.append(i);
                                    stringBuilder2.append("x");
                                    stringBuilder2.append(i2);
                                    stringBuilder2.append("], sample size: ");
                                    stringBuilder2.append(c.inSampleSize);
                                    stringBuilder2.append(", density: ");
                                    stringBuilder2.append(c.inDensity);
                                    stringBuilder2.append(", target density: ");
                                    stringBuilder2.append(c.inTargetDensity);
                                    stringBuilder2.append(", thread: ");
                                    stringBuilder2.append(Thread.currentThread().getName());
                                    stringBuilder2.append(", duration: ");
                                    stringBuilder2.append(LogTime.m3212a(j));
                                    Log.v("Downsampler", stringBuilder2.toString());
                                }
                                if (b2 == null) {
                                    bitmap = null;
                                } else {
                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                    if (b2.equals(bitmap)) {
                                        downsampler.f3533i.mo940a(b2);
                                    }
                                }
                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                m3037b(c);
                                downsampler.f3535k.mo950a(obj5);
                                return a;
                            }
                            throw new IllegalArgumentException("Cannot round with null rounding");
                        }
                        stringBuilder2 = new StringBuilder("Cannot scale with factor: ");
                        stringBuilder2.append(a6);
                        stringBuilder2.append(" from: ");
                        stringBuilder2.append(downsampleStrategy);
                        stringBuilder2.append(", source: [");
                        stringBuilder2.append(i5);
                        stringBuilder2.append("x");
                        stringBuilder2.append(i8);
                        stringBuilder2.append("], target: [");
                        stringBuilder2.append(i3);
                        stringBuilder2.append("x");
                        stringBuilder2.append(b);
                        stringBuilder2.append("]");
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    }
                }
                imageType = a5;
                decodeFormat2 = decodeFormat;
                z = b3;
            } catch (Throwable th3) {
                e42 = th3;
                obj = obj5;
                th2 = e42;
                m3037b(c);
                downsampler.f3535k.mo950a(obj);
                throw th2;
            }
            try {
                if (Log.isLoggable("Downsampler", 3)) {
                    stringBuilder3 = new StringBuilder("Unable to determine dimensions for: ");
                    obj2 = imageType;
                    stringBuilder3.append(obj2);
                    stringBuilder3.append(" with target [");
                    stringBuilder3.append(i3);
                    stringBuilder3.append("x");
                    stringBuilder3.append(b);
                    stringBuilder3.append("]");
                    Log.d("Downsampler", stringBuilder3.toString());
                    hardwareConfigState = this.f3537m;
                    if (i7 != 0) {
                        if (VERSION.SDK_INT >= 26) {
                            decodeFormat3 = decodeFormat2;
                            if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                                if (!z) {
                                    if (i3 >= 128) {
                                    }
                                    if (obj3 == null) {
                                        c.inPreferredConfig = Config.HARDWARE;
                                        c.inMutable = false;
                                    }
                                    if (obj3 == null) {
                                        inputStream3 = inputStream;
                                    } else if (VERSION.SDK_INT == 16) {
                                        inputStream3 = inputStream;
                                        c.inPreferredConfig = Config.ARGB_8888;
                                    } else {
                                        inputStream3 = inputStream;
                                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                        if (z2) {
                                        }
                                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                        if (c.inPreferredConfig == Config.RGB_565) {
                                            c.inDither = true;
                                        }
                                    }
                                    if (VERSION.SDK_INT < 19) {
                                    }
                                    booleanValue = true;
                                    if (VERSION.SDK_INT >= 19) {
                                        booleanValue = f3531g.contains(obj2);
                                    }
                                    if (booleanValue) {
                                        if (i5 >= 0) {
                                        }
                                        if (m3034a(c)) {
                                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                        }
                                        f2 = f;
                                        i3 = c.inSampleSize;
                                        f3 = (float) i3;
                                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                        b = (int) Math.ceil((double) (((float) i8) / f3));
                                        i4 = Math.round(((float) i4) * f2);
                                        b = Math.round(((float) b) * f2);
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            stringBuilder4 = new StringBuilder("Calculated target [");
                                            stringBuilder4.append(i4);
                                            stringBuilder4.append("x");
                                            stringBuilder4.append(b);
                                            stringBuilder4.append("] for source [");
                                            stringBuilder4.append(i5);
                                            stringBuilder4.append("x");
                                            stringBuilder4.append(i8);
                                            stringBuilder4.append("], sampleSize: ");
                                            stringBuilder4.append(i3);
                                            stringBuilder4.append(", targetDensity: ");
                                            stringBuilder4.append(c.inTargetDensity);
                                            stringBuilder4.append(", density: ");
                                            stringBuilder4.append(c.inDensity);
                                            stringBuilder4.append(", density multiplier: ");
                                            stringBuilder4.append(f2);
                                            Log.v("Downsampler", stringBuilder4.toString());
                                        }
                                        i3 = i4;
                                        bitmapPool = downsampler.f3533i;
                                        if (VERSION.SDK_INT >= 26) {
                                            config = null;
                                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                                            config = c.outConfig;
                                        }
                                        if (config == null) {
                                            config = c.inPreferredConfig;
                                        }
                                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                    }
                                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                    if (Log.isLoggable("Downsampler", 2)) {
                                        stringBuilder2 = new StringBuilder("Decoded ");
                                        stringBuilder2.append(m3032a(b2));
                                        stringBuilder2.append(" from [");
                                        stringBuilder2.append(i5);
                                        stringBuilder2.append("x");
                                        stringBuilder2.append(i8);
                                        stringBuilder2.append("] ");
                                        stringBuilder2.append(str);
                                        stringBuilder2.append(" with inBitmap ");
                                        stringBuilder2.append(m3032a(c.inBitmap));
                                        stringBuilder2.append(" for [");
                                        stringBuilder2.append(i);
                                        stringBuilder2.append("x");
                                        stringBuilder2.append(i2);
                                        stringBuilder2.append("], sample size: ");
                                        stringBuilder2.append(c.inSampleSize);
                                        stringBuilder2.append(", density: ");
                                        stringBuilder2.append(c.inDensity);
                                        stringBuilder2.append(", target density: ");
                                        stringBuilder2.append(c.inTargetDensity);
                                        stringBuilder2.append(", thread: ");
                                        stringBuilder2.append(Thread.currentThread().getName());
                                        stringBuilder2.append(", duration: ");
                                        stringBuilder2.append(LogTime.m3212a(j));
                                        Log.v("Downsampler", stringBuilder2.toString());
                                    }
                                    if (b2 == null) {
                                        b2.setDensity(downsampler.f3534j.densityDpi);
                                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                        if (b2.equals(bitmap)) {
                                            downsampler.f3533i.mo940a(b2);
                                        }
                                    } else {
                                        bitmap = null;
                                    }
                                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                    m3037b(c);
                                    downsampler.f3535k.mo950a(obj5);
                                    return a;
                                }
                            }
                            obj3 = null;
                            if (obj3 == null) {
                                inputStream3 = inputStream;
                            } else if (VERSION.SDK_INT == 16) {
                                inputStream3 = inputStream;
                                z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                if (z2) {
                                }
                                c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                if (c.inPreferredConfig == Config.RGB_565) {
                                    c.inDither = true;
                                }
                            } else {
                                inputStream3 = inputStream;
                                c.inPreferredConfig = Config.ARGB_8888;
                            }
                            if (VERSION.SDK_INT < 19) {
                            }
                            booleanValue = true;
                            if (VERSION.SDK_INT >= 19) {
                                booleanValue = f3531g.contains(obj2);
                            }
                            if (booleanValue) {
                                if (i5 >= 0) {
                                }
                                if (m3034a(c)) {
                                    f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                }
                                f2 = f;
                                i3 = c.inSampleSize;
                                f3 = (float) i3;
                                i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                b = (int) Math.ceil((double) (((float) i8) / f3));
                                i4 = Math.round(((float) i4) * f2);
                                b = Math.round(((float) b) * f2);
                                if (Log.isLoggable("Downsampler", 2)) {
                                    stringBuilder4 = new StringBuilder("Calculated target [");
                                    stringBuilder4.append(i4);
                                    stringBuilder4.append("x");
                                    stringBuilder4.append(b);
                                    stringBuilder4.append("] for source [");
                                    stringBuilder4.append(i5);
                                    stringBuilder4.append("x");
                                    stringBuilder4.append(i8);
                                    stringBuilder4.append("], sampleSize: ");
                                    stringBuilder4.append(i3);
                                    stringBuilder4.append(", targetDensity: ");
                                    stringBuilder4.append(c.inTargetDensity);
                                    stringBuilder4.append(", density: ");
                                    stringBuilder4.append(c.inDensity);
                                    stringBuilder4.append(", density multiplier: ");
                                    stringBuilder4.append(f2);
                                    Log.v("Downsampler", stringBuilder4.toString());
                                }
                                i3 = i4;
                                bitmapPool = downsampler.f3533i;
                                if (VERSION.SDK_INT >= 26) {
                                    config = null;
                                } else if (c.inPreferredConfig != Config.HARDWARE) {
                                    config = c.outConfig;
                                }
                                if (config == null) {
                                    config = c.inPreferredConfig;
                                }
                                c.inBitmap = bitmapPool.mo941b(i3, b, config);
                            }
                            b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                            decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                            if (Log.isLoggable("Downsampler", 2)) {
                                stringBuilder2 = new StringBuilder("Decoded ");
                                stringBuilder2.append(m3032a(b2));
                                stringBuilder2.append(" from [");
                                stringBuilder2.append(i5);
                                stringBuilder2.append("x");
                                stringBuilder2.append(i8);
                                stringBuilder2.append("] ");
                                stringBuilder2.append(str);
                                stringBuilder2.append(" with inBitmap ");
                                stringBuilder2.append(m3032a(c.inBitmap));
                                stringBuilder2.append(" for [");
                                stringBuilder2.append(i);
                                stringBuilder2.append("x");
                                stringBuilder2.append(i2);
                                stringBuilder2.append("], sample size: ");
                                stringBuilder2.append(c.inSampleSize);
                                stringBuilder2.append(", density: ");
                                stringBuilder2.append(c.inDensity);
                                stringBuilder2.append(", target density: ");
                                stringBuilder2.append(c.inTargetDensity);
                                stringBuilder2.append(", thread: ");
                                stringBuilder2.append(Thread.currentThread().getName());
                                stringBuilder2.append(", duration: ");
                                stringBuilder2.append(LogTime.m3212a(j));
                                Log.v("Downsampler", stringBuilder2.toString());
                            }
                            if (b2 == null) {
                                bitmap = null;
                            } else {
                                b2.setDensity(downsampler.f3534j.densityDpi);
                                bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                if (b2.equals(bitmap)) {
                                    downsampler.f3533i.mo940a(b2);
                                }
                            }
                            a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                            m3037b(c);
                            downsampler.f3535k.mo950a(obj5);
                            return a;
                        }
                    }
                    decodeFormat3 = decodeFormat2;
                    obj3 = null;
                    if (obj3 == null) {
                        inputStream3 = inputStream;
                    } else if (VERSION.SDK_INT == 16) {
                        inputStream3 = inputStream;
                        c.inPreferredConfig = Config.ARGB_8888;
                    } else {
                        inputStream3 = inputStream;
                        z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                        if (z2) {
                        }
                        c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                        if (c.inPreferredConfig == Config.RGB_565) {
                            c.inDither = true;
                        }
                    }
                    if (VERSION.SDK_INT < 19) {
                    }
                    booleanValue = true;
                    if (VERSION.SDK_INT >= 19) {
                        booleanValue = f3531g.contains(obj2);
                    }
                    if (booleanValue) {
                        if (i5 >= 0) {
                        }
                        if (m3034a(c)) {
                            f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                        }
                        f2 = f;
                        i3 = c.inSampleSize;
                        f3 = (float) i3;
                        i4 = (int) Math.ceil((double) (((float) i5) / f3));
                        b = (int) Math.ceil((double) (((float) i8) / f3));
                        i4 = Math.round(((float) i4) * f2);
                        b = Math.round(((float) b) * f2);
                        if (Log.isLoggable("Downsampler", 2)) {
                            stringBuilder4 = new StringBuilder("Calculated target [");
                            stringBuilder4.append(i4);
                            stringBuilder4.append("x");
                            stringBuilder4.append(b);
                            stringBuilder4.append("] for source [");
                            stringBuilder4.append(i5);
                            stringBuilder4.append("x");
                            stringBuilder4.append(i8);
                            stringBuilder4.append("], sampleSize: ");
                            stringBuilder4.append(i3);
                            stringBuilder4.append(", targetDensity: ");
                            stringBuilder4.append(c.inTargetDensity);
                            stringBuilder4.append(", density: ");
                            stringBuilder4.append(c.inDensity);
                            stringBuilder4.append(", density multiplier: ");
                            stringBuilder4.append(f2);
                            Log.v("Downsampler", stringBuilder4.toString());
                        }
                        i3 = i4;
                        bitmapPool = downsampler.f3533i;
                        if (VERSION.SDK_INT >= 26) {
                            config = null;
                        } else if (c.inPreferredConfig != Config.HARDWARE) {
                            config = c.outConfig;
                        }
                        if (config == null) {
                            config = c.inPreferredConfig;
                        }
                        c.inBitmap = bitmapPool.mo941b(i3, b, config);
                    }
                    b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                    decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        stringBuilder2 = new StringBuilder("Decoded ");
                        stringBuilder2.append(m3032a(b2));
                        stringBuilder2.append(" from [");
                        stringBuilder2.append(i5);
                        stringBuilder2.append("x");
                        stringBuilder2.append(i8);
                        stringBuilder2.append("] ");
                        stringBuilder2.append(str);
                        stringBuilder2.append(" with inBitmap ");
                        stringBuilder2.append(m3032a(c.inBitmap));
                        stringBuilder2.append(" for [");
                        stringBuilder2.append(i);
                        stringBuilder2.append("x");
                        stringBuilder2.append(i2);
                        stringBuilder2.append("], sample size: ");
                        stringBuilder2.append(c.inSampleSize);
                        stringBuilder2.append(", density: ");
                        stringBuilder2.append(c.inDensity);
                        stringBuilder2.append(", target density: ");
                        stringBuilder2.append(c.inTargetDensity);
                        stringBuilder2.append(", thread: ");
                        stringBuilder2.append(Thread.currentThread().getName());
                        stringBuilder2.append(", duration: ");
                        stringBuilder2.append(LogTime.m3212a(j));
                        Log.v("Downsampler", stringBuilder2.toString());
                    }
                    if (b2 == null) {
                        b2.setDensity(downsampler.f3534j.densityDpi);
                        bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                        if (b2.equals(bitmap)) {
                            downsampler.f3533i.mo940a(b2);
                        }
                    } else {
                        bitmap = null;
                    }
                    a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                    m3037b(c);
                    downsampler.f3535k.mo950a(obj5);
                    return a;
                }
                obj2 = imageType;
                hardwareConfigState = this.f3537m;
                if (i7 != 0) {
                    if (VERSION.SDK_INT >= 26) {
                        decodeFormat3 = decodeFormat2;
                        if (decodeFormat3 != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
                            if (!z) {
                                if (i3 >= 128) {
                                }
                                if (obj3 == null) {
                                    c.inPreferredConfig = Config.HARDWARE;
                                    c.inMutable = false;
                                }
                                if (obj3 == null) {
                                    inputStream3 = inputStream;
                                } else if (VERSION.SDK_INT == 16) {
                                    inputStream3 = inputStream;
                                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                                    if (z2) {
                                    }
                                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                                    if (c.inPreferredConfig == Config.RGB_565) {
                                        c.inDither = true;
                                    }
                                } else {
                                    inputStream3 = inputStream;
                                    c.inPreferredConfig = Config.ARGB_8888;
                                }
                                if (VERSION.SDK_INT < 19) {
                                }
                                booleanValue = true;
                                if (VERSION.SDK_INT >= 19) {
                                    booleanValue = f3531g.contains(obj2);
                                }
                                if (booleanValue) {
                                    if (i5 >= 0) {
                                    }
                                    if (m3034a(c)) {
                                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                                    }
                                    f2 = f;
                                    i3 = c.inSampleSize;
                                    f3 = (float) i3;
                                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                                    b = (int) Math.ceil((double) (((float) i8) / f3));
                                    i4 = Math.round(((float) i4) * f2);
                                    b = Math.round(((float) b) * f2);
                                    if (Log.isLoggable("Downsampler", 2)) {
                                        stringBuilder4 = new StringBuilder("Calculated target [");
                                        stringBuilder4.append(i4);
                                        stringBuilder4.append("x");
                                        stringBuilder4.append(b);
                                        stringBuilder4.append("] for source [");
                                        stringBuilder4.append(i5);
                                        stringBuilder4.append("x");
                                        stringBuilder4.append(i8);
                                        stringBuilder4.append("], sampleSize: ");
                                        stringBuilder4.append(i3);
                                        stringBuilder4.append(", targetDensity: ");
                                        stringBuilder4.append(c.inTargetDensity);
                                        stringBuilder4.append(", density: ");
                                        stringBuilder4.append(c.inDensity);
                                        stringBuilder4.append(", density multiplier: ");
                                        stringBuilder4.append(f2);
                                        Log.v("Downsampler", stringBuilder4.toString());
                                    }
                                    i3 = i4;
                                    bitmapPool = downsampler.f3533i;
                                    if (VERSION.SDK_INT >= 26) {
                                        config = null;
                                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                                        config = c.outConfig;
                                    }
                                    if (config == null) {
                                        config = c.inPreferredConfig;
                                    }
                                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                                }
                                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                                if (Log.isLoggable("Downsampler", 2)) {
                                    stringBuilder2 = new StringBuilder("Decoded ");
                                    stringBuilder2.append(m3032a(b2));
                                    stringBuilder2.append(" from [");
                                    stringBuilder2.append(i5);
                                    stringBuilder2.append("x");
                                    stringBuilder2.append(i8);
                                    stringBuilder2.append("] ");
                                    stringBuilder2.append(str);
                                    stringBuilder2.append(" with inBitmap ");
                                    stringBuilder2.append(m3032a(c.inBitmap));
                                    stringBuilder2.append(" for [");
                                    stringBuilder2.append(i);
                                    stringBuilder2.append("x");
                                    stringBuilder2.append(i2);
                                    stringBuilder2.append("], sample size: ");
                                    stringBuilder2.append(c.inSampleSize);
                                    stringBuilder2.append(", density: ");
                                    stringBuilder2.append(c.inDensity);
                                    stringBuilder2.append(", target density: ");
                                    stringBuilder2.append(c.inTargetDensity);
                                    stringBuilder2.append(", thread: ");
                                    stringBuilder2.append(Thread.currentThread().getName());
                                    stringBuilder2.append(", duration: ");
                                    stringBuilder2.append(LogTime.m3212a(j));
                                    Log.v("Downsampler", stringBuilder2.toString());
                                }
                                if (b2 == null) {
                                    bitmap = null;
                                } else {
                                    b2.setDensity(downsampler.f3534j.densityDpi);
                                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                                    if (b2.equals(bitmap)) {
                                        downsampler.f3533i.mo940a(b2);
                                    }
                                }
                                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                                m3037b(c);
                                downsampler.f3535k.mo950a(obj5);
                                return a;
                            }
                        }
                        obj3 = null;
                        if (obj3 == null) {
                            inputStream3 = inputStream;
                        } else if (VERSION.SDK_INT == 16) {
                            inputStream3 = inputStream;
                            c.inPreferredConfig = Config.ARGB_8888;
                        } else {
                            inputStream3 = inputStream;
                            z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                            if (z2) {
                            }
                            c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                            if (c.inPreferredConfig == Config.RGB_565) {
                                c.inDither = true;
                            }
                        }
                        if (VERSION.SDK_INT < 19) {
                        }
                        booleanValue = true;
                        if (VERSION.SDK_INT >= 19) {
                            booleanValue = f3531g.contains(obj2);
                        }
                        if (booleanValue) {
                            if (i5 >= 0) {
                            }
                            if (m3034a(c)) {
                                f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                            }
                            f2 = f;
                            i3 = c.inSampleSize;
                            f3 = (float) i3;
                            i4 = (int) Math.ceil((double) (((float) i5) / f3));
                            b = (int) Math.ceil((double) (((float) i8) / f3));
                            i4 = Math.round(((float) i4) * f2);
                            b = Math.round(((float) b) * f2);
                            if (Log.isLoggable("Downsampler", 2)) {
                                stringBuilder4 = new StringBuilder("Calculated target [");
                                stringBuilder4.append(i4);
                                stringBuilder4.append("x");
                                stringBuilder4.append(b);
                                stringBuilder4.append("] for source [");
                                stringBuilder4.append(i5);
                                stringBuilder4.append("x");
                                stringBuilder4.append(i8);
                                stringBuilder4.append("], sampleSize: ");
                                stringBuilder4.append(i3);
                                stringBuilder4.append(", targetDensity: ");
                                stringBuilder4.append(c.inTargetDensity);
                                stringBuilder4.append(", density: ");
                                stringBuilder4.append(c.inDensity);
                                stringBuilder4.append(", density multiplier: ");
                                stringBuilder4.append(f2);
                                Log.v("Downsampler", stringBuilder4.toString());
                            }
                            i3 = i4;
                            bitmapPool = downsampler.f3533i;
                            if (VERSION.SDK_INT >= 26) {
                                config = null;
                            } else if (c.inPreferredConfig != Config.HARDWARE) {
                                config = c.outConfig;
                            }
                            if (config == null) {
                                config = c.inPreferredConfig;
                            }
                            c.inBitmap = bitmapPool.mo941b(i3, b, config);
                        }
                        b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                        decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                        if (Log.isLoggable("Downsampler", 2)) {
                            stringBuilder2 = new StringBuilder("Decoded ");
                            stringBuilder2.append(m3032a(b2));
                            stringBuilder2.append(" from [");
                            stringBuilder2.append(i5);
                            stringBuilder2.append("x");
                            stringBuilder2.append(i8);
                            stringBuilder2.append("] ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(" with inBitmap ");
                            stringBuilder2.append(m3032a(c.inBitmap));
                            stringBuilder2.append(" for [");
                            stringBuilder2.append(i);
                            stringBuilder2.append("x");
                            stringBuilder2.append(i2);
                            stringBuilder2.append("], sample size: ");
                            stringBuilder2.append(c.inSampleSize);
                            stringBuilder2.append(", density: ");
                            stringBuilder2.append(c.inDensity);
                            stringBuilder2.append(", target density: ");
                            stringBuilder2.append(c.inTargetDensity);
                            stringBuilder2.append(", thread: ");
                            stringBuilder2.append(Thread.currentThread().getName());
                            stringBuilder2.append(", duration: ");
                            stringBuilder2.append(LogTime.m3212a(j));
                            Log.v("Downsampler", stringBuilder2.toString());
                        }
                        if (b2 == null) {
                            b2.setDensity(downsampler.f3534j.densityDpi);
                            bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                            if (b2.equals(bitmap)) {
                                downsampler.f3533i.mo940a(b2);
                            }
                        } else {
                            bitmap = null;
                        }
                        a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                        m3037b(c);
                        downsampler.f3535k.mo950a(obj5);
                        return a;
                    }
                }
                decodeFormat3 = decodeFormat2;
                obj3 = null;
                if (obj3 == null) {
                    inputStream3 = inputStream;
                } else if (VERSION.SDK_INT == 16) {
                    inputStream3 = inputStream;
                    z2 = ImageHeaderParserUtils.m2845a(downsampler.f3536l, inputStream3, downsampler.f3535k).f3334i;
                    if (z2) {
                    }
                    c.inPreferredConfig = z2 ? Config.RGB_565 : Config.ARGB_8888;
                    if (c.inPreferredConfig == Config.RGB_565) {
                        c.inDither = true;
                    }
                } else {
                    inputStream3 = inputStream;
                    c.inPreferredConfig = Config.ARGB_8888;
                }
                if (VERSION.SDK_INT < 19) {
                }
                booleanValue = true;
                if (VERSION.SDK_INT >= 19) {
                    booleanValue = f3531g.contains(obj2);
                }
                if (booleanValue) {
                    if (i5 >= 0) {
                    }
                    if (m3034a(c)) {
                        f = ((float) c.inTargetDensity) / ((float) c.inDensity);
                    }
                    f2 = f;
                    i3 = c.inSampleSize;
                    f3 = (float) i3;
                    i4 = (int) Math.ceil((double) (((float) i5) / f3));
                    b = (int) Math.ceil((double) (((float) i8) / f3));
                    i4 = Math.round(((float) i4) * f2);
                    b = Math.round(((float) b) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        stringBuilder4 = new StringBuilder("Calculated target [");
                        stringBuilder4.append(i4);
                        stringBuilder4.append("x");
                        stringBuilder4.append(b);
                        stringBuilder4.append("] for source [");
                        stringBuilder4.append(i5);
                        stringBuilder4.append("x");
                        stringBuilder4.append(i8);
                        stringBuilder4.append("], sampleSize: ");
                        stringBuilder4.append(i3);
                        stringBuilder4.append(", targetDensity: ");
                        stringBuilder4.append(c.inTargetDensity);
                        stringBuilder4.append(", density: ");
                        stringBuilder4.append(c.inDensity);
                        stringBuilder4.append(", density multiplier: ");
                        stringBuilder4.append(f2);
                        Log.v("Downsampler", stringBuilder4.toString());
                    }
                    i3 = i4;
                    bitmapPool = downsampler.f3533i;
                    if (VERSION.SDK_INT >= 26) {
                        config = null;
                    } else if (c.inPreferredConfig != Config.HARDWARE) {
                        config = c.outConfig;
                    }
                    if (config == null) {
                        config = c.inPreferredConfig;
                    }
                    c.inBitmap = bitmapPool.mo941b(i3, b, config);
                }
                b2 = m3036b(inputStream3, c, decodeCallbacks2, downsampler.f3533i);
                decodeCallbacks2.mo993a(downsampler.f3533i, b2);
                if (Log.isLoggable("Downsampler", 2)) {
                    stringBuilder2 = new StringBuilder("Decoded ");
                    stringBuilder2.append(m3032a(b2));
                    stringBuilder2.append(" from [");
                    stringBuilder2.append(i5);
                    stringBuilder2.append("x");
                    stringBuilder2.append(i8);
                    stringBuilder2.append("] ");
                    stringBuilder2.append(str);
                    stringBuilder2.append(" with inBitmap ");
                    stringBuilder2.append(m3032a(c.inBitmap));
                    stringBuilder2.append(" for [");
                    stringBuilder2.append(i);
                    stringBuilder2.append("x");
                    stringBuilder2.append(i2);
                    stringBuilder2.append("], sample size: ");
                    stringBuilder2.append(c.inSampleSize);
                    stringBuilder2.append(", density: ");
                    stringBuilder2.append(c.inDensity);
                    stringBuilder2.append(", target density: ");
                    stringBuilder2.append(c.inTargetDensity);
                    stringBuilder2.append(", thread: ");
                    stringBuilder2.append(Thread.currentThread().getName());
                    stringBuilder2.append(", duration: ");
                    stringBuilder2.append(LogTime.m3212a(j));
                    Log.v("Downsampler", stringBuilder2.toString());
                }
                if (b2 == null) {
                    bitmap = null;
                } else {
                    b2.setDensity(downsampler.f3534j.densityDpi);
                    bitmap = TransformationUtils.m3053a(downsampler.f3533i, b2, i6);
                    if (b2.equals(bitmap)) {
                        downsampler.f3533i.mo940a(b2);
                    }
                }
                a = BitmapResource.m11573a(bitmap, downsampler.f3533i);
                m3037b(c);
                downsampler.f3535k.mo950a(obj5);
                return a;
            } catch (Throwable th4) {
                e42 = th4;
                obj = obj5;
                downsampler = this;
                th2 = e42;
                m3037b(c);
                downsampler.f3535k.mo950a(obj);
                throw th2;
            }
        } catch (Throwable th5) {
            e42 = th5;
            th2 = e42;
            m3037b(c);
            downsampler.f3535k.mo950a(obj);
            throw th2;
        }
    }

    private static int m3031a(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(2.147483647E9d * d);
    }

    private static int[] m3035a(InputStream inputStream, Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        m3036b(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static android.graphics.Bitmap m3036b(java.io.InputStream r8, android.graphics.BitmapFactory.Options r9, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r10, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r11) throws java.io.IOException {
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
        r0 = r9.inJustDecodeBounds;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = 10485760; // 0xa00000 float:1.469368E-38 double:5.180654E-317;
        r8.mark(r0);
        goto L_0x000d;
    L_0x000a:
        r10.mo992a();
    L_0x000d:
        r0 = r9.outWidth;
        r1 = r9.outHeight;
        r2 = r9.outMimeType;
        r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.m3055a();
        r3.lock();
        r3 = 0;
        r4 = android.graphics.BitmapFactory.decodeStream(r8, r3, r9);	 Catch:{ IllegalArgumentException -> 0x0030 }
        r10 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.m3055a();
        r10.unlock();
        r9 = r9.inJustDecodeBounds;
        if (r9 == 0) goto L_0x002d;
    L_0x002a:
        r8.reset();
    L_0x002d:
        return r4;
    L_0x002e:
        r8 = move-exception;
        goto L_0x008e;
    L_0x0030:
        r4 = move-exception;
        r5 = new java.io.IOException;	 Catch:{ all -> 0x002e }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002e }
        r7 = "Exception decoding bitmap, outWidth: ";	 Catch:{ all -> 0x002e }
        r6.<init>(r7);	 Catch:{ all -> 0x002e }
        r6.append(r0);	 Catch:{ all -> 0x002e }
        r0 = ", outHeight: ";	 Catch:{ all -> 0x002e }
        r6.append(r0);	 Catch:{ all -> 0x002e }
        r6.append(r1);	 Catch:{ all -> 0x002e }
        r0 = ", outMimeType: ";	 Catch:{ all -> 0x002e }
        r6.append(r0);	 Catch:{ all -> 0x002e }
        r6.append(r2);	 Catch:{ all -> 0x002e }
        r0 = ", inBitmap: ";	 Catch:{ all -> 0x002e }
        r6.append(r0);	 Catch:{ all -> 0x002e }
        r0 = r9.inBitmap;	 Catch:{ all -> 0x002e }
        r0 = m3032a(r0);	 Catch:{ all -> 0x002e }
        r6.append(r0);	 Catch:{ all -> 0x002e }
        r0 = r6.toString();	 Catch:{ all -> 0x002e }
        r5.<init>(r0, r4);	 Catch:{ all -> 0x002e }
        r0 = "Downsampler";	 Catch:{ all -> 0x002e }
        r1 = 3;	 Catch:{ all -> 0x002e }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0072;	 Catch:{ all -> 0x002e }
    L_0x006b:
        r0 = "Downsampler";	 Catch:{ all -> 0x002e }
        r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use";	 Catch:{ all -> 0x002e }
        android.util.Log.d(r0, r1, r5);	 Catch:{ all -> 0x002e }
    L_0x0072:
        r0 = r9.inBitmap;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x008d;
    L_0x0076:
        r8.reset();	 Catch:{ IOException -> 0x008c }
        r0 = r9.inBitmap;	 Catch:{ IOException -> 0x008c }
        r11.mo940a(r0);	 Catch:{ IOException -> 0x008c }
        r9.inBitmap = r3;	 Catch:{ IOException -> 0x008c }
        r8 = m3036b(r8, r9, r10, r11);	 Catch:{ IOException -> 0x008c }
        r9 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.m3055a();
        r9.unlock();
        return r8;
    L_0x008c:
        throw r5;	 Catch:{ all -> 0x002e }
    L_0x008d:
        throw r5;	 Catch:{ all -> 0x002e }
    L_0x008e:
        r9 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.m3055a();
        r9.unlock();
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.b(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean m3034a(Options options) {
        return (options.inTargetDensity <= 0 || options.inDensity <= 0 || options.inTargetDensity == options.inDensity) ? null : true;
    }

    @TargetApi(19)
    private static String m3032a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        String stringBuilder;
        if (VERSION.SDK_INT >= 19) {
            StringBuilder stringBuilder2 = new StringBuilder(" (");
            stringBuilder2.append(bitmap.getAllocationByteCount());
            stringBuilder2.append(")");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "";
        }
        StringBuilder stringBuilder3 = new StringBuilder("[");
        stringBuilder3.append(bitmap.getWidth());
        stringBuilder3.append("x");
        stringBuilder3.append(bitmap.getHeight());
        stringBuilder3.append("] ");
        stringBuilder3.append(bitmap.getConfig());
        stringBuilder3.append(stringBuilder);
        return stringBuilder3.toString();
    }

    private static synchronized Options m3039c() {
        Options options;
        synchronized (Downsampler.class) {
            synchronized (f3532h) {
                options = (Options) f3532h.poll();
            }
            if (options == null) {
                options = new Options();
                m3040c(options);
            }
        }
        return options;
    }

    private static void m3037b(Options options) {
        m3040c(options);
        synchronized (f3532h) {
            f3532h.offer(options);
        }
    }

    private static void m3040c(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
