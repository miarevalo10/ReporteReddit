package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface Downloader {

    public static class Response {
        final InputStream f23776a;
        final Bitmap f23777b;
        final boolean f23778c;
        final long f23779d;

        public Response(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f23776a = inputStream;
            this.f23777b = null;
            this.f23778c = z;
            this.f23779d = j;
        }
    }

    public static class ResponseException extends IOException {
        final boolean f23780a;
        final int f23781b;

        public ResponseException(String str, int i, int i2) {
            super(str);
            this.f23780a = NetworkPolicy.m25772c(i);
            this.f23781b = i2;
        }
    }

    Response mo5459a(Uri uri, int i) throws IOException;
}
