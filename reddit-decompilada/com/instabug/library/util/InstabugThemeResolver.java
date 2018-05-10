package com.instabug.library.util;

import com.instabug.library.C0593R;
import com.instabug.library.InstabugColorTheme;

public class InstabugThemeResolver {
    public static int resolveTheme(InstabugColorTheme instabugColorTheme) {
        if (instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight) {
            return C0593R.style.InstabugSdkTheme_Light;
        }
        return C0593R.style.InstabugSdkTheme_Dark;
    }
}
