package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;

public final class zzdvb implements zzduv<MessageDigest> {
    public final /* synthetic */ Object mo1867a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
