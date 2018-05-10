package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingPresenter.kt */
final class UserSubmittedListingPresenter$isLoggedInUser$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ UserSubmittedListingPresenter f36733a;

    UserSubmittedListingPresenter$isLoggedInUser$2(UserSubmittedListingPresenter userSubmittedListingPresenter) {
        this.f36733a = userSubmittedListingPresenter;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        Session c = b.c();
        boolean z = !c.isAnonymous() && Intrinsics.m26845a(c.getUsername(), this.f36733a.f36739e.mo7368a());
        return Boolean.valueOf(z);
    }
}
