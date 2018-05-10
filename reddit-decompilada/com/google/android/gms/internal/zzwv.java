package com.google.android.gms.internal;

import android.content.DialogInterface.OnClickListener;

public final class zzwv implements OnClickListener {
    private /* synthetic */ String f8126a;
    private /* synthetic */ String f8127b;
    private /* synthetic */ zzwu f8128c;

    public zzwv(zzwu com_google_android_gms_internal_zzwu, String str, String str2) {
        this.f8128c = com_google_android_gms_internal_zzwu;
        this.f8126a = str;
        this.f8127b = str2;
    }

    public final void onClick(android.content.DialogInterface r3, int r4) {
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
        r2 = this;
        r3 = r2.f8128c;
        r3 = r3.f14727b;
        r4 = "download";
        r3 = r3.getSystemService(r4);
        r3 = (android.app.DownloadManager) r3;
        r4 = r2.f8126a;	 Catch:{ IllegalStateException -> 0x002b }
        r0 = r2.f8127b;	 Catch:{ IllegalStateException -> 0x002b }
        r1 = new android.app.DownloadManager$Request;	 Catch:{ IllegalStateException -> 0x002b }
        r4 = android.net.Uri.parse(r4);	 Catch:{ IllegalStateException -> 0x002b }
        r1.<init>(r4);	 Catch:{ IllegalStateException -> 0x002b }
        r4 = android.os.Environment.DIRECTORY_PICTURES;	 Catch:{ IllegalStateException -> 0x002b }
        r1.setDestinationInExternalPublicDir(r4, r0);	 Catch:{ IllegalStateException -> 0x002b }
        r4 = com.google.android.gms.ads.internal.zzbs.m4488g();	 Catch:{ IllegalStateException -> 0x002b }
        r4.mo1721a(r1);	 Catch:{ IllegalStateException -> 0x002b }
        r3.enqueue(r1);	 Catch:{ IllegalStateException -> 0x002b }
        return;
    L_0x002b:
        r3 = r2.f8128c;
        r4 = "Could not store picture.";
        r3.m6783a(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwv.onClick(android.content.DialogInterface, int):void");
    }
}
