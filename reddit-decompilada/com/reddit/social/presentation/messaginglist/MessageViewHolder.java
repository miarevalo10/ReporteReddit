package com.reddit.social.presentation.messaginglist;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/MessageViewHolder;", "Lcom/reddit/social/presentation/messaginglist/BaseMessageViewHolder;", "view", "Lcom/reddit/social/presentation/messaginglist/MessageView;", "dateContainer", "Landroid/widget/LinearLayout;", "messageContainer", "dateText", "Landroid/widget/TextView;", "timeText", "profileIcon", "Landroid/widget/ImageView;", "profileIconContainer", "Landroid/widget/FrameLayout;", "usernameText", "contentContainer", "content", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "sentStatusText", "(Lcom/reddit/social/presentation/messaginglist/MessageView;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/FrameLayout;Landroid/widget/TextView;Landroid/widget/FrameLayout;Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;Landroid/widget/TextView;)V", "getContent", "()Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "getContentContainer", "()Landroid/widget/FrameLayout;", "getDateContainer", "()Landroid/widget/LinearLayout;", "getDateText", "()Landroid/widget/TextView;", "getMessageContainer", "getProfileIcon", "()Landroid/widget/ImageView;", "getProfileIconContainer", "getSentStatusText", "getTimeText", "getUsernameText", "getView", "()Lcom/reddit/social/presentation/messaginglist/MessageView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageViewHolder.kt */
public final class MessageViewHolder extends BaseMessageViewHolder {
    final MessageView f34587a;
    final LinearLayout f34588b;
    final LinearLayout f34589p;
    final TextView f34590q;
    final TextView f34591r;
    final ImageView f34592s;
    final FrameLayout f34593t;
    final TextView f34594u;
    final MessageContentViewHolder f34595v;
    final TextView f34596w;
    private final FrameLayout f34597x;

    public MessageViewHolder(MessageView messageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView, FrameLayout frameLayout, TextView textView3, FrameLayout frameLayout2, MessageContentViewHolder messageContentViewHolder, TextView textView4) {
        Intrinsics.m26847b(messageView, "view");
        Intrinsics.m26847b(linearLayout, "dateContainer");
        Intrinsics.m26847b(linearLayout2, "messageContainer");
        Intrinsics.m26847b(textView, "dateText");
        Intrinsics.m26847b(textView2, "timeText");
        Intrinsics.m26847b(imageView, "profileIcon");
        Intrinsics.m26847b(frameLayout, "profileIconContainer");
        Intrinsics.m26847b(textView3, "usernameText");
        Intrinsics.m26847b(frameLayout2, "contentContainer");
        Intrinsics.m26847b(messageContentViewHolder, "content");
        Intrinsics.m26847b(textView4, "sentStatusText");
        super(messageView);
        this.f34587a = messageView;
        this.f34588b = linearLayout;
        this.f34589p = linearLayout2;
        this.f34590q = textView;
        this.f34591r = textView2;
        this.f34592s = imageView;
        this.f34593t = frameLayout;
        this.f34594u = textView3;
        this.f34597x = frameLayout2;
        this.f34595v = messageContentViewHolder;
        this.f34596w = textView4;
    }
}
