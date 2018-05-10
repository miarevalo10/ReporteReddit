package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import java.util.HashMap;

public class BaseListingProvider2$$StateSaver<T extends BaseListingProvider2> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.BaseListingProvider2$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("listing", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putWithBundler(bundle, "listing", t.listing);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.listing = (Listing) HELPER.getWithBundler(bundle, "listing");
    }
}
