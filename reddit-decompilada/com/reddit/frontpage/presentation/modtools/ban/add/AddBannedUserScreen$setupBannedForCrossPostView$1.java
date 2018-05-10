package com.reddit.frontpage.presentation.modtools.ban.add;

import android.view.View;
import android.view.View.OnLongClickListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
final class AddBannedUserScreen$setupBannedForCrossPostView$1 implements OnLongClickListener {
    final /* synthetic */ AddBannedUserScreen f20880a;

    AddBannedUserScreen$setupBannedForCrossPostView$1(AddBannedUserScreen addBannedUserScreen) {
        this.f20880a = addBannedUserScreen;
    }

    public final boolean onLongClick(View view) {
        view = this.f20880a.f40087v;
        if (view != null) {
            view.m23469a();
        }
        return true;
    }
}
