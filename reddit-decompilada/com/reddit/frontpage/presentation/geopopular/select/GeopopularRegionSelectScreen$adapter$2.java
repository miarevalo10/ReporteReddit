package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularRegionAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectScreen.kt */
final class GeopopularRegionSelectScreen$adapter$2 extends Lambda implements Function0<GeopopularRegionAdapter> {
    final /* synthetic */ GeopopularRegionSelectScreen f36468a;

    GeopopularRegionSelectScreen$adapter$2(GeopopularRegionSelectScreen geopopularRegionSelectScreen) {
        this.f36468a = geopopularRegionSelectScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new GeopopularRegionAdapter(new Function1<GeopopularRegionPresentationModel, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                GeopopularRegionPresentationModel geopopularRegionPresentationModel = (GeopopularRegionPresentationModel) obj;
                Intrinsics.m26847b(geopopularRegionPresentationModel, "it");
                this.f36468a.m40604w().m34689a(geopopularRegionPresentationModel);
                return Unit.f25273a;
            }
        });
    }
}
