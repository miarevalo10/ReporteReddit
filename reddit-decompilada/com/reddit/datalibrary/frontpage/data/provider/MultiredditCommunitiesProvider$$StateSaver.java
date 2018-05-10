package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import java.util.HashMap;
import java.util.List;

public class MultiredditCommunitiesProvider$$StateSaver<T extends MultiredditCommunitiesProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("communities", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putString(bundle, "multiredditName", t.multiredditName);
        HELPER.putWithBundler(bundle, "communities", t.communities);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.multiredditName = HELPER.getString(bundle, "multiredditName");
        t.communities = (List) HELPER.getWithBundler(bundle, "communities");
    }
}
