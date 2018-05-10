package com.reddit.frontpage.ui.modtools;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.alert.DialogMenu;
import com.reddit.frontpage.ui.alert.DialogMenu.Builder;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnModerateListener;
import timber.log.Timber;

public class PopupPostModOptions {
    public final DialogMenu f21478a;
    public OnModActionCompletedListener f21479b;
    private Menu f21480c;
    private MenuItem f21481d;
    private MenuItem f21482e;
    private MenuItem f21483f;
    private MenuItem f21484g;
    private MenuItem f21485h;
    private MenuItem f21486i;
    private MenuItem f21487j;
    private MenuItem f21488k;
    private MenuItem f21489l;
    private MenuItem f21490m;
    private final Link f21491n;
    private final OnModerateListener f21492o;
    private final String f21493p;
    private Screen f21494q;
    private final OnMenuItemClickListener f21495r = new C23571(this);

    class C23571 implements OnMenuItemClickListener {
        final /* synthetic */ PopupPostModOptions f29175a;

        C23571(PopupPostModOptions popupPostModOptions) {
            this.f29175a = popupPostModOptions;
        }

        public final boolean m30288a(MenuItem menuItem) {
            if (this.f29175a.f21492o == null) {
                Timber.e("Attempted action on moderator popup without any moderateListener", new Object[0]);
                return false;
            }
            menuItem = menuItem.getItemId();
            if (menuItem == this.f29175a.f21482e.getItemId()) {
                boolean a = ModUtil.m23824a().m30453a(this.f29175a.f21491n.getName(), this.f29175a.f21491n.isNsfw()) ^ 1;
                ModUtil.m23824a().m30452a(this.f29175a.f21491n.getName(), Boolean.valueOf(a));
                this.f29175a.f21492o.mo5033a(this.f29175a.f21491n, a);
                PopupPostModOptions.m23564a(this.f29175a, a ? "post_mark_nsfw" : "post_unmark_nsfw");
            } else if (menuItem == this.f29175a.f21483f.getItemId()) {
                menuItem = ModUtil.m23824a().m30455b(this.f29175a.f21491n.getName(), this.f29175a.f21491n.isSpoiler()) ^ 1;
                ModUtil.m23824a().m30454b(this.f29175a.f21491n.getName(), Boolean.valueOf(menuItem));
                this.f29175a.f21492o.mo5035b(this.f29175a.f21491n, menuItem);
                PopupPostModOptions.m23564a(this.f29175a, menuItem != null ? "post_mark_spoiler" : "post_unmark_spoiler");
            } else if (menuItem == this.f29175a.f21484g.getItemId()) {
                menuItem = ModUtil.m23824a().m30457c(this.f29175a.f21491n.getName(), this.f29175a.f21491n.isLocked()) ^ 1;
                ModUtil.m23824a().m30456c(this.f29175a.f21491n.getName(), Boolean.valueOf(menuItem));
                this.f29175a.f21492o.mo5037c(this.f29175a.f21491n, menuItem);
                PopupPostModOptions.m23564a(this.f29175a, menuItem != null ? "post_mod_lock" : "post_mod_unlock");
            } else if (menuItem == this.f29175a.f21485h.getItemId()) {
                menuItem = ModUtil.m23824a().getStickyState(this.f29175a.f21491n.getName(), this.f29175a.f21491n.isStickied()) ^ 1;
                ModUtil.m23824a().cacheStickyState(this.f29175a.f21491n.getName(), Boolean.valueOf(menuItem));
                this.f29175a.f21492o.mo5038d(this.f29175a.f21491n, menuItem);
                PopupPostModOptions.m23564a(this.f29175a, menuItem != null ? "post_mod_pin" : "post_mod_unpin");
            } else if (menuItem == this.f29175a.f21486i.getItemId()) {
                ModUtil.m23824a().cacheRemovedState(this.f29175a.f21491n.getName(), Boolean.valueOf(true));
                this.f29175a.f21492o.mo5031a(this.f29175a.f21491n);
                PopupPostModOptions.m23564a(this.f29175a, "post_mod_remove");
            } else if (menuItem == this.f29175a.f21487j.getItemId()) {
                ModUtil.m23824a().m30458d(this.f29175a.f21491n.getName(), Boolean.valueOf(true));
                this.f29175a.f21492o.mo5034b(this.f29175a.f21491n);
                PopupPostModOptions.m23564a(this.f29175a, "post_mod_remove_spam");
            } else if (menuItem == this.f29175a.f21488k.getItemId()) {
                ModUtil.m23824a().cacheApprovedState(this.f29175a.f21491n.getName(), Boolean.valueOf(true));
                this.f29175a.f21492o.mo5036c(this.f29175a.f21491n);
                PopupPostModOptions.m23564a(this.f29175a, "post_mod_approve");
            } else if (menuItem == this.f29175a.f21489l.getItemId()) {
                menuItem = ModUtil.m23824a().getDistinguishState(this.f29175a.f21491n.getName(), this.f29175a.f21491n.isDistinguished()) ^ 1;
                ModUtil.m23824a().cacheDistinguishState(this.f29175a.f21491n.getName(), Boolean.valueOf(menuItem));
                this.f29175a.f21492o.mo5039e(this.f29175a.f21491n, menuItem);
                PopupPostModOptions.m23564a(this.f29175a, menuItem != null ? "post_distinguish" : "post_undistinguish");
            } else if (menuItem == this.f29175a.f21481d.getItemId()) {
                this.f29175a.f21492o.mo5032a(this.f29175a.f21491n, this.f29175a.f21494q);
            } else if (menuItem == this.f29175a.f21490m.getItemId()) {
                new PopupModReports(this.f29175a.f21494q.am_(), this.f29175a.f21491n, this.f29175a.f21493p, this.f29175a.f21479b).m23562b();
            }
            if (this.f29175a.f21479b != null) {
                this.f29175a.f21479b.mo4891a();
            }
            return false;
        }
    }

    public final void m23581a(OnDismissListener onDismissListener) {
        if (this.f21478a != null) {
            this.f21478a.f21085d = onDismissListener;
        }
    }

    private void m23565a(int[] iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (this.f21480c.findItem(i) != null) {
                    this.f21480c.findItem(i).setVisible(false);
                }
            }
        }
    }

    public PopupPostModOptions(Context context, Link link, OnModerateListener onModerateListener, String str, int[] iArr, boolean z) {
        this.f21480c = new PopupMenu(context, null).a;
        new MenuInflater(context).inflate(C1761R.menu.menu_link_mod_options, this.f21480c);
        this.f21481d = this.f21480c.findItem(C1761R.id.action_flair);
        this.f21482e = this.f21480c.findItem(C1761R.id.action_mark_nsfw);
        this.f21483f = this.f21480c.findItem(C1761R.id.action_mark_spoiler);
        this.f21484g = this.f21480c.findItem(C1761R.id.action_lock_comments);
        this.f21485h = this.f21480c.findItem(C1761R.id.action_sticky_announcement);
        this.f21486i = this.f21480c.findItem(C1761R.id.action_remove_post);
        this.f21487j = this.f21480c.findItem(C1761R.id.action_remove_spam);
        this.f21488k = this.f21480c.findItem(C1761R.id.action_approve_post);
        this.f21489l = this.f21480c.findItem(C1761R.id.action_distinguish);
        this.f21490m = this.f21480c.findItem(C1761R.id.action_view_reports);
        this.f21491n = link;
        this.f21492o = onModerateListener;
        this.f21493p = str;
        this.f21494q = Routing.m22617a(context);
        this.f21482e.setTitle(ModUtil.m23824a().m30453a(link.getName(), link.isNsfw()) != null ? C1761R.string.action_unmark_nsfw : C1761R.string.action_mark_nsfw);
        this.f21483f.setTitle(ModUtil.m23824a().m30455b(link.getName(), link.isSpoiler()) != null ? C1761R.string.action_unmark_spoiler : C1761R.string.action_mark_spoiler);
        this.f21484g.setTitle(ModUtil.m23824a().m30457c(link.getName(), link.isLocked()) != null ? C1761R.string.action_unlock_comments : C1761R.string.action_lock_comments);
        this.f21485h.setTitle(ModUtil.m23824a().getStickyState(link.getName(), link.isStickied()) != null ? C1761R.string.action_unsticky_post : C1761R.string.action_sticky_post);
        onModerateListener = this.f21481d;
        str = ModUtil.m23824a();
        onModerateListener.setTitle(str.getValue(str.f29392f, link.getName(), Boolean.valueOf(TextUtils.isEmpty(link.getLinkFlairText()))) != null ? C1761R.string.action_select_post_flair : C1761R.string.action_edit_post_flair);
        onModerateListener = SessionManager.b().c.getUsername();
        if (link.isApproved() != null && TextUtils.isEmpty(link.getApprovedBy()) == null && Util.m24017d(onModerateListener, link.getApprovedBy()) == null) {
            this.f21488k.setEnabled(false);
            this.f21488k.setTitle(Util.m23960a((int) C1761R.string.mod_approved_by, link.getApprovedBy()));
        } else if (ModUtil.m23824a().getApprovedState(link.getName(), link.isApproved()) != null && ModUtil.m23824a().getRemovedState(link.getName(), link.isRemoved()) == null && ModUtil.m23824a().m30459d(link.getName(), link.isSpam()) == null) {
            this.f21488k.setEnabled(false);
            this.f21488k.setTitle(Util.m24027f((int) C1761R.string.mod_approved));
        }
        if (ModUtil.m23824a().getRemovedState(link.getName(), link.isRemoved()) != null) {
            this.f21486i.setEnabled(false);
        }
        if (ModUtil.m23824a().m30459d(link.getName(), link.isSpam()) != null) {
            this.f21487j.setEnabled(false);
        }
        if (Util.m24017d(link.getAuthor(), SessionManager.b().c.getUsername()) == null) {
            this.f21489l.setVisible(false);
        } else if (ModUtil.m23824a().getDistinguishState(link.getName(), link.isDistinguished()) != null) {
            this.f21489l.setTitle(Util.m24027f((int) C1761R.string.action_undistinguish_as_mod));
        }
        if (link.getNumReports() <= null) {
            this.f21490m.setVisible(false);
        }
        if (!z) {
            this.f21481d.setVisible(false);
        }
        m23565a(iArr);
        this.f21478a = new Builder(context).m23278a(this.f21480c).m23277a(this.f21495r).f21081a;
    }

    public final void m23582a(OnModActionCompletedListener onModActionCompletedListener) {
        this.f21479b = onModActionCompletedListener;
    }

    public final void m23580a() {
        this.f21478a.m23284a();
    }

    static /* synthetic */ void m23564a(PopupPostModOptions popupPostModOptions, String str) {
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = popupPostModOptions.f21493p;
        b.f19955b = str;
        b.f19956c = popupPostModOptions.f21491n.getUrl();
        b.m21825a();
    }
}
