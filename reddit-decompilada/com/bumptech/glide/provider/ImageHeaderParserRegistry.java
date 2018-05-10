package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> f3602a = new ArrayList();

    public final synchronized List<ImageHeaderParser> m3110a() {
        return this.f3602a;
    }

    public final synchronized void m3111a(ImageHeaderParser imageHeaderParser) {
        this.f3602a.add(imageHeaderParser);
    }
}
