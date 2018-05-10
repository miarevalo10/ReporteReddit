package com.reddit.frontpage.presentation.modtools.ban.add;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.nav.Nav;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
final class C1853x2ee5d3ab implements OnClickListener {
    final /* synthetic */ AddBannedUserScreen f20879a;

    C1853x2ee5d3ab(AddBannedUserScreen addBannedUserScreen) {
        this.f20879a = addBannedUserScreen;
    }

    public final void onClick(View view) {
        if (this.f20879a.comment != null) {
            view = this.f20879a.comment;
            String str = null;
            if (view != null) {
                view = view.getId();
            } else {
                view = null;
            }
            if (view != null) {
                view = this.f20879a.comment;
                if ((view != null ? view.j() : null) != null) {
                    view = this.f20879a.comment;
                    view = view != null ? view.j() : null;
                    if (view == null) {
                        Intrinsics.m26842a();
                    }
                    String b = ThingUtil.b(view);
                    AddBannedUserScreen addBannedUserScreen = this.f20879a;
                    Comment comment = this.f20879a.comment;
                    if (comment != null) {
                        str = comment.getId();
                    }
                    if (str == null) {
                        Intrinsics.m26842a();
                    }
                    addBannedUserScreen.m29359a(Nav.m22557a(b, str, "3"));
                }
            }
        }
    }
}
