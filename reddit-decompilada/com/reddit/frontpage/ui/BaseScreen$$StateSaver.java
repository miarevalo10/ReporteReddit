package com.reddit.frontpage.ui;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.Object;
import java.util.HashMap;

public class BaseScreen$$StateSaver<T extends BaseScreen> extends Object<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.BaseScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        HELPER.putBoolean(bundle, "suppressScreenViewEvent", t.suppressScreenViewEvent);
        HELPER.putString(bundle, "eventRequestId", t.eventRequestId);
    }

    public void restore(T t, Bundle bundle) {
        t.suppressScreenViewEvent = HELPER.getBoolean(bundle, "suppressScreenViewEvent");
        t.eventRequestId = HELPER.getString(bundle, "eventRequestId");
    }
}
