package com.reddit.frontpage.presentation.communities;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "kindWithId", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$onCarouselItemDismissed$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ CommunitiesPresenter f36412a;

    CommunitiesPresenter$onCarouselItemDismissed$3(CommunitiesPresenter communitiesPresenter) {
        this.f36412a = communitiesPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "kindWithId");
        CommunitiesPresenter communitiesPresenter = this.f36412a;
        Disposable subscribe = this.f36412a.f33820o.m22491a(this.f36412a.m34631d(), str).subscribe();
        Intrinsics.m26843a((Object) subscribe, "repository.deleteRecentS…, kindWithId).subscribe()");
        communitiesPresenter.handleDispose(subscribe);
        return Unit.f25273a;
    }
}
