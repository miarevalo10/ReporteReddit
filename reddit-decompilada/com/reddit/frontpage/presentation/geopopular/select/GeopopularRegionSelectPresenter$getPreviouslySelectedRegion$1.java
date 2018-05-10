package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;", "<name for destructuring parameter 0>", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$getPreviouslySelectedRegion$1<T, R> implements Function<T, R> {
    public static final GeopopularRegionSelectPresenter$getPreviouslySelectedRegion$1 f28245a = new GeopopularRegionSelectPresenter$getPreviouslySelectedRegion$1();

    GeopopularRegionSelectPresenter$getPreviouslySelectedRegion$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) obj;
        Intrinsics.m26847b(geopopularRegionSelectFilter, "<name for destructuring parameter 0>");
        obj = geopopularRegionSelectFilter.f20534a;
        List a = StringsKt__StringsKt.m42449a((CharSequence) obj, new char[]{'_'});
        return new PreviousRegionSelection(obj, (String) (CollectionsKt__CollectionsKt.m26787a(a) >= 0 ? a.get(0) : ""), (String) (1 <= CollectionsKt__CollectionsKt.m26787a(a) ? a.get(1) : ""), a.subList(1, a.size()));
    }
}
