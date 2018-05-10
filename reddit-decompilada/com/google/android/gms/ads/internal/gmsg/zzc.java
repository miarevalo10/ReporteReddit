package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zzzv;
import java.util.Map;

@zzzv
public final class zzc implements zzt<zzanh> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        String str = (String) map.get("action");
        String str2;
        if ("tick".equals(str)) {
            str = (String) map.get("label");
            Object obj2 = (String) map.get("start_label");
            str2 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str)) {
                zzakb.m5371e("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str2)) {
                zzakb.m5371e("No timestamp given for CSI tick.");
            } else {
                try {
                    long b = zzbs.m4492k().mo1633b() + (Long.parseLong(str2) - zzbs.m4492k().mo1632a());
                    if (TextUtils.isEmpty(obj2) != null) {
                        obj2 = "native:view_load";
                    }
                    obj = com_google_android_gms_internal_zzanh.mo3471j();
                    map = obj.f7941b;
                    zzns com_google_android_gms_internal_zzns = (zzns) obj.f7940a.get(obj2);
                    String[] strArr = new String[]{str};
                    if (map != null) {
                        if (com_google_android_gms_internal_zzns != null) {
                            map.m6505a(com_google_android_gms_internal_zzns, b, strArr);
                        }
                    }
                    map = obj.f7940a;
                    obj = obj.f7941b;
                    map.put(str, obj == null ? null : obj.m6503a(b));
                } catch (Object obj3) {
                    zzakb.m5369c("Malformed timestamp for CSI tick.", obj3);
                }
            }
        } else if ("experiment".equals(str)) {
            str2 = (String) map.get("value");
            if (TextUtils.isEmpty(str2)) {
                zzakb.m5371e("No value given for CSI experiment.");
                return;
            }
            obj3 = com_google_android_gms_internal_zzanh.mo3471j().f7941b;
            if (obj3 == null) {
                zzakb.m5371e("No ticker for WebView, dropping experiment ID.");
            } else {
                obj3.m6504a("e", str2);
            }
        } else {
            if ("extra".equals(str)) {
                str = (String) map.get("name");
                str2 = (String) map.get("value");
                if (TextUtils.isEmpty(str2)) {
                    zzakb.m5371e("No value given for CSI extra.");
                } else if (TextUtils.isEmpty(str)) {
                    zzakb.m5371e("No name given for CSI extra.");
                } else {
                    obj3 = com_google_android_gms_internal_zzanh.mo3471j().f7941b;
                    if (obj3 == null) {
                        zzakb.m5371e("No ticker for WebView, dropping extra parameter.");
                        return;
                    }
                    obj3.m6504a(str, str2);
                }
            }
        }
    }
}
