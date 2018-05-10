package com.reddit.social.presentation.groupchat.presentation;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$load$5<T> implements Consumer<Throwable> {
    final /* synthetic */ MessagingSettingsPresenter f29832a;

    MessagingSettingsPresenter$load$5(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f29832a = messagingSettingsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.c((Throwable) obj, "Failed to get channel muting setting.", new Object[0]);
        MessagingSettingsPresenter.m30830b(this.f29832a).mo7570a();
    }
}
