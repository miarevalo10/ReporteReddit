package com.reddit.frontpage.ui.profile;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class ProfilePagerScreen$$Lambda$1 implements Consumer {
    private final ProfilePagerScreen f29227a;

    ProfilePagerScreen$$Lambda$1(ProfilePagerScreen profilePagerScreen) {
        this.f29227a = profilePagerScreen;
    }

    public final void accept(Object obj) {
        Timber.b((Throwable) obj, "Couldn't fetch trophies for %s", new Object[]{this.f29227a.username});
    }
}
