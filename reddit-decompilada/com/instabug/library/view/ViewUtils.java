package com.instabug.library.view;

import android.content.Context;
import android.util.TypedValue;

public class ViewUtils {
    public static int convertDpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
