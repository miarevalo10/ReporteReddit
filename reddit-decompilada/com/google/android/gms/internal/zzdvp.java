package com.google.android.gms.internal;

import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.util.List;

final class zzdvp extends zzdvm {
    private final zzdvn f14400a = new zzdvn();

    zzdvp() {
    }

    public final void mo1869a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        zzdvn com_google_android_gms_internal_zzdvn = this.f14400a;
        while (true) {
            Reference poll = com_google_android_gms_internal_zzdvn.f7348b.poll();
            if (poll == null) {
                break;
            }
            com_google_android_gms_internal_zzdvn.f7347a.remove(poll);
        }
        List<Throwable> list = (List) com_google_android_gms_internal_zzdvn.f7347a.get(new zzdvo(th));
        if (list != null) {
            synchronized (list) {
                for (Throwable th2 : list) {
                    printWriter.print("Suppressed: ");
                    th2.printStackTrace(printWriter);
                }
            }
        }
    }
}
