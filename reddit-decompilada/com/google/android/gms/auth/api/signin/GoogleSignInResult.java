package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    public Status f13805a;
    public GoogleSignInAccount f13806b;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f13806b = googleSignInAccount;
        this.f13805a = status;
    }

    public final Status k_() {
        return this.f13805a;
    }
}
