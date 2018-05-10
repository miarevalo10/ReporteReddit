package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    private final Converter<Data> f12523a;

    public interface Converter<Data> {
        Class<Data> mo967a();

        Data mo968a(byte[] bArr);
    }

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {

        class C10711 implements Converter<ByteBuffer> {
            final /* synthetic */ ByteBufferFactory f12519a;

            C10711(ByteBufferFactory byteBufferFactory) {
                this.f12519a = byteBufferFactory;
            }

            public final Class<ByteBuffer> mo967a() {
                return ByteBuffer.class;
            }

            public final /* synthetic */ Object mo968a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        public final ModelLoader<byte[], ByteBuffer> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new C10711(this));
        }
    }

    private static class Fetcher<Data> implements DataFetcher<Data> {
        private final byte[] f12520a;
        private final Converter<Data> f12521b;

        public final void mo884a() {
        }

        public final void mo886b() {
        }

        Fetcher(byte[] bArr, Converter<Data> converter) {
            this.f12520a = bArr;
            this.f12521b = converter;
        }

        public final void mo885a(Priority priority, DataCallback<? super Data> dataCallback) {
            dataCallback.mo903a(this.f12521b.mo968a(this.f12520a));
        }

        public final Class<Data> mo887c() {
            return this.f12521b.mo967a();
        }

        public final DataSource mo888d() {
            return DataSource.LOCAL;
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {

        class C10721 implements Converter<InputStream> {
            final /* synthetic */ StreamFactory f12522a;

            C10721(StreamFactory streamFactory) {
                this.f12522a = streamFactory;
            }

            public final Class<InputStream> mo967a() {
                return InputStream.class;
            }

            public final /* synthetic */ Object mo968a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        public final ModelLoader<byte[], InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new C10721(this));
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo891a(Object obj) {
        return true;
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        byte[] bArr = (byte[]) obj;
        return new LoadData(new ObjectKey(bArr), new Fetcher(bArr, this.f12523a));
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.f12523a = converter;
    }
}
