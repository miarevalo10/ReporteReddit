package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.OkHttpClient;

public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    private final okhttp3.Call.Factory f12310a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static volatile okhttp3.Call.Factory f12308a;
        private final okhttp3.Call.Factory f12309b;

        private static okhttp3.Call.Factory m11228a() {
            if (f12308a == null) {
                synchronized (Factory.class) {
                    if (f12308a == null) {
                        f12308a = new OkHttpClient();
                    }
                }
            }
            return f12308a;
        }

        public Factory() {
            this(m11228a());
        }

        private Factory(okhttp3.Call.Factory factory) {
            this.f12309b = factory;
        }

        public final ModelLoader<GlideUrl, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.f12309b);
        }
    }

    public /* bridge */ /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        return mo3809a((GlideUrl) obj);
    }

    public OkHttpUrlLoader(okhttp3.Call.Factory factory) {
        this.f12310a = factory;
    }

    public LoadData<InputStream> mo3809a(GlideUrl glideUrl) {
        return new LoadData(glideUrl, new OkHttpStreamFetcher(this.f12310a, glideUrl));
    }
}
