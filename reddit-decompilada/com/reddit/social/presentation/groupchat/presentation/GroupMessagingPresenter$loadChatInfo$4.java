package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.C1761R;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadChatInfo$4<T> implements Consumer<Throwable> {
    final /* synthetic */ GroupMessagingPresenter f29762a;

    GroupMessagingPresenter$loadChatInfo$4(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29762a = groupMessagingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        GroupMessagingPresenter.m30774a(this.f29762a).mo7548a((int) C1761R.string.chat_error_load_chat_info);
        Timber.c(th, "Failed to load channel info", new Object[0]);
    }
}
