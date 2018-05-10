package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.BaseFrontpageFragment$$StateSaver;
import java.util.HashMap;

public class EditFragmentLegacy$$StateSaver<T extends EditFragmentLegacy> extends BaseFrontpageFragment$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.EditFragmentLegacy$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseFrontpageFragment) t, bundle);
        HELPER.putString(bundle, "editIdentifier", t.editIdentifier);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseFrontpageFragment) t, bundle);
        t.editIdentifier = HELPER.getString(bundle, "editIdentifier");
    }
}
