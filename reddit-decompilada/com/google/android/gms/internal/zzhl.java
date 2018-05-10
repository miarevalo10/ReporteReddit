package com.google.android.gms.internal;

import android.view.View;

final class zzhl implements Runnable {
    private /* synthetic */ View f7686a;
    private /* synthetic */ zzhk f7687b;

    zzhl(zzhk com_google_android_gms_internal_zzhk, View view) {
        this.f7687b = com_google_android_gms_internal_zzhk;
        this.f7686a = view;
    }

    public final void run() {
        zzhk com_google_android_gms_internal_zzhk = this.f7687b;
        View view = this.f7686a;
        try {
            zzhe com_google_android_gms_internal_zzhe = new zzhe(com_google_android_gms_internal_zzhk.f7674e, com_google_android_gms_internal_zzhk.f7675f, com_google_android_gms_internal_zzhk.f7676g, com_google_android_gms_internal_zzhk.f7677h, com_google_android_gms_internal_zzhk.f7678i, com_google_android_gms_internal_zzhk.f7679j, com_google_android_gms_internal_zzhk.f7680k);
            zzho a = com_google_android_gms_internal_zzhk.m6294a(view, com_google_android_gms_internal_zzhe);
            com_google_android_gms_internal_zzhe.m6278c();
            if (a.f7694a != 0 || a.f7695b != 0) {
                if (a.f7695b != 0 || com_google_android_gms_internal_zzhe.f7638b != 0) {
                    if (a.f7695b != 0 || !com_google_android_gms_internal_zzhk.f7672c.m6280a(com_google_android_gms_internal_zzhe)) {
                        zzhf com_google_android_gms_internal_zzhf = com_google_android_gms_internal_zzhk.f7672c;
                        synchronized (com_google_android_gms_internal_zzhf.f7653a) {
                            int size;
                            if (com_google_android_gms_internal_zzhf.f7655c.size() >= 10) {
                                size = com_google_android_gms_internal_zzhf.f7655c.size();
                                StringBuilder stringBuilder = new StringBuilder(41);
                                stringBuilder.append("Queue is full, current size = ");
                                stringBuilder.append(size);
                                zzakb.m5366b(stringBuilder.toString());
                                com_google_android_gms_internal_zzhf.f7655c.remove(0);
                            }
                            size = com_google_android_gms_internal_zzhf.f7654b;
                            com_google_android_gms_internal_zzhf.f7654b = size + 1;
                            com_google_android_gms_internal_zzhe.f7639c = size;
                            com_google_android_gms_internal_zzhf.f7655c.add(com_google_android_gms_internal_zzhe);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            zzakb.m5367b("Exception in fetchContentOnUIThread", e);
            com_google_android_gms_internal_zzhk.f7673d.mo2296a(e, "ContentFetchTask.fetchContent");
        }
    }
}
