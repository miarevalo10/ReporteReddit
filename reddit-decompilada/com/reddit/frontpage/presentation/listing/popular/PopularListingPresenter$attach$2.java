package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.frontpage.domain.usecase.DiffListingResult;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/frontpage/domain/usecase/DiffListingResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopularListingPresenter.kt */
final class PopularListingPresenter$attach$2<T> implements Consumer<DiffListingResult> {
    final /* synthetic */ PopularListingPresenter f28441a;

    PopularListingPresenter$attach$2(PopularListingPresenter popularListingPresenter) {
        this.f28441a = popularListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        DiffListingResult diffListingResult = (DiffListingResult) obj;
        List b = this.f28441a.f36718i;
        b.clear();
        b.addAll(diffListingResult.f20273b);
        b = this.f28441a.f36717h;
        b.clear();
        b.addAll(diffListingResult.f20272a);
        Map d = this.f28441a.f36719j;
        d.clear();
        d.putAll(diffListingResult.f20274c);
        this.f28441a.f36716f.mo7330b(this.f28441a.f36718i);
        this.f28441a.f36716f.mo7324a(diffListingResult.f20277f);
        this.f28441a.m37161a(diffListingResult.f20275d, diffListingResult.f20276e);
    }
}
