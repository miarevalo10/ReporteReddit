package com.reddit.frontpage.presentation.listing.submitted;

import android.support.v7.widget.LinearLayoutManager;
import com.reddit.frontpage.ui.layout.SmoothScrollingLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$layoutManager$2 extends Lambda implements Function0<LinearLayoutManager> {
    final /* synthetic */ UserSubmittedListingScreen f36766a;

    UserSubmittedListingScreen$layoutManager$2(UserSubmittedListingScreen userSubmittedListingScreen) {
        this.f36766a = userSubmittedListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return SmoothScrollingLinearLayoutManager.m35006a(this.f36766a.am_(), this.f36766a.f40070O);
    }
}
