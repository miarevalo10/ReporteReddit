package com.reddit.datalibrary.frontpage.requests.images;

import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class OkHttpProgressUrlLoader extends OkHttpUrlLoader {
    private final okhttp3.Call.Factory f18807a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private final okhttp3.Call.Factory f16345a;

        public Factory(okhttp3.Call.Factory factory) {
            this.f16345a = factory;
        }

        public final ModelLoader<GlideUrl, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpProgressUrlLoader(this.f16345a);
        }
    }

    public final /* bridge */ /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        return mo3809a((GlideUrl) obj);
    }

    public OkHttpProgressUrlLoader(okhttp3.Call.Factory factory) {
        super(factory);
        this.f18807a = factory;
    }

    public final LoadData<InputStream> mo3809a(GlideUrl glideUrl) {
        return new LoadData(glideUrl, new OkHttpProgressStreamFetcher(this.f18807a, glideUrl));
    }
}
