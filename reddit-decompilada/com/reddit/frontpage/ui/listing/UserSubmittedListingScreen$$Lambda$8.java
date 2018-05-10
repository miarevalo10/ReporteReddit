package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import io.reactivex.functions.Function;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$8 implements Function {
    static final Function f29083a = new UserSubmittedListingScreen$$Lambda$8();

    private UserSubmittedListingScreen$$Lambda$8() {
    }

    public final Object apply(Object obj) {
        return ((ClientLink) obj).getMedia().getRedditVideo();
    }
}
