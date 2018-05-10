package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.Object;
import java.util.HashMap;

public class BaseOtherProvider$$StateSaver<T extends BaseOtherProvider> extends Object<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        HELPER.putString(bundle, "providerId", t.providerId);
    }

    public void restore(T t, Bundle bundle) {
        t.providerId = HELPER.getString(bundle, "providerId");
    }
}
