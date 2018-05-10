package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import java.util.HashMap;

public class MessageThreadProvider$$StateSaver<T extends MessageThreadProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.MessageThreadProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putSerializable(bundle, "mMessageTree", t.mMessageTree);
        HELPER.putString(bundle, "threadId", t.threadId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.mMessageTree = (CollapseTree) HELPER.getSerializable(bundle, "mMessageTree");
        t.threadId = HELPER.getString(bundle, "threadId");
    }
}
