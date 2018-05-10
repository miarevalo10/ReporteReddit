package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    private static final Config f12480a = Config.ARGB_8888;
    private final LruPoolStrategy f12481b;
    private final Set<Config> f12482c;
    private final long f12483d;
    private final BitmapTracker f12484e;
    private long f12485f;
    private long f12486g;
    private int f12487h;
    private int f12488i;
    private int f12489j;
    private int f12490k;

    private interface BitmapTracker {
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }
    }

    private LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Config> set) {
        this.f12483d = j;
        this.f12485f = j;
        this.f12481b = lruPoolStrategy;
        this.f12482c = set;
        this.f12484e = new NullBitmapTracker();
    }

    public final synchronized void mo940a(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        } else {
            StringBuilder stringBuilder;
            if (bitmap.isMutable() && ((long) this.f12481b.mo936c(bitmap)) <= this.f12485f) {
                if (this.f12482c.contains(bitmap.getConfig())) {
                    int c = this.f12481b.mo936c(bitmap);
                    this.f12481b.mo933a(bitmap);
                    this.f12489j++;
                    this.f12486g += (long) c;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        stringBuilder = new StringBuilder("Put bitmap in pool=");
                        stringBuilder.append(this.f12481b.mo935b(bitmap));
                        Log.v("LruBitmapPool", stringBuilder.toString());
                    }
                    m11401b();
                    m11400a(this.f12485f);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                stringBuilder = new StringBuilder("Reject bitmap from pool, bitmap: ");
                stringBuilder.append(this.f12481b.mo935b(bitmap));
                stringBuilder.append(", is mutable: ");
                stringBuilder.append(bitmap.isMutable());
                stringBuilder.append(", is allowed config: ");
                stringBuilder.append(this.f12482c.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", stringBuilder.toString());
            }
            bitmap.recycle();
        }
    }

    public final Bitmap mo937a(int i, int i2, Config config) {
        Bitmap d = m11404d(i, i2, config);
        if (d == null) {
            return m11402c(i, i2, config);
        }
        d.eraseColor(0);
        return d;
    }

    public final Bitmap mo941b(int i, int i2, Config config) {
        Bitmap d = m11404d(i, i2, config);
        return d == null ? m11402c(i, i2, config) : d;
    }

    private static Bitmap m11402c(int i, int i2, Config config) {
        if (config == null) {
            config = f12480a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public final void mo938a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m11400a(0);
    }

    @SuppressLint({"InlinedApi"})
    public final void mo939a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            StringBuilder stringBuilder = new StringBuilder("trimMemory, level=");
            stringBuilder.append(i);
            Log.d("LruBitmapPool", stringBuilder.toString());
        }
        if (i >= 40) {
            mo938a();
            return;
        }
        if (i >= 20) {
            m11400a(this.f12485f / 2);
        }
    }

    private synchronized void m11400a(long j) {
        while (this.f12486g > j) {
            Bitmap a = this.f12481b.mo931a();
            if (a == null) {
                if (Log.isLoggable("LruBitmapPool", 5) != null) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m11403c();
                }
                this.f12486g = 0;
                return;
            }
            this.f12486g -= (long) this.f12481b.mo936c(a);
            this.f12490k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder stringBuilder = new StringBuilder("Evicting bitmap=");
                stringBuilder.append(this.f12481b.mo935b(a));
                Log.d("LruBitmapPool", stringBuilder.toString());
            }
            m11401b();
            a.recycle();
        }
    }

    private void m11401b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m11403c();
        }
    }

    private void m11403c() {
        StringBuilder stringBuilder = new StringBuilder("Hits=");
        stringBuilder.append(this.f12487h);
        stringBuilder.append(", misses=");
        stringBuilder.append(this.f12488i);
        stringBuilder.append(", puts=");
        stringBuilder.append(this.f12489j);
        stringBuilder.append(", evictions=");
        stringBuilder.append(this.f12490k);
        stringBuilder.append(", currentSize=");
        stringBuilder.append(this.f12486g);
        stringBuilder.append(", maxSize=");
        stringBuilder.append(this.f12485f);
        stringBuilder.append("\nStrategy=");
        stringBuilder.append(this.f12481b);
        Log.v("LruBitmapPool", stringBuilder.toString());
    }

    public LruBitmapPool(long j) {
        LruPoolStrategy sizeConfigStrategy;
        if (VERSION.SDK_INT >= 19) {
            sizeConfigStrategy = new SizeConfigStrategy();
        } else {
            sizeConfigStrategy = new AttributeStrategy();
        }
        Set hashSet = new HashSet(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        this(j, sizeConfigStrategy, Collections.unmodifiableSet(hashSet));
    }

    private synchronized Bitmap m11404d(int i, int i2, Config config) {
        Bitmap a;
        if (VERSION.SDK_INT < 26 || config != Config.HARDWARE) {
            a = this.f12481b.mo932a(i, i2, config != null ? config : f12480a);
            if (a == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder stringBuilder = new StringBuilder("Missing bitmap=");
                    stringBuilder.append(this.f12481b.mo934b(i, i2, config));
                    Log.d("LruBitmapPool", stringBuilder.toString());
                }
                this.f12488i++;
            } else {
                this.f12487h++;
                this.f12486g -= (long) this.f12481b.mo936c(a);
                a.setHasAlpha(true);
                if (VERSION.SDK_INT >= 19) {
                    a.setPremultiplied(true);
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder stringBuilder2 = new StringBuilder("Get bitmap=");
                stringBuilder2.append(this.f12481b.mo934b(i, i2, config));
                Log.v("LruBitmapPool", stringBuilder2.toString());
            }
            m11401b();
        } else {
            i2 = new StringBuilder("Cannot create a mutable Bitmap with config: ");
            i2.append(config);
            i2.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            throw new IllegalArgumentException(i2.toString());
        }
        return a;
    }
}
