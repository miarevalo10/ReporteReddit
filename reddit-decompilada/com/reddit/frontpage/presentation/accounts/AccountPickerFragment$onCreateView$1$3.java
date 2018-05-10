package com.reddit.frontpage.presentation.accounts;

import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "Lkotlin/ParameterName;", "name", "account", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountPickerFragment.kt */
final class AccountPickerFragment$onCreateView$1$3 extends FunctionReference implements Function1<AccountPresentationModel, Unit> {
    AccountPickerFragment$onCreateView$1$3(AccountPickerPresenter accountPickerPresenter) {
        super(1, accountPickerPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(AccountPickerPresenter.class);
    }

    public final String mo5687b() {
        return "selectAccount";
    }

    public final String mo6932c() {
        return "selectAccount(Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        AccountPresentationModel accountPresentationModel = (AccountPresentationModel) obj;
        AccountPickerPresenter accountPickerPresenter = (AccountPickerPresenter) this.b;
        AccountHelper accountHelper = accountPickerPresenter.f28044a;
        if (accountPresentationModel != null) {
            obj = accountPresentationModel.f20320a;
        } else {
            obj = null;
        }
        if (accountHelper.mo4768a(obj) == null) {
            accountPickerPresenter.f28045b.m22639b();
        }
        return Unit.f25273a;
    }
}
