package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "it", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$uploadImage$2<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ ProfileSettingsPresenter f29263a;

    ProfileSettingsPresenter$uploadImage$2(ProfileSettingsPresenter profileSettingsPresenter) {
        this.f29263a = profileSettingsPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((Response) obj, "it");
        return this.f29263a.f34418f.m22393a();
    }
}
