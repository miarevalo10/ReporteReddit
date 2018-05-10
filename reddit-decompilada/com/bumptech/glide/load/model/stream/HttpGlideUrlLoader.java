package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public static final Option<Integer> f12579a = Option.m2851a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    private final ModelCache<GlideUrl, GlideUrl> f12580b;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private final ModelCache<GlideUrl, GlideUrl> f12578a = new ModelCache(500);

        public final ModelLoader<GlideUrl, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f12578a);
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo891a(Object obj) {
        return true;
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        obj = (GlideUrl) obj;
        if (this.f12580b != 0) {
            GlideUrl glideUrl = (GlideUrl) this.f12580b.get(obj, 0, 0);
            if (glideUrl == null) {
                this.f12580b.put(obj, 0, 0, obj);
            } else {
                obj = glideUrl;
            }
        }
        return new LoadData(obj, new HttpUrlFetcher(obj, ((Integer) options.m11235a(f12579a)).intValue()));
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.f12580b = modelCache;
    }
}
