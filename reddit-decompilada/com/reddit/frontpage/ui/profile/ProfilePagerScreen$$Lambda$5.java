package com.reddit.frontpage.ui.profile;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class ProfilePagerScreen$$Lambda$5 implements Consumer {
    private final ProfilePagerScreen f29229a;

    ProfilePagerScreen$$Lambda$5(ProfilePagerScreen profilePagerScreen) {
        this.f29229a = profilePagerScreen;
    }

    public final void accept(Object obj) {
        Timber.b((Throwable) obj, "Couldn't fetch account for %s", new Object[]{this.f29229a.username});
    }
}
