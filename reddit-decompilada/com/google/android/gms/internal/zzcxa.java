package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.Scope;
import com.instabug.library.model.State;

public final class zzcxa {
    public static final zza<zzcxn, zzcxe> f7196a = new zzcxb();
    public static final Api<zzcxe> f7197b = new Api("SignIn.API", f7196a, f7198c);
    private static zzf<zzcxn> f7198c = new zzf();
    private static zzf<zzcxn> f7199d = new zzf();
    private static zza<zzcxn, Object> f7200e = new zzcxc();
    private static Scope f7201f = new Scope("profile");
    private static Scope f7202g = new Scope(State.KEY_EMAIL);
    private static Api<Object> f7203h = new Api("SignIn.INTERNAL_API", f7200e, f7199d);
}
