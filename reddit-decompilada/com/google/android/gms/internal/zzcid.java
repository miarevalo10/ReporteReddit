package com.google.android.gms.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbq;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class zzcid {
    private final zzcif f6942a;

    public zzcid(zzcif com_google_android_gms_internal_zzcif) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcif);
        this.f6942a = com_google_android_gms_internal_zzcif;
    }

    public static boolean m5707a(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        com.google.android.gms.common.internal.zzbq.m4808a(r4);
        r0 = 0;
        r1 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001f }
        if (r1 != 0) goto L_0x000b;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x000a:
        return r0;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x000b:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001f }
        r3 = "com.google.android.gms.measurement.AppMeasurementReceiver";	 Catch:{ NameNotFoundException -> 0x001f }
        r2.<init>(r4, r3);	 Catch:{ NameNotFoundException -> 0x001f }
        r4 = 2;	 Catch:{ NameNotFoundException -> 0x001f }
        r4 = r1.getReceiverInfo(r2, r4);	 Catch:{ NameNotFoundException -> 0x001f }
        if (r4 == 0) goto L_0x001f;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x0019:
        r4 = r4.enabled;	 Catch:{ NameNotFoundException -> 0x001f }
        if (r4 == 0) goto L_0x001f;
    L_0x001d:
        r4 = 1;
        return r4;
    L_0x001f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcid.a(android.content.Context):boolean");
    }

    public final void m5708a(Context context, Intent intent) {
        zzcim a = zzcim.m5720a(context);
        zzchm e = a.m5754e();
        if (intent == null) {
            e.f17818c.m5693a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        e.f17822g.m5694a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            intent = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            intent.setAction("com.google.android.gms.measurement.UPLOAD");
            e.f17822g.m5693a("Starting wakeful intent.");
            this.f6942a.mo2301a(context, intent);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            PendingResult a2 = this.f6942a.mo2300a();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                e.f17822g.m5693a("Install referrer extras are null");
                if (a2 != null) {
                    a2.finish();
                }
                return;
            }
            e.f17820e.m5694a("Install referrer extras are", action);
            if (!action.contains(Operation.EMPTY_PARAM)) {
                String str = Operation.EMPTY_PARAM;
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle a3 = a.m5758i().m18533a(Uri.parse(action));
            if (a3 == null) {
                e.f17822g.m5693a("No campaign defined in install referrer broadcast");
                if (a2 != null) {
                    a2.finish();
                    return;
                }
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
            if (longExtra == 0) {
                e.f17818c.m5693a("Install referrer is missing timestamp");
            }
            a.m5755f().m18271a(new zzcie(a, longExtra, a3, context, e, a2));
        }
    }
}
