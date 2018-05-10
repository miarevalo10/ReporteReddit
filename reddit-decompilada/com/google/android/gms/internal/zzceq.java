package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.zzag;
import java.util.List;

public final class zzceq implements GeofencingApi {
    private static PendingResult<Status> m13441a(GoogleApiClient googleApiClient, zzag com_google_android_gms_location_zzag) {
        return googleApiClient.mo1597b(new zzces(googleApiClient, com_google_android_gms_location_zzag));
    }

    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.mo1597b(new zzcer(googleApiClient, geofencingRequest, pendingIntent));
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return m13441a(googleApiClient, zzag.m19192a(pendingIntent));
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return m13441a(googleApiClient, zzag.m19193a((List) list));
    }

    @Deprecated
    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        if (list != null) {
            if (!list.isEmpty()) {
                for (Object obj : list) {
                    if (obj != null) {
                        zzbq.m4809a(obj, (Object) "geofence can't be null.");
                        zzbq.m4818b(obj instanceof zzcfs, "Geofence must be created using Geofence.Builder.");
                        builder.f8199a.add((zzcfs) obj);
                    }
                }
            }
        }
        builder.f8200b = 5;
        zzbq.m4818b(builder.f8199a.isEmpty() ^ 1, "No geofence has been added to this request.");
        return addGeofences(googleApiClient, new GeofencingRequest(builder.f8199a, builder.f8200b, builder.f8201c), pendingIntent);
    }
}
