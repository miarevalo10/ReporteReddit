package com.reddit.frontpage.widgets;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class ListingFooterView_ViewBinding implements Unbinder {
    private ListingFooterView f29476b;

    public ListingFooterView_ViewBinding(ListingFooterView listingFooterView, View view) {
        this.f29476b = listingFooterView;
        listingFooterView.loadingIndicator = Utils.a(view, C1761R.id.loading_indicator, "field 'loadingIndicator'");
        listingFooterView.errorContainer = Utils.a(view, C1761R.id.error_container_stub, "field 'errorContainer'");
    }

    public final void m30492a() {
        ListingFooterView listingFooterView = this.f29476b;
        if (listingFooterView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29476b = null;
        listingFooterView.loadingIndicator = null;
        listingFooterView.errorContainer = null;
    }
}
