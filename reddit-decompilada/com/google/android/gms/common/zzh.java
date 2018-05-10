package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzh extends zzau {
    private int f17354a;

    protected zzh(byte[] bArr) {
        if (bArr.length != 25) {
            boolean z = false;
            int length = bArr.length;
            String a = zzl.m4905a(bArr, bArr.length);
            StringBuilder stringBuilder = new StringBuilder(51 + String.valueOf(a).length());
            stringBuilder.append("Cert hash data has incorrect length (");
            stringBuilder.append(length);
            stringBuilder.append("):\n");
            stringBuilder.append(a);
            Log.wtf("GoogleCertificates", stringBuilder.toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            if (bArr.length == 25) {
                z = true;
            }
            int length2 = bArr.length;
            StringBuilder stringBuilder2 = new StringBuilder(55);
            stringBuilder2.append("cert hash data has incorrect length. length=");
            stringBuilder2.append(length2);
            zzbq.m4818b(z, stringBuilder2.toString());
        }
        this.f17354a = Arrays.hashCode(bArr);
    }

    protected static byte[] m17687a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final IObjectWrapper mo1626a() {
        return zzn.m17692a(mo3961c());
    }

    public final int mo1627b() {
        return hashCode();
    }

    abstract byte[] mo3961c();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzat)) {
            return false;
        }
        try {
            zzat com_google_android_gms_common_internal_zzat = (zzat) obj;
            if (com_google_android_gms_common_internal_zzat.mo1627b() != hashCode()) {
                return false;
            }
            IObjectWrapper a = com_google_android_gms_common_internal_zzat.mo1626a();
            if (a == null) {
                return false;
            }
            return Arrays.equals(mo3961c(), (byte[]) zzn.m17693a(a));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    public int hashCode() {
        return this.f17354a;
    }
}
