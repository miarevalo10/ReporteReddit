package com.reddit.frontpage.presentation.geopopular.select;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/reddit/frontpage/presentation/geopopular/select/GeopopularRegionSelectPresenter$GeopopularFilteredMappingResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionSelectPresenter.kt */
final class GeopopularRegionSelectPresenter$attach$2<T> implements Consumer<GeopopularFilteredMappingResult> {
    final /* synthetic */ GeopopularRegionSelectPresenter f28242a;

    GeopopularRegionSelectPresenter$attach$2(GeopopularRegionSelectPresenter geopopularRegionSelectPresenter) {
        this.f28242a = geopopularRegionSelectPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        GeopopularFilteredMappingResult geopopularFilteredMappingResult = (GeopopularFilteredMappingResult) obj;
        List list = geopopularFilteredMappingResult.f20546a;
        this.f28242a.f33866d = geopopularFilteredMappingResult.f20547b;
        if (this.f28242a.f33865c.isEmpty() != null) {
            this.f28242a.f33865c.addAll(list);
        }
        if ((list.isEmpty() ^ 1) != null) {
            this.f28242a.f33864a.mo7347a(list);
            this.f28242a.f33864a.z_();
            this.f28242a.f33864a.mo7351d();
            return;
        }
        this.f28242a.f33864a.A_();
        this.f28242a.f33864a.mo7350c();
    }
}
