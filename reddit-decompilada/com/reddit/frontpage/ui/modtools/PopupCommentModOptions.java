package com.reddit.frontpage.ui.modtools;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.ui.alert.DialogMenu;
import com.reddit.frontpage.ui.alert.DialogMenu.Builder;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnModerateListener;
import timber.log.Timber;

public class PopupCommentModOptions {
    public final DialogMenu f21457a;
    public OnModActionCompletedListener f21458b;
    OnMenuItemClickListener f21459c = new C23561(this);
    private Menu f21460d;
    private MenuItem f21461e;
    private MenuItem f21462f;
    private MenuItem f21463g;
    private MenuItem f21464h;
    private MenuItem f21465i;
    private final Comment f21466j;
    private final OnModerateListener f21467k;
    private final ModCacheComments f21468l;
    private final String f21469m;

    class C23561 implements OnMenuItemClickListener {
        final /* synthetic */ PopupCommentModOptions f29170a;

        C23561(PopupCommentModOptions popupCommentModOptions) {
            this.f29170a = popupCommentModOptions;
        }

        public final boolean m30286a(MenuItem menuItem) {
            if (this.f29170a.f21467k == null) {
                Timber.e("Attempted action on moderator popup without any moderateListener", new Object[0]);
                return false;
            }
            menuItem = menuItem.getItemId();
            if (menuItem == this.f29170a.f21461e.getItemId()) {
                this.f29170a.f21468l.cacheStickyState(this.f29170a.f21466j.getName(), Boolean.valueOf(true));
                this.f29170a.f21468l.cacheDistinguishState(this.f29170a.f21466j.getName(), Boolean.valueOf(true));
                this.f29170a.f21467k.mo5038d(this.f29170a.f21466j, true);
                PopupCommentModOptions.m23551a(this.f29170a, "comment_mod_pin");
            } else if (menuItem == this.f29170a.f21462f.getItemId()) {
                this.f29170a.f21468l.cacheRemovedState(this.f29170a.f21466j.getName(), Boolean.valueOf(true));
                this.f29170a.f21468l.cacheStickyState(this.f29170a.f21466j.getName(), Boolean.valueOf(false));
                this.f29170a.f21467k.mo5031a(this.f29170a.f21466j);
                PopupCommentModOptions.m23551a(this.f29170a, "comment_mod_remove");
            } else if (menuItem == this.f29170a.f21463g.getItemId()) {
                this.f29170a.f21468l.cacheRemovedState(this.f29170a.f21466j.getName(), Boolean.valueOf(true));
                this.f29170a.f21468l.cacheStickyState(this.f29170a.f21466j.getName(), Boolean.valueOf(false));
                this.f29170a.f21467k.mo5034b(this.f29170a.f21466j);
                PopupCommentModOptions.m23551a(this.f29170a, "comment_mod_remove_as_spam");
            } else if (menuItem == this.f29170a.f21464h.getItemId()) {
                this.f29170a.f21468l.cacheApprovedState(this.f29170a.f21466j.getName(), Boolean.valueOf(true));
                this.f29170a.f21467k.mo5036c(this.f29170a.f21466j);
                PopupCommentModOptions.m23551a(this.f29170a, "comment_mod_approve");
            } else if (menuItem == this.f29170a.f21465i.getItemId()) {
                menuItem = this.f29170a.f21468l.getDistinguishState(this.f29170a.f21466j.getName(), this.f29170a.f21466j.l()) ^ 1;
                this.f29170a.f21468l.cacheDistinguishState(this.f29170a.f21466j.getName(), Boolean.valueOf(menuItem));
                this.f29170a.f21467k.mo5039e(this.f29170a.f21466j, menuItem);
                if (menuItem == null) {
                    this.f29170a.f21468l.cacheStickyState(this.f29170a.f21466j.getName(), Boolean.valueOf(false));
                    PopupCommentModOptions.m23551a(this.f29170a, "comment_undistinguish");
                } else {
                    PopupCommentModOptions.m23551a(this.f29170a, "comment_distinguish");
                }
            }
            if (this.f29170a.f21458b != null) {
                this.f29170a.f21458b.mo4891a();
            }
            return true;
        }
    }

    public PopupCommentModOptions(Context context, Comment comment, OnModerateListener onModerateListener, String str) {
        this.f21460d = new PopupMenu(context, null).a;
        new MenuInflater(context).inflate(C1761R.menu.menu_comment_mod_options, this.f21460d);
        this.f21461e = this.f21460d.findItem(C1761R.id.action_sticky_comment);
        this.f21462f = this.f21460d.findItem(C1761R.id.action_remove_comment);
        this.f21463g = this.f21460d.findItem(C1761R.id.action_remove_spam);
        this.f21464h = this.f21460d.findItem(C1761R.id.action_approve_comment);
        this.f21465i = this.f21460d.findItem(C1761R.id.action_distinguish);
        this.f21466j = comment;
        this.f21467k = onModerateListener;
        this.f21468l = ModUtil.m23823a(comment.link_id);
        this.f21469m = str;
        if (this.f21468l.getApprovedState(comment.getName(), comment.approved) != null) {
            if (TextUtils.isEmpty(comment.approved_by) == null) {
                onModerateListener = Util.m23960a((int) C1761R.string.mod_approved_by, comment.approved_by);
            } else {
                onModerateListener = Util.m24027f((int) C1761R.string.mod_approved);
            }
            this.f21464h.setEnabled(false);
            this.f21464h.setTitle(onModerateListener);
        } else {
            this.f21464h.setEnabled(true);
            this.f21464h.setTitle(Util.m24027f((int) C1761R.string.action_approve_comment));
        }
        if (this.f21468l.getRemovedState(comment.getName(), comment.removed) != null) {
            this.f21462f.setEnabled(false);
            this.f21463g.setEnabled(false);
        }
        if (Util.m24017d(comment.c(), SessionManager.b().c.getUsername()) != null) {
            if (this.f21468l.getDistinguishState(comment.getName(), comment.l()) != null) {
                this.f21465i.setTitle(Util.m24027f((int) C1761R.string.action_undistinguish_as_mod));
            } else {
                this.f21465i.setTitle(Util.m24027f((int) C1761R.string.action_distinguish_as_mod));
            }
            if (this.f21468l.getStickyState(comment.getName(), comment.stickied) != null) {
                this.f21461e.setVisible(false);
            } else {
                this.f21461e.setVisible(true);
            }
        } else {
            this.f21465i.setVisible(false);
            this.f21461e.setVisible(false);
        }
        this.f21457a = new Builder(context).m23278a(this.f21460d).m23277a(this.f21459c).f21081a;
    }

    static /* synthetic */ void m23551a(PopupCommentModOptions popupCommentModOptions, String str) {
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = popupCommentModOptions.f21469m;
        b.f19955b = str;
        b.f19956c = popupCommentModOptions.f21466j.link_url;
        b.m21825a();
    }
}
