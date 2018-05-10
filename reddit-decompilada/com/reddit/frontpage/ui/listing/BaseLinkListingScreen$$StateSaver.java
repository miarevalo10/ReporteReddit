package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class BaseLinkListingScreen$$StateSaver<T extends BaseLinkListingScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.BaseLinkListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putInt(bundle, "lastClickedPosition", t.lastClickedPosition);
        HELPER.putInt(bundle, "lastPlayingPosition", t.lastPlayingPosition);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.lastClickedPosition = HELPER.getInt(bundle, "lastClickedPosition");
        t.lastPlayingPosition = HELPER.getInt(bundle, "lastPlayingPosition");
    }
}
