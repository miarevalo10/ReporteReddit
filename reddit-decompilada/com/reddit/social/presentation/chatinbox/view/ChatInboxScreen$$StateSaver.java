package com.reddit.social.presentation.chatinbox.view;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen.ChatNavType;
import java.util.HashMap;

public class ChatInboxScreen$$StateSaver<T extends ChatInboxScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.social.presentation.chatinbox.view.ChatInboxScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putSerializable(bundle, "ChatNavType", t.chatNavType);
        HELPER.putString(bundle, "Url", t.url);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.m41171a((ChatNavType) HELPER.getSerializable(bundle, "ChatNavType"));
        t.m41172a(HELPER.getString(bundle, "Url"));
    }
}
