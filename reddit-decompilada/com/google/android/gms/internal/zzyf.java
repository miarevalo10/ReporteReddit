package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.widget.PopupWindow;

@zzzv
@TargetApi(19)
public final class zzyf extends zzyc {
    private Object f19237d = new Object();
    private PopupWindow f19238e;
    private boolean f19239f = false;

    zzyf(Context context, zzafp com_google_android_gms_internal_zzafp, zzanh com_google_android_gms_internal_zzanh, zzyb com_google_android_gms_internal_zzyb) {
        super(context, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzyb);
    }

    private final void m20446c() {
        synchronized (this.f19237d) {
            this.f19239f = true;
            if ((this.a instanceof Activity) && ((Activity) this.a).isDestroyed()) {
                this.f19238e = null;
            }
            if (this.f19238e != null) {
                if (this.f19238e.isShowing()) {
                    this.f19238e.dismiss();
                }
                this.f19238e = null;
            }
        }
    }

    protected final void mo4043a(int i) {
        m20446c();
        super.mo4043a(i);
    }

    protected final void mo4044b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.a;
        r0 = r0 instanceof android.app.Activity;
        r1 = 0;
        if (r0 == 0) goto L_0x0010;
    L_0x0007:
        r0 = r8.a;
        r0 = (android.app.Activity) r0;
        r0 = r0.getWindow();
        goto L_0x0011;
    L_0x0010:
        r0 = r1;
    L_0x0011:
        if (r0 == 0) goto L_0x0071;
    L_0x0013:
        r2 = r0.getDecorView();
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r2 = r8.a;
        r2 = (android.app.Activity) r2;
        r2 = r2.isDestroyed();
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        return;
    L_0x0025:
        r2 = new android.widget.FrameLayout;
        r3 = r8.a;
        r2.<init>(r3);
        r3 = new android.view.ViewGroup$LayoutParams;
        r4 = -1;
        r3.<init>(r4, r4);
        r2.setLayoutParams(r3);
        r3 = r8.b;
        if (r3 != 0) goto L_0x003a;
    L_0x0039:
        throw r1;
    L_0x003a:
        r3 = (android.view.View) r3;
        r2.addView(r3, r4, r4);
        r3 = r8.f19237d;
        monitor-enter(r3);
        r5 = r8.f19239f;	 Catch:{ all -> 0x006e }
        if (r5 == 0) goto L_0x0048;	 Catch:{ all -> 0x006e }
    L_0x0046:
        monitor-exit(r3);	 Catch:{ all -> 0x006e }
        return;	 Catch:{ all -> 0x006e }
    L_0x0048:
        r5 = new android.widget.PopupWindow;	 Catch:{ all -> 0x006e }
        r6 = 0;	 Catch:{ all -> 0x006e }
        r7 = 1;	 Catch:{ all -> 0x006e }
        r5.<init>(r2, r7, r7, r6);	 Catch:{ all -> 0x006e }
        r8.f19238e = r5;	 Catch:{ all -> 0x006e }
        r2 = r8.f19238e;	 Catch:{ all -> 0x006e }
        r2.setOutsideTouchable(r7);	 Catch:{ all -> 0x006e }
        r2 = r8.f19238e;	 Catch:{ all -> 0x006e }
        r2.setClippingEnabled(r6);	 Catch:{ all -> 0x006e }
        r2 = "Displaying the 1x1 popup off the screen.";	 Catch:{ all -> 0x006e }
        com.google.android.gms.internal.zzakb.m5366b(r2);	 Catch:{ all -> 0x006e }
        r2 = r8.f19238e;	 Catch:{ Exception -> 0x006a }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x006a }
        r2.showAtLocation(r0, r6, r4, r4);	 Catch:{ Exception -> 0x006a }
        goto L_0x006c;
    L_0x006a:
        r8.f19238e = r1;	 Catch:{ all -> 0x006e }
    L_0x006c:
        monitor-exit(r3);	 Catch:{ all -> 0x006e }
        return;	 Catch:{ all -> 0x006e }
    L_0x006e:
        r0 = move-exception;	 Catch:{ all -> 0x006e }
        monitor-exit(r3);	 Catch:{ all -> 0x006e }
        throw r0;
    L_0x0071:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzyf.b():void");
    }

    public final void mo1644d() {
        m20446c();
        super.mo1644d();
    }
}
