package com.google.android.gms.internal;

final class zzut implements Runnable {
    private /* synthetic */ zzakv f8095a;
    private /* synthetic */ zzur f8096b;

    zzut(zzur com_google_android_gms_internal_zzur, zzakv com_google_android_gms_internal_zzakv) {
        this.f8096b = com_google_android_gms_internal_zzur;
        this.f8095a = com_google_android_gms_internal_zzakv;
    }

    public final void run() {
        for (zzakv com_google_android_gms_internal_zzakv : this.f8096b.f14668k.keySet()) {
            if (com_google_android_gms_internal_zzakv != this.f8095a) {
                ((zzul) this.f8096b.f14668k.get(com_google_android_gms_internal_zzakv)).m14299a();
            }
        }
    }
}
