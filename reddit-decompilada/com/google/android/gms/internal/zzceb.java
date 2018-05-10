package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public final class zzceb implements FusedLocationProviderApi {
    public final PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1597b(new zzceg(googleApiClient));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.mo1597b(new zzcel(googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.mo1597b(new zzced(googleApiClient, locationCallback));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.mo1597b(new zzcek(googleApiClient, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.mo1597b(new zzcej(googleApiClient, locationRequest, pendingIntent));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.mo1597b(new zzcei(googleApiClient, locationRequest, locationCallback, looper));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        zzbq.m4809a(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return googleApiClient.mo1597b(new zzcec(googleApiClient, locationRequest, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.mo1597b(new zzceh(googleApiClient, locationRequest, locationListener, looper));
    }

    public final PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.mo1597b(new zzcef(googleApiClient, location));
    }

    public final PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.mo1597b(new zzcee(googleApiClient, z));
    }

    public final android.location.Location getLastLocation(com.google.android.gms.common.api.GoogleApiClient r2) {
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
        r1 = this;
        r2 = com.google.android.gms.location.LocationServices.m6840a(r2);
        r2 = r2.f19568i;	 Catch:{ Exception -> 0x001e }
        r0 = r2.f6781a;	 Catch:{ Exception -> 0x001e }
        r0.mo1779a();	 Catch:{ Exception -> 0x001e }
        r0 = r2.f6781a;	 Catch:{ Exception -> 0x001e }
        r0 = r0.mo1780b();	 Catch:{ Exception -> 0x001e }
        r0 = (com.google.android.gms.internal.zzcez) r0;	 Catch:{ Exception -> 0x001e }
        r2 = r2.f6782b;	 Catch:{ Exception -> 0x001e }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x001e }
        r2 = r0.mo1798a(r2);	 Catch:{ Exception -> 0x001e }
        return r2;
    L_0x001e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzceb.getLastLocation(com.google.android.gms.common.api.GoogleApiClient):android.location.Location");
    }

    public final com.google.android.gms.location.LocationAvailability getLocationAvailability(com.google.android.gms.common.api.GoogleApiClient r2) {
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
        r1 = this;
        r2 = com.google.android.gms.location.LocationServices.m6840a(r2);
        r2 = r2.f19568i;	 Catch:{ Exception -> 0x001e }
        r0 = r2.f6781a;	 Catch:{ Exception -> 0x001e }
        r0.mo1779a();	 Catch:{ Exception -> 0x001e }
        r0 = r2.f6781a;	 Catch:{ Exception -> 0x001e }
        r0 = r0.mo1780b();	 Catch:{ Exception -> 0x001e }
        r0 = (com.google.android.gms.internal.zzcez) r0;	 Catch:{ Exception -> 0x001e }
        r2 = r2.f6782b;	 Catch:{ Exception -> 0x001e }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x001e }
        r2 = r0.mo1807b(r2);	 Catch:{ Exception -> 0x001e }
        return r2;
    L_0x001e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzceb.getLocationAvailability(com.google.android.gms.common.api.GoogleApiClient):com.google.android.gms.location.LocationAvailability");
    }
}
