package com.reddit.frontpage.ui.submit;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class ReplyFragmentLegacy$$Lambda$1 implements OnClickListener {
    private final ReplyFragmentLegacy f21620a;
    private final MenuItem f21621b;

    ReplyFragmentLegacy$$Lambda$1(ReplyFragmentLegacy replyFragmentLegacy, MenuItem menuItem) {
        this.f21620a = replyFragmentLegacy;
        this.f21621b = menuItem;
    }

    public final void onClick(View view) {
        this.f21620a.onOptionsItemSelected(this.f21621b);
    }
}
