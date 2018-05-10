package android.support.v4.os;

import android.os.Build.VERSION;

public class BuildCompat {
    @Deprecated
    public static boolean m971a() {
        return VERSION.SDK_INT >= 27;
    }
}
