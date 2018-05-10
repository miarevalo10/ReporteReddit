package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean f19805a = false;
    private boolean f19806b = false;
    private SignInConfiguration f19807c;
    private boolean f19808d;
    private int f19809e;
    private Intent f19810f;

    class zza implements LoaderCallbacks<Void> {
        private /* synthetic */ SignInHubActivity f13807a;

        private zza(SignInHubActivity signInHubActivity) {
            this.f13807a = signInHubActivity;
        }

        public final Loader<Void> mo1526a() {
            return new zzb(this.f13807a, GoogleApiClient.m4644a());
        }

        public final /* synthetic */ void mo1527a(Object obj) {
            this.f13807a.setResult(this.f13807a.f19809e, this.f13807a.f19810f);
            this.f13807a.finish();
        }

        public final void mo1528b() {
        }
    }

    private final void m21536a() {
        getSupportLoaderManager().mo252a(0, new zza());
        f19805a = false;
    }

    private final void m21537a(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f19805a = false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onCreate(android.os.Bundle r6) {
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
        r5 = this;
        super.onCreate(r6);
        r0 = r5.getIntent();
        r1 = r0.getAction();
        r2 = "com.google.android.gms.auth.NO_IMPL";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0019;
    L_0x0013:
        r6 = 12500; // 0x30d4 float:1.7516E-41 double:6.176E-320;
        r5.m21537a(r6);
        return;
    L_0x0019:
        r2 = f19805a;
        r3 = 0;
        if (r2 == 0) goto L_0x0027;
    L_0x001e:
        r5.setResult(r3);
        r6 = 12502; // 0x30d6 float:1.7519E-41 double:6.177E-320;
        r5.m21537a(r6);
        return;
    L_0x0027:
        r2 = 1;
        f19805a = r2;
        r4 = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x005d;
    L_0x0032:
        r4 = "com.google.android.gms.auth.APPAUTH_SIGN_IN";
        r4 = r1.equals(r4);
        if (r4 != 0) goto L_0x005d;
    L_0x003a:
        r6 = "AuthSignInClient";
        r1 = "Unknown action: ";
        r0 = r0.getAction();
        r0 = java.lang.String.valueOf(r0);
        r2 = r0.length();
        if (r2 == 0) goto L_0x0051;
    L_0x004c:
        r0 = r1.concat(r0);
        goto L_0x0056;
    L_0x0051:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x0056:
        android.util.Log.e(r6, r0);
        r5.finish();
        return;
    L_0x005d:
        r4 = "config";
        r0 = r0.getBundleExtra(r4);
        r4 = "config";
        r0 = r0.getParcelable(r4);
        r0 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r0;
        r5.f19807c = r0;
        r0 = r5.f19807c;
        if (r0 != 0) goto L_0x007f;
    L_0x0071:
        r6 = "AuthSignInClient";
        r0 = "Activity started with invalid configuration.";
        android.util.Log.e(r6, r0);
        r5.setResult(r3);
        r5.finish();
        return;
    L_0x007f:
        if (r6 != 0) goto L_0x00b6;
    L_0x0081:
        r6 = new android.content.Intent;
        r6.<init>(r1);
        r0 = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0094;
    L_0x008e:
        r0 = "com.google.android.gms";
    L_0x0090:
        r6.setPackage(r0);
        goto L_0x0099;
    L_0x0094:
        r0 = r5.getPackageName();
        goto L_0x0090;
    L_0x0099:
        r0 = "config";
        r1 = r5.f19807c;
        r6.putExtra(r0, r1);
        r0 = 40962; // 0xa002 float:5.74E-41 double:2.0238E-319;
        r5.startActivityForResult(r6, r0);	 Catch:{ ActivityNotFoundException -> 0x00a7 }
        return;
    L_0x00a7:
        r5.f19806b = r2;
        r6 = "AuthSignInClient";
        r0 = "Could not launch sign in Intent. Google Play Service is probably being updated...";
        android.util.Log.w(r6, r0);
        r6 = 17;
        r5.m21537a(r6);
        return;
    L_0x00b6:
        r0 = "signingInGoogleApiClients";
        r0 = r6.getBoolean(r0);
        r5.f19808d = r0;
        r0 = r5.f19808d;
        if (r0 == 0) goto L_0x00d7;
    L_0x00c2:
        r0 = "signInResultCode";
        r0 = r6.getInt(r0);
        r5.f19809e = r0;
        r0 = "signInResultData";
        r6 = r6.getParcelable(r0);
        r6 = (android.content.Intent) r6;
        r5.f19810f = r6;
        r5.m21536a();
    L_0x00d7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.onCreate(android.os.Bundle):void");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f19808d);
        if (this.f19808d) {
            bundle.putInt("signInResultCode", this.f19809e);
            bundle.putParcelable("signInResultData", this.f19810f);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f19806b) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.f17245a != null) {
                        i = signInAccount.f17245a;
                        zzo.m4604a(this).m4607a(this.f19807c.f17248a, i);
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", i);
                        this.f19808d = true;
                        this.f19809e = i2;
                        this.f19810f = intent;
                        m21536a();
                        return;
                    } else if (intent.hasExtra("errorCode") != 0) {
                        m21537a(intent.getIntExtra("errorCode", 8));
                        return;
                    }
                }
                m21537a(8);
            }
        }
    }
}
