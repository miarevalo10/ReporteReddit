package com.reddit.frontpage.ui.listing;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.provider.LocationPermissionRequestProvider;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionsScreen;
import com.reddit.frontpage.ui.BaseScreen;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LegacyPopularListingScreen.kt */
final class LegacyPopularListingScreen$onCreateView$$inlined$let$lambda$2 implements OnClickListener {
    final /* synthetic */ LegacyPopularListingScreen f21297a;

    LegacyPopularListingScreen$onCreateView$$inlined$let$lambda$2(LegacyPopularListingScreen legacyPopularListingScreen) {
        this.f21297a = legacyPopularListingScreen;
    }

    public final void onClick(View view) {
        Activity am_ = this.f21297a.am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
        }
        view = new GeopopularOptionsScreen(am_);
        view.m38951a((BaseScreen) this.f21297a);
        view.m38949a((LocationPermissionRequestProvider) this.f21297a);
        view.show();
    }
}
