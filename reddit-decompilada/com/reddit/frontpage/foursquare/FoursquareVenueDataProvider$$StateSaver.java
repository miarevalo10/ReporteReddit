package com.reddit.frontpage.foursquare;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider$.StateSaver;
import java.util.HashMap;

public class FoursquareVenueDataProvider$$StateSaver<T extends FoursquareVenueDataProvider> extends StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.foursquare.FoursquareVenueDataProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save(t, bundle);
        HELPER.putString(bundle, "latlong", t.latlong);
    }

    public void restore(T t, Bundle bundle) {
        super.restore(t, bundle);
        t.latlong = HELPER.getString(bundle, "latlong");
    }
}
