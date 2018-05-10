package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter.PopularLoadResult.Error;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter.PopularLoadResult.Success;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "loadResult", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopularListingPresenter.kt */
final class PopularListingPresenter$loadListingAndSetOnView$5<T> implements Consumer<PopularLoadResult> {
    final /* synthetic */ PopularListingPresenter f28445a;
    final /* synthetic */ SortType f28446b;
    final /* synthetic */ SortTimeFrame f28447c;
    final /* synthetic */ String f28448d;
    final /* synthetic */ String f28449e;
    final /* synthetic */ boolean f28450f;
    final /* synthetic */ boolean f28451g;
    final /* synthetic */ boolean f28452h;
    final /* synthetic */ Function0 f28453i;

    PopularListingPresenter$loadListingAndSetOnView$5(PopularListingPresenter popularListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, boolean z2, boolean z3, Function0 function0) {
        this.f28445a = popularListingPresenter;
        this.f28446b = sortType;
        this.f28447c = sortTimeFrame;
        this.f28448d = str;
        this.f28449e = str2;
        this.f28450f = z;
        this.f28451g = z2;
        this.f28452h = z3;
        this.f28453i = function0;
    }

    public final /* synthetic */ void accept(Object obj) {
        PopularLoadResult popularLoadResult = (PopularLoadResult) obj;
        if (popularLoadResult instanceof Error) {
            PopularListingPresenter.m37157a(this.f28445a, this.f28446b, this.f28447c, this.f28448d, this.f28449e, this.f28450f, this.f28451g, this.f28452h);
            return;
        }
        if (popularLoadResult instanceof Success) {
            this.f28453i.invoke();
            PopularListingPresenter.m37160a(this.f28445a, this.f28452h, (Success) popularLoadResult, this.f28450f, this.f28446b, this.f28447c, this.f28451g);
        }
    }
}
