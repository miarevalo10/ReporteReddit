package com.reddit.frontpage.ui;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class LoggedOutScreen$$StateSaver<T extends LoggedOutScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.LoggedOutScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putInt(bundle, "textRes", t.textRes);
        HELPER.putInt(bundle, "titleRes", t.titleRes);
        HELPER.putBoxedBoolean(bundle, "fullScreenOverride", t.fullScreenOverride);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.textRes = HELPER.getInt(bundle, "textRes");
        t.titleRes = HELPER.getInt(bundle, "titleRes");
        t.fullScreenOverride = HELPER.getBoxedBoolean(bundle, "fullScreenOverride");
    }
}
