package com.reddit.datalibrary.social.data.session;

import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$connectObservable$6 implements Action {
    final /* synthetic */ ChatConnectionManager f27384a;

    ChatConnectionManager$connectObservable$6(ChatConnectionManager chatConnectionManager) {
        this.f27384a = chatConnectionManager;
    }

    public final void run() {
        this.f27384a.f19863e.onComplete();
    }
}
