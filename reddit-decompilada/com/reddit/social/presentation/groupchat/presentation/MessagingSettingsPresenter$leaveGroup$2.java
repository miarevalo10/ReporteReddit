package com.reddit.social.presentation.groupchat.presentation;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$leaveGroup$2<T> implements Consumer<Throwable> {
    final /* synthetic */ MessagingSettingsPresenter f29828a;

    MessagingSettingsPresenter$leaveGroup$2(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f29828a = messagingSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        MessagingSettingsPresenter.m30830b(this.f29828a).mo7573a("Something went wrong and we couldn't remove you from this group");
    }
}
