package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.model.User;
import com.reddit.frontpage.util.SchedulerProvider;
import com.sendbird.android.SendBird;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$createChannelPathInitializer$1", "Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter$Initializer;", "(Lcom/reddit/social/presentation/groupchat/presentation/GroupMessagingPresenter;)V", "init", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
public final class GroupMessagingPresenter$createChannelPathInitializer$1 implements Initializer {
    final /* synthetic */ GroupMessagingPresenter f29749a;

    GroupMessagingPresenter$createChannelPathInitializer$1(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29749a = groupMessagingPresenter;
    }

    public final void mo5159a() {
        if (SendBird.m25001k() != null) {
            List b = CollectionsKt__CollectionsKt.m26796b((Object[]) new User[]{new User(this.f29749a.f29816v, this.f29749a.f29815u, null), new User(SendBird.m25001k().m25021d(), SendBird.m25001k().m25022e(), SendBird.m25001k().m25023f())});
            CompositeDisposable n = GroupMessagingPresenter.m30798n(this.f29749a);
            Object subscribe = this.f29749a.m30818g().mo4514a(b, null).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new GroupMessagingPresenter$createChannelPathInitializer$1$init$1(this), new GroupMessagingPresenter$createChannelPathInitializer$1$init$2(this));
            Intrinsics.m26843a(subscribe, "chatDataRepository.creat…DO: Exit view\n          }");
            DisposableKt.m26766a(n, subscribe);
        }
    }
}
