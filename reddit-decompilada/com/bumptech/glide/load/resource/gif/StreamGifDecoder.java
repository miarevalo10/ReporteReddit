package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private final List<ImageHeaderParser> f12639a;
    private final ResourceDecoder<ByteBuffer, GifDrawable> f12640b;
    private final ArrayPool f12641c;

    public final /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        obj = m11679a((InputStream) obj);
        if (obj == null) {
            return null;
        }
        return this.f12640b.mo979a(ByteBuffer.wrap(obj), i, i2, options);
    }

    public final /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return (((Boolean) options.m11235a(GifOptions.f3574b)).booleanValue() == null && ImageHeaderParserUtils.m2845a(this.f12639a, (InputStream) obj, this.f12641c) == ImageType.GIF) ? true : null;
    }

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f12639a = list;
        this.f12640b = resourceDecoder;
        this.f12641c = arrayPool;
    }

    private static byte[] m11679a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (InputStream inputStream2) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", inputStream2);
            }
            return null;
        }
    }
}
