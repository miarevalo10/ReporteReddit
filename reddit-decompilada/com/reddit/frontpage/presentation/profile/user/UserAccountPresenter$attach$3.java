package com.reddit.frontpage.presentation.profile.user;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.domain.model.Trophy;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserAccountPresenter.kt */
final class UserAccountPresenter$attach$3 extends Lambda implements Function1<Pair<? extends Account, ? extends List<? extends Trophy>>, Unit> {
    final /* synthetic */ UserAccountPresenter f37044a;

    UserAccountPresenter$attach$3(UserAccountPresenter userAccountPresenter) {
        this.f37044a = userAccountPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Pair pair = (Pair) obj;
        Account account = (Account) pair.f25267a;
        this.f37044a.f34145a.mo7420a(new UserAccountPresentationModel(this.f37044a.f34146b.mo4820b(account), this.f37044a.f34146b.mo4818a(account), this.f37044a.f34146b.mo4822c(account), (List) pair.f25268b));
        return Unit.f25273a;
    }
}
