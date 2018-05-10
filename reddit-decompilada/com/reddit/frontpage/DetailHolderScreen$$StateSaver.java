package com.reddit.frontpage;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class DetailHolderScreen$$StateSaver<T extends DetailHolderScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.DetailHolderScreen$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("link", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putWithBundler(bundle, "link", t.link);
        HELPER.putString(bundle, "linkId", t.linkId);
        HELPER.putString(bundle, "commentContext", t.commentContext);
        HELPER.putString(bundle, "sourcePage", t.sourcePage);
        HELPER.putString(bundle, "comment", t.comment);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.link = (Link) HELPER.getWithBundler(bundle, "link");
        t.linkId = HELPER.getString(bundle, "linkId");
        t.commentContext = HELPER.getString(bundle, "commentContext");
        t.sourcePage = HELPER.getString(bundle, "sourcePage");
        t.comment = HELPER.getString(bundle, "comment");
    }
}
