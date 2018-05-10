package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> f3656a = new ConcurrentHashMap();

    public static Key m3202a(Context context) {
        String packageName = context.getPackageName();
        Key key = (Key) f3656a.get(packageName);
        if (key != null) {
            return key;
        }
        context = m3203b(context);
        if (context != null) {
            context = String.valueOf(context.versionCode);
        } else {
            context = UUID.randomUUID().toString();
        }
        key = new ObjectKey(context);
        Key key2 = (Key) f3656a.putIfAbsent(packageName, key);
        return key2 == null ? key : key2;
    }

    private static PackageInfo m3203b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Cannot resolve info for");
            stringBuilder.append(context.getPackageName());
            Log.e("AppVersionSignature", stringBuilder.toString(), e);
            return null;
        }
    }
}
