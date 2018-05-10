package com.reddit.frontpage.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.reddit.data.events.models.AnalyticsPlatform;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.vendor.CustomTabsHelper;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u000e\u0010\u001f\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fXD¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/util/Platform;", "Lcom/reddit/data/events/models/AnalyticsPlatform;", "()V", "appInstallTime", "", "getAppInstallTime", "()Ljava/lang/Long;", "appVersionCode", "", "getAppVersionCode", "()I", "appVersionName", "", "getAppVersionName", "()Ljava/lang/String;", "browserName", "getBrowserName", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "deviceId", "getDeviceId", "deviceName", "getDeviceName", "osName", "getOsName", "osVersion", "getOsVersion", "platformName", "getPlatformName", "platformNamePhone", "platformNameTablet", "returnBrowserName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Platform.kt */
public final class Platform implements AnalyticsPlatform {
    public static final Platform f29397a = new Platform();
    private static final String f29398b = "android_tablet";
    private static final String f29399c = "android_phone";
    private static final String f29400d;
    private static final String f29401e;
    private static final String f29402f = "android";
    private static final String f29403g;
    private static final String f29404h = "3.1.2";
    private static final int f29405i = 209200;
    private static final String f29406j;

    static {
        String str;
        Object obj = FrontpageApplication.f27402a;
        Intrinsics.m26843a(obj, "FrontpageApplication.instance");
        obj = ((Context) obj).getResources().getConfiguration();
        Intrinsics.m26843a(obj, "resources.configuration");
        if ((obj.screenLayout & 15) >= 3) {
            str = f29398b;
        } else {
            str = f29399c;
        }
        f29400d = str;
        obj = Build.MODEL;
        Intrinsics.m26843a(obj, "Build.MODEL");
        f29401e = obj;
        obj = VERSION.RELEASE;
        Intrinsics.m26843a(obj, "Build.VERSION.RELEASE");
        f29403g = obj;
        str = CustomTabsHelper.m21971a(FrontpageApplication.f27402a);
        if (str == null) {
            str = "web_view_fallback";
        } else {
            Regex regex = new Regex("[^a-z0-9_-]");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            obj = str.toLowerCase();
            Intrinsics.m26843a(obj, "(this as java.lang.String).toLowerCase()");
            str = regex.m28146a((CharSequence) obj, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        }
        f29406j = str;
    }

    private Platform() {
    }

    public final String getPlatformName() {
        return f29400d;
    }

    public final String getDeviceId() {
        Object obj = Config.g;
        Intrinsics.m26843a(obj, "Config.deviceId");
        return obj;
    }

    public final String getDeviceName() {
        return f29401e;
    }

    public final String getOsName() {
        return f29402f;
    }

    public final String getOsVersion() {
        return f29403g;
    }

    public final String getAppVersionName() {
        return f29404h;
    }

    public final int getAppVersionCode() {
        return f29405i;
    }

    public final Long getAppInstallTime() {
        return Config.n;
    }

    public final String getBrowserName() {
        return f29406j;
    }
}
