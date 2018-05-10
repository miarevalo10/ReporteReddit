package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzbs;

final class zzaio implements OnClickListener {
    private /* synthetic */ zzain f6421a;

    zzaio(zzain com_google_android_gms_internal_zzain) {
        this.f6421a = com_google_android_gms_internal_zzain;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbs.m4486e();
        zzahn.m5168a(this.f6421a.f6417a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
