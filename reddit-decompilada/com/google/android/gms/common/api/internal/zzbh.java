package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;

public interface zzbh {
    <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1570a(T t);

    void mo1571a();

    void mo1572a(int i);

    void mo1573a(Bundle bundle);

    void mo1574a(ConnectionResult connectionResult, Api<?> api, boolean z);

    <A extends zzb, T extends zzm<? extends Result, A>> T mo1575b(T t);

    boolean mo1576b();

    void mo1577c();
}
