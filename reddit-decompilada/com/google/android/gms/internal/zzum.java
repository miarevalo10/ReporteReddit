package com.google.android.gms.internal;

final class zzum implements Runnable {
    private /* synthetic */ zzuk f8084a;
    private /* synthetic */ zzul f8085b;

    zzum(zzul com_google_android_gms_internal_zzul, zzuk com_google_android_gms_internal_zzuk) {
        this.f8085b = com_google_android_gms_internal_zzul;
        this.f8084a = com_google_android_gms_internal_zzuk;
    }

    public final void run() {
        synchronized (this.f8085b.f14646i) {
            if (this.f8085b.f14656s != -2) {
                return;
            }
            this.f8085b.f14655r = this.f8085b.m14291d();
            if (this.f8085b.f14655r == null) {
                this.f8085b.mo2163a(4);
            } else if (!this.f8085b.m14293e() || this.f8085b.m14288b(1)) {
                zzuk com_google_android_gms_internal_zzuk = this.f8084a;
                zzup com_google_android_gms_internal_zzup = this.f8085b;
                synchronized (com_google_android_gms_internal_zzuk.f18309a) {
                    com_google_android_gms_internal_zzuk.f18310b = com_google_android_gms_internal_zzup;
                }
                zzul.m14284a(this.f8085b, this.f8084a);
            } else {
                String g = this.f8085b.f14638a;
                StringBuilder stringBuilder = new StringBuilder(56 + String.valueOf(g).length());
                stringBuilder.append("Ignoring adapter ");
                stringBuilder.append(g);
                stringBuilder.append(" as delayed impression is not supported");
                zzakb.m5371e(stringBuilder.toString());
                this.f8085b.mo2163a(2);
            }
        }
    }
}
