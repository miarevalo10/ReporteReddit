package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzakm implements Runnable {
    private final zzaki f6487a;
    private final zzakv f6488b;

    zzakm(zzaki com_google_android_gms_internal_zzaki, zzakv com_google_android_gms_internal_zzakv) {
        this.f6487a = com_google_android_gms_internal_zzaki;
        this.f6488b = com_google_android_gms_internal_zzakv;
    }

    public final void run() {
        Throwable cause;
        zzaki com_google_android_gms_internal_zzaki = this.f6487a;
        try {
            com_google_android_gms_internal_zzaki.mo1730a(this.f6488b.get());
        } catch (ExecutionException e) {
            cause = e.getCause();
            com_google_android_gms_internal_zzaki.mo1731a(cause);
        } catch (InterruptedException e2) {
            cause = e2;
            Thread.currentThread().interrupt();
            com_google_android_gms_internal_zzaki.mo1731a(cause);
        } catch (Exception e3) {
            cause = e3;
            com_google_android_gms_internal_zzaki.mo1731a(cause);
        }
    }
}
