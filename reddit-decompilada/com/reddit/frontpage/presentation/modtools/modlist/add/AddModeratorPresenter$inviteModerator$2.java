package com.reddit.frontpage.presentation.modtools.modlist.add;

import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddModeratorPresenter.kt */
final class AddModeratorPresenter$inviteModerator$2<T> implements Consumer<Throwable> {
    final /* synthetic */ AddModeratorPresenter f28627a;

    AddModeratorPresenter$inviteModerator$2(AddModeratorPresenter addModeratorPresenter) {
        this.f28627a = addModeratorPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "error");
        View view = this.f28627a.f34074a;
        obj = th.getLocalizedMessage();
        Intrinsics.m26843a(obj, "error.localizedMessage");
        view.mo7241c(obj);
    }
}
