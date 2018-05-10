package com.reddit.social.presentation.messaginglist;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.VideoFileMessageData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
final class MessageViewHolderKt$bind$$inlined$let$lambda$5 implements OnClickListener {
    final /* synthetic */ MessageViewHolder f22407a;
    final /* synthetic */ HasMessageData f22408b;
    final /* synthetic */ MessageItemOnClickListener f22409c;

    MessageViewHolderKt$bind$$inlined$let$lambda$5(MessageViewHolder messageViewHolder, HasMessageData hasMessageData, MessageItemOnClickListener messageItemOnClickListener) {
        this.f22407a = messageViewHolder;
        this.f22408b = hasMessageData;
        this.f22409c = messageItemOnClickListener;
    }

    public final void onClick(View view) {
        this.f22409c.mo5198a(((VideoFileMessageData) this.f22408b).f29968a, ((VideoFileMessageData) this.f22408b).f29969b);
    }
}
