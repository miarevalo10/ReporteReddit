package android.support.v4.text;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
    private static final Locale f1373a = new Locale("", "");

    public static int m998a(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (!(locale == null || locale.equals(f1373a))) {
            String a = ICUCompat.m992a(locale);
            if (a == null) {
                switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                    case 1:
                    case 2:
                        return 1;
                    default:
                        return 0;
                }
            } else if (!(a.equalsIgnoreCase("Arab") == null && a.equalsIgnoreCase("Hebr") == null)) {
                return 1;
            }
        }
        return 0;
    }
}
