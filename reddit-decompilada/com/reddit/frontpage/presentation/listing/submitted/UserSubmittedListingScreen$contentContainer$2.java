package com.reddit.frontpage.presentation.listing.submitted;

import android.view.View;
import android.widget.FrameLayout;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$contentContainer$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ UserSubmittedListingScreen f36763a;

    UserSubmittedListingScreen$contentContainer$2(UserSubmittedListingScreen userSubmittedListingScreen) {
        this.f36763a = userSubmittedListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View d = this.f36763a.K;
        if (d == null) {
            Intrinsics.m26842a();
        }
        d = d.findViewById(C1761R.id.content_container);
        if (d != null) {
            return (FrameLayout) d;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
}
