package com.reddit.frontpage.ui.live;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.data.provider.LiveThreadProvider;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.BaseFrontpageFragment$$StateSaver;
import java.util.HashMap;

public class LiveThreadContainerFragment$$StateSaver<T extends LiveThreadContainerFragment> extends BaseFrontpageFragment$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.live.LiveThreadContainerFragment$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("provider", new ParcelerBundler());
        BUNDLERS.put("liveThread", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseFrontpageFragment) t, bundle);
        HELPER.putBoolean(bundle, "enablePaging", t.enablePaging);
        HELPER.putWithBundler(bundle, "provider", t.provider);
        HELPER.putWithBundler(bundle, "liveThread", t.liveThread);
        HELPER.putString(bundle, "liveThreadId", t.liveThreadId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseFrontpageFragment) t, bundle);
        t.enablePaging = HELPER.getBoolean(bundle, "enablePaging");
        t.provider = (LiveThreadProvider) HELPER.getWithBundler(bundle, "provider");
        t.liveThread = (LiveThread) HELPER.getWithBundler(bundle, "liveThread");
        t.liveThreadId = HELPER.getString(bundle, "liveThreadId");
    }
}
