package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
    private final CompressFormat f12642a;
    private final int f12643b;

    public BitmapBytesTranscoder() {
        this(CompressFormat.JPEG);
    }

    private BitmapBytesTranscoder(CompressFormat compressFormat) {
        this.f12642a = compressFormat;
        this.f12643b = 100;
    }

    public final Resource<byte[]> mo1002a(Resource<Bitmap> resource, Options options) {
        options = new ByteArrayOutputStream();
        ((Bitmap) resource.mo926b()).compress(this.f12642a, this.f12643b, options);
        resource.mo928d();
        return new BytesResource(options.toByteArray());
    }
}
