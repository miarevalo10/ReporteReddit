package com.reddit.social.presentation.messaginglist;

import android.view.View;
import com.reddit.social.presentation.messaginglist.content.AdminMessageContent;
import com.reddit.social.presentation.messaginglist.content.ImageFileKt;
import com.reddit.social.presentation.messaginglist.content.ImageFileMessageContent;
import com.reddit.social.presentation.messaginglist.content.LinkContent;
import com.reddit.social.presentation.messaginglist.content.LinkKt;
import com.reddit.social.presentation.messaginglist.content.RedditImageKt;
import com.reddit.social.presentation.messaginglist.content.RedditImageMessageContent;
import com.reddit.social.presentation.messaginglist.content.SnoomojiGifMessageContent;
import com.reddit.social.presentation.messaginglist.content.SnoomojiImageKt;
import com.reddit.social.presentation.messaginglist.content.SnoomojiImageMessageContent;
import com.reddit.social.presentation.messaginglist.content.TextKt;
import com.reddit.social.presentation.messaginglist.content.TextMessageContent;
import com.reddit.social.presentation.presentationobjects.AdminMessageData;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.ImageFileMessageData;
import com.reddit.social.presentation.presentationobjects.LinkContentMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import com.reddit.social.presentation.presentationobjects.RedditImageContentMessageData;
import com.reddit.social.presentation.presentationobjects.SnoomojiGifMessageData;
import com.reddit.social.presentation.presentationobjects.SnoomojiImageMessageData;
import com.reddit.social.presentation.presentationobjects.TextMessageData;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0018\u00010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "", "content", "Landroid/view/View;", "(Landroid/view/View;)V", "getContent", "()Landroid/view/View;", "bindMessage", "", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "listener", "Lcom/reddit/social/presentation/messaginglist/MessageContentClickListener;", "linkEmbedLoaded", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
public class MessageContentViewHolder {
    public final View f22385a;

    public MessageContentViewHolder(View view) {
        this.f22385a = view;
    }

    public final void m24711a(HasMessageData hasMessageData, MessageContentClickListener messageContentClickListener, PublishSubject<Pair<Long, LinkEmbedState>> publishSubject) {
        Intrinsics.m26847b(hasMessageData, "message");
        if (this instanceof TextMessageContent) {
            TextKt.m24736a((TextMessageContent) this, (TextMessageData) hasMessageData, messageContentClickListener);
        } else if (this instanceof AdminMessageContent) {
            AdminMessageContent.m30877a((AdminMessageContent) this, (AdminMessageData) hasMessageData);
        } else if (this instanceof ImageFileMessageContent) {
            ImageFileKt.m24722a((ImageFileMessageContent) this, (ImageFileMessageData) hasMessageData);
        } else if (this instanceof RedditImageMessageContent) {
            RedditImageKt.m24728a((RedditImageMessageContent) this, (RedditImageContentMessageData) hasMessageData);
        } else if (this instanceof SnoomojiGifMessageContent) {
            SnoomojiGifMessageContent.m30884a((SnoomojiGifMessageContent) this, (SnoomojiGifMessageData) hasMessageData);
        } else if (this instanceof SnoomojiImageMessageContent) {
            SnoomojiImageKt.m24733a((SnoomojiImageMessageContent) this, (SnoomojiImageMessageData) hasMessageData);
        } else if (this instanceof LinkContent) {
            LinkKt.m24726a((LinkContent) this, (LinkContentMessageData) hasMessageData, messageContentClickListener, publishSubject);
        } else {
            throw ((Throwable) new NotImplementedError());
        }
    }
}
