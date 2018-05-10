package com.reddit.frontpage.presentation.geopopular.subregion;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularSubregionSelectScreen.kt */
final class GeopopularSubregionSelectScreen$adapter$2 extends Lambda implements Function0<GeopopularRegionAdapter> {
    final /* synthetic */ GeopopularSubregionSelectScreen f36476a;

    GeopopularSubregionSelectScreen$adapter$2(GeopopularSubregionSelectScreen geopopularSubregionSelectScreen) {
        this.f36476a = geopopularSubregionSelectScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new GeopopularRegionAdapter(new Function1<GeopopularRegionPresentationModel, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                GeopopularRegionPresentationModel geopopularRegionPresentationModel = (GeopopularRegionPresentationModel) obj;
                Intrinsics.m26847b(geopopularRegionPresentationModel, "it");
                this.f36476a.m40616w().m34693a(geopopularRegionPresentationModel);
                return Unit.f25273a;
            }
        }, new Function0<Unit>() {
            public final /* synthetic */ Object invoke() {
                GeopopularSubregionSelectPresenter w = this.f36476a.m40616w();
                w.f33875b.mo7355a(new GeopopularRegionSelectFilter(w.f33875b.mo7354a().getGeoFilter(), w.f33875b.mo7354a().getName()));
                return Unit.f25273a;
            }
        }, this.f36476a.f40030z);
    }
}
