package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public final class zzchg extends zzeu implements zzche {
    zzchg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzcln> mo1831a(zzcgi com_google_android_gms_internal_zzcgi, boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        zzew.m5940a(o_, z);
        Parcel a = m5934a(7, o_);
        List createTypedArrayList = a.createTypedArrayList(zzcln.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzcgl> mo1832a(String str, String str2, zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        Parcel a = m5934a(16, o_);
        List createTypedArrayList = a.createTypedArrayList(zzcgl.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzcgl> mo1833a(String str, String str2, String str3) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        o_.writeString(str3);
        Parcel a = m5934a(17, o_);
        List createTypedArrayList = a.createTypedArrayList(zzcgl.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzcln> mo1834a(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        o_.writeString(str3);
        zzew.m5940a(o_, z);
        Parcel a = m5934a(15, o_);
        List createTypedArrayList = a.createTypedArrayList(zzcln.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzcln> mo1835a(String str, String str2, boolean z, zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        zzew.m5940a(o_, z);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        Parcel a = m5934a(14, o_);
        List createTypedArrayList = a.createTypedArrayList(zzcln.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final void mo1836a(long j, String str, String str2, String str3) throws RemoteException {
        Parcel o_ = o_();
        o_.writeLong(j);
        o_.writeString(str);
        o_.writeString(str2);
        o_.writeString(str3);
        m5935b(10, o_);
    }

    public final void mo1837a(zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        m5935b(4, o_);
    }

    public final void mo1838a(zzcgl com_google_android_gms_internal_zzcgl) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgl);
        m5935b(13, o_);
    }

    public final void mo1839a(zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgl);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        m5935b(12, o_);
    }

    public final void mo1840a(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcha);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        m5935b(1, o_);
    }

    public final void mo1841a(zzcha com_google_android_gms_internal_zzcha, String str, String str2) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcha);
        o_.writeString(str);
        o_.writeString(str2);
        m5935b(5, o_);
    }

    public final void mo1842a(zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcln);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        m5935b(2, o_);
    }

    public final byte[] mo1843a(zzcha com_google_android_gms_internal_zzcha, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcha);
        o_.writeString(str);
        Parcel a = m5934a(9, o_);
        byte[] createByteArray = a.createByteArray();
        a.recycle();
        return createByteArray;
    }

    public final void mo1844b(zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        m5935b(6, o_);
    }

    public final String mo1845c(zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        Parcel a = m5934a(11, o_);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo1846d(zzcgi com_google_android_gms_internal_zzcgi) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzcgi);
        m5935b(18, o_);
    }
}
