package com.instabug.survey.p029c;

import java.util.Locale;

/* compiled from: LocaleHelper */
public class C0794c {
    public static boolean m8410a() {
        byte directionality = Character.getDirectionality(Locale.getDefault().getDisplayName().charAt(0));
        if (directionality != (byte) 1) {
            if (directionality != (byte) 2) {
                return false;
            }
        }
        return true;
    }
}
