package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.datalibrary.social.data.datasource.local.ChatCountChangeDataSource;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/social/presentation/chatrequests/presentation/ChatRequestPresenter$acceptInvite$2", "Lio/reactivex/observers/DisposableObserver;", "", "(Lcom/reddit/social/presentation/chatrequests/presentation/ChatRequestPresenter;Ljava/lang/String;)V", "onComplete", "", "onError", "e", "", "onNext", "t", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
public final class ChatRequestPresenter$acceptInvite$2 extends DisposableObserver<Boolean> {
    final /* synthetic */ ChatRequestPresenter f34582a;
    final /* synthetic */ String f34583b;

    public final void onComplete() {
    }

    ChatRequestPresenter$acceptInvite$2(ChatRequestPresenter chatRequestPresenter, String str) {
        this.f34582a = chatRequestPresenter;
        this.f34583b = str;
    }

    public final /* synthetic */ void onNext(Object obj) {
        ((Boolean) obj).booleanValue();
        obj = ChatCountChangeDataSource.f19838a;
        ChatCountChangeDataSource.m21695b();
        ChatRequestPresenter.m30676a(this.f34582a).mo7514b(this.f34583b);
        obj = this.f34582a.m30692d();
        String str = this.f34583b;
        Intrinsics.m26847b(str, "channelUrl");
        BiFunction biFunction = ChatAnalytics$invitationAccept$combine$1.f29569a;
        LoadMessagesUseCase loadMessagesUseCase = obj.f22294d;
        if (loadMessagesUseCase == null) {
            Intrinsics.m26844a("loadMessagesUseCase");
        }
        ObservableSource a = loadMessagesUseCase.m24494a(str, false);
        ChatDataRepositoryContract chatDataRepositoryContract = obj.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable zip = Observable.zip(a, chatDataRepositoryContract.mo4506a(str), biFunction);
        Intrinsics.m26843a((Object) zip, "Observable.zip(loadMessa…nel(channelUrl), combine)");
        ObservablesKt.m24091a(zip, (Function1) new ChatAnalytics$invitationAccept$1(obj, str));
    }

    public final void onError(Throwable th) {
        Intrinsics.m26847b(th, "e");
        ChatRequestPresenter.m30676a(this.f34582a).mo7506a((int) C1761R.string.chat_error_something_went_wrong_accept);
    }
}
