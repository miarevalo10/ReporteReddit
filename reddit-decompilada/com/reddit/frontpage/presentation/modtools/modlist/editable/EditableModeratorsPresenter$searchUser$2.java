package com.reddit.frontpage.presentation.modtools.modlist.editable;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: EditableModeratorsPresenter.kt */
final class EditableModeratorsPresenter$searchUser$2<T> implements Consumer<Throwable> {
    final /* synthetic */ EditableModeratorsPresenter f28665a;

    EditableModeratorsPresenter$searchUser$2(EditableModeratorsPresenter editableModeratorsPresenter) {
        this.f28665a = editableModeratorsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = this.f28665a.f36987a;
        Object f = Util.m24027f((int) C1761R.string.error_server_error);
        Intrinsics.m26843a(f, "Util.getString(R.string.error_server_error)");
        obj.b_(f);
    }
}
