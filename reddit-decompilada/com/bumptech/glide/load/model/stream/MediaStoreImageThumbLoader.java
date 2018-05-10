package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context f12584a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context f12583a;

        public Factory(Context context) {
            this.f12583a = context;
        }

        public final ModelLoader<Uri, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.f12583a);
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        return MediaStoreUtil.m2872a(i, i2) != 0 ? new LoadData(new ObjectKey(uri), ThumbFetcher.m11269a(this.f12584a, uri)) : null;
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        return MediaStoreUtil.m2875c((Uri) obj);
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f12584a = context.getApplicationContext();
    }
}
