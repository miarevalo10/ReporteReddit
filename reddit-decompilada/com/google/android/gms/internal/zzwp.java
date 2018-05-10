package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import com.google.android.gms.ads.internal.zzbs;

public final class zzwp implements OnClickListener {
    private /* synthetic */ zzwo f8120a;

    public zzwp(zzwo com_google_android_gms_internal_zzwo) {
        this.f8120a = com_google_android_gms_internal_zzwo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface = this.f8120a;
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", dialogInterface.f14701b);
        data.putExtra("eventLocation", dialogInterface.f14705f);
        data.putExtra("description", dialogInterface.f14704e);
        if (dialogInterface.f14702c > -1) {
            data.putExtra("beginTime", dialogInterface.f14702c);
        }
        if (dialogInterface.f14703d > -1) {
            data.putExtra("endTime", dialogInterface.f14703d);
        }
        data.setFlags(268435456);
        zzbs.m4486e();
        zzahn.m5167a(this.f8120a.f14700a, data);
    }
}
