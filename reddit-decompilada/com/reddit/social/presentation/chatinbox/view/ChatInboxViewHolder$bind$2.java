package com.reddit.social.presentation.chatinbox.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxViewHolder.kt */
final class ChatInboxViewHolder$bind$2 implements OnClickListener {
    final /* synthetic */ ChatInboxItemEvent f22332a;
    final /* synthetic */ ChatInboxItem f22333b;

    ChatInboxViewHolder$bind$2(ChatInboxItemEvent chatInboxItemEvent, ChatInboxItem chatInboxItem) {
        this.f22332a = chatInboxItemEvent;
        this.f22333b = chatInboxItem;
    }

    public final void onClick(View view) {
        this.f22332a.mo5113a(this.f22333b);
    }
}
