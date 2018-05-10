package com.reddit.frontpage.ui.inbox;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class ComposeScreen$$StateSaver<T extends ComposeScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.inbox.ComposeScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putBoolean(bundle, "isContactingMods", t.isContactingMods);
        HELPER.putString(bundle, "recipient", t.recipient);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.isContactingMods = HELPER.getBoolean(bundle, "isContactingMods");
        t.recipient = HELPER.getString(bundle, "recipient");
    }
}
