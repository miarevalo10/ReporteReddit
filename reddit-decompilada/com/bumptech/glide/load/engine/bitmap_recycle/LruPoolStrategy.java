package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

interface LruPoolStrategy {
    Bitmap mo931a();

    Bitmap mo932a(int i, int i2, Config config);

    void mo933a(Bitmap bitmap);

    String mo934b(int i, int i2, Config config);

    String mo935b(Bitmap bitmap);

    int mo936c(Bitmap bitmap);
}
