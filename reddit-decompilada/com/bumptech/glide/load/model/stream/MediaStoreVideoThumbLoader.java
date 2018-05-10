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
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context f12586a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context f12585a;

        public Factory(Context context) {
            this.f12585a = context;
        }

        public final ModelLoader<Uri, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f12585a);
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        if (MediaStoreUtil.m2872a(i, i2) != 0) {
            Long l = (Long) options.m11235a(VideoDecoder.f12609a);
            i = (l == null || l.longValue() != -1) ? 0 : 1;
            if (i != 0) {
                return new LoadData(new ObjectKey(uri), ThumbFetcher.m11271b(this.f12586a, uri));
            }
        }
        return null;
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        return MediaStoreUtil.m2874b((Uri) obj);
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f12586a = context.getApplicationContext();
    }
}
