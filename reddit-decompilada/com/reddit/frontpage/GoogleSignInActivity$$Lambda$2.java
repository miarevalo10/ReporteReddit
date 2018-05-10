package com.reddit.frontpage;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

final /* synthetic */ class GoogleSignInActivity$$Lambda$2 implements ResultCallback {
    private final GoogleSignInActivity f27418a;

    GoogleSignInActivity$$Lambda$2(GoogleSignInActivity googleSignInActivity) {
        this.f27418a = googleSignInActivity;
    }

    public final void m28884a(Result result) {
        GoogleSignInActivity googleSignInActivity = this.f27418a;
        GoogleSignInResult googleSignInResult = (GoogleSignInResult) result;
        if (googleSignInActivity.f40545b != null && googleSignInActivity.f40545b.isShowing()) {
            googleSignInActivity.f40545b.hide();
        }
        googleSignInActivity.m41952a(googleSignInResult);
    }
}
