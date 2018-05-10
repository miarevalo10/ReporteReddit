package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> f17198a = new HashMap();

    public final Object m17560a(String str) {
        return this.f17198a.get(str);
    }
}
