package com.reddit.datalibrary.social.data.repo;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBird.ChannelHandler;
import com.sendbird.android.User;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$listenNewInvite$1<T> implements ObservableOnSubscribe<T> {
    final /* synthetic */ String f27355a;

    ChatDataRepository$listenNewInvite$1(String str) {
        this.f27355a = str;
    }

    public final void mo4493a(final ObservableEmitter<GroupChannel> observableEmitter) {
        Intrinsics.m26847b(observableEmitter, "emitter");
        SendBird.m24969a(this.f27355a, (ChannelHandler) new ChannelHandler() {
            public final void mo4494a(BaseChannel baseChannel, BaseMessage baseMessage) {
                Intrinsics.m26847b(baseChannel, "baseChannel");
                Intrinsics.m26847b(baseMessage, "baseMessage");
            }

            public final void mo4505a(GroupChannel groupChannel, User user, List<? extends User> list) {
                Intrinsics.m26847b(groupChannel, "channel");
                Intrinsics.m26847b(user, "inviter");
                Intrinsics.m26847b(list, "invitees");
                observableEmitter.mo5641a((Object) groupChannel);
            }
        });
    }
}
