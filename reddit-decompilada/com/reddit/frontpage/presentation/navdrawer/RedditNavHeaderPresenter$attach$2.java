package com.reddit.frontpage.presentation.navdrawer;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfo;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfo;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditNavHeaderPresenter.kt */
final class RedditNavHeaderPresenter$attach$2 extends Lambda implements Function1<AccountInfo, Unit> {
    final /* synthetic */ RedditNavHeaderPresenter f36997a;

    RedditNavHeaderPresenter$attach$2(RedditNavHeaderPresenter redditNavHeaderPresenter) {
        this.f36997a = redditNavHeaderPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        AccountInfo accountInfo = (AccountInfo) obj;
        Intrinsics.m26847b(accountInfo, "<name for destructuring parameter 0>");
        Account account = accountInfo.f20264a;
        obj = accountInfo.f20265b;
        UserAccountPresentationModel userAccountPresentationModel = new UserAccountPresentationModel(this.f36997a.f34089b.mo4820b(account), this.f36997a.f34089b.mo4818a(account), this.f36997a.f34089b.mo4822c(account), CollectionsKt__CollectionsKt.m26790a());
        this.f36997a.f34088a.setAvatar(obj);
        this.f36997a.f34088a.setAccount(userAccountPresentationModel);
        return Unit.f25273a;
    }
}
