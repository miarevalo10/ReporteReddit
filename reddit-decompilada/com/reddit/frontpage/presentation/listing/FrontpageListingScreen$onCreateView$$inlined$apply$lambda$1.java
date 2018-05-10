package com.reddit.frontpage.presentation.listing;

import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.FreshContentPill;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class FrontpageListingScreen$onCreateView$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FrontpageListingScreen f36519a;

    FrontpageListingScreen$onCreateView$$inlined$apply$lambda$1(FrontpageListingScreen frontpageListingScreen) {
        this.f36519a = frontpageListingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        View view = (View) obj;
        AppAnalytics.m21858b().m21826b(FreshContentPill.NAME).m21824a("front_page").m21825a();
        if (view == null) {
            Intrinsics.m26842a();
        }
        ViewsKt.m24109d(view);
        obj = this.f36519a.mo7641w();
        obj.f36636e.j("front_page");
        obj.f36634c.mo7627X();
        obj.m37066b();
        this.f36519a.mo7200K();
        return Unit.f25273a;
    }
}
