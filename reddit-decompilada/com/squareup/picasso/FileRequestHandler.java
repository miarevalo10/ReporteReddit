package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;

class FileRequestHandler extends ContentStreamRequestHandler {
    FileRequestHandler(Context context) {
        super(context);
    }

    public final boolean mo5445a(Request request) {
        return "file".equals(request.uri.getScheme());
    }

    public final Result mo5446b(Request request) throws IOException {
        InputStream c = m31683c(request);
        LoadedFrom loadedFrom = LoadedFrom.DISK;
        request = new ExifInterface(request.uri.getPath()).getAttributeInt("Orientation", 1);
        request = request != 3 ? request != 6 ? request != 8 ? null : SubsamplingScaleImageView.ORIENTATION_270 : 90 : 180;
        return new Result(null, c, loadedFrom, request);
    }
}
