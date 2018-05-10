package com.reddit.frontpage.util;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.reddit.frontpage.FrontpageApplication;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/util/ScreenUtil;", "", "()V", "isOrientationLocked", "", "isOrientationLocked$annotations", "()Z", "hideKeyboard", "", "activity", "Landroid/app/Activity;", "isScreenLocked", "keepScreenOff", "keepScreenOn", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ScreenUtil.kt */
public final class ScreenUtil {
    public static final ScreenUtil f21789a = new ScreenUtil();

    private ScreenUtil() {
    }

    public static final boolean m23889a() {
        Object obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        return System.getInt(obj.getContentResolver(), "accelerometer_rotation", 1) == 0;
    }

    public static final void m23888a(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        Object systemService = activity.getSystemService("input_method");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static final void m23890b(Activity activity) {
        if (activity != null) {
            activity = activity.getWindow();
            if (activity != null) {
                activity.addFlags(128);
            }
        }
    }

    public static final void m23891c(Activity activity) {
        if (activity != null) {
            activity = activity.getWindow();
            if (activity != null) {
                activity.clearFlags(128);
            }
        }
    }
}
