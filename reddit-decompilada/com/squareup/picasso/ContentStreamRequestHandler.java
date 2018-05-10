package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class ContentStreamRequestHandler extends RequestHandler {
    final Context f30666a;

    ContentStreamRequestHandler(Context context) {
        this.f30666a = context;
    }

    public boolean mo5445a(Request request) {
        return "content".equals(request.uri.getScheme());
    }

    public Result mo5446b(Request request) throws IOException {
        return new Result(m31683c(request), LoadedFrom.DISK);
    }

    final InputStream m31683c(Request request) throws FileNotFoundException {
        return this.f30666a.getContentResolver().openInputStream(request.uri);
    }
}
