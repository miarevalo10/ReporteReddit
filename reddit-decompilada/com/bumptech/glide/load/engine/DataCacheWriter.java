package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import java.io.File;

class DataCacheWriter<DataType> implements Writer {
    private final Encoder<DataType> f12346a;
    private final DataType f12347b;
    private final Options f12348c;

    DataCacheWriter(Encoder<DataType> encoder, DataType dataType, Options options) {
        this.f12346a = encoder;
        this.f12347b = dataType;
        this.f12348c = options;
    }

    public final boolean mo906a(File file) {
        return this.f12346a.mo969a(this.f12347b, file, this.f12348c);
    }
}
