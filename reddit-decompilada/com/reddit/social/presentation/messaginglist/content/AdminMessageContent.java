package com.reddit.social.presentation.messaginglist.content;

import android.widget.TextView;
import com.reddit.social.presentation.messaginglist.MessageContentViewHolder;
import com.reddit.social.presentation.presentationobjects.AdminMessageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/content/AdminMessageContent;", "Lcom/reddit/social/presentation/messaginglist/MessageContentViewHolder;", "message", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "getMessage", "()Landroid/widget/TextView;", "bind", "", "messageData", "Lcom/reddit/social/presentation/presentationobjects/AdminMessageData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Admin.kt */
public final class AdminMessageContent extends MessageContentViewHolder {
    private final TextView f29892b;

    public AdminMessageContent(TextView textView) {
        Intrinsics.m26847b(textView, "message");
        super(textView);
        this.f29892b = textView;
    }

    public static void m30877a(AdminMessageContent adminMessageContent, AdminMessageData adminMessageData) {
        Intrinsics.m26847b(adminMessageContent, "$receiver");
        Intrinsics.m26847b(adminMessageData, "messageData");
        adminMessageContent.f29892b.setText((CharSequence) adminMessageData.f29924a);
    }
}
