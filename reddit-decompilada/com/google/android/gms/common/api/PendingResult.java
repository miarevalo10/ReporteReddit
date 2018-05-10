package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {

    public interface zza {
        void mo1559a();
    }

    public abstract R mo1541a(long j, TimeUnit timeUnit);

    public void mo1542a(zza com_google_android_gms_common_api_PendingResult_zza) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1543a(ResultCallback<? super R> resultCallback);

    public abstract void mo1544c();

    public abstract boolean mo1545d();

    public Integer mo1546e() {
        throw new UnsupportedOperationException();
    }
}
