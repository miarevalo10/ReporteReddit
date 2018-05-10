package com.reddit.social.presentation.groupchat.presentation;

import com.sendbird.android.UserMessage;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$sendSnoomoji$5<T> implements Consumer<Throwable> {
    final /* synthetic */ GroupMessagingPresenter f29786a;
    final /* synthetic */ BehaviorSubject f29787b;
    final /* synthetic */ String f29788c;

    GroupMessagingPresenter$sendSnoomoji$5(GroupMessagingPresenter groupMessagingPresenter, BehaviorSubject behaviorSubject, String str) {
        this.f29786a = groupMessagingPresenter;
        this.f29787b = behaviorSubject;
        this.f29788c = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        GroupMessagingPresenter groupMessagingPresenter = this.f29786a;
        Object obj2 = this.f29787b;
        Intrinsics.m26843a(obj2, "tempMessage");
        GroupMessagingPresenter.m30779a(groupMessagingPresenter, (UserMessage) obj2.m38179b());
        Timber.c(th, "Failed to send message", new Object[0]);
        this.f29786a.m30819h().m24475b(this.f29788c, "snoomoji", null, null, null);
    }
}
