package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@zzzv
public abstract class zzyk<T extends zzzb> implements zzzb<T> {
    private final HashMap<String, List<zzt<? super T>>> f14749a = new HashMap();

    public void mo2292a(String str, zzt<? super T> com_google_android_gms_ads_internal_gmsg_zzt__super_T) {
        List list = (List) this.f14749a.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.f14749a.put(str, list);
        }
        list.add(com_google_android_gms_ads_internal_gmsg_zzt__super_T);
    }

    public void mo2293b(String str, zzt<? super T> com_google_android_gms_ads_internal_gmsg_zzt__super_T) {
        List list = (List) this.f14749a.get(str);
        if (list != null) {
            list.remove(com_google_android_gms_ads_internal_gmsg_zzt__super_T);
        }
    }
}
