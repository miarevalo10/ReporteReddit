package com.reddit.frontpage.widgets.submit;

import io.reactivex.functions.Predicate;

final /* synthetic */ class SubredditLocationSelectView$$Lambda$5 implements Predicate {
    private final SubredditLocationSelectView f29533a;

    SubredditLocationSelectView$$Lambda$5(SubredditLocationSelectView subredditLocationSelectView) {
        this.f29533a = subredditLocationSelectView;
    }

    public final boolean test(Object obj) {
        return ((CharSequence) obj).equals(this.f29533a.defaultSubredditText) == null ? true : null;
    }
}
