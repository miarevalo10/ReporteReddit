package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzaks implements Runnable {
    private final zzalf f6502a;
    private final zzakv f6503b;

    zzaks(zzalf com_google_android_gms_internal_zzalf, zzakv com_google_android_gms_internal_zzakv) {
        this.f6502a = com_google_android_gms_internal_zzalf;
        this.f6503b = com_google_android_gms_internal_zzakv;
    }

    public final void run() {
        Throwable cause;
        zzalf com_google_android_gms_internal_zzalf = this.f6502a;
        try {
            com_google_android_gms_internal_zzalf.m13330b(this.f6503b.get());
        } catch (ExecutionException e) {
            cause = e.getCause();
            com_google_android_gms_internal_zzalf.m13329a(cause);
        } catch (InterruptedException e2) {
            cause = e2;
            Thread.currentThread().interrupt();
            com_google_android_gms_internal_zzalf.m13329a(cause);
        } catch (Throwable cause2) {
            com_google_android_gms_internal_zzalf.m13329a(cause2);
        }
    }
}
