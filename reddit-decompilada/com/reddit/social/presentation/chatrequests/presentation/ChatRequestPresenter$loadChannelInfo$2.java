package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.frontpage.C1761R;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
final class ChatRequestPresenter$loadChannelInfo$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ChatRequestPresenter f29657a;

    ChatRequestPresenter$loadChannelInfo$2(ChatRequestPresenter chatRequestPresenter) {
        this.f29657a = chatRequestPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.c((Throwable) obj, "Failed to load channel info", new Object[0]);
        ChatRequestPresenter.m30676a(this.f29657a).mo7506a((int) C1761R.string.chat_error_something_went_wrong);
    }
}
