package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeader;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder.Companion;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkViewHolder.kt */
final class LinkViewHolder$attachMenuListener$1 implements OnMenuItemClickListener {
    final /* synthetic */ LinkViewHolder f28513a;
    final /* synthetic */ Context f28514b;
    final /* synthetic */ SessionManager f28515c;
    final /* synthetic */ Session f28516d;

    LinkViewHolder$attachMenuListener$1(LinkViewHolder linkViewHolder, Context context, SessionManager sessionManager, Session session) {
        this.f28513a = linkViewHolder;
        this.f28514b = context;
        this.f28515c = sessionManager;
        this.f28516d = session;
    }

    public final boolean m29729a(MenuItem menuItem) {
        Intrinsics.m26843a((Object) menuItem, "item");
        Companion companion;
        switch (menuItem.getItemId()) {
            case C1761R.id.action_hide:
                menuItem = AppAnalytics.m21858b();
                LinkHeader M = this.f28513a.m34771M();
                if (M != null) {
                    menuItem = menuItem.m21823a((View) M);
                    companion = LinkViewHolder.f34040w;
                    menuItem.m21826b(LinkViewHolder.f34041z).m21825a();
                    menuItem = CustomReportEventBuilder.f27449a;
                    CustomReportEventBuilder.Companion.m21900a(this.f28513a.m34773O(), "post_overflow", "click", CustomReasonsNoun.f20020e.f20028l);
                    LinkUtil.m23800d(this.f28513a.m34773O().getName());
                    menuItem = this.f28513a.f34046s;
                    if (menuItem != null) {
                        menuItem.mo4839a(this.f28513a);
                        break;
                    }
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                break;
            case C1761R.id.action_report:
                Context context;
                if (AccountUtil.a(this.f28515c) == null) {
                    menuItem = RedditAlertDialog.f21112b;
                    context = this.f28514b;
                    Intrinsics.m26843a((Object) context, "context");
                    RedditAlertDialog.Companion.m23296a(context, this.f28513a.m34773O().getName(), (Function0) new Function0<Unit>() {
                        public final /* synthetic */ Object invoke() {
                            OnLinkHiddenListener onLinkHiddenListener = this.f28513a.f34046s;
                            if (onLinkHiddenListener != null) {
                                onLinkHiddenListener.mo4839a(this.f28513a);
                            }
                            return Unit.f25273a;
                        }
                    }).m23323a();
                    menuItem = CustomReportEventBuilder.f27449a;
                    CustomReportEventBuilder.Companion.m21900a(this.f28513a.m34773O(), "post_overflow", "click", CustomReasonsNoun.f20017b.f20028l);
                    break;
                }
                menuItem = RedditAlertDialog.f21112b;
                context = this.f28514b;
                Intrinsics.m26843a((Object) context, "context");
                RedditAlertDialog.Companion.m23289a(context).m23323a();
                break;
            case C1761R.id.action_save:
                menuItem = AppAnalytics.m21858b().m21823a(this.f28513a.c);
                companion = LinkViewHolder.f34040w;
                menuItem.m21826b(LinkViewHolder.f34033A).m21827c(this.f28513a.m34773O().ad).m21828d(this.f28513a.m34773O().getName()).m21830f(this.f28513a.m34773O().getDomain()).m21825a();
                menuItem = CustomReportEventBuilder.f27449a;
                CustomReportEventBuilder.Companion.m21900a(this.f28513a.m34773O(), "post_overflow", "click", CustomReasonsNoun.f20018c.f20028l);
                Object obj = this.f28514b;
                Intrinsics.m26843a(obj, "context");
                menuItem = ContextsKt.m24080d(obj);
                Object obj2 = this.f28515c;
                Intrinsics.m26843a(obj2, "sessionManager");
                if (!obj2.c().isAnonymous()) {
                    LinkUtil.m23782a(this.f28516d, this.f28513a.m34773O().getName());
                    break;
                }
                this.f28515c.a(menuItem, true);
                break;
            case C1761R.id.action_share:
                menuItem = this.f28513a.f34047t;
                if (menuItem != null) {
                    menuItem.invoke();
                    break;
                }
                break;
            case C1761R.id.action_unsave:
                menuItem = AppAnalytics.m21858b().m21823a(this.f28513a.c);
                companion = LinkViewHolder.f34040w;
                menuItem.m21826b(LinkViewHolder.f34034B).m21827c(this.f28513a.m34773O().ad).m21828d(this.f28513a.m34773O().getName()).m21830f(this.f28513a.m34773O().getDomain()).m21825a();
                menuItem = CustomReportEventBuilder.f27449a;
                CustomReportEventBuilder.Companion.m21900a(this.f28513a.m34773O(), "post_overflow", "click", CustomReasonsNoun.f20019d.f20028l);
                LinkUtil.m23792b(this.f28516d, this.f28513a.m34773O().getName());
                break;
            default:
                break;
        }
        return true;
    }
}
