package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzlt zzals;

    public static final class Builder {
        private final zzlu f5393a = new zzlu();

        public final PublisherAdRequest m4393a() {
            return new PublisherAdRequest();
        }

        public final Builder m4392a(String str, String str2) {
            this.f5393a.f7798d.putString(str, str2);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzals = new zzlt(builder.f5393a);
    }

    public static void updateCorrelator() {
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzals.m6437c(cls);
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzals.m6434a((Class) cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzals.m6436b(cls);
    }

    public final boolean isTestDevice(Context context) {
        return this.zzals.m6435a(context);
    }

    public final zzlt zzbg() {
        return this.zzals;
    }

    public final Date getBirthday() {
        return this.zzals.f7779a;
    }

    public final String getContentUrl() {
        return this.zzals.f7780b;
    }

    public final int getGender() {
        return this.zzals.f7781c;
    }

    public final Set<String> getKeywords() {
        return this.zzals.f7782d;
    }

    public final Location getLocation() {
        return this.zzals.f7783e;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzals.f7784f;
    }

    public final String getPublisherProvidedId() {
        return this.zzals.f7787i;
    }

    public final Bundle getCustomTargeting() {
        return this.zzals.f7791m;
    }
}
