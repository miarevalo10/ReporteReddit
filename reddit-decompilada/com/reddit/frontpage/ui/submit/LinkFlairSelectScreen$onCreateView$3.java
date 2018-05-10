package com.reddit.frontpage.ui.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen.LinkFlairSelectedListener;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkFlairSelectScreen.kt */
final class LinkFlairSelectScreen$onCreateView$3 implements OnClickListener {
    final /* synthetic */ LinkFlairSelectScreen f21609a;

    LinkFlairSelectScreen$onCreateView$3(LinkFlairSelectScreen linkFlairSelectScreen) {
        this.f21609a = linkFlairSelectScreen;
    }

    public final void onClick(View view) {
        view = this.f21609a.mo7220H();
        Object obj = null;
        if (!(view instanceof LinkFlairSelectedListener)) {
            view = null;
        }
        LinkFlairSelectedListener linkFlairSelectedListener = (LinkFlairSelectedListener) view;
        if (linkFlairSelectedListener != null) {
            LinkFlair linkFlair = this.f21609a.selectedFlair;
            Map map = this.f21609a.flairEdits;
            LinkFlair linkFlair2 = this.f21609a.selectedFlair;
            if (linkFlair2 != null) {
                obj = linkFlair2.getId();
            }
            linkFlairSelectedListener.mo7206a(linkFlair, (String) map.get(obj), this.f21609a.thing);
        }
        this.f21609a.m29351F();
    }
}
