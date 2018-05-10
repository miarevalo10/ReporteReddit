package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.groupchat.ChatContract.View;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$sendSnoomoji$3 extends Lambda implements Function1<HasMessageData, Unit> {
    final /* synthetic */ GroupMessagingPresenter f37532a;

    GroupMessagingPresenter$sendSnoomoji$3(GroupMessagingPresenter groupMessagingPresenter) {
        this.f37532a = groupMessagingPresenter;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        HasMessageData hasMessageData = (HasMessageData) obj;
        View a = GroupMessagingPresenter.m30774a(this.f37532a);
        Intrinsics.m26843a((Object) hasMessageData, "it");
        a.mo7551a(hasMessageData);
        return Unit.f25273a;
    }
}
