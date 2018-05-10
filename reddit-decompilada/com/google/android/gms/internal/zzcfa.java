package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzag;

public final class zzcfa extends zzeu implements zzcez {
    zzcfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final Location mo1798a(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(21, o_);
        Location location = (Location) zzew.m5937a(a, Location.CREATOR);
        a.recycle();
        return location;
    }

    public final void mo1799a(Location location) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) location);
        m5935b(13, o_);
    }

    public final void mo1800a(zzcdz com_google_android_gms_internal_zzcdz) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcdz);
        m5935b(75, o_);
    }

    public final void mo1801a(zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzceu);
        m5935b(67, o_);
    }

    public final void mo1802a(zzcfq com_google_android_gms_internal_zzcfq) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcfq);
        m5935b(59, o_);
    }

    public final void mo1803a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzcex com_google_android_gms_internal_zzcex) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) geofencingRequest);
        zzew.m5939a(o_, (Parcelable) pendingIntent);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzcex);
        m5935b(57, o_);
    }

    public final void mo1804a(LocationSettingsRequest locationSettingsRequest, zzcfb com_google_android_gms_internal_zzcfb, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) locationSettingsRequest);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzcfb);
        o_.writeString(str);
        m5935b(63, o_);
    }

    public final void mo1805a(zzag com_google_android_gms_location_zzag, zzcex com_google_android_gms_internal_zzcex) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_location_zzag);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzcex);
        m5935b(74, o_);
    }

    public final void mo1806a(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(12, o_);
    }

    public final LocationAvailability mo1807b(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(34, o_);
        LocationAvailability locationAvailability = (LocationAvailability) zzew.m5937a(a, LocationAvailability.CREATOR);
        a.recycle();
        return locationAvailability;
    }
}
