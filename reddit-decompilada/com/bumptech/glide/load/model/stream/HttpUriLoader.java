package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpUriLoader implements ModelLoader<Uri, InputStream> {
    private static final Set<String> f12581a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final ModelLoader<GlideUrl, InputStream> f12582b;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        public final ModelLoader<Uri, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.m3013a(GlideUrl.class, InputStream.class));
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        return this.f12582b.mo890a(new GlideUrl(((Uri) obj).toString()), i, i2, options);
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        return f12581a.contains(((Uri) obj).getScheme());
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f12582b = modelLoader;
    }
}
