package com.reddit.social.presentation.groupchat.presentation;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$leaveGroup$1<T> implements Consumer<Boolean> {
    final /* synthetic */ MessagingSettingsPresenter f29827a;

    MessagingSettingsPresenter$leaveGroup$1(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f29827a = messagingSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Boolean) obj;
        Intrinsics.m26843a(obj, "it");
        if (obj.booleanValue() != null) {
            MessagingSettingsPresenter.m30830b(this.f29827a).mo7584c();
            MessagingSettingsPresenter.m30830b(this.f29827a).mo7573a("You were successfully removed from this group");
            return;
        }
        MessagingSettingsPresenter.m30830b(this.f29827a).mo7573a("Something went wrong and we couldn't remove you from this group");
    }
}
