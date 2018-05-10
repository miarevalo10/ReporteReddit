package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditLinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import kotlin.jvm.internal.Intrinsics;

public class MultiredditListingScreen extends BaseLinkListingScreen {
    private String f40161v;

    public String getAnalyticsScreenName() {
        return "multireddit";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_all_listing;
    }

    public static MultiredditListingScreen m41013a(String str) {
        return new MultiredditListingScreen(str);
    }

    public MultiredditListingScreen(Bundle bundle) {
        super(bundle);
    }

    protected final void mo7142t() {
        super.mo7142t();
        this.f40161v = this.a.getString("args.multireddit_name");
    }

    public final String mo7451T() {
        return this.f40161v;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        ((TextView) this.K.findViewById(C1761R.id.toolbar_title)).setText(this.f40161v);
        n();
        return this.K;
    }

    public final LinkListingProvider mo7452U() {
        ProviderManager providerManager = ProviderManager.b;
        String str = this.l;
        String str2 = this.f40161v;
        Intrinsics.m26847b(str, "ownerId");
        Intrinsics.m26847b(str2, "multireddit");
        BaseOtherProvider baseOtherProvider = (BaseOtherProvider) ProviderManager.b().get(str);
        if (baseOtherProvider == null) {
            baseOtherProvider = new MultiredditLinkListingProvider(str, str2);
            ProviderManager.b().put(str, baseOtherProvider);
        }
        return (MultiredditLinkListingProvider) baseOtherProvider;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(ResourcesUtil.m22734f(am_(), (int) C1761R.drawable.ic_icon_back));
    }

    public final void mo7454a(Menu menu, MenuInflater menuInflater) {
        super.mo7454a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_link_listing_multireddit, menu);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1761R.id.action_communities) {
            Routing.m22623a((Screen) this, Nav.m22585g(this.f40161v));
            return true;
        } else if (itemId != C1761R.id.action_search) {
            return super.mo7201a(menuItem);
        } else {
            Routing.m22623a((Screen) this, Nav.m22562a(this.f40161v, true));
            return true;
        }
    }

    protected final String mo7453V() {
        return this.f40161v;
    }

    private MultiredditListingScreen(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("args.multireddit_name", str);
        this(bundle);
    }
}
