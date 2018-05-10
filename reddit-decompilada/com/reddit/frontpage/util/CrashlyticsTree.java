package com.reddit.frontpage.util;

import com.crashlytics.android.Crashlytics;
import timber.log.Timber.Tree;

public class CrashlyticsTree extends Tree {
    protected final boolean m30429a(int i) {
        return i == 6;
    }

    protected final void m30428a(int i, String str, String str2, Throwable th) {
        Crashlytics.setInt("priority", i);
        Crashlytics.setString("tag", str);
        Crashlytics.setString("message", str2);
        if (th == null) {
            Crashlytics.logException(new Exception("EXCEPTION_DEFAULT"));
        } else {
            Crashlytics.logException(th);
        }
    }
}
