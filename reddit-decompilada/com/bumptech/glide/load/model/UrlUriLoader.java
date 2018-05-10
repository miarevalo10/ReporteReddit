package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> f12576a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final ModelLoader<GlideUrl, Data> f12577b;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        public final ModelLoader<Uri, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.m3013a(GlideUrl.class, InputStream.class));
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        return this.f12577b.mo890a(new GlideUrl(((Uri) obj).toString()), i, i2, options);
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        return f12576a.contains(((Uri) obj).getScheme());
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.f12577b = modelLoader;
    }
}
