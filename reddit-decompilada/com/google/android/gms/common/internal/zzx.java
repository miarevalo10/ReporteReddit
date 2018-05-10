package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

final class zzx extends zzv {
    private /* synthetic */ Intent f14009a;
    private /* synthetic */ Fragment f14010b;
    private /* synthetic */ int f14011c;

    zzx(Intent intent, Fragment fragment, int i) {
        this.f14009a = intent;
        this.f14010b = fragment;
        this.f14011c = i;
    }

    public final void mo1631a() {
        if (this.f14009a != null) {
            this.f14010b.startActivityForResult(this.f14009a, this.f14011c);
        }
    }
}
