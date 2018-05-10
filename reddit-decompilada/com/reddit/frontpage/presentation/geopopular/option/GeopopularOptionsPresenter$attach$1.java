package com.reddit.frontpage.presentation.geopopular.option;

import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularOptionsPresenter.kt */
final class GeopopularOptionsPresenter$attach$1<T> implements Consumer<GeopopularRegionSelectFilter> {
    final /* synthetic */ GeopopularOptionsPresenter f28238a;

    GeopopularOptionsPresenter$attach$1(GeopopularOptionsPresenter geopopularOptionsPresenter) {
        this.f28238a = geopopularOptionsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        GeopopularRegionSelectFilter geopopularRegionSelectFilter = (GeopopularRegionSelectFilter) obj;
        String str = geopopularRegionSelectFilter.f20534a;
        obj = geopopularRegionSelectFilter.f20535b;
        View a = this.f28238a.f33857a;
        if (StringsKt__StringsJVMKt.m41943a((CharSequence) str)) {
            a.mo7176b();
        } else {
            a.mo7177b(obj);
        }
    }
}
