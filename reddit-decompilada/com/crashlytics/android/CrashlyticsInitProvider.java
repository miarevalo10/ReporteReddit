package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.services.common.FirebaseInfo;

public class CrashlyticsInitProvider extends ContentProvider {
    private static final String TAG = "CrashlyticsInitProvider";

    interface EnabledCheckStrategy {
        boolean isCrashlyticsEnabled(Context context);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
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
        r0 = r5.getContext();
        r1 = new io.fabric.sdk.android.services.common.FirebaseInfo;
        r1.<init>();
        r2 = new com.crashlytics.android.ManifestEnabledCheckStrategy;
        r2.<init>();
        r1 = r5.shouldInitializeFabric(r0, r1, r2);
        r2 = 1;
        if (r1 == 0) goto L_0x003a;
    L_0x0015:
        r1 = 0;
        r3 = new io.fabric.sdk.android.Kit[r2];	 Catch:{ IllegalStateException -> 0x002e }
        r4 = new com.crashlytics.android.Crashlytics;	 Catch:{ IllegalStateException -> 0x002e }
        r4.<init>();	 Catch:{ IllegalStateException -> 0x002e }
        r3[r1] = r4;	 Catch:{ IllegalStateException -> 0x002e }
        io.fabric.sdk.android.Fabric.a(r0, r3);	 Catch:{ IllegalStateException -> 0x002e }
        r0 = io.fabric.sdk.android.Fabric.b();	 Catch:{ IllegalStateException -> 0x002e }
        r3 = "CrashlyticsInitProvider";	 Catch:{ IllegalStateException -> 0x002e }
        r4 = "CrashlyticsInitProvider initialization successful";	 Catch:{ IllegalStateException -> 0x002e }
        r0.c(r3, r4);	 Catch:{ IllegalStateException -> 0x002e }
        goto L_0x003a;
    L_0x002e:
        r0 = io.fabric.sdk.android.Fabric.b();
        r2 = "CrashlyticsInitProvider";
        r3 = "CrashlyticsInitProvider initialization unsuccessful";
        r0.c(r2, r3);
        return r1;
    L_0x003a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.CrashlyticsInitProvider.onCreate():boolean");
    }

    boolean shouldInitializeFabric(Context context, FirebaseInfo firebaseInfo, EnabledCheckStrategy enabledCheckStrategy) {
        return (FirebaseInfo.b(context) == null || enabledCheckStrategy.isCrashlyticsEnabled(context) == null) ? null : true;
    }
}
