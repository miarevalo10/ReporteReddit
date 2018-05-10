package com.reddit.frontpage.presentation.accounts;

import android.accounts.Account;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfoUseCaseParams;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar.AnonymousAvatar;
import com.reddit.frontpage.presentation.accounts.AccountPickerContract.View;
import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0014\u0010\u0017\u001a\u00020\u0013*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountPickerPresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/accounts/AccountPickerContract$Presenter;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "accountHelper", "Lcom/reddit/frontpage/presentation/accounts/AccountHelper;", "accountInfoUseCase", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;", "view", "Lcom/reddit/frontpage/presentation/accounts/AccountPickerContract$View;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/frontpage/presentation/accounts/AccountHelper;Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;Lcom/reddit/frontpage/presentation/accounts/AccountPickerContract$View;)V", "getAccountsDisposable", "Lio/reactivex/disposables/Disposable;", "attach", "", "detach", "removeAccount", "account", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "selectAccount", "showLoadingAccounts", "updateAccounts", "toPresentationModel", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfo;", "isActive", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPickerPresenter.kt */
public final class AccountPickerPresenter implements BasePresenter {
    final AccountHelper f28044a;
    final View f28045b;
    private Disposable f28046c;
    private final BackgroundThread f28047d;
    private final AccountInfoUseCase f28048e;

    public final void destroy() {
    }

    @Inject
    public AccountPickerPresenter(BackgroundThread backgroundThread, AccountHelper accountHelper, AccountInfoUseCase accountInfoUseCase, View view) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(accountHelper, "accountHelper");
        Intrinsics.m26847b(accountInfoUseCase, "accountInfoUseCase");
        Intrinsics.m26847b(view, "view");
        this.f28047d = backgroundThread;
        this.f28044a = accountHelper;
        this.f28048e = accountInfoUseCase;
        this.f28045b = view;
    }

    public final void attach() {
        m29369a();
    }

    private final void m29369a() {
        Object b;
        Collection arrayList;
        if (this.f28045b.mo7318c().isEmpty()) {
            b = this.f28044a.mo4770b();
            Iterable<Object> a = this.f28044a.mo4767a();
            arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
            for (Object obj : a) {
                Object obj2 = obj.name;
                Intrinsics.m26843a(obj2, "account.name");
                arrayList.add(new AccountPresentationModel(obj2, AnonymousAvatar.f27958a, Intrinsics.m26845a(obj, b)));
            }
            this.f28045b.mo7317a((List) arrayList);
            this.f28045b.mo7319d();
        }
        Disposable disposable = this.f28046c;
        if (disposable != null) {
            disposable.mo5626a();
        }
        Account b2 = this.f28044a.mo4770b();
        Iterable<Account> a2 = this.f28044a.mo4767a();
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a2));
        for (Account account : a2) {
            AccountInfoUseCase accountInfoUseCase = this.f28048e;
            Object obj3 = account.name;
            Intrinsics.m26843a(obj3, "it.name");
            arrayList.add(TuplesKt.m26780a(account, accountInfoUseCase.m22528b(new AccountInfoUseCaseParams(obj3))));
        }
        Iterable<Pair> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Pair pair : iterable) {
            arrayList2.add(((Single) pair.f25268b).map(new AccountPickerPresenter$updateAccounts$$inlined$map$lambda$1((Account) pair.f25267a, this, b2)));
        }
        b = Single.zip((List) arrayList2, AccountPickerPresenter$updateAccounts$3$1.f28043a);
        Intrinsics.m26843a(b, "accountHelper.accounts\n …ntPresentationModel } } }");
        this.f28046c = SubscribersKt.m26769a(SinglesKt.m24093a(b, this.f28047d), (Function1) AccountPickerPresenter$updateAccounts$4.f36346a, (Function1) new AccountPickerPresenter$updateAccounts$5(this));
    }

    public final void detach() {
        Disposable disposable = this.f28046c;
        if (disposable != null) {
            disposable.mo5626a();
        }
    }
}
