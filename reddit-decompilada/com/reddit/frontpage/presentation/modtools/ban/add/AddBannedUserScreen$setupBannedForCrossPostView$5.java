package com.reddit.frontpage.presentation.modtools.ban.add;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder.OnViewMediaListener;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
final class AddBannedUserScreen$setupBannedForCrossPostView$5 implements OnClickListener {
    final /* synthetic */ AddBannedUserScreen f20884a;

    AddBannedUserScreen$setupBannedForCrossPostView$5(AddBannedUserScreen addBannedUserScreen) {
        this.f20884a = addBannedUserScreen;
    }

    public final void onClick(View view) {
        view = Util.m23994b(this.f20884a.link);
        if (this.f20884a.f40088w != null && this.f20884a.link != null) {
            OnViewMediaListener onViewMediaListener = this.f20884a.f40088w;
            if (onViewMediaListener == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.newcard.LinkViewHolder.OnViewMediaListener");
            }
            onViewMediaListener.mo4993a((Link) view);
        }
    }
}
