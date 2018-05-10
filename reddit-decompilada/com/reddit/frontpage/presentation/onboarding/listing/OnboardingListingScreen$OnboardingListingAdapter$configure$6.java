package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen.OnboardingListingAdapter;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter$configure$6", "Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;", "(Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen$OnboardingListingAdapter;Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;)V", "beforeVoteChanged", "", "onVoteChanged", "", "votableFullName", "", "voteDirection", "", "adAnalyticsInfo", "Lcom/reddit/datalibrary/frontpage/requests/models/Votable$AdAnalyticsInfo;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingScreen.kt */
public final class OnboardingListingScreen$OnboardingListingAdapter$configure$6 implements OnVoteChangeListener {
    final /* synthetic */ OnboardingListingAdapter f28729a;
    final /* synthetic */ LinkViewHolder f28730b;

    public final boolean mo4894a() {
        return true;
    }

    OnboardingListingScreen$OnboardingListingAdapter$configure$6(OnboardingListingAdapter onboardingListingAdapter, LinkViewHolder linkViewHolder) {
        this.f28729a = onboardingListingAdapter;
        this.f28730b = linkViewHolder;
    }

    public final void mo4893a(String str, int i, AdAnalyticsInfo adAnalyticsInfo) {
        this.f28729a.f34142b.mo7641w().m34847j(this.f28729a.mo6471d(this.f28730b)).m28959a(Source.POST).m28956a(Action.CLICK).m28954a(i).m21891a();
    }
}
