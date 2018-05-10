package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;

final /* synthetic */ class ListingFooterView$$Lambda$0 implements OnInflateListener {
    private final ListingFooterView f21925a;

    ListingFooterView$$Lambda$0(ListingFooterView listingFooterView) {
        this.f21925a = listingFooterView;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        viewStub = this.f21925a;
        viewStub.errorContainer = view;
        viewStub.f21927a = (TextView) view.findViewById(C1761R.id.error_message);
        viewStub.errorContainer.setOnClickListener(new ListingFooterView$$Lambda$1(viewStub));
    }
}
