package com.reddit.social.presentation.groupchat.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.reddit.social.presentation.presentationobjects.MessageData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$deleteMessage$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ GroupMessagingScreen f22350a;
    final /* synthetic */ MessageData f22351b;

    GroupMessagingScreen$deleteMessage$$inlined$let$lambda$1(GroupMessagingScreen groupMessagingScreen, MessageData messageData) {
        this.f22350a = groupMessagingScreen;
        this.f22351b = messageData;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f22350a.m41332w().mo5167a(this.f22351b.f22438k, this.f22351b.f22429b, this.f22351b.f22428a);
    }
}
