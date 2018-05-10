package com.reddit.frontpage.redditauth_private.ui;

import android.widget.Button;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class LoginFragment$$Lambda$1 implements Consumer {
    private final LoginFragment f28842a;

    LoginFragment$$Lambda$1(LoginFragment loginFragment) {
        this.f28842a = loginFragment;
    }

    public final void accept(Object obj) {
        LoginFragment loginFragment = this.f28842a;
        boolean z = false;
        obj = ((TextViewAfterTextChangeEvent) obj).b().length() == null ? 1 : null;
        boolean z2 = loginFragment.password.getText().length() == 0;
        Button button = loginFragment.loginButton;
        if (obj == null && !z2) {
            z = true;
        }
        button.setEnabled(z);
    }
}
