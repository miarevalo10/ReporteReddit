package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    Resource<Z> mo979a(T t, int i, int i2, Options options) throws IOException;

    boolean mo980a(T t, Options options) throws IOException;
}
