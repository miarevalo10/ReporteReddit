package android.support.v4.util;

import android.os.Build.VERSION;
import java.util.Objects;

public class ObjectsCompat {
    public static boolean m1037a(Object obj, Object obj2) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }
}
