package com.reddit.frontpage.presentation.geopopular.select;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$saveRegionAndNotifyView$1 implements Action {
    final /* synthetic */ GeopopularRegionSelectPresenter f28249a;
    final /* synthetic */ GeopopularRegionSelectFilter f28250b;

    GeopopularRegionSelectPresenter$saveRegionAndNotifyView$1(GeopopularRegionSelectPresenter geopopularRegionSelectPresenter, GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        this.f28249a = geopopularRegionSelectPresenter;
        this.f28250b = geopopularRegionSelectFilter;
    }

    public final void run() {
        this.f28249a.f33864a.mo7349b(this.f28250b);
    }
}
