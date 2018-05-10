package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

public class LinkFlairSelectScreen$$StateSaver<T extends LinkFlairSelectScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.LinkFlairSelectScreen$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("Thing", new ParcelerBundler());
        BUNDLERS.put("SelectedFlair", new ParcelerBundler());
        BUNDLERS.put("subredditName", new ParcelerBundler());
        BUNDLERS.put("FlairEdits", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putWithBundler(bundle, "Thing", t.thing);
        HELPER.putWithBundler(bundle, "SelectedFlair", t.selectedFlair);
        HELPER.putWithBundler(bundle, "subredditName", t.subredditName);
        HELPER.putWithBundler(bundle, "FlairEdits", t.flairEdits);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.thing = (Thing) HELPER.getWithBundler(bundle, "Thing");
        t.m39555a((LinkFlair) HELPER.getWithBundler(bundle, "SelectedFlair"));
        t.subredditName = (String) HELPER.getWithBundler(bundle, "subredditName");
        HashMap hashMap = (HashMap) HELPER.getWithBundler(bundle, "FlairEdits");
        Intrinsics.m26847b(hashMap, "<set-?>");
        t.flairEdits = hashMap;
    }
}
