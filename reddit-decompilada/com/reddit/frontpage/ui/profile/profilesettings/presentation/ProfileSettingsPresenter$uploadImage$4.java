package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageType;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "it", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$uploadImage$4<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ ProfileSettingsPresenter f29266a;
    final /* synthetic */ ImageType f29267b;

    ProfileSettingsPresenter$uploadImage$4(ProfileSettingsPresenter profileSettingsPresenter, ImageType imageType) {
        this.f29266a = profileSettingsPresenter;
        this.f29267b = imageType;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Account account = (Account) obj;
        Intrinsics.m26847b(account, "it");
        return ProfileSettingsPresenter.m35159a(account, this.f29267b);
    }
}
