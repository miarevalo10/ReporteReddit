package com.reddit.frontpage.presentation.modtools.ban.add;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
final class AddBannedUserScreen$setupBannedForCrossPostView$3 implements OnClickListener {
    final /* synthetic */ AddBannedUserScreen f20882a;

    AddBannedUserScreen$setupBannedForCrossPostView$3(AddBannedUserScreen addBannedUserScreen) {
        this.f20882a = addBannedUserScreen;
    }

    public final void onClick(View view) {
        view = Util.m23994b(this.f20882a.link);
        if (view != null) {
            Activity am_ = this.f20882a.am_();
            if (am_ != null) {
                am_.startActivity(IntentUtil.m23745a((Context) this.f20882a.am_(), (ScreenDeepLinker) DetailHolderScreen.m38887b(view.getId(), null, null)));
            }
        }
    }
}
