package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;

class ResourceRequestHandler extends RequestHandler {
    private final Context f30671a;

    ResourceRequestHandler(Context context) {
        this.f30671a = context;
    }

    public final boolean mo5445a(Request request) {
        if (request.resourceId != 0) {
            return true;
        }
        return "android.resource".equals(request.uri.getScheme());
    }

    public final Result mo5446b(Request request) throws IOException {
        Resources a = Utils.m25815a(this.f30671a, request);
        int a2 = Utils.m25812a(a, request);
        Options d = RequestHandler.m25795d(request);
        if (RequestHandler.m25794a(d)) {
            BitmapFactory.decodeResource(a, a2, d);
            RequestHandler.m25793a(request.targetWidth, request.targetHeight, d, request);
        }
        return new Result(BitmapFactory.decodeResource(a, a2, d), LoadedFrom.DISK);
    }
}
