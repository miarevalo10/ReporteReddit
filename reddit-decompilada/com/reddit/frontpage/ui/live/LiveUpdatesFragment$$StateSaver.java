package com.reddit.frontpage.ui.live;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.BaseFrontpageFragment$$StateSaver;
import java.util.HashMap;
import java.util.List;

public class LiveUpdatesFragment$$StateSaver<T extends LiveUpdatesFragment> extends BaseFrontpageFragment$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.live.LiveUpdatesFragment$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("liveThread", new ParcelerBundler());
        BUNDLERS.put("updates", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseFrontpageFragment) t, bundle);
        HELPER.putWithBundler(bundle, "liveThread", t.liveThread);
        HELPER.putWithBundler(bundle, "updates", t.updates);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseFrontpageFragment) t, bundle);
        t.liveThread = (LiveThread) HELPER.getWithBundler(bundle, "liveThread");
        t.updates = (List) HELPER.getWithBundler(bundle, "updates");
    }
}
