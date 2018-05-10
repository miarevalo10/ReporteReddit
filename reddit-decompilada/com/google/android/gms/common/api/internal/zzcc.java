package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface zzcc {
    <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1547a(T t);

    void mo1548a();

    void mo1549a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean mo1550a(zzcu com_google_android_gms_common_api_internal_zzcu);

    ConnectionResult mo1551b();

    <A extends zzb, T extends zzm<? extends Result, A>> T mo1552b(T t);

    void mo1553c();

    boolean mo1554d();

    boolean mo1555e();

    void mo1556f();

    void mo1557g();
}
