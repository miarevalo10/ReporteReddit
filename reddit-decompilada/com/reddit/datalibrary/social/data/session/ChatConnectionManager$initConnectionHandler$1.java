package com.reddit.datalibrary.social.data.session;

import com.sendbird.android.SendBird;
import com.sendbird.android.SendBird.ConnectionHandler;
import io.reactivex.subjects.PublishSubject;
import java.net.ConnectException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/datalibrary/social/data/session/ChatConnectionManager$initConnectionHandler$1", "Lcom/sendbird/android/SendBird$ConnectionHandler;", "(Lcom/reddit/datalibrary/social/data/session/ChatConnectionManager;)V", "onReconnectFailed", "", "onReconnectStarted", "onReconnectSucceeded", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
public final class ChatConnectionManager$initConnectionHandler$1 implements ConnectionHandler {
    final /* synthetic */ ChatConnectionManager f27385a;

    ChatConnectionManager$initConnectionHandler$1(ChatConnectionManager chatConnectionManager) {
        this.f27385a = chatConnectionManager;
    }

    public final void mo4556a() {
        Timber.b("onReconnectStarted", new Object[0]);
    }

    public final void mo4557b() {
        Timber.b("onReconnectSucceeded", new Object[0]);
        this.f27385a.f19866h = false;
        if (!this.f27385a.f19864f.hasComplete() && !this.f27385a.f19864f.hasThrowable() && SendBird.m25001k() != null) {
            PublishSubject d = this.f27385a.f19864f;
            Object k = SendBird.m25001k();
            Intrinsics.m26843a(k, "SendBird.getCurrentUser()");
            d.onNext(k.m25021d());
        }
    }

    public final void mo4558c() {
        Timber.b("onReconnectFailed", new Object[0]);
        this.f27385a.f19864f.onError(new ConnectException("SendBird Reconnect Failed"));
    }
}
