package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.domain.functions.HasMore;
import com.reddit.social.domain.functions.MessagesBatch;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadMessages$5<T> implements Consumer<Throwable> {
    final /* synthetic */ GroupMessagingPresenter f29769a;

    GroupMessagingPresenter$loadMessages$5(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29769a = groupMessagingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        GroupMessagingPresenter.m30774a(this.f29769a).mo7562c(new MessagesBatch(CollectionsKt__CollectionsKt.m26790a(), HasMore.f22300c));
        Timber.c(th, "Failed to load more messages", new Object[0]);
    }
}
