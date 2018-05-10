package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> f12589a;
    private final Resources f12590b;

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f12590b = (Resources) Preconditions.m3217a((Object) resources);
        this.f12589a = (ResourceDecoder) Preconditions.m3217a((Object) resourceDecoder);
    }

    public final boolean mo980a(DataType dataType, Options options) throws IOException {
        return this.f12589a.mo980a(dataType, options);
    }

    public final Resource<BitmapDrawable> mo979a(DataType dataType, int i, int i2, Options options) throws IOException {
        return LazyBitmapDrawableResource.m11613a(this.f12590b, this.f12589a.mo979a(dataType, i, i2, options));
    }
}
