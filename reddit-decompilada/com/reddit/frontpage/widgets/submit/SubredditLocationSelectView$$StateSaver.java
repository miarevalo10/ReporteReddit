package com.reddit.frontpage.widgets.submit;

import android.os.Bundle;
import android.os.Parcelable;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.View;
import java.util.HashMap;

public class SubredditLocationSelectView$$StateSaver<T extends SubredditLocationSelectView> extends View<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.widgets.submit.SubredditLocationSelectView$$StateSaver", BUNDLERS);

    public Parcelable save(T t, Parcelable parcelable) {
        parcelable = HELPER.putParent(parcelable);
        HELPER.putBoolean(parcelable, "locationSet", t.locationSet);
        HELPER.putString(parcelable, "requestTag", t.requestTag);
        return parcelable;
    }

    public Parcelable restore(T t, Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        t.locationSet = HELPER.getBoolean(bundle, "locationSet");
        t.requestTag = HELPER.getString(bundle, "requestTag");
        return HELPER.getParent(bundle);
    }
}
