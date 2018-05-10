package com.reddit.frontpage.presentation.geopopular.select;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularFilteredMappingResult;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularMappingResult;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class C2302x403d12da<T, R> implements Function<T, R> {
    final /* synthetic */ GeopopularRegionSelectPresenter f28244a;

    C2302x403d12da(GeopopularRegionSelectPresenter geopopularRegionSelectPresenter) {
        this.f28244a = geopopularRegionSelectPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "<name for destructuring parameter 0>");
        String str = (String) pair.f25267a;
        GeopopularMappingResult geopopularMappingResult = (GeopopularMappingResult) pair.f25268b;
        List arrayList = new ArrayList();
        this.f28244a.m34685a(str, geopopularMappingResult.f20548a, arrayList, geopopularMappingResult.f20549b);
        return new GeopopularFilteredMappingResult(arrayList, geopopularMappingResult.f20550c);
    }
}
