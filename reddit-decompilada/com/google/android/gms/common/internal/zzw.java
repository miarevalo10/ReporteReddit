package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zzw extends zzv {
    private /* synthetic */ Intent f14006a;
    private /* synthetic */ Activity f14007b;
    private /* synthetic */ int f14008c;

    zzw(Intent intent, Activity activity, int i) {
        this.f14006a = intent;
        this.f14007b = activity;
        this.f14008c = i;
    }

    public final void mo1631a() {
        if (this.f14006a != null) {
            this.f14007b.startActivityForResult(this.f14006a, this.f14008c);
        }
    }
}
