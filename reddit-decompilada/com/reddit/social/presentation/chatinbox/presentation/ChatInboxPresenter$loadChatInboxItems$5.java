package com.reddit.social.presentation.chatinbox.presentation;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "errorThrowable", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
final class ChatInboxPresenter$loadChatInboxItems$5<T> implements Consumer<Throwable> {
    final /* synthetic */ ChatInboxPresenter f29603a;

    ChatInboxPresenter$loadChatInboxItems$5(ChatInboxPresenter chatInboxPresenter) {
        this.f29603a = chatInboxPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        ChatInboxPresenter.m30626a(this.f29603a).mo7492a(null, true);
        Timber.e(th.getMessage(), new Object[0]);
    }
}
