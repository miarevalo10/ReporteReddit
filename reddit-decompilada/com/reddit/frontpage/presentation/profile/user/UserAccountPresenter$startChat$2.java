package com.reddit.frontpage.presentation.profile.user;

import com.reddit.frontpage.presentation.profile.user.UserAccountContract.View;
import com.reddit.social.analytics.ChatAnalytics;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "userId", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserAccountPresenter.kt */
final class UserAccountPresenter$startChat$2<T> implements Consumer<String> {
    final /* synthetic */ UserAccountPresenter f28744a;
    final /* synthetic */ ChatAnalytics f28745b;

    UserAccountPresenter$startChat$2(UserAccountPresenter userAccountPresenter, ChatAnalytics chatAnalytics) {
        this.f28744a = userAccountPresenter;
        this.f28745b = chatAnalytics;
    }

    public final /* synthetic */ void accept(Object obj) {
        String str = (String) obj;
        View view = this.f28744a.f34145a;
        Intrinsics.m26843a((Object) str, "userId");
        view.mo7421a(str);
        ChatAnalytics.m24468b();
    }
}
