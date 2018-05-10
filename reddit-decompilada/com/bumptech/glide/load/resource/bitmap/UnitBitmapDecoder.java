package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;
import java.io.IOException;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap f12606a;

        public final void mo928d() {
        }

        NonOwnedBitmapResource(Bitmap bitmap) {
            this.f12606a = bitmap;
        }

        public final Class<Bitmap> mo925a() {
            return Bitmap.class;
        }

        public final int mo927c() {
            return Util.m3224a(this.f12606a);
        }

        public final /* bridge */ /* synthetic */ Object mo926b() {
            return this.f12606a;
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return true;
    }

    public final /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        return new NonOwnedBitmapResource((Bitmap) obj);
    }
}
