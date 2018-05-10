package com.reddit.datalibrary.social.data.session;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "throwable", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$RetryWithDelay$apply$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ RetryWithDelay f27373a;

    ChatConnectionManager$RetryWithDelay$apply$1(RetryWithDelay retryWithDelay) {
        this.f27373a = retryWithDelay;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "throwable");
        RetryWithDelay retryWithDelay = this.f27373a;
        int i = retryWithDelay.f27374a;
        retryWithDelay.f27374a = i + 1;
        if (i < this.f27373a.f27375b) {
            this.f27373a.f27377d.f19862d = false;
            this.f27373a.f27377d.m21771a().f19850b = null;
            Observable.timer((long) this.f27373a.f27376c, TimeUnit.MILLISECONDS);
        }
        return Observable.error(th);
    }
}
