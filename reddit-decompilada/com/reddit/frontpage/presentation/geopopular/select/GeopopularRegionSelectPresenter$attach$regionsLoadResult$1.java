package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.domain.model.Region;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$RegionsLoadResult;", "previousSelection", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$PreviousRegionSelection;", "regions", "", "Lcom/reddit/frontpage/domain/model/Region;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$attach$regionsLoadResult$1<T1, T2, R> implements BiFunction<PreviousRegionSelection, List<? extends Region>, RegionsLoadResult> {
    public static final GeopopularRegionSelectPresenter$attach$regionsLoadResult$1 f28243a = new GeopopularRegionSelectPresenter$attach$regionsLoadResult$1();

    GeopopularRegionSelectPresenter$attach$regionsLoadResult$1() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        PreviousRegionSelection previousRegionSelection = (PreviousRegionSelection) obj;
        List list = (List) obj2;
        Intrinsics.m26847b(previousRegionSelection, "previousSelection");
        Intrinsics.m26847b(list, "regions");
        return new RegionsLoadResult(previousRegionSelection, list);
    }
}
