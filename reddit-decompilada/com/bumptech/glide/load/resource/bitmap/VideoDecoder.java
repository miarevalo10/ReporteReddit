package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Option.CacheKeyUpdater;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final Option<Long> f12609a = Option.m2852a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new C10791());
    public static final Option<Integer> f12610b = Option.m2852a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new C10802());
    private static final MediaMetadataRetrieverFactory f12611c = new MediaMetadataRetrieverFactory();
    private final MediaMetadataRetrieverInitializer<T> f12612d;
    private final BitmapPool f12613e;
    private final MediaMetadataRetrieverFactory f12614f;

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public static MediaMetadataRetriever m3063a() {
            return new MediaMetadataRetriever();
        }
    }

    interface MediaMetadataRetrieverInitializer<T> {
        void mo994a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    class C10791 implements CacheKeyUpdater<Long> {
        private final ByteBuffer f12607a = ByteBuffer.allocate(8);

        C10791() {
        }

        public final /* synthetic */ void mo892a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Long l = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.f12607a) {
                this.f12607a.position(0);
                messageDigest.update(this.f12607a.putLong(l.longValue()).array());
            }
        }
    }

    class C10802 implements CacheKeyUpdater<Integer> {
        private final ByteBuffer f12608a = ByteBuffer.allocate(4);

        C10802() {
        }

        public final /* synthetic */ void mo892a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Integer num = (Integer) obj;
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f12608a) {
                    this.f12608a.position(0);
                    messageDigest.update(this.f12608a.putInt(num.intValue()).array());
                }
            }
        }
    }

    private static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        public final /* synthetic */ void mo994a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        public final /* synthetic */ void mo994a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
        }
    }

    public final boolean mo980a(T t, Options options) {
        return true;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> m11636a(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> m11637b(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    private VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, f12611c);
    }

    private VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.f12613e = bitmapPool;
        this.f12612d = mediaMetadataRetrieverInitializer;
        this.f12614f = mediaMetadataRetrieverFactory;
    }

    public final Resource<Bitmap> mo979a(T t, int i, int i2, Options options) throws IOException {
        long longValue = ((Long) options.m11235a(f12609a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            options = (Integer) options.m11235a(f12610b);
            if (options == null) {
                options = Integer.valueOf(2);
            }
            MediaMetadataRetriever a = MediaMetadataRetrieverFactory.m3063a();
            try {
                this.f12612d.mo994a(a, t);
                int intValue = options.intValue();
                if (VERSION.SDK_INT < 27 || i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    t = a.getFrameAtTime(longValue, intValue);
                } else {
                    t = a.getScaledFrameAtTime(longValue, intValue, i, i2);
                }
                a.release();
                return BitmapResource.m11573a(t, this.f12613e);
            } catch (T t2) {
                throw new IOException(t2);
            } catch (Throwable th) {
                a.release();
            }
        } else {
            i = new StringBuilder("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            i.append(longValue);
            throw new IllegalArgumentException(i.toString());
        }
    }
}
