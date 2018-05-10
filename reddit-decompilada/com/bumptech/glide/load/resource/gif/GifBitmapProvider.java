package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements BitmapProvider {
    private final BitmapPool f12626a;
    private final ArrayPool f12627b;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f12626a = bitmapPool;
        this.f12627b = arrayPool;
    }

    public final Bitmap mo995a(int i, int i2, Config config) {
        return this.f12626a.mo941b(i, i2, config);
    }

    public final void mo996a(Bitmap bitmap) {
        this.f12626a.mo940a(bitmap);
    }

    public final byte[] mo999a(int i) {
        if (this.f12627b == null) {
            return new byte[i];
        }
        return (byte[]) this.f12627b.mo946a(i, byte[].class);
    }

    public final void mo997a(byte[] bArr) {
        if (this.f12627b != null) {
            this.f12627b.mo950a((Object) bArr);
        }
    }

    public final int[] mo1000b(int i) {
        if (this.f12627b == null) {
            return new int[i];
        }
        return (int[]) this.f12627b.mo946a(i, int[].class);
    }

    public final void mo998a(int[] iArr) {
        if (this.f12627b != null) {
            this.f12627b.mo950a((Object) iArr);
        }
    }
}
