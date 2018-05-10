package com.reddit.frontpage.presentation.modtools.mute;

import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MutedUsersPresenter.kt */
final class MutedUsersPresenter$searchUser$2<T> implements Consumer<Throwable> {
    final /* synthetic */ MutedUsersPresenter f28686a;

    MutedUsersPresenter$searchUser$2(MutedUsersPresenter mutedUsersPresenter) {
        this.f28686a = mutedUsersPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "error");
        View view = this.f28686a.f36992a;
        obj = th.getLocalizedMessage();
        Intrinsics.m26843a(obj, "error.localizedMessage");
        view.b_(obj);
    }
}
