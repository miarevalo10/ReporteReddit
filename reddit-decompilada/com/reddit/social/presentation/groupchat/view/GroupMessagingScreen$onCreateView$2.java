package com.reddit.social.presentation.groupchat.view;

import com.reddit.social.presentation.messaginglist.MessageItemOnClickListener;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/reddit/social/presentation/groupchat/view/GroupMessagingScreen$onCreateView$2", "Lcom/reddit/social/presentation/messaginglist/MessageItemOnClickListener;", "(Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen;)V", "onFileMessageItemClick", "", "name", "", "fileUrl", "onLongClick", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "onRedditItemClick", "url", "onUserMessageItemClick", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
public final class GroupMessagingScreen$onCreateView$2 implements MessageItemOnClickListener {
    final /* synthetic */ GroupMessagingScreen f29853a;

    public final void mo5197a(String str) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
    }

    GroupMessagingScreen$onCreateView$2(GroupMessagingScreen groupMessagingScreen) {
        this.f29853a = groupMessagingScreen;
    }

    public final void mo5196a(HasMessageData hasMessageData) {
        Intrinsics.m26847b(hasMessageData, "message");
        if (Intrinsics.m26845a(hasMessageData.mo5204a().f22436i, SentStatus.f22462c)) {
            GroupMessagingScreen.m41286a(this.f29853a, hasMessageData);
        }
    }

    public final void mo5198a(String str, String str2) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "fileUrl");
        GroupMessagingScreen.m41288a(this.f29853a, str2);
    }

    public final void mo5199b(HasMessageData hasMessageData) {
        Intrinsics.m26847b(hasMessageData, "message");
        GroupMessagingScreen.m41286a(this.f29853a, hasMessageData);
    }
}
