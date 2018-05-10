package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;

final /* synthetic */ class BaseLinkListingScreen$$Lambda$2 implements OnInflateListener {
    private final BaseLinkListingScreen f21258a;

    BaseLinkListingScreen$$Lambda$2(BaseLinkListingScreen baseLinkListingScreen) {
        this.f21258a = baseLinkListingScreen;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        viewStub = this.f21258a;
        viewStub.f39196A = (TextView) view.findViewById(C1761R.id.error_message);
        view.setOnClickListener(new BaseLinkListingScreen$$Lambda$7(viewStub));
    }
}
