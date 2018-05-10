package com.reddit.frontpage.foursquare;

import android.location.Address;
import android.location.Geocoder;
import com.android.volley.VolleyError;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder.Callbacks;
import com.reddit.frontpage.foursquare.model.LocationDistance;
import io.reactivex.subjects.PublishSubject;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import timber.log.Timber;

public class FoursquareVenueDataProvider extends BaseOtherProvider {
    public final PublishSubject<List<LocationDistance>> f28032a = PublishSubject.create();
    public final PublishSubject<List<LocationDistance>> f28033b = PublishSubject.create();
    private final String f28034c = this.f28035d.getUsername();
    private final Session f28035d = SessionManager.b().c;
    @State
    public String latlong;

    class C22921 implements Callbacks<List<LocationDistance>> {
        final /* synthetic */ FoursquareVenueDataProvider f28030a;

        public C22921(FoursquareVenueDataProvider foursquareVenueDataProvider) {
            this.f28030a = foursquareVenueDataProvider;
        }

        public final /* synthetic */ void m29335a(Object obj) {
            this.f28030a.f28032a.onNext((List) obj);
        }

        public final void m29334a(VolleyError volleyError) {
            Timber.c(volleyError, "Issue retrieving venues", new Object[0]);
            this.f28030a.f28032a.onNext(Collections.emptyList());
        }
    }

    class C22932 implements Callbacks<List<LocationDistance>> {
        final /* synthetic */ FoursquareVenueDataProvider f28031a;

        public C22932(FoursquareVenueDataProvider foursquareVenueDataProvider) {
            this.f28031a = foursquareVenueDataProvider;
        }

        public final /* synthetic */ void m29337a(Object obj) {
            this.f28031a.f28033b.onNext((List) obj);
        }

        public final void m29336a(VolleyError volleyError) {
            Timber.c(volleyError, "Issue retrieving events", new Object[0]);
            this.f28031a.f28033b.onNext(Collections.emptyList());
        }
    }

    static void m29339a(Geocoder geocoder, List<LocationDistance> list, Map<String, LocationDistance> map) {
        for (LocationDistance locationDistance : list) {
            if (!(locationDistance.f20308e == null || map.containsKey(locationDistance.f20308e))) {
                Object obj = null;
                try {
                    List fromLocationName = geocoder.getFromLocationName(locationDistance.f20308e, 1);
                    if (!(fromLocationName == null || fromLocationName.isEmpty())) {
                        Address address = (Address) fromLocationName.get(0);
                        obj = new LocationDistance(locationDistance.f20308e, Double.valueOf(address.getLatitude()), Double.valueOf(address.getLongitude()), -1.0d, locationDistance.f20308e);
                    }
                } catch (Throwable e) {
                    Timber.a(e, "Failed to get location for city", new Object[0]);
                }
                if (obj == null) {
                    LocationDistance locationDistance2 = new LocationDistance(locationDistance.f20308e, locationDistance.f20305b, locationDistance.f20306c, -1.0d, locationDistance.f20308e);
                }
                map.put(locationDistance.f20308e, obj);
            }
        }
    }
}
