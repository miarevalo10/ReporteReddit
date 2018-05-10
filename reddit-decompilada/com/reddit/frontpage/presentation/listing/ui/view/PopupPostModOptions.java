package com.reddit.frontpage.presentation.listing.ui.view;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.presentation.listing.ui.view.LinkFooterView.OnModerateListener;
import com.reddit.frontpage.ui.alert.DialogMenu;
import com.reddit.frontpage.ui.alert.DialogMenu.Builder;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\tH\u0002J\u000e\u0010#\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010$\u001a\u00020 R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/PopupPostModOptions;", "", "anchorView", "Landroid/view/View;", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "moderateListener", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModerateListener;", "screenName", "", "(Landroid/view/View;Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModerateListener;Ljava/lang/String;)V", "actionCompletedListener", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModActionCompletedListener;", "approvePostItem", "Landroid/view/MenuItem;", "clickListener", "Landroid/support/v7/widget/PopupMenu$OnMenuItemClickListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "distinguishPostItem", "lockCommentsItem", "markNsfwItem", "markSpoilerItem", "menu", "Landroid/view/Menu;", "popupMenu", "Lcom/reddit/frontpage/ui/alert/DialogMenu;", "removePostItem", "removeSpamItem", "stickyPostItem", "inflatePrepare", "", "sendClickEvent", "controlName", "setActionCompletedListener", "show", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PopupPostModOptions.kt */
public final class PopupPostModOptions {
    DialogMenu f20790a;
    OnModActionCompletedListener f20791b;
    private final Context f20792c = this.f20803n.getContext();
    private Menu f20793d;
    private MenuItem f20794e;
    private MenuItem f20795f;
    private MenuItem f20796g;
    private MenuItem f20797h;
    private MenuItem f20798i;
    private MenuItem f20799j;
    private MenuItem f20800k;
    private MenuItem f20801l;
    private final OnMenuItemClickListener f20802m = ((OnMenuItemClickListener) new PopupPostModOptions$clickListener$1(this));
    private final View f20803n;
    private final LinkPresentationModel f20804o;
    private final OnModerateListener f20805p;
    private final String f20806q;

    public PopupPostModOptions(View view, LinkPresentationModel linkPresentationModel, OnModerateListener onModerateListener, String str) {
        Intrinsics.m26847b(view, "anchorView");
        Intrinsics.m26847b(linkPresentationModel, "link");
        Intrinsics.m26847b(onModerateListener, "moderateListener");
        Intrinsics.m26847b(str, "screenName");
        this.f20803n = view;
        this.f20804o = linkPresentationModel;
        this.f20805p = onModerateListener;
        this.f20806q = str;
        Object obj = this.f20792c;
        Intrinsics.m26843a(obj, "context");
        Object a = new PopupMenu(obj, this.f20803n).a();
        Intrinsics.m26843a(a, "PopupMenu(context, anchorView).menu");
        this.f20793d = a;
        linkPresentationModel = new MenuInflater(obj);
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        linkPresentationModel.inflate(C1761R.menu.menu_link_mod_options, view);
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_mark_nsfw);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_mark_nsfw)");
        this.f20794e = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_mark_spoiler);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_mark_spoiler)");
        this.f20795f = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_lock_comments);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_lock_comments)");
        this.f20796g = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_sticky_announcement);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_sticky_announcement)");
        this.f20797h = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_remove_post);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_remove_post)");
        this.f20798i = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_remove_spam);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_remove_spam)");
        this.f20799j = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_approve_post);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_approve_post)");
        this.f20800k = obj;
        view = this.f20793d;
        if (view == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.findItem(C1761R.id.action_distinguish);
        Intrinsics.m26843a(obj, "menu.findItem(R.id.action_distinguish)");
        this.f20801l = obj;
        view = this.f20794e;
        if (view == null) {
            Intrinsics.m26844a("markNsfwItem");
        }
        view.setTitle(ModUtil.m23824a().m30453a(this.f20804o.getName(), this.f20804o.f33950C) != null ? C1761R.string.action_unmark_nsfw : C1761R.string.action_mark_nsfw);
        view = this.f20795f;
        if (view == null) {
            Intrinsics.m26844a("markSpoilerItem");
        }
        view.setTitle(ModUtil.m23824a().m30455b(this.f20804o.getName(), this.f20804o.f33953F) != null ? C1761R.string.action_unmark_spoiler : C1761R.string.action_mark_spoiler);
        view = this.f20796g;
        if (view == null) {
            Intrinsics.m26844a("lockCommentsItem");
        }
        view.setTitle(ModUtil.m23824a().m30457c(this.f20804o.getName(), this.f20804o.f33995v) != null ? C1761R.string.action_unlock_comments : C1761R.string.action_lock_comments);
        view = this.f20797h;
        if (view == null) {
            Intrinsics.m26844a("stickyPostItem");
        }
        view.setTitle(ModUtil.m23824a().getStickyState(this.f20804o.getName(), this.f20804o.f33992s) != null ? C1761R.string.action_unsticky_post : C1761R.string.action_sticky_post);
        obj = SessionManager.b();
        Intrinsics.m26843a(obj, "SessionManager.getInstance()");
        view = obj.c().getUsername();
        if (this.f20804o.f33996w != null && TextUtils.isEmpty((CharSequence) this.f20804o.f33997x) == null && Util.m24017d(view, this.f20804o.f33997x) == null) {
            view = this.f20800k;
            if (view == null) {
                Intrinsics.m26844a("approvePostItem");
            }
            view.setEnabled(false);
            view.setTitle(Util.m23960a((int) C1761R.string.mod_approved_by, this.f20804o.f33997x));
        } else if (ModUtil.m23824a().getApprovedState(this.f20804o.getName(), this.f20804o.f33996w) != null && ModUtil.m23824a().getRemovedState(this.f20804o.getName(), this.f20804o.ab) == null && ModUtil.m23824a().m30459d(this.f20804o.getName(), this.f20804o.ac) == null) {
            view = this.f20800k;
            if (view == null) {
                Intrinsics.m26844a("approvePostItem");
            }
            view.setEnabled(false);
            view.setTitle(Util.m24027f((int) C1761R.string.mod_approved));
        }
        if (!(ModUtil.m23824a().getRemovedState(this.f20804o.getName(), this.f20804o.ab) == null && ModUtil.m23824a().m30459d(this.f20804o.getName(), this.f20804o.ac) == null)) {
            view = this.f20798i;
            if (view == null) {
                Intrinsics.m26844a("removePostItem");
            }
            view.setEnabled(false);
            view = this.f20799j;
            if (view == null) {
                Intrinsics.m26844a("removeSpamItem");
            }
            view.setEnabled(false);
        }
        obj = SessionManager.b();
        Intrinsics.m26843a(obj, "SessionManager.getInstance()");
        if (Util.m24017d(this.f20804o.f33985l, obj.c().getUsername()) != null) {
            if (ModUtil.m23824a().getDistinguishState(this.f20804o.getName(), this.f20804o.m34744a()) != null) {
                view = this.f20801l;
                if (view == null) {
                    Intrinsics.m26844a("distinguishPostItem");
                }
                view.setTitle(Util.m24027f((int) C1761R.string.action_undistinguish_as_mod));
            } else {
                view = this.f20801l;
                if (view == null) {
                    Intrinsics.m26844a("distinguishPostItem");
                }
                view.setVisible(false);
            }
        }
        view = new Builder(this.f20792c);
        Menu menu = this.f20793d;
        if (menu == null) {
            Intrinsics.m26844a("menu");
        }
        obj = view.m23278a(menu).m23277a(this.f20802m).m23279a();
        Intrinsics.m26843a(obj, "DialogMenu.Builder(conte…istener)\n        .build()");
        this.f20790a = obj;
    }

    public static final /* synthetic */ MenuItem m23027a(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20794e;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("markNsfwItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23031d(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20795f;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("markSpoilerItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23032e(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20796g;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("lockCommentsItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23033f(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20797h;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("stickyPostItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23034g(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20798i;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("removePostItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23035h(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20799j;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("removeSpamItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23036i(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20800k;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("approvePostItem");
        }
        return popupPostModOptions;
    }

    public static final /* synthetic */ MenuItem m23037j(PopupPostModOptions popupPostModOptions) {
        popupPostModOptions = popupPostModOptions.f20801l;
        if (popupPostModOptions == null) {
            Intrinsics.m26844a("distinguishPostItem");
        }
        return popupPostModOptions;
    }
}
