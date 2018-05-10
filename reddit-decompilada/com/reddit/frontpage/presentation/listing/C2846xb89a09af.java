package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u001b\u0010\u0007\u001a\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "listablePosition", "p2", "", "", "idsSeen", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class C2846xb89a09af extends FunctionReference implements Function2<Integer, Set<? extends String>, Unit> {
    C2846xb89a09af(FrontpageListingPresenter frontpageListingPresenter) {
        super(2, frontpageListingPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(FrontpageListingPresenter.class);
    }

    public final String mo5687b() {
        return "onCarouselImpression";
    }

    public final String mo6932c() {
        return "onCarouselImpression(ILjava/util/Set;)V";
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        Set set = (Set) obj2;
        Intrinsics.m26847b(set, "p2");
        ((FrontpageListingPresenter) this.b).m37063a(intValue, set);
        return Unit.f25273a;
    }
}
