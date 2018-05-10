package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J1\u0010\u0007\u001a\u00020\u0004\"\u0012\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ1\u0010\u0010\u001a\u00020\u0004\"\u0012\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0013J9\u0010\u0014\u001a\u00020\u0004\"\u0012\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0017J9\u0010\u0018\u001a\u00020\u0004\"\u0012\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0017J)\u0010\u0019\u001a\u00020\u0004\"\u0012\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016JA\u0010\u001e\u001a\u00020\u0004\"\b\b\u0000\u0010\u001f*\u00020\n\"\u0012\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u001f0\t*\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0016J'\u0010,\u001a\u0004\u0018\u00010\u0006*\u00020\u00062\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040.¢\u0006\u0002\b/H\u0002¨\u00060"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditListingViewActions;", "Lcom/reddit/frontpage/presentation/listing/common/ListingViewActions;", "()V", "hideRefreshing", "", "screen", "Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;", "notifyDiffResult", "R", "Lcom/reddit/frontpage/presentation/listing/common/ListingAdapter;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "adapter", "diffResult", "Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "(Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;)V", "notifyLinkChanged", "position", "", "(ILcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "notifyLinksInserted", "startPosition", "numItems", "(IILcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "notifyLinksRemoved", "notifyListingChanged", "(Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "notifyLoadError", "errorMessage", "", "setListing", "T", "posts", "", "(Ljava/util/List;Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;)V", "showContentListView", "showEmptyListView", "layout", "(Lcom/reddit/frontpage/presentation/listing/common/LinkListingScreen;Ljava/lang/Integer;)V", "showLoading", "showRefreshing", "showSuspendedReportView", "context", "Landroid/content/Context;", "applyIfViewCreated", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingViewActions.kt */
public final class RedditListingViewActions implements ListingViewActions {
    public final <T extends Listable, R extends CardLinkAdapter & ListingAdapter<T>> void mo4866a(List<? extends T> list, R r) {
        Intrinsics.m26847b(list, "posts");
        Intrinsics.m26847b(r, "adapter");
        ((ListingAdapter) r).mo6470a(CollectionsKt___CollectionsKt.m41428c(list));
    }

    public final <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4864a(R r) {
        Intrinsics.m26847b(r, "adapter");
        r.e();
    }

    public final <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4860a(int i, R r) {
        Intrinsics.m26847b(r, "adapter");
        r.d(((ListingAdapter) r).mo6472h(i));
    }

    public final <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4859a(int i, int i2, R r) {
        Intrinsics.m26847b(r, "adapter");
        r.c(((ListingAdapter) r).mo6472h(i), i2);
    }

    public final <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4867b(int i, R r) {
        Intrinsics.m26847b(r, "adapter");
        r.d(((ListingAdapter) r).mo6472h(i), 1);
    }

    public final <R extends CardLinkAdapter & ListingAdapter<Listable>> void mo4865a(R r, ViewDiffResult viewDiffResult) {
        Intrinsics.m26847b(r, "adapter");
        Intrinsics.m26847b(viewDiffResult, "diffResult");
        viewDiffResult.f20594a.a(new RedditListingViewActions$notifyDiffResult$1(r, new RedditListingViewActions$notifyDiffResult$getPosition$1(r)));
    }

    public final void mo4863a(LinkListingScreen linkListingScreen, String str) {
        Intrinsics.m26847b(linkListingScreen, "screen");
        Intrinsics.m26847b(str, "errorMessage");
        m29602a(linkListingScreen, (Function1) new RedditListingViewActions$notifyLoadError$1(str));
    }

    public final void mo4861a(LinkListingScreen linkListingScreen) {
        Intrinsics.m26847b(linkListingScreen, "screen");
        m29602a(linkListingScreen, (Function1) RedditListingViewActions$showContentListView$1.f36574a);
    }

    public final void mo4862a(LinkListingScreen linkListingScreen, Integer num) {
        Intrinsics.m26847b(linkListingScreen, "screen");
        m29602a(linkListingScreen, (Function1) new RedditListingViewActions$showEmptyListView$1(num));
    }

    public final void mo4868b(LinkListingScreen linkListingScreen) {
        Intrinsics.m26847b(linkListingScreen, "screen");
        m29602a(linkListingScreen, (Function1) RedditListingViewActions$showLoading$1.f36576a);
    }

    public final void mo4869c(LinkListingScreen linkListingScreen) {
        Intrinsics.m26847b(linkListingScreen, "screen");
        m29602a(linkListingScreen, (Function1) RedditListingViewActions$showRefreshing$1.f36577a);
    }

    public final void mo4870d(LinkListingScreen linkListingScreen) {
        Intrinsics.m26847b(linkListingScreen, "screen");
        m29602a(linkListingScreen, (Function1) RedditListingViewActions$hideRefreshing$1.f36571a);
    }

    private static LinkListingScreen m29602a(LinkListingScreen linkListingScreen, Function1<? super LinkListingScreen, Unit> function1) {
        if ((linkListingScreen.az() ^ 1) == 0) {
            linkListingScreen = null;
        }
        if (linkListingScreen == null) {
            return null;
        }
        function1.mo6492a(linkListingScreen);
        return linkListingScreen;
    }
}
