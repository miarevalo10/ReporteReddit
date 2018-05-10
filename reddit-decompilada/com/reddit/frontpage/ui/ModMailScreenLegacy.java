package com.reddit.frontpage.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.inbox.ModeratorInboxListingScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/ui/ModMailScreenLegacy;", "Lcom/reddit/frontpage/ui/inbox/ModeratorInboxListingScreen;", "()V", "keyColor", "", "(Ljava/lang/String;)V", "getKeyColor", "()Ljava/lang/String;", "setKeyColor", "getLayoutId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModMailScreenLegacy.kt */
public final class ModMailScreenLegacy extends ModeratorInboxListingScreen {
    public static final Companion f40601v = new Companion();
    @State
    public String keyColor;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/ModMailScreenLegacy$Companion;", "", "()V", "instance", "Lcom/reddit/frontpage/ui/ModMailScreenLegacy;", "keyColor", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModMailScreenLegacy.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ModMailScreenLegacy m23276a(String str) {
            Intrinsics.m26847b(str, "keyColor");
            return new ModMailScreenLegacy(str);
        }
    }

    public static final ModMailScreenLegacy m42151a(String str) {
        return Companion.m23276a(str);
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_inbox_listing_with_toolbar;
    }

    public ModMailScreenLegacy(String str) {
        Intrinsics.m26847b(str, "keyColor");
        this.keyColor = str;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Object am_;
        Intrinsics.m26847b(layoutInflater, "inflater");
        this.K = super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = this.keyColor;
        if (layoutInflater == null) {
            Intrinsics.m26844a("keyColor");
        }
        if ((((CharSequence) layoutInflater).length() == null ? true : null) != null) {
            am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(am_, "activity!!");
            layoutInflater = ResourcesUtil.m22740i((Context) am_, C1761R.attr.rdt_default_key_color);
        } else {
            layoutInflater = this.keyColor;
            if (layoutInflater == null) {
                Intrinsics.m26844a("keyColor");
            }
            layoutInflater = Color.parseColor(layoutInflater);
        }
        ((Toolbar) this.K.findViewById(C1761R.id.toolbar)).setBackgroundColor(layoutInflater);
        am_ = this.K.findViewById(C1761R.id.toolbar_title);
        Intrinsics.m26843a(am_, "rootView.findViewById<Te…View>(R.id.toolbar_title)");
        TextView textView = (TextView) am_;
        viewGroup = am_();
        textView.setText((CharSequence) (viewGroup != null ? viewGroup.getString(C1761R.string.mod_tools_mod_mail) : null));
        am_ = this.K;
        Intrinsics.m26843a(am_, "rootView");
        return am_;
    }
}
