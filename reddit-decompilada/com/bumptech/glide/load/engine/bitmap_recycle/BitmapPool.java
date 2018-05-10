package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public interface BitmapPool {
    Bitmap mo937a(int i, int i2, Config config);

    void mo938a();

    void mo939a(int i);

    void mo940a(Bitmap bitmap);

    Bitmap mo941b(int i, int i2, Config config);
}
