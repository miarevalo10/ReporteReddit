package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import java.util.HashMap;

public class AccountProvider$$StateSaver<T extends AccountProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.AccountProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putSerializable(bundle, "mAccount", t.mAccount);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.mAccount = (Account) HELPER.getSerializable(bundle, "mAccount");
    }
}
