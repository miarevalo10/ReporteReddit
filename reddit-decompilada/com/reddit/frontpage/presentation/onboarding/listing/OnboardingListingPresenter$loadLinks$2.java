package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006 \b*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingListingPresenter.kt */
final class OnboardingListingPresenter$loadLinks$2<T> implements Consumer<Pair<? extends List<? extends Subreddit>, ? extends Listing<? extends Link>>> {
    final /* synthetic */ OnboardingListingPresenter f28723a;
    final /* synthetic */ Function0 f28724b;

    OnboardingListingPresenter$loadLinks$2(OnboardingListingPresenter onboardingListingPresenter, Function0 function0) {
        this.f28723a = onboardingListingPresenter;
        this.f28724b = function0;
    }

    public final /* synthetic */ void accept(Object obj) {
        Pair pair = (Pair) obj;
        List list = (List) pair.f25267a;
        Listing listing = (Listing) pair.f25268b;
        this.f28724b.invoke();
        OnboardingListingPresenter.m34830a(this.f28723a, list, listing, this.f28723a.f34119b.f27972a);
    }
}
