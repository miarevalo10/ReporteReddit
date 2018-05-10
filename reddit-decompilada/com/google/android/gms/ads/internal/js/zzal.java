package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzzv;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zzal implements zzak {
    private final zzaj f19073a;
    private final HashSet<SimpleEntry<String, zzt<? super zzaj>>> f19074b = new HashSet();

    public zzal(zzaj com_google_android_gms_ads_internal_js_zzaj) {
        this.f19073a = com_google_android_gms_ads_internal_js_zzaj;
    }

    public final void mo3933a() {
        Iterator it = this.f19074b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((zzt) simpleEntry.getValue()).toString());
            zzagf.m13278a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f19073a.mo3935b((String) simpleEntry.getKey(), (zzt) simpleEntry.getValue());
        }
        this.f19074b.clear();
    }

    public final void mo3934a(String str, zzt<? super zzaj> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj) {
        this.f19073a.mo3934a(str, com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj);
        this.f19074b.add(new SimpleEntry(str, com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj));
    }

    public final void mo3462a(String str, Map<String, ?> map) {
        this.f19073a.mo3462a(str, (Map) map);
    }

    public final void mo3463a(String str, JSONObject jSONObject) {
        this.f19073a.mo3463a(str, jSONObject);
    }

    public final void mo3935b(String str, zzt<? super zzaj> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj) {
        this.f19073a.mo3935b(str, com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj);
        this.f19074b.remove(new SimpleEntry(str, com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_ads_internal_js_zzaj));
    }

    public final void mo3465b(String str, JSONObject jSONObject) {
        this.f19073a.mo3465b(str, jSONObject);
    }
}
