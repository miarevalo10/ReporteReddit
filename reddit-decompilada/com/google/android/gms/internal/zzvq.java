package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzzv
public final class zzvq implements MediationAdRequest {
    private final Date f14688a;
    private final int f14689b;
    private final Set<String> f14690c;
    private final boolean f14691d;
    private final Location f14692e;
    private final int f14693f;
    private final boolean f14694g;

    public zzvq(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.f14688a = date;
        this.f14689b = i;
        this.f14690c = set;
        this.f14692e = location;
        this.f14691d = z;
        this.f14693f = i2;
        this.f14694g = z2;
    }

    public final Date getBirthday() {
        return this.f14688a;
    }

    public final int getGender() {
        return this.f14689b;
    }

    public final Set<String> getKeywords() {
        return this.f14690c;
    }

    public final Location getLocation() {
        return this.f14692e;
    }

    public final boolean isDesignedForFamilies() {
        return this.f14694g;
    }

    public final boolean isTesting() {
        return this.f14691d;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.f14693f;
    }
}
