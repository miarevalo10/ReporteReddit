package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {
    private final Uri f12332a;
    private final ThumbnailStreamOpener f12333b;
    private InputStream f12334c;

    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] f12328b = new String[]{"_data"};
        private final ContentResolver f12329a;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f12329a = contentResolver;
        }

        public final Cursor mo901a(Uri uri) {
            uri = uri.getLastPathSegment();
            return this.f12329a.query(Thumbnails.EXTERNAL_CONTENT_URI, f12328b, "kind = 1 AND image_id = ?", new String[]{uri}, null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] f12330b = new String[]{"_data"};
        private final ContentResolver f12331a;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f12331a = contentResolver;
        }

        public final Cursor mo901a(Uri uri) {
            uri = uri.getLastPathSegment();
            return this.f12331a.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, f12330b, "kind = 1 AND video_id = ?", new String[]{uri}, null);
        }
    }

    public final void mo886b() {
    }

    public static ThumbFetcher m11269a(Context context, Uri uri) {
        return m11270a(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher m11271b(Context context, Uri uri) {
        return m11270a(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private static ThumbFetcher m11270a(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.m2775a(context).f3194c.m2790a(), thumbnailQuery, Glide.m2775a(context).f3195d, context.getContentResolver()));
    }

    private ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f12332a = uri;
        this.f12333b = thumbnailStreamOpener;
    }

    public final void mo884a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r0 = r1.f12334c;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.f12334c;	 Catch:{ IOException -> 0x000a }
        r0.close();	 Catch:{ IOException -> 0x000a }
        return;
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbFetcher.a():void");
    }

    public final Class<InputStream> mo887c() {
        return InputStream.class;
    }

    public final DataSource mo888d() {
        return DataSource.LOCAL;
    }

    public final void mo885a(Priority priority, DataCallback<? super InputStream> dataCallback) {
        try {
            priority = this.f12333b.m2880b(this.f12332a);
            int a = priority != null ? this.f12333b.m2879a(this.f12332a) : -1;
            if (a != -1) {
                priority = new ExifOrientationStream(priority, a);
            }
            this.f12334c = priority;
            dataCallback.mo903a(this.f12334c);
        } catch (Exception e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dataCallback.mo902a(e);
        }
    }
}
