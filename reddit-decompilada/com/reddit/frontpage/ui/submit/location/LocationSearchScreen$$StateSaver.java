package com.reddit.frontpage.ui.submit.location;

import android.location.Location;
import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class LocationSearchScreen$$StateSaver<T extends LocationSearchScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.location.LocationSearchScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putParcelable(bundle, "location", t.location);
        HELPER.putString(bundle, "requestId", t.requestId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.location = (Location) HELPER.getParcelable(bundle, "location");
        t.requestId = HELPER.getString(bundle, "requestId");
    }
}
