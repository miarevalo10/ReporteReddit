package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.zzp;

public final class zzw extends zzr {
    private final Context f17255a;

    public zzw(Context context) {
        this.f17255a = context;
    }

    private final void m17574c() {
        if (!zzp.zzf(this.f17255a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder stringBuilder = new StringBuilder(52);
            stringBuilder.append("Calling UID ");
            stringBuilder.append(callingUid);
            stringBuilder.append(" is not Google Play services.");
            throw new SecurityException(stringBuilder.toString());
        }
    }

    public final void mo3405a() {
        m17574c();
        zzz a = zzz.m4620a(this.f17255a);
        GoogleSignInAccount a2 = a.m4624a();
        HasOptions hasOptions = GoogleSignInOptions.f19088f;
        if (a2 != null) {
            hasOptions = a.m4628b();
        }
        GoogleApiClient a3 = new Builder(this.f17255a).m4637a(Auth.f5676e, hasOptions).m4640a();
        try {
            if (a3.mo1564f().m17584b()) {
                if (a2 != null) {
                    Auth.f5679h.revokeAccess(a3);
                } else {
                    a3.mo1567i();
                }
            }
            a3.mo1565g();
        } catch (Throwable th) {
            a3.mo1565g();
        }
    }

    public final void mo3406b() {
        m17574c();
        zzo.m4604a(this.f17255a).m4606a();
    }
}
