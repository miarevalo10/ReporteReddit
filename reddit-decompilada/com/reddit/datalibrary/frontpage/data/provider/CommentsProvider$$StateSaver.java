package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class CommentsProvider$$StateSaver<T extends CommentsProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.CommentsProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putInt(bundle, "sortId", t.sortId);
        HELPER.putString(bundle, "commentContext", t.commentContext);
        HELPER.putString(bundle, "comment", t.comment);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.sortId = HELPER.getInt(bundle, "sortId");
        t.commentContext = HELPER.getString(bundle, "commentContext");
        t.comment = HELPER.getString(bundle, "comment");
    }
}
