package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzcu extends zzct {
    private zzcu(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzcu m20407a(String str, Context context, boolean z) {
        zzct.m18647a(context, z);
        return new zzcu(context, str, z);
    }

    protected final List<Callable<Void>> mo4024a(zzdm com_google_android_gms_internal_zzdm, zzaz com_google_android_gms_internal_zzaz, zzaw com_google_android_gms_internal_zzaw) {
        if (com_google_android_gms_internal_zzdm.f7217b != null) {
            if (this.q) {
                int c = com_google_android_gms_internal_zzdm.m5851c();
                List<Callable<Void>> arrayList = new ArrayList();
                arrayList.addAll(super.mo4024a(com_google_android_gms_internal_zzdm, com_google_android_gms_internal_zzaz, com_google_android_gms_internal_zzaw));
                arrayList.add(new zzed(com_google_android_gms_internal_zzdm, "VywbbfxE2QuRqZ5xcIwapO7AdSzfVaSWnmJxmUg+0adJ3QBAH5P7EgXr1uzyY+u6", "JgKAyQW0PWqOrZHk4ZNT0IJH02FdSWTXOOjBnF9RRok=", com_google_android_gms_internal_zzaz, c));
                return arrayList;
            }
        }
        return super.mo4024a(com_google_android_gms_internal_zzdm, com_google_android_gms_internal_zzaz, com_google_android_gms_internal_zzaw);
    }
}
