package com.reddit.frontpage.ui.subreddit;

import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.functions.Consumer;

final /* synthetic */ class SubredditInfoScreen$$Lambda$0 implements Consumer {
    private final SubredditInfoScreen f29371a;

    SubredditInfoScreen$$Lambda$0(SubredditInfoScreen subredditInfoScreen) {
        this.f29371a = subredditInfoScreen;
    }

    public final void accept(Object obj) {
        this.f29371a.m41153b((Subreddit) obj);
    }
}
