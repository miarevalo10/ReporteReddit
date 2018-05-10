package com.reddit.datalibrary.social.data.session;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "userId", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$connectObservable$4<T> implements Consumer<String> {
    final /* synthetic */ ChatConnectionManager f27382a;

    ChatConnectionManager$connectObservable$4(ChatConnectionManager chatConnectionManager) {
        this.f27382a = chatConnectionManager;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f27382a.f19863e.onNext((String) obj);
    }
}
