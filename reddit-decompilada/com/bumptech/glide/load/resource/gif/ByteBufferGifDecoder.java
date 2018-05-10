package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory f12619a = new GifDecoderFactory();
    private static final GifHeaderParserPool f12620b = new GifHeaderParserPool();
    private final Context f12621c;
    private final List<ImageHeaderParser> f12622d;
    private final GifHeaderParserPool f12623e;
    private final GifDecoderFactory f12624f;
    private final GifBitmapProvider f12625g;

    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        static GifDecoder m3067a(BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> f3555a = Util.m3229a(0);

        GifHeaderParserPool() {
        }

        final synchronized GifHeaderParser m3068a(ByteBuffer byteBuffer) {
            GifHeaderParser gifHeaderParser;
            gifHeaderParser = (GifHeaderParser) this.f3555a.poll();
            if (gifHeaderParser == null) {
                gifHeaderParser = new GifHeaderParser();
            }
            gifHeaderParser.f3306b = null;
            Arrays.fill(gifHeaderParser.f3305a, (byte) 0);
            gifHeaderParser.f3307c = new GifHeader();
            gifHeaderParser.f3308d = 0;
            gifHeaderParser.f3306b = byteBuffer.asReadOnlyBuffer();
            gifHeaderParser.f3306b.position(0);
            gifHeaderParser.f3306b.order(ByteOrder.LITTLE_ENDIAN);
            return gifHeaderParser;
        }

        final synchronized void m3069a(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.f3306b = null;
            gifHeaderParser.f3307c = null;
            this.f3555a.offer(gifHeaderParser);
        }
    }

    public final /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return (((Boolean) options.m11235a(GifOptions.f3574b)).booleanValue() == null && ImageHeaderParserUtils.m2846a(this.f12622d, (ByteBuffer) obj) == ImageType.GIF) ? true : null;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f12620b, f12619a);
    }

    private ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f12621c = context.getApplicationContext();
        this.f12622d = list;
        this.f12624f = gifDecoderFactory;
        this.f12625g = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f12623e = gifHeaderParserPool;
    }

    private GifDrawableResource m11661a(ByteBuffer byteBuffer, int i, int i2, Options options) {
        GifHeaderParser a = this.f12623e.m3068a(byteBuffer);
        try {
            byteBuffer = m11660a(byteBuffer, i, i2, a, options);
            return byteBuffer;
        } finally {
            this.f12623e.m3069a(a);
        }
    }

    private GifDrawableResource m11660a(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        StringBuilder stringBuilder;
        ByteBufferGifDecoder byteBufferGifDecoder = this;
        int i3 = i;
        int i4 = i2;
        GifHeaderParser gifHeaderParser2 = gifHeaderParser;
        long a = LogTime.m3213a();
        try {
            if (gifHeaderParser2.f3306b == null) {
                throw new IllegalStateException("You must call setData() before parseHeader()");
            }
            StringBuilder stringBuilder2;
            if (!gifHeaderParser.m2840c()) {
                gifHeaderParser.m2839b();
                if (!gifHeaderParser.m2840c()) {
                    gifHeaderParser.m2838a();
                    if (gifHeaderParser2.f3307c.f3294c < 0) {
                        gifHeaderParser2.f3307c.f3293b = 1;
                    }
                }
            }
            GifHeader gifHeader = gifHeaderParser2.f3307c;
            if (gifHeader.f3294c > 0) {
                if (gifHeader.f3293b == 0) {
                    Config config;
                    if (options.m11235a(GifOptions.f3573a) == DecodeFormat.PREFER_RGB_565) {
                        config = Config.RGB_565;
                    } else {
                        config = Config.ARGB_8888;
                    }
                    int min = Math.min(gifHeader.f3298g / i4, gifHeader.f3297f / i3);
                    if (min == 0) {
                        min = 0;
                    } else {
                        min = Integer.highestOneBit(min);
                    }
                    min = Math.max(1, min);
                    if (Log.isLoggable("BufferGifDecoder", 2) && min > 1) {
                        StringBuilder stringBuilder3 = new StringBuilder("Downsampling GIF, sampleSize: ");
                        stringBuilder3.append(min);
                        stringBuilder3.append(", target dimens: [");
                        stringBuilder3.append(i3);
                        stringBuilder3.append("x");
                        stringBuilder3.append(i4);
                        stringBuilder3.append("], actual dimens: [");
                        stringBuilder3.append(gifHeader.f3297f);
                        stringBuilder3.append("x");
                        stringBuilder3.append(gifHeader.f3298g);
                        stringBuilder3.append("]");
                        Log.v("BufferGifDecoder", stringBuilder3.toString());
                    }
                    GifDecoder a2 = GifDecoderFactory.m3067a(byteBufferGifDecoder.f12625g, gifHeader, byteBuffer, min);
                    a2.mo875a(config);
                    a2.mo876b();
                    Bitmap h = a2.mo882h();
                    if (h == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            stringBuilder2 = new StringBuilder("Decoded GIF from stream in ");
                            stringBuilder2.append(LogTime.m3212a(a));
                            Log.v("BufferGifDecoder", stringBuilder2.toString());
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(byteBufferGifDecoder.f12621c, a2, UnitTransformation.m17011a(), i3, i4, h));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        stringBuilder = new StringBuilder("Decoded GIF from stream in ");
                        stringBuilder.append(LogTime.m3212a(a));
                        Log.v("BufferGifDecoder", stringBuilder.toString());
                    }
                    return gifDrawableResource;
                }
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                stringBuilder2 = new StringBuilder("Decoded GIF from stream in ");
                stringBuilder2.append(LogTime.m3212a(a));
                Log.v("BufferGifDecoder", stringBuilder2.toString());
            }
            return null;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                stringBuilder = new StringBuilder("Decoded GIF from stream in ");
                stringBuilder.append(LogTime.m3212a(a));
                Log.v("BufferGifDecoder", stringBuilder.toString());
            }
        }
    }
}
