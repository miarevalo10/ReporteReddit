package com.reddit.social.presentation.messaginglist;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
final class MessageViewHolderKt$bind$$inlined$let$lambda$1 implements OnLongClickListener {
    final /* synthetic */ MessageViewHolder f22398a;
    final /* synthetic */ HasMessageData f22399b;
    final /* synthetic */ MessageItemOnClickListener f22400c;

    MessageViewHolderKt$bind$$inlined$let$lambda$1(MessageViewHolder messageViewHolder, HasMessageData hasMessageData, MessageItemOnClickListener messageItemOnClickListener) {
        this.f22398a = messageViewHolder;
        this.f22399b = hasMessageData;
        this.f22400c = messageItemOnClickListener;
    }

    public final boolean onLongClick(View view) {
        this.f22400c.mo5199b(this.f22399b);
        return true;
    }
}
