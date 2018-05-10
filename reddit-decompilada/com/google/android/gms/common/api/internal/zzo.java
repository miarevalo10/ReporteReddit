package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzo extends LifecycleCallback implements OnCancelListener {
    private final Handler f13964b;
    protected volatile boolean f13965c;
    protected final AtomicReference<zzp> f13966d;
    protected final GoogleApiAvailability f13967e;

    protected zzo(zzcf com_google_android_gms_common_api_internal_zzcf) {
        this(com_google_android_gms_common_api_internal_zzcf, GoogleApiAvailability.m12790a());
    }

    private zzo(zzcf com_google_android_gms_common_api_internal_zzcf, GoogleApiAvailability googleApiAvailability) {
        super(com_google_android_gms_common_api_internal_zzcf);
        this.f13966d = new AtomicReference(null);
        this.f13964b = new Handler(Looper.getMainLooper());
        this.f13967e = googleApiAvailability;
    }

    public final void mo1614a(Bundle bundle) {
        super.mo1614a(bundle);
        if (bundle != null) {
            this.f13966d.set(bundle.getBoolean("resolving_error", false) ? new zzp(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    protected abstract void mo3410a(ConnectionResult connectionResult, int i);

    public void mo1615b() {
        super.mo1615b();
        this.f13965c = true;
    }

    public final void m13042b(ConnectionResult connectionResult, int i) {
        zzp com_google_android_gms_common_api_internal_zzp = new zzp(connectionResult, i);
        if (this.f13966d.compareAndSet(null, com_google_android_gms_common_api_internal_zzp)) {
            this.f13964b.post(new zzq(this, com_google_android_gms_common_api_internal_zzp));
        }
    }

    public void mo1617d() {
        super.mo1617d();
        this.f13965c = false;
    }

    protected abstract void mo3412e();

    protected final void m13045f() {
        this.f13966d.set(null);
        mo3412e();
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo3410a(new ConnectionResult(13, null), m13036a((zzp) this.f13966d.get()));
        m13045f();
    }

    public final void mo1616b(Bundle bundle) {
        super.mo1616b(bundle);
        zzp com_google_android_gms_common_api_internal_zzp = (zzp) this.f13966d.get();
        if (com_google_android_gms_common_api_internal_zzp != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", com_google_android_gms_common_api_internal_zzp.f5853a);
            bundle.putInt("failed_status", com_google_android_gms_common_api_internal_zzp.f5854b.f17257b);
            bundle.putParcelable("failed_resolution", com_google_android_gms_common_api_internal_zzp.f5854b.f17258c);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1613a(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = r3.f13966d;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.zzp) r0;
        r1 = 1;
        r2 = 0;
        switch(r4) {
            case 1: goto L_0x002a;
            case 2: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        goto L_0x004f;
    L_0x000e:
        r4 = r3.f13967e;
        r5 = r3.m4681a();
        r4 = r4.mo1537a(r5);
        if (r4 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x001c;
    L_0x001b:
        r1 = r2;
    L_0x001c:
        if (r0 != 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        r5 = r0.f5854b;
        r5 = r5.f17257b;
        r6 = 18;
        if (r5 != r6) goto L_0x0050;
    L_0x0027:
        if (r4 != r6) goto L_0x0050;
    L_0x0029:
        return;
    L_0x002a:
        r4 = -1;
        if (r5 != r4) goto L_0x002e;
    L_0x002d:
        goto L_0x0050;
    L_0x002e:
        if (r5 != 0) goto L_0x004f;
    L_0x0030:
        r4 = 13;
        if (r6 == 0) goto L_0x003a;
    L_0x0034:
        r5 = "<<ResolutionFailureErrorDetail>>";
        r4 = r6.getIntExtra(r5, r4);
    L_0x003a:
        r5 = new com.google.android.gms.common.api.internal.zzp;
        r6 = new com.google.android.gms.common.ConnectionResult;
        r1 = 0;
        r6.<init>(r4, r1);
        r4 = m13036a(r0);
        r5.<init>(r6, r4);
        r4 = r3.f13966d;
        r4.set(r5);
        r0 = r5;
    L_0x004f:
        r1 = r2;
    L_0x0050:
        if (r1 == 0) goto L_0x0056;
    L_0x0052:
        r3.m13045f();
        return;
    L_0x0056:
        if (r0 == 0) goto L_0x005f;
    L_0x0058:
        r4 = r0.f5854b;
        r5 = r0.f5853a;
        r3.mo3410a(r4, r5);
    L_0x005f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzo.a(int, int, android.content.Intent):void");
    }

    private static int m13036a(zzp com_google_android_gms_common_api_internal_zzp) {
        return com_google_android_gms_common_api_internal_zzp == null ? -1 : com_google_android_gms_common_api_internal_zzp.f5853a;
    }
}
