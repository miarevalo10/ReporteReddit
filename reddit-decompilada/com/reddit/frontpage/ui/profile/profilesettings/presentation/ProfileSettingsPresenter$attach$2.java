package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.frontpage.ui.profile.profilesettings.model.AccountPresentationModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "account", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$attach$2<T> implements Consumer<AccountPresentationModel> {
    final /* synthetic */ ProfileSettingsPresenter f29243a;

    ProfileSettingsPresenter$attach$2(ProfileSettingsPresenter profileSettingsPresenter) {
        this.f29243a = profileSettingsPresenter;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        AccountPresentationModel accountPresentationModel = (AccountPresentationModel) obj;
        this.f29243a.f34414a = accountPresentationModel.f21550g ^ 1;
        this.f29243a.f34415b = accountPresentationModel.f21551h ^ 1;
    }
}
