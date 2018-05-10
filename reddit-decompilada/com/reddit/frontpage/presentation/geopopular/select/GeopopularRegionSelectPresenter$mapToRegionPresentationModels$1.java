package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel.Companion;
import io.reactivex.functions.Function;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularMappingResult;", "<name for destructuring parameter 0>", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$RegionsLoadResult;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$mapToRegionPresentationModels$1<T, R> implements Function<T, R> {
    public static final GeopopularRegionSelectPresenter$mapToRegionPresentationModels$1 f28246a = new GeopopularRegionSelectPresenter$mapToRegionPresentationModels$1();

    GeopopularRegionSelectPresenter$mapToRegionPresentationModels$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        RegionsLoadResult regionsLoadResult = (RegionsLoadResult) obj;
        Intrinsics.m26847b(regionsLoadResult, "<name for destructuring parameter 0>");
        PreviousRegionSelection previousRegionSelection = regionsLoadResult.f20555a;
        List list = regionsLoadResult.f20556b;
        obj = previousRegionSelection.f20551a;
        String str = previousRegionSelection.f20552b;
        String str2 = previousRegionSelection.f20553c;
        List list2 = previousRegionSelection.f20554d;
        Companion companion = GeopopularRegionPresentationModel.f20537f;
        List<GeopopularRegionPresentationModel> a = CollectionsKt___CollectionsKt.m41418a((Iterable) Companion.m22847a(list, null, str, str2, false, 18), (Comparator) new C1816xee79f9cb());
        int i = 0;
        for (GeopopularRegionPresentationModel geopopularRegionPresentationModel : a) {
            if (Intrinsics.m26845a(geopopularRegionPresentationModel.f20538a.getName(), (Object) "United States")) {
                break;
            }
            i++;
        }
        i = -1;
        list = CollectionsKt___CollectionsKt.m41428c(a);
        list.add(0, list.remove(i));
        return new GeopopularMappingResult(list, obj, list2);
    }
}
