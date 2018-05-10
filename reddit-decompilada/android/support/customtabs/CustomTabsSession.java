package android.support.customtabs;

import android.content.ComponentName;

public final class CustomTabsSession {
    private final Object f397a = new Object();
    private final ICustomTabsService f398b;
    private final ICustomTabsCallback f399c;
    private final ComponentName f400d;

    CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.f398b = iCustomTabsService;
        this.f399c = iCustomTabsCallback;
        this.f400d = componentName;
    }

    public final boolean m148a(android.net.Uri r4) {
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
        r0 = r3.f398b;	 Catch:{ RemoteException -> 0x000a }
        r1 = r3.f399c;	 Catch:{ RemoteException -> 0x000a }
        r2 = 0;	 Catch:{ RemoteException -> 0x000a }
        r4 = r0.mo35a(r1, r4, r2, r2);	 Catch:{ RemoteException -> 0x000a }
        return r4;
    L_0x000a:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.customtabs.CustomTabsSession.a(android.net.Uri):boolean");
    }
}
