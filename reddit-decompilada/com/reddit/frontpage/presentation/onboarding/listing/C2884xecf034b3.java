package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen.OnboardingListingAdapter;
import com.reddit.frontpage.util.SubredditUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingListingScreen.kt */
final class C2884xecf034b3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OnboardingListingAdapter f37021a;
    final /* synthetic */ LinkPresentationModel f37022b;
    final /* synthetic */ LinkViewHolder f37023c;

    C2884xecf034b3(OnboardingListingAdapter onboardingListingAdapter, LinkPresentationModel linkPresentationModel, LinkViewHolder linkViewHolder) {
        this.f37021a = onboardingListingAdapter;
        this.f37022b = linkPresentationModel;
        this.f37023c = linkViewHolder;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        OnboardingListingPresenter w = this.f37021a.f34142b.mo7641w();
        int d = this.f37023c.d();
        Pair i = w.m34846i(d);
        Link link = (Link) i.f25267a;
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) i.f25268b;
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b.c();
        OnboardingEventBuilder a = w.m34847j(d).m28959a(Source.POST).m28957a(Noun.SUBSCRIBE);
        if (SubredditUtil.m23933d(linkPresentationModel.af)) {
            SubredditUtil.m23926b(link);
            a.m28956a(Action.DESELECT);
        } else {
            SubredditUtil.m23917a(link);
            a.m28956a(Action.SELECT);
        }
        a.m21891a();
        return Unit.f25273a;
    }
}
