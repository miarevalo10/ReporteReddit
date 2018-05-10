package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader implements ModelLoader<URL, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> f12587a;

    public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
        public final ModelLoader<URL, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.m3013a(GlideUrl.class, InputStream.class));
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo891a(Object obj) {
        return true;
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        return this.f12587a.mo890a(new GlideUrl((URL) obj), i, i2, options);
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f12587a = modelLoader;
    }
}
