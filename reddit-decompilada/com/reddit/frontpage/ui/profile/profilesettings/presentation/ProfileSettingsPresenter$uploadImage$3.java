package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageType;
import com.reddit.frontpage.ui.profile.profilesettings.presentation.ProfileSettingsPresenter.WhenMappings;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$uploadImage$3<T> implements Consumer<Account> {
    final /* synthetic */ ProfileSettingsPresenter f29264a;
    final /* synthetic */ ImageType f29265b;

    ProfileSettingsPresenter$uploadImage$3(ProfileSettingsPresenter profileSettingsPresenter, ImageType imageType) {
        this.f29264a = profileSettingsPresenter;
        this.f29265b = imageType;
    }

    public final /* synthetic */ void accept(Object obj) {
        Account account = (Account) obj;
        switch (WhenMappings.f21570c[this.f29265b.ordinal()]) {
            case 1:
                this.f29264a.f34414a = true;
                obj = account.getSubreddit();
                if (obj != null) {
                    obj = obj.getIconImg();
                    if (obj != null) {
                        this.f29264a.f34421i.mo5011a(obj);
                    }
                }
                return;
            case 2:
                this.f29264a.f34415b = true;
                obj = account.getSubreddit();
                if (obj != null) {
                    obj = obj.getBannerImg();
                    if (obj != null) {
                        this.f29264a.f34421i.mo5014b(obj);
                        return;
                    }
                }
                break;
            default:
                break;
        }
    }
}
