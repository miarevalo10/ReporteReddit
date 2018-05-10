package com.reddit.datalibrary.frontpage.data.provider;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionFailed"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeocodedAddressProvider.kt */
final class GeocodedAddressProvider$googleApiClient$1 implements OnConnectionFailedListener {
    final /* synthetic */ GeocodedAddressProvider f16240a;

    GeocodedAddressProvider$googleApiClient$1(GeocodedAddressProvider geocodedAddressProvider) {
        this.f16240a = geocodedAddressProvider;
    }

    public final void mo1583a(ConnectionResult connectionResult) {
        Intrinsics.b(connectionResult, "it");
        this.f16240a.f16243b.onError(new Exception("LocationDataProvider.publishLocation(): ACCESS_COARSE_LOCATION permission not granted"));
    }
}
