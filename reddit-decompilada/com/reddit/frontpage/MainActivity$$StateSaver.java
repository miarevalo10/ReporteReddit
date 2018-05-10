package com.reddit.frontpage;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.Object;
import java.util.HashMap;

public class MainActivity$$StateSaver<T extends MainActivity> extends Object<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.MainActivity$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        HELPER.putString(bundle, "bottomNavInstanceId", t.bottomNavInstanceId);
    }

    public void restore(T t, Bundle bundle) {
        t.bottomNavInstanceId = HELPER.getString(bundle, "bottomNavInstanceId");
    }
}
