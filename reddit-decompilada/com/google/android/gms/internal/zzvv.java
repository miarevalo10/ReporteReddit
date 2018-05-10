package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzzv
public final class zzvv implements NativeMediationAdRequest {
    private final Date f18320a;
    private final int f18321b;
    private final Set<String> f18322c;
    private final boolean f18323d;
    private final Location f18324e;
    private final int f18325f;
    private final zzpe f18326g;
    private final List<String> f18327h = new ArrayList();
    private final boolean f18328i;
    private final Map<String, Boolean> f18329j = new HashMap();

    public zzvv(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzpe com_google_android_gms_internal_zzpe, List<String> list, boolean z2) {
        this.f18320a = date;
        this.f18321b = i;
        this.f18322c = set;
        this.f18324e = location;
        this.f18323d = z;
        this.f18325f = i2;
        this.f18326g = com_google_android_gms_internal_zzpe;
        this.f18328i = z2;
        String str = "custom:";
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith(str)) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        Map map;
                        Object obj;
                        Object valueOf;
                        if ("true".equals(split[2])) {
                            map = this.f18329j;
                            obj = split[1];
                            valueOf = Boolean.valueOf(true);
                        } else if ("false".equals(split[2])) {
                            map = this.f18329j;
                            obj = split[1];
                            valueOf = Boolean.valueOf(false);
                        }
                        map.put(obj, valueOf);
                    }
                } else {
                    this.f18327h.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzly.m6467a().m6468b();
    }

    public final Date getBirthday() {
        return this.f18320a;
    }

    public final int getGender() {
        return this.f18321b;
    }

    public final Set<String> getKeywords() {
        return this.f18322c;
    }

    public final Location getLocation() {
        return this.f18324e;
    }

    public final boolean isAdMuted() {
        return zzly.m6467a().m6469c();
    }

    public final boolean isAppInstallAdRequested() {
        return this.f18327h != null && this.f18327h.contains("2");
    }

    public final boolean isContentAdRequested() {
        return this.f18327h != null && this.f18327h.contains("1");
    }

    public final boolean isDesignedForFamilies() {
        return this.f18328i;
    }

    public final boolean isTesting() {
        return this.f18323d;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f18325f;
    }

    public final boolean zzmo() {
        return this.f18327h != null && this.f18327h.contains("3");
    }

    public final Map<String, Boolean> zzmp() {
        return this.f18329j;
    }

    public final NativeAdOptions getNativeAdOptions() {
        if (this.f18326g == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.f5395a = this.f18326g.f18239b;
        builder.f5396b = this.f18326g.f18240c;
        builder.f5397c = this.f18326g.f18241d;
        if (this.f18326g.f18238a >= 2) {
            builder.f5399e = this.f18326g.f18242e;
        }
        if (this.f18326g.f18238a >= 3 && this.f18326g.f18243f != null) {
            builder.f5398d = new VideoOptions(this.f18326g.f18243f);
        }
        return builder.m4406c();
    }
}
