package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.internal.zzaur;
import com.google.android.gms.internal.zzaus;
import com.google.android.gms.internal.zzaut;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.internal.zzavy;
import com.google.android.gms.internal.zzawx;

public final class Auth {
    public static final zzf<zzavy> f5672a = new zzf();
    public static final zzf<zzd> f5673b = new zzf();
    public static final Api<zzf> f5674c = zzd.f5728a;
    public static final Api<AuthCredentialsOptions> f5675d = new Api("Auth.CREDENTIALS_API", f5681j, f5672a);
    public static final Api<GoogleSignInOptions> f5676e = new Api("Auth.GOOGLE_SIGN_IN_API", f5683l, f5673b);
    public static final ProxyApi f5677f = new zzawx();
    public static final CredentialsApi f5678g = new zzavp();
    public static final GoogleSignInApi f5679h = new zzc();
    private static zzf<zzaut> f5680i = new zzf();
    private static final zza<zzavy, AuthCredentialsOptions> f5681j = new zza();
    private static final zza<zzaut, Object> f5682k = new zzb();
    private static final zza<zzd, GoogleSignInOptions> f5683l = new zzc();
    private static Api<Object> f5684m = new Api("Auth.ACCOUNT_STATUS_API", f5682k, f5680i);
    private static zzaur f5685n = new zzaus();

    @Deprecated
    public static class AuthCredentialsOptions implements Optional {
        private static AuthCredentialsOptions f19079c = new AuthCredentialsOptions(new Builder());
        public final PasswordSpecification f19080a;
        public final boolean f19081b;
        private final String f19082d = null;

        @Deprecated
        public static class Builder {
            protected PasswordSpecification f5670a = PasswordSpecification.f17216a;
            protected Boolean f5671b = Boolean.valueOf(false);
        }

        private AuthCredentialsOptions(Builder builder) {
            this.f19080a = builder.f5670a;
            this.f19081b = builder.f5671b.booleanValue();
        }
    }
}
