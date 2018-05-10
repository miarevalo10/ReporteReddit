package com.reddit.social.presentation.chatinbox.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxViewHolder.kt */
final class ChatInboxViewHolder$bind$3 implements OnLongClickListener {
    final /* synthetic */ ChatInboxItemEvent f22334a;
    final /* synthetic */ ChatInboxItem f22335b;

    ChatInboxViewHolder$bind$3(ChatInboxItemEvent chatInboxItemEvent, ChatInboxItem chatInboxItem) {
        this.f22334a = chatInboxItemEvent;
        this.f22335b = chatInboxItem;
    }

    public final boolean onLongClick(View view) {
        this.f22334a.mo5114b(this.f22335b);
        return true;
    }
}
