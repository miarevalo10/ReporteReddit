package com.reddit.frontpage.ui.profile.profilesettings.presentation;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.ui.profile.profilesettings.model.AccountMapper;
import com.reddit.frontpage.ui.profile.profilesettings.model.AccountPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;", "p1", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "Lkotlin/ParameterName;", "name", "account", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsPresenter.kt */
final class ProfileSettingsPresenter$attach$1 extends FunctionReference implements Function1<Account, AccountPresentationModel> {
    ProfileSettingsPresenter$attach$1(AccountMapper accountMapper) {
        super(1, accountMapper);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(AccountMapper.class);
    }

    public final String mo5687b() {
        return "toPresentationModel";
    }

    public final String mo6932c() {
        return "toPresentationModel(Lcom/reddit/datalibrary/frontpage/data/model/Account;)Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Account account = (Account) obj;
        Intrinsics.m26847b(account, "p1");
        return AccountMapper.m23602a(account);
    }
}
