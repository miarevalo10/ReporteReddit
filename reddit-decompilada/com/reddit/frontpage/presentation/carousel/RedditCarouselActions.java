package com.reddit.frontpage.presentation.carousel;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.SubredditCarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.CarouselView;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ListingView;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001IB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002JD\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J²\u0001\u0010$\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010-2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010.2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u000e\u0018\u00010.2\u0006\u00101\u001a\u00020\u0015H\u0017JL\u00102\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\u0006\u00103\u001a\u00020\u0010H\u0016J\\\u00104\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\u0006\u00103\u001a\u00020\u00102\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J&\u00105\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u0002072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+H\u0003Jb\u00105\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016JT\u00108\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\u0006\u00103\u001a\u00020\u00102\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J`\u00109\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0&2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+2\u0006\u0010<\u001a\u00020=H\u0016JJ\u0010>\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+H\u0016JD\u0010?\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\u0006\u0010(\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0003J\u001a\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00172\b\b\u0002\u0010C\u001a\u00020\u0015H\u0002J\u001c\u0010!\u001a\u0004\u0018\u00010#*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010D\u001a\u00020\u001eH\u0002J\u001c\u0010E\u001a\u0004\u0018\u00010F*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010D\u001a\u00020\u001eH\u0002J \u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010H*\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010D\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions;", "Lcom/reddit/frontpage/presentation/carousel/CarouselActions;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "analytics", "Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/domain/repository/SubredditRepository;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lcom/reddit/common/rx/PostExecutionThread;)V", "navigateToLink", "", "listingNavigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "item", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "navigateToSubreddit", "isUser", "", "name", "", "onCarouselImpression", "screenName", "models", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listablePosition", "", "idsSeen", "", "getCarouselCollection", "Lkotlin/Function0;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "onCarouselItemDismissed", "Lio/reactivex/disposables/Disposable;", "", "carouselItemPosition", "model", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselItemPresentationModel;", "listingView", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "handleCarouselReplacement", "Lkotlin/Function2;", "Lkotlin/Function1;", "onCarouselRemoved", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "notifyView", "onCarouselItemHeaderSelected", "navigator", "onCarouselItemSelected", "onCarouselItemSubscribed", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult;", "Lcom/reddit/frontpage/presentation/carousel/model/SubredditCarouselItemPresentationModel;", "onCarouselSelected", "onCarouselShowMeLessSelected", "links", "Lcom/reddit/frontpage/domain/model/Link;", "carouselView", "Lcom/reddit/frontpage/presentation/listing/CarouselView;", "onCarouselSubscribed", "onLinkCarouselItemSubscribed", "subscribeSubreddit", "Lio/reactivex/Completable;", "subredditName", "subscribe", "position", "getLinkCarouselCollection", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "getSubredditCarouselCollection", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "SubscribeResult", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditCarouselActions.kt */
public final class RedditCarouselActions implements CarouselActions {
    private final SubredditRepository f28065a;
    private final PreferenceRepository f28066b;
    private final CarouselAnalytics f28067c;
    private final FrontpageSettings f28068d;
    private final PostExecutionThread f28069e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult;", "", "disposable", "Lio/reactivex/disposables/Disposable;", "subscribed", "", "subredditDisplayName", "", "subscribedAction", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "(Lio/reactivex/disposables/Disposable;ZLjava/lang/String;Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;)V", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "getSubredditDisplayName", "()Ljava/lang/String;", "getSubscribed", "()Z", "getSubscribedAction", "()Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "SubscribeAction", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditCarouselActions.kt */
    public static final class SubscribeResult {
        public static final Companion f20336e = new Companion();
        public final Disposable f20337a;
        final boolean f20338b;
        public final String f20339c;
        public final SubscribeAction f20340d;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$Companion;", "", "()V", "getSubredditAction", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "subscribed", "", "getUserSubredditAction", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: RedditCarouselActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public static SubscribeAction m22677a() {
                return SubscribeAction.f20330a;
            }

            public static SubscribeAction m22678b() {
                return SubscribeAction.f20332c;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "", "(Ljava/lang/String;I)V", "message", "", "getMessage", "()Ljava/lang/Integer;", "SUBSCRIBED", "UNSUBSCRIBED", "FOLLOWED", "UNFOLLOWED", "NONE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: RedditCarouselActions.kt */
        public enum SubscribeAction {
            ;

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction$FOLLOWED;", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "(Ljava/lang/String;I)V", "message", "", "getMessage", "()Ljava/lang/Integer;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
            /* compiled from: RedditCarouselActions.kt */
            static final class FOLLOWED extends SubscribeAction {
                FOLLOWED(String str) {
                    super(str, 2);
                }

                public final Integer mo4785a() {
                    return Integer.valueOf(C1761R.string.fmt_now_following);
                }
            }

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction$NONE;", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "(Ljava/lang/String;I)V", "message", "", "getMessage", "()Ljava/lang/Integer;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
            /* compiled from: RedditCarouselActions.kt */
            static final class NONE extends SubscribeAction {
                public final Integer mo4785a() {
                    return null;
                }

                NONE(String str) {
                    super(str, 4);
                }
            }

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction$SUBSCRIBED;", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "(Ljava/lang/String;I)V", "message", "", "getMessage", "()Ljava/lang/Integer;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
            /* compiled from: RedditCarouselActions.kt */
            static final class SUBSCRIBED extends SubscribeAction {
                SUBSCRIBED(String str) {
                    super(str, 0);
                }

                public final Integer mo4785a() {
                    return Integer.valueOf(C1761R.string.fmt_now_subscribed);
                }
            }

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction$UNFOLLOWED;", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "(Ljava/lang/String;I)V", "message", "", "getMessage", "()Ljava/lang/Integer;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
            /* compiled from: RedditCarouselActions.kt */
            static final class UNFOLLOWED extends SubscribeAction {
                UNFOLLOWED(String str) {
                    super(str, 3);
                }

                public final Integer mo4785a() {
                    return Integer.valueOf(C1761R.string.fmt_now_unfollow);
                }
            }

            @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction$UNSUBSCRIBED;", "Lcom/reddit/frontpage/presentation/carousel/RedditCarouselActions$SubscribeResult$SubscribeAction;", "(Ljava/lang/String;I)V", "message", "", "getMessage", "()Ljava/lang/Integer;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
            /* compiled from: RedditCarouselActions.kt */
            static final class UNSUBSCRIBED extends SubscribeAction {
                UNSUBSCRIBED(String str) {
                    super(str, 1);
                }

                public final Integer mo4785a() {
                    return Integer.valueOf(C1761R.string.fmt_now_unsubscribed);
                }
            }

            public abstract Integer mo4785a();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubscribeResult) {
                SubscribeResult subscribeResult = (SubscribeResult) obj;
                if (Intrinsics.m26845a(this.f20337a, subscribeResult.f20337a)) {
                    return (this.f20338b == subscribeResult.f20338b) && Intrinsics.m26845a(this.f20339c, subscribeResult.f20339c) && Intrinsics.m26845a(this.f20340d, subscribeResult.f20340d);
                }
            }
        }

        public final int hashCode() {
            Disposable disposable = this.f20337a;
            int i = 0;
            int hashCode = (disposable != null ? disposable.hashCode() : 0) * 31;
            int i2 = this.f20338b;
            if (i2 != 0) {
                i2 = 1;
            }
            hashCode = (hashCode + i2) * 31;
            String str = this.f20339c;
            hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            SubscribeAction subscribeAction = this.f20340d;
            if (subscribeAction != null) {
                i = subscribeAction.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("SubscribeResult(disposable=");
            stringBuilder.append(this.f20337a);
            stringBuilder.append(", subscribed=");
            stringBuilder.append(this.f20338b);
            stringBuilder.append(", subredditDisplayName=");
            stringBuilder.append(this.f20339c);
            stringBuilder.append(", subscribedAction=");
            stringBuilder.append(this.f20340d);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public SubscribeResult(Disposable disposable, boolean z, String str, SubscribeAction subscribeAction) {
            Intrinsics.m26847b(str, "subredditDisplayName");
            Intrinsics.m26847b(subscribeAction, "subscribedAction");
            this.f20337a = disposable;
            this.f20338b = z;
            this.f20339c = str;
            this.f20340d = subscribeAction;
        }
    }

    @Inject
    public RedditCarouselActions(SubredditRepository subredditRepository, PreferenceRepository preferenceRepository, CarouselAnalytics carouselAnalytics, FrontpageSettings frontpageSettings, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(subredditRepository, "subredditRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(carouselAnalytics, "analytics");
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f28065a = subredditRepository;
        this.f28066b = preferenceRepository;
        this.f28067c = carouselAnalytics;
        this.f28068d = frontpageSettings;
        this.f28069e = postExecutionThread;
    }

    public final void mo4791a(String str, List<? extends Listable> list, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, ListingNavigator listingNavigator) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingNavigator, "navigator");
        if ((carouselCollectionPresentationModel instanceof LinkCarouselCollectionPresentationModel) == null) {
            carouselCollectionPresentationModel = null;
        }
        str = (LinkCarouselCollectionPresentationModel) carouselCollectionPresentationModel;
        if (str == null) {
            str = null;
        }
        if (str != null) {
            str = ((LinkCarouselItemPresentationModel) CollectionsKt___CollectionsKt.m41430d((List) str.f36374k)).f28083l.af;
            m29411a(listingNavigator, SubredditUtil.m23920a((CharSequence) str), str);
        }
    }

    public final void mo4789a(String str, List<? extends Listable> list, int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingNavigator listingNavigator, Function0<? extends CarouselCollectionPresentationModel> function0) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(carouselItemPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingNavigator, "navigator");
        list = m29409a(list, i);
        if (list == null) {
            list = function0 != null ? (CarouselCollectionPresentationModel) function0.invoke() : null;
        }
        if (list != null) {
            if ((carouselItemPresentationModel instanceof SubredditCarouselItemPresentationModel) != 0) {
                SubredditCarouselItemPresentationModel subredditCarouselItemPresentationModel = (SubredditCarouselItemPresentationModel) carouselItemPresentationModel;
                m29411a(listingNavigator, subredditCarouselItemPresentationModel.f33784b.isUser(), subredditCarouselItemPresentationModel.f33784b.getDisplayName());
            } else if ((carouselItemPresentationModel instanceof LinkCarouselItemPresentationModel) != 0) {
                Link link = ((LinkCarouselItemPresentationModel) carouselItemPresentationModel).f28083l.av;
                if (link != 0) {
                    listingNavigator.mo4844a(link);
                }
            }
            this.f28067c.mo4771a(set, i2, list, str);
        }
    }

    public final void mo4792a(String str, List<? extends Listable> list, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingNavigator listingNavigator) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(carouselItemPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingNavigator, "navigator");
        if ((carouselItemPresentationModel instanceof LinkCarouselItemPresentationModel) == null) {
            carouselItemPresentationModel = null;
        }
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = (LinkCarouselItemPresentationModel) carouselItemPresentationModel;
        if (linkCarouselItemPresentationModel != null) {
            m29411a(listingNavigator, null, linkCarouselItemPresentationModel.f28083l.af);
        }
    }

    public final SubscribeResult mo4786a(String str, List<Listable> list, int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingView<? super Listable> listingView) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(carouselItemPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingView, "listingView");
        Object obj = list.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel");
        }
        CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj;
        if (carouselCollectionPresentationModel instanceof GeneralCarouselCollectionPresentationModel) {
            SubredditCarouselItemPresentationModel subredditCarouselItemPresentationModel = (SubredditCarouselItemPresentationModel) carouselItemPresentationModel;
            list = subredditCarouselItemPresentationModel.f33787e ^ 1;
            String displayName = subredditCarouselItemPresentationModel.f33784b.getDisplayName();
            if (list == null) {
                list = new SubscribeResult(null, false, displayName, SubscribeAction.f20334e);
            } else {
                subredditCarouselItemPresentationModel.f33787e = true;
                listingView.mo7328b(i);
                if (SubredditUtil.m23920a((CharSequence) displayName) != null) {
                    list = SubscribeResult.f20336e;
                    list = Companion.m22678b();
                } else {
                    list = SubscribeResult.f20336e;
                    list = Companion.m22677a();
                }
                list = new SubscribeResult(m29410a(displayName).subscribe(), true, displayName, list);
            }
        } else if (carouselCollectionPresentationModel instanceof LinkCarouselCollectionPresentationModel) {
            LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = (LinkCarouselItemPresentationModel) carouselItemPresentationModel;
            list = list.get(i);
            if (!(list instanceof LinkCarouselCollectionPresentationModel)) {
                list = null;
            }
            list = (LinkCarouselCollectionPresentationModel) list;
            if (list == null) {
                list = null;
            }
            if (list == null) {
                list = new StringBuilder();
                list.append(null);
                list.append(" is not a ");
                list.append(LinkCarouselCollectionPresentationModel.f36364p);
                throw ((Throwable) new IllegalStateException(list.toString()));
            }
            int i3 = linkCarouselItemPresentationModel.f28076e ^ 1;
            Object obj2 = linkCarouselItemPresentationModel.f28074c;
            if (i3 == 0) {
                list = new SubscribeResult(null, false, obj2, SubscribeAction.f20334e);
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : list.f36374k) {
                    if (Intrinsics.m26845a(((LinkCarouselItemPresentationModel) next).f28074c, obj2)) {
                        arrayList.add(next);
                    }
                }
                for (LinkCarouselItemPresentationModel linkCarouselItemPresentationModel2 : (List) arrayList) {
                    linkCarouselItemPresentationModel2.f28076e = true;
                }
                listingView.mo7328b(i);
                i = m29410a(obj2).subscribe();
                listingView = SubscribeResult.f20336e;
                list = new SubscribeResult(i, true, obj2, Companion.m22677a());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (list.f20337a != 0) {
            this.f28067c.mo4772a(set, i2, carouselCollectionPresentationModel, str, list.f20338b);
        }
        return list;
    }

    public final SubscribeResult mo4787a(String str, List<Listable> list, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, ListingView<? super Listable> listingView) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingView, "listingView");
        if (carouselCollectionPresentationModel instanceof LinkCarouselCollectionPresentationModel) {
            LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel = (LinkCarouselCollectionPresentationModel) carouselCollectionPresentationModel;
            String str2 = linkCarouselCollectionPresentationModel.f36368e;
            if (linkCarouselCollectionPresentationModel.f36373j) {
                return new SubscribeResult(null, linkCarouselCollectionPresentationModel.f36373j, str2, SubscribeAction.f20334e);
            }
            SubredditUtil.m23928b(str2, true);
            list.set(i, LinkCarouselCollectionPresentationModel.m36775a(linkCarouselCollectionPresentationModel));
            listingView.mo7330b((List) list);
            listingView.mo7328b(i);
            this.f28067c.mo4775b(set, carouselCollectionPresentationModel, str);
            list = m29410a(str2).subscribe();
            i = SubscribeResult.f20336e;
            return new SubscribeResult(list, true, str2, Companion.m22677a());
        }
        throw ((Throwable) new UnsupportedOperationException("Carousel subscribe operation only supported for links"));
    }

    public final void mo4790a(String str, List<? extends Listable> list, int i, Set<String> set, Function0<? extends CarouselCollectionPresentationModel> function0) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(set, "idsSeen");
        list = m29409a(list, i);
        if (list == null) {
            list = function0 != null ? (CarouselCollectionPresentationModel) function0.invoke() : null;
        }
        if (list != null) {
            this.f28067c.mo4776c(set, list, str);
        }
    }

    public final void mo4793a(String str, List<Link> list, List<Listable> list2, int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel, Set<String> set, ListingView<? super Listable> listingView, CarouselView carouselView) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "links");
        Intrinsics.m26847b(list2, "models");
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingView, "listingView");
        Intrinsics.m26847b(carouselView, "carouselView");
        FrontpageSettings frontpageSettings = this.f28068d;
        DiscoveryUnit a = carouselCollectionPresentationModel.mo6934a();
        if (a == null) {
            Intrinsics.m26842a();
        }
        frontpageSettings.f(a.unique_id);
        list.remove(i);
        list2.remove(i);
        carouselView.mo7630a();
        listingView.mo7330b((List) list2);
        listingView.mo7322a(i);
        this.f28067c.mo4777d(set, carouselCollectionPresentationModel, str);
    }

    private final Completable m29410a(String str) {
        SubredditUtil.m23928b(str, true);
        return CompletablesKt.m24074b(this.f28065a.m22506g(str), this.f28069e);
    }

    private static void m29411a(ListingNavigator listingNavigator, boolean z, String str) {
        if (z) {
            String b = SubredditUtil.m23921b(str);
            Intrinsics.m26843a((Object) b, "SubredditUtil.stripUserPrefix(name)");
            listingNavigator.mo4845a(b);
            return;
        }
        listingNavigator.mo4848b(str);
    }

    private static CarouselCollectionPresentationModel m29409a(List<? extends Listable> list, int i) {
        list = list.get(i);
        if ((list instanceof CarouselCollectionPresentationModel) == 0) {
            list = null;
        }
        return (CarouselCollectionPresentationModel) list;
    }

    public final Disposable mo4788a(String str, List<Listable> list, int i, int i2, CarouselItemPresentationModel carouselItemPresentationModel, Set<String> set, ListingView<? super Listable> listingView, Function0<? extends CarouselCollectionPresentationModel> function0, Function2<? super Integer, ? super CarouselCollectionPresentationModel, Unit> function2, Function1<? super String, Unit> function1, Function1<? super DiscoveryUnit, Unit> function12, boolean z) {
        Object subscribe;
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(list, "models");
        Intrinsics.m26847b(carouselItemPresentationModel, "model");
        Intrinsics.m26847b(set, "idsSeen");
        Intrinsics.m26847b(listingView, "listingView");
        carouselItemPresentationModel = list.get(i);
        CarouselCollectionPresentationModel carouselCollectionPresentationModel = null;
        if (!(carouselItemPresentationModel instanceof GeneralCarouselCollectionPresentationModel)) {
            carouselItemPresentationModel = null;
        }
        carouselItemPresentationModel = (GeneralCarouselCollectionPresentationModel) carouselItemPresentationModel;
        if (carouselItemPresentationModel == null) {
            if (function0 != null) {
                carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) function0.invoke();
            }
            if (carouselCollectionPresentationModel == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel<*>");
            }
            carouselItemPresentationModel = (GeneralCarouselCollectionPresentationModel) carouselCollectionPresentationModel;
        }
        function0 = CollectionsKt___CollectionsKt.m41428c((Collection) carouselItemPresentationModel.f36357e);
        if (i2 >= 0) {
            if (i2 <= CollectionsKt__CollectionsKt.m26787a((List) function0)) {
                ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) function0.remove(i2);
                if (function0.isEmpty()) {
                    list.remove(i);
                    if (z) {
                        listingView.mo7330b((List) list);
                        listingView.mo7322a(i);
                    }
                    if (function12 != null) {
                        list = carouselItemPresentationModel.f36361i;
                        if (list == null) {
                            Intrinsics.m26842a();
                        }
                        function12.mo6492a(list);
                    }
                } else {
                    function0 = GeneralCarouselCollectionPresentationModel.m36772a(carouselItemPresentationModel, function0);
                    if (function2 == null) {
                        list.set(i, function0);
                    } else {
                        function2.mo6497a(Integer.valueOf(i), function0);
                    }
                    if (z) {
                        listingView.mo7330b((List) list);
                        listingView.mo7328b(i);
                    }
                }
                if (function1 != null) {
                    function1.mo6492a(iCarouselItemPresentationModel.mo6433a());
                }
                this.f28067c.mo4774b(set, i2, (CarouselCollectionPresentationModel) carouselItemPresentationModel, str);
                str = this.f28066b;
                CarouselCollectionStateKey carouselCollectionStateKey = carouselItemPresentationModel.f36362j;
                if (carouselCollectionStateKey == null) {
                    Intrinsics.m26842a();
                }
                subscribe = CompletablesKt.m24074b(str.m22466a(carouselCollectionStateKey, (Function1) new RedditCarouselActions$onCarouselItemDismissed$1(iCarouselItemPresentationModel)), (Thread) this.f28069e).subscribe();
                Intrinsics.m26843a(subscribe, "preferenceRepository\n   …ead)\n        .subscribe()");
                return subscribe;
            }
        }
        subscribe = Disposables.m26512a();
        Intrinsics.m26843a(subscribe, "Disposables.empty()");
        return subscribe;
    }
}
