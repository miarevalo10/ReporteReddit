package com.reddit.frontpage.presentation.modtools.actions;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public final class ModToolsActionsScreen_ViewBinding implements Unbinder {
    private ModToolsActionsScreen f28529b;

    public ModToolsActionsScreen_ViewBinding(ModToolsActionsScreen modToolsActionsScreen, View view) {
        this.f28529b = modToolsActionsScreen;
        modToolsActionsScreen.recyclerView = (RecyclerView) Utils.b(view, C1761R.id.mod_tools_actions_recyclerview, "field 'recyclerView'", RecyclerView.class);
    }

    public final void m29732a() {
        ModToolsActionsScreen modToolsActionsScreen = this.f28529b;
        if (modToolsActionsScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28529b = null;
        modToolsActionsScreen.recyclerView = null;
    }
}
