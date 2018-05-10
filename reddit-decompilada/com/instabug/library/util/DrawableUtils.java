package com.instabug.library.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

public class DrawableUtils {
    public static void setColor(View view, int i) {
        view = view.getBackground();
        if (view instanceof ShapeDrawable) {
            ((ShapeDrawable) view).getPaint().setColor(i);
        } else if (view instanceof GradientDrawable) {
            ((GradientDrawable) view).setColor(i);
        } else {
            if (view instanceof ColorDrawable) {
                ((ColorDrawable) view).setColor(i);
            }
        }
    }
}
