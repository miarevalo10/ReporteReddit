package com.reddit.config;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.reddit.datalibrary.frontpage.requests.images.OkHttpProgressUrlLoader.Factory;
import com.reddit.frontpage.FrontpageApplication;
import java.io.InputStream;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;

public final class RedditGlideModule extends AppGlideModule {
    @Inject
    @Named("default")
    OkHttpClient f19335a;

    public final boolean mo4179c() {
        return false;
    }

    public RedditGlideModule() {
        FrontpageApplication.f().a(this);
    }

    public final void mo3259a(Context context, GlideBuilder glideBuilder) {
        super.mo3259a(context, glideBuilder);
        glideBuilder.f3214l = new RequestOptions().mo2844a(DecodeFormat.PREFER_ARGB_8888).mo2862c();
    }

    public final void mo1006a(Context context, Glide glide, Registry registry) {
        super.mo1006a(context, glide, registry);
        registry.m2792b(GlideUrl.class, InputStream.class, new Factory(this.f19335a));
    }
}
