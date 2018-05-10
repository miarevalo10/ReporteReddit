package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Karma;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import com.reddit.frontpage.domain.usecase.LinksLoadData;
import com.reddit.frontpage.domain.usecase.LinksLoadDataParams;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.listing.common.LinkPresentationPositionUtil;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingContract.Presenter;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GBG\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00104\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000202H\u0016J\u0010\u00107\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\b\u00108\u001a\u00020&H\u0016J\u0010\u00109\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010<\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010=\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010@\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010A\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010C\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010D\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0016J\b\u0010E\u001a\u00020&H\u0016J\b\u0010F\u001a\u00020&H\u0016R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "karmaRepository", "Lcom/reddit/frontpage/domain/repository/KarmaRepository;", "userAccountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "moderatorActions", "Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "linksLoadData", "Lcom/reddit/frontpage/domain/usecase/LinksLoadData;", "(Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingContract$View;Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;Lcom/reddit/frontpage/domain/repository/KarmaRepository;Lcom/reddit/frontpage/domain/repository/AccountRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;Lcom/reddit/frontpage/domain/usecase/LinksLoadData;)V", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "isLoading", "", "isLoggedInUser", "()Z", "isLoggedInUser$delegate", "Lkotlin/Lazy;", "karmaItems", "", "Lcom/reddit/frontpage/domain/model/Karma;", "links", "Lcom/reddit/frontpage/domain/model/Link;", "nextLinkId", "", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "attach", "", "createScreenViewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "createScreenViewLegacyEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent;", "event", "loadListing", "loadMore", "loadOtherUserListing", "loadSelfListing", "onCommentsSelected", "presentationModelPosition", "", "onCommunitySelected", "onCrossPostSelected", "onKarmaItemClicked", "position", "onLinkSelected", "onLoadErrorClicked", "onModerateApprove", "onModerateDistinguish", "onModerateLockComments", "onModerateMarkNsfw", "onModerateMarkSpoiler", "onModeratePinAnnouncement", "onModerateRemove", "onModerateRemoveAsSpam", "onModerateSelected", "onPreviewSelected", "onShareSelected", "onSourceSelected", "sendScrollEvent", "updateListing", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingPresenter.kt */
public final class UserSubmittedListingPresenter extends DisposablePresenter implements Presenter {
    static final /* synthetic */ KProperty[] f36734a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserSubmittedListingPresenter.class), "isLoggedInUser", "isLoggedInUser()Z"))};
    public static final Companion f36735f = new Companion();
    final Account f36736b;
    final List<Link> f36737c = ((List) new ArrayList());
    String f36738d;
    final View f36739e;
    private final Lazy f36740g = LazyKt.m26777a((Function0) new UserSubmittedListingPresenter$isLoggedInUser$2(this));
    private final List<Listable> f36741h = ((List) new ArrayList());
    private final List<Karma> f36742i = ((List) new ArrayList());
    private boolean f36743j;
    private final ListingNavigator f36744k;
    private final KarmaRepository f36745l;
    private final AccountRepository f36746m;
    private final PostExecutionThread f36747n;
    private final ModeratorLinkActions f36748o;
    private final UserLinkActions f36749p;
    private final LinksLoadData f36750q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/submitted/UserSubmittedListingPresenter$Companion;", "", "()V", "MAX_KARMA_LIST_LENGTH", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserSubmittedListingPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final void mo6483a(int i) {
    }

    public final void mo6488f(int i) {
    }

    @Inject
    public UserSubmittedListingPresenter(View view, ListingNavigator listingNavigator, KarmaRepository karmaRepository, AccountRepository accountRepository, PostExecutionThread postExecutionThread, ModeratorLinkActions moderatorLinkActions, UserLinkActions userLinkActions, LinksLoadData linksLoadData) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(listingNavigator, "navigator");
        Intrinsics.m26847b(karmaRepository, "karmaRepository");
        Intrinsics.m26847b(accountRepository, "userAccountRepository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        Intrinsics.m26847b(moderatorLinkActions, "moderatorActions");
        Intrinsics.m26847b(userLinkActions, "linkActions");
        Intrinsics.m26847b(linksLoadData, "linksLoadData");
        this.f36739e = view;
        this.f36744k = listingNavigator;
        this.f36745l = karmaRepository;
        this.f36746m = accountRepository;
        this.f36747n = postExecutionThread;
        this.f36748o = moderatorLinkActions;
        this.f36749p = userLinkActions;
        this.f36750q = linksLoadData;
    }

    public final void mo6484b(int i) {
        StringBuilder stringBuilder = new StringBuilder("An operation is not implemented: ");
        stringBuilder.append("not implemented");
        throw new NotImplementedError(stringBuilder.toString());
    }

    public final void mo6485c(int i) {
        UserLinkActions userLinkActions = this.f36749p;
        i = this.f36741h.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4882a((LinkPresentationModel) i);
    }

    public final void mo6486d(int i) {
        UserLinkActions userLinkActions = this.f36749p;
        i = this.f36741h.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4885b((LinkPresentationModel) i, this.f36737c, MapsKt__MapsKt.m36116a());
    }

    public final void mo6487e(int i) {
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        LinkPresentationModel linkPresentationModel = (LinkPresentationModel) obj;
        UserLinkActions userLinkActions = this.f36749p;
        List list = this.f36737c;
        LinkPresentationPositionUtil linkPresentationPositionUtil = LinkPresentationPositionUtil.f20573a;
        userLinkActions.mo4881a((Link) list.get(LinkPresentationPositionUtil.m22873a(i, this.f36737c, linkPresentationModel)), linkPresentationModel);
    }

    public final void mo6489g(int i) {
        UserLinkActions userLinkActions = this.f36749p;
        i = this.f36741h.get(i);
        if (i == 0) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        userLinkActions.mo4887c((LinkPresentationModel) i, this.f36737c, MapsKt__MapsKt.m36116a());
    }

    public final void mo6943h(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4871a(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6944i(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4872b(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6946k(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4874d(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6950o(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4878h(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6945j(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4873c(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6947l(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4875e(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6948m(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4876f(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void mo6949n(int i) {
        ModeratorLinkActions moderatorLinkActions = this.f36748o;
        Object obj = this.f36741h.get(i);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.model.LinkPresentationModel");
        }
        moderatorLinkActions.mo4877g(i, (LinkPresentationModel) obj, this.f36737c, MapsKt__MapsKt.m36116a(), this.f36741h, this.f36739e);
    }

    public final void attach() {
        this.f36739e.mo7369b();
        m37195b();
    }

    public final void m37193a() {
        if (this.f36738d != null && !this.f36743j) {
            this.f36743j = true;
            Object subscribe = SinglesKt.m24094b(this.f36750q.m22528b(new LinksLoadDataParams(this.f36739e.mo7368a(), this.f36738d)), this.f36747n).subscribe(new UserSubmittedListingPresenter$loadMore$1(this), new UserSubmittedListingPresenter$loadMore$2(this));
            Intrinsics.m26843a(subscribe, "linksLoadData\n          …          }\n            )");
            handleDispose(subscribe);
        }
    }

    final void m37195b() {
        this.f36743j = true;
        if (((Boolean) this.f36740g.mo5678b()).booleanValue()) {
            Object subscribe = SinglesKt.m24094b(this.f36750q.m22528b(new LinksLoadDataParams(this.f36739e.mo7368a(), this.f36738d)), this.f36747n).subscribe(new UserSubmittedListingPresenter$loadSelfListing$1(this), new UserSubmittedListingPresenter$loadSelfListing$2(this));
            Intrinsics.m26843a(subscribe, "linksLoadData\n          …          }\n            )");
            handleDispose(subscribe);
            return;
        }
        subscribe = this.f36746m.m22394a(this.f36739e.mo7368a()).flatMap(new UserSubmittedListingPresenter$loadOtherUserListing$1(this.f36745l.m22406a(this.f36739e.mo7368a()), this.f36750q.m22528b(new LinksLoadDataParams(this.f36739e.mo7368a(), this.f36738d))));
        Intrinsics.m26843a(subscribe, "userAccount\n            …          }\n            }");
        subscribe = SinglesKt.m24094b(subscribe, this.f36747n).subscribe(new UserSubmittedListingPresenter$loadOtherUserListing$2(this), new UserSubmittedListingPresenter$loadOtherUserListing$3(this));
        Intrinsics.m26843a(subscribe, "userAccount\n            …              }\n        )");
        handleDispose(subscribe);
    }

    public static void m37190c() {
        Timber.b("TODO: implement sendScrollEvent", new Object[0]);
    }
}
