package com.reddit.datalibrary.frontpage.data.provider;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;

public class LocationDataProvider extends BaseOtherProvider implements ConnectionCallbacks, OnConnectionFailedListener {
    private final PublishSubject<Location> f16263a = PublishSubject.create();
    private GoogleApiClient f16264b;
    private final WeakReference<Activity> f16265c;

    public final void mo1581a(int i) {
    }

    public LocationDataProvider(Activity activity) {
        this.f16265c = new WeakReference(activity);
    }

    public void finish() {
        super.finish();
        this.f16265c.clear();
    }

    public final synchronized Observable<Location> m16271a() {
        if (this.f16264b == null) {
            this.f16264b = new Builder(FrontpageApplication.a).m4638a((ConnectionCallbacks) this).m4639a((OnConnectionFailedListener) this).m4636a(LocationServices.f8202a).m4640a();
        }
        if (!(this.f16264b.mo1568j() || this.f16264b.mo1569k())) {
            this.f16264b.mo1563e();
        }
        return this.f16263a.toSerialized();
    }

    public final void mo1582a(Bundle bundle) {
        if (this.f16265c.get() == null) {
            this.f16263a.onError(new Exception("LocationDataProvider.onConnected(): null Activity reference"));
            return;
        }
        bundle = LocationServices.f8203b.getLastLocation(this.f16264b);
        if (bundle != null) {
            this.f16263a.onNext(bundle);
        } else {
            this.f16263a.onError(new Exception("LocationDataProvider.publishLocation(): lastLocation is null"));
        }
        this.f16264b.mo1565g();
    }

    public final void mo1583a(ConnectionResult connectionResult) {
        this.f16263a.onError(new Exception("LocationDataProvider.publishLocation(): ACCESS_COARSE_LOCATION permission not granted"));
    }
}
