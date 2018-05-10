package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import io.reactivex.functions.Predicate;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$7 implements Predicate {
    static final Predicate f29082a = new UserSubmittedListingScreen$$Lambda$7();

    private UserSubmittedListingScreen$$Lambda$7() {
    }

    public final boolean test(Object obj) {
        return UserSubmittedListingScreen.m41034b((ClientLink) obj);
    }
}
