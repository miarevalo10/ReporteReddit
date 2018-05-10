package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    private static final UnitTranscoder<?> f12648a = new UnitTranscoder();

    public final Resource<Z> mo1002a(Resource<Z> resource, Options options) {
        return resource;
    }

    public static <Z> ResourceTranscoder<Z, Z> m11686a() {
        return f12648a;
    }
}
