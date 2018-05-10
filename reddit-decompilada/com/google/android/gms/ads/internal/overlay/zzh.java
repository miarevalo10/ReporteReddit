package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzh extends RelativeLayout {
    public boolean f5481a;
    private zzaig f5482b;

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f5481a) {
            this.f5482b.m5275a(motionEvent);
        }
        return false;
    }

    public zzh(Context context, String str, String str2) {
        super(context);
        this.f5482b = new zzaig(context, str);
        this.f5482b.f6396c = str2;
    }
}
