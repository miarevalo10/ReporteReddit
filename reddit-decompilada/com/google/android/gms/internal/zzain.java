package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;

final class zzain implements Runnable {
    final /* synthetic */ Context f6417a;
    private /* synthetic */ String f6418b;
    private /* synthetic */ boolean f6419c;
    private /* synthetic */ boolean f6420d;

    zzain(Context context, String str, boolean z, boolean z2) {
        this.f6417a = context;
        this.f6418b = str;
        this.f6419c = z;
        this.f6420d = z2;
    }

    public final void run() {
        Builder builder = new Builder(this.f6417a);
        builder.setMessage(this.f6418b);
        builder.setTitle(this.f6419c ? "Error" : "Info");
        if (this.f6420d) {
            builder.setNeutralButton("Dismiss", null);
        } else {
            builder.setPositiveButton("Learn More", new zzaio(this));
            builder.setNegativeButton("Dismiss", null);
        }
        builder.create().show();
    }
}
