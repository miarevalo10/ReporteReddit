package com.reddit.frontpage.ui.search;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class CombinedSearchResultScreen_ViewBinding implements Unbinder {
    private CombinedSearchResultScreen f29287b;

    public CombinedSearchResultScreen_ViewBinding(CombinedSearchResultScreen combinedSearchResultScreen, View view) {
        this.f29287b = combinedSearchResultScreen;
        combinedSearchResultScreen.mNoResultsContainer = (ViewGroup) Utils.b(view, C1761R.id.no_results_container, "field 'mNoResultsContainer'", ViewGroup.class);
    }

    public final void m30375a() {
        CombinedSearchResultScreen combinedSearchResultScreen = this.f29287b;
        if (combinedSearchResultScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29287b = null;
        combinedSearchResultScreen.mNoResultsContainer = null;
    }
}
