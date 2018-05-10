package com.reddit.frontpage.widgets.modtools.modview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.util.ModCacheLinks;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModViewRight.kt */
final class ModViewRight$$special$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ ModViewRight f22016a;
    final /* synthetic */ Context f22017b;

    ModViewRight$$special$$inlined$apply$lambda$1(ModViewRight modViewRight, Context context) {
        this.f22016a = modViewRight;
        this.f22017b = context;
    }

    public final void onClick(View view) {
        view = ModUtil.m23824a();
        Link link = this.f22016a.getLink();
        Subreddit subreddit = null;
        String name = link != null ? link.getName() : null;
        Link link2 = this.f22016a.getLink();
        Boolean valueOf = link2 != null ? Boolean.valueOf(link2.isDistinguished()) : null;
        if (valueOf == null) {
            Intrinsics.m26842a();
        }
        if (view.getDistinguishState(name, valueOf.booleanValue()) != null) {
            view = this.f22016a;
            Object drawable = this.f22016a.getDistinguishView().getDrawable();
            Intrinsics.m26843a(drawable, "distinguishView.drawable");
            view.m35309a((Drawable) drawable);
        } else {
            DrawableCompat.a(this.f22016a.getDistinguishView().getDrawable(), this.f22017b.getResources().getColor(C1761R.color.rdt_green));
        }
        view = ModUtil.m23824a();
        link = this.f22016a.getLink();
        name = link != null ? link.getName() : null;
        link2 = this.f22016a.getLink();
        boolean z = link2 != null && link2.isDistinguished();
        view = view.getDistinguishState(name, z) ^ 1;
        ModCacheLinks a = ModUtil.m23824a();
        link2 = this.f22016a.getLink();
        a.cacheDistinguishState(link2 != null ? link2.getName() : null, Boolean.valueOf(view));
        this.f22016a.getModerateListener().mo5039e(this.f22016a.getLink(), view);
        link = this.f22016a.getLink();
        if (link != null) {
            subreddit = link.getSubredditDetail();
        }
        if (subreddit != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20049h.f20068M);
            String name2 = subreddit.getName();
            Object obj = subreddit.display_name;
            Intrinsics.m26843a(obj, "subreddit.display_name");
            modEventBuilder = (ModEventBuilder) modEventBuilder.m21889a(name2, obj);
            Link link3 = this.f22016a.getLink();
            if (link3 == null) {
                Intrinsics.m26842a();
            }
            String name3 = link3.getName();
            name2 = String.valueOf(Util.m23952a(this.f22016a.getLink()));
            Link link4 = this.f22016a.getLink();
            if (link4 == null) {
                Intrinsics.m26842a();
            }
            Object title = link4.getTitle();
            Intrinsics.m26843a(title, "link!!.title");
            ((ModEventBuilder) modEventBuilder.m21890a(name3, name2, title)).m21891a();
        }
        OnModActionCompletedListener actionCompletedListener = this.f22016a.getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Screens.m22631a(this.f22017b, view != null ? C1761R.string.success_post_distinguish : C1761R.string.success_post_undistinguish);
    }
}
