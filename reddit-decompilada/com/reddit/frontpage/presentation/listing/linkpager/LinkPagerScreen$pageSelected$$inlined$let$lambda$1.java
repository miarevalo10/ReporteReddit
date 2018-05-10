package com.reddit.frontpage.presentation.listing.linkpager;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerScreen.kt */
final class LinkPagerScreen$pageSelected$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ LinkPagerScreen f20608a;

    LinkPagerScreen$pageSelected$$inlined$let$lambda$1(LinkPagerScreen linkPagerScreen) {
        this.f20608a = linkPagerScreen;
    }

    public final void onClick(View view) {
        if (this.f20608a.mo6986J() == null) {
            Routing.m22621a((Screen) this.f20608a);
        }
    }
}
