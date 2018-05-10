package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources f12644a;

    public BitmapDrawableTranscoder(Resources resources) {
        this.f12644a = (Resources) Preconditions.m3217a((Object) resources);
    }

    public final Resource<BitmapDrawable> mo1002a(Resource<Bitmap> resource, Options options) {
        return LazyBitmapDrawableResource.m11613a(this.f12644a, resource);
    }
}
