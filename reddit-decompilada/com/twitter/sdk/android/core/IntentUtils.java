package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;

public class IntentUtils {
    public static boolean m25838a(Context context, Intent intent) {
        if ((context.getPackageManager().queryIntentActivities(intent, 0).isEmpty() ^ 1) == 0) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}
