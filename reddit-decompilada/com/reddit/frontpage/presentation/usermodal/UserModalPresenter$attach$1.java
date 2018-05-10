package com.reddit.frontpage.presentation.usermodal;

import com.reddit.frontpage.presentation.usermodal.UserModalContract.View;
import com.reddit.frontpage.presentation.usermodal.UserModalPresenter.UserModalInfo;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter$UserModalInfo;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserModalPresenter.kt */
final class UserModalPresenter$attach$1<T> implements Consumer<UserModalInfo> {
    final /* synthetic */ UserModalPresenter f28808a;

    UserModalPresenter$attach$1(UserModalPresenter userModalPresenter) {
        this.f28808a = userModalPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        UserModalInfo userModalInfo = (UserModalInfo) obj;
        View view = this.f28808a.f34178a;
        Intrinsics.m26843a((Object) userModalInfo, "result");
        view.mo4935a(userModalInfo);
    }
}
