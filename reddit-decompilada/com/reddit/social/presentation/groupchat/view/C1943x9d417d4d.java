package com.reddit.social.presentation.groupchat.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class C1943x9d417d4d implements OnClickListener {
    final /* synthetic */ GroupMessagingScreen f22358a;
    final /* synthetic */ Uri f22359b;

    C1943x9d417d4d(GroupMessagingScreen groupMessagingScreen, Uri uri) {
        this.f22358a = groupMessagingScreen;
        this.f22359b = uri;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.f22358a.m41332w().mo5162a(this.f22359b);
        }
    }
}
