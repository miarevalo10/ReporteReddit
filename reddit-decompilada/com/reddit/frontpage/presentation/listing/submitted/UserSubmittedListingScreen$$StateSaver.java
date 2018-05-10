package com.reddit.frontpage.presentation.listing.submitted;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class UserSubmittedListingScreen$$StateSaver<T extends UserSubmittedListingScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putInt(bundle, "LastPlayingPosition", t.lastPlayingPosition);
        HELPER.putInt(bundle, "LastClickedPosition", t.lastClickedPosition);
        HELPER.putString(bundle, "username", t.username);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.lastPlayingPosition = HELPER.getInt(bundle, "LastPlayingPosition");
        t.lastClickedPosition = HELPER.getInt(bundle, "LastClickedPosition");
        t.username = HELPER.getString(bundle, "username");
    }
}
