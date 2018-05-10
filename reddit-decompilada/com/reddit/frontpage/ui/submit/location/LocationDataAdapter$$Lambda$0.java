package com.reddit.frontpage.ui.submit.location;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.foursquare.model.LocationDistance;

final /* synthetic */ class LocationDataAdapter$$Lambda$0 implements OnClickListener {
    private final LocationDataAdapter f21636a;
    private final LocationDistance f21637b;

    LocationDataAdapter$$Lambda$0(LocationDataAdapter locationDataAdapter, LocationDistance locationDistance) {
        this.f21636a = locationDataAdapter;
        this.f21637b = locationDistance;
    }

    public final void onClick(View view) {
        view = this.f21636a;
        view.f29348b.m39589a(this.f21637b);
    }
}
