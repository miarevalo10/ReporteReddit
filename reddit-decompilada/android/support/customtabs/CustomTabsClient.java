package android.support.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback.Stub;
import android.text.TextUtils;

public class CustomTabsClient {
    private final ICustomTabsService f388a;
    private final ComponentName f389b;

    class C15832 extends Stub {
        final /* synthetic */ CustomTabsCallback f16397a = null;
        final /* synthetic */ CustomTabsClient f16398b;
        private Handler f16399c = new Handler(Looper.getMainLooper());

        C15832(CustomTabsClient customTabsClient) {
            this.f16398b = customTabsClient;
        }

        public final void mo25a(final int i, final Bundle bundle) {
            if (this.f16397a != null) {
                this.f16399c.post(new Runnable(this) {
                    final /* synthetic */ C15832 f374c;

                    public void run() {
                    }
                });
            }
        }

        public final void mo27a(final String str, final Bundle bundle) throws RemoteException {
            if (this.f16397a != null) {
                this.f16399c.post(new Runnable(this) {
                    final /* synthetic */ C15832 f377c;

                    public void run() {
                    }
                });
            }
        }

        public final void mo26a(final Bundle bundle) throws RemoteException {
            if (this.f16397a != null) {
                this.f16399c.post(new Runnable(this) {
                    final /* synthetic */ C15832 f379b;

                    public void run() {
                    }
                });
            }
        }

        public final void mo28b(final String str, final Bundle bundle) throws RemoteException {
            if (this.f16397a != null) {
                this.f16399c.post(new Runnable(this) {
                    final /* synthetic */ C15832 f382c;

                    public void run() {
                    }
                });
            }
        }

        public final void mo24a(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
            if (this.f16397a != null) {
                final int i2 = i;
                final Uri uri2 = uri;
                final boolean z2 = z;
                final Bundle bundle2 = bundle;
                this.f16399c.post(new Runnable(this) {
                    final /* synthetic */ C15832 f387e;

                    public void run() {
                    }
                });
            }
        }
    }

    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.f388a = iCustomTabsService;
        this.f389b = componentName;
    }

    public static boolean m142a(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public final boolean m143a() {
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
        r0 = r3.f388a;	 Catch:{ RemoteException -> 0x0009 }
        r1 = 0;	 Catch:{ RemoteException -> 0x0009 }
        r0 = r0.mo31a(r1);	 Catch:{ RemoteException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.customtabs.CustomTabsClient.a():boolean");
    }

    public final android.support.customtabs.CustomTabsSession m144b() {
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
        r4 = this;
        r0 = new android.support.customtabs.CustomTabsClient$2;
        r0.<init>(r4);
        r1 = 0;
        r2 = r4.f388a;	 Catch:{ RemoteException -> 0x0019 }
        r2 = r2.mo32a(r0);	 Catch:{ RemoteException -> 0x0019 }
        if (r2 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r1 = new android.support.customtabs.CustomTabsSession;
        r2 = r4.f388a;
        r3 = r4.f389b;
        r1.<init>(r2, r0, r3);
        return r1;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.customtabs.CustomTabsClient.b():android.support.customtabs.CustomTabsSession");
    }
}
