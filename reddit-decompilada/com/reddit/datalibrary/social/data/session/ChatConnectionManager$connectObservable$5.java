package com.reddit.datalibrary.social.data.session;

import com.reddit.frontpage.util.SessionUtil;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$connectObservable$5<T> implements Consumer<Throwable> {
    final /* synthetic */ ChatConnectionManager f27383a;

    ChatConnectionManager$connectObservable$5(ChatConnectionManager chatConnectionManager) {
        this.f27383a = chatConnectionManager;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f27383a.f19863e.onError(new IOException(((Throwable) obj).getMessage()));
        obj = this.f27383a.m21771a();
        Object d = SessionUtil.m23898d();
        Intrinsics.m26843a(d, "SessionUtil.getTypedCurrentSessionAccountID()");
        obj.m21698a(d);
    }
}
