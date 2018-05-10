package com.instabug.library.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.Locale;

public class LocaleUtils {
    public static void setLocale(Activity activity, Locale locale) {
        Configuration configuration = activity.getApplicationContext().getResources().getConfiguration();
        if (VERSION.SDK_INT >= 24) {
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            updateResources(activity, locale);
        } else if (VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        activity.getResources().updateConfiguration(configuration, activity.getResources().getDisplayMetrics());
    }

    @TargetApi(24)
    private static Context updateResources(Context context, Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    public static String getLocaleStringResource(Locale locale, int i, Context context) {
        if (VERSION.SDK_INT >= 17) {
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration).getText(i).toString();
        }
        context = context.getResources();
        configuration = context.getConfiguration();
        Locale locale2 = configuration.locale;
        configuration.locale = locale;
        context.updateConfiguration(configuration, null);
        i = context.getString(i);
        configuration.locale = locale2;
        context.updateConfiguration(configuration, null);
        return i;
    }

    public static boolean isRTL(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
        } else {
            locale = Character.getDirectionality(locale.getDisplayName().charAt(0));
            if (locale != 1) {
                if (locale != 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
