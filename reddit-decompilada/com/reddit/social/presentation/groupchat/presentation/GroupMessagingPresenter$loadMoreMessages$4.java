package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.sendbird.android.GroupChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "groupChannel", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMoreMessages$4 extends Lambda implements Function1<GroupChannel, Unit> {
    final /* synthetic */ GroupMessagingPresenter f37528a;

    GroupMessagingPresenter$loadMoreMessages$4(GroupMessagingPresenter groupMessagingPresenter) {
        this.f37528a = groupMessagingPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        ChatDataRepositoryContract g = this.f37528a.m30818g();
        Intrinsics.m26843a((Object) groupChannel, "groupChannel");
        g.mo4517a(groupChannel);
        return Unit.f25273a;
    }
}
