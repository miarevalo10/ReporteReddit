package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import java.util.HashMap;
import java.util.List;

public class LinkListingProvider$$StateSaver<T extends LinkListingProvider> extends BaseListingProvider2$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("linkPositions", new ParcelerBundler());
        BUNDLERS.put("linkIds", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseListingProvider2) t, bundle);
        HELPER.putInt(bundle, "ignoreLinkForPagingCount", t.ignoreLinkForPagingCount);
        HELPER.putInt(bundle, "sortId", t.sortId);
        HELPER.putInt(bundle, "sortTimeFrame", t.sortTimeFrame);
        HELPER.putWithBundler(bundle, "linkPositions", t.linkPositions);
        HELPER.putWithBundler(bundle, "linkIds", t.linkIds);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseListingProvider2) t, bundle);
        t.ignoreLinkForPagingCount = HELPER.getInt(bundle, "ignoreLinkForPagingCount");
        t.sortId = HELPER.getInt(bundle, "sortId");
        t.sortTimeFrame = HELPER.getInt(bundle, "sortTimeFrame");
        t.linkPositions = (List) HELPER.getWithBundler(bundle, "linkPositions");
        t.linkIds = (List) HELPER.getWithBundler(bundle, "linkIds");
    }
}
