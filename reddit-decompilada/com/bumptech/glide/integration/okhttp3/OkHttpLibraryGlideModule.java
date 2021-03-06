package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader.Factory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;

public final class OkHttpLibraryGlideModule extends LibraryGlideModule {
    public final void mo1006a(Context context, Glide glide, Registry registry) {
        registry.m2792b(GlideUrl.class, InputStream.class, new Factory());
    }
}
