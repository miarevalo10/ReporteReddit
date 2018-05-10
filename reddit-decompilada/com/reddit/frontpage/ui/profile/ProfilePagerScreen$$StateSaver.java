package com.reddit.frontpage.ui.profile;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class ProfilePagerScreen$$StateSaver<T extends ProfilePagerScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.profile.ProfilePagerScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putBoolean(bundle, "following", t.following);
        HELPER.putBoolean(bundle, "self", t.self);
        HELPER.putInt(bundle, "screenPosition", t.screenPosition);
        HELPER.putString(bundle, "subredditName", t.subredditName);
        HELPER.putString(bundle, "subredditId", t.subredditId);
        HELPER.putString(bundle, "userId", t.userId);
        HELPER.putString(bundle, "username", t.username);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.following = HELPER.getBoolean(bundle, "following");
        t.self = HELPER.getBoolean(bundle, "self");
        t.screenPosition = HELPER.getInt(bundle, "screenPosition");
        t.subredditName = HELPER.getString(bundle, "subredditName");
        t.subredditId = HELPER.getString(bundle, "subredditId");
        t.userId = HELPER.getString(bundle, "userId");
        t.username = HELPER.getString(bundle, "username");
    }
}
