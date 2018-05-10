package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;

class AssetRequestHandler extends RequestHandler {
    private static final int f30662a = 22;
    private final AssetManager f30663b;

    public AssetRequestHandler(Context context) {
        this.f30663b = context.getAssets();
    }

    public final boolean mo5445a(Request request) {
        request = request.uri;
        if (!"file".equals(request.getScheme()) || request.getPathSegments().isEmpty() || "android_asset".equals(request.getPathSegments().get(0)) == null) {
            return false;
        }
        return true;
    }

    public final Result mo5446b(Request request) throws IOException {
        return new Result(this.f30663b.open(request.uri.toString().substring(f30662a)), LoadedFrom.DISK);
    }
}
