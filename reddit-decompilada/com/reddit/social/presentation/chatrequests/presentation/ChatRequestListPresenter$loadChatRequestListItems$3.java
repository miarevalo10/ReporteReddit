package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestListPresenter.kt */
final class ChatRequestListPresenter$loadChatRequestListItems$3<T> implements Consumer<List<? extends ChatInboxItem>> {
    final /* synthetic */ ChatRequestListPresenter f29638a;

    ChatRequestListPresenter$loadChatRequestListItems$3(ChatRequestListPresenter chatRequestListPresenter) {
        this.f29638a = chatRequestListPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        List list = (List) obj;
        if (this.f29638a.f29643b == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        ChatAnalytics.m24463a(list.size());
    }
}
