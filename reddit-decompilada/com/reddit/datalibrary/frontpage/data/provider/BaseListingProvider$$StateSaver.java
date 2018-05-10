package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.SerializableBundler;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseListingProvider$$StateSaver<T extends BaseListingProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.BaseListingProvider$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("mObjects", new SerializableBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putString(bundle, "mAfter", t.mAfter);
        HELPER.putWithBundler(bundle, "mObjects", t.mObjects);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.mAfter = HELPER.getString(bundle, "mAfter");
        t.mObjects = (ArrayList) HELPER.getWithBundler(bundle, "mObjects");
    }
}
