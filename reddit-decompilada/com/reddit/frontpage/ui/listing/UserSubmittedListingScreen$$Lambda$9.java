package com.reddit.frontpage.ui.listing;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.requests.models.v1.RedditVideo;
import io.reactivex.functions.Function;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$9 implements Function {
    private final UserSubmittedListingScreen f29084a;

    UserSubmittedListingScreen$$Lambda$9(UserSubmittedListingScreen userSubmittedListingScreen) {
        this.f29084a = userSubmittedListingScreen;
    }

    public final Object apply(Object obj) {
        obj = ((RedditVideo) obj).getDashUrl();
        int lastIndexOf = obj.lastIndexOf(47);
        return obj.substring(obj.substring(0, lastIndexOf).lastIndexOf(Operation.DIVISION) + 1, lastIndexOf);
    }
}
