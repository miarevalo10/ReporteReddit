package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.frontpage.util.UrlUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$reachAccountImage$1<V> implements Callable<T> {
    final /* synthetic */ String f21572a;

    ProfileSettingsPresenter$reachAccountImage$1(String str) {
        this.f21572a = str;
    }

    public final /* synthetic */ Object call() {
        return Boolean.valueOf(UrlUtil.m23948a(this.f21572a));
    }
}
