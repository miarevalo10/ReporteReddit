package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    private static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        private final File f12524a;

        public final void mo884a() {
        }

        public final void mo886b() {
        }

        ByteBufferFetcher(File file) {
            this.f12524a = file;
        }

        public final void mo885a(Priority priority, DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.mo903a(ByteBufferUtil.m3204a(this.f12524a));
            } catch (Exception e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                dataCallback.mo902a(e);
            }
        }

        public final Class<ByteBuffer> mo887c() {
            return ByteBuffer.class;
        }

        public final DataSource mo888d() {
            return DataSource.LOCAL;
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public final ModelLoader<File, ByteBuffer> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo891a(Object obj) {
        return true;
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        File file = (File) obj;
        return new LoadData(new ObjectKey(file), new ByteBufferFetcher(file));
    }
}
