package com.reddit.frontpage.presentation.listing.submitted;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$onCreateView$1$2 extends FunctionReference implements Function0<Unit> {
    UserSubmittedListingScreen$onCreateView$1$2(UserSubmittedListingPresenter userSubmittedListingPresenter) {
        super(0, userSubmittedListingPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(UserSubmittedListingPresenter.class);
    }

    public final String mo5687b() {
        return "loadMore";
    }

    public final String mo6932c() {
        return "loadMore()V";
    }

    public final /* synthetic */ Object invoke() {
        ((UserSubmittedListingPresenter) this.b).m37193a();
        return Unit.f25273a;
    }
}
