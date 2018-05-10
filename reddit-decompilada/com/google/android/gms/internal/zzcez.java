package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzag;

public interface zzcez extends IInterface {
    Location mo1798a(String str) throws RemoteException;

    void mo1799a(Location location) throws RemoteException;

    void mo1800a(zzcdz com_google_android_gms_internal_zzcdz) throws RemoteException;

    void mo1801a(zzceu com_google_android_gms_internal_zzceu) throws RemoteException;

    void mo1802a(zzcfq com_google_android_gms_internal_zzcfq) throws RemoteException;

    void mo1803a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzcex com_google_android_gms_internal_zzcex) throws RemoteException;

    void mo1804a(LocationSettingsRequest locationSettingsRequest, zzcfb com_google_android_gms_internal_zzcfb, String str) throws RemoteException;

    void mo1805a(zzag com_google_android_gms_location_zzag, zzcex com_google_android_gms_internal_zzcex) throws RemoteException;

    void mo1806a(boolean z) throws RemoteException;

    LocationAvailability mo1807b(String str) throws RemoteException;
}
