package com.reddit.social.presentation.groupchat.presentation;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$setChannelMuted$2<T> implements Consumer<Object> {
    final /* synthetic */ MessagingSettingsPresenter f29836a;
    final /* synthetic */ boolean f29837b;

    MessagingSettingsPresenter$setChannelMuted$2(MessagingSettingsPresenter messagingSettingsPresenter, boolean z) {
        this.f29836a = messagingSettingsPresenter;
        this.f29837b = z;
    }

    public final void accept(Object obj) {
        MessagingSettingsPresenter.m30830b(this.f29836a).mo7578a(this.f29837b);
    }
}
