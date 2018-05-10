package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView;
import com.reddit.frontpage.presentation.listing.ui.viewholder.VideoPlayable;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0002J3\u0010\f\u001a\u00020\u0004\"\f\b\u0000\u0010\r*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0011J3\u0010\u0012\u001a\u00020\u0004\"\f\b\u0000\u0010\r*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u0013\u001a\u00020\u0004\"\f\b\u0000\u0010\r*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\rH\u0016¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u00020\u0004\"\f\b\u0000\u0010\r*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\rH\u0016¢\u0006\u0002\u0010\u0014J+\u0010\u0016\u001a\u00020\u0004\"\f\b\u0000\u0010\r*\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditListingScreenActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingScreenActions;", "()V", "changeVideoPlayerState", "", "adapter", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "listView", "Landroid/support/v7/widget/RecyclerView;", "action", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoPlayable;", "onActivityPaused", "T", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "view", "(Lcom/reddit/frontpage/ui/BaseScreen;Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onActivityResumed", "onActivityStopped", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "onAttach", "onDetach", "visibilityDependentDelegate", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "(Lcom/reddit/frontpage/ui/BaseScreen;Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingScreenActions.kt */
public final class RedditListingScreenActions implements ListingScreenActions {
    public final <T extends BaseScreen & VisibilityDependent> void mo4854a(T t) {
        Intrinsics.m26847b(t, "view");
        ((VisibilityDependent) t).ap();
    }

    public final <T extends BaseScreen & VisibilityDependent> void mo4856a(T t, VisibilityDependentDelegate visibilityDependentDelegate) {
        Intrinsics.m26847b(t, "view");
        Intrinsics.m26847b(visibilityDependentDelegate, "visibilityDependentDelegate");
        ((VisibilityDependent) t).aq();
        visibilityDependentDelegate.m23493a(null);
    }

    public final <T extends BaseScreen & VisibilityDependent> void mo4855a(T t, CardLinkAdapter cardLinkAdapter, RecyclerView recyclerView) {
        Intrinsics.m26847b(t, "view");
        Intrinsics.m26847b(cardLinkAdapter, "adapter");
        Intrinsics.m26847b(recyclerView, "listView");
        if (t.T_() != null) {
            m29592a(cardLinkAdapter, recyclerView, (Function1) RedditListingScreenActions$onActivityPaused$1$1.f36569a);
        }
    }

    public final <T extends BaseScreen & VisibilityDependent> void mo4858b(T t, CardLinkAdapter cardLinkAdapter, RecyclerView recyclerView) {
        Intrinsics.m26847b(t, "view");
        Intrinsics.m26847b(cardLinkAdapter, "adapter");
        Intrinsics.m26847b(recyclerView, "listView");
        if (t.T_() != null) {
            t = cardLinkAdapter.m30232l();
            if (t >= null) {
                cardLinkAdapter.d(t);
            }
            m29592a(cardLinkAdapter, recyclerView, (Function1) RedditListingScreenActions$onActivityResumed$1$1.f36570a);
        }
    }

    private static void m29592a(CardLinkAdapter cardLinkAdapter, RecyclerView recyclerView, Function1<? super VideoPlayable, Unit> function1) {
        cardLinkAdapter = cardLinkAdapter.m30230k();
        if (cardLinkAdapter >= null) {
            cardLinkAdapter = recyclerView.findViewHolderForAdapterPosition(cardLinkAdapter);
            if ((cardLinkAdapter instanceof VideoPlayable) != null) {
                function1.mo6492a(cardLinkAdapter);
            }
        }
    }

    public final <T extends BaseScreen & VisibilityDependent> void mo4857b(T t) {
        Intrinsics.m26847b(t, "view");
        if (t.v_()) {
            ((VisibilityDependent) t).aq();
        }
    }
}
