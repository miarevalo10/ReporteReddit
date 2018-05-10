package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.datalibrary.frontpage.data.model.DefaultAvatar;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/data/model/DefaultAvatar;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$restoreAvatar$1<T> implements Consumer<DefaultAvatar> {
    final /* synthetic */ ProfileSettingsPresenter f29251a;

    ProfileSettingsPresenter$restoreAvatar$1(ProfileSettingsPresenter profileSettingsPresenter) {
        this.f29251a = profileSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        DefaultAvatar defaultAvatar = (DefaultAvatar) obj;
        this.f29251a.f34414a = false;
        this.f29251a.f34421i.mo5013b();
        this.f29251a.f34416c.mo7228a(defaultAvatar.getIconImg());
    }
}
