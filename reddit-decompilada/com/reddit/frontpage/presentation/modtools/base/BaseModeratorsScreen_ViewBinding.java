package com.reddit.frontpage.presentation.modtools.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.modtools.ModSearchView;

public class BaseModeratorsScreen_ViewBinding implements Unbinder {
    private BaseModeratorsScreen f28597b;

    public BaseModeratorsScreen_ViewBinding(BaseModeratorsScreen baseModeratorsScreen, View view) {
        this.f28597b = baseModeratorsScreen;
        baseModeratorsScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.mod_tools_users_recyclerview, "field 'recyclerView'", RecyclerView.class);
        baseModeratorsScreen.searchView = (ModSearchView) Utils.b(view, C1761R.id.mod_tools_users_search_view, "field 'searchView'", ModSearchView.class);
        baseModeratorsScreen.emptyContainer = Utils.a(view, C1761R.id.empty_container_stub, "field 'emptyContainer'");
    }

    public final void m29766a() {
        BaseModeratorsScreen baseModeratorsScreen = this.f28597b;
        if (baseModeratorsScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28597b = null;
        baseModeratorsScreen.recyclerView = null;
        baseModeratorsScreen.searchView = null;
        baseModeratorsScreen.emptyContainer = null;
    }
}
