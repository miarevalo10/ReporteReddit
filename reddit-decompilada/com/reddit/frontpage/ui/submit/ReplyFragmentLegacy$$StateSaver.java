package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.BaseFrontpageFragment$$StateSaver;
import java.util.HashMap;

public class ReplyFragmentLegacy$$StateSaver<T extends ReplyFragmentLegacy> extends BaseFrontpageFragment$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.ReplyFragmentLegacy$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseFrontpageFragment) t, bundle);
        HELPER.putString(bundle, "mReplyIdentifier", t.mReplyIdentifier);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseFrontpageFragment) t, bundle);
        t.mReplyIdentifier = HELPER.getString(bundle, "mReplyIdentifier");
    }
}
