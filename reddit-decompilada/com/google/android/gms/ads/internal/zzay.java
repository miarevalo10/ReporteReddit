package com.google.android.gms.ads.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzade;
import com.google.android.gms.internal.zzael;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzva;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzay implements Runnable {
    private /* synthetic */ zzax f5509a;

    zzay(zzax com_google_android_gms_ads_internal_zzax) {
        this.f5509a = com_google_android_gms_ads_internal_zzax;
    }

    public final void run() {
        Object a = this.f5509a.f5508b.f17181a;
        Runnable runnable = this.f5509a.f5507a;
        zzbq.m4816b("Adapters must be initialized on the main thread.");
        Map map = zzbs.m4490i().m13267o().f6339b;
        if (map != null) {
            if (!map.isEmpty()) {
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        zzakb.m5369c("Could not initialize rewarded ads.", th);
                        return;
                    }
                }
                zzade E = zzade.m20932E();
                if (E != null) {
                    Collection<zzui> values = map.values();
                    Map hashMap = new HashMap();
                    IObjectWrapper a2 = zzn.m17692a(a);
                    for (zzui com_google_android_gms_internal_zzui : values) {
                        for (zzuh com_google_android_gms_internal_zzuh : com_google_android_gms_internal_zzui.f8065a) {
                            String str = com_google_android_gms_internal_zzuh.f8055j;
                            for (String str2 : com_google_android_gms_internal_zzuh.f8048c) {
                                if (!hashMap.containsKey(str2)) {
                                    hashMap.put(str2, new ArrayList());
                                }
                                if (str != null) {
                                    ((Collection) hashMap.get(str2)).add(str);
                                }
                            }
                        }
                    }
                    for (Entry entry : hashMap.entrySet()) {
                        String str3 = (String) entry.getKey();
                        try {
                            zzael b = E.mo4271b(str3);
                            if (b != null) {
                                zzva com_google_android_gms_internal_zzva = b.f6253a;
                                if (!com_google_android_gms_internal_zzva.mo2187g()) {
                                    if (com_google_android_gms_internal_zzva.mo2193m()) {
                                        com_google_android_gms_internal_zzva.mo2172a(a2, b.f6254b, (List) entry.getValue());
                                        String str4 = "Initialized rewarded video mediation adapter ";
                                        String valueOf = String.valueOf(str3);
                                        zzakb.m5366b(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            StringBuilder stringBuilder = new StringBuilder(56 + String.valueOf(str3).length());
                            stringBuilder.append("Failed to initialize rewarded video mediation adapter \"");
                            stringBuilder.append(str3);
                            stringBuilder.append("\"");
                            zzakb.m5369c(stringBuilder.toString(), th2);
                        }
                    }
                }
            }
        }
    }
}
