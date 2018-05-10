package com.reddit.frontpage.presentation.usermodal;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserModalPresenter.kt */
final class UserModalPresenter$unban$2<T> implements Consumer<Throwable> {
    final /* synthetic */ UserModalPresenter f28812a;

    UserModalPresenter$unban$2(UserModalPresenter userModalPresenter) {
        this.f28812a = userModalPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = this.f28812a.f34178a;
        String f = Util.m24027f((int) C1761R.string.error_network_error);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.error_network_error)");
        obj.mo4936a(f);
    }
}
