package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.reddit.social.analytics.ChatAnalytics.Source;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$blockUser$2<T> implements Consumer<Boolean> {
    final /* synthetic */ MessagingSettingsPresenter f29824a;
    final /* synthetic */ String f29825b;

    MessagingSettingsPresenter$blockUser$2(MessagingSettingsPresenter messagingSettingsPresenter, String str) {
        this.f29824a = messagingSettingsPresenter;
        this.f29825b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        MessagingSettingsPresenter.m30830b(this.f29824a).mo7584c();
        obj = MessagingSettingsPresenter.m30830b(this.f29824a);
        String f = Util.m24027f((int) C1761R.string.chat_success_user_block);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_success_user_block)");
        obj.mo7573a(f);
        obj = this.f29824a.f29840b;
        if (obj == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        obj.m24472a(MessagingSettingsPresenter.m30831c(this.f29824a), this.f29825b, Source.f22284d);
    }
}
