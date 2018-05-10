package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.social.data.session.ChatConnectionManager.Companion;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$connectObservable$2<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatConnectionManager f27380a;

    ChatConnectionManager$connectObservable$2(ChatConnectionManager chatConnectionManager) {
        this.f27380a = chatConnectionManager;
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "it");
        obj = ChatConnectionManager.m21755a(this.f27380a, str);
        Companion companion = ChatConnectionManager.f19854b;
        return obj.timeout(ChatConnectionManager.f19858l, TimeUnit.SECONDS).retry(1);
    }
}
