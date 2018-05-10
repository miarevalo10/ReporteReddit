package com.reddit.frontpage.presentation.modtools.ban.add;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
final class AddBannedUserScreen$setupBannedForCrossPostView$2 implements OnClickListener {
    final /* synthetic */ AddBannedUserScreen f20881a;

    AddBannedUserScreen$setupBannedForCrossPostView$2(AddBannedUserScreen addBannedUserScreen) {
        this.f20881a = addBannedUserScreen;
    }

    public final void onClick(View view) {
        if (this.f20881a.f40088w != null) {
            view = this.f20881a.f40088w;
            if (view == null) {
                Intrinsics.m26842a();
            }
            view.mo4993a(this.f20881a.link);
        }
    }
}
