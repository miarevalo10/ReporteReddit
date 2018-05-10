package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.common.ThingType;
import com.reddit.common.ThingUtil;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadData;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadDataParams;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadDataParams.Load;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadDataParams.Refresh;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.listing.common.LinkPresentationPositionUtil;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.onboarding.OnboardingNavigator;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.Parameters;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.Presenter;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.View;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BO\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0002J,\u0010'\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0,2\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020%2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0,H\u0002J\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000202012\u0006\u00103\u001a\u00020\u001cH\u0002J$\u00104\u001a\u00020%2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020%06H\u0002J\b\u00107\u001a\u00020%H\u0016J\b\u00108\u001a\u000209H\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001cH\u0007J\u0010\u0010;\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010<\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010=\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010>\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010?\u001a\u00020%2\u0006\u0010:\u001a\u00020\u001cH\u0016J\b\u0010@\u001a\u00020%H\u0016J\u0010\u0010A\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010B\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010D\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0010\u0010E\u001a\u00020%2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u001a\u0010F\u001a\u00020%2\b\b\u0001\u0010G\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u0010\u0010H\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0002J2\u0010I\u001a\b\u0012\u0004\u0012\u00020#0)2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0)2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010J\u001a\u00020%H\u0016R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$View;", "parameters", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Parameters;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "onboardingNavigator", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingNavigator;", "formatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "categoryLinksLoadData", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadData;", "subscriptionCountRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$View;Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingContract$Parameters;Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;Lcom/reddit/frontpage/presentation/onboarding/OnboardingNavigator;Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadData;Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/common/rx/PostExecutionThread;)V", "after", "", "isLoadingMore", "", "linkPositions", "", "", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "loadLinksParams", "Lcom/reddit/frontpage/domain/usecase/CategoryLinksLoadDataParams;", "presentationModels", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingLinkPresentationModel;", "attach", "", "handleLoadLinkFailure", "handleLoadLinkSuccess", "subreddits", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "listing", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "handleViewShouldLoadMore", "linkAndModelAt", "Lkotlin/Pair;", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "presentationModelPosition", "loadLinks", "onComplete", "Lkotlin/Function0;", "loadMore", "newAnalyticsEventBuilder", "Lcom/reddit/frontpage/commons/analytics/events/v2/OnboardingEventBuilder;", "position", "onCommentsSelected", "onCommunitySelected", "onCrossPostSelected", "onLinkSelected", "onLinkVisible", "onLoadErrorClicked", "onModerateSelected", "onPreviewSelected", "onShareSelected", "onSourceSelected", "onSubscribeClicked", "onVoteChanged", "direction", "openLink", "toPresentationModels", "updateListing", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingListingPresenter.kt */
public final class OnboardingListingPresenter extends DisposablePresenter implements Presenter {
    String f34118a;
    private CategoryLinksLoadDataParams f34119b;
    private boolean f34120c;
    private final List<Link> f34121d;
    private final Map<String, Integer> f34122e;
    private final List<OnboardingLinkPresentationModel> f34123f;
    private final View f34124g;
    private final UserLinkActions f34125h;
    private final OnboardingNavigator f34126i;
    private final NumberFormatter f34127j;
    private final CategoryLinksLoadData f34128k;
    private final SubscriptionCountRepository f34129l;
    private final BackgroundThread f34130m;
    private final PostExecutionThread f34131n;

    @Inject
    public OnboardingListingPresenter(View view, Parameters parameters, UserLinkActions userLinkActions, OnboardingNavigator onboardingNavigator, NumberFormatter numberFormatter, CategoryLinksLoadData categoryLinksLoadData, SubscriptionCountRepository subscriptionCountRepository, BackgroundThread backgroundThread, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(parameters, "parameters");
        Intrinsics.m26847b(userLinkActions, "linkActions");
        Intrinsics.m26847b(onboardingNavigator, "onboardingNavigator");
        Intrinsics.m26847b(numberFormatter, "formatter");
        Intrinsics.m26847b(categoryLinksLoadData, "categoryLinksLoadData");
        Intrinsics.m26847b(subscriptionCountRepository, "subscriptionCountRepository");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f34124g = view;
        this.f34125h = userLinkActions;
        this.f34126i = onboardingNavigator;
        this.f34127j = numberFormatter;
        this.f34128k = categoryLinksLoadData;
        this.f34129l = subscriptionCountRepository;
        this.f34130m = backgroundThread;
        this.f34131n = postExecutionThread;
        if (parameters.f20951b != null) {
            view = (CategoryLinksLoadDataParams) new Refresh(parameters.f20950a);
        } else {
            view = (CategoryLinksLoadDataParams) new Load(parameters.f20950a);
        }
        this.f34119b = view;
        this.f34121d = (List) new ArrayList();
        this.f34122e = (Map) new LinkedHashMap();
        this.f34123f = (List) new ArrayList();
    }

    public final void attach() {
        if (this.f34121d.isEmpty()) {
            this.f34124g.mo7677a();
            m34829a(this, null, null, 3);
        } else {
            this.f34124g.mo7681e();
        }
        Object subscribe = ObservablesKt.m24092b(ObservablesKt.m24090a(this.f34129l.a(), (Thread) this.f34130m), this.f34131n).subscribe((Consumer) new OnboardingListingPresenter$attach$1(this));
        Intrinsics.m26843a(subscribe, "subscriptionCountReposit…istingChanged()\n        }");
        handleDispose(subscribe);
    }

    public final void m34837a() {
        if (!this.f34120c) {
            this.f34124g.mo7679c();
            this.f34120c = true;
            m34831a(this.f34118a, new OnboardingListingPresenter$loadMore$1(this));
        }
    }

    public final void m34845h(int i) {
        m34847j(i).m28959a(Source.POST).m28956a(Action.VIEW).m28957a(Noun.POST).m21891a();
    }

    public final void mo6483a(int i) {
        m34836k(i);
        m34847j(i).m28959a(Source.POST).m28956a(Action.CLICK).m28957a(Noun.BODY).m21891a();
    }

    public final void mo6484b(int i) {
        this.f34125h.mo4883a((LinkPresentationModel) m34846i(i).f25268b, this.f34121d, this.f34122e);
        m34847j(i).m28959a(Source.POST).m28956a(Action.CLICK).m28957a(Noun.BODY).m21891a();
    }

    public final void mo6485c(int i) {
        m34836k(i);
        m34847j(i).m28959a(Source.POST).m28956a(Action.CLICK).m28957a(Noun.SUBREDDIT).m21891a();
    }

    public final void mo6486d(int i) {
        throw ((Throwable) new UnsupportedOperationException("Not available from onboarding screen"));
    }

    public final void mo6487e(int i) {
        i = m34846i(i);
        this.f34125h.mo4881a((Link) i.f25267a, (LinkPresentationModel) i.f25268b);
    }

    public final void mo6488f(int i) {
        m34836k(i);
        m34847j(i).m28959a(Source.POST).m28956a(Action.CLICK).m28957a(Noun.COMMENTS).m21891a();
    }

    public final void mo6489g(int i) {
        this.f34125h.mo4887c((LinkPresentationModel) m34846i(i).f25268b, this.f34121d, this.f34122e);
        m34847j(i).m28959a(Source.POST).m28956a(Action.CLICK).m28957a(Noun.SHARE).m21891a();
    }

    private final void m34831a(String str, Function0<Unit> function0) {
        if (str != null) {
            this.f34119b = new Load(this.f34119b.f27972a, str);
        }
        Object subscribe = SinglesKt.m24094b(this.f34128k.m22528b(this.f34119b), this.f34131n).subscribe(new OnboardingListingPresenter$loadLinks$2(this, function0), new OnboardingListingPresenter$loadLinks$3(this, function0));
        Intrinsics.m26843a(subscribe, "categoryLinksLoadData\n  …dLinkFailure()\n        })");
        handleDispose(subscribe);
    }

    private final List<OnboardingLinkPresentationModel> m34828a(List<Link> list, List<Subreddit> list2, SubredditCategory subredditCategory) {
        Iterable<Subreddit> iterable = list2;
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(iterable)), 16));
        for (Subreddit subreddit : iterable) {
            Pair a = TuplesKt.m26780a(ThingUtil.a(subreddit.getId(), ThingType.d), this.f34127j.mo4823a(subreddit.getSubscribers()));
            linkedHashMap.put(a.f25267a, a.f25268b);
        }
        Iterable<Link> iterable2 = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
        for (Link link : iterable2) {
            String a2 = ThingUtil.a(link.getSubredditId(), ThingType.d);
            LinkMapper linkMapper = LinkMapper.f20611a;
            LinkPresentationModel a3 = LinkMapper.m22969a(link);
            a2 = (String) linkedHashMap.get(a2);
            if (a2 == null) {
                a2 = "";
            }
            arrayList.add(new OnboardingLinkPresentationModel(a3, a2, subredditCategory));
        }
        return (List) arrayList;
    }

    final Pair<Link, LinkPresentationModel> m34846i(int i) {
        LinkPresentationModel linkPresentationModel = ((OnboardingLinkPresentationModel) this.f34123f.get(i)).f34114a;
        List list = this.f34121d;
        LinkPresentationPositionUtil linkPresentationPositionUtil = LinkPresentationPositionUtil.f20573a;
        return TuplesKt.m26780a((Link) list.get(LinkPresentationPositionUtil.m22873a(i, this.f34121d, linkPresentationModel)), linkPresentationModel);
    }

    private final void m34836k(int i) {
        this.f34126i.mo4920a((Link) m34846i(i).f25267a, this.f34119b.f27972a, ((OnboardingLinkPresentationModel) this.f34123f.get(i)).f34115b);
    }

    private OnboardingEventBuilder m34832b() {
        OnboardingEventBuilder onboardingEventBuilder = new OnboardingEventBuilder();
        onboardingEventBuilder.m28958a(PageType.RECOMMENDATIONS);
        onboardingEventBuilder.m28960a(this.f34119b.f27972a);
        return onboardingEventBuilder;
    }

    public final OnboardingEventBuilder m34847j(int i) {
        OnboardingEventBuilder b = m34832b();
        Link link = (Link) m34846i(i).f25267a;
        b.m21889a(link.getSubredditId(), link.getSubreddit());
        b.m21890a(link.getKindWithId(), link.getAnalyticsPostType().name(), link.getTitle());
        return b;
    }

    public static final /* synthetic */ void m34830a(OnboardingListingPresenter onboardingListingPresenter, List list, Listing listing, SubredditCategory subredditCategory) {
        boolean isEmpty = onboardingListingPresenter.f34121d.isEmpty();
        Collection arrayList = new ArrayList();
        for (Object next : listing.getChildren()) {
            if ((onboardingListingPresenter.f34122e.containsKey(((Link) next).getId()) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        int size = onboardingListingPresenter.f34121d.size();
        onboardingListingPresenter.f34121d.addAll(list2);
        Map map = onboardingListingPresenter.f34122e;
        Iterable<Link> iterable = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (Link id : iterable) {
            int i2 = i + 1;
            arrayList2.add(TuplesKt.m26780a(id.getId(), Integer.valueOf(i + size)));
            i = i2;
        }
        Iterable<Pair> iterable2 = (List) arrayList2;
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(iterable2)), 16));
        for (Pair pair : iterable2) {
            linkedHashMap.put(pair.f25267a, pair.f25268b);
        }
        map.putAll(linkedHashMap);
        onboardingListingPresenter.f34123f.addAll(onboardingListingPresenter.m34828a(list2, list, subredditCategory));
        onboardingListingPresenter.f34118a = listing.getAfter();
        onboardingListingPresenter.f34124g.mo7330b((List) onboardingListingPresenter.f34123f);
        onboardingListingPresenter.f34124g.mo7681e();
        if (isEmpty) {
            onboardingListingPresenter.f34124g.mo7335x();
        } else {
            onboardingListingPresenter.f34124g.mo7323a(size, list2.size());
        }
    }

    public static final /* synthetic */ void m34835d(OnboardingListingPresenter onboardingListingPresenter) {
        onboardingListingPresenter.f34124g.mo7678b();
        if (onboardingListingPresenter.f34121d.isEmpty()) {
            onboardingListingPresenter.f34124g.mo7336y();
            onboardingListingPresenter.m34832b().m28959a(Source.ONBOARDING).m28956a(Action.FAIL).m28957a(Noun.LOAD_FEED).m21891a();
            return;
        }
        onboardingListingPresenter.f34124g.Z_();
    }
}
