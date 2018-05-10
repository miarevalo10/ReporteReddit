package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$removeBanner$1 implements Action {
    final /* synthetic */ ProfileSettingsPresenter f29249a;

    ProfileSettingsPresenter$removeBanner$1(ProfileSettingsPresenter profileSettingsPresenter) {
        this.f29249a = profileSettingsPresenter;
    }

    public final void run() {
        this.f29249a.f34415b = false;
        this.f29249a.f34421i.mo5015c();
        this.f29249a.f34416c.mo7233b(null);
    }
}
