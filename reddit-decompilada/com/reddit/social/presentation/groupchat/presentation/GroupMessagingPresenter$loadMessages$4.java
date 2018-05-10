package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.presentation.groupchat.ChatContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "batch", "Lcom/reddit/social/domain/functions/MessagesBatch;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMessages$4<T> implements Consumer<MessagesBatch> {
    final /* synthetic */ GroupMessagingPresenter f29767a;
    final /* synthetic */ String f29768b;

    GroupMessagingPresenter$loadMessages$4(GroupMessagingPresenter groupMessagingPresenter, String str) {
        this.f29767a = groupMessagingPresenter;
        this.f29768b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        MessagesBatch messagesBatch = (MessagesBatch) obj;
        View a = GroupMessagingPresenter.m30774a(this.f29767a);
        Intrinsics.m26843a((Object) messagesBatch, "batch");
        a.mo7550a(messagesBatch);
        obj = this.f29767a.m30819h();
        String str = this.f29768b;
        Intrinsics.m26847b(str, "channelUrl");
        obj = obj.f22291a;
        if (obj == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(obj.mo4506a(str), (Function1) new ChatAnalytics$chat$1(str));
        this.f29767a.m30820i().mo5103a(this.f29768b, false);
    }
}
