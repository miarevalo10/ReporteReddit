package com.reddit.frontpage.ui;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class BottomNavScreen$$StateSaver<T extends BottomNavScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.BottomNavScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putBoolean(bundle, "bottomNavIsActive", t.bottomNavIsActive);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.bottomNavIsActive = HELPER.getBoolean(bundle, "bottomNavIsActive");
    }
}
