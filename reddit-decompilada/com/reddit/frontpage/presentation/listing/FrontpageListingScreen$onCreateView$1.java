package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class FrontpageListingScreen$onCreateView$1 extends FunctionReference implements Function0<Unit> {
    FrontpageListingScreen$onCreateView$1(FrontpageListingPresenter frontpageListingPresenter) {
        super(0, frontpageListingPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(FrontpageListingPresenter.class);
    }

    public final String mo5687b() {
        return "loadMore";
    }

    public final String mo6932c() {
        return "loadMore()V";
    }

    public final /* synthetic */ Object invoke() {
        ((FrontpageListingPresenter) this.b).m37059a();
        return Unit.f25273a;
    }
}
