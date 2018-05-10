package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter.FrontpageLoadResult.Error;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter.FrontpageLoadResult.Success;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "loadResult", "Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$FrontpageLoadResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingPresenter.kt */
final class FrontpageListingPresenter$loadListingAndSetOnView$5<T> implements Consumer<FrontpageLoadResult> {
    final /* synthetic */ FrontpageListingPresenter f28386a;
    final /* synthetic */ SortType f28387b;
    final /* synthetic */ SortTimeFrame f28388c;
    final /* synthetic */ String f28389d;
    final /* synthetic */ String f28390e;
    final /* synthetic */ boolean f28391f;
    final /* synthetic */ boolean f28392g;
    final /* synthetic */ boolean f28393h;
    final /* synthetic */ Function0 f28394i;

    FrontpageListingPresenter$loadListingAndSetOnView$5(FrontpageListingPresenter frontpageListingPresenter, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, boolean z2, boolean z3, Function0 function0) {
        this.f28386a = frontpageListingPresenter;
        this.f28387b = sortType;
        this.f28388c = sortTimeFrame;
        this.f28389d = str;
        this.f28390e = str2;
        this.f28391f = z;
        this.f28392g = z2;
        this.f28393h = z3;
        this.f28394i = function0;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (FrontpageLoadResult) obj;
        if (Intrinsics.m26845a(obj, Error.f28376a)) {
            FrontpageListingPresenter.m37045a(this.f28386a, this.f28387b, this.f28388c, this.f28389d, this.f28390e, this.f28391f, this.f28392g, this.f28393h);
            return;
        }
        if (obj instanceof Success) {
            this.f28394i.invoke();
            FrontpageListingPresenter.m37048a(this.f28386a, this.f28393h, (Success) obj, this.f28391f, this.f28387b, this.f28388c, this.f28392g);
            if (!(this.f28391f == null && this.f28393h == null)) {
                obj = this.f28386a.m37051c();
                obj.m23417a();
                obj.m23421b();
                FrontpageListingPresenter.m37044a(this.f28386a, this.f28387b, this.f28388c);
            }
        }
    }
}
