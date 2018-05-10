package com.reddit.frontpage.presentation.listing.submitted;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen$Adapter;", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$adapter$2 extends Lambda implements Function0<Adapter> {
    final /* synthetic */ UserSubmittedListingScreen f36762a;

    UserSubmittedListingScreen$adapter$2(UserSubmittedListingScreen userSubmittedListingScreen) {
        this.f36762a = userSubmittedListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        UserSubmittedListingScreen userSubmittedListingScreen = this.f36762a;
        Object am_ = this.f36762a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Adapter adapter = new Adapter(userSubmittedListingScreen, (Context) am_);
        adapter.a(true);
        return adapter;
    }
}
