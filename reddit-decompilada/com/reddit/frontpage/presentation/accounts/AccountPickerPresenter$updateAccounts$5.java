package com.reddit.frontpage.presentation.accounts;

import com.reddit.frontpage.presentation.accounts.AccountPickerContract.View;
import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "fetchedAccounts", "", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountPickerPresenter.kt */
final class AccountPickerPresenter$updateAccounts$5 extends Lambda implements Function1<List<? extends AccountPresentationModel>, Unit> {
    final /* synthetic */ AccountPickerPresenter f36347a;

    AccountPickerPresenter$updateAccounts$5(AccountPickerPresenter accountPickerPresenter) {
        this.f36347a = accountPickerPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = (List) obj;
        View b = this.f36347a.f28045b;
        Intrinsics.m26843a(obj, "fetchedAccounts");
        b.mo7317a(obj);
        this.f36347a.f28045b.mo7319d();
        return Unit.f25273a;
    }
}
