package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;

class NetworkRequestHandler extends RequestHandler {
    private final Downloader f30668a;
    private final Stats f30669b;

    static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }

    final int mo5456a() {
        return 2;
    }

    final boolean mo5458b() {
        return true;
    }

    public NetworkRequestHandler(Downloader downloader, Stats stats) {
        this.f30668a = downloader;
        this.f30669b = stats;
    }

    public final boolean mo5445a(Request request) {
        request = request.uri.getScheme();
        if (!"http".equals(request)) {
            if ("https".equals(request) == null) {
                return null;
            }
        }
        return true;
    }

    public final Result mo5446b(Request request) throws IOException {
        request = this.f30668a.mo5459a(request.uri, request.networkPolicy);
        LoadedFrom loadedFrom = request.f23778c ? LoadedFrom.DISK : LoadedFrom.NETWORK;
        Bitmap bitmap = request.f23777b;
        if (bitmap != null) {
            return new Result(bitmap, loadedFrom);
        }
        InputStream inputStream = request.f23776a;
        if (inputStream == null) {
            return null;
        }
        if (loadedFrom == LoadedFrom.DISK && request.f23779d == 0) {
            Utils.m25824a(inputStream);
            throw new ContentLengthException("Received response with 0 content-length header.");
        }
        if (loadedFrom == LoadedFrom.NETWORK && request.f23779d > 0) {
            Stats stats = this.f30669b;
            stats.f23890c.sendMessage(stats.f23890c.obtainMessage(4, Long.valueOf(request.f23779d)));
        }
        return new Result(inputStream, loadedFrom);
    }

    final boolean mo5457a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (networkInfo.isConnected() == null) {
                return null;
            }
        }
        return true;
    }
}
