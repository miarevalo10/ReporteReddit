package com.instabug.library.util;

import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.settings.SettingsManager;

public class PlaceHolderUtils {
    public static String getPlaceHolder(Key key, String str) {
        InstabugCustomTextPlaceHolder customPlaceHolders = SettingsManager.getInstance().getCustomPlaceHolders();
        if (customPlaceHolders == null) {
            return str;
        }
        key = customPlaceHolders.get(key);
        return (key == null || key.trim().equals("")) ? str : key;
    }
}
