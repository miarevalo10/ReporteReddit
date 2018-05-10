package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzcfs;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends zzbfm {
    public static final Creator<GeofencingRequest> CREATOR = new zzl();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final String mTag;
    private final List<zzcfs> zzijj;
    private final int zzijk;

    public static final class Builder {
        public final List<zzcfs> f8199a = new ArrayList();
        public int f8200b = 5;
        public String f8201c = "";
    }

    public GeofencingRequest(List<zzcfs> list, int i, String str) {
        this.zzijj = list;
        this.zzijk = i;
        this.mTag = str;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.zzijj);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzijk;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeofencingRequest[");
        stringBuilder.append("geofences=");
        stringBuilder.append(this.zzijj);
        int i = this.zzijk;
        StringBuilder stringBuilder2 = new StringBuilder(30);
        stringBuilder2.append(", initialTrigger=");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder.append(stringBuilder2.toString());
        String str = "tag=";
        String valueOf = String.valueOf(this.mTag);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5559c(parcel, 1, this.zzijj);
        zzbfp.m5540a(parcel, 2, getInitialTrigger());
        zzbfp.m5545a(parcel, 3, this.mTag);
        zzbfp.m5537a(parcel, i);
    }
}
