package com.reddit.frontpage.ui.preferences;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.Object;
import java.util.HashMap;

public class PreferencesFragment$$StateSaver<T extends PreferencesFragment> extends Object<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.preferences.PreferencesFragment$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        HELPER.putInt(bundle, "resultCode", t.resultCode);
    }

    public void restore(T t, Bundle bundle) {
        t.resultCode = HELPER.getInt(bundle, "resultCode");
    }
}
