package com.reddit.frontpage.presentation.accounts;

import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountPickerContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPickerContract.kt */
public interface AccountPickerContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountPickerContract$View;", "", "accounts", "", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "getAccounts", "()Ljava/util/List;", "setAccounts", "(Ljava/util/List;)V", "dismiss", "", "notifyAccountsChanged", "startLogin", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AccountPickerContract.kt */
    public interface View {
        void mo7317a(List<AccountPresentationModel> list);

        void m22639b();

        List<AccountPresentationModel> mo7318c();

        void mo7319d();
    }
}
