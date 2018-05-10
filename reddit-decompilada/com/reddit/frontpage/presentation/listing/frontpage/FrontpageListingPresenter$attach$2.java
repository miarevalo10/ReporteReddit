package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.frontpage.domain.usecase.DiffListingResult;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/frontpage/domain/usecase/DiffListingResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingPresenter.kt */
final class FrontpageListingPresenter$attach$2<T> implements Consumer<DiffListingResult> {
    final /* synthetic */ FrontpageListingPresenter f28381a;

    FrontpageListingPresenter$attach$2(FrontpageListingPresenter frontpageListingPresenter) {
        this.f28381a = frontpageListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        DiffListingResult diffListingResult = (DiffListingResult) obj;
        List b = this.f28381a.f36633b;
        b.clear();
        b.addAll(diffListingResult.f20273b);
        b = this.f28381a.f36639i;
        b.clear();
        b.addAll(diffListingResult.f20272a);
        Map d = this.f28381a.f36640j;
        d.clear();
        d.putAll(diffListingResult.f20274c);
        this.f28381a.f36634c.mo7330b(this.f28381a.f36633b);
        this.f28381a.f36634c.mo7324a(diffListingResult.f20277f);
        this.f28381a.m37049a(diffListingResult.f20275d, diffListingResult.f20276e);
    }
}
