package com.reddit.frontpage.presentation.listing.submitted;

import android.view.View;
import android.view.ViewStub;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/ViewStub;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$errorContatiner$2 extends Lambda implements Function0<ViewStub> {
    final /* synthetic */ UserSubmittedListingScreen f36765a;

    UserSubmittedListingScreen$errorContatiner$2(UserSubmittedListingScreen userSubmittedListingScreen) {
        this.f36765a = userSubmittedListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View d = this.f36765a.K;
        if (d == null) {
            Intrinsics.m26842a();
        }
        return (ViewStub) d.findViewById(C1761R.id.error_container_stub);
    }
}
