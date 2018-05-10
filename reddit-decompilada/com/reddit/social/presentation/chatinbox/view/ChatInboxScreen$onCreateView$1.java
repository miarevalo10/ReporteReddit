package com.reddit.social.presentation.chatinbox.view;

import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/reddit/social/presentation/chatinbox/view/ChatInboxScreen$onCreateView$1", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemEvent;", "(Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen;)V", "onItemClick", "", "chatInboxItem", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "onItemLongClick", "onSeeAllClick", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxScreen.kt */
public final class ChatInboxScreen$onCreateView$1 implements ChatInboxItemEvent {
    final /* synthetic */ ChatInboxScreen f29626a;

    ChatInboxScreen$onCreateView$1(ChatInboxScreen chatInboxScreen) {
        this.f29626a = chatInboxScreen;
    }

    public final void mo5113a(ChatInboxItem chatInboxItem) {
        Intrinsics.m26847b(chatInboxItem, "chatInboxItem");
        ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract = this.f29626a.f40188x;
        if (chatPerformanceAnalyticsContract == null) {
            Intrinsics.m26844a("chatPerfAnalytics");
        }
        chatPerformanceAnalyticsContract.mo5102a(chatInboxItem.f22314b);
        ChatInboxScreen.m41161a(this.f29626a, chatInboxItem);
    }

    public final void mo5114b(ChatInboxItem chatInboxItem) {
        Intrinsics.m26847b(chatInboxItem, "chatInboxItem");
        ChatInboxScreen.m41161a(this.f29626a, chatInboxItem);
    }

    public final void mo5115c(ChatInboxItem chatInboxItem) {
        Intrinsics.m26847b(chatInboxItem, "chatInboxItem");
        ChatInboxScreen.m41164b(this.f29626a, chatInboxItem);
    }
}
