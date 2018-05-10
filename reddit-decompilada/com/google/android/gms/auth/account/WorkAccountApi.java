package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface WorkAccountApi {
    PendingResult<Object> addWorkAccount(GoogleApiClient googleApiClient, String str);

    PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, Account account);

    void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, boolean z);

    PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient googleApiClient, boolean z);
}
