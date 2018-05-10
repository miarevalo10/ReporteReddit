package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import java.util.HashMap;

public class LiveThreadProvider$$StateSaver<T extends LiveThreadProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.LiveThreadProvider$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("liveThread", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putWithBundler(bundle, "liveThread", t.liveThread);
        HELPER.putString(bundle, "liveThreadId", t.liveThreadId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.liveThread = (LiveThread) HELPER.getWithBundler(bundle, "liveThread");
        t.liveThreadId = HELPER.getString(bundle, "liveThreadId");
    }
}
