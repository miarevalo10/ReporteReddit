package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public interface ImageRegionDecoder {
    Bitmap mo1109a(Rect rect, int i);

    Point mo1110a(Context context, Uri uri) throws Exception;

    boolean mo1111a();

    void mo1112b();
}
