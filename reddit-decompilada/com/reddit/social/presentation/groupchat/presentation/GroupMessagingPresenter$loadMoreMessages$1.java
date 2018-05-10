package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.presentation.groupchat.ChatContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "batch", "Lcom/reddit/social/domain/functions/MessagesBatch;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMoreMessages$1<T> implements Consumer<MessagesBatch> {
    final /* synthetic */ GroupMessagingPresenter f29770a;

    GroupMessagingPresenter$loadMoreMessages$1(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29770a = groupMessagingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        MessagesBatch messagesBatch = (MessagesBatch) obj;
        View a = GroupMessagingPresenter.m30774a(this.f29770a);
        Intrinsics.m26843a((Object) messagesBatch, "batch");
        a.mo7559b(messagesBatch);
    }
}
