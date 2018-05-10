package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.library.model.NetworkLog;

final class zzaii implements OnClickListener {
    private /* synthetic */ String f6408a;
    private /* synthetic */ zzaig f6409b;

    zzaii(zzaig com_google_android_gms_internal_zzaig, String str) {
        this.f6409b = com_google_android_gms_internal_zzaig;
        this.f6408a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbs.m4486e();
        zzahn.m5167a(this.f6409b.f6398e, Intent.createChooser(new Intent("android.intent.action.SEND").setType(NetworkLog.PLAIN_TEXT).putExtra("android.intent.extra.TEXT", this.f6408a), "Share via"));
    }
}
