package com.reddit.datalibrary.frontpage.data.provider;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.subjects.SingleSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\b0\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "()V", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "kotlin.jvm.PlatformType", "locationObservable", "Lio/reactivex/subjects/SingleSubject;", "Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressEvent;", "fetchAddress", "locationToAddress", "", "Landroid/location/Address;", "location", "Landroid/location/Location;", "maxResults", "", "onConnected", "", "bundle", "Landroid/os/Bundle;", "onConnectionSuspended", "i", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeocodedAddressProvider.kt */
public final class GeocodedAddressProvider implements ConnectionCallbacks {
    public static final Companion f16241a = new Companion();
    private static final String f16242d = "GeocodedAddressProvider";
    private final SingleSubject<GeocodedAddressEvent> f16243b = SingleSubject.a();
    private final GoogleApiClient f16244c = new Builder(FrontpageApplication.a).m4638a((ConnectionCallbacks) this).m4639a((OnConnectionFailedListener) new GeocodedAddressProvider$googleApiClient$1(this)).m4636a(LocationServices.f8202a).m4640a();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/GeocodedAddressProvider$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeocodedAddressProvider.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final void mo1581a(int i) {
    }

    public final SingleSubject<GeocodedAddressEvent> m16248a() {
        Timber.a(f16242d);
        this.f16244c.mo1563e();
        SingleSubject<GeocodedAddressEvent> singleSubject = this.f16243b;
        Intrinsics.a(singleSubject, "locationObservable");
        return singleSubject;
    }

    public final void mo1582a(android.os.Bundle r10) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r10 = 0;
        r0 = com.google.android.gms.location.LocationServices.f8203b;	 Catch:{ SecurityException -> 0x0064 }
        r1 = r9.f16244c;	 Catch:{ SecurityException -> 0x0064 }
        r0 = r0.getLastLocation(r1);	 Catch:{ SecurityException -> 0x0064 }
        if (r0 != 0) goto L_0x0013;	 Catch:{ SecurityException -> 0x0064 }
    L_0x000b:
        r0 = r9.f16243b;	 Catch:{ SecurityException -> 0x0064 }
        r1 = com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Error.f16238a;	 Catch:{ SecurityException -> 0x0064 }
        r0.onSuccess(r1);	 Catch:{ SecurityException -> 0x0064 }
        goto L_0x0075;
    L_0x0013:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005c }
        r2 = "Geocode address for lat: ";	 Catch:{ IOException -> 0x005c }
        r1.<init>(r2);	 Catch:{ IOException -> 0x005c }
        r2 = r0.getLatitude();	 Catch:{ IOException -> 0x005c }
        r1.append(r2);	 Catch:{ IOException -> 0x005c }
        r2 = " long: ";	 Catch:{ IOException -> 0x005c }
        r1.append(r2);	 Catch:{ IOException -> 0x005c }
        r2 = r0.getLongitude();	 Catch:{ IOException -> 0x005c }
        r1.append(r2);	 Catch:{ IOException -> 0x005c }
        r1 = r1.toString();	 Catch:{ IOException -> 0x005c }
        r2 = new java.lang.Object[r10];	 Catch:{ IOException -> 0x005c }
        timber.log.Timber.b(r1, r2);	 Catch:{ IOException -> 0x005c }
        r3 = new android.location.Geocoder;	 Catch:{ IOException -> 0x005c }
        r1 = com.reddit.frontpage.FrontpageApplication.a;	 Catch:{ IOException -> 0x005c }
        r1 = (android.content.Context) r1;	 Catch:{ IOException -> 0x005c }
        r3.<init>(r1);	 Catch:{ IOException -> 0x005c }
        r4 = r0.getLatitude();	 Catch:{ IOException -> 0x005c }
        r6 = r0.getLongitude();	 Catch:{ IOException -> 0x005c }
        r8 = 1;	 Catch:{ IOException -> 0x005c }
        r0 = r3.getFromLocation(r4, r6, r8);	 Catch:{ IOException -> 0x005c }
        r1 = "geocoder.getFromLocation…on.longitude, maxResults)";	 Catch:{ IOException -> 0x005c }
        kotlin.jvm.internal.Intrinsics.a(r0, r1);	 Catch:{ IOException -> 0x005c }
        r1 = r9.f16243b;	 Catch:{ IOException -> 0x005c }
        r2 = new com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent$Result;	 Catch:{ IOException -> 0x005c }
        r2.<init>(r0);	 Catch:{ IOException -> 0x005c }
        r1.onSuccess(r2);	 Catch:{ IOException -> 0x005c }
        goto L_0x0075;
    L_0x005c:
        r0 = r9.f16243b;	 Catch:{ SecurityException -> 0x0064 }
        r1 = com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Error.f16238a;	 Catch:{ SecurityException -> 0x0064 }
        r0.onSuccess(r1);	 Catch:{ SecurityException -> 0x0064 }
        goto L_0x0075;
    L_0x0064:
        r0 = move-exception;
        r0 = (java.lang.Throwable) r0;
        r1 = "Security exception while trying to access current location";
        r10 = new java.lang.Object[r10];
        timber.log.Timber.c(r0, r1, r10);
        r10 = r9.f16243b;
        r0 = com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressEvent.Error.f16238a;
        r10.onSuccess(r0);
    L_0x0075:
        r10 = r9.f16244c;
        r10.mo1565g();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider.a(android.os.Bundle):void");
    }
}
