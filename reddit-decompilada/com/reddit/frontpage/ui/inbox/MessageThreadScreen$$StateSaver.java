package com.reddit.frontpage.ui.inbox;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class MessageThreadScreen$$StateSaver<T extends MessageThreadScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.inbox.MessageThreadScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putString(bundle, "correspondent", t.correspondent);
        HELPER.putString(bundle, "requestId", t.requestId);
        HELPER.putString(bundle, "threadId", t.threadId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.correspondent = HELPER.getString(bundle, "correspondent");
        t.requestId = HELPER.getString(bundle, "requestId");
        t.threadId = HELPER.getString(bundle, "threadId");
    }
}
