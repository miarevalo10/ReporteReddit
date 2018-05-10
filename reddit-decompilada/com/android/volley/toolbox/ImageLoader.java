package com.android.volley.toolbox;

import android.graphics.Bitmap;

public class ImageLoader {

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }
}
