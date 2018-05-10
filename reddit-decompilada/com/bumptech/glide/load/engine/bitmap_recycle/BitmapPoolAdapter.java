package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class BitmapPoolAdapter implements BitmapPool {
    public final void mo938a() {
    }

    public final void mo939a(int i) {
    }

    public void mo940a(Bitmap bitmap) {
        bitmap.recycle();
    }

    public final Bitmap mo937a(int i, int i2, Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public final Bitmap mo941b(int i, int i2, Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }
}
