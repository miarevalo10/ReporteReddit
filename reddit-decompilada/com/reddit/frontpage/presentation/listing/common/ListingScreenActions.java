package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.widget.RecyclerView;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ3\u0010\r\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ#\u0010\u000e\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\u000fJ#\u0010\u0010\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\u000fJ+\u0010\u0011\u001a\u00020\u0003\"\f\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/ListingScreenActions;", "", "onActivityPaused", "", "T", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "view", "adapter", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "listView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/reddit/frontpage/ui/BaseScreen;Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onActivityResumed", "onActivityStopped", "(Lcom/reddit/frontpage/ui/BaseScreen;)V", "onAttach", "onDetach", "visibilityDependentDelegate", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;", "(Lcom/reddit/frontpage/ui/BaseScreen;Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependentDelegate;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingScreenActions.kt */
public interface ListingScreenActions {
    <T extends BaseScreen & VisibilityDependent> void mo4854a(T t);

    <T extends BaseScreen & VisibilityDependent> void mo4855a(T t, CardLinkAdapter cardLinkAdapter, RecyclerView recyclerView);

    <T extends BaseScreen & VisibilityDependent> void mo4856a(T t, VisibilityDependentDelegate visibilityDependentDelegate);

    <T extends BaseScreen & VisibilityDependent> void mo4857b(T t);

    <T extends BaseScreen & VisibilityDependent> void mo4858b(T t, CardLinkAdapter cardLinkAdapter, RecyclerView recyclerView);
}
