package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzdpz {
    private static final CopyOnWriteArrayList<zzdpy> f7242a = new CopyOnWriteArrayList();

    public static zzdpy m5864a(String str) throws GeneralSecurityException {
        Iterator it = f7242a.iterator();
        while (it.hasNext()) {
            zzdpy com_google_android_gms_internal_zzdpy = (zzdpy) it.next();
            if (com_google_android_gms_internal_zzdpy.m5862a()) {
                return com_google_android_gms_internal_zzdpy;
            }
        }
        String str2 = "No KMS client does support: ";
        str = String.valueOf(str);
        throw new GeneralSecurityException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }
}
