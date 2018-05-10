package com.reddit.social.presentation.groupchat.presentation;

import com.sendbird.android.GroupChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$markMessagesAsRead$1 extends Lambda implements Function1<GroupChannel, Unit> {
    final /* synthetic */ GroupMessagingPresenter f37529a;

    GroupMessagingPresenter$markMessagesAsRead$1(GroupMessagingPresenter groupMessagingPresenter) {
        this.f37529a = groupMessagingPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "it");
        this.f37529a.m30818g().mo4517a(groupChannel);
        return Unit.f25273a;
    }
}
