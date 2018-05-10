package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.groupchat.ChatContract.View;
import com.sendbird.android.UserMessage;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/sendbird/android/UserMessage;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$resendMessage$4<T> implements Consumer<UserMessage> {
    final /* synthetic */ GroupMessagingPresenter f29776a;

    GroupMessagingPresenter$resendMessage$4(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29776a = groupMessagingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (UserMessage) obj;
        View a = GroupMessagingPresenter.m30774a(this.f29776a);
        Intrinsics.m26843a(obj, "it");
        String j = obj.m31084j();
        Intrinsics.m26843a((Object) j, "it.requestId");
        a.mo7553a(j, obj.m24878f());
    }
}
