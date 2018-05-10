package com.reddit.social.presentation.contacts.view;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import com.reddit.frontpage.util.BundlerSetParcelable;
import com.reddit.social.util.BundlerContactsActionType;
import java.util.HashMap;
import java.util.Set;

public class ContactsScreen$$StateSaver<T extends ContactsScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.social.presentation.contacts.view.ContactsScreen$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("contactsActionType", new BundlerContactsActionType());
        BUNDLERS.put("members", new BundlerSetParcelable());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putSerializable(bundle, "Link", t.link);
        HELPER.putWithBundler(bundle, "contactsActionType", t.contactsActionType);
        HELPER.putString(bundle, "Title", t.title);
        HELPER.putString(bundle, "Url", t.url);
        HELPER.putWithBundler(bundle, "members", t.members);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.link = (Link) HELPER.getSerializable(bundle, "Link");
        t.contactsActionType = (ContactsActionType) HELPER.getWithBundler(bundle, "contactsActionType");
        t.title = HELPER.getString(bundle, "Title");
        t.url = HELPER.getString(bundle, "Url");
        t.members = (Set) HELPER.getWithBundler(bundle, "members");
    }
}
