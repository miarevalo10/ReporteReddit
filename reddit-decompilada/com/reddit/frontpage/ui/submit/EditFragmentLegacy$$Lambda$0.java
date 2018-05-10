package com.reddit.frontpage.ui.submit;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class EditFragmentLegacy$$Lambda$0 implements OnClickListener {
    private final EditFragmentLegacy f21604a;
    private final MenuItem f21605b;

    EditFragmentLegacy$$Lambda$0(EditFragmentLegacy editFragmentLegacy, MenuItem menuItem) {
        this.f21604a = editFragmentLegacy;
        this.f21605b = menuItem;
    }

    public final void onClick(View view) {
        this.f21604a.onOptionsItemSelected(this.f21605b);
    }
}
