package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class SelfSubmitScreen$$StateSaver<T extends SelfSubmitScreen> extends BaseSubmitScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.SelfSubmitScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseSubmitScreen) t, bundle);
        HELPER.putString(bundle, "defaultText", t.defaultText);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseSubmitScreen) t, bundle);
        t.defaultText = HELPER.getString(bundle, "defaultText");
    }
}
