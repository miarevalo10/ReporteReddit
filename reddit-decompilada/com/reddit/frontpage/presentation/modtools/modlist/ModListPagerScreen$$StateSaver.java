package com.reddit.frontpage.presentation.modtools.modlist;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class ModListPagerScreen$$StateSaver<T extends ModListPagerScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.modtools.modlist.ModListPagerScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putString(bundle, "subredditId", t.subredditId);
        HELPER.putString(bundle, "subredditName", t.subredditName);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.subredditId = HELPER.getString(bundle, "subredditId");
        t.subredditName = HELPER.getString(bundle, "subredditName");
    }
}
