package com.reddit.frontpage.ui.profile.profilesettings.view;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.io.File;
import java.util.HashMap;

public class ProfileSettingsScreen$$StateSaver<T extends ProfileSettingsScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.profile.profilesettings.view.ProfileSettingsScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putSerializable(bundle, "tempImageFile", t.tempImageFile);
        HELPER.putString(bundle, "userSubredditDisplayName", t.userSubredditDisplayName);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.tempImageFile = (File) HELPER.getSerializable(bundle, "tempImageFile");
        t.userSubredditDisplayName = HELPER.getString(bundle, "userSubredditDisplayName");
    }
}
