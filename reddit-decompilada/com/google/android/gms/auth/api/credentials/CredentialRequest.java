package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CredentialRequest extends zzbfm {
    public static final Creator<CredentialRequest> CREATOR = new zze();
    private int zzeck;
    private final boolean zzefh;
    private final String[] zzefi;
    private final CredentialPickerConfig zzefj;
    private final CredentialPickerConfig zzefk;
    private final boolean zzefl;
    private final String zzefm;
    private final String zzefn;
    private final boolean zzefo;

    public static final class Builder {
        private boolean f5689a;
        private String[] f5690b;
        private CredentialPickerConfig f5691c;
        private CredentialPickerConfig f5692d;
        private boolean f5693e;
        private String f5694f;
        private String f5695g;
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.zzeck = i;
        this.zzefh = z;
        this.zzefi = (String[]) zzbq.m4808a((Object) strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().m4574a();
        }
        this.zzefj = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().m4574a();
        }
        this.zzefk = credentialPickerConfig2;
        if (i < 3) {
            this.zzefl = true;
            this.zzefm = null;
            this.zzefn = null;
        } else {
            this.zzefl = z2;
            this.zzefm = str;
            this.zzefn = str2;
        }
        this.zzefo = z3;
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.f5689a, builder.f5690b, builder.f5691c, builder.f5692d, builder.f5693e, builder.f5694f, builder.f5695g, false);
    }

    public final String[] getAccountTypes() {
        return this.zzefi;
    }

    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zzefi));
    }

    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzefk;
    }

    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzefj;
    }

    public final String getIdTokenNonce() {
        return this.zzefn;
    }

    public final String getServerClientId() {
        return this.zzefm;
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isIdTokenRequested() {
        return this.zzefl;
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzefh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 1, isPasswordLoginSupported());
        zzbfp.m5550a(parcel, 2, getAccountTypes());
        zzbfp.m5544a(parcel, 3, getCredentialPickerConfig(), i);
        zzbfp.m5544a(parcel, 4, getCredentialHintPickerConfig(), i);
        zzbfp.m5547a(parcel, 5, isIdTokenRequested());
        zzbfp.m5545a(parcel, 6, getServerClientId());
        zzbfp.m5545a(parcel, 7, getIdTokenNonce());
        zzbfp.m5540a(parcel, 1000, this.zzeck);
        zzbfp.m5547a(parcel, 8, this.zzefo);
        zzbfp.m5537a(parcel, a);
    }
}
