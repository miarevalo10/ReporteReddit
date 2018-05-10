package com.reddit.frontpage.presentation.modtools.modlist.add;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class AddModeratorScreen$$StateSaver<T extends AddModeratorScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putString(bundle, "subredditName", t.subredditName);
        HELPER.putString(bundle, "subredditId", t.subredditId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.subredditName = HELPER.getString(bundle, "subredditName");
        t.subredditId = HELPER.getString(bundle, "subredditId");
    }
}
