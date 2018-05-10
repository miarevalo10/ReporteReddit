package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final Downsampler f12604a;
    private final ArrayPool f12605b;

    static class UntrustedCallbacks implements DecodeCallbacks {
        private final RecyclableBufferedInputStream f12602a;
        private final ExceptionCatchingInputStream f12603b;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f12602a = recyclableBufferedInputStream;
            this.f12603b = exceptionCatchingInputStream;
        }

        public final void mo992a() {
            this.f12602a.m3048a();
        }

        public final void mo993a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException iOException = this.f12603b.f3666a;
            if (iOException != null) {
                if (bitmap != null) {
                    bitmapPool.mo940a(bitmap);
                }
                throw iOException;
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f12604a = downsampler;
        this.f12605b = arrayPool;
    }

    private Resource<Bitmap> m11623a(InputStream inputStream, int i, int i2, Options options) throws IOException {
        Object obj;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            inputStream = (RecyclableBufferedInputStream) inputStream;
            obj = null;
        } else {
            InputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f12605b);
            obj = 1;
            inputStream = recyclableBufferedInputStream;
        }
        InputStream a = ExceptionCatchingInputStream.m3210a(inputStream);
        try {
            i = this.f12604a.m3041a(new MarkEnforcingInputStream(a), i, i2, options, new UntrustedCallbacks(inputStream, a));
            return i;
        } finally {
            a.m3211a();
            if (obj != null) {
                inputStream.m3049b();
            }
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return Downsampler.m3033a();
    }
}
