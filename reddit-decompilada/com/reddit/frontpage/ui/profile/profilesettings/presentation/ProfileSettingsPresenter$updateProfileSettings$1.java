package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.frontpage.ui.profile.profilesettings.model.UserSubredditSettingsMapper;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "Lokhttp3/ResponseBody;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$updateProfileSettings$1<T, R> implements Function<T, R> {
    final /* synthetic */ String f29253a;
    final /* synthetic */ String f29254b;
    final /* synthetic */ boolean f29255c;

    ProfileSettingsPresenter$updateProfileSettings$1(String str, String str2, boolean z) {
        this.f29253a = str;
        this.f29254b = str2;
        this.f29255c = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        ResponseBody responseBody = (ResponseBody) obj;
        Intrinsics.m26847b(responseBody, "it");
        UserSubredditSettingsMapper userSubredditSettingsMapper = UserSubredditSettingsMapper.f21567a;
        return UserSubredditSettingsMapper.m23604a(responseBody, this.f29253a, this.f29254b, this.f29255c);
    }
}
