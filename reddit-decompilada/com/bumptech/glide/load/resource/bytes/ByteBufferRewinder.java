package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
    private final ByteBuffer f12615a;

    public static class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<ByteBuffer> {
        public final /* synthetic */ DataRewinder mo896a(Object obj) {
            return new ByteBufferRewinder((ByteBuffer) obj);
        }

        public final Class<ByteBuffer> mo897a() {
            return ByteBuffer.class;
        }
    }

    public final void mo899b() {
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f12615a = byteBuffer;
    }

    public final /* synthetic */ Object mo898a() throws IOException {
        this.f12615a.position(0);
        return this.f12615a;
    }
}
