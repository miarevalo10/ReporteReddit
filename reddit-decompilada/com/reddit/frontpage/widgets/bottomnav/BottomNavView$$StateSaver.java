package com.reddit.frontpage.widgets.bottomnav;

import android.os.Bundle;
import android.os.Parcelable;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.evernote.android.state.Injector.View;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import java.util.HashMap;

public class BottomNavView$$StateSaver<T extends BottomNavView> extends View<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.widgets.bottomnav.BottomNavView$$StateSaver", BUNDLERS);

    public Parcelable save(T t, Parcelable parcelable) {
        parcelable = HELPER.putParent(parcelable);
        HELPER.putSerializable(parcelable, "SelectedItem", t.getSelectedItem());
        return parcelable;
    }

    public Parcelable restore(T t, Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        t.setSelectedItem((Item) HELPER.getSerializable(bundle, "SelectedItem"));
        return HELPER.getParent(bundle);
    }
}
