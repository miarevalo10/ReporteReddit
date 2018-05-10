package com.reddit.social.presentation.groupchat.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.reddit.frontpage.util.FileUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class C1942x84b9e966 implements OnClickListener {
    final /* synthetic */ GroupMessagingScreen f22355a;
    final /* synthetic */ String f22356b;

    C1942x84b9e966(GroupMessagingScreen groupMessagingScreen, String str) {
        this.f22355a = groupMessagingScreen;
        this.f22356b = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            FileUtil.m23695a(this.f22355a.am_(), this.f22356b, this.f22356b);
        }
    }
}
