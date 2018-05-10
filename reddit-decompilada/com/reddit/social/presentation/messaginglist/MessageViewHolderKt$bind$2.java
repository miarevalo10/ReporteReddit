package com.reddit.social.presentation.messaginglist;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"com/reddit/social/presentation/messaginglist/MessageViewHolderKt$bind$2", "Lcom/reddit/social/presentation/messaginglist/MessageContentClickListener;", "(Lcom/reddit/social/presentation/messaginglist/MessageItemOnClickListener;)V", "onClick", "", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "onLongClick", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
public final class MessageViewHolderKt$bind$2 implements MessageContentClickListener {
    final /* synthetic */ MessageItemOnClickListener f29884a;

    MessageViewHolderKt$bind$2(MessageItemOnClickListener messageItemOnClickListener) {
        this.f29884a = messageItemOnClickListener;
    }

    public final void mo5202a(HasMessageData hasMessageData) {
        MessageItemOnClickListener messageItemOnClickListener = this.f29884a;
        if (messageItemOnClickListener != null) {
            messageItemOnClickListener.mo5199b(hasMessageData);
        }
    }

    public final void mo5203b(HasMessageData hasMessageData) {
        MessageItemOnClickListener messageItemOnClickListener = this.f29884a;
        if (messageItemOnClickListener != null) {
            messageItemOnClickListener.mo5196a(hasMessageData);
        }
    }
}
