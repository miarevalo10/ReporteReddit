package io.branch.referral;

import android.os.AsyncTask;

public abstract class BranchAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public final android.os.AsyncTask<Params, Progress, Result> m26099a(Params... r3) {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0012;
    L_0x0006:
        r0 = android.os.AsyncTask.THREAD_POOL_EXECUTOR;	 Catch:{ Throwable -> 0x000d }
        r0 = r2.executeOnExecutor(r0, r3);	 Catch:{ Throwable -> 0x000d }
        return r0;
    L_0x000d:
        r3 = r2.execute(r3);
        return r3;
    L_0x0012:
        r3 = r2.execute(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchAsyncTask.a(java.lang.Object[]):android.os.AsyncTask<Params, Progress, Result>");
    }
}
