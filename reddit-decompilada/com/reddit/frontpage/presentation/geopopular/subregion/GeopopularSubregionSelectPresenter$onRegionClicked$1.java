package com.reddit.frontpage.presentation.geopopular.subregion;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularSubregionSelectPresenter.kt */
final class GeopopularSubregionSelectPresenter$onRegionClicked$1 implements Action {
    final /* synthetic */ GeopopularSubregionSelectPresenter f28262a;
    final /* synthetic */ GeopopularRegionSelectFilter f28263b;

    GeopopularSubregionSelectPresenter$onRegionClicked$1(GeopopularSubregionSelectPresenter geopopularSubregionSelectPresenter, GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        this.f28262a = geopopularSubregionSelectPresenter;
        this.f28263b = geopopularRegionSelectFilter;
    }

    public final void run() {
        this.f28262a.f33875b.mo7355a(this.f28263b);
    }
}
