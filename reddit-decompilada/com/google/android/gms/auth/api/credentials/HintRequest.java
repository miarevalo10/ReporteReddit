package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class HintRequest extends zzbfm implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR = new zzh();
    private int zzeck;
    private final String[] zzefi;
    private final boolean zzefl;
    private final String zzefm;
    private final String zzefn;
    private final CredentialPickerConfig zzefp;
    private final boolean zzefq;
    private final boolean zzefr;

    public static final class Builder {
        private boolean f5696a;
        private boolean f5697b;
        private String[] f5698c;
        private CredentialPickerConfig f5699d;
        private boolean f5700e;
        private String f5701f;
        private String f5702g;
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.zzeck = i;
        this.zzefp = (CredentialPickerConfig) zzbq.m4808a((Object) credentialPickerConfig);
        this.zzefq = z;
        this.zzefr = z2;
        this.zzefi = (String[]) zzbq.m4808a((Object) strArr);
        if (this.zzeck < 2) {
            this.zzefl = true;
            this.zzefm = null;
            this.zzefn = null;
            return;
        }
        this.zzefl = z3;
        this.zzefm = str;
        this.zzefn = str2;
    }

    private HintRequest(Builder builder) {
        this(2, builder.f5699d, builder.f5696a, builder.f5697b, builder.f5698c, builder.f5700e, builder.f5701f, builder.f5702g);
    }

    public final String[] getAccountTypes() {
        return this.zzefi;
    }

    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzefp;
    }

    public final String getIdTokenNonce() {
        return this.zzefn;
    }

    public final String getServerClientId() {
        return this.zzefm;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzefq;
    }

    public final boolean isIdTokenRequested() {
        return this.zzefl;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 1, getHintPickerConfig(), i);
        zzbfp.m5547a(parcel, 2, isEmailAddressIdentifierSupported());
        zzbfp.m5547a(parcel, 3, this.zzefr);
        zzbfp.m5550a(parcel, 4, getAccountTypes());
        zzbfp.m5547a(parcel, 5, isIdTokenRequested());
        zzbfp.m5545a(parcel, 6, getServerClientId());
        zzbfp.m5545a(parcel, 7, getIdTokenNonce());
        zzbfp.m5540a(parcel, 1000, this.zzeck);
        zzbfp.m5537a(parcel, a);
    }
}
