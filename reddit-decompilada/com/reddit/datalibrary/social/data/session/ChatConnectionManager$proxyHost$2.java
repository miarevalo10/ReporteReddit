package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdConfig;", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$proxyHost$2<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatConnectionManager f27387a;

    ChatConnectionManager$proxyHost$2(ChatConnectionManager chatConnectionManager) {
        this.f27387a = chatConnectionManager;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.m26847b((SendBirdAccessTokenData) obj, "it");
        obj = this.f27387a.m21771a();
        if (obj.f19850b != null) {
            obj = Observable.just(obj.f19850b);
            Intrinsics.m26843a(obj, "Observable.just(sendBirdConfig)");
            return obj;
        }
        obj = obj.f19849a.m28848c().subscribeOn(SchedulerProvider.m23886b()).doOnNext(new ChatCredentialsRepository$fetchSendbirdConfig$1(obj));
        Intrinsics.m26843a(obj, "baseplateClient.fetchSen…age_length)\n            }");
        return obj;
    }
}
