package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        public final boolean f3334i;

        private ImageType(boolean z) {
            this.f3334i = z;
        }
    }

    int mo987a(InputStream inputStream, ArrayPool arrayPool) throws IOException;

    ImageType mo988a(InputStream inputStream) throws IOException;

    ImageType mo989a(ByteBuffer byteBuffer) throws IOException;
}
