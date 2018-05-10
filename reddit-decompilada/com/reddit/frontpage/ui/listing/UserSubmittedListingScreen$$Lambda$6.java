package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import io.reactivex.functions.Predicate;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$6 implements Predicate {
    private final Class f29081a;

    private UserSubmittedListingScreen$$Lambda$6(Class cls) {
        this.f29081a = cls;
    }

    static Predicate m30130a(Class cls) {
        return new UserSubmittedListingScreen$$Lambda$6(cls);
    }

    public final boolean test(Object obj) {
        return this.f29081a.isInstance((Listable) obj);
    }
}
