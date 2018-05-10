package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class UserAccountProvider$$StateSaver<T extends UserAccountProvider> extends AccountProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.UserAccountProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((AccountProvider) t, bundle);
        HELPER.putString(bundle, "username", t.username);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((AccountProvider) t, bundle);
        t.username = HELPER.getString(bundle, "username");
    }
}
