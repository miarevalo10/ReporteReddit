package com.reddit.frontpage.presentation.geopopular.select;

import android.app.Activity;
import com.reddit.frontpage.presentation.geopopular.ActionBarProvider;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/ActionBarProvider;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectScreen.kt */
final class GeopopularRegionSelectScreen$actionBarProvider$2 extends Lambda implements Function0<ActionBarProvider> {
    final /* synthetic */ GeopopularRegionSelectScreen f36466a;

    GeopopularRegionSelectScreen$actionBarProvider$2(GeopopularRegionSelectScreen geopopularRegionSelectScreen) {
        this.f36466a = geopopularRegionSelectScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Activity am_ = this.f36466a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        if (am_ != null) {
            return (ActionBarProvider) am_;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.geopopular.ActionBarProvider");
    }
}
