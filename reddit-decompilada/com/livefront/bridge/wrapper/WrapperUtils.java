package com.livefront.bridge.wrapper;

import android.graphics.Bitmap;
import android.os.Bundle;

public class WrapperUtils {
    public static void m8491a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (bundle.get(str) instanceof BitmapWrapper) {
                bundle.putParcelable(str, ((BitmapWrapper) bundle.get(str)).f10034a);
            }
        }
    }

    public static void m8492b(Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (bundle.get(str) instanceof Bitmap) {
                bundle.putParcelable(str, new BitmapWrapper((Bitmap) bundle.get(str)));
            }
        }
    }
}
