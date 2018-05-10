package com.reddit.social.presentation.groupchat.view;

import com.reddit.frontpage.ui.sorting.SnoomojiPreviewDialog.OnSendListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "snoomojiId", "", "onSend"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$onCreateView$sendListener$1 implements OnSendListener {
    final /* synthetic */ GroupMessagingScreen f29858a;

    GroupMessagingScreen$onCreateView$sendListener$1(GroupMessagingScreen groupMessagingScreen) {
        this.f29858a = groupMessagingScreen;
    }

    public final void mo5201a(String str) {
        Intrinsics.m26847b(str, "snoomojiId");
        this.f29858a.m41332w().mo5174c(str);
    }
}
