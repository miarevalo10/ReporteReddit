package com.google.android.gms.internal;

import android.provider.Settings.SettingNotFoundException;
import java.lang.reflect.InvocationTargetException;

public final class zzdx extends zzet {
    public zzdx(zzdm com_google_android_gms_internal_zzdm, String str, String str2, zzaz com_google_android_gms_internal_zzaz, int i) {
        super(com_google_android_gms_internal_zzdm, str, str2, com_google_android_gms_internal_zzaz, i, 49);
    }

    protected final void mo1870a() throws IllegalAccessException, InvocationTargetException {
        this.b.f17622F = Integer.valueOf(2);
        try {
            boolean booleanValue = ((Boolean) this.c.invoke(null, new Object[]{this.a.m5845a()})).booleanValue();
            this.b.f17622F = Integer.valueOf(booleanValue);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
