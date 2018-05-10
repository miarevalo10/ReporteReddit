package com.reddit.frontpage.presentation.listing.ui.view;

import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.util.ModUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "onMenuItemClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopupPostModOptions.kt */
final class PopupPostModOptions$clickListener$1 implements OnMenuItemClickListener {
    final /* synthetic */ PopupPostModOptions f28501a;

    PopupPostModOptions$clickListener$1(PopupPostModOptions popupPostModOptions) {
        this.f28501a = popupPostModOptions;
    }

    public final boolean m29721a(MenuItem menuItem) {
        menuItem = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int itemId = PopupPostModOptions.m23027a(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                menuItem = ModUtil.m23824a().m30453a(this.f28501a.f20804o.getName(), this.f28501a.f20804o.f33950C) ^ 1;
                ModUtil.m23824a().m30452a(this.f28501a.f20804o.getName(), Boolean.valueOf(menuItem));
                this.f28501a.f20805p.mo4831a();
                AppAnalytics.m21858b().m21824a(this.f28501a.f20806q).m21826b(menuItem != null ? "post_mark_nsfw" : "post_unmark_nsfw").m21827c(this.f28501a.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23031d(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                menuItem = ModUtil.m23824a().m30455b(this.f28501a.f20804o.getName(), this.f28501a.f20804o.f33953F) ^ 1;
                ModUtil.m23824a().m30454b(this.f28501a.f20804o.getName(), Boolean.valueOf(menuItem));
                this.f28501a.f20805p.mo4832b();
                AppAnalytics.m21858b().m21824a(this.f28501a.f20806q).m21826b(menuItem != null ? "post_mark_spoiler" : "post_unmark_spoiler").m21827c(this.f28501a.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23032e(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                menuItem = ModUtil.m23824a().m30457c(this.f28501a.f20804o.getName(), this.f28501a.f20804o.f33995v) ^ 1;
                ModUtil.m23824a().m30456c(this.f28501a.f20804o.getName(), Boolean.valueOf(menuItem));
                this.f28501a.f20805p.mo4833c();
                AppAnalytics.m21858b().m21824a(this.f28501a.f20806q).m21826b(menuItem != null ? "post_mod_lock" : "post_mod_unlock").m21827c(this.f28501a.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23033f(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                menuItem = ModUtil.m23824a().getStickyState(this.f28501a.f20804o.getName(), this.f28501a.f20804o.f33992s) ^ 1;
                ModUtil.m23824a().cacheStickyState(this.f28501a.f20804o.getName(), Boolean.valueOf(menuItem));
                this.f28501a.f20805p.mo4834d();
                AppAnalytics.m21858b().m21824a(this.f28501a.f20806q).m21826b(menuItem != null ? "post_mod_pin" : "post_mod_unpin").m21827c(this.f28501a.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23034g(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                ModUtil.m23824a().cacheRemovedState(this.f28501a.f20804o.getName(), Boolean.valueOf(true));
                this.f28501a.f20805p.mo4835e();
                menuItem = this.f28501a;
                String str = "post_mod_remove";
                AppAnalytics.m21858b().m21824a(menuItem.f20806q).m21826b(str).m21827c(menuItem.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23035h(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                ModUtil.m23824a().m30458d(this.f28501a.f20804o.getName(), Boolean.valueOf(true));
                this.f28501a.f20805p.mo4836f();
                menuItem = this.f28501a;
                str = "post_mod_remove_spam";
                AppAnalytics.m21858b().m21824a(menuItem.f20806q).m21826b(str).m21827c(menuItem.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23036i(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                ModUtil.m23824a().cacheApprovedState(this.f28501a.f20804o.getName(), Boolean.valueOf(true));
                this.f28501a.f20805p.mo4837g();
                menuItem = this.f28501a;
                str = "post_mod_approve";
                AppAnalytics.m21858b().m21824a(menuItem.f20806q).m21826b(str).m21827c(menuItem.f20804o.ad).m21825a();
                menuItem = this.f28501a.f20791b;
                if (menuItem != null) {
                    menuItem.mo4904a();
                }
                return null;
            }
        }
        itemId = PopupPostModOptions.m23037j(this.f28501a).getItemId();
        if (menuItem != null) {
            if (menuItem.intValue() == itemId) {
                menuItem = ModUtil.m23824a().getDistinguishState(this.f28501a.f20804o.getName(), this.f28501a.f20804o.m34744a()) ^ 1;
                ModUtil.m23824a().cacheDistinguishState(this.f28501a.f20804o.getName(), Boolean.valueOf(menuItem));
                this.f28501a.f20805p.mo4838h();
                PopupPostModOptions popupPostModOptions = this.f28501a;
                str = menuItem != null ? "post_distinguish" : "post_undistinguish";
                menuItem = popupPostModOptions;
                AppAnalytics.m21858b().m21824a(menuItem.f20806q).m21826b(str).m21827c(menuItem.f20804o.ad).m21825a();
            }
        }
        menuItem = this.f28501a.f20791b;
        if (menuItem != null) {
            menuItem.mo4904a();
        }
        return null;
    }
}
