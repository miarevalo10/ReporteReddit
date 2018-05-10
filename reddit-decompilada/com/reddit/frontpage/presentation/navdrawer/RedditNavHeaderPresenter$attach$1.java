package com.reddit.frontpage.presentation.navdrawer;

import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.AnonymousAvatar;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditNavHeaderPresenter.kt */
final class RedditNavHeaderPresenter$attach$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ RedditNavHeaderPresenter f36996a;

    RedditNavHeaderPresenter$attach$1(RedditNavHeaderPresenter redditNavHeaderPresenter) {
        this.f36996a = redditNavHeaderPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Throwable) obj, "it");
        obj = new UserAccountPresentationModel(this.f36996a.f34089b.mo4819b(), this.f36996a.f34089b.mo4817a(), this.f36996a.f34089b.mo4821c(), CollectionsKt__CollectionsKt.m26790a());
        this.f36996a.f34088a.setAvatar(AnonymousAvatar.f27958a);
        this.f36996a.f34088a.setAccount(obj);
        return Unit.f25273a;
    }
}
