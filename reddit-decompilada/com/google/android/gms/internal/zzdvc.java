package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;

public final class zzdvc implements zzduv<Signature> {
    public final /* synthetic */ Object mo1867a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
