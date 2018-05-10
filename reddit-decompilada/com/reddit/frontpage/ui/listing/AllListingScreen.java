package com.reddit.frontpage.ui.listing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import org.parceler.Parcel;

public class AllListingScreen extends SubscribeListingScreen {

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        DeepLinker() {
        }

        public Screen createScreen() {
            return AllListingScreen.m42510w();
        }
    }

    public final String mo7451T() {
        return "all";
    }

    protected final String mo7453V() {
        return "all";
    }

    public String getAnalyticsPageType() {
        return "all";
    }

    public String getAnalyticsScreenName() {
        return "all";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_all_listing;
    }

    public static AllListingScreen m42510w() {
        return new AllListingScreen();
    }

    public static ScreenDeepLinker m42509S() {
        return new DeepLinker();
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        n();
        ((TextView) this.K.findViewById(C1761R.id.toolbar_title)).setText(C1761R.string.title_all);
        return this.K;
    }

    public final LinkListingProvider mo7452U() {
        return ProviderManager.a(this.l, "all");
    }
}
