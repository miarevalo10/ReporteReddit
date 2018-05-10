package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopularListingScreen.kt */
final class PopularListingScreen$onCreateView$1 extends FunctionReference implements Function0<Unit> {
    PopularListingScreen$onCreateView$1(PopularListingPresenter popularListingPresenter) {
        super(0, popularListingPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(PopularListingPresenter.class);
    }

    public final String mo5687b() {
        return "loadMore";
    }

    public final String mo6932c() {
        return "loadMore()V";
    }

    public final /* synthetic */ Object invoke() {
        PopularListingPresenter popularListingPresenter = (PopularListingPresenter) this.b;
        if (!(popularListingPresenter.f36713c == null || popularListingPresenter.f36715e)) {
            popularListingPresenter.f36715e = true;
            PopularListingPresenter.m37158a(popularListingPresenter, popularListingPresenter.f36711a, popularListingPresenter.f36712b, false, popularListingPresenter.f36713c, popularListingPresenter.f36714d, false, new PopularListingPresenter$loadMore$1(popularListingPresenter), 32);
        }
        return Unit.f25273a;
    }
}
