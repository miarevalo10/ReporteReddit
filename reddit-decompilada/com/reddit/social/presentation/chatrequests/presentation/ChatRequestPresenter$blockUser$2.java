package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.social.analytics.ChatAnalytics.Source;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "channel", "Lcom/sendbird/android/GroupChannel;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
final class ChatRequestPresenter$blockUser$2<T> implements Consumer<GroupChannel> {
    final /* synthetic */ ChatRequestPresenter f29651a;
    final /* synthetic */ String f29652b;

    ChatRequestPresenter$blockUser$2(ChatRequestPresenter chatRequestPresenter, String str) {
        this.f29651a = chatRequestPresenter;
        this.f29652b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (GroupChannel) obj;
        ChatRequestPresenter.m30676a(this.f29651a).mo7517d(this.f29652b);
        Object obj2 = this.f29652b;
        Intrinsics.m26843a(obj, "channel");
        obj = obj.m30981k();
        if (Intrinsics.m26845a(obj2, obj != null ? obj.m25021d() : null) != null) {
            ChatRequestPresenter.m30676a(this.f29651a).mo7519f();
            ChatRequestPresenter.m30676a(this.f29651a).mo7520g();
        }
        obj = this.f29651a.f29663e;
        if (obj != null) {
            this.f29651a.m30692d().m24472a(obj, this.f29652b, Source.f22286f);
        }
    }
}
