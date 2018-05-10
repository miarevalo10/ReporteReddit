package com.reddit.social.presentation.chatrequests.view;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.presentation.chatinbox.view.ChatInboxItemEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/reddit/social/presentation/chatrequests/view/ChatRequestListScreen$onCreateView$2", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemEvent;", "(Lcom/reddit/social/presentation/chatrequests/view/ChatRequestListScreen;)V", "onItemClick", "", "chatInboxItem", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "onItemLongClick", "onSeeAllClick", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestListScreen.kt */
public final class ChatRequestListScreen$onCreateView$2 implements ChatInboxItemEvent {
    final /* synthetic */ ChatRequestListScreen f29671a;

    public final void mo5114b(ChatInboxItem chatInboxItem) {
        Intrinsics.m26847b(chatInboxItem, "chatInboxItem");
    }

    public final void mo5115c(ChatInboxItem chatInboxItem) {
        Intrinsics.m26847b(chatInboxItem, "chatInboxItem");
    }

    ChatRequestListScreen$onCreateView$2(ChatRequestListScreen chatRequestListScreen) {
        this.f29671a = chatRequestListScreen;
    }

    public final void mo5113a(ChatInboxItem chatInboxItem) {
        Intrinsics.m26847b(chatInboxItem, "chatInboxItem");
        ChatRequestListScreen chatRequestListScreen = this.f29671a;
        chatInboxItem = chatInboxItem.f22314b;
        Intrinsics.m26847b(chatInboxItem, UpdateFragment.FRAGMENT_URL);
        Routing.m22623a((Screen) chatRequestListScreen, Nav.m22609t(chatInboxItem));
    }
}
