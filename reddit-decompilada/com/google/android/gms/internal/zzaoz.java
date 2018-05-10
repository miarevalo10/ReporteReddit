package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzzv
public final class zzaoz extends MutableContextWrapper {
    Activity f6676a;
    Context f6677b;
    private Context f6678c;

    public zzaoz(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.f6677b.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.f6678c = context.getApplicationContext();
        this.f6676a = context instanceof Activity ? (Activity) context : null;
        this.f6677b = context;
        super.setBaseContext(this.f6678c);
    }

    public final void startActivity(Intent intent) {
        if (this.f6676a != null) {
            this.f6676a.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.f6678c.startActivity(intent);
    }
}
