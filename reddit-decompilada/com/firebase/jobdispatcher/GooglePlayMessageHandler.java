package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;

@TargetApi(21)
class GooglePlayMessageHandler extends Handler {
    private final GooglePlayReceiver f3853a;

    public GooglePlayMessageHandler(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f3853a = googlePlayReceiver;
    }

    public void handleMessage(android.os.Message r4) {
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
        r3 = this;
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r3.f3853a;
        r0 = r0.getApplicationContext();
        r1 = "appops";
        r0 = r0.getSystemService(r1);
        r0 = (android.app.AppOpsManager) r0;
        r1 = r4.sendingUid;	 Catch:{ SecurityException -> 0x0091 }
        r2 = "com.google.android.gms";	 Catch:{ SecurityException -> 0x0091 }
        r0.checkPackage(r1, r2);	 Catch:{ SecurityException -> 0x0091 }
        r0 = r4.what;
        r1 = 4;
        if (r0 == r1) goto L_0x0090;
    L_0x001d:
        r1 = 3;
        switch(r0) {
            case 1: goto L_0x005c;
            case 2: goto L_0x0035;
            default: goto L_0x0021;
        };
    L_0x0021:
        r0 = "FJD.GooglePlayReceiver";
        r1 = new java.lang.StringBuilder;
        r2 = "Unrecognized message received: ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        android.util.Log.e(r0, r4);
        return;
    L_0x0035:
        r0 = com.firebase.jobdispatcher.GooglePlayReceiver.m11796b();
        r4 = r4.getData();
        r4 = r0.m3473a(r4);
        if (r4 != 0) goto L_0x0053;
    L_0x0043:
        r4 = "FJD.GooglePlayReceiver";
        r4 = android.util.Log.isLoggable(r4, r1);
        if (r4 == 0) goto L_0x0052;
    L_0x004b:
        r4 = "FJD.GooglePlayReceiver";
        r0 = "Invalid stop execution message.";
        android.util.Log.d(r4, r0);
    L_0x0052:
        return;
    L_0x0053:
        r4 = r4.m3484a();
        r0 = 1;
        com.firebase.jobdispatcher.ExecutionDelegator.m3457a(r4, r0);
        return;
    L_0x005c:
        r0 = r4.getData();
        r4 = r4.replyTo;
        r2 = "tag";
        r2 = r0.getString(r2);
        if (r4 == 0) goto L_0x0080;
    L_0x006a:
        if (r2 != 0) goto L_0x006d;
    L_0x006c:
        goto L_0x0080;
    L_0x006d:
        r1 = new com.firebase.jobdispatcher.GooglePlayMessengerCallback;
        r1.<init>(r4, r2);
        r4 = com.firebase.jobdispatcher.GooglePlayReceiver.m11793a(r1, r0);
        r0 = r3.f3853a;
        r0 = r0.m11800a();
        r0.m3458a(r4);
        return;
    L_0x0080:
        r4 = "FJD.GooglePlayReceiver";
        r4 = android.util.Log.isLoggable(r4, r1);
        if (r4 == 0) goto L_0x008f;
    L_0x0088:
        r4 = "FJD.GooglePlayReceiver";
        r0 = "Invalid start execution message.";
        android.util.Log.d(r4, r0);
    L_0x008f:
        return;
    L_0x0090:
        return;
    L_0x0091:
        r4 = "FJD.GooglePlayReceiver";
        r0 = "Message was not sent from GCM.";
        android.util.Log.e(r4, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayMessageHandler.handleMessage(android.os.Message):void");
    }
}
