package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.groupchat.ChatSettingsContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$load$4<T> implements Consumer<Boolean> {
    final /* synthetic */ MessagingSettingsPresenter f29831a;

    MessagingSettingsPresenter$load$4(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f29831a = messagingSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Boolean) obj;
        View b = MessagingSettingsPresenter.m30830b(this.f29831a);
        Intrinsics.m26843a(obj, "it");
        b.mo7578a(obj.booleanValue());
    }
}
