package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;

public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    public final Resource<byte[]> mo1002a(Resource<GifDrawable> resource, Options options) {
        return new BytesResource(ByteBufferUtil.m3206a(((GifDrawable) resource.mo926b()).m11675b()));
    }
}
