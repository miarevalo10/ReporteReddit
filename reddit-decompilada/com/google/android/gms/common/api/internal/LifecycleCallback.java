package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    protected final zzcf f5764a;

    protected LifecycleCallback(zzcf com_google_android_gms_common_api_internal_zzcf) {
        this.f5764a = com_google_android_gms_common_api_internal_zzcf;
    }

    public static zzcf m4679a(Activity activity) {
        return m4680a(new zzce(activity));
    }

    @Keep
    private static zzcf getChimeraLifecycleFragmentImpl(zzce com_google_android_gms_common_api_internal_zzce) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public final Activity m4681a() {
        return this.f5764a.mo1608a();
    }

    public void mo1613a(int i, int i2, Intent intent) {
    }

    public void mo1614a(Bundle bundle) {
    }

    public void mo3420a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void mo1615b() {
    }

    public void mo1616b(Bundle bundle) {
    }

    public void mo3411c() {
    }

    public void mo1617d() {
    }

    protected static zzcf m4680a(zzce com_google_android_gms_common_api_internal_zzce) {
        if (com_google_android_gms_common_api_internal_zzce.f5806a instanceof FragmentActivity) {
            return zzdb.m17654a((FragmentActivity) com_google_android_gms_common_api_internal_zzce.f5806a);
        }
        if (com_google_android_gms_common_api_internal_zzce.f5806a instanceof Activity) {
            return zzcg.m13007a((Activity) com_google_android_gms_common_api_internal_zzce.f5806a);
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
