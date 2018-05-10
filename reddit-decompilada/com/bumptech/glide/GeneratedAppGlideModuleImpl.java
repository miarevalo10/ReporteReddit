package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.reddit.config.RedditGlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final RedditGlideModule f19482a = new RedditGlideModule();

    public final boolean mo4179c() {
        return false;
    }

    GeneratedAppGlideModuleImpl() {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.reddit.config.RedditGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    public final void mo3259a(Context context, GlideBuilder glideBuilder) {
        this.f19482a.mo3259a(context, glideBuilder);
    }

    public final void mo1006a(Context context, Glide glide, Registry registry) {
        new OkHttpLibraryGlideModule().mo1006a(context, glide, registry);
        this.f19482a.mo1006a(context, glide, registry);
    }

    public final Set<Class<?>> mo4230a() {
        return Collections.emptySet();
    }

    final /* synthetic */ RequestManagerFactory mo4231b() {
        return new GeneratedRequestManagerFactory();
    }
}
