package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private final RecyclableBufferedInputStream f12324a;

    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<InputStream> {
        private final ArrayPool f12323a;

        public final /* synthetic */ DataRewinder mo896a(Object obj) {
            return new InputStreamRewinder((InputStream) obj, this.f12323a);
        }

        public Factory(ArrayPool arrayPool) {
            this.f12323a = arrayPool;
        }

        public final Class<InputStream> mo897a() {
            return InputStream.class;
        }
    }

    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        this.f12324a = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f12324a.mark(5242880);
    }

    public final void mo899b() {
        this.f12324a.m3049b();
    }

    public final /* synthetic */ Object mo898a() throws IOException {
        this.f12324a.reset();
        return this.f12324a;
    }
}
