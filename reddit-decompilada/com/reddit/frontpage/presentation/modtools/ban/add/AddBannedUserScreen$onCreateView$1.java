package com.reddit.frontpage.presentation.modtools.ban.add;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsScreen;
import com.reddit.frontpage.ui.BaseScreen;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
final class AddBannedUserScreen$onCreateView$1 implements OnClickListener {
    final /* synthetic */ AddBannedUserScreen f20878a;

    AddBannedUserScreen$onCreateView$1(AddBannedUserScreen addBannedUserScreen) {
        this.f20878a = addBannedUserScreen;
    }

    public final void onClick(View view) {
        Activity am_ = this.f20878a.am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
        }
        view = new BanReasonsScreen(am_, this.f20878a.f40086E);
        BaseScreen baseScreen = this.f20878a;
        Intrinsics.m26847b(baseScreen, "<set-?>");
        view.f39105e = baseScreen;
        view.show();
    }
}
