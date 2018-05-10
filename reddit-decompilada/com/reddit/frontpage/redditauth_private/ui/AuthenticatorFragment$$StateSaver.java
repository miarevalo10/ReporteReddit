package com.reddit.frontpage.redditauth_private.ui;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.Object;
import java.util.HashMap;

public class AuthenticatorFragment$$StateSaver<T extends AuthenticatorFragment> extends Object<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.redditauth_private.ui.AuthenticatorFragment$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        HELPER.putBoolean(bundle, "Backup", t.isBackup);
    }

    public void restore(T t, Bundle bundle) {
        t.isBackup = HELPER.getBoolean(bundle, "Backup");
    }
}
