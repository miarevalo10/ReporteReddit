package com.instabug.library.util;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;

public class Colorizer {
    public static Drawable getPrimaryColorTintedDrawable(Drawable drawable) {
        return getTintedDrawable(Instabug.getPrimaryColor(), drawable);
    }

    public static Drawable getTintedDrawable(int i, Drawable drawable) {
        drawable.clearColorFilter();
        drawable.setColorFilter(i, Mode.SRC_IN);
        return drawable;
    }

    public static void applyPrimaryColorTint(ImageView imageView) {
        applyTint(Instabug.getPrimaryColor(), imageView);
    }

    public static void applyTint(int i, ImageView imageView) {
        imageView.clearColorFilter();
        imageView.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_IN));
    }

    public static ColorFilter getPrimaryColorFilter() {
        return new PorterDuffColorFilter(SettingsManager.getInstance().getPrimaryColor(), Mode.SRC_IN);
    }
}
