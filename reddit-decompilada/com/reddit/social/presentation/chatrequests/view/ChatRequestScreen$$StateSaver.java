package com.reddit.social.presentation.chatrequests.view;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;
import net.hockeyapp.android.UpdateFragment;

public class ChatRequestScreen$$StateSaver<T extends ChatRequestScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.social.presentation.chatrequests.view.ChatRequestScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putString(bundle, UpdateFragment.FRAGMENT_URL, t.url);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.url = HELPER.getString(bundle, UpdateFragment.FRAGMENT_URL);
    }
}
