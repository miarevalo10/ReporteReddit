package com.reddit.frontpage.presentation.accounts;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerAccountPickerComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.presentation.accounts.AccountPickerContract.View;
import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import com.reddit.frontpage.presentation.common.ui.view.RedditBottomSheetDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0016H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006,"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountPickerFragment;", "Landroid/support/design/widget/BottomSheetDialogFragment;", "Lcom/reddit/frontpage/presentation/accounts/AccountPickerContract$View;", "()V", "accounts", "", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "getAccounts", "()Ljava/util/List;", "setAccounts", "(Ljava/util/List;)V", "accountsAdapter", "Lcom/reddit/frontpage/presentation/accounts/AccountsAdapter;", "accountsView", "Landroid/support/v7/widget/RecyclerView;", "presenter", "Lcom/reddit/frontpage/presentation/accounts/AccountPickerPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/accounts/AccountPickerPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/accounts/AccountPickerPresenter;)V", "notifyAccountsChanged", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "promptRemoveAccount", "account", "startLogin", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPickerFragment.kt */
public final class AccountPickerFragment extends BottomSheetDialogFragment implements View {
    @Inject
    public AccountPickerPresenter f39998j;
    List<AccountPresentationModel> f39999k = new ArrayList();
    private AccountsAdapter f40000l;
    private RecyclerView f40001m;
    private HashMap f40002n;

    public static final /* synthetic */ AccountsAdapter m40542a(AccountPickerFragment accountPickerFragment) {
        accountPickerFragment = accountPickerFragment.f40000l;
        if (accountPickerFragment == null) {
            Intrinsics.m26844a("accountsAdapter");
        }
        return accountPickerFragment;
    }

    public final void mo7317a(List<AccountPresentationModel> list) {
        Intrinsics.m26847b(list, "<set-?>");
        this.f39999k = list;
    }

    public final List<AccountPresentationModel> mo7318c() {
        return this.f39999k;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = DaggerAccountPickerComponent.m28990a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        bundle = bundle.mo4575a(k).mo4576a((View) this);
        Context context = getContext();
        if (context == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a((Object) context, "context!!");
        bundle.mo4574a(context).mo4577a().mo4579a(this);
    }

    public final android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Object inflate = layoutInflater.inflate(C1761R.layout.account_picker, viewGroup, false);
        AccountPickerFragment accountPickerFragment = this;
        Function0 function0 = (Function0) new AccountPickerFragment$onCreateView$1$1(accountPickerFragment);
        Function0 function02 = (Function0) AccountPickerFragment$onCreateView$1$2.f36344a;
        AccountPickerPresenter accountPickerPresenter = this.f39998j;
        if (accountPickerPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        this.f40000l = new AccountsAdapter(function0, function02, (Function1) new AccountPickerFragment$onCreateView$1$3(accountPickerPresenter), (Function0) new AccountPickerFragment$onCreateView$1$4(accountPickerFragment), (Function1) new AccountPickerFragment$onCreateView$1$5(accountPickerFragment), (Function0) AccountPickerFragment$onCreateView$1$6.f36345a);
        Object findViewById = inflate.findViewById(C1761R.id.account_picker_accounts);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        AccountsAdapter accountsAdapter = this.f40000l;
        if (accountsAdapter == null) {
            Intrinsics.m26844a("accountsAdapter");
        }
        recyclerView.setAdapter(accountsAdapter);
        Intrinsics.m26843a(findViewById, "findViewById<RecyclerVie…= accountsAdapter\n      }");
        this.f40001m = recyclerView;
        viewGroup = this.f39998j;
        if (viewGroup == null) {
            Intrinsics.m26844a("presenter");
        }
        viewGroup.attach();
        Intrinsics.m26843a(inflate, "inflater.inflate(R.layou… presenter.attach()\n    }");
        return inflate;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        AccountPickerPresenter accountPickerPresenter = this.f39998j;
        if (accountPickerPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        accountPickerPresenter.detach();
        if (this.f40002n != null) {
            this.f40002n.clear();
        }
    }

    public final void mo7319d() {
        if (getActivity() != null && isVisible()) {
            getActivity().runOnUiThread(new C1803xd0cd068f(this));
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SessionManager.b().a(i, i2, intent);
    }

    public final /* synthetic */ Dialog m40544a() {
        Object context = getContext();
        if (context == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(context, "context!!");
        RedditBottomSheetDialog redditBottomSheetDialog = new RedditBottomSheetDialog(context);
        redditBottomSheetDialog.m36781a(getString(C1761R.string.label_accounts));
        return redditBottomSheetDialog;
    }

    public static final /* synthetic */ void m40543a(AccountPickerFragment accountPickerFragment, AccountPresentationModel accountPresentationModel) {
        Object context = accountPickerFragment.getContext();
        if (context == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(context, "context!!");
        accountPickerFragment = accountPickerFragment.f39998j;
        if (accountPickerFragment == null) {
            Intrinsics.m26844a("presenter");
        }
        new ConfirmLogoutDialog(context, accountPresentationModel, new AccountPickerFragment$promptRemoveAccount$1(accountPickerFragment)).show();
    }
}
