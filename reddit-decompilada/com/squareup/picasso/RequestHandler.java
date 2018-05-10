package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import java.io.InputStream;

public abstract class RequestHandler {

    public static final class Result {
        final LoadedFrom f23881a;
        final Bitmap f23882b;
        final InputStream f23883c;
        final int f23884d;

        public Result(Bitmap bitmap, LoadedFrom loadedFrom) {
            this((Bitmap) Utils.m25818a((Object) bitmap, "bitmap == null"), null, loadedFrom, 0);
        }

        public Result(InputStream inputStream, LoadedFrom loadedFrom) {
            this(null, (InputStream) Utils.m25818a((Object) inputStream, "stream == null"), loadedFrom, 0);
        }

        Result(Bitmap bitmap, InputStream inputStream, LoadedFrom loadedFrom, int i) {
            int i2 = 0;
            int i3 = bitmap != null ? 1 : 0;
            if (inputStream != null) {
                i2 = 1;
            }
            if ((i2 ^ i3) == 0) {
                throw new AssertionError();
            }
            this.f23882b = bitmap;
            this.f23883c = inputStream;
            this.f23881a = (LoadedFrom) Utils.m25818a((Object) loadedFrom, "loadedFrom == null");
            this.f23884d = i;
        }
    }

    int mo5456a() {
        return 0;
    }

    boolean mo5457a(NetworkInfo networkInfo) {
        return false;
    }

    public abstract boolean mo5445a(Request request);

    public abstract Result mo5446b(Request request) throws IOException;

    boolean mo5458b() {
        return false;
    }

    static Options m25795d(Request request) {
        boolean hasSize = request.hasSize();
        Object obj = request.config != null ? 1 : null;
        Options options = null;
        if (hasSize || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = hasSize;
            if (obj != null) {
                options.inPreferredConfig = request.config;
            }
        }
        return options;
    }

    static boolean m25794a(Options options) {
        return (options == null || options.inJustDecodeBounds == null) ? null : true;
    }

    static void m25793a(int i, int i2, Options options, Request request) {
        m25792a(i, i2, options.outWidth, options.outHeight, options, request);
    }

    static void m25792a(int i, int i2, int i3, int i4, Options options, Request request) {
        if (i4 <= i2) {
            if (i3 <= i) {
                i = 1;
                options.inSampleSize = i;
                options.inJustDecodeBounds = false;
            }
        }
        if (i2 == 0) {
            i = (int) Math.floor((double) (((float) i3) / ((float) i)));
        } else if (i == 0) {
            i = (int) Math.floor((double) (((float) i4) / ((float) i2)));
        } else {
            i2 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            i = (int) Math.floor((double) (((float) i3) / ((float) i)));
            i = request.centerInside != 0 ? Math.max(i2, i) : Math.min(i2, i);
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
    }
}
